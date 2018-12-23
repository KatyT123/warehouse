package controller;

import dao.StockDao;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpSession;
import model.Product;
import model.Stock;
import model.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import wrapper.WrapperStock;

@Controller
public class StockController {
    
    @Autowired
    private StockDao stockdao;
    
    @RequestMapping(value="/createstock.htm", method=RequestMethod.POST)
    public String stockCreation( ModelMap map, @ModelAttribute("mystock") WrapperStock combined, BindingResult bindingResult,
            @RequestParam(value="creation") String pcode,HttpSession session) throws IOException{
      
        
        Product product = new Product(); //de ginetai na parw to combined object gia to product gt sth forma to product den anhkei sth spring form
        product.setProductCode(pcode);   //dld sth spring form de to emfanizoume..to pairnoume 3exwrista opote to combined de mporei na to parei ap th forma asxeta an to vlepei epeidh to xei sth wrapper klash...opote auto pou pairnei einai null 
        Store store=combined.getStore();
        Stock stock=combined.getStock();
        stock.setProductCode(product);  //gemisma
        stock.setStoreId(store);  //gemisma
        //stock.getStockId();
        stockdao.addnewStockToDatabase(stock);
        
        int k=stock.getStoreId().getStoreId();
        if(k==1){
            int i=2;
            int l=3;
            stockdao.insertOtherStockProductToOtherStore(stock, pcode,i,l);
        }
        else if(k==2){
            int i=1;
            int l=3;
            stockdao.insertOtherStockProductToOtherStore(stock, pcode,i,l);
        }else if(k==3){
            int i=1;
            int l=2;
            stockdao.insertOtherStockProductToOtherStore(stock, pcode,i,l);
        }
        return "forward:homeController.htm";
    }
    
    @RequestMapping(value = "/history.htm")
    public String returnStock(ModelMap model){
        
        List<Stock> results = stockdao.returnAllStock();
        model.addAttribute("stocks", results);
        
        return "HistoryStock";
    }
    
}
