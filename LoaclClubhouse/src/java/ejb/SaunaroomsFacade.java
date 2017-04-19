/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Saunarooms;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author MingWai
 */
@Stateless
public class SaunaroomsFacade extends AbstractFacade<Saunarooms> implements SaunaroomsFacadeLocal {

    @PersistenceContext(unitName = "LoaclClubhousePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SaunaroomsFacade() {
        super(Saunarooms.class);
    }
    
}
