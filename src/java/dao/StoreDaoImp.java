
package dao;

import helpers.BCrypt;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Store;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class StoreDaoImp implements StoreDao{
    
    @PersistenceContext
    private EntityManager em;

    @Transactional
    @Override
    public boolean checkIfUserIsAlreadyExist(int id,String username){
        
        Boolean i=false;
        Store store1 = em.find(Store.class, id);
        String sql="Select s.username from Store s where s.username = :username";
        Query query=em.createQuery(sql);
        query.setParameter("username", username);
        List<String> usernames =query.getResultList();
        int k=usernames.size();
        
        if(store1==null && k==0){
            i=false; //efoson einai null to store1 kai to k=0 mporei na kanei registration
        }
        else{
            i=true;
        }
        return i;
    }
    
   @Transactional
   @Override
    public Boolean returnForcePassChangeFromDb(String text){
        String sql="Select s.forcePassChange from Store s where s.username = :text";
       Query query=em.createQuery(sql);
       query.setParameter("text", text);
       Boolean forcepass=false;
       try{
            forcepass=(Boolean)query.getSingleResult();

           return forcepass;
       }
       catch (NoResultException nre){

           return forcepass;
       }

    }
    
    @Override
    public ArrayList<Store> getStores() {
        ArrayList<Store> stores = new ArrayList<>();
        String sql = "SELECT s FROM Store s";
        Query query = em.createQuery(sql);
        stores = (ArrayList)query.getResultList();
        return stores;
        
    }
    
    @Transactional
    @Override
     public Store findstore(int id){
        Store store = em.find(Store.class, id);
        return store;
     }
     
    @Transactional
    @Override
     public void addnewStoreToDatabase(Store store){
        em.persist(store);
     }
     
    @Transactional
    @Override
     public String searchForStoreByUsernameAndPassword(Store store){
         
        String sql="Select s.password from Store s where s.username = :username";
        Query query1=em.createQuery(sql);
        query1.setParameter("username", store.getUsername());
        
        
        try{
            String hashedpassdb=(String)query1.getSingleResult();
            return hashedpassdb;
        }
        catch (NoResultException nre){
            
            return null;
        }
     
     }
     
    @Transactional
    @Override
     public void updatePasswordForFirstTimeAndBoolean(String username,String password){
         
        String hashedpass = BCrypt.hashpw(password, BCrypt.gensalt());
        
        String sql="update store s set s.password = ?, s.force_pass_change = ? where s.username = ? ";
        Query query=em.createNativeQuery(sql);
        query.setParameter(1,hashedpass );
        query.setParameter(2, false);
        query.setParameter(3, username);
        query.executeUpdate();
        
        
        
     }
     
     @Transactional
    @Override
     public Boolean returnForcePassChangeFromDb(Store store){
         ArrayList<Store> stores = new ArrayList<>();
         String sql="Select s.forcePassChange from Store s where s.username = :username ";
        Query query=em.createQuery(sql);
        query.setParameter("username", store.getUsername());
        
        Boolean forcepasschange=(Boolean)query.getSingleResult();
        return forcepasschange;
     }
     
     @Transactional
    @Override
     public int getIdFormDb(Store store){
         
        String sql="Select s.storeId from Store s where s.username = :username";
        Query query=em.createQuery(sql);
        query.setParameter("username", store.getUsername());
        int id=(int)query.getSingleResult();
        
        return id;
     }
     
     //katerina
    @Override
     public ArrayList <Store> getAllStores() {
         String sql = "SELECT s FROM Store s";
         Query query = em.createQuery(sql);
         ArrayList <Store> stores = (ArrayList <Store>) query.getResultList();
         return stores;
    }

    @Override
    public Store GetStore(Integer s) {
         Store store = new Store();
         String sql = "SELECT s FROM Store s WHERE s.storeId = :s";
         Query query = em.createQuery(sql);
         query.setParameter("s", s);
         store = (Store) query.getSingleResult();
         return store;
    }

    @Override
    public Store GetStoreByProductCode(String s) {
         Store store = new Store();
         String sql = "SELECT s FROM Store s WHERE s.productCode = :s";
         Query query = em.createQuery(sql);
         query.setParameter("s", s);
         store = (Store) query.getSingleResult();
         return store;
    }
     
     
     
     
     
}
