/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MingWai
 */
@Entity
@Table(name = "bbq")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bbq.findAll", query = "SELECT b FROM Bbq b")
    , @NamedQuery(name = "Bbq.findByPeopleNum", query = "SELECT b FROM Bbq b WHERE b.peopleNum = :peopleNum")
    , @NamedQuery(name = "Bbq.findByNumber", query = "SELECT b FROM Bbq b WHERE b.number = :number")
    , @NamedQuery(name = "Bbq.findByUsername", query = "SELECT b FROM Bbq b WHERE b.username = :username")
    , @NamedQuery(name = "Bbq.findByTaken", query = "SELECT b FROM Bbq b WHERE b.taken = :taken")
    , @NamedQuery(name = "Bbq.findByTime", query = "SELECT b FROM Bbq b WHERE b.time = :time")
    , @NamedQuery(name = "Bbq.findByDate", query = "SELECT b FROM Bbq b WHERE b.date = :date")
    , @NamedQuery(name = "Bbq.match", query = "SELECT b FROM Bbq b WHERE b.date = :date and b.time = :time and b.peopleNum = :peopleNum and b.taken = 0")})
public class Bbq implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "peopleNum")
    private int peopleNum;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "number")
    private Integer number;
    @Size(max = 5)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Column(name = "taken")
    private int taken;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "time")
    private String time;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;

    public Bbq() {
    }

    public Bbq(Integer number) {
        this.number = number;
    }

    public Bbq(Integer number, int peopleNum, int taken, String time, Date date) {
        this.number = number;
        this.peopleNum = peopleNum;
        this.taken = taken;
        this.time = time;
        this.date = date;
    }

    public int getPeopleNum() {
        return peopleNum;
    }

    public void setPeopleNum(int peopleNum) {
        this.peopleNum = peopleNum;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getTaken() {
        return taken;
    }

    public void setTaken(int taken) {
        this.taken = taken;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (number != null ? number.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bbq)) {
            return false;
        }
        Bbq other = (Bbq) object;
        if ((this.number == null && other.number != null) || (this.number != null && !this.number.equals(other.number))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "services.entity.Bbq[ number=" + number + " ]";
    }

}
