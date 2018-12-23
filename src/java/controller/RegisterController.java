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
    
   //Registration Controller
     
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
        
        Boolean k=storeDao.checkIfUserIsAlreadyExist(id, username);
        
        Boolean userValidation=storeValidator.validateUsername(username,k);
        
        storeValidator3.validate(store, bindingResult); //validation of confirm allagh
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
        Boolean passValidation=storeValidator.validatePassword(password);
        if(!passValidation){
            return "RegistrationForm";
        }
        Boolean locValidation=storeValidator.validatelocation(location);
        if(!locValidation){
            return "RegistrationForm";
        }
        
        else{
        
        String hashed =BCrypt.hashpw(password, BCrypt.gensalt());
        store.setPassword(hashed);
        store.setForcePassChange(locValidation);
        Boolean i=false;
        store.setForcePassChange(i);
        storeDao.addnewStoreToDatabase(store);
        return "forward:/homeController.htm";
        }
    }
    
    
    
   
    
    
} 

