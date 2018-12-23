
package dao;

import java.util.ArrayList;
import model.Product;


public interface ProductDao {
    
    public void addnewProductToDatabase(Product product);
    
    public Product findproduct(String pCode);
    
     public ArrayList<Product> getProducts();
     
     public Product GetProduct(String pcode);
}
