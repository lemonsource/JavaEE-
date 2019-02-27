/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.assignment.repository.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author familywang
 */
@Entity
@Table(name = "ORDERSDETAIL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ordersdetail.findAll", query = "SELECT o FROM Ordersdetail o")
    , @NamedQuery(name = "Ordersdetail.findByOrdersdetailid", query = "SELECT o FROM Ordersdetail o WHERE o.ordersdetailid = :ordersdetailid")
    , @NamedQuery(name = "Ordersdetail.findByType", query = "SELECT o FROM Ordersdetail o WHERE o.type = :type")
    , @NamedQuery(name = "Ordersdetail.findByNumber", query = "SELECT o FROM Ordersdetail o WHERE o.number = :number")})
public class Ordersdetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ORDERSDETAILID")
    private Integer ordersdetailid;
    @Column(name = "TYPE")
    private Integer type;
    @Column(name = "NUMBER")
    private Integer number;
    @JoinColumn(name = "COMMODITYID", referencedColumnName = "COMMODITYID")
    @ManyToOne
    private Commodityinfo commodityid;
    @JoinColumn(name = "ORDERSID", referencedColumnName = "ORDERSID")
    @ManyToOne
    private Orders ordersid;

    public Ordersdetail() {
    }

    public Ordersdetail(Integer ordersdetailid) {
        this.ordersdetailid = ordersdetailid;
    }

    public Integer getOrdersdetailid() {
        return ordersdetailid;
    }

    public void setOrdersdetailid(Integer ordersdetailid) {
        this.ordersdetailid = ordersdetailid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Commodityinfo getCommodityid() {
        return commodityid;
    }

    public void setCommodityid(Commodityinfo commodityid) {
        this.commodityid = commodityid;
    }

    public Orders getOrdersid() {
        return ordersid;
    }

    public void setOrdersid(Orders ordersid) {
        this.ordersid = ordersid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ordersdetailid != null ? ordersdetailid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ordersdetail)) {
            return false;
        }
        Ordersdetail other = (Ordersdetail) object;
        if ((this.ordersdetailid == null && other.ordersdetailid != null) || (this.ordersdetailid != null && !this.ordersdetailid.equals(other.ordersdetailid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fit5192.assignment.repository.entities.Ordersdetail[ ordersdetailid=" + ordersdetailid + " ]";
    }
    
}
