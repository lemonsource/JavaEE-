/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.assignment.managebeans;

import fit5192.assignment.repository.CommodityRepository;
import fit5192.assignment.repository.entities.Commodityinfo;
import java.io.Serializable;
import java.util.List;
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
@Named(value = "commodityManageBean")
@ManagedBean
@SessionScoped
public class CommodityManageBean implements Serializable{
    @EJB
    private CommodityRepository commodityrepository;
    private HttpSession session;
    private Commodityinfo commodity;
    private List<Commodityinfo> searchcommodities;
    
    private int commodityid;
    private String title;
    private String label;
    private int price;
    
    private int availablenum;
    
    private String message_searchcommodity;
    private String message_updatecommodity;
    public CommodityManageBean() {
    }
    
    public String displayAllComodities(){
        this.searchcommodities=this.commodityrepository.getAllCommodities();
        return "superadministrator";
    }
    public String searchall(){
        System.out.println(this.title);
        if(this.commodityid>0){
            this.searchcommodities.add(0, this.searchCommodityById(this.commodityid));
        }else{
            if(this.price>0){
                if(!this.commodityrepository.SearchByPrice(price).isEmpty()){
                           this.searchcommodities= this.commodityrepository.SearchByPrice(price);       
                    }else{
                        return "searchFailed";
                }
            }else{
                if(this.title.length()>0){  
                    if(!this.commodityrepository.SearchByTitle(title).isEmpty()){
                           this.searchcommodities= this.commodityrepository.SearchByTitle(title);       
                    }else{
                        return "searchFailed";
                    }
                }else{
                    if(this.label.length()>0){
                        if(!this.commodityrepository.SearchByLabel(label).isEmpty()){
                           this.searchcommodities= this.commodityrepository.SearchByLabel(label);       
                    }else{
                        return "searchFailed";
                    }
                    }else{
                        return "searchFailed";
                    }
                }
            }
        }
        return "superadministrator";
    }
    public Commodityinfo searchCommodityById(int id){
        Commodityinfo commodity = commodityrepository.SearchById(commodityid);
        if(commodity==null){
            message_searchcommodity="Np commodity you search";
            return null;
        }
        return commodity;
    }
    public List<Commodityinfo> SearchCommodityByPrice(int price){
        List<Commodityinfo> commodities = this.commodityrepository.SearchByPrice(price);
        if(commodities==null){
            message_searchcommodity="Np commodity you search";
            return null;
        }
        return commodities;
    }
    
    public List<Commodityinfo> SearchCommodityByTitle(String title){       
        List<Commodityinfo> commodities = this.commodityrepository.SearchByTitle(title);
        return commodities;
    }
    public List<Commodityinfo> SearchCommodityByLabel(String label){
        System.out.println("haha SearchCommodityByLabel"+label);
        List<Commodityinfo> commodities = this.commodityrepository.SearchByLabel(label);
        if(commodities==null){
            message_searchcommodity="Np commodity you search";
            return null;
        }
        System.out.println("SerachCommodity ByLabel"+commodities.get(0).toString());
        return commodities;
    }
  public String DisplayCommodityDetail(int commodityid){
      this.commodity=this.commodityrepository.SearchById(commodityid);
      return "commodityDetail";
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

    public Commodityinfo getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodityinfo commodity) {
        this.commodity = commodity;
    }

    public int getCommodityid() {
        return commodityid;
    }

    public void setCommodityid(int commodityid) {
        this.commodityid = commodityid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAvailablenum() {
        return availablenum;
    }

    public void setAvailablenum(int availablenum) {
        this.availablenum = availablenum;
    }

   

    public String getMessage_searchcommodity() {
        return message_searchcommodity;
    }

    public void setMessage_searchcommodity(String message_searchcommodity) {
        this.message_searchcommodity = message_searchcommodity;
    }

    public String getMessage_updatecommodity() {
        return message_updatecommodity;
    }

    public void setMessage_updatecommodity(String message_updatecommodity) {
        this.message_updatecommodity = message_updatecommodity;
    }

    public List<Commodityinfo> getSearchcommodities() {
        return searchcommodities;
    }

    public void setSearchcommodities(List<Commodityinfo> searchcommodities) {
        this.searchcommodities = searchcommodities;
    }
    
    
    
    
}
