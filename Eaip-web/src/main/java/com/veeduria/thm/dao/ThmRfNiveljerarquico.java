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
 * @author luz
 */
@Entity
@Table(name = "thm_rf_niveljerarquico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ThmRfNiveljerarquico.findAll", query = "SELECT t FROM ThmRfNiveljerarquico t"),
    @NamedQuery(name = "ThmRfNiveljerarquico.findByEnjId", query = "SELECT t FROM ThmRfNiveljerarquico t WHERE t.enjId = :enjId"),
    @NamedQuery(name = "ThmRfNiveljerarquico.findByEnjNombre", query = "SELECT t FROM ThmRfNiveljerarquico t WHERE t.enjNombre = :enjNombre")})
public class ThmRfNiveljerarquico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "enj_id")
    private Integer enjId;
    @Size(max = 250)
    @Column(name = "enj_nombre")
    private String enjNombre;
    @OneToMany(mappedBy = "enjId")
    private List<ThmEmpleados> thmEmpleadosList;
    @OneToMany(mappedBy = "enjId")
    private List<ThmTrabajoficiales> thmTrabajoficialesList;
    @OneToMany(mappedBy = "enjId")
    private List<ThmSupernumerarios> thmSupernumerariosList;
    @OneToMany(mappedBy = "enjId")
    private List<ThmTemporal> thmTemporalList;

    public ThmRfNiveljerarquico() {
    }

    public ThmRfNiveljerarquico(Integer enjId) {
        this.enjId = enjId;
    }

    public Integer getEnjId() {
        return enjId;
    }

    public void setEnjId(Integer enjId) {
        this.enjId = enjId;
    }

    public String getEnjNombre() {
        return enjNombre;
    }

    public void setEnjNombre(String enjNombre) {
        this.enjNombre = enjNombre;
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
        hash += (enjId != null ? enjId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ThmRfNiveljerarquico)) {
            return false;
        }
        ThmRfNiveljerarquico other = (ThmRfNiveljerarquico) object;
        return !((this.enjId == null && other.enjId != null) || (this.enjId != null && !this.enjId.equals(other.enjId)));
    }

    @Override
    public String toString() {
        return "com.veeduria.dao.ThmRfNiveljerarquico[ enjId=" + enjId + " ]";
    }
    
}
