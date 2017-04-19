/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import ejb.AccountsFacadeRemote;
import ejb.BbqsFacadeRemote;
import ejb.BookingFacadeRemote;
import ejb.ComplaintsFacadeRemote;
import ejb.CustomersFacadeRemote;
import ejb.GymroomsFacadeRemote;
import ejb.SaunaroomsFacadeRemote;
import ejb.StudyroomsFacadeRemote;
import ejb.SwimmingpoolsFacadeRemote;
import entity.Accounts;
import entity.Bbqs;
import entity.Booking;
import entity.Complaints;
import entity.Customers;
import entity.Gymrooms;
import entity.Saunarooms;
import entity.Studyrooms;
import entity.Swimmingpools;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author MingWai
 */
@Named(value = "show")
@SessionScoped
public class ShowBean implements Serializable {

    @EJB
    private SwimmingpoolsFacadeRemote swimmingpoolsFacade;

    @EJB
    private StudyroomsFacadeRemote studyroomsFacade;

    @EJB
    private SaunaroomsFacadeRemote saunaroomsFacade;

    @EJB
    private GymroomsFacadeRemote gymroomsFacade;

    @EJB
    private AccountsFacadeRemote accountsFacade;

    @EJB
    private BookingFacadeRemote bookingFacade;

    @EJB
    private BbqsFacadeRemote bbqsFacade;

    @EJB
    private ComplaintsFacadeRemote complaintsFacade;

    @EJB
    private CustomersFacadeRemote customersFacade;

    private Integer comid;
    private String comment;

    public ShowBean() {
    }

    public List<Customers> getShowCustomer() {
        return customersFacade.findAll();
    }

    public List<Complaints> getShowComplaints() {
        return complaintsFacade.findAll();
    }

    public List<Bbqs> getShowBbqs() {
        return bbqsFacade.findAll();
    }

    public List<Booking> getShowBbqsBooking() {
        List<Booking> list = bookingFacade.findAll();
        ArrayList<Booking> accounts = new ArrayList<Booking>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getSchBbqId() != null) {
                accounts.add(list.get(i));
            }
        }
        return accounts;
    }

    public List<Booking> getShowGymBooking() {
        List<Booking> list = bookingFacade.findAll();
        ArrayList<Booking> accounts = new ArrayList<Booking>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getSchGymId() != null) {
                accounts.add(list.get(i));
            }
        }
        return accounts;
    }

    public List<Booking> getShowPoolBooking() {
        List<Booking> list = bookingFacade.findAll();
        ArrayList<Booking> accounts = new ArrayList<Booking>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getSchPoolId() != null) {
                accounts.add(list.get(i));
            }
        }
        return accounts;
    }

    public List<Booking> getShowSaunaBooking() {
        List<Booking> list = bookingFacade.findAll();
        ArrayList<Booking> accounts = new ArrayList<Booking>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getSchSaunaId() != null) {
                accounts.add(list.get(i));
            }
        }
        return accounts;
    }

    public List<Booking> getShowStudyBooking() {
        List<Booking> list = bookingFacade.findAll();
        ArrayList<Booking> accounts = new ArrayList<Booking>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getSchStudyId() != null) {
                accounts.add(list.get(i));
            }
        }
        return accounts;
    }

    public List<Accounts> getShowAccounts() {
        List<Accounts> list = accountsFacade.findAll();
        ArrayList<Accounts> accounts = new ArrayList<Accounts>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getAccCustId() != null) {
                accounts.add(list.get(i));
            }
        }
        return accounts;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getComid() {
        return comid;
    }

    public void setComid(Integer comid) {
        this.comid = comid;
    }

    public void addComment(Integer comid) {
        this.comid = comid;
        Complaints c = complaintsFacade.find(comid);
        c.setComment(comment);
        comment = "";
        complaintsFacade.edit(c);
        try {
            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
            ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
        } catch (Exception ex) {

        }
    }

    public List<Gymrooms> getShowGymrooms() {
        return gymroomsFacade.findAll();
    }

    public List<Saunarooms> getShowSaunarooms() {
        return saunaroomsFacade.findAll();
    }

    public List<Studyrooms> getShowStudyrooms() {
        return studyroomsFacade.findAll();
    }

    public List<Swimmingpools> getShowSwimmingpools() {
        return swimmingpoolsFacade.findAll();
    }
}
