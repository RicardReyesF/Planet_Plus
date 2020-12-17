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
import modelo.Compras;

/**
 *
 * @author ricardo
 */
@Stateless
public class ComprasFacade extends AbstractFacade<Compras> {

    @PersistenceContext(unitName = "Demo02PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ComprasFacade() {
        super(Compras.class);
    }
    
     public List<Compras> Consulta_activos() {
        Query consulta = em.createNamedQuery("Compras.Activos",Compras.class);
         List<Compras> lista = consulta.getResultList();
         if(!lista.isEmpty()){
             return lista;
         }else{
            return null; 
         }
            
    }
    
    public List<Compras> Consulta_inactivos() {
        Query consulta = em.createNamedQuery("Compras.Inactivos",Compras.class);
         List<Compras> lista = consulta.getResultList();
         if(!lista.isEmpty()){
             return lista;
         }else{
            return null; 
         }
            
    }
}
