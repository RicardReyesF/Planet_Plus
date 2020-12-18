package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Envio;
import modelo.Paqueteria;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-12-17T23:44:09")
@StaticMetamodel(Seguimiento.class)
public class Seguimiento_ { 

    public static volatile SingularAttribute<Seguimiento, Envio> guia;
    public static volatile SingularAttribute<Seguimiento, Paqueteria> idPaqueteria;
    public static volatile SingularAttribute<Seguimiento, Integer> id;

}