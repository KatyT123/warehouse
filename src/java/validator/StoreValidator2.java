/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validator;

import model.Store;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author Tasos
 */
@Component
public class StoreValidator2 implements Validator{

    @Override
    public boolean supports(Class<?> type) {
         return Store.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        boolean f=true;
        Store store = (Store)o;
        String i=store.getUsername();
        
        if(i==null){
            errors.rejectValue("username","username.does.not.exist");
            
        }else{
            f=true;
        }
    }
    
}
