package controller;

import dao.AlloyDao;
import dao.CategoryDao;
import dao.ProducerDao;
import dao.ProductDao;
import dao.StoneDao;
import dao.StoreDao;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import wrapper.WrapperStock;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import model.Alloy;
import model.Category;
import wrapper.WrapperProduct;
import model.Producer;
import model.Product;
import model.Stone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import validator.ProductValidator;

@Controller
public class ProductController {
    
    private static final String UPLOAD_DIRECTORY ="C:/Tomcat/webapps/images/";  
    
    @Autowired
    private ProductValidator productvalidator;
    
    
    
    @Autowired 
    ServletContext servletContext;
    
    
     @Autowired
     private AlloyDao alloydao;
    
     @Autowired
     private ProductDao productDao;
    
    @Autowired
     private CategoryDao categoryDao;
    
    @Autowired
     private ProducerDao producerDao;
    
    
    
    @Autowired
    private StoreDao storeDao;
    
    @Autowired
    private StoneDao stonedao;
    
    
   @RequestMapping(value="/LoginController.htm", method=RequestMethod.POST)
    public String doLogin(ModelMap map) throws IOException{
        
        //alloydao.addAlloy();
        
             return "index";
    }
    @RequestMapping(value="/creator.htm", method=RequestMethod.GET)
    public String createProductInStore(ModelMap map) throws IOException{
       
        WrapperProduct product= new WrapperProduct();
        map.addAttribute("combined", product);
        ArrayList<Producer> producers = producerDao.getProducers();
        map.addAttribute("producers",producers);
        List stoneDescr = new ArrayList();
        map.addAttribute("stoneDescr",stoneDescr);
        List weight = new ArrayList();
        map.addAttribute("weight",weight);
        List quantity = new ArrayList();
        map.addAttribute("quantity",quantity);
       
        
             return "CreatePro";
    }
    
    
    @RequestMapping(value="/creationhandler.htm", method=RequestMethod.POST)
    public String characteristicsOfproductCreation(@Valid @ModelAttribute("combined") WrapperProduct combined, BindingResult bindingResult,ModelMap map,@RequestParam(value="stoneDescr") List stoneDescr,
            @RequestParam(value="weight") List weights,@RequestParam(value="quantity") List quantities,@RequestParam CommonsMultipartFile file,HttpSession session) throws IOException{
        
        String name=file.getName(); 
        String filename = file.getOriginalFilename();
        if(!file.isEmpty()){
            byte[] bytes = file.getBytes();  
        BufferedOutputStream stream =new BufferedOutputStream(new FileOutputStream(  
         new File(UPLOAD_DIRECTORY + File.separator + filename))); //anti gia UPLOAD_DIRECTORY evaze to path giati??
            
            stream.write(bytes);  
            stream.flush();  
            stream.close();  
        }         
        
                
        Category cat=combined.getCategory();
        
        Product pr=combined.getProduct();
        String pcode=pr.getProductCode();
        
        if(filename.equals("")){
           pr.setImg("noimage.png");
       }else{
          pr.setImg(filename);
       }
        
        productvalidator.validate(productDao.findproduct(pcode), bindingResult);
        if(bindingResult.hasErrors()){
           
            return "CreatePro";
        }
        else{
    
        
        pr.setCategoryId(cat);
        
        
        Producer producer=combined.getProducer();
        pr.setProducerCode(producer);
        
        Alloy alloy=combined.getAlloy();
        pr.setAlloyId(alloy);
        
        Stone stone = new Stone();
        stone.setProductCode(pr);
        
        
        alloydao.addAlloy(alloy);
        productDao.addnewProductToDatabase(pr);
        stonedao.addStone(stone,stoneDescr,weights,quantities);
        
        }  
        
        
        WrapperStock mystock= new WrapperStock();
        map.addAttribute("mystock", mystock);
        map.addAttribute("creation",pr);
                    
    return "stock";
    }
    
    
    
    
    
    
    
    
    
           
}

