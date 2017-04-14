/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Bbqs;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author MingWai
 */
@Stateless
public class BbqsFacade extends AbstractFacade<Bbqs> implements BbqsFacadeRemote {

    @PersistenceContext(unitName = "Clubhouse-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BbqsFacade() {
        super(Bbqs.class);
    }
    
}
