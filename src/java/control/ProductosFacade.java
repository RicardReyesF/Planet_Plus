/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modelo.Productos;

/**
 *
 * @author ricardo
 */
@Stateless
public class ProductosFacade extends AbstractFacade<Productos> {

    @PersistenceContext(unitName = "Demo02PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductosFacade() {
        super(Productos.class);
    }
    
    public List<Productos> Consulta_activos() {
        Query consulta = em.createNamedQuery("Productos.Activos",Productos.class);
         List<Productos> lista = consulta.getResultList();
         if(!lista.isEmpty()){
             return lista;
         }else{
            return null; 
         }
            
    }
    
    public List<Productos> Consulta_inactivos() {
        Query consulta = em.createNamedQuery("Productos.Inactivos",Productos.class);
         List<Productos> lista = consulta.getResultList();
         if(!lista.isEmpty()){
             return lista;
         }else{
            return null; 
         }
            
    }
}
