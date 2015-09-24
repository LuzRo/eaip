/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veeduria.adm.dao;

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
@Table(name = "adm_tipoentidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdmTipoentidad.findAll", query = "SELECT a FROM AdmTipoentidad a"),
    @NamedQuery(name = "AdmTipoentidad.findByTpeId", query = "SELECT a FROM AdmTipoentidad a WHERE a.tpeId = :tpeId"),
    @NamedQuery(name = "AdmTipoentidad.findByTpeNombre", query = "SELECT a FROM AdmTipoentidad a WHERE a.tpeNombre = :tpeNombre")})
public class AdmTipoentidad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "tpe_id")
    private Integer tpeId;
    @Size(max = 250)
    @Column(name = "tpe_nombre")
    private String tpeNombre;
    @OneToMany(mappedBy = "tpeId")
    private List<AdmEntidad> admEntidadList;

    public AdmTipoentidad() {
    }

    public AdmTipoentidad(Integer tpeId) {
        this.tpeId = tpeId;
    }

    public Integer getTpeId() {
        return tpeId;
    }

    public void setTpeId(Integer tpeId) {
        this.tpeId = tpeId;
    }

    public String getTpeNombre() {
        return tpeNombre;
    }

    public void setTpeNombre(String tpeNombre) {
        this.tpeNombre = tpeNombre;
    }

    @XmlTransient
    public List<AdmEntidad> getAdmEntidadList() {
        return admEntidadList;
    }

    public void setAdmEntidadList(List<AdmEntidad> admEntidadList) {
        this.admEntidadList = admEntidadList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tpeId != null ? tpeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdmTipoentidad)) {
            return false;
        }
        AdmTipoentidad other = (AdmTipoentidad) object;
        if ((this.tpeId == null && other.tpeId != null) || (this.tpeId != null && !this.tpeId.equals(other.tpeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.veeduria.adm.dao.AdmTipoentidad[ tpeId=" + tpeId + " ]";
    }
    
}
