/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MingWai
 */
@Entity
@Table(name = "officers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Officers.findAll", query = "SELECT o FROM Officers o")
    , @NamedQuery(name = "Officers.findByOffId", query = "SELECT o FROM Officers o WHERE o.offId = :offId")
    , @NamedQuery(name = "Officers.findByFirstName", query = "SELECT o FROM Officers o WHERE o.firstName = :firstName")
    , @NamedQuery(name = "Officers.findByLastName", query = "SELECT o FROM Officers o WHERE o.lastName = :lastName")
    , @NamedQuery(name = "Officers.findByEmail", query = "SELECT o FROM Officers o WHERE o.email = :email")
    , @NamedQuery(name = "Officers.findByAddress", query = "SELECT o FROM Officers o WHERE o.address = :address")
    , @NamedQuery(name = "Officers.findBySalary", query = "SELECT o FROM Officers o WHERE o.salary = :salary")
    , @NamedQuery(name = "Officers.findByApplyDate", query = "SELECT o FROM Officers o WHERE o.applyDate = :applyDate")
    , @NamedQuery(name = "Officers.findByLastUpdate", query = "SELECT o FROM Officers o WHERE o.lastUpdate = :lastUpdate")})
public class Officers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "off_id")
    private String offId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "first_name")
    private String firstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "last_name")
    private String lastName;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "address")
    private String address;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "salary")
    private BigDecimal salary;
    @Basic(optional = false)
    @NotNull
    @Column(name = "apply_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date applyDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "last_update")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;
    @OneToMany(mappedBy = "accOffId")
    private Collection<Accounts> accountsCollection;

    public Officers() {
    }

    public Officers(String offId) {
        this.offId = offId;
    }

    public Officers(String offId, String firstName, String lastName, String email, String address, BigDecimal salary, Date applyDate, Date lastUpdate) {
        this.offId = offId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.salary = salary;
        this.applyDate = applyDate;
        this.lastUpdate = lastUpdate;
    }

    public String getOffId() {
        return offId;
    }

    public void setOffId(String offId) {
        this.offId = offId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @XmlTransient
    public Collection<Accounts> getAccountsCollection() {
        return accountsCollection;
    }

    public void setAccountsCollection(Collection<Accounts> accountsCollection) {
        this.accountsCollection = accountsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (offId != null ? offId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Officers)) {
            return false;
        }
        Officers other = (Officers) object;
        if ((this.offId == null && other.offId != null) || (this.offId != null && !this.offId.equals(other.offId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Officers[ offId=" + offId + " ]";
    }
    
}
