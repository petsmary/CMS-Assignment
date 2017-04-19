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
@Table(name = "saunarooms")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Saunarooms.findAll", query = "SELECT s FROM Saunarooms s")
    , @NamedQuery(name = "Saunarooms.findBySaunaId", query = "SELECT s FROM Saunarooms s WHERE s.saunaId = :saunaId")
    , @NamedQuery(name = "Saunarooms.findBySaunaName", query = "SELECT s FROM Saunarooms s WHERE s.saunaName = :saunaName")
    , @NamedQuery(name = "Saunarooms.findByLocation", query = "SELECT s FROM Saunarooms s WHERE s.location = :location")
    , @NamedQuery(name = "Saunarooms.findByOpen", query = "SELECT s FROM Saunarooms s WHERE s.open = :open")
    , @NamedQuery(name = "Saunarooms.findByEnd", query = "SELECT s FROM Saunarooms s WHERE s.end = :end")
    , @NamedQuery(name = "Saunarooms.findByLimited", query = "SELECT s FROM Saunarooms s WHERE s.limited = :limited")
    , @NamedQuery(name = "Saunarooms.findByDate", query = "SELECT s FROM Saunarooms s WHERE s.date = :date")
    , @NamedQuery(name = "Saunarooms.findByTaken", query = "SELECT s FROM Saunarooms s WHERE s.taken = :taken")})
public class Saunarooms implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "sauna_id")
    private String saunaId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "sauna_name")
    private String saunaName;
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
    @OneToMany(mappedBy = "schSaunaId")
    private Collection<Booking> bookingCollection;

    public Saunarooms() {
    }

    public Saunarooms(String saunaId) {
        this.saunaId = saunaId;
    }

    public Saunarooms(String saunaId, String saunaName, String location, Date open, Date end, int limited, Date date, int taken) {
        this.saunaId = saunaId;
        this.saunaName = saunaName;
        this.location = location;
        this.open = open;
        this.end = end;
        this.limited = limited;
        this.date = date;
        this.taken = taken;
    }

    public String getSaunaId() {
        return saunaId;
    }

    public void setSaunaId(String saunaId) {
        this.saunaId = saunaId;
    }

    public String getSaunaName() {
        return saunaName;
    }

    public void setSaunaName(String saunaName) {
        this.saunaName = saunaName;
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
        hash += (saunaId != null ? saunaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Saunarooms)) {
            return false;
        }
        Saunarooms other = (Saunarooms) object;
        if ((this.saunaId == null && other.saunaId != null) || (this.saunaId != null && !this.saunaId.equals(other.saunaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Saunarooms[ saunaId=" + saunaId + " ]";
    }
    
}
