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
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Katy
 */
@Entity
@Table(name = "product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p")})
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "product_code")
    private String productCode;
    @Column(name = "price")
    private String price;
    @Column(name = "cost_eu")
    private String costEu;
    @Column(name = "cost_usd")
    private String costUsd;
    @Column(name = "item_desc")
    private String itemDesc;
    @Lob
    @Column(name = "img")
    private String img;
    @JoinColumn(name = "alloy_id", referencedColumnName = "alloy_id")
    @ManyToOne
    private Alloy alloyId;
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    @ManyToOne(optional = false)
    private Category categoryId;
    @JoinColumn(name = "producer_code", referencedColumnName = "producer_code")
    @ManyToOne(optional = false)
    private Producer producerCode;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productCode", fetch = FetchType.EAGER)
    private Collection<Stock> stockCollection;
    @OneToMany(mappedBy = "productCode", fetch = FetchType.EAGER)
    private Collection<Stone> stoneCollection;

    public Product() {
    }

    public Product(String productCode) {
        this.productCode = productCode;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCostEu() {
        return costEu;
    }

    public void setCostEu(String costEu) {
        this.costEu = costEu;
    }

    public String getCostUsd() {
        return costUsd;
    }

    public void setCostUsd(String costUsd) {
        this.costUsd = costUsd;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Alloy getAlloyId() {
        return alloyId;
    }

    public void setAlloyId(Alloy alloyId) {
        this.alloyId = alloyId;
    }

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }

    public Producer getProducerCode() {
        return producerCode;
    }

    public void setProducerCode(Producer producerCode) {
        this.producerCode = producerCode;
    }

    @XmlTransient
    public Collection<Stock> getStockCollection() {
        return stockCollection;
    }

    public void setStockCollection(Collection<Stock> stockCollection) {
        this.stockCollection = stockCollection;
    }

    @XmlTransient
    public Collection<Stone> getStoneCollection() {
        return stoneCollection;
    }

    public void setStoneCollection(Collection<Stone> stoneCollection) {
        this.stoneCollection = stoneCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productCode != null ? productCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.productCode == null && other.productCode != null) || (this.productCode != null && !this.productCode.equals(other.productCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + productCode ;
    }
    
}
