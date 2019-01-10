package wrapper;


import model.Product;
import model.Stock;
import model.Store;


public class WrapperStock {
    
     
    private Product product;
    private Stock stock;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
    private Store store;
}
