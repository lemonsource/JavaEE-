/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.assignment.managebeans;

import fit5192.assignment.repository.CommodityRepository;
import fit5192.assignment.repository.entities.Userinfo;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.servlet.http.HttpSession;

/**
 *
 * @author familywang
 */
@Named(value = "addUserManagedBean")
@ManagedBean
@SessionScoped
public class AddUserManagedBean implements Serializable {

    @EJB
    private  CommodityRepository commodityrepository;
    private HttpSession session;
    
    private Userinfo user;
    
    private Integer userid;
    private String lastname;
    private String firstname;
    private String email;
    private String password;
    private Integer membershiplevel;
    private String address;
    private String phonenumber;
    private Integer availablecredits;
    /**
     * Creates a new instance of AddUserManagedBean
     */
    public AddUserManagedBean() {
    }
    public String addUser(){
         Userinfo adduser =new Userinfo(this.userid, this.lastname, this.firstname, this.email, this.password, this.membershiplevel, this.address, this.phonenumber, this.availablecredits);
        this.commodityrepository.addUser(adduser);
        return "manageruser";
}

    
    
    

    public CommodityRepository getCommodityrepository() {
        return commodityrepository;
    }

    public void setCommodityrepository(CommodityRepository commodityrepository) {
        this.commodityrepository = commodityrepository;
    }

    public HttpSession getSession() {
        return session;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }

    public Userinfo getUser() {
        return user;
    }

    public void setUser(Userinfo user) {
        this.user = user;
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
    
    
}
