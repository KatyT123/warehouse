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
import validator.StoreValidator3;

@Controller
public class RegisterController {
    
   
     @Autowired
     private StoreDao storeDao;
     @Autowired
     private StoreValidator storeValidator;
     @Autowired
     private StoreValidator3 storeValidator3;

     
     @RequestMapping(value="/registrationFormController.htm", method=RequestMethod.GET)
     public String createEmptyStore(ModelMap map) throws IOException{
         Store store= new Store();
         map.addAttribute("emptystore", store);
         return "RegistrationForm";
    }
     
    @RequestMapping(value="/handleregistration.htm", method=RequestMethod.POST)
    public String registerStore(@Valid @ModelAttribute("emptystore") Store store ,BindingResult bindingResult,ModelMap map,HttpSession session) throws IOException{
        
        int id=store.getStoreId();
        String username=store.getUsername();
        String password=store.getPassword();
        String location=store.getLocation();
        Boolean userexist=storeDao.checkIfUserIsAlreadyExist(id, username);
        Boolean userValidation=storeValidator.validateUsername(username,userexist);
        
        storeValidator3.validate(store, bindingResult); 
        if(bindingResult.hasErrors()){
            return "RegistrationForm";
        }
        
        Boolean idValidation=storeValidator.validateId(id);
        if(!idValidation){ 
            return "RegistrationForm";
        }
        
        if(!userValidation){
            Store store2 = new Store();
            storeValidator.validate(store2, bindingResult);
            if(bindingResult.hasErrors()){
                return "RegistrationForm";
            }
        }
        
        if(!storeValidator.validatePassword(password)){
            return "RegistrationForm";
        }
        if(!storeValidator.validatelocation(location)){
            return "RegistrationForm";
        }
        
        else{
            storeDao.addnewStoreToDatabase(setNewPasswordToStore(store,storeValidator.validatelocation(location)));
            return "forward:/homeController.htm";
        }
    }
    
    public Store setNewPasswordToStore(Store store, Boolean locValidation){
        String password=store.getPassword();
        String hashed =BCrypt.hashpw(password, BCrypt.gensalt());
        store.setPassword(hashed);
        store.setForcePassChange(locValidation);
        Boolean i=false;
        store.setForcePassChange(i);
        return store;
    }
    
   
    
    
} 

