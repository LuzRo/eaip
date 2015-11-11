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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author con1ead
 */
@Entity
@Table(name = "thm_rf_nivelescolaridad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ThmRfNivelescolaridad.findAll", query = "SELECT t FROM ThmRfNivelescolaridad t"),
    @NamedQuery(name = "ThmRfNivelescolaridad.findByEneId", query = "SELECT t FROM ThmRfNivelescolaridad t WHERE t.eneId = :eneId"),
    @NamedQuery(name = "ThmRfNivelescolaridad.findByEneNombre", query = "SELECT t FROM ThmRfNivelescolaridad t WHERE t.eneNombre = :eneNombre")})
public class ThmRfNivelescolaridad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ene_id")
    private Integer eneId;
    @Size(max = 250)
    @Column(name = "ene_nombre")
    private String eneNombre;
    @OneToMany(mappedBy = "eneId")
    private List<ThmEmpleados> thmEmpleadosList;
    @OneToMany(mappedBy = "eneId")
    private List<ThmTrabajoficiales> thmTrabajoficialesList;
    @OneToMany(mappedBy = "eneId")
    private List<ThmSupernumerarios> thmSupernumerariosList;
    @OneToMany(mappedBy = "eneId")
    private List<ThmTemporal> thmTemporalList;

    public ThmRfNivelescolaridad() {
    }

    public ThmRfNivelescolaridad(Integer eneId) {
        this.eneId = eneId;
    }

    public Integer getEneId() {
        return eneId;
    }

    public void setEneId(Integer eneId) {
        this.eneId = eneId;
    }

    public String getEneNombre() {
        return eneNombre;
    }

    public void setEneNombre(String eneNombre) {
        this.eneNombre = eneNombre;
    }

    @XmlTransient
    public List<ThmEmpleados> getThmEmpleadosList() {
        return thmEmpleadosList;
    }

    public void setThmEmpleadosList(List<ThmEmpleados> thmEmpleadosList) {
        this.thmEmpleadosList = thmEmpleadosList;
    }

    @XmlTransient
    public List<ThmTrabajoficiales> getThmTrabajoficialesList() {
        return thmTrabajoficialesList;
    }

    public void setThmTrabajoficialesList(List<ThmTrabajoficiales> thmTrabajoficialesList) {
        this.thmTrabajoficialesList = thmTrabajoficialesList;
    }

    @XmlTransient
    public List<ThmSupernumerarios> getThmSupernumerariosList() {
        return thmSupernumerariosList;
    }

    public void setThmSupernumerariosList(List<ThmSupernumerarios> thmSupernumerariosList) {
        this.thmSupernumerariosList = thmSupernumerariosList;
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
        hash += (eneId != null ? eneId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ThmRfNivelescolaridad)) {
            return false;
        }
        ThmRfNivelescolaridad other = (ThmRfNivelescolaridad) object;
        return !((this.eneId == null && other.eneId != null) || (this.eneId != null && !this.eneId.equals(other.eneId)));
    }

    @Override
    public String toString() {
        return "com.veeduria.dao.ThmRfNivelescolaridad[ eneId=" + eneId + " ]";
    }
    
}
