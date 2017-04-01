/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.AccountsDAO;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.servlet.http.HttpSession;
import util.SessionUtils;

/**
 *
 * @author MingWai
 */
@Named(value = "login")
@SessionScoped
public class LoginBean implements Serializable {

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
        if (AccountsDAO.login(username, password)) {
            HttpSession session = SessionUtils.getSession();
            session.setAttribute("username", username);
            return "customer";
        } else {
            return "error";
        }
    }
    
    public String validAdmin() {
        if (AccountsDAO.loginAdmin(username, password)) {
            HttpSession session = SessionUtils.getSession();
            session.setAttribute("username", username);
            return "admin";
        } else {
            return "error";
        }
    }

    public String logout() {
        HttpSession session = SessionUtils.getSession();
        session.invalidate();
        return "login";
    }
}
