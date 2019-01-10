package controller;

import dao.StoreDao;
import java.io.IOException;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Katy
 */
@Controller
public class ChangePasswordController {
    
    @Autowired
     private StoreDao storeDao;
    
    
    
    @RequestMapping(value="/changepass.htm", method=RequestMethod.POST)
    public String changepassword(@RequestParam(value="password") String password,HttpSession session) throws IOException{
        
        String k="efe";
        String username=(String)session.getAttribute("username");
        storeDao.updatePasswordForFirstTimeAndBoolean(username, password);
        return "forward:/homeController.htm";  
    }
}
