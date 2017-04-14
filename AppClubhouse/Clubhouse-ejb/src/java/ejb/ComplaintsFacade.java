/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Complaints;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author MingWai
 */
@Stateless
public class ComplaintsFacade extends AbstractFacade<Complaints> implements ejb.ComplaintsFacadeRemote {

    @PersistenceContext(unitName = "Clubhouse-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ComplaintsFacade() {
        super(Complaints.class);
    }
    
}
