/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import dao.CategoryDao;
import dao.ProducerDao;
import dao.SearchProductDao;
import dao.StoreDao;
import dao.WrapperProductDao;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import model.Category;
import model.Producer;
import model.Product;
import model.Store;
import model.WrappedProduct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author KATY
 */
@Controller
public class HomeController {
    
  
     @Autowired 
    private ServletContext servletContext;
    @Autowired
     private CategoryDao categoryDao;
    @Autowired
    private WrapperProductDao wrapperdao;
    @Autowired
    private SearchProductDao searchPrdao;
    @Autowired
    private StoreDao storedao;
    @Autowired
    private ProducerDao producerdao;
    
    
    //These methods fill the application context of our project
    
    public void fillApplicationContext(){
        ArrayList<Category> categories = categoryDao.getCategories();
        ArrayList<Store> stores =storedao.getStores();
        ArrayList<Producer> producers = producerdao.getProducers();
        servletContext.setAttribute("categories", categories);
        servletContext.setAttribute("stores", stores);
        servletContext.setAttribute("producers", producers);
    }
    
    @RequestMapping(value="/homeController.htm", method = RequestMethod.POST)
    public String storeItems(ModelMap model, HttpSession session){
         int storeId = (int) session.getAttribute("id");
         session.setAttribute("storeId",storeId);
         fillApplicationContext();
         model.addAttribute("wrapped", fetchAllProducts(storeId));
         return "homepage";
}
    public ArrayList fetchAllProducts(int storeId){
        
        ArrayList<Product> products = searchPrdao.fetchAllProductsByStore(storeId);
        ArrayList<WrappedProduct> wrapped = wrapperdao.GetWrappedPr(products);
        return wrapped;
    }
    
}
