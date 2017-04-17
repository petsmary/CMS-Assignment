/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Booking;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author MingWai
 */
@Stateless
public class BookingFacade extends AbstractFacade<Booking> implements BookingFacadeRemote {

    @PersistenceContext(unitName = "Clubhouse-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BookingFacade() {
        super(Booking.class);
    }

    @Override
    public boolean check(String cust, String id, int type) {
        List<Booking> list = findAll();
        boolean check = true;
        for (int i = 0; i < list.size(); i++) {
            Booking booking = list.get(i);
            switch (type) {
                case 0:
                    if (booking.getSchCustId().getCustId().equals(cust) && booking.getSchBbqId() != null && booking.getSchBbqId().getBbqId().equals(id)) {
                        check = false;
                    }
                    break;
                case 1:
                    if (booking.getSchCustId().getCustId().equals(cust) && booking.getSchGymId() != null && booking.getSchGymId().getGymId().equals(id)) {
                        check = false;
                    }
                    break;
                case 2:
                    if (booking.getSchCustId().getCustId().equals(cust) && booking.getSchPoolId() != null && booking.getSchPoolId().getPoolId().equals(id)) {
                        check = false;
                    }
                    break;
                case 3:
                    if (booking.getSchCustId().getCustId().equals(cust) && booking.getSchSaunaId() != null && booking.getSchSaunaId().getSaunaId().equals(id)) {
                        check = false;
                    }
                    break;
                case 4:
                    if (booking.getSchCustId().getCustId().equals(cust) && booking.getSchStudyId() != null && booking.getSchStudyId().getStudyId().equals(id)) {
                        check = false;
                    }
                    break;
            }
        }
        return check;
    }

}
