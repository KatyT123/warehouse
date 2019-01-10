/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.StockDao;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import model.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import wrapper.StockPseudo;

/**
 *
 * @author Katy
 */
@RestController
public class StockAjaxController {
    
    @Autowired
    private StockDao stockdao;
    
    
    
    @RequestMapping(value = "/insertStock/{pcode}/{newquant}", method = RequestMethod.GET, headers = "Accept= */*")
    public @ResponseBody String InsertNewStockAndGetCurrent(ModelMap model, @PathVariable("pcode") String pcode, @PathVariable("newquant") String newquant, HttpSession session ) throws JsonProcessingException{ 
        
        ObjectMapper mapper = new ObjectMapper();
        int storeId = (int) session.getAttribute("storeId");
        int currentquant = stockdao.getStock(pcode,storeId).getQuantity();
        stockdao.updateNewStock(pcode,Integer.parseInt(newquant),storeId);
        int toupdatequant = currentquant + Integer.parseInt(newquant);                  
        stockdao.updateNewStock(pcode,toupdatequant,storeId);
        Stock stock = stockdao.getStock(pcode, storeId);
        return mapper.writeValueAsString(stock.getQuantity());
    }  
    
    @RequestMapping(value = "/substractStock/{pcode}/{newquant}", method = RequestMethod.GET, headers = "Accept= */*")
    public @ResponseBody String SubstractStckAndCurrentStock(ModelMap model, @PathVariable("pcode") String pcode, @PathVariable("newquant") String newquant, HttpSession session ) throws JsonProcessingException{ 
        
        ObjectMapper mapper = new ObjectMapper();
        int storeId = (int) session.getAttribute("storeId");
        int currentquant = stockdao.getStock(pcode,storeId).getQuantity();
        int toupdatequant = currentquant - Integer.parseInt(newquant);
        if (toupdatequant > 0){                                                            
             stockdao.updateNewStock(pcode,toupdatequant,storeId);
             Stock stock = stockdao.getStock(pcode, storeId);
             return mapper.writeValueAsString(stock.getQuantity());
        }  
        else return mapper.writeValueAsString(currentquant);
    }
    
    @RequestMapping(value = "/otherStoresStock/{pcode}", method = RequestMethod.GET, headers = "Accept= */*")
    public @ResponseBody String SearchStockOfOtherStores(ModelMap model, @PathVariable("pcode") String pcode, HttpSession session ) throws JsonProcessingException{ 
        
        int storeId = (int) session.getAttribute("storeId");
        ArrayList<String> mylist = stockdao.getOthersStockAsStringList(storeId, pcode);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(mylist);
    } 
    
    @RequestMapping(value = "/ajax.htm",method=RequestMethod.GET,headers="Accept=*/*",produces="application/json")
    public @ResponseBody String returnAllstock(Model map) throws JsonProcessingException{
        
        List<StockPseudo> ajaxresults = stockdao.returnPseudoStock(stockdao.returnAllStock());
        ObjectMapper mapper = new ObjectMapper();
        
        return mapper.writeValueAsString(ajaxresults);
    } 
    
    @RequestMapping(value = "/ajaxsearch.htm",method=RequestMethod.GET,headers="Accept=*/*",produces="application/json")
   public @ResponseBody String returnstock(@RequestParam("text2") String text) throws JsonProcessingException{

       List<Stock> results = stockdao.returnSearchStock(stockdao.returnAllStock(), text);
       List<StockPseudo> ajaxresults = stockdao.returnPseudoStock(results);
       ObjectMapper mapper = new ObjectMapper();

       return mapper.writeValueAsString(ajaxresults);
   }
}

