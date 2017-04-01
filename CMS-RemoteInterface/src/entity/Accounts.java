/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MingWai
 */
@Entity
@Table(name = "accounts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Accounts.findAll", query = "SELECT a FROM Accounts a")
    , @NamedQuery(name = "Accounts.findByAccId", query = "SELECT a FROM Accounts a WHERE a.accId = :accId")
    , @NamedQuery(name = "Accounts.findByLoginName", query = "SELECT a FROM Accounts a WHERE a.loginName = :loginName")
    , @NamedQuery(name = "Accounts.findByPassword", query = "SELECT a FROM Accounts a WHERE a.password = :password")
    , @NamedQuery(name = "Accounts.findByIsOfficer", query = "SELECT a FROM Accounts a WHERE a.isOfficer = :isOfficer")})
public class Accounts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "acc_id")
    private Integer accId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "login_name")
    private String loginName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isOfficer")
    private boolean isOfficer;
    @JoinColumn(name = "acc_cust_id", referencedColumnName = "cust_id")
    @ManyToOne
    private Customers accCustId;
    @JoinColumn(name = "acc_off_id", referencedColumnName = "off_id")
    @ManyToOne
    private Officers accOffId;

    public Accounts() {
    }

    public Accounts(Integer accId) {
        this.accId = accId;
    }

    public Accounts(Integer accId, String loginName, String password, boolean isOfficer) {
        this.accId = accId;
        this.loginName = loginName;
        this.password = password;
        this.isOfficer = isOfficer;
    }

    public Integer getAccId() {
        return accId;
    }

    public void setAccId(Integer accId) {
        this.accId = accId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getIsOfficer() {
        return isOfficer;
    }

    public void setIsOfficer(boolean isOfficer) {
        this.isOfficer = isOfficer;
    }

    public Customers getAccCustId() {
        return accCustId;
    }

    public void setAccCustId(Customers accCustId) {
        this.accCustId = accCustId;
    }

    public Officers getAccOffId() {
        return accOffId;
    }

    public void setAccOffId(Officers accOffId) {
        this.accOffId = accOffId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accId != null ? accId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Accounts)) {
            return false;
        }
        Accounts other = (Accounts) object;
        if ((this.accId == null && other.accId != null) || (this.accId != null && !this.accId.equals(other.accId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Accounts[ accId=" + accId + " ]";
    }
    
}
