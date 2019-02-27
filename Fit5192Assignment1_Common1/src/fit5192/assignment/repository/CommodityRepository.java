/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.assignment.repository;

import fit5192.assignment.repository.entities.Commodityinfo;
import fit5192.assignment.repository.entities.Pocession;
import fit5192.assignment.repository.entities.Userinfo;
import java.util.List;
import javax.ejb.Remote;


 
/**
 *
 * @author familywang
 */
@Remote
public interface CommodityRepository {
     public List<Commodityinfo> getAllCommodities();
     public Commodityinfo SearchById(int commodityid);
     public List<Commodityinfo> SearchCommodityById(int commodityid);
     public List<Commodityinfo> SearchByLabel(String label);
     public List<Commodityinfo> SearchByTitle(String title);
     public List<Commodityinfo> SearchByPrice(int price);
     public void AddCommodity(Commodityinfo commodity);
     public void EditCommodity(Commodityinfo commodity);
     public void RemoveCommodity(int commodityid);
     
    /***************************************************************************
        User entity
     * @param user
    ***************************************************************************/
    public void addUser(Userinfo user); 
    public List<Userinfo> searchUserById(int userid);
    public List<Userinfo> searchUserByEmail(String email);
    public List<Userinfo> checkLogin(String email, String password);
//    public Userinfo  searchUser(int id); 
    public List<Userinfo> getAllUsers();
    public void removeUser(int UserId);
    public List<Userinfo> searchUserUnion(int ID, String lastname, String firstname, String email, String password, String usertype,Integer phonenumber);
    public void updateUser(Userinfo user);
     public List<Userinfo> searchUserByFistName(String firstnamel);
     public List<Userinfo> searchUserByLastName(String lastname);
     public List<Userinfo> searchUserByPhoneNumber(String phonenumber);
     
     //
      public int getPocessionNum(int commodityid, int userid);
    public List<Pocession> searchPocessionById(int userid);
     public Userinfo BuyCommodity(int commodityid, int userid);
      public Userinfo SaleCommodity(int commodityid, int userid);
    /***************************************************************************
     * 
     * 
     */
}
