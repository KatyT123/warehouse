/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author chern
 */
@Entity
@Table(name = "stone")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stone.findAll", query = "SELECT s FROM Stone s")})
public class Stone implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "stone_weight")
    private String stoneWeight;
    @Column(name = "stone_quant")
    private Integer stoneQuant;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "stone_id")
    private Integer stoneId;
    @Column(name = "stone_desc")
    private String stoneDesc;
    @JoinColumn(name = "product_code", referencedColumnName = "product_code")
    @ManyToOne
    private Product productCode;

    public Stone() {
    }

    public Stone(Integer stoneId) {
        this.stoneId = stoneId;
    }

    public String getStoneWeight() {
        return stoneWeight;
    }

    public void setStoneWeight(String stoneWeight) {
        this.stoneWeight = stoneWeight;
    }

    public Integer getStoneQuant() {
        return stoneQuant;
    }

    public void setStoneQuant(Integer stoneQuant) {
        this.stoneQuant = stoneQuant;
    }

    public Integer getStoneId() {
        return stoneId;
    }

    public void setStoneId(Integer stoneId) {
        this.stoneId = stoneId;
    }

    public String getStoneDesc() {
        return stoneDesc;
    }

    public void setStoneDesc(String stoneDesc) {
        this.stoneDesc = stoneDesc;
    }

    public Product getProductCode() {
        return productCode;
    }

    public void setProductCode(Product productCode) {
        this.productCode = productCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stoneId != null ? stoneId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stone)) {
            return false;
        }
        Stone other = (Stone) object;
        if ((this.stoneId == null && other.stoneId != null) || (this.stoneId != null && !this.stoneId.equals(other.stoneId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Stone[ stoneId=" + stoneId + " ]";
    }
    
}
