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
@Table(name = "studyrooms")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Studyrooms.findAll", query = "SELECT s FROM Studyrooms s")
    , @NamedQuery(name = "Studyrooms.findByStudyId", query = "SELECT s FROM Studyrooms s WHERE s.studyId = :studyId")
    , @NamedQuery(name = "Studyrooms.findByStudyName", query = "SELECT s FROM Studyrooms s WHERE s.studyName = :studyName")
    , @NamedQuery(name = "Studyrooms.findByLocation", query = "SELECT s FROM Studyrooms s WHERE s.location = :location")
    , @NamedQuery(name = "Studyrooms.findByOpen", query = "SELECT s FROM Studyrooms s WHERE s.open = :open")
    , @NamedQuery(name = "Studyrooms.findByEnd", query = "SELECT s FROM Studyrooms s WHERE s.end = :end")
    , @NamedQuery(name = "Studyrooms.findByLimited", query = "SELECT s FROM Studyrooms s WHERE s.limited = :limited")
    , @NamedQuery(name = "Studyrooms.findByDate", query = "SELECT s FROM Studyrooms s WHERE s.date = :date")
    , @NamedQuery(name = "Studyrooms.findByTaken", query = "SELECT s FROM Studyrooms s WHERE s.taken = :taken")})
public class Studyrooms implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "study_id")
    private String studyId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "study_name")
    private String studyName;
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
    @OneToMany(mappedBy = "schStudyId")
    private Collection<Booking> bookingCollection;

    public Studyrooms() {
    }

    public Studyrooms(String studyId) {
        this.studyId = studyId;
    }

    public Studyrooms(String studyId, String studyName, String location, Date open, Date end, int limited, Date date, int taken) {
        this.studyId = studyId;
        this.studyName = studyName;
        this.location = location;
        this.open = open;
        this.end = end;
        this.limited = limited;
        this.date = date;
        this.taken = taken;
    }

    public String getStudyId() {
        return studyId;
    }

    public void setStudyId(String studyId) {
        this.studyId = studyId;
    }

    public String getStudyName() {
        return studyName;
    }

    public void setStudyName(String studyName) {
        this.studyName = studyName;
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
        hash += (studyId != null ? studyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Studyrooms)) {
            return false;
        }
        Studyrooms other = (Studyrooms) object;
        if ((this.studyId == null && other.studyId != null) || (this.studyId != null && !this.studyId.equals(other.studyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Studyrooms[ studyId=" + studyId + " ]";
    }
    
}
