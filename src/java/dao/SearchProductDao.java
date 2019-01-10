/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import converter.StoreConverter;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import model.Product;
import model.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author chern
 */
@Transactional
@Repository
public class SearchProductDao {

    public SearchProductDao() {
    }
   
    @PersistenceContext
    private EntityManager em;
    
    @Autowired
    private StoreConverter storeconv;
  
     public ArrayList findProductsByCategory(String catId){
         int id = parseInt(catId);
         ArrayList<Product> products = new ArrayList<>();
         String sql = "SELECT p FROM Product p, Category c WHERE p.categoryId = c.categoryId AND c.categoryId = :id";
         Query query = em.createQuery(sql);
         query.setParameter("id", id );
         products = (ArrayList<Product>)query.getResultList();
         return products;
   }
   public ArrayList fetchAllProductsByStore(int storeId){ //allagi
         Store store = (storeconv.convert(storeId));
         ArrayList<Product> products = new ArrayList<>(); 
         String sql = "SELECT DISTINCT p FROM Product p, Stock s WHERE p.productCode = s.productCode AND s.storeId = :store";
         Query query = em.createQuery(sql);
         query.setParameter("store", store);
         products = (ArrayList<Product>)query.getResultList();
         return products;
    }

    public Product fetchByPcode(String pcode) {
        String sql = "Select p From Product p Where p.productCode = :pcode";
        Query query = em.createQuery(sql);
        query.setParameter("pcode", pcode);
        Product p = (Product) query.getSingleResult();
        return p;
    }
    
    
     
}
