/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author chern
 */
@Entity
@Table(name = "store")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Store.findAll", query = "SELECT s FROM Store s")})
public class Store implements Serializable {

    @Column(name = "force_pass_change")
    private Boolean forcePassChange;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "store_id")
    private Integer storeId;
    @Column(name = "location")
    private String location;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @OneToMany(mappedBy = "receivingStore")
    private Collection<Transit> transitCollection;
    @OneToMany(mappedBy = "senderStore")
    private Collection<Transit> transitCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "storeId")
    private Collection<Stock> stockCollection;
    
    @Transient                      //allagh
   private String confirmpassword;

   public String getConfirmpassword() {
       return confirmpassword;
   }

   public void setConfirmpassword(String confirmpassword) {
       this.confirmpassword = confirmpassword;
   }

    public Store() {
    }

    public Store(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlTransient
    public Collection<Transit> getTransitCollection() {
        return transitCollection;
    }

    public void setTransitCollection(Collection<Transit> transitCollection) {
        this.transitCollection = transitCollection;
    }

    @XmlTransient
    public Collection<Transit> getTransitCollection1() {
        return transitCollection1;
    }

    public void setTransitCollection1(Collection<Transit> transitCollection1) {
        this.transitCollection1 = transitCollection1;
    }

    @XmlTransient
    public Collection<Stock> getStockCollection() {
        return stockCollection;
    }

    public void setStockCollection(Collection<Stock> stockCollection) {
        this.stockCollection = stockCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (storeId != null ? storeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Store)) {
            return false;
        }
        Store other = (Store) object;
        if ((this.storeId == null && other.storeId != null) || (this.storeId != null && !this.storeId.equals(other.storeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + storeId ;
    }

    public Boolean getForcePassChange() {
        return forcePassChange;
    }

    public void setForcePassChange(Boolean forcePassChange) {
        this.forcePassChange = forcePassChange;
    }
    
}
