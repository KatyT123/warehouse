package dao;

import converter.ProductConverter;
import converter.StoreConverter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Product;
import model.Stock;
import model.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import wrapper.StockPseudo;

@Repository
public class StockDaoImp implements StockDao{
    
    @PersistenceContext
    private EntityManager em;
    @Autowired
    private ProductConverter prconv;
    @Autowired
    private StoreConverter storeconv;
    @Autowired
    private StoreDao storedao;

    @Override
    public Boolean searchIfProductExistInOtherStores(Store store) {
        Boolean i=false;
        ArrayList<Store> stores = new ArrayList<>();
        Integer id=store.getStoreId();
        String sql = "SELECT s FROM Stock s WHERE NOT s.storeId = :id";
        Query query = em.createQuery(sql);
        query.setParameter("id", id );
        stores=(ArrayList<Store>) query.getResultList();
        
        if(stores!=null){
            i=true;
        }
        return i;
    }
    
    @Transactional
    @Override
    public void addnewStockToDatabase(Stock stock){
        
        em.persist(stock);
     }
    
    @Transactional
    @Override
    public void insertOtherStockProductToOtherStore(Stock stock,String pcode){
      
        ArrayList<Store> stores = storedao.getStores();
        for(Store s : stores){
            if(s.getStoreId()!= stock.getStoreId().getStoreId()){
               Stock stock1=new Stock();
               stock1.setProductCode(prconv.convertWithoutDb(pcode));
               stock1.setStoreId(storeconv.convertWithoutDb(s.getStoreId()));
               stock1.setQuantity(0);
               em.persist(stock1); 
            }
        }
    }
    
    @Transactional 
    @Override
     public List returnAllStock(){
         
         Query query =em.createQuery("Select s from Stock s ");
         List<Stock> mystock = query.getResultList();
         
         return mystock;
     }
     
    @Transactional 
    @Override
     public List stockBytext(String text){
         
         Query query =em.createQuery("Select s from Stock s where s.productCode like :productCode");
         query.setParameter("productCode", text + "%");
         List<Stock> mystock = query.getResultList();
         return mystock;
     }
     
      @Override
    public List<Stock> returnSearchStock(List<Stock> results,String text){

     List<Stock> search = new ArrayList();
      for(Stock s : results){
           String pcode=s.getProductCode().getProductCode();
           Pattern r = Pattern.compile(text);
           Matcher m = r.matcher(pcode);
           if(m.find()){
               search.add(s);
           }
       }

       return search;
   }


   @Override
   public List<StockPseudo> returnPseudoStock(List<Stock> search){

       List<StockPseudo> finalstock = new ArrayList();


       for(Stock s : search){
           StockPseudo pstock = new StockPseudo();
           pstock.setPcode(s.getProductCode().getProductCode());
           pstock.setQuant(s.getQuantity().toString());
           pstock.setDate(s.getCurrentdate().toString());
           finalstock.add(pstock);
           }

       return finalstock;

   }
     
    @Override
     public ArrayList getStockCollection(String pcode) {
         Product product = prconv.convert(pcode);
         String sql = "SELECT s FROM Stock s WHERE s.productCode = :pcode";
         Query query = em.createQuery(sql);
         query.setParameter("pcode", product);
         ArrayList<Stock> productstock = (ArrayList<Stock>) query.getResultList();
         return productstock;
    }
     
    @javax.transaction.Transactional
    @Override
    public void updateNewStock(String pcode,int toupdatequant, int storeId) {
         Stock stock = updatedStock(pcode, toupdatequant ,storeId); 
         em.persist(stock);
         
    }
    @Override
    public Stock updatedStock(String pcode, int toupdatequant, int storeId){
                                                                              
         Stock stock = new Stock ();
         stock.setQuantity(toupdatequant);
         stock.setProductCode(prconv.convert(pcode));
         stock.setStoreId(storeconv.convert(storeId));
         return stock;
    }
      
    @Override
    public Stock getStock(String pcode, int storeId) {
        
         Product product = prconv.convert(pcode);
         Store store = storeconv.convert(storeId);
         String sql = "SELECT DISTINCT s FROM Stock s WHERE s.productCode = :product AND s.storeId = :store AND s.currentdate = (Select max(s.currentdate) from s Where s.storeId = :store AND s.productCode = :product)";
         Query query = em.createQuery(sql);
         query.setParameter("product", product);
         query.setParameter("store", store);
         query.setParameter("store", store);
         query.setParameter("product", product);
         Stock stock  =  (Stock) query.getSingleResult();
         return stock;
        
    }

    @Override
    public ArrayList<Stock> getStockCurrentCollectionOfOtherStores(int storeId, String pcode) {
        
        ArrayList<Store> stores = fetchOtherStores(storeId);
        ArrayList<Stock> stock = new ArrayList<>();
        
        for(Store str : stores){        
             stock.add(getStock(pcode, str.getStoreId()));
         }
         return stock;
         }
    
    private ArrayList<Store> fetchOtherStores(int storeId){
        
        ArrayList<Store> stores = storedao.getAllStores();
        for(int i = 0; i< stores.size(); i++){
            if (storeId == stores.get(i).getStoreId()){
                stores.remove(i);
            }
            }
        
        return stores;
    }

    @Override
    public ArrayList<String> getOthersStockAsStringList(int storeId, String pcode) {
        
        ArrayList<String> mylist = new ArrayList<>();
        ArrayList<Stock> mystock = getStockCurrentCollectionOfOtherStores(storeId, pcode);
        for(Stock s : mystock){
            mylist.add(s.getStoreId().getLocation());
            mylist.add(s.getQuantity().toString());
        }
        return mylist;
    }
    
   
}






















