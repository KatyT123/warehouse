package dao;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ProductDaoImp implements ProductDao{
    
    @PersistenceContext
    private EntityManager em;
    
    @Transactional
    @Override
     public void addnewProductToDatabase(Product product){
        em.persist(product);
     }
     
     @Transactional
    @Override
     public Product findproduct(String pCode){
        Product product = em.find(Product.class, pCode);
        return product;
     }
     
     @Override
    public ArrayList<Product> getProducts() {
        ArrayList<Product> products = new ArrayList<>();
        String sql = "Select p from Product p";
        Query query = em.createQuery(sql);
        products = (ArrayList)query.getResultList();
        return products;
        
    }
    @Override
    public Product GetProduct(String pcode) {
         Product product = new Product();
         String sql = "SELECT p FROM Product p WHERE p.productCode = :pcode";
         Query query = em.createQuery(sql);
         query.setParameter("pcode", pcode);
         product = (Product) query.getSingleResult();
         return product;
   }
    
}
