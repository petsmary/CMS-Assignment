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
@Table(name = "bbqs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bbqs.findAll", query = "SELECT b FROM Bbqs b")
    , @NamedQuery(name = "Bbqs.findByBbqId", query = "SELECT b FROM Bbqs b WHERE b.bbqId = :bbqId")
    , @NamedQuery(name = "Bbqs.findByBbqName", query = "SELECT b FROM Bbqs b WHERE b.bbqName = :bbqName")
    , @NamedQuery(name = "Bbqs.findByLocation", query = "SELECT b FROM Bbqs b WHERE b.location = :location")
    , @NamedQuery(name = "Bbqs.findByOpen", query = "SELECT b FROM Bbqs b WHERE b.open = :open")
    , @NamedQuery(name = "Bbqs.findByEnd", query = "SELECT b FROM Bbqs b WHERE b.end = :end")
    , @NamedQuery(name = "Bbqs.findByLimited", query = "SELECT b FROM Bbqs b WHERE b.limited = :limited")
    , @NamedQuery(name = "Bbqs.findByDate", query = "SELECT b FROM Bbqs b WHERE b.date = :date")
    , @NamedQuery(name = "Bbqs.findByTaken", query = "SELECT b FROM Bbqs b WHERE b.taken = :taken")})
public class Bbqs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "bbq_id")
    private String bbqId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "bbq_name")
    private String bbqName;
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
    @OneToMany(mappedBy = "schBbqId")
    private Collection<Booking> bookingCollection;

    public Bbqs() {
    }

    public Bbqs(String bbqId) {
        this.bbqId = bbqId;
    }

    public Bbqs(String bbqId, String bbqName, String location, Date open, Date end, int limited, Date date, int taken) {
        this.bbqId = bbqId;
        this.bbqName = bbqName;
        this.location = location;
        this.open = open;
        this.end = end;
        this.limited = limited;
        this.date = date;
        this.taken = taken;
    }

    public String getBbqId() {
        return bbqId;
    }

    public void setBbqId(String bbqId) {
        this.bbqId = bbqId;
    }

    public String getBbqName() {
        return bbqName;
    }

    public void setBbqName(String bbqName) {
        this.bbqName = bbqName;
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
        hash += (bbqId != null ? bbqId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bbqs)) {
            return false;
        }
        Bbqs other = (Bbqs) object;
        if ((this.bbqId == null && other.bbqId != null) || (this.bbqId != null && !this.bbqId.equals(other.bbqId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Bbqs[ bbqId=" + bbqId + " ]";
    }
    
}
