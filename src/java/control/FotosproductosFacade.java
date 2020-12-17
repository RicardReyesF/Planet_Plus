/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Fotosproductos;

/**
 *
 * @author ricardo
 */
@Stateless
public class FotosproductosFacade extends AbstractFacade<Fotosproductos> {

    @PersistenceContext(unitName = "Demo02PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FotosproductosFacade() {
        super(Fotosproductos.class);
    }
    
}
