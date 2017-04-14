/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
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
@Table(name = "swimmingpools")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Swimmingpools.findAll", query = "SELECT s FROM Swimmingpools s")
    , @NamedQuery(name = "Swimmingpools.findByPoolId", query = "SELECT s FROM Swimmingpools s WHERE s.poolId = :poolId")
    , @NamedQuery(name = "Swimmingpools.findByPoolName", query = "SELECT s FROM Swimmingpools s WHERE s.poolName = :poolName")
    , @NamedQuery(name = "Swimmingpools.findByLocation", query = "SELECT s FROM Swimmingpools s WHERE s.location = :location")
    , @NamedQuery(name = "Swimmingpools.findByOpen", query = "SELECT s FROM Swimmingpools s WHERE s.open = :open")
    , @NamedQuery(name = "Swimmingpools.findByEnd", query = "SELECT s FROM Swimmingpools s WHERE s.end = :end")
    , @NamedQuery(name = "Swimmingpools.findByLimited", query = "SELECT s FROM Swimmingpools s WHERE s.limited = :limited")
    , @NamedQuery(name = "Swimmingpools.findByDate", query = "SELECT s FROM Swimmingpools s WHERE s.date = :date")
    , @NamedQuery(name = "Swimmingpools.findByTaken", query = "SELECT s FROM Swimmingpools s WHERE s.taken = :taken")})
public class Swimmingpools implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "pool_id")
    private String poolId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "pool_name")
    private String poolName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "location")
    private String location;
    @Basic(optional = false)
    @NotNull
    @Column(name = "open")
    @Temporal(TemporalType.TIME)
    private Date open;
    @Basic(optional = false)
    @NotNull
    @Column(name = "end")
    @Temporal(TemporalType.TIME)
    private Date end;
    @Basic(optional = false)
    @NotNull
    @Column(name = "limited")
    private int limited;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "taken")
    private int taken;
    @OneToMany(mappedBy = "schPoolId")
    private Collection<Booking> bookingCollection;

    public Swimmingpools() {
    }

    public Swimmingpools(String poolId) {
        this.poolId = poolId;
    }

    public Swimmingpools(String poolId, String poolName, String location, Date open, Date end, int limited, Date date, int taken) {
        this.poolId = poolId;
        this.poolName = poolName;
        this.location = location;
        this.open = open;
        this.end = end;
        this.limited = limited;
        this.date = date;
        this.taken = taken;
    }

    public String getPoolId() {
        return poolId;
    }

    public void setPoolId(String poolId) {
        this.poolId = poolId;
    }

    public String getPoolName() {
        return poolName;
    }

    public void setPoolName(String poolName) {
        this.poolName = poolName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getOpen() {
        return open;
    }

    public void setOpen(Date open) {
        this.open = open;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public int getLimited() {
        return limited;
    }

    public void setLimited(int limited) {
        this.limited = limited;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getTaken() {
        return taken;
    }

    public void setTaken(int taken) {
        this.taken = taken;
    }

    @XmlTransient
    public Collection<Booking> getBookingCollection() {
        return bookingCollection;
    }

    public void setBookingCollection(Collection<Booking> bookingCollection) {
        this.bookingCollection = bookingCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (poolId != null ? poolId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Swimmingpools)) {
            return false;
        }
        Swimmingpools other = (Swimmingpools) object;
        if ((this.poolId == null && other.poolId != null) || (this.poolId != null && !this.poolId.equals(other.poolId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Swimmingpools[ poolId=" + poolId + " ]";
    }
    
}
