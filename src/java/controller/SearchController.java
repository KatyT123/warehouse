/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import dao.SearchProductDao;
import dao.WrapperProductDao;
import java.util.ArrayList;
import model.Product;
import model.WrappedProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author KATY
 */
@Controller
public class SearchController {
    
    @Autowired
    private WrapperProductDao wrapperdao;
    
    @Autowired
    private SearchProductDao searchPrdao;
    
   @RequestMapping(value = "/searchByCategory/{catId}.htm", method = RequestMethod.GET )
    public String ShowRegisterForm(ModelMap model, @PathVariable("catId") String catId)throws JsonProcessingException{ 
       
            ArrayList<Product> products = searchPrdao.findProductsByCategory(catId);
            ArrayList<WrappedProduct> wrapped = wrapperdao.GetWrappedPr(products);
            model.addAttribute("wrapped", wrapped);
            return "productsTable"; 
       
     
    }
    } 

