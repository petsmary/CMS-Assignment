/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import ejb.ComplaintsFacadeRemote;
import ejb.CustomersFacadeRemote;
import entity.Complaints;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import util.SessionUtils;

/**
 *
 * @author MingWai
 */
@Named(value = "complaints")
@SessionScoped
public class ComplaintsBean implements Serializable {

    @EJB
    private CustomersFacadeRemote customersFacade;

    @EJB
    private ComplaintsFacadeRemote complaintsFacade;

    private String name;
    private String message;
    private boolean complaint;
    
    public ComplaintsBean() {
        if (SessionUtils.getUserName() != null) {
            name = SessionUtils.getUserName();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public boolean isComplaint() {
        return complaint;
    }

    public void setComplaint(boolean complaint) {
        this.complaint = complaint;
    }
    
    //get the complaints or inquiries history of login customer and show the comment of officers
    public ArrayList<Complaints> getList() {
        List<Complaints> list = complaintsFacade.findAll();
        ArrayList<Complaints> complaints = new ArrayList<Complaints>();
        for (int i = 0; i < list.size(); i++) {
            Complaints e = list.get(i);
            if(e.getComCustId().getCustId().equals(SessionUtils.getUserId())) {
                complaints.add(e);
            }
        }
        return complaints;
    }
    
    //add the complaints or inquiries to database 
    public void send() {
        try {
            int i = complaintsFacade.findAll().size();
            Complaints complain = new Complaints();
            if (i < 10) {
                complain = new Complaints((i + 1), message);
            } else if (i >= 10 && i < 100) {
                complain = new Complaints((i + 1), message);
            }
            if (i >= 100 && i < 1000) {
                complain = new Complaints((i + 1), message);
            }
            if (i >= 1000 && i < 10000) {
                complain = new Complaints((i + 1), message);
            }
            complain.setComCustId(customersFacade.find(SessionUtils.getUserId()));
            complaintsFacade.create(complain);
            this.complaint = true;
        } catch (Exception ex) {

        }
    }
    
}
