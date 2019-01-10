
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author chern
 */
@Entity
@Table(name = "ProductView")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductView.findAll", query = "SELECT p FROM ProductView p")})
public class ProductView implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Id
    @Column(name = "product_code")
    private String productCode;
    @Column(name = "stone_desc")
    private String stoneDesc;
    @Column(name = "pcolor")
    private String pcolor;

    public ProductView() {
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getStoneDesc() {
        return stoneDesc;
    }

    public void setStoneDesc(String stoneDesc) {
        this.stoneDesc = stoneDesc;
    }

    public String getPcolor() {
        return pcolor;
    }

    public void setPcolor(String pcolor) {
        this.pcolor = pcolor;
    }
    
}
