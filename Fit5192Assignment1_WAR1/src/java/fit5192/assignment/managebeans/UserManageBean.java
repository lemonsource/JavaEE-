/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.assignment.managebeans;

import fit5192.assignment.repository.CommodityRepository;
import fit5192.assignment.repository.entities.Commodityinfo;
import fit5192.assignment.repository.entities.Pocession;
import fit5192.assignment.repository.entities.Userinfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author familywang
 */
@Named(value = "userManageBean")
@ManagedBean
@SessionScoped
public class UserManageBean implements Serializable {
    @EJB
    private  CommodityRepository commodityrepository;
    private HttpSession session;

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
    
    private Userinfo user;
    private Userinfo adduser;
    private List<Userinfo> searchUserResult;
    private List<Commodityinfo> searchCommoditiesResult;
    private List<Pocession> searchPocessionResult;
    private Pocession addpocession;
    
    private Integer userid;
    private String lastname;
    private String firstname;
    private String email;
    private String password;
    private Integer membershiplevel;
    private String address;
    private String phonenumber;
    private Integer availablecredits;
    
    private String message_username;
    private String message_password;
    private String message_add;
    private String message_delete;
    /**
     * Creates a new instance of UserManageBean
     */
  

    public UserManageBean() {
    }

    

    
    
//    public UserManageBean(Userinfo user) {
//        this.user = user;
//        this.adduser = new Userinfo();
//        this.searchUserResult = new ArrayList<>();
//        this.message_username = "";
//        this.message_password = "";
//        this.message_add = "";
//        this.message_delete = "";
//    }
    
    
    
    
    

    public Userinfo getUser() {
        return user;
    }

    public void setUser(Userinfo user) {
        this.user = user;
    }
    
    public String checkLogin(){
        if(!this.commodityrepository.checkLogin(this.email, this.password).isEmpty()){
            this.user=this.commodityrepository.checkLogin(email, password).get(0);
            this.email="";
            this.userid=0;
            return "superadministrator";
        }else{
            return "loginFail";
        }
    }
    
    public String Logout(){
        return "index";
    }
    
    public String searchUserAll(){
        System.out.println("1111111111111111111");
        if(userid > 0){           
            System.out.println(this.commodityrepository.searchUserById(this.userid).toString());
            this.searchUserResult=this.commodityrepository.searchUserById(this.userid);
            this.userid=0;           
        }else  if(null!=email&&!email.isEmpty()){
                System.out.println("hahhaah");
                this.searchUserResult=this.commodityrepository.searchUserByEmail(this.email);
        }else if(null!=firstname&&!firstname.isEmpty()){
                 System.out.println(" Search user by firstname start"+this.firstname);
                 this.searchUserResult=this.commodityrepository.searchUserByFistName(firstname);
        }else if(null!=lastname&&!lastname.isEmpty()){
            System.out.println(" Search user by lastname start"+this.lastname);
            this.searchUserResult=this.commodityrepository.searchUserByLastName(lastname);
        }else if(null!=phonenumber&&!phonenumber.isEmpty()){
            System.out.println(" Search user by phonenumber start"+this.phonenumber);
            this.searchUserResult=this.commodityrepository.searchUserByPhoneNumber(phonenumber);
        }else {
            System.out.println(" No input");
        }                      
        return "manageruser";
    }
    
public String disPlayAllUsers(){
    this.searchUserResult=this.commodityrepository.getAllUsers();
    return "manageruser";
}
    
public String displayUserDetail(int DuserId){
    this.searchPocessionResult=this.commodityrepository.searchPocessionById(DuserId);
    return "userHomePage";
}

public String BuyCommodity( int commodityid){
        this.user=this.commodityrepository.BuyCommodity(commodityid, this.user.getUserid());
        this.searchPocessionResult=this.commodityrepository.searchPocessionById(this.user.getUserid());
        return "userHomePage";
    }
public int getPocessionNum(int commodityid){
    return this.commodityrepository.getPocessionNum(commodityid, this.user.getUserid());
}

public String SaleCommodity( int commodityid){
    this.user=this.commodityrepository.SaleCommodity(commodityid, this.user.getUserid());
    this.searchPocessionResult=this.commodityrepository.searchPocessionById(this.user.getUserid());
    return "userHomePage";
}


public String addUser(){
    this.commodityrepository.addUser(this.user);
    return "manageruser";
}
public String deleteUser(int userid){
    this.commodityrepository.removeUser(userid);
    return "manageruser";
}



    public List<Pocession> getSearchPocessionResult() {
        return searchPocessionResult;
    }

    public void setSearchPocessionResult(List<Pocession> searchPocessionResult) {
        this.searchPocessionResult = searchPocessionResult;
    }


        
    public Userinfo getAdduser() {
        return adduser;
    }

    public void setAdduser(Userinfo adduser) {
        this.adduser = adduser;
    }

    public List<Userinfo> getSearchUserResult() {
        return searchUserResult;
    }

    public void setSearchUserResult(List<Userinfo> searchUserResult) {
        this.searchUserResult = searchUserResult;
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

    public String getMessage_username() {
        return message_username;
    }

    public void setMessage_username(String message_username) {
        this.message_username = message_username;
    }

    public String getMessage_password() {
        return message_password;
    }

    public void setMessage_password(String message_password) {
        this.message_password = message_password;
    }

    public String getMessage_add() {
        return message_add;
    }

    public void setMessage_add(String message_add) {
        this.message_add = message_add;
    }

    public String getMessage_delete() {
        return message_delete;
    }

    public void setMessage_delete(String message_delete) {
        this.message_delete = message_delete;
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

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
    
    

    public List<Commodityinfo> getSearchCommoditiesResult() {
        return searchCommoditiesResult;
    }
    
    

    public void setSearchCommoditiesResult(List<Commodityinfo> searchCommoditiesResult) {
        this.searchCommoditiesResult = searchCommoditiesResult;
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

    public Integer getAvailablecredits() {
        return availablecredits;
    }

    public void setAvailablecredits(Integer availablecredits) {
        this.availablecredits = availablecredits;
    }
    
    
    
    
    
}
