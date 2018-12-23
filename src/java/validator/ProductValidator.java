package validator;


import model.Product;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ProductValidator implements Validator{
    
    

    @Override
    public boolean supports(Class<?> type) {
        return Product.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        boolean f=true;
        Product product = (Product)o;
        if(product==null){
            f=true;
        }
        else{
            errors.rejectValue("product.productCode","pcode.exist");
        }
        
    }
    
}
