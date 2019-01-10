/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import converter.AlloyConverter;
import converter.ProducerConverter;
import helper.MyBinarySearch;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import model.Alloy;
import model.Producer;
import model.Product;
import model.ProductView;
import model.WrappedProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author chern
 */

@Repository
public class WrapperProductDao {
    
    @Autowired
    private AlloyConverter alloyconv;
    @Autowired
    private ProducerConverter producerconv;
    @Autowired
    private ProductViewDao prviewdao;
    @Autowired
    private AlloyDao alloydao;
    @Autowired
    private ProducerDao producerdao;
   

    public ArrayList<WrappedProduct> GetWrappedPr(ArrayList<Product> products) {
        long startTime = System.currentTimeMillis();
        ArrayList<WrappedProduct> wrappedpr = new ArrayList<>();
        
         for (Product p: products){
             WrappedProduct wrapped = new WrappedProduct();
             wrapped.setProduct(p);
             wrapped.setAlloy(findAlloy(p));
             wrapped.setProducer(findProducer(p));
             wrapped.setPrview(findProductView(p));
             wrappedpr.add(wrapped);
         }
         long stopTime = System.currentTimeMillis(); 
         long elapsedTime = stopTime - startTime; //test time stop
         System.out.println("2: "+elapsedTime);
         return wrappedpr;
    }

    public WrappedProduct getZoomProductWrapped(Product p) {
          WrappedProduct wrapped = new WrappedProduct();
          wrapped.setAlloy(alloyconv.convert(p.getAlloyId().getAlloyId()));
          wrapped.setProduct(p);
          wrapped.setProducer(producerconv.convert(p.getProducerCode().getProducerCode()));
          wrapped.setPrview(prviewdao.findProductProductView(p.getProductCode()));
          return wrapped;
    }

   private Alloy findAlloy(Product p) {
       Comparator <Alloy> c = new Comparator<Alloy>(){public int compare(Alloy a, Alloy a1) {
          return (a.getAlloyId() - a1.getAlloyId());
          } 
       };
       List<Alloy> alloys = alloydao.fetchAlloys();
       return MyBinarySearch.getObjectWithBinarySearch(alloys, p.getAlloyId(), c);
     
    }
    
    private Producer findProducer(Product p) {
        
         ArrayList<Producer> producers = producerdao.getProducers();
         Producer producer = new Producer();
         for(Producer pr : producers){
           if (p.getProducerCode().getProducerCode().equals(pr.getProducerCode())){
               producer = pr;
               break;
           }}
        return producer;
    }

    private ProductView findProductView(Product p) {
        
        ArrayList<ProductView> prview = prviewdao.fetchProductViews();
        ProductView productview = new ProductView();
        for(ProductView prd : prview){
           if (p.getProductCode().equals(prd.getProductCode())){
               productview = prd;
               break;
           }}
        return productview;
        
    }
    
        
      
     
     
}
