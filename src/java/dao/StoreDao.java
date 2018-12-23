
package dao;

import java.util.ArrayList;
import model.Store;


public interface StoreDao {
    
    public boolean checkIfUserIsAlreadyExist(int id,String username);
    
    public ArrayList<Store> getStores();
    
    public Store findstore(int id);
    
    public void addnewStoreToDatabase(Store store);
    
    public String searchForStoreByUsernameAndPassword(Store store);
    
    public void updatePasswordForFirstTimeAndBoolean(String username,String password);
    
    public Boolean returnForcePassChangeFromDb(Store store);
    
    public int getIdFormDb(Store store);
    
    //Katerina
    
    public ArrayList <Store> getAllStores();
    
    public Store GetStore(Integer s);
    
    public Store GetStoreByProductCode(String s);
    
    public Boolean returnForcePassChangeFromDb(String text);
    
    
    
}
