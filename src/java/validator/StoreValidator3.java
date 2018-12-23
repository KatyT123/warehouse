package validator;

import model.Store;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class StoreValidator3 implements Validator{

    @Override
    public boolean supports(Class<?> type) {
        return Store.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Boolean i=false;
         Store store = (Store)o;
         store.getConfirmpassword();
        if((store.getPassword()).equals(store.getConfirmpassword())){
            i=true;
        }
        else{
            errors.rejectValue("password","confirmation.fail");
        }
    
    }
    
    
    
    
}