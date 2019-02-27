/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.assignment.repository.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.logging.Logger;
import javax.persistence.Basic;
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
 * @author familywang
 */
@Entity
@Table(name = "COMMODITYINFO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Commodityinfo.findAll", query = "SELECT c FROM Commodityinfo c")
    , @NamedQuery(name = "Commodityinfo.findByCommodityid", query = "SELECT c FROM Commodityinfo c WHERE c.commodityid = :commodityid")
    , @NamedQuery(name = "Commodityinfo.findByLabel", query = "SELECT c FROM Commodityinfo c WHERE c.label = :label")
    , @NamedQuery(name = "Commodityinfo.findByTitle", query = "SELECT c FROM Commodityinfo c WHERE c.title = :title")
    , @NamedQuery(name = "Commodityinfo.findByThumbnailimage", query = "SELECT c FROM Commodityinfo c WHERE c.thumbnailimage = :thumbnailimage")
    , @NamedQuery(name = "Commodityinfo.findByPrice", query = "SELECT c FROM Commodityinfo c WHERE c.price = :price")
    , @NamedQuery(name = "Commodityinfo.findByItemsnum", query = "SELECT c FROM Commodityinfo c WHERE c.itemsnum = :itemsnum")
    , @NamedQuery(name = "Commodityinfo.findByItemstotalnum", query = "SELECT c FROM Commodityinfo c WHERE c.itemstotalnum = :itemstotalnum")
    , @NamedQuery(name = "Commodityinfo.findByDescription", query = "SELECT c FROM Commodityinfo c WHERE c.description = :description")
    , @NamedQuery(name = "Commodityinfo.findByMaterial", query = "SELECT c FROM Commodityinfo c WHERE c.material = :material")
    , @NamedQuery(name = "Commodityinfo.findByGrades", query = "SELECT c FROM Commodityinfo c WHERE c.grades = :grades")
    , @NamedQuery(name = "Commodityinfo.findByAuthor", query = "SELECT c FROM Commodityinfo c WHERE c.author = :author")})
public class Commodityinfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "COMMODITYID")
    private Integer commodityid;
    @Column(name = "LABEL")
    private String label;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "THUMBNAILIMAGE")
    private String thumbnailimage;
    @Column(name = "PRICE")
    private Integer price;
    @Column(name = "ITEMSNUM")
    private Integer itemsnum;
    @Column(name = "ITEMSTOTALNUM")
    private Integer itemstotalnum;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "MATERIAL")
    private String material;
    @Column(name = "GRADES")
    private Integer grades;
    @Column(name = "AUTHOR")
    private String author;
    @OneToMany(mappedBy = "commodityid")
    private Collection<Pocession> pocessionCollection;
    @OneToMany(mappedBy = "commodityid")
    private Collection<Ordersdetail> ordersdetailCollection;

    public Commodityinfo() {
    }

    public Commodityinfo(Integer commodityid) {
        this.commodityid = commodityid;
    }

    public Integer getCommodityid() {
        return commodityid;
    }

    public void setCommodityid(Integer commodityid) {
        this.commodityid = commodityid;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnailimage() {
        return thumbnailimage;
    }

    public void setThumbnailimage(String thumbnailimage) {
        this.thumbnailimage = thumbnailimage;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getItemsnum() {
        return itemsnum;
    }

    public void setItemsnum(Integer itemsnum) {
        this.itemsnum = itemsnum;
    }

    public Integer getItemstotalnum() {
        return itemstotalnum;
    }

    public void setItemstotalnum(Integer itemstotalnum) {
        this.itemstotalnum = itemstotalnum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Integer getGrades() {
        return grades;
    }

    public void setGrades(Integer grades) {
        this.grades = grades;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @XmlTransient
    public Collection<Pocession> getPocessionCollection() {
        return pocessionCollection;
    }

    public void setPocessionCollection(Collection<Pocession> pocessionCollection) {
        this.pocessionCollection = pocessionCollection;
    }

    @XmlTransient
    public Collection<Ordersdetail> getOrdersdetailCollection() {
        return ordersdetailCollection;
    }

    public void setOrdersdetailCollection(Collection<Ordersdetail> ordersdetailCollection) {
        this.ordersdetailCollection = ordersdetailCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (commodityid != null ? commodityid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Commodityinfo)) {
            return false;
        }
        Commodityinfo other = (Commodityinfo) object;
        if ((this.commodityid == null && other.commodityid != null) || (this.commodityid != null && !this.commodityid.equals(other.commodityid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fit5192.assignment.repository.entities.Commodityinfo[ commodityid=" + commodityid + itemstotalnum + " ]";
    }
    
    
    
}
