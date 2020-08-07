/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
 * @author dell
 */
@Entity
@Table(name = "actions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Actions.findAll", query = "SELECT a FROM Actions a")
    , @NamedQuery(name = "Actions.findByActionId", query = "SELECT a FROM Actions a WHERE a.actionId = :actionId")
    , @NamedQuery(name = "Actions.findByBookId", query = "SELECT a FROM Actions a WHERE a.bookId = :bookId")
    , @NamedQuery(name = "Actions.findByUserId", query = "SELECT a FROM Actions a WHERE a.userId = :userId")
    , @NamedQuery(name = "Actions.findByActionType", query = "SELECT a FROM Actions a WHERE a.actionType = :actionType")
    , @NamedQuery(name = "Actions.findByCreatedAct", query = "SELECT a FROM Actions a WHERE a.createdAct = :createdAct")})
public class Actions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "action_id")
    private Integer actionId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "book_id")
    private int bookId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "user_id")
    private int userId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "action_type")
    private String actionType;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created_act")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAct;

    public Actions() {
    }

    public Actions(Integer actionId) {
        this.actionId = actionId;
    }

    public Actions(Integer actionId, int bookId, int userId, String actionType, Date createdAct) {
        this.actionId = actionId;
        this.bookId = bookId;
        this.userId = userId;
        this.actionType = actionType;
        this.createdAct = createdAct;
    }

    public Integer getActionId() {
        return actionId;
    }

    public void setActionId(Integer actionId) {
        this.actionId = actionId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public Date getCreatedAct() {
        return createdAct;
    }

    public void setCreatedAct(Date createdAct) {
        this.createdAct = createdAct;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (actionId != null ? actionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actions)) {
            return false;
        }
        Actions other = (Actions) object;
        if ((this.actionId == null && other.actionId != null) || (this.actionId != null && !this.actionId.equals(other.actionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Actions[ actionId=" + actionId + " ]";
    }
    
}
