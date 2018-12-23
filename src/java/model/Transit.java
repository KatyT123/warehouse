/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Katy
 */
@Entity
@Table(name = "transit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transit.findAll", query = "SELECT t FROM Transit t")})
public class Transit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "status")
    private Boolean status;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "transit_id")
    private Integer transitId;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Column(name = "transit_desc")
    private String transitDesc;
    @JoinColumn(name = "receiving_store", referencedColumnName = "store_id")
    @ManyToOne
    private Store receivingStore;
    @JoinColumn(name = "sender_store", referencedColumnName = "store_id")
    @ManyToOne
    private Store senderStore;

    public Transit() {
    }

    public Transit(Integer transitId) {
        this.transitId = transitId;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getTransitId() {
        return transitId;
    }

    public void setTransitId(Integer transitId) {
        this.transitId = transitId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTransitDesc() {
        return transitDesc;
    }

    public void setTransitDesc(String transitDesc) {
        this.transitDesc = transitDesc;
    }

    public Store getReceivingStore() {
        return receivingStore;
    }

    public void setReceivingStore(Store receivingStore) {
        this.receivingStore = receivingStore;
    }

    public Store getSenderStore() {
        return senderStore;
    }

    public void setSenderStore(Store senderStore) {
        this.senderStore = senderStore;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transitId != null ? transitId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transit)) {
            return false;
        }
        Transit other = (Transit) object;
        if ((this.transitId == null && other.transitId != null) || (this.transitId != null && !this.transitId.equals(other.transitId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + transitId ;
    }
    
}
