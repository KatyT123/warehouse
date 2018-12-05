/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CatergoryDao;
import dao.SearchProductDao;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import model.Category;
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
    ServletContext servletContext;
    
    @Autowired
    CatergoryDao categorydao;
    
    //This method fill the application context of our project
    public void fillApplicationContext(){
        ArrayList<Category> categories = categorydao.getCategories();
        servletContext.setAttribute("categories", categories);
    }
    
    @RequestMapping(value="/homeController.htm", method = RequestMethod.GET)
    public String storeItems(ModelMap model){
         fillApplicationContext();
         return "index";
}
}
