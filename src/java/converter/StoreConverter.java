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
 * @author Katy
 */
@Component
public class StoreConverter implements Converter <Integer, Store>{
    
    @Autowired 
    StoreDao storedao;

    @Override
    public Store convert(Integer s) {
        return storedao.findstore(s);
    }
    
    public Store convertWithoutDb(Integer s){
        Store store = new Store();
        store.setStoreId(s);
        return store;
    }
    
    
}
