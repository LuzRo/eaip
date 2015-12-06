/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veeduria.thm.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author luz
 */
@Entity
@Table(name = "thm_rf_formavinculacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ThmRfFormavinculacion.findAll", query = "SELECT t FROM ThmRfFormavinculacion t"),
    @NamedQuery(name = "ThmRfFormavinculacion.findByForId", query = "SELECT t FROM ThmRfFormavinculacion t WHERE t.forId = :forId"),
    @NamedQuery(name = "ThmRfFormavinculacion.findByForNombre", query = "SELECT t FROM ThmRfFormavinculacion t WHERE t.forNombre = :forNombre")})
public class ThmRfFormavinculacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "for_id")
    private Integer forId;
    @Size(max = 250)
    @Column(name = "for_nombre")
    private String forNombre;
    @OneToMany(mappedBy = "forId")
    private List<ThmEmpleados> thmEmpleadosList;
    @OneToMany(mappedBy = "forId")
    private List<ThmTemporal> thmTemporalList;

    public ThmRfFormavinculacion() {
    }

    public ThmRfFormavinculacion(Integer forId) {
        this.forId = forId;
    }

    public Integer getForId() {
        return forId;
    }

    public void setForId(Integer forId) {
        this.forId = forId;
    }

    public String getForNombre() {
        return forNombre;
    }

    public void setForNombre(String forNombre) {
        this.forNombre = forNombre;
    }

    @XmlTransient
    public List<ThmEmpleados> getThmEmpleadosList() {
        return thmEmpleadosList;
    }

    public void setThmEmpleadosList(List<ThmEmpleados> thmEmpleadosList) {
        this.thmEmpleadosList = thmEmpleadosList;
    }

    @XmlTransient
    public List<ThmTemporal> getThmTemporalList() {
        return thmTemporalList;
    }

    public void setThmTemporalList(List<ThmTemporal> thmTemporalList) {
        this.thmTemporalList = thmTemporalList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (forId != null ? forId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ThmRfFormavinculacion)) {
            return false;
        }
        ThmRfFormavinculacion other = (ThmRfFormavinculacion) object;
        return !((this.forId == null && other.forId != null) || (this.forId != null && !this.forId.equals(other.forId)));
    }

    @Override
    public String toString() {
        return "com.veeduria.dao.ThmRfFormavinculacion[ forId=" + forId + " ]";
    }
    
}
