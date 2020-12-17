package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Entidades;
import modelo.Envio;
import modelo.Proveedores;
import modelo.Usuarios;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-12-17T14:19:51")
@StaticMetamodel(Municipios.class)
public class Municipios_ { 

    public static volatile SingularAttribute<Municipios, Entidades> idEntidad;
    public static volatile CollectionAttribute<Municipios, Envio> envioCollection;
    public static volatile CollectionAttribute<Municipios, Proveedores> proveedoresCollection;
    public static volatile CollectionAttribute<Municipios, Usuarios> usuariosCollection;
    public static volatile SingularAttribute<Municipios, Integer> id;
    public static volatile SingularAttribute<Municipios, String> nombre;
    public static volatile SingularAttribute<Municipios, Integer> status;

}