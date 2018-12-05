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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author chern
 */
@Entity
@Table(name = "producer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producer.findAll", query = "SELECT p FROM Producer p")})
public class Producer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "producer_code")
    private String producerCode;
    @Column(name = "producer_name")
    private String producerName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producerCode")
    private Collection<Product> productCollection;

    public Producer() {
    }

    public Producer(String producerCode) {
        this.producerCode = producerCode;
    }

    public String getProducerCode() {
        return producerCode;
    }

    public void setProducerCode(String producerCode) {
        this.producerCode = producerCode;
    }

    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
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
        hash += (producerCode != null ? producerCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producer)) {
            return false;
        }
        Producer other = (Producer) object;
        if ((this.producerCode == null && other.producerCode != null) || (this.producerCode != null && !this.producerCode.equals(other.producerCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Producer[ producerCode=" + producerCode + " ]";
    }
    
}
