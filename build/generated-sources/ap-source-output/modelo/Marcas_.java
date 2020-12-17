package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Productos;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-12-17T01:04:21")
@StaticMetamodel(Marcas.class)
public class Marcas_ { 

    public static volatile SingularAttribute<Marcas, String> descripcion;
    public static volatile SingularAttribute<Marcas, String> marca;
    public static volatile CollectionAttribute<Marcas, Productos> productosCollection;
    public static volatile SingularAttribute<Marcas, Integer> id;
    public static volatile SingularAttribute<Marcas, Integer> status;

}