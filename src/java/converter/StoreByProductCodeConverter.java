/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import dao.StoreDao;
import model.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 *
 * @author chern
 */
@Component
public class StoreByProductCodeConverter implements Converter <String, Store>{
    
    @Autowired 
    StoreDao storedao;

    @Override
    public Store convert(String s) {
       return storedao.GetStoreByProductCode(s);
    }
}
