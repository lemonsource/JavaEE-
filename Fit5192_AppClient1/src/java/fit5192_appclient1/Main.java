/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192_appclient1;

import fit5192.assignment.repository.entities.Commodityinfo;
import fit5192.assignment.repository.CommodityRepository;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.ejb.EJB;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author familywang
 */
public class Main implements ListSelectionListener, ActionListener {
    
    @EJB
    static CommodityRepository commodityrepository;
    private MainFrame mainframe;
    private String name;

    public Main() {
        
        initView();
        System.out.println("hello ");
    }

    public void initView() {
        mainframe=new MainFrame(this,this);
        List<Commodityinfo> commodities =commodityrepository.getAllCommodities();
        mainframe.displayData(commodities);
        mainframe.setVisible(true);
    }
    
    @Override
    public void valueChanged(ListSelectionEvent e) {
       if ((e.getSource() == this.mainframe.getCommodityTable().getSelectionModel())
            && (! e.getValueIsAdjusting()))
        {
            try
            {
                if (mainframe.isPropertySelected()) {
                    int propertyId = mainframe.getSelectedPropertyId();
                
                    Commodityinfo commodity = Main.commodityrepository.SearchById(propertyId);
                    mainframe.displaySelectedPropertyDetails(commodity);
                }               
            }
            catch (Exception ex)
            {
                System.err.println((ex.getMessage()));
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == mainframe.getSearchButton()){
                this.searchCommodity();
        }
        if(e.getSource() == mainframe.getAddButton()){
            mainframe.addCommodity();
        }
        if(e.getSource()==mainframe.getDeleteButton()){
            System.out.println("delete operation start");
            
            mainframe.deleteCommodity();
            System.out.println("delete operation end");
            
        }
        if(e.getSource()==mainframe.getUpdateButton()){
           mainframe.displayAllCommodityInfo();
        }
    }
    
    public void searchCommodity(){
        
        int id =mainframe.getCommodityId();
        
        if(id>0){
            this.searchCommodityById(id);
        }else{
            int budget =mainframe.getCommodityBudget();
            if(budget>0){
                this.searchCommodityByPrice(budget);
            }else{
                String label=mainframe.getCommodityLabel();
                if(label!=null){
                    this.searchCommodityByLabel(label);
                }else{
                    String title =mainframe.getCommodityTitle();
                    if(title!=null){
                        this.searchCommodityByTitle(title);
                    }else{
                        mainframe.displayMessageInDialog("Please input match infomation");
                    }
                        }
            }
        }
        
    }
    
    public void searchCommodityById(int id){
        try{
            Commodityinfo commodity = commodityrepository.SearchById(id);
            if(commodity !=null){
                mainframe.displaySelectedPropertyDetails(commodity);
            }else{
                mainframe.displayMessageInDialog("No matched properties found");
                mainframe.clearTable();
            }
            
        }catch (Exception ex){
            mainframe.displayMessageInDialog("Failed to search commodityinfo by Id" + ex.getMessage());
            mainframe.clearTable();
        }finally{
            
            mainframe.clearInput();
        }
    }
    
    public void searchCommodityByTitle(String title){
            try{
            List<Commodityinfo> commodities = commodityrepository.SearchByTitle(title);
            if(commodities !=null){
                mainframe.displaySelectedPropertyDetails(commodities);
            }else{
                mainframe.displayMessageInDialog("No matched properties found");
                mainframe.clearTable();
            }
            
        }catch (Exception ex){
            mainframe.displayMessageInDialog("Failed to search commodityinfo by Id" + ex.getMessage());
            mainframe.clearTable();
        }finally{
            
            mainframe.clearInput();
        }
    }
    
public void searchCommodityByLabel(String label){
            try{
            List<Commodityinfo> commodities = commodityrepository.SearchByLabel(label);
            if(commodities !=null){
                mainframe.displaySelectedPropertyDetails(commodities);
            }else{
                mainframe.displayMessageInDialog("No matched properties found");
                mainframe.clearTable();
            }
            
        }catch (Exception ex){
            mainframe.displayMessageInDialog("Failed to search commodityinfo by Id" + ex.getMessage());
            mainframe.clearTable();
        }finally{
            
            mainframe.clearInput();
        }
    }
    
    public void searchCommodityByPrice(int price){
            try{
            List<Commodityinfo> commodities = commodityrepository.SearchByPrice(price);
            if(commodities !=null){
                mainframe.displaySelectedPropertyDetails(commodities);
            }else{
                mainframe.displayMessageInDialog("No matched properties found");
                mainframe.clearTable();
            }
            
        }catch (Exception ex){
            mainframe.displayMessageInDialog("Failed to search commodityinfo by Id" + ex.getMessage());
            mainframe.clearTable();
        }finally{
            
            mainframe.clearInput();
        }
    }
    

    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Main main =new Main();
    }
    
}
