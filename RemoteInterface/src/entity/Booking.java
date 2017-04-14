/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MingWai
 */
@Entity
@Table(name = "booking")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Booking.findAll", query = "SELECT b FROM Booking b")
    , @NamedQuery(name = "Booking.findByBookingId", query = "SELECT b FROM Booking b WHERE b.bookingId = :bookingId")
    , @NamedQuery(name = "Booking.findByBookingdate", query = "SELECT b FROM Booking b WHERE b.bookingdate = :bookingdate")
    , @NamedQuery(name = "Booking.findByStart", query = "SELECT b FROM Booking b WHERE b.start = :start")
    , @NamedQuery(name = "Booking.findByEnd", query = "SELECT b FROM Booking b WHERE b.end = :end")
    , @NamedQuery(name = "Booking.findByStatus", query = "SELECT b FROM Booking b WHERE b.status = :status")})
public class Booking implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "booking_id")
    private String bookingId;
    @Basic(optional = false)
    @Column(name = "bookingdate")
    @Temporal(TemporalType.DATE)
    private Date bookingdate;
    @Basic(optional = false)
    @Column(name = "start")
    @Temporal(TemporalType.TIME)
    private Date start;
    @Basic(optional = false)
    @Column(name = "end")
    @Temporal(TemporalType.TIME)
    private Date end;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "sch_gym_id", referencedColumnName = "gym_id")
    @ManyToOne
    private Gymrooms schGymId;
    @JoinColumn(name = "sch_pool_id", referencedColumnName = "pool_id")
    @ManyToOne
    private Swimmingpools schPoolId;
    @JoinColumn(name = "sch_sauna_id", referencedColumnName = "sauna_id")
    @ManyToOne
    private Saunarooms schSaunaId;
    @JoinColumn(name = "sch_study_id", referencedColumnName = "study_id")
    @ManyToOne
    private Studyrooms schStudyId;
    @JoinColumn(name = "sch_bbq_id", referencedColumnName = "bbq_id")
    @ManyToOne
    private Bbqs schBbqId;
    @JoinColumn(name = "sch_cust_id", referencedColumnName = "cust_id")
    @ManyToOne(optional = false)
    private Customers schCustId;

    public Booking() {
    }

    public Booking(String bookingId) {
        this.bookingId = bookingId;
    }

    public Booking(String bookingId, Date bookingdate, Date start, Date end, String status) {
        this.bookingId = bookingId;
        this.bookingdate = bookingdate;
        this.start = start;
        this.end = end;
        this.status = status;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public Date getBookingdate() {
        return bookingdate;
    }

    public void setBookingdate(Date bookingdate) {
        this.bookingdate = bookingdate;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Gymrooms getSchGymId() {
        return schGymId;
    }

    public void setSchGymId(Gymrooms schGymId) {
        this.schGymId = schGymId;
    }

    public Swimmingpools getSchPoolId() {
        return schPoolId;
    }

    public void setSchPoolId(Swimmingpools schPoolId) {
        this.schPoolId = schPoolId;
    }

    public Saunarooms getSchSaunaId() {
        return schSaunaId;
    }

    public void setSchSaunaId(Saunarooms schSaunaId) {
        this.schSaunaId = schSaunaId;
    }

    public Studyrooms getSchStudyId() {
        return schStudyId;
    }

    public void setSchStudyId(Studyrooms schStudyId) {
        this.schStudyId = schStudyId;
    }

    public Bbqs getSchBbqId() {
        return schBbqId;
    }

    public void setSchBbqId(Bbqs schBbqId) {
        this.schBbqId = schBbqId;
    }

    public Customers getSchCustId() {
        return schCustId;
    }

    public void setSchCustId(Customers schCustId) {
        this.schCustId = schCustId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bookingId != null ? bookingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Booking)) {
            return false;
        }
        Booking other = (Booking) object;
        if ((this.bookingId == null && other.bookingId != null) || (this.bookingId != null && !this.bookingId.equals(other.bookingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Booking[ bookingId=" + bookingId + " ]";
    }
    
}
