/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import dao.ProductDao;
import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 *
 * @author chern
 */
@Component
public class ProductConverter implements Converter<String, Product>{
    
    @Autowired ProductDao productdao;
    
    @Override
    public Product convert(String s) {
       return productdao.GetProduct(s);
    }
    
    public Product convertWithoutDb(String s){
        Product product = new Product();
        product.setProductCode(s);
        return product;
    }
}
