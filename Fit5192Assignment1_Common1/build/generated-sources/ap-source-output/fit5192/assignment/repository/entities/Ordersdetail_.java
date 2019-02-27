package fit5192.assignment.repository.entities;

import fit5192.assignment.repository.entities.Commodityinfo;
import fit5192.assignment.repository.entities.Orders;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-08-12T21:43:33")
@StaticMetamodel(Ordersdetail.class)
public class Ordersdetail_ { 

    public static volatile SingularAttribute<Ordersdetail, Integer> number;
    public static volatile SingularAttribute<Ordersdetail, Orders> ordersid;
    public static volatile SingularAttribute<Ordersdetail, Integer> ordersdetailid;
    public static volatile SingularAttribute<Ordersdetail, Commodityinfo> commodityid;
    public static volatile SingularAttribute<Ordersdetail, Integer> type;

}