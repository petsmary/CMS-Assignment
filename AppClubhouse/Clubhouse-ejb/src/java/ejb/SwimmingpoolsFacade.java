/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Swimmingpools;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author MingWai
 */
@Stateless
public class SwimmingpoolsFacade extends AbstractFacade<Swimmingpools> implements SwimmingpoolsFacadeRemote {

    @PersistenceContext(unitName = "Clubhouse-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SwimmingpoolsFacade() {
        super(Swimmingpools.class);
    }
    
}
