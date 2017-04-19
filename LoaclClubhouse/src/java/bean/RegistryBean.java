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
import javax.ejb.EJB;

/**
 *
 * @author MingWai
 */
@Named(value = "registry")
@SessionScoped
public class RegistryBean implements Serializable {

    @EJB
    private CustomersFacadeLocal customersFacade;

    @EJB
    private AccountsFacadeLocal accountsFacade;

    private String login_name;
    private String password;
    private String xpassword;
    private String firstname;
    private String lastname;
    private String address;
    private String email;
    private boolean successful;
    private boolean error;
    private boolean passwordError;

    public String getLogin_name() {
        return login_name;
    }

    public void setLogin_name(String login_name) {
        this.login_name = login_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getXpassword() {
        return xpassword;
    }

    public void setXpassword(String xpassword) {
        this.xpassword = xpassword;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public RegistryBean() {
    }

    public void signup() {
        try {
            if (password.equals(xpassword)) {
                int i = customersFacade.findAll().size();
                String custId = "C0001";
                if (i < 9) {
                    custId = "C000" + (i + 1);
                } else if (i >= 9 && i < 99) {
                    custId = "C00" + (i + 2);
                }
                if (i >= 99 && i < 999) {
                    custId = "C0" + (i + 3);
                }
                if (i >= 999 && i < 9999) {
                    custId = "C" + (i + 4);
                }
                Customers customer = new Customers(custId, firstname, lastname, email, address, true, new Date(), new Date());
                customersFacade.create(customer);
                Accounts account = new Accounts();
                account.setAccCustId(customer);
                account.setIsOfficer(false);
                account.setLoginName(login_name);
                account.setPassword(password);
                accountsFacade.create(account);
                setSuccessful(true);
            } else {
                setPasswordError(true);
            }
        } catch (Exception ex) {
            setError(true);
        }
    }

    public void setFalse() {
        setSuccessful(false);
        setError(false);
        setPasswordError(false);
    }

    public boolean isPasswordError() {
        return passwordError;
    }

    public void setPasswordError(boolean passwordError) {
        this.passwordError = passwordError;
    }

    public boolean isSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }
}
