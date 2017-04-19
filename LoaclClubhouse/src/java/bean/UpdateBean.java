/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import ejb.BbqsFacadeLocal;
import ejb.BookingFacadeLocal;
import ejb.GymroomsFacadeLocal;
import ejb.SaunaroomsFacadeLocal;
import ejb.StudyroomsFacadeLocal;
import ejb.SwimmingpoolsFacadeLocal;
import entity.Bbqs;
import entity.Booking;
import entity.Gymrooms;
import entity.Saunarooms;
import entity.Studyrooms;
import entity.Swimmingpools;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author MingWai
 */
@Named(value = "update")
@SessionScoped
public class UpdateBean implements Serializable {

    @EJB
    private BookingFacadeLocal bookingFacade;

    @EJB
    private SwimmingpoolsFacadeLocal swimmingpoolsFacade;

    @EJB
    private StudyroomsFacadeLocal studyroomsFacade;

    @EJB
    private SaunaroomsFacadeLocal saunaroomsFacade;

    @EJB
    private GymroomsFacadeLocal gymroomsFacade;

    @EJB
    private BbqsFacadeLocal bbqsFacade;

    private Map<String, String> availableItems;
    private String custid;
    private String bookid;
    private String status;

    DateFormat sdf = new SimpleDateFormat("hh:mm:ss");

    public UpdateBean() {
    }

    public String getCustid() {
        return custid;
    }

    public void setCustid(String custid) {
        this.custid = custid;
    }

    public String getBookid() {
        return bookid;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Map<String, String> getAvailableItems() {
        try {
            availableItems = new LinkedHashMap<String, String>();
            List<Booking> booking = bookingFacade.findAll();
            for (int i = 0; i < booking.size(); i++) {
                Booking b = booking.get(i);
                if (b.getSchCustId().getCustId().equals(custid) && b.getStatus().equals("booked")) {
                    if (b.getSchBbqId() != null) {
                        availableItems.put(b.getSchBbqId().getBbqName() + ", " + b.getSchBbqId().getDate() + ", " + sdf.format(b.getSchBbqId().getOpen()) + " to " + sdf.format(b.getSchBbqId().getEnd()), b.getBookingId());
                    } else if (b.getSchGymId() != null) {
                        availableItems.put(b.getSchGymId().getGymName() + ", " + b.getSchGymId().getDate() + ", " + sdf.format(b.getSchGymId().getOpen()) + " to " + sdf.format(b.getSchGymId().getEnd()), b.getBookingId());
                    } else if (b.getSchPoolId() != null) {
                        availableItems.put(b.getSchPoolId().getPoolName() + ", " + b.getSchPoolId().getDate() + ", " + sdf.format(b.getSchPoolId().getOpen()) + " to " + sdf.format(b.getSchPoolId().getEnd()), b.getBookingId());
                    } else if (b.getSchSaunaId() != null) {
                        availableItems.put(b.getSchSaunaId().getSaunaName() + ", " + b.getSchSaunaId().getDate() + ", " + sdf.format(b.getSchSaunaId().getOpen()) + " to " + sdf.format(b.getSchSaunaId().getEnd()), b.getBookingId());
                    } else if (b.getSchStudyId() != null) {
                        availableItems.put(b.getSchStudyId().getStudyName() + ", " + b.getSchStudyId().getDate() + ", " + sdf.format(b.getSchStudyId().getOpen()) + " to " + sdf.format(b.getSchStudyId().getEnd()), b.getBookingId());
                    }
                }
            }
            return availableItems;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }

    public void change() {
        Booking b = bookingFacade.find(bookid);
        b.setStatus(status);
        if (b.getSchBbqId() != null && status.equalsIgnoreCase("used")) {
            Bbqs bbq = b.getSchBbqId();
            bbq.setTaken(bbq.getTaken() - 1);
            bbqsFacade.edit(bbq);
        } else if (b.getSchGymId() != null && status.equalsIgnoreCase("used")) {
            Gymrooms gym = b.getSchGymId();
            gym.setTaken(gym.getTaken() - 1);
            gymroomsFacade.edit(gym);
        } else if (b.getSchPoolId() != null && status.equalsIgnoreCase("used")) {
            Swimmingpools pool = b.getSchPoolId();
            pool.setTaken(pool.getTaken() - 1);
            swimmingpoolsFacade.edit(pool);
        } else if (b.getSchSaunaId() != null && status.equalsIgnoreCase("used")) {
            Saunarooms sauna = b.getSchSaunaId();
            sauna.setTaken(sauna.getTaken() - 1);
            saunaroomsFacade.edit(sauna);
        } else if (b.getSchStudyId() != null && status.equalsIgnoreCase("used")) {
            Studyrooms study = b.getSchStudyId();
            study.setTaken(study.getTaken() - 1);
            studyroomsFacade.edit(study);
        }
        bookingFacade.edit(b);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Update Complete"));
    }

}
