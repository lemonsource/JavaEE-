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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author familywang
 */
@Entity
@Table(name = "USERINFO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Userinfo.findAll", query = "SELECT u FROM Userinfo u")
    , @NamedQuery(name = "Userinfo.findByUserid", query = "SELECT u FROM Userinfo u WHERE u.userid = :userid")
    , @NamedQuery(name = "Userinfo.findByLastname", query = "SELECT u FROM Userinfo u WHERE u.lastname = :lastname")
    , @NamedQuery(name = "Userinfo.findByFirstname", query = "SELECT u FROM Userinfo u WHERE u.firstname = :firstname")
    , @NamedQuery(name = "Userinfo.findByEmail", query = "SELECT u FROM Userinfo u WHERE u.email = :email")
    , @NamedQuery(name = "Userinfo.findByPassword", query = "SELECT u FROM Userinfo u WHERE u.password = :password")
    , @NamedQuery(name = "Userinfo.findByMembershiplevel", query = "SELECT u FROM Userinfo u WHERE u.membershiplevel = :membershiplevel")
    , @NamedQuery(name = "Userinfo.findByAddress", query = "SELECT u FROM Userinfo u WHERE u.address = :address")
    , @NamedQuery(name = "Userinfo.findByPhonenumber", query = "SELECT u FROM Userinfo u WHERE u.phonenumber = :phonenumber")
    , @NamedQuery(name = "Userinfo.findByAvailablecredits", query = "SELECT u FROM Userinfo u WHERE u.availablecredits = :availablecredits")
//    , @NamedQuery(name = "Userinfo.findPocessionByuserid", query = "SELECT c FROM Commodityinfo c , Pocession p WHERE p.userid.userid = :userid AND c.commodityid = : p.commodityid")
})
public class Userinfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "USERID")
    private Integer userid;
    @Column(name = "LASTNAME")
//    @Pattern(regexp = "^[A-Za-z]+$",message="Lastname Only can have letter,cannot be null!")
    private String lastname;
    @Column(name = "FIRSTNAME")
//    @Pattern(regexp = "^[A-Za-z]+$",message="Lastname Only can have letter,cannot be null!")
    private String firstname;
    @Column(name = "EMAIL")
    @Pattern(regexp ="[A-Za-z0-9\\u4e00-\\u9fa5]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$",message ="You must enter an valid email! " )
    private String email;
    @Column(name = "PASSWORD")
    @Pattern(regexp ="((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,20})", message = "Password required 8 to 20 characters string with at least one digit, one upper case letter, one lower case letter! ")
    private String password;
    @Column(name = "MEMBERSHIPLEVEL")
    private Integer membershiplevel;//1 represents superadministrator, 2 represents administor, 3 represents trader, 4 represents visitor
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "PHONENUMBER")
//    @Pattern(regexp = "^(9([0-9]{7}))$|^(0([0-9]{9}))$", message = "Phonenumber should be like 9xxxxxxx or 0xxxxxxxxx")
    private String phonenumber;
    @Column(name = "AVAILABLECREDITS")
    private Integer availablecredits;
    @OneToMany(mappedBy = "userid")
    private Collection<Pocession> pocessionCollection;
    @OneToMany(mappedBy = "userid")
    private Collection<Orders> ordersCollection;

    public Userinfo() {
    }

    public Userinfo(Integer userid) {
        this.userid = userid;
    }

    public Userinfo(Integer userid, String lastname, String firstname, String email, String password, Integer membershiplevel, String address, String phonenumber, Integer availablecredits) {
        this.userid = userid;
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
        this.password = password;
        this.membershiplevel = membershiplevel;
        this.address = address;
        this.phonenumber = phonenumber;
        this.availablecredits = availablecredits;
    }
    
    

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getMembershiplevel() {
        return membershiplevel;
    }

    public void setMembershiplevel(Integer membershiplevel) {
        this.membershiplevel = membershiplevel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public Integer getAvailablecredits() {
        return availablecredits;
    }

    public void setAvailablecredits(Integer availablecredits) {
        this.availablecredits = availablecredits;
    }

    @XmlTransient
    public Collection<Pocession> getPocessionCollection() {
        return pocessionCollection;
    }

    public void setPocessionCollection(Collection<Pocession> pocessionCollection) {
        this.pocessionCollection = pocessionCollection;
    }

    @XmlTransient
    public Collection<Orders> getOrdersCollection() {
        return ordersCollection;
    }

    public void setOrdersCollection(Collection<Orders> ordersCollection) {
        this.ordersCollection = ordersCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userid != null ? userid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Userinfo)) {
            return false;
        }
        Userinfo other = (Userinfo) object;
        if ((this.userid == null && other.userid != null) || (this.userid != null && !this.userid.equals(other.userid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fit5192.assignment.repository.entities.Userinfo[ userid=" + userid + " ]";
    }
    
}
