/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import converter.AlloyConverter;
import converter.ProducerConverter;
import java.util.ArrayList;
import model.Product;
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
   

    public ArrayList<WrappedProduct> GetWrappedPr(ArrayList<Product> products) {
        ArrayList<WrappedProduct> wrappedpr = new ArrayList<>();
         for (Product p: products){
             WrappedProduct wrapped = new WrappedProduct();
             wrapped.setAlloy(alloyconv.convert(p.getAlloyId().getAlloyId()));
             wrapped.setProduct(p);
             wrapped.setProducer(producerconv.convert(p.getProducerCode().getProducerCode()));
             wrapped.setPrview(prviewdao.findProductProductView(p.getProductCode()));
             wrappedpr.add(wrapped);
         }
         return wrappedpr;
    }
     
     
}
