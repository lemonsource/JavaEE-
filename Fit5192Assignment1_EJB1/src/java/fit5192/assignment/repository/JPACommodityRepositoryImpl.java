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
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author familywang
 */
@Stateless
public class JPACommodityRepositoryImpl implements CommodityRepository{
        private static final String PERSISTENCE_UNIT="Fit5192Assignment1_Common1PU";
    
    private EntityManager entityManager;
    private EntityManagerFactory entityManagerFactory;
    
    public JPACommodityRepositoryImpl() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        this.entityManager = this.entityManagerFactory.createEntityManager();
    }


    @Override
    public List<Commodityinfo> getAllCommodities(){
        //return entityManager.createNamedQuery(PERSISTENCE_UNIT).getResultList();
        return entityManager.createNamedQuery("Commodityinfo.findAll").getResultList();
    }
    @Override
    public Commodityinfo SearchById(int commodityid){
        TypedQuery<Commodityinfo> query =entityManager.createNamedQuery("Commodityinfo.findByCommodityid", Commodityinfo.class);
        query.setParameter("commodityid", commodityid);
        return query.getSingleResult();
    }
    @Override
    public List<Commodityinfo> SearchCommodityById(int commodityid){
        TypedQuery<Commodityinfo> query =entityManager.createNamedQuery("Commodityinfo.findByCommodityid", Commodityinfo.class);
        query.setParameter("commodityid", commodityid);
        return query.getResultList();
    }
    @Override
    public List<Commodityinfo> SearchByLabel(String label){
        TypedQuery<Commodityinfo> query =entityManager.createNamedQuery("Commodityinfo.findByLabel", Commodityinfo.class);
        query.setParameter("label", label);
        return query.getResultList();
    }
    @Override
    public List<Commodityinfo> SearchByTitle(String title){
        System.out.println("JPA searchtitle");
        System.out.println(title);
        TypedQuery<Commodityinfo> query = entityManager.createNamedQuery("Commodityinfo.findByTitle", Commodityinfo.class);
        query.setParameter("title", title);
        return query.getResultList();
    }
    @Override
    public List<Commodityinfo> SearchByPrice(int price){
        TypedQuery<Commodityinfo> query = entityManager.createNamedQuery("Commodityinfo.findByPrice", Commodityinfo.class);
        query.setParameter("price", price);
        return query.getResultList();
     }
    @Override
    public void AddCommodity(Commodityinfo commodity){       
       EntityTransaction transaction = this.entityManager.getTransaction();
        try {
            transaction.begin();
            
            System.out.println("hello here 1 ");
            
            this.entityManager.persist(commodity);
            
            //System.out.println(commodity.toString());
            transaction.commit();
            System.out.println("hello here 2");
        }catch (Exception ex){
            if (transaction!=null&&transaction.isActive()){
                transaction.rollback();
            }
        }
    }
     @Override
     public void EditCommodity(Commodityinfo commodity){
          entityManager.merge(commodity);
     }
     @Override
     public void RemoveCommodity(int commodityid){
         EntityTransaction transaction = this.entityManager.getTransaction();
          try{
             transaction.begin();
             Commodityinfo commodity = this.SearchById(commodityid);
             if(commodity!=null){
                this.entityManager.remove(commodity);
                transaction.commit();
            }
         }catch(Exception ex){
                if (transaction!=null&&transaction.isActive()){
                transaction.rollback();
                }
            }
     }
     @Override
         public Userinfo BuyCommodity(int commodityid, int userid){
         TypedQuery<Pocession> query=entityManager.createNamedQuery("Pocession.findPocessionByUserid&Commodityid", Pocession.class);
        query.setParameter("userid", userid);
        query.setParameter("commodityid", commodityid);
         List<Pocession> searchpocession =query.getResultList();
                if(!searchpocession.isEmpty()){
                    searchpocession.get(0).addPocession();
                }else{
                    String stringcommodityid=commodityid+"";
                    String stringuserid=userid+"";
                     String stringpocessonid=stringcommodityid+stringuserid;
                     Pocession addpocession = new Pocession(Integer.parseInt(stringpocessonid), 1, this.SearchById(commodityid), this.searchUserById(userid).get(0));


                     EntityTransaction transaction = this.entityManager.getTransaction();
                        try {
                            transaction.begin();
                            this.entityManager.persist(addpocession);            
                            //System.out.println(commodity.toString());
                            transaction.commit();
                            
                        }catch (Exception ex){
                            if (transaction!=null&&transaction.isActive()){
                                transaction.rollback();
                            }
                        }
                }
                
         this.SearchById(commodityid).setItemsnum(this.SearchCommodityById(commodityid).get(0).getItemsnum()-1);
         this.searchUserById(userid).get(0).setAvailablecredits(this.searchUserById(userid).get(0).getAvailablecredits()-this.SearchById(commodityid).getPrice());
         
         return this.searchUserById(userid).get(0);
            
        }
         
         @Override
         public Userinfo SaleCommodity(int commodityid, int userid){
                TypedQuery<Pocession> query=entityManager.createNamedQuery("Pocession.findPocessionByUserid&Commodityid", Pocession.class);
                query.setParameter("userid", userid);
                query.setParameter("commodityid", commodityid);
                 List<Pocession> searchpocession =query.getResultList();
                 if(searchpocession.get(0).getPocessionnum()>1){
                    searchpocession.get(0).subPocession();
                }else{                
                     EntityTransaction transaction = this.entityManager.getTransaction();
                        try {
                            transaction.begin();
                            this.entityManager.remove(searchpocession.get(0));
                            //System.out.println(commodity.toString());
                            transaction.commit();
                            
                        }catch (Exception ex){
                            if (transaction!=null&&transaction.isActive()){
                                transaction.rollback();
                            }
                        }
                }
                
                this.SearchById(commodityid).setItemsnum(this.SearchCommodityById(commodityid).get(0).getItemsnum()+1);
                this.searchUserById(userid).get(0).setAvailablecredits(this.searchUserById(userid).get(0).getAvailablecredits()+this.SearchById(commodityid).getPrice());
                
                return this.searchUserById(userid).get(0);
         }
         
         @Override
         public int getPocessionNum(int commodityid, int userid){
             TypedQuery<Pocession> query=entityManager.createNamedQuery("Pocession.findPocessionByUserid&Commodityid", Pocession.class);
                query.setParameter("userid", userid);
                query.setParameter("commodityid", commodityid);
                return query.getResultList().get(0).getPocessionnum();
         }
     
    /***************************************************************************
        User entity
     * @param email
     * @param password
     * @return 
    ***************************************************************************/
    @Override
    public List<Userinfo> checkLogin(String email, String password){
        System.out.println(email+password);
        TypedQuery<Userinfo> query =entityManager.createQuery("SELECT u FROM Userinfo u WHERE u.email = :email AND u.password = :password", Userinfo.class);
        query.setParameter("email", email);
        query.setParameter("password", password);
        System.out.println("after");
        try{
            return query.getResultList();
        }catch (Exception e){
            return null;
        }
        
    }
    
    @Override
    public void addUser(Userinfo user){
        EntityTransaction transaction = this.entityManager.getTransaction();
        try {
            transaction.begin();                        
            this.entityManager.persist(user);
            transaction.commit();

        }catch (Exception ex){
            if (transaction!=null&&transaction.isActive()){
                transaction.rollback();
            }
        }
    }
    @Override
    public List<Userinfo> searchUserById(int userid){
        TypedQuery<Userinfo> query =entityManager.createNamedQuery("Userinfo.findByUserid", Userinfo.class);
        query.setParameter("userid", userid);
        return query.getResultList();
    }
    @Override
    public List<Userinfo> searchUserByEmail(String email){
        TypedQuery<Userinfo> query=entityManager.createNamedQuery("Userinfo.findByEmail", Userinfo.class);
        query.setParameter("email", email);
        return query.getResultList();
    }
    
    @Override
    public List<Userinfo> searchUserByFistName(String firstnamel){
        TypedQuery<Userinfo> query=entityManager.createNamedQuery("Userinfo.findByFirstname", Userinfo.class);
        query.setParameter("firstname", firstnamel);
        return query.getResultList();
    }
    @Override
    public List<Userinfo> searchUserByLastName(String lastname){
        TypedQuery<Userinfo> query=entityManager.createNamedQuery("Userinfo.findByLastname", Userinfo.class);
        query.setParameter("lastname", lastname);
        return query.getResultList();
    }
    
    @Override
    public List<Userinfo> searchUserByPhoneNumber(String phonenumber){
        TypedQuery<Userinfo> query=entityManager.createNamedQuery("Userinfo.findByPhonenumber", Userinfo.class);
        query.setParameter("phonenumber", phonenumber);
        return query.getResultList();
    }
    
//    @Override
//    public Userinfo  searchUser(int id){
//        TypedQuery<Userinfo> query =entityManager.createNamedQuery("Userinfo.findByUserid", Userinfo.class);
//        query.setParameter("userid", userid);
//        return query.getSingleResult();
//    }
    @Override
    public List<Userinfo> getAllUsers(){
        TypedQuery<Userinfo> query =entityManager.createNamedQuery("Userinfo.findAll", Userinfo.class);
        return query.getResultList();
    }
    @Override
    public void removeUser(int UserId){
//        Userinfo user = this.searchUserById(UserId).get(0);
//        if(user!=null){
//            entityManager.remove(user);
//        }
        
         EntityTransaction transaction = this.entityManager.getTransaction();
          try{
             transaction.begin();
             Userinfo user = this.searchUserById(UserId).get(0);
             List<Pocession> pocessions=this.searchPocessionById(UserId);
             if(pocessions!=null){
                 for(Pocession pocession:pocessions){
                             this.entityManager.remove(pocession);
                    }
             }
             if(user!=null){
                this.entityManager.remove(user);
                transaction.commit();
            }
             
         }catch(Exception ex){
                if (transaction!=null&&transaction.isActive()){
                transaction.rollback();
                }
            }
    }
    
    @Override
    public List<Userinfo> searchUserUnion(int ID, String lastname, String firstname, String email, String password, String usertype,Integer phonenumber){
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(Userinfo.class);
        Root<Userinfo> root = query.from(Userinfo.class);
        Predicate condition = builder.conjunction();
        if(ID != 0) { 
            condition = builder.and(condition, builder.equal(root.get("userid"), ID));
        }        
        if(lastname!=null&&!lastname.equals("")) {
            condition = builder.and(condition, builder.equal(root.get("lastname"), lastname));
        } 
        
        if(firstname!=null&&!firstname.equals("")) {
            condition = builder.and(condition, builder.equal(root.get("firstname"), firstname));
        }
        if(email!=null&&!email.equals("")){
            condition = builder.and(condition, builder.equal(root.get("email"), email));
        }
        if(password!=null&&!password.equals("")) {
            condition = builder.and(condition, builder.equal(root.get("password"), password));
        }
        if(phonenumber!=0) {
            condition = builder.and(condition, builder.equal(root.get("phonenumber"), phonenumber));
        }
//        if(usertype!=null&&!usertype.equals("")) {
//            condition = builder.and(condition, builder.equal(root.get("membershiplevel"), Integer.parseInt(usertype));
//        }       
        query.select(root).where(condition);
        return entityManager.createQuery(query).getResultList();
    }
    
//    @Override 
//    public Userinfo CheckLogin(int ID, String password){
//        List<Userinfo> user = searchUserUnion(ID,"","","",password,null,0);
//        if(!user.isEmpty())
//                return user.get(0);
//        else
//                return null;
//    }
    @Override
    public void updateUser(Userinfo user){
        EntityTransaction transaction = this.entityManager.getTransaction();
        try {
            transaction.begin();                             
            this.entityManager.merge(user);
                      
            transaction.commit();
            System.out.println("hello here 2");
        }catch (Exception ex){
            if (transaction!=null&&transaction.isActive()){
                transaction.rollback();
            }
        
      }
    }
    
    /***************************************************************************/
    
    /***************************************************************************
        User entit
     * @param userid
     * @return
    ***************************************************************************/
    @Override
    public List<Pocession> searchPocessionById(int userid){
       TypedQuery<Pocession> query=entityManager.createNamedQuery("Pocession.findPocessionByUserid", Pocession.class);
        query.setParameter("userid", userid);
        return query.getResultList();
    }
}
//         Commodityinfo commodity = this.SearchById(commodityid);
//         if(commodity!=null){
//             System.out.println("JPA remove"+ commodityid +" ");
//             entityManager.remove(commodity);
//         }else{
//             System.out.println("data empty");
//         }
//     }

