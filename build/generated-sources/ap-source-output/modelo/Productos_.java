package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Categorias;
import modelo.DetalleCompra;
import modelo.DetalleVenta;
import modelo.Fotosproductos;
import modelo.Marcas;
import modelo.Proveedores;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-12-17T14:19:51")
@StaticMetamodel(Productos.class)
public class Productos_ { 

    public static volatile SingularAttribute<Productos, String> descripcion;
    public static volatile CollectionAttribute<Productos, DetalleCompra> detalleCompraCollection;
    public static volatile SingularAttribute<Productos, String> nombre;
    public static volatile SingularAttribute<Productos, Integer> existencia;
    public static volatile SingularAttribute<Productos, Double> precioCompra;
    public static volatile SingularAttribute<Productos, Proveedores> idProveedor;
    public static volatile CollectionAttribute<Productos, Fotosproductos> fotosproductosCollection;
    public static volatile SingularAttribute<Productos, Integer> id;
    public static volatile SingularAttribute<Productos, Double> precioVenta;
    public static volatile SingularAttribute<Productos, Integer> stock;
    public static volatile SingularAttribute<Productos, Marcas> idMarca;
    public static volatile SingularAttribute<Productos, Categorias> idCategoria;
    public static volatile SingularAttribute<Productos, Integer> status;
    public static volatile CollectionAttribute<Productos, DetalleVenta> detalleVentaCollection;

}