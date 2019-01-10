
package dao;

import java.util.List;
import model.Alloy;





public interface AlloyDao {
    
      public void addAlloy(Alloy alloy);
      
      public Alloy GetAlloy(Integer alloyId);
      
      public List<Alloy> fetchAlloys();
      
}
