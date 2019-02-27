package fit5192.assignment.repository.entities;

import fit5192.assignment.repository.entities.Commodityinfo;
import fit5192.assignment.repository.entities.Userinfo;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-08-12T21:43:33")
@StaticMetamodel(Pocession.class)
public class Pocession_ { 

    public static volatile SingularAttribute<Pocession, Integer> pocessionnum;
    public static volatile SingularAttribute<Pocession, Integer> pocessionid;
    public static volatile SingularAttribute<Pocession, Commodityinfo> commodityid;
    public static volatile SingularAttribute<Pocession, Userinfo> userid;

}