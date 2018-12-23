
package dao;

import java.util.ArrayList;
import model.Alloy;





public interface AlloyDao {
    
      public void addAlloy(Alloy alloy);
      
      public Alloy GetAlloy(Integer alloyId);
      
      public ArrayList<Alloy> fetchAlloys();
      
}
