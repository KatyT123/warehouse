package dao;

import java.util.ArrayList;
import model.Category;

public interface CategoryDao {
    
    public void addnewCategoryToDatabase(Category Category);
    
    public ArrayList<Category> getCategories();
    
}
