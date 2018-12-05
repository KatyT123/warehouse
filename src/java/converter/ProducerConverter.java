/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import dao.ProducerDao;
import model.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 *
 * @author chern
 */
@Component
public class ProducerConverter implements Converter<String, Producer>{
    
    @Autowired 
         ProducerDao producerdao;

    @Override
    public Producer convert(String producerCode) {
        
        return producerdao.GetProducer(producerCode);

    }
    
}
