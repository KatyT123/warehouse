package controller;

import java.io.IOException;
import javax.servlet.http.HttpSession;
import model.Store;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author chern
 */
@Controller
public class LogoutController {
    
    
    @RequestMapping(value="/logout.htm", method=RequestMethod.GET)
    public String loginStore(ModelMap map,HttpSession session) throws IOException{
        
        session.invalidate();
        Store store= new Store();
        map.addAttribute("emptystore", store);
        return "loginForm";
        
    }
    
    
    
}
