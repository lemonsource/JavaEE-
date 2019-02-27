package fit5192.assignment.repository.entities;

import fit5192.assignment.repository.entities.Ordersdetail;
import fit5192.assignment.repository.entities.Userinfo;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-08-12T21:43:33")
@StaticMetamodel(Orders.class)
public class Orders_ { 

    public static volatile SingularAttribute<Orders, Integer> ordersid;
    public static volatile SingularAttribute<Orders, String> datetime;
    public static volatile CollectionAttribute<Orders, Ordersdetail> ordersdetailCollection;
    public static volatile SingularAttribute<Orders, Userinfo> userid;

}