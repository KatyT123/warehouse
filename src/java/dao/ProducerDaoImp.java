
package dao;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Producer;
import org.springframework.stereotype.Repository;

@Repository
public class ProducerDaoImp implements ProducerDao{
    
     @PersistenceContext
    private EntityManager em;

    @Override
    public ArrayList<Producer> getProducers() {
        ArrayList<Producer> producers = new ArrayList<>();
        String sql = "Select c from Producer c";
        Query query = em.createQuery(sql);
        producers = (ArrayList)query.getResultList();
        return producers;
        
    }
    
     @Override
    public Producer GetProducer(String producerCode){ 
         
         Producer producer = new Producer();
         String sql = "SELECT p FROM Producer p WHERE p.producerCode = :producerCode";
         Query query = em.createQuery(sql);
          query.setParameter("producerCode", producerCode);
         producer = (Producer) query.getSingleResult();
         return producer;
   }
    
}
