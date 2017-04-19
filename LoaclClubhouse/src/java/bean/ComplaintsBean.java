/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import ejb.ComplaintsFacadeLocal;
import ejb.CustomersFacadeLocal;
import entity.Complaints;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
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
    private CustomersFacadeLocal customersFacade;

    @EJB
    private ComplaintsFacadeLocal complaintsFacade;

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
    
    public void send() {
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
    }
    
}
