package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Seguimiento;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-12-17T01:04:21")
@StaticMetamodel(Paqueteria.class)
public class Paqueteria_ { 

    public static volatile SingularAttribute<Paqueteria, Integer> id;
    public static volatile CollectionAttribute<Paqueteria, Seguimiento> seguimientoCollection;
    public static volatile SingularAttribute<Paqueteria, String> nom;
    public static volatile SingularAttribute<Paqueteria, Integer> status;

}