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
@Table(name = "complaints")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Complaints.findAll", query = "SELECT c FROM Complaints c")
    , @NamedQuery(name = "Complaints.findByComId", query = "SELECT c FROM Complaints c WHERE c.comId = :comId")
    , @NamedQuery(name = "Complaints.findByMessage", query = "SELECT c FROM Complaints c WHERE c.message = :message")
    , @NamedQuery(name = "Complaints.findByComment", query = "SELECT c FROM Complaints c WHERE c.comment = :comment")})
public class Complaints implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "com_id")
    private Integer comId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "message")
    private String message;
    @Size(max = 60)
    @Column(name = "comment")
    private String comment;
    @JoinColumn(name = "com_cust_id", referencedColumnName = "cust_id")
    @ManyToOne(optional = false)
    private Customers comCustId;

    public Complaints() {
    }

    public Complaints(Integer comId) {
        this.comId = comId;
    }

    public Complaints(Integer comId, String message) {
        this.comId = comId;
        this.message = message;
    }

    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Customers getComCustId() {
        return comCustId;
    }

    public void setComCustId(Customers comCustId) {
        this.comCustId = comCustId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (comId != null ? comId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Complaints)) {
            return false;
        }
        Complaints other = (Complaints) object;
        if ((this.comId == null && other.comId != null) || (this.comId != null && !this.comId.equals(other.comId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Complaints[ comId=" + comId + " ]";
    }
    
}
