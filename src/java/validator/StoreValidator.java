package validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.Store;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author chern
 */
@Component
public class StoreValidator implements Validator{
    
    
    private Matcher regMatcher;
    
    

    @Override
    public boolean supports(Class<?> type) {
        return Store.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        boolean f=true;
        Store store = (Store)o;
        
        if(store.getStoreId()==null||store.getUsername()==null){
            errors.rejectValue("storeId","id.exist");
        }
        else{
            
            f=true;
        }
        
    }
    
    public Boolean validateUsername(String username,Boolean k){
        boolean i=false;
        Pattern pattern = Pattern.compile("^[A-Za-z]{3,15}$");
         regMatcher=pattern.matcher(username);
         
         if(regMatcher.matches()){   //ara vazei to swsto typo username (dhladh ths morfhw pou theloume)
             if(!k){
                i=true; //tote kai mono tote mporei na kanei registration giati den uparxei o xrhsths sth vash
             }
             else if(k){
                 i=false;
             }
         }
         else{
            i=false;
         }
        return i;
    }
    
    public Boolean validatePassword(String password){
        boolean i=false;
        Pattern pattern = Pattern.compile("^((?!.*[\\s])(?=.*[A-Z])(?=.*[#$^+=!*()@%&]).{8,15})");
         regMatcher=pattern.matcher(password);
         
         if(regMatcher.matches()){   //ara vazei to swsto typo password (dhladh ths morfhw pou theloume)
             i=true;                 //dld opwsdhpote ena kefalaio gramma enan arithmo kai ena special xarakthra px &
         }                           //kai to password prepei na einai toulaxiston 8 xarakthres kai mikrotero iso 15 xarakthres   
        return i;
    }
    
    public Boolean validatelocation(String location){
        boolean i=false;
        Pattern pattern = Pattern.compile("[A-Za-z]{1,15}"); 
         regMatcher=pattern.matcher(location);
         
         if(regMatcher.matches()){   //ara vazei to swsto typo location (dhladh ths morfhw pou theloume dhladh mono letters me mhkos ews 15 xarakthres)
             i=true;
         }
        return i;
    }
    
    public Boolean validateId(int id){
        Integer k=id;
        String myId=k.toString();
        boolean i=false;
        Pattern pattern = Pattern.compile("^((?!(0))[0-9]{1,2})$");
         regMatcher=pattern.matcher(myId);
         
         if(regMatcher.matches()){   //ara vazei to swsto typo id (dhladh ths morfhw pou theloume dld mexri 2 psifia px 99 h 12 oxi arnhtikoi oxi 0)
             i=true;
         }
        return i;
    }
    
    public Boolean validateusername(String username){  //allagh extra mehodos
       boolean i=false;
       Pattern pattern = Pattern.compile("^[A-Za-z]{3,15}$");
        regMatcher=pattern.matcher(username);

        if(regMatcher.matches()){   //ara vazei to swsto typo username (dhladh ths morfhw pou theloume)
            i=true;
        }
        else{
           i=false;
        }
       return i;
   }
}
