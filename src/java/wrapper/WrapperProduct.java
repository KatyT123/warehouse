
package wrapper;

import java.util.ArrayList;
import model.Alloy;
import model.Category;
import model.Producer;
import model.Product;
import model.ProductView;
import model.Stock;
import model.Stone;
import model.Store;
import org.springframework.stereotype.Component;

@Component
public class WrapperProduct {
    
    private Product product;
    private Category category;
    private Store store;
    private Producer producer;
    private Alloy alloy;
    private Stone stone;
    private Stock stock;
    private ProductView prview;
    private ArrayList<Stone> prstones = new ArrayList<>();

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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public Alloy getAlloy() {
        return alloy;
    }

    public void setAlloy(Alloy alloy) {
        this.alloy = alloy;
    }

    public Stone getStone() {
        return stone;
    }

    public void setStone(Stone stone) {
        this.stone = stone;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }
    
    
}
