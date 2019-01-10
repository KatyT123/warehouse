/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.ProductView;
import org.springframework.stereotype.Repository;

/**
 *
 * @author chern
 */

@Repository
public class ProductViewDao {
    
    @PersistenceContext
    private EntityManager em;
  
    public ProductView findProductProductView(String product_code){
        ProductView prview = new ProductView();
        String sql = "SELECT p FROM ProductView p WHERE p.productCode = :product_code";
         Query query = em.createQuery(sql);
         query.setParameter("product_code", product_code);
         prview = (ProductView) query.getSingleResult();
         return prview;
   }
    ArrayList<ProductView> fetchProductViews() {
        
        String sql = "SELECT p FROM ProductView p";
        Query query = em.createQuery(sql);
        ArrayList<ProductView> productviews = (ArrayList<ProductView>) query.getResultList();
        return productviews;
    } 
    
}
