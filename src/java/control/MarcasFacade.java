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
import modelo.Marcas;

/**
 *
 * @author ricardo
 */
@Stateless
public class MarcasFacade extends AbstractFacade<Marcas> {

    @PersistenceContext(unitName = "Demo02PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MarcasFacade() {
        super(Marcas.class);
    }
    
    public List<Marcas> Consulta_activos() {
        Query consulta = em.createNamedQuery("Marcas.Activos",Marcas.class);
         List<Marcas> lista = consulta.getResultList();
         if(!lista.isEmpty()){
             return lista;
         }else{
            return null; 
         }
            
    }
    
    public List<Marcas> Consulta_inactivos() {
        Query consulta = em.createNamedQuery("Marcas.Inactivos",Marcas.class);
         List<Marcas> lista = consulta.getResultList();
         if(!lista.isEmpty()){
             return lista;
         }else{
            return null; 
         }
            
    }
}
