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
@Table(name = "gymrooms")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gymrooms.findAll", query = "SELECT g FROM Gymrooms g")
    , @NamedQuery(name = "Gymrooms.findByGymId", query = "SELECT g FROM Gymrooms g WHERE g.gymId = :gymId")
    , @NamedQuery(name = "Gymrooms.findByGymName", query = "SELECT g FROM Gymrooms g WHERE g.gymName = :gymName")
    , @NamedQuery(name = "Gymrooms.findByLocation", query = "SELECT g FROM Gymrooms g WHERE g.location = :location")
    , @NamedQuery(name = "Gymrooms.findByOpen", query = "SELECT g FROM Gymrooms g WHERE g.open = :open")
    , @NamedQuery(name = "Gymrooms.findByEnd", query = "SELECT g FROM Gymrooms g WHERE g.end = :end")
    , @NamedQuery(name = "Gymrooms.findByLimited", query = "SELECT g FROM Gymrooms g WHERE g.limited = :limited")
    , @NamedQuery(name = "Gymrooms.findByDate", query = "SELECT g FROM Gymrooms g WHERE g.date = :date")
    , @NamedQuery(name = "Gymrooms.findByTaken", query = "SELECT g FROM Gymrooms g WHERE g.taken = :taken")})
public class Gymrooms implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "gym_id")
    private String gymId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "gym_name")
    private String gymName;
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
    @OneToMany(mappedBy = "schGymId")
    private Collection<Booking> bookingCollection;

    public Gymrooms() {
    }

    public Gymrooms(String gymId) {
        this.gymId = gymId;
    }

    public Gymrooms(String gymId, String gymName, String location, Date open, Date end, int limited, Date date, int taken) {
        this.gymId = gymId;
        this.gymName = gymName;
        this.location = location;
        this.open = open;
        this.end = end;
        this.limited = limited;
        this.date = date;
        this.taken = taken;
    }

    public String getGymId() {
        return gymId;
    }

    public void setGymId(String gymId) {
        this.gymId = gymId;
    }

    public String getGymName() {
        return gymName;
    }

    public void setGymName(String gymName) {
        this.gymName = gymName;
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
        hash += (gymId != null ? gymId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gymrooms)) {
            return false;
        }
        Gymrooms other = (Gymrooms) object;
        if ((this.gymId == null && other.gymId != null) || (this.gymId != null && !this.gymId.equals(other.gymId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Gymrooms[ gymId=" + gymId + " ]";
    }
    
}
