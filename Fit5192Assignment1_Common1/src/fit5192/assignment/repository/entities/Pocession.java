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
@Table(name = "POCESSION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pocession.findAll", query = "SELECT p FROM Pocession p")
    , @NamedQuery(name = "Pocession.findByPocessionid", query = "SELECT p FROM Pocession p WHERE p.pocessionid = :pocessionid")
    , @NamedQuery(name = "Pocession.findByPocessionnum", query = "SELECT p FROM Pocession p WHERE p.pocessionnum = :pocessionnum")
    , @NamedQuery(name = "Pocession.findPocessionByUserid", query = "SELECT p FROM Pocession p WHERE p.userid.userid = :userid")
    , @NamedQuery(name = "Pocession.findPocessionByUserid&Commodityid", query = "SELECT p FROM Pocession p WHERE p.userid.userid = :userid AND p.commodityid.commodityid =:commodityid")})
public class Pocession implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "POCESSIONID")
    private Integer pocessionid;
    @Column(name = "POCESSIONNUM")
    private Integer pocessionnum;
    @JoinColumn(name = "COMMODITYID", referencedColumnName = "COMMODITYID")
    @ManyToOne
    private Commodityinfo commodityid;
    @JoinColumn(name = "USERID", referencedColumnName = "USERID")
    @ManyToOne
    private Userinfo userid;

    public Pocession() {
    }

    public Pocession(Integer pocessionid, Integer pocessionnum, Commodityinfo commodityid, Userinfo userid) {
        this.pocessionid = pocessionid;
        this.pocessionnum = pocessionnum;
        this.commodityid = commodityid;
        this.userid = userid;
    }
    
    

    public Pocession(Integer pocessionid) {
        this.pocessionid = pocessionid;
    }

    public Integer getPocessionid() {
        return pocessionid;
    }

    public void setPocessionid(Integer pocessionid) {
        this.pocessionid = pocessionid;
    }
    
    public void addPocession(){
        this.pocessionnum++;
    }
    public void subPocession(){
        this.pocessionnum--;
    }

    public Integer getPocessionnum() {
        return pocessionnum;
    }

    public void setPocessionnum(Integer pocessionnum) {
        this.pocessionnum = pocessionnum;
    }

    public Commodityinfo getCommodityid() {
        return commodityid;
    }

    public void setCommodityid(Commodityinfo commodityid) {
        this.commodityid = commodityid;
    }

    public Userinfo getUserid() {
        return userid;
    }

    public void setUserid(Userinfo userid) {
        this.userid = userid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pocessionid != null ? pocessionid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pocession)) {
            return false;
        }
        Pocession other = (Pocession) object;
        if ((this.pocessionid == null && other.pocessionid != null) || (this.pocessionid != null && !this.pocessionid.equals(other.pocessionid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fit5192.assignment.repository.entities.Pocession[ pocessionid=" + pocessionid + " ]";
    }
    
}
