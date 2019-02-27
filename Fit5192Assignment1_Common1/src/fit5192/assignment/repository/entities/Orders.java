/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.assignment.repository.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "ORDERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orders.findAll", query = "SELECT o FROM Orders o")
    , @NamedQuery(name = "Orders.findByOrdersid", query = "SELECT o FROM Orders o WHERE o.ordersid = :ordersid")
    , @NamedQuery(name = "Orders.findByDatetime", query = "SELECT o FROM Orders o WHERE o.datetime = :datetime")})
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ORDERSID")
    private Integer ordersid;
    @Column(name = "DATETIME")
    private String datetime;
    @JoinColumn(name = "USERID", referencedColumnName = "USERID")
    @ManyToOne
    private Userinfo userid;
    @OneToMany(mappedBy = "ordersid")
    private Collection<Ordersdetail> ordersdetailCollection;

    public Orders() {
    }

    public Orders(Integer ordersid) {
        this.ordersid = ordersid;
    }

    public Integer getOrdersid() {
        return ordersid;
    }

    public void setOrdersid(Integer ordersid) {
        this.ordersid = ordersid;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public Userinfo getUserid() {
        return userid;
    }

    public void setUserid(Userinfo userid) {
        this.userid = userid;
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
        hash += (ordersid != null ? ordersid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orders)) {
            return false;
        }
        Orders other = (Orders) object;
        if ((this.ordersid == null && other.ordersid != null) || (this.ordersid != null && !this.ordersid.equals(other.ordersid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fit5192.assignment.repository.entities.Orders[ ordersid=" + ordersid + " ]";
    }
    
}
