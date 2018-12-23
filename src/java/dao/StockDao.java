package dao;

import java.util.ArrayList;
import java.util.List;
import model.Stock;
import model.Store;
import wrapper.StockPseudo;


public interface StockDao {
    
     public Boolean searchIfProductExistInOtherStores(Store store);
     
     public void addnewStockToDatabase(Stock stock);
     
     public void insertOtherStockProductToOtherStore(Stock stock,String product,int i,int l);
     
     public List returnAllStock();
     
     public List stockBytext(String text);
     
     public List<StockPseudo> returnPseudoStock(List<Stock> search);
     
     public List<Stock> returnSearchStock(List<Stock> results,String text);

      
     //Katerina
     public ArrayList getStockCollection(String pcode) ;
     
     public void updateNewStock(String pcode,int toupdatequant, int storeId);
     
     public Stock updatedStock(String pcode, int toupdatequant, int storeId);
     
     public Stock getStock(String pcode, int storeId);
     
     public ArrayList<Stock> getStockCurrentCollectionOfOtherStores(int storeId, String pcode);
     
      public ArrayList<String> getOthersStockAsStringList(int storeId, String pcode);
     
     
}
