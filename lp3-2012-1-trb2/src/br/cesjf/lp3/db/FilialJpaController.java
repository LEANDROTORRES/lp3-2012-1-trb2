/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf.lp3.db;

import br.cesjf.lp3.Filial;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import br.cesjf.lp3.Produto;
import br.cesjf.lp3.db.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.*;
import javax.transaction.UserTransaction;

/**
 *
 * @author Leandro
 */
public class FilialJpaController implements Serializable {

    public FilialJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;
    
    public FilialJpaController() {
        emf = Persistence.createEntityManagerFactory("lp3-2012-1-trb2-pu");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Filial filial) {
        if (filial.getProduto() == null) {
            filial.setProduto(new ArrayList<Produto>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Produto> attachedProduto = new ArrayList<Produto>();
            for (Produto produtoProdutoToAttach : filial.getProduto()) {
                produtoProdutoToAttach = em.getReference(produtoProdutoToAttach.getClass(), produtoProdutoToAttach.getId());
                attachedProduto.add(produtoProdutoToAttach);
            }
            filial.setProduto(attachedProduto);
            em.persist(filial);
            for (Produto produtoProduto : filial.getProduto()) {
                Filial oldFilialOfProdutoProduto = produtoProduto.getFilial();
                produtoProduto.setFilial(filial);
                produtoProduto = em.merge(produtoProduto);
                if (oldFilialOfProdutoProduto != null) {
                    oldFilialOfProdutoProduto.getProduto().remove(produtoProduto);
                    oldFilialOfProdutoProduto = em.merge(oldFilialOfProdutoProduto);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Filial filial) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Filial persistentFilial = em.find(Filial.class, filial.getId());
            Collection<Produto> produtoOld = persistentFilial.getProduto();
            Collection<Produto> produtoNew = filial.getProduto();
            Collection<Produto> attachedProdutoNew = new ArrayList<Produto>();
            for (Produto produtoNewProdutoToAttach : produtoNew) {
                produtoNewProdutoToAttach = em.getReference(produtoNewProdutoToAttach.getClass(), produtoNewProdutoToAttach.getId());
                attachedProdutoNew.add(produtoNewProdutoToAttach);
            }
            produtoNew = attachedProdutoNew;
            filial.setProduto(produtoNew);
            filial = em.merge(filial);
            for (Produto produtoOldProduto : produtoOld) {
                if (!produtoNew.contains(produtoOldProduto)) {
                    produtoOldProduto.setFilial(null);
                    produtoOldProduto = em.merge(produtoOldProduto);
                }
            }
            for (Produto produtoNewProduto : produtoNew) {
                if (!produtoOld.contains(produtoNewProduto)) {
                    Filial oldFilialOfProdutoNewProduto = produtoNewProduto.getFilial();
                    produtoNewProduto.setFilial(filial);
                    produtoNewProduto = em.merge(produtoNewProduto);
                    if (oldFilialOfProdutoNewProduto != null && !oldFilialOfProdutoNewProduto.equals(filial)) {
                        oldFilialOfProdutoNewProduto.getProduto().remove(produtoNewProduto);
                        oldFilialOfProdutoNewProduto = em.merge(oldFilialOfProdutoNewProduto);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = filial.getId();
                if (buscaPorId(id) == null) {
                    throw new NonexistentEntityException("The filial with id " + id + " no longer exists.");
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
            Filial filial;
            try {
                filial = em.getReference(Filial.class, id);
                filial.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The filial with id " + id + " no longer exists.", enfe);
            }
            Collection<Produto> produto = filial.getProduto();
            for (Produto produtoProduto : produto) {
                produtoProduto.setFilial(null);
                produtoProduto = em.merge(produtoProduto);
            }
            em.remove(filial);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Filial> listAll() {
        return findFilialEntities(true, -1, -1);
    }

    public List<Filial> findFilialEntities(int maxResults, int firstResult) {
        return findFilialEntities(false, maxResults, firstResult);
    }

    private List<Filial> findFilialEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from Filial as o");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Filial buscaPorId(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Filial.class, id);
        } finally {
            em.close();
        }
    }

    public int getFilialCount() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select count(o) from Filial as o");
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
