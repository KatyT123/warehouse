/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 *
 * @author Tasos
 */
@Controller
public class fileUploadAjax {
    
    
    @RequestMapping(value = "fileUpload", method = RequestMethod.POST)
    public ResponseEntity<String> fileUpload(@RequestParam CommonsMultipartFile file) throws IOException {
        
        // Save file on system
        if (!file.getOriginalFilename().isEmpty()) {
            BufferedOutputStream outputStream = new BufferedOutputStream(
            new FileOutputStream(new File("C:/Tomcat/webapps/images", file.getOriginalFilename())));
            outputStream.write(file.getBytes());
            outputStream.flush();
            outputStream.close();
        } 
        else  return new ResponseEntity<>("Invalid file.", HttpStatus.BAD_REQUEST);
        
        return new ResponseEntity<>("File Uploaded Successfully.", HttpStatus.OK);
    }
}

