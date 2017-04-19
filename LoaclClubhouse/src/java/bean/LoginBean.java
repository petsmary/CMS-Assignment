/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import ejb.AccountsFacadeLocal;
import ejb.CustomersFacadeLocal;
import entity.Accounts;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.http.HttpSession;
import util.SessionUtils;

/**
 *
 * @author MingWai
 */
@Named(value = "loginR")
@SessionScoped
public class LoginBean implements Serializable {

    @EJB
    private CustomersFacadeLocal customersFacade;

    @EJB
    private AccountsFacadeLocal accountsFacade;

    private String username;
    private String password;
    private static final long serialVersionUID = 1094801825228386363L;

    public LoginBean() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String valid() {
        try {
            List<Accounts> list = accountsFacade.findAll();
            for (int i = 0; i < list.size(); i++) {
                Accounts account = list.get(i);
                if (account.getLoginName().equals(username) && account.getPassword().equals(password) && !account.getIsOfficer()) {
                    HttpSession session = SessionUtils.getSession();
                    session.setAttribute("username", username);
                    session.setAttribute("userid", account.getAccCustId().getCustId());
                    session.setAttribute("officer", "no");
                    return "customer";
                }
            }
        } catch (Exception ex) {
            return "error";
        }
        return "error";
    }
    
    public String validAdmin() {
        try {
            List<Accounts> list = accountsFacade.findAll();
            for (int i = 0; i < list.size(); i++) {
                Accounts account = list.get(i);
                if (account.getLoginName().equals(username) && account.getPassword().equals(password) && account.getIsOfficer()) {
                    HttpSession session = SessionUtils.getSession();
                    session.setAttribute("username", username);
                    session.setAttribute("userid", account.getAccCustId().getCustId());
                    session.setAttribute("officer", "yes");
                    return "customer";
                }
            }
        } catch (Exception ex) {
            return "error";
        }
        return "error";
    }

}
