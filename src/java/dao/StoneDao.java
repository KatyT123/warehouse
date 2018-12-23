package dao;

import java.util.List;
import model.Stone;


public interface StoneDao {
    
    public void addStone(Stone stone,List weights,List quantity,List stoneDescr);
}
