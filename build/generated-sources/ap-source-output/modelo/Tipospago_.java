package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Ventas;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-12-17T01:04:21")
@StaticMetamodel(Tipospago.class)
public class Tipospago_ { 

    public static volatile CollectionAttribute<Tipospago, Ventas> ventasCollection;
    public static volatile SingularAttribute<Tipospago, Integer> id;
    public static volatile SingularAttribute<Tipospago, String> nombre;
    public static volatile SingularAttribute<Tipospago, Integer> status;

}