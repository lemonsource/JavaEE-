package fit5192.assignment.repository.entities;

import fit5192.assignment.repository.entities.Orders;
import fit5192.assignment.repository.entities.Pocession;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-08-12T21:43:33")
@StaticMetamodel(Userinfo.class)
public class Userinfo_ { 

    public static volatile SingularAttribute<Userinfo, String> firstname;
    public static volatile SingularAttribute<Userinfo, String> password;
    public static volatile SingularAttribute<Userinfo, Integer> membershiplevel;
    public static volatile SingularAttribute<Userinfo, String> address;
    public static volatile SingularAttribute<Userinfo, String> phonenumber;
    public static volatile CollectionAttribute<Userinfo, Pocession> pocessionCollection;
    public static volatile SingularAttribute<Userinfo, Integer> availablecredits;
    public static volatile CollectionAttribute<Userinfo, Orders> ordersCollection;
    public static volatile SingularAttribute<Userinfo, Integer> userid;
    public static volatile SingularAttribute<Userinfo, String> email;
    public static volatile SingularAttribute<Userinfo, String> lastname;

}