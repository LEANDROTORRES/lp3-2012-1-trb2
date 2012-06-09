package br.cesjf.lp3.app;

import br.cesjf.lp3.Filial;
import br.cesjf.lp3.Produto;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CriaFilial {
   
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("lp3-2012-1-trb2-pu");        
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        Filial filial = new Filial("JF", "B1");
        em.persist(filial);
        Produto p1 = new Produto("P1", 1);        
        
        p1.setFilial(filial);       
        em.persist(p1);
        
        em.getTransaction().commit();
        
    }
    
     
}
