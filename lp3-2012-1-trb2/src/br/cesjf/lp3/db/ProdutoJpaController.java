package br.cesjf.lp3.db;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import br.cesjf.lp3.Filial;
import br.cesjf.lp3.Produto;
import br.cesjf.lp3.db.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.*;
import javax.transaction.UserTransaction;

public class ProdutoJpaController implements Serializable {
    
    public ProdutoJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;
    
    public ProdutoJpaController() {
        emf = Persistence.createEntityManagerFactory("lp3-2012-1-trb2-pu");
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public void create(Produto produto) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Filial filial = produto.getFilial();
            if (filial != null) {
                filial = em.getReference(filial.getClass(), filial.getId());
                produto.setFilial(filial);
            }
            em.persist(produto);
            if (filial != null) {
                filial.getProduto().add(produto);
                filial = em.merge(filial);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public void edit(Produto produto) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Produto persistentProduto = em.find(Produto.class, produto.getId());
            Filial filialOld = persistentProduto.getFilial();
            Filial filialNew = produto.getFilial();
            if (filialNew != null) {
                filialNew = em.getReference(filialNew.getClass(), filialNew.getId());
                produto.setFilial(filialNew);
            }
            produto = em.merge(produto);
            if (filialOld != null && !filialOld.equals(filialNew)) {
                filialOld.getProduto().remove(produto);
                filialOld = em.merge(filialOld);
            }
            if (filialNew != null && !filialNew.equals(filialOld)) {
                filialNew.getProduto().add(produto);
                filialNew = em.merge(filialNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = produto.getId();
                if (buscaPorID(id) == null) {
                    throw new NonexistentEntityException("The produto with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public void excluir(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Produto produto;
            try {
                produto = em.getReference(Produto.class, id);
                produto.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The produto with id " + id + " no longer exists.", enfe);
            }
            Filial filial = produto.getFilial();
            if (filial != null) {
                filial.getProduto().remove(produto);
                filial = em.merge(filial);
            }
            em.remove(produto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public List<Produto> findProdutoEntities() {
        return findProdutoEntities(true, -1, -1);
    }
    
    public List<Produto> findProdutoEntities(int maxResults, int firstResult) {
        return findProdutoEntities(false, maxResults, firstResult);
    }
    
    private List<Produto> findProdutoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from Produto as o");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }
    
    public List<Produto> listarPorFilial(Long filial) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from Produto as o WHERE o.filial.id = " + filial);            
            return q.getResultList();
            
        } finally {
            em.close();
        }
    }
    
    public Produto buscaPorID(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Produto.class, id);
        } finally {
            em.close();
        }
    }
    
    public int getProdutoCount() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select count(o) from Produto as o");
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}
