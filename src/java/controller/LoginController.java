package controller;

import dao.StoreDao;
import helpers.BCrypt;
import java.io.IOException;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import model.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import validator.StoreValidator;
import validator.StoreValidator2;

/**
 *
 * @author Katy
 */
@Controller
public class LoginController {
    
     @Autowired
     private StoreDao storeDao;
     @Autowired
     private StoreValidator2 storeValidator2;
     @Autowired
     private StoreValidator storeValidator;


    //prowthisi adeiou store antikeimenou sth spring form
    @RequestMapping(value="/loginSetEmpty.htm", method=RequestMethod.GET)
    public String createEmptyStore(ModelMap map) throws IOException{
        Store store= new Store();
        map.addAttribute("emptystore", store);
        return "loginForm";
    }
    
    
    //epe3ergasia login meta to pathma tou submit ths login
         @RequestMapping(value="/handleLogin.htm", method=RequestMethod.POST)
    public String loginStore(@Valid @ModelAttribute("emptystore") Store store ,BindingResult bindingResult,ModelMap map,HttpSession session) throws IOException{
        
     if(storeValidator.validateusername(store.getUsername())&&storeValidator.validatePassword(store.getPassword())){  
        if(storeDao.searchForStoreByUsernameAndPassword(store)==null){
            Store store1= new Store();
            storeValidator2.validate(store1, bindingResult);
            if(bindingResult.hasErrors()){
            return "loginForm";
            }
        }
        
        else{
            if (BCrypt.checkpw(store.getPassword(), storeDao.searchForStoreByUsernameAndPassword(store))){ //ean tairiazei to password me auto sth vash..
                int id=storeDao.getIdFormDb(store);
                session.setAttribute("id", id);
                session.setAttribute("username",store.getUsername());
                
                if(storeDao.returnForcePassChangeFromDb(store)){ //ean einai 1 tha mpei sthn if...1 shmainei oti einai tou admin kai tha allaxei apo 1 se 0 h boolean sth vash
                    
                    return "changepassword";  
                   
                }else{
                    
                    return "forward:/homeController.htm";
               }
            
            }
            else{
                Store store2= new Store();
                storeValidator2.validate(store2, bindingResult);
                if(bindingResult.hasErrors()){
                    
                    return "loginForm";
                }
            }
             
          }
        }
     else{
            return "loginForm";
        }
        return null;
    }
    
}