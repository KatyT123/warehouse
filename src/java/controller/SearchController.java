/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import dao.SearchProductDao;
import dao.StockDao;
import dao.WrapperProductDao;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import model.Product;
import model.WrappedProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author chern
 */
@Controller
public class SearchController {
    
    @Autowired
    private WrapperProductDao wrapperdao;
    @Autowired
    private SearchProductDao searchPrdao;
    @Autowired
    private StockDao stockdao;
    
   @RequestMapping(value = "/searchByCategory/{catId}.htm", method = RequestMethod.GET )
    public String ShowRegisterForm(ModelMap model, @PathVariable("catId") String catId)throws JsonProcessingException{ 
       
            ArrayList<Product> products = searchPrdao.findProductsByCategory(catId);
            ArrayList<WrappedProduct> wrapped = wrapperdao.GetWrappedPr(products);
            model.addAttribute("wrapped", wrapped);
            return "productsTable"; 
   
    }
    
    @RequestMapping(value = "/zoomProduct/{productCode}.htm", method = RequestMethod.GET )
    public String ZoomProduct(ModelMap model, @PathVariable("productCode") String pcode, HttpSession session){ 
        
            WrappedProduct wrapped = wrapperdao.getZoomProductWrapped(searchPrdao.fetchByPcode(pcode));
            model.addAttribute("wrapped", wrapped);
            model.addAttribute("stones", wrapped.getProduct().getStoneCollection());
            int storeId = (int)session.getAttribute("storeId");
            model.addAttribute("stock", stockdao.getStock(pcode,storeId));
            return "zoomProduct"; 
    }  
    
    @RequestMapping(value = "/searchById.htm", method = RequestMethod.GET )
    public String SearchById(ModelMap model, @ModelAttribute("pcode") String pcode, HttpSession session){ 
            
            WrappedProduct wrapped = wrapperdao.getZoomProductWrapped(searchPrdao.fetchByPcode(pcode));
            model.addAttribute("wrapped", wrapped);
            model.addAttribute("stones", wrapped.getProduct().getStoneCollection());
            int storeId = (int)session.getAttribute("storeId");
            model.addAttribute("stock", stockdao.getStock(pcode,storeId));
            return "zoomProduct"; 
    }   
    
    @RequestMapping(value = "/showPreferences.htm", method = RequestMethod.GET)
    public String showPreferences(@ModelAttribute("price") String price, ModelMap model) {
        // ArrayList<Product> products = searchPrdao.findProductsByCategory(catId);
        // ArrayList<WrappedProduct> wrapped = wrapperdao.GetWrappedPr(products);
         
         return "productsTable";
    } 
    
    
 
    } 

