/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dell
 */
@Entity
@Table(name = "publishers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Publishers.findAll", query = "SELECT p FROM Publishers p")
    , @NamedQuery(name = "Publishers.findByPublisherId", query = "SELECT p FROM Publishers p WHERE p.publisherId = :publisherId")
    , @NamedQuery(name = "Publishers.findByName", query = "SELECT p FROM Publishers p WHERE p.name = :name")
    , @NamedQuery(name = "Publishers.findByCountry", query = "SELECT p FROM Publishers p WHERE p.country = :country")})
public class Publishers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "publisher_id")
    private Integer publisherId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;
    @Size(max = 20)
    @Column(name = "country")
    private String country;

    public Publishers() {
    }

    public Publishers(Integer publisherId) {
        this.publisherId = publisherId;
    }

    public Publishers(Integer publisherId, String name) {
        this.publisherId = publisherId;
        this.name = name;
    }

    public Integer getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Integer publisherId) {
        this.publisherId = publisherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (publisherId != null ? publisherId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Publishers)) {
            return false;
        }
        Publishers other = (Publishers) object;
        if ((this.publisherId == null && other.publisherId != null) || (this.publisherId != null && !this.publisherId.equals(other.publisherId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Publishers[ publisherId=" + publisherId + " ]";
    }
    
}
