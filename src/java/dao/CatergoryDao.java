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
import javax.transaction.Transactional;
import model.Category;
import org.springframework.stereotype.Repository;

/**
 *
 * @author chern
 */
@Transactional
@Repository
public class CatergoryDao {

    public CatergoryDao() {
    }
    
    
     @PersistenceContext
    private EntityManager em;
     
      public ArrayList<Category> getCategories() {
        ArrayList<Category> categories = new ArrayList<>();
        String sql = "Select c from Category c";
        Query query = em.createQuery(sql);
        categories = (ArrayList)query.getResultList();
        return categories;
    }
}
