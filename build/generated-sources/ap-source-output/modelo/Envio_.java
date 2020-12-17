package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Entidades;
import modelo.Municipios;
import modelo.Paises;
import modelo.Seguimiento;
import modelo.Usuarios;
import modelo.Ventas;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-12-17T01:04:21")
@StaticMetamodel(Envio.class)
public class Envio_ { 

    public static volatile SingularAttribute<Envio, String> contacto;
    public static volatile SingularAttribute<Envio, Integer> numext;
    public static volatile SingularAttribute<Envio, Paises> idPais;
    public static volatile SingularAttribute<Envio, String> calle;
    public static volatile SingularAttribute<Envio, Usuarios> idUsuario;
    public static volatile SingularAttribute<Envio, Municipios> idMunicipio;
    public static volatile CollectionAttribute<Envio, Seguimiento> seguimientoCollection;
    public static volatile SingularAttribute<Envio, Integer> cp;
    public static volatile SingularAttribute<Envio, String> colonia;
    public static volatile SingularAttribute<Envio, Ventas> idVenta;
    public static volatile SingularAttribute<Envio, Entidades> idEntidad;
    public static volatile SingularAttribute<Envio, Integer> guia;
    public static volatile SingularAttribute<Envio, String> telefono;

}