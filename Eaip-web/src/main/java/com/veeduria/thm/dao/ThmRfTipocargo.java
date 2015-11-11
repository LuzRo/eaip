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
@Table(name = "thm_rf_tipocargo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ThmRfTipocargo.findAll", query = "SELECT t FROM ThmRfTipocargo t"),
    @NamedQuery(name = "ThmRfTipocargo.findByEtcId", query = "SELECT t FROM ThmRfTipocargo t WHERE t.etcId = :etcId"),
    @NamedQuery(name = "ThmRfTipocargo.findByEtcNombre", query = "SELECT t FROM ThmRfTipocargo t WHERE t.etcNombre = :etcNombre")})
public class ThmRfTipocargo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "etc_id")
    private Integer etcId;
    @Size(max = 250)
    @Column(name = "etc_nombre")
    private String etcNombre;
    @OneToMany(mappedBy = "etcId")
    private List<ThmEmpleados> thmEmpleadosList;
    @OneToMany(mappedBy = "etcId")
    private List<ThmTemporal> thmTemporalList;

    public ThmRfTipocargo() {
    }

    public ThmRfTipocargo(Integer etcId) {
        this.etcId = etcId;
    }

    public Integer getEtcId() {
        return etcId;
    }

    public void setEtcId(Integer etcId) {
        this.etcId = etcId;
    }

    public String getEtcNombre() {
        return etcNombre;
    }

    public void setEtcNombre(String etcNombre) {
        this.etcNombre = etcNombre;
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
        hash += (etcId != null ? etcId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ThmRfTipocargo)) {
            return false;
        }
        ThmRfTipocargo other = (ThmRfTipocargo) object;
        return !((this.etcId == null && other.etcId != null) || (this.etcId != null && !this.etcId.equals(other.etcId)));
    }

    @Override
    public String toString() {
        return "com.veeduria.dao.ThmRfTipocargo[ etcId=" + etcId + " ]";
    }
    
}
