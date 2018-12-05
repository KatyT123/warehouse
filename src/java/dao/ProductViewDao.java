/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static java.lang.Integer.parseInt;
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
        String sql = "SELECT p FROM ProductView p WHERE p.productCode LIKE ?";
         Query query = em.createQuery(sql);
         query.setParameter(1, product_code);
         prview = (ProductView) query.getSingleResult();
         return prview;
   }
     
}
