/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import model.Producer;
import org.springframework.stereotype.Repository;

/**
 *
 * @author chern
 */
@Transactional
@Repository
public class ProducerDao {
    
     @PersistenceContext
    private EntityManager em;
     
     public Producer GetProducer(String producerCode){ 
         
         Producer producer = new Producer();
         String sql = "SELECT p FROM Producer p WHERE p.producerCode LIKE ?";
         Query query = em.createQuery(sql);
          query.setParameter(1, producerCode);
         producer = (Producer) query.getSingleResult();
         return producer;
   }
}
