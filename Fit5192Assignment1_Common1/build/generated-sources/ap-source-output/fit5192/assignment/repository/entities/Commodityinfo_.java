package fit5192.assignment.repository.entities;

import fit5192.assignment.repository.entities.Ordersdetail;
import fit5192.assignment.repository.entities.Pocession;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-08-12T21:43:33")
@StaticMetamodel(Commodityinfo.class)
public class Commodityinfo_ { 

    public static volatile SingularAttribute<Commodityinfo, String> author;
    public static volatile SingularAttribute<Commodityinfo, String> description;
    public static volatile CollectionAttribute<Commodityinfo, Pocession> pocessionCollection;
    public static volatile SingularAttribute<Commodityinfo, Integer> commodityid;
    public static volatile SingularAttribute<Commodityinfo, String> label;
    public static volatile SingularAttribute<Commodityinfo, Integer> grades;
    public static volatile CollectionAttribute<Commodityinfo, Ordersdetail> ordersdetailCollection;
    public static volatile SingularAttribute<Commodityinfo, String> title;
    public static volatile SingularAttribute<Commodityinfo, Integer> itemstotalnum;
    public static volatile SingularAttribute<Commodityinfo, String> material;
    public static volatile SingularAttribute<Commodityinfo, Integer> price;
    public static volatile SingularAttribute<Commodityinfo, String> thumbnailimage;
    public static volatile SingularAttribute<Commodityinfo, Integer> itemsnum;

}