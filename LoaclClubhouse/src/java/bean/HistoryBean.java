/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import ejb.BookingFacadeLocal;
import entity.Booking;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import util.SessionUtils;

/**
 *
 * @author MingWai
 */
@Named(value = "history")
@SessionScoped
public class HistoryBean implements Serializable {

    @EJB
    private BookingFacadeLocal bookingFacade;

    ArrayList<Booking> bbqList = new ArrayList<Booking>();
    ArrayList<Booking> gymList = new ArrayList<Booking>();
    ArrayList<Booking> poolList = new ArrayList<Booking>();
    ArrayList<Booking> saunaList = new ArrayList<Booking>();
    ArrayList<Booking> studyList = new ArrayList<Booking>();

    public HistoryBean() {
        
    }

    public ArrayList<Booking> getBbqList() {
        return bbqList;
    }

    public void setBbqList(ArrayList<Booking> bbqList) {
        this.bbqList = bbqList;
    }

    public ArrayList<Booking> getGymList() {
        return gymList;
    }

    public void setGymList(ArrayList<Booking> gymList) {
        this.gymList = gymList;
    }

    public ArrayList<Booking> getPoolList() {
        return poolList;
    }

    public void setPoolList(ArrayList<Booking> poolList) {
        this.poolList = poolList;
    }

    public ArrayList<Booking> getSaunaList() {
        return saunaList;
    }

    public void setSaunaList(ArrayList<Booking> saunaList) {
        this.saunaList = saunaList;
    }

    public ArrayList<Booking> getStudyList() {
        return studyList;
    }

    public void setStudyList(ArrayList<Booking> studyList) {
        this.studyList = studyList;
    }

    public void getList() {
        bbqList.clear();
        gymList.clear();
        poolList.clear();
        saunaList.clear();
        studyList.clear();
        try {
            List<Booking> booking = bookingFacade.findAll();
            for (int i = 0; i < booking.size(); i++) {
                Booking b = booking.get(i);
                if (b.getSchCustId().getCustId().equals(SessionUtils.getUserId())) {
                    if (b.getSchBbqId()!= null) {
                        bbqList.add(b);
                    } else if (b.getSchGymId() != null) {
                        gymList.add(b);
                    } else if (b.getSchPoolId() != null) {
                        poolList.add(b);
                    } else if (b.getSchSaunaId() != null) {
                        saunaList.add(b);
                    } else if (b.getSchStudyId() != null) {
                        studyList.add(b);
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

}
