/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Gymrooms;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author MingWai
 */
@Stateless
public class GymroomsFacade extends AbstractFacade<Gymrooms> implements GymroomsFacadeLocal {

    @PersistenceContext(unitName = "LoaclClubhousePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GymroomsFacade() {
        super(Gymrooms.class);
    }
    
}
