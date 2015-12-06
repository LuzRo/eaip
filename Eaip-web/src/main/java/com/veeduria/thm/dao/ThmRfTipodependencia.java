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
@Table(name = "thm_rf_tipodependencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ThmRfTipodependencia.findAll", query = "SELECT t FROM ThmRfTipodependencia t"),
    @NamedQuery(name = "ThmRfTipodependencia.findByEtdId", query = "SELECT t FROM ThmRfTipodependencia t WHERE t.etdId = :etdId"),
    @NamedQuery(name = "ThmRfTipodependencia.findByEtdNombre", query = "SELECT t FROM ThmRfTipodependencia t WHERE t.etdNombre = :etdNombre")})
public class ThmRfTipodependencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "etd_id")
    private Integer etdId;
    @Size(max = 250)
    @Column(name = "etd_nombre")
    private String etdNombre;
    @OneToMany(mappedBy = "etdId")
    private List<ThmEmpleados> thmEmpleadosList;
    @OneToMany(mappedBy = "etdId")
    private List<ThmTrabajoficiales> thmTrabajoficialesList;
    @OneToMany(mappedBy = "etdId")
    private List<ThmTemporal> thmTemporalList;

    public ThmRfTipodependencia() {
    }

    public ThmRfTipodependencia(Integer etdId) {
        this.etdId = etdId;
    }

    public Integer getEtdId() {
        return etdId;
    }

    public void setEtdId(Integer etdId) {
        this.etdId = etdId;
    }

    public String getEtdNombre() {
        return etdNombre;
    }

    public void setEtdNombre(String etdNombre) {
        this.etdNombre = etdNombre;
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
    public List<ThmTemporal> getThmTemporalList() {
        return thmTemporalList;
    }

    public void setThmTemporalList(List<ThmTemporal> thmTemporalList) {
        this.thmTemporalList = thmTemporalList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (etdId != null ? etdId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ThmRfTipodependencia)) {
            return false;
        }
        ThmRfTipodependencia other = (ThmRfTipodependencia) object;
        return !((this.etdId == null && other.etdId != null) || (this.etdId != null && !this.etdId.equals(other.etdId)));
    }

    @Override
    public String toString() {
        return "com.veeduria.dao.ThmRfTipodependencia[ etdId=" + etdId + " ]";
    }
    
}
