package controller;

import dao.StockDao;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpSession;
import model.Product;
import model.Stock;
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
      
        
        Product product = new Product(); 
        product.setProductCode(pcode);  
        Stock stock = setNewStock(combined);
        stockdao.addnewStockToDatabase(stock);
        stockdao.insertOtherStockProductToOtherStore(stock, pcode);
        return "forward:homeController.htm";
    }
    
    @RequestMapping(value = "/history.htm")
    public String returnStock(ModelMap model){
        
        List<Stock> results = stockdao.returnAllStock();
        model.addAttribute("stocks", results);
        
        return "HistoryStock";
    }
    
    public Stock setNewStock(WrapperStock combined){
        Stock stock=combined.getStock();
        stock.setProductCode(combined.getProduct()); 
        stock.setStoreId(combined.getStore());
        return stock;
    }
    
}
