package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Compras;
import modelo.Entidades;
import modelo.Municipios;
import modelo.Paises;
import modelo.Productos;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-12-17T23:44:09")
@StaticMetamodel(Proveedores.class)
public class Proveedores_ { 

    public static volatile SingularAttribute<Proveedores, String> contacto;
    public static volatile SingularAttribute<Proveedores, Integer> numext;
    public static volatile CollectionAttribute<Proveedores, Compras> comprasCollection;
    public static volatile SingularAttribute<Proveedores, Paises> idPais;
    public static volatile SingularAttribute<Proveedores, String> calle;
    public static volatile CollectionAttribute<Proveedores, Productos> productosCollection;
    public static volatile SingularAttribute<Proveedores, Municipios> idMunicipio;
    public static volatile SingularAttribute<Proveedores, String> nombre;
    public static volatile SingularAttribute<Proveedores, Integer> cp;
    public static volatile SingularAttribute<Proveedores, String> rfc;
    public static volatile SingularAttribute<Proveedores, String> colonia;
    public static volatile SingularAttribute<Proveedores, Entidades> idEntidad;
    public static volatile SingularAttribute<Proveedores, String> razonSocial;
    public static volatile SingularAttribute<Proveedores, Integer> id;
    public static volatile SingularAttribute<Proveedores, String> telefono;
    public static volatile SingularAttribute<Proveedores, String> email;
    public static volatile SingularAttribute<Proveedores, Integer> status;

}