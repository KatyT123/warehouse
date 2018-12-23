/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import org.springframework.stereotype.Component;

/**
 *
 * @author Katy
 */
@Component
public class WrappedProduct {
    
    private Alloy alloy ;
    private Product product ;
    private Producer producer ;
    private Stock stock;
    private ProductView prview ;
    private ArrayList<Stone> prstones = new ArrayList<>();

    public WrappedProduct() {
    }

    public Alloy getAlloy() {
        return alloy;
    }

    public void setAlloy(Alloy alloy) {
        this.alloy = alloy;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public ProductView getPrview() {
        return prview;
    }

    public void setPrview(ProductView prview) {
        this.prview = prview;
    }

    public ArrayList<Stone> getPrstones() {
        return prstones;
    }

    public void setPrstones(ArrayList<Stone> prstones) {
        this.prstones = prstones;
    }
    
    
}
