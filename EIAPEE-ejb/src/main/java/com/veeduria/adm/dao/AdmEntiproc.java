/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veeduria.adm.dao;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author luz
 */
@Entity
@Table(name = "adm_entiproc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdmEntiproc.findAll", query = "SELECT a FROM AdmEntiproc a"),
    @NamedQuery(name = "AdmEntiproc.findByEprId", query = "SELECT a FROM AdmEntiproc a WHERE a.eprId = :eprId"),
    @NamedQuery(name = "AdmEntiproc.findByEprEstado", query = "SELECT a FROM AdmEntiproc a WHERE a.eprEstado = :eprEstado")})
public class AdmEntiproc implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "epr_id")
    private Integer eprId;
    @Column(name = "epr_estado")
    private Boolean eprEstado;
    @JoinColumn(name = "pro_id", referencedColumnName = "pro_id")
    @ManyToOne
    private AdmProceso proId;
    @JoinColumn(name = "ent_id", referencedColumnName = "ent_id")
    @ManyToOne
    private AdmEntidad entId;

    public AdmEntiproc() {
    }

    public AdmEntiproc(Integer eprId) {
        this.eprId = eprId;
    }

    public Integer getEprId() {
        return eprId;
    }

    public void setEprId(Integer eprId) {
        this.eprId = eprId;
    }

    public Boolean getEprEstado() {
        return eprEstado;
    }

    public void setEprEstado(Boolean eprEstado) {
        this.eprEstado = eprEstado;
    }

    public AdmProceso getProId() {
        return proId;
    }

    public void setProId(AdmProceso proId) {
        this.proId = proId;
    }

    public AdmEntidad getEntId() {
        return entId;
    }

    public void setEntId(AdmEntidad entId) {
        this.entId = entId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eprId != null ? eprId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdmEntiproc)) {
            return false;
        }
        AdmEntiproc other = (AdmEntiproc) object;
        if ((this.eprId == null && other.eprId != null) || (this.eprId != null && !this.eprId.equals(other.eprId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.veeduria.adm.dao.AdmEntiproc[ eprId=" + eprId + " ]";
    }
    
}
