package dao;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Category;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CategoryDaoImp implements CategoryDao{
    
    @PersistenceContext
    private EntityManager em;
    
    @Transactional
    @Override
    public void addnewCategoryToDatabase(Category category){
        
        em.persist(category);
     }
    
    @Transactional
    @Override
    public ArrayList<Category> getCategories() {
        ArrayList<Category> categories = new ArrayList<>();
        String sql = "Select c from Category c";
        Query query = em.createQuery(sql);
        categories = (ArrayList)query.getResultList();
        return categories;
    }

    
}
