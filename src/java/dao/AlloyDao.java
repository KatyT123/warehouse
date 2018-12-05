/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Alloy;
import org.springframework.stereotype.Repository;

/**
 *
 * @author chern
 */

@Repository
public class AlloyDao {
    
    @PersistenceContext
    private EntityManager em;
    
     public Alloy GetAlloy(Integer alloyId){ 
         
         Alloy alloy = new Alloy();
         String sql = "SELECT a FROM Alloy a WHERE a.alloyId LIKE ?";
         Query query = em.createQuery(sql);
         query.setParameter(1, alloyId);
         alloy = (Alloy) query.getSingleResult();
         return alloy;
   }
}
