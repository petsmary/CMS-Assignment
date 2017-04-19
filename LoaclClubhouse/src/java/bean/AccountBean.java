/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import ejb.AccountsFacadeLocal;
import ejb.CustomersFacadeLocal;
import entity.Accounts;
import entity.Customers;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import util.SessionUtils;

/**
 *
 * @author MingWai
 */
@Named(value = "account")
@SessionScoped
public class AccountBean implements Serializable {

    @EJB
    private CustomersFacadeLocal customersFacade;

    @EJB
    private AccountsFacadeLocal accountsFacade;

    Accounts account = new Accounts();
    private String oldpassword;
    private String newpassword;
    private String confirmpassword;
    private boolean error;

    public AccountBean() {
    }

    public Accounts getAccount() {
        return account;
    }

    public void setAccount(Accounts account) {
        this.account = account;
    }

    public String getOldpassword() {
        return oldpassword;
    }

    public void setOldpassword(String oldpassword) {
        this.oldpassword = oldpassword;
    }

    public String getNewpassword() {
        return newpassword;
    }

    public void setNewpassword(String newpassword) {
        this.newpassword = newpassword;
    }

    public String getConfirmpassword() {
        return confirmpassword;
    }

    public void setConfirmpassword(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public void getAccountDetails() {
        try {
            List<Accounts> list = accountsFacade.findAll();
            Accounts account = new Accounts();
            for (int i = 0; i < list.size(); i++) {
                account = list.get(i);
                if (account.getAccCustId() != null) {
                    if (account.getAccCustId().getCustId().equals(SessionUtils.getUserId())) {
                        this.account = account;
                        break;
                    }
                }
            }
        } catch (Exception ex) {

        }
    }

    public void updateDetails() {
        Customers c = account.getAccCustId();
        c.setLastUpdate(new Date());
        customersFacade.edit(c);
    }

    public void updatePassword() {
        if (oldpassword.equals(account.getPassword()) && newpassword.equals(confirmpassword) && !newpassword.equals(oldpassword) && !confirmpassword.equals(oldpassword)) {
            account.setPassword(newpassword);
            accountsFacade.edit(account);
        } else {
            this.error = true;
        }
    }

}
