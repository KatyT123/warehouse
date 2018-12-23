
package dao;

import java.util.ArrayList;
import model.Producer;

public interface ProducerDao {
    
    public ArrayList<Producer> getProducers();
    
    public Producer GetProducer(String producerCode);
}
