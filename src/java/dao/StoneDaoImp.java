package dao;

import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Stone;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class StoneDaoImp implements StoneDao{
    
    @PersistenceContext
    private EntityManager em;
    
    @Override
    @Transactional
    public void addStone(Stone stone,List stoneDescr,List weights,List quantities) {
        
        for(int i=0; i<stoneDescr.size(); i++){
            if(!stoneDescr.get(i).equals("") && !weights.get(i).equals("") && !quantities.get(i).equals("")){
                 
                String w=weights.get(i).toString();
                String qu=quantities.get(i).toString();     
                int q=(int) Float.parseFloat(qu);                     
                stone.setStoneDesc((String) stoneDescr.get(i));
                stone.setStoneWeight(new BigDecimal(w));
                stone.setStoneQuant(q);
                em.merge(stone);
            } 
        }  
    }
    
    
}
