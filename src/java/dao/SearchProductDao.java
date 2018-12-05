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
import javax.transaction.Transactional;
import model.Product;
import org.springframework.stereotype.Repository;

/**
 *
 * @author KATY
 */
@Transactional
@Repository
public class SearchProductDao {

    public SearchProductDao() {
    }
   
    @PersistenceContext
    private EntityManager em;
  
     public ArrayList findProductsByCategory(String catId){
         int id = parseInt(catId);
         ArrayList<Product> products = new ArrayList<>();
         String sql = "SELECT p FROM Product p, Category c WHERE p.categoryId = c.categoryId AND c.categoryId LIKE ?";
         Query query = em.createQuery(sql);
         query.setParameter(1, id );
         products = (ArrayList<Product>)query.getResultList();
         return products;
   }
   
   
    
 /*   public Collection getStones(ArrayList<Product> products){
        Collection <Stone> stones ;
        if (products.size()!= 0){
         Product p = products.get(0);
         Collection <Stone> stones =  p.getStoneCollection();
         for(Stone s: stones){
             System.out.println(s.getStoneDscr()+"  $$  "+s.getStoneDscr());
         }
        for(Product p:products){
            stones = p.getStoneCollection();
            
    } */
    
   /*public ArrayList findCategory(String catId){
         int id = parseInt(catId);
         ArrayList<Product> products = new ArrayList<>();
         String sql = "SELECT p FROM Product p, Category c WHERE p.categoryId = c.categoryId AND c.categoryId LIKE ?";
         Query query = em.createQuery(sql);
         query.setParameter(1, id );
         products = (ArrayList<Product>)query.getResultList(); 
         return products; } 
    
    public void insertAlloy(){
        Alloy alloy = new Alloy();
        alloy.setGoldWeight(5.6);
        alloy.setKarats(40);
        alloy.setSilverWeight(9.7);
        em.persist(alloy);
    } 

   /* public void insertProduct() {
        Product product = new Product();
        Producer producer = new Producer();
        Category category = new Category();
        Alloy alloy = new Alloy();
        producer.setProducerCode("1");
        alloy.setAlloyId(1);
        category.setCategoryId(1);
        product.setCategoryId(category);
        product.setProductCode("ab1234");
        product.setAlloyId(alloy);
        product.setProduserCode(producer);
         em.persist(product);
    } */
   
     
}
