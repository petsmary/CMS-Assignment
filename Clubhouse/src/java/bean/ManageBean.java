/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import ejb.ComplaintsFacadeRemote;
import ejb.CustomersFacadeRemote;
import entity.Complaints;
import entity.Customers;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author MingWai
 */
@Named(value = "manage")
@SessionScoped
public class ManageBean implements Serializable {

    @EJB
    private ComplaintsFacadeRemote complaintsFacade;

    @EJB
    private CustomersFacadeRemote customersFacade;

    public ManageBean() {
    }
    
    public List<Customers> show() {
        return customersFacade.findAll();
    }
    
    public List<Complaints> shows() {
        return complaintsFacade.findAll();
    }
}
