/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import ejb.AccountsFacadeLocal;
import ejb.BbqsFacadeLocal;
import ejb.BookingFacadeLocal;
import ejb.ComplaintsFacadeLocal;
import ejb.CustomersFacadeLocal;
import ejb.GymroomsFacadeLocal;
import ejb.SaunaroomsFacadeLocal;
import ejb.StudyroomsFacadeLocal;
import ejb.SwimmingpoolsFacadeLocal;
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

/**
 *
 * @author MingWai
 */
@Named(value = "show")
@SessionScoped
public class ShowBean implements Serializable {

    @EJB
    private SwimmingpoolsFacadeLocal swimmingpoolsFacade;

    @EJB
    private StudyroomsFacadeLocal studyroomsFacade;

    @EJB
    private SaunaroomsFacadeLocal saunaroomsFacade;

    @EJB
    private GymroomsFacadeLocal gymroomsFacade;

    @EJB
    private AccountsFacadeLocal accountsFacade;

    @EJB
    private BookingFacadeLocal bookingFacade;

    @EJB
    private BbqsFacadeLocal bbqsFacade;

    @EJB
    private ComplaintsFacadeLocal complaintsFacade;

    @EJB
    private CustomersFacadeLocal customersFacade;
    
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
