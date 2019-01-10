package controller;

import dao.AlloyDao;
import dao.ProducerDao;
import dao.ProductDao;
import dao.StoneDao;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import wrapper.WrapperStock;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
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
    private ProducerDao producerDao;
    @Autowired
    private StoneDao stonedao;
    
   
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
        
       
        if(bindingResult.hasErrors()) return "CreatePro";
        else{
             writeIntoFile(file);  
             Product pr=combined.getProduct();
             productvalidator.validate(productDao.findproduct(pr.getProductCode()), bindingResult);
             alloydao.addAlloy(combined.getAlloy());
             productDao.addnewProductToDatabase(SetNewProduct(file, combined));
             stonedao.addStone(NewStone(pr),stoneDescr,weights,quantities);
             map.addAttribute("mystock", new WrapperStock());
             map.addAttribute("creation",pr);       
             return "stock";
        }
    }
    
    public void writeIntoFile(CommonsMultipartFile file) throws FileNotFoundException, IOException{
        String filename = file.getOriginalFilename();
        if(!file.isEmpty()){
            byte[] bytes = file.getBytes();  
            BufferedOutputStream stream =new BufferedOutputStream(new FileOutputStream(  
            new File(UPLOAD_DIRECTORY + File.separator + filename))); 
            stream.write(bytes);  
            stream.flush();  
            stream.close();  
        }   
    }
    
    public Product setProductImage(Product pr,CommonsMultipartFile file ){
         String filename = file.getOriginalFilename();
         if(filename.equals("")){
           pr.setImg("noimage.png");
         }
         else{
           pr.setImg(filename);
         }
         return pr;
    }
    
    public Product SetNewProduct(CommonsMultipartFile file, WrapperProduct combined ){
          Product pr=combined.getProduct();
          pr = setProductImage(pr,file);
          pr.setCategoryId(combined.getCategory());
          pr.setProducerCode(combined.getProducer());
          pr.setAlloyId(combined.getAlloy());
          return pr;
    }
    
    public Stone NewStone(Product pr){
         Stone stone = new Stone();
         stone.setProductCode(pr);
         return stone;
        
    }
      
           
}

