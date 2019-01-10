/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Comparator;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author chern
 */
@Entity
@Table(name = "alloy")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alloy.findAll", query = "SELECT a FROM Alloy a")})
public class Alloy implements Serializable, Comparator<Alloy> {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "alloy_id")
    private Integer alloyId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "gold_weight")
    private BigDecimal goldWeight;
    @Column(name = "silver_weight")
    private BigDecimal silverWeight;
    @Column(name = "karats")
    private Integer karats;
    @OneToMany(mappedBy = "alloyId")
    private Collection<Product> productCollection;

    public Alloy() {
    }

    public Alloy(Integer alloyId) {
        this.alloyId = alloyId;
    }

    public Integer getAlloyId() {
        return alloyId;
    }

    public void setAlloyId(Integer alloyId) {
        this.alloyId = alloyId;
    }

    public BigDecimal getGoldWeight() {
        return goldWeight;
    }

    public void setGoldWeight(BigDecimal goldWeight) {
        this.goldWeight = goldWeight;
    }

    public BigDecimal getSilverWeight() {
        return silverWeight;
    }

    public void setSilverWeight(BigDecimal silverWeight) {
        this.silverWeight = silverWeight;
    }

    public Integer getKarats() {
        return karats;
    }

    public void setKarats(Integer karats) {
        this.karats = karats;
    }

    @XmlTransient
    public Collection<Product> getProductCollection() {
        return productCollection;
    }

    public void setProductCollection(Collection<Product> productCollection) {
        this.productCollection = productCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (alloyId != null ? alloyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alloy)) {
            return false;
        }
        Alloy other = (Alloy) object;
        if ((this.alloyId == null && other.alloyId != null) || (this.alloyId != null && !this.alloyId.equals(other.alloyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + alloyId ;
    }

    @Override
    public int compare(Alloy a, Alloy a1) {
       return (a.alloyId - a1.alloyId); 
    }

   
}
