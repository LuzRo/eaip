/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veeduria.adm.dao;

import com.veeduria.not.dao.AdmNotificacion;
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
@Table(name = "adm_proceso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdmProceso.findAll", query = "SELECT a FROM AdmProceso a ORDER BY a.proNombre"),
    @NamedQuery(name = "AdmProceso.findByProId", query = "SELECT a FROM AdmProceso a WHERE a.proId = :proId"),
    @NamedQuery(name = "AdmProceso.findByProNombre", query = "SELECT a FROM AdmProceso a WHERE a.proNombre = :proNombre"),
    @NamedQuery(name = "AdmProceso.findByProDesc", query = "SELECT a FROM AdmProceso a WHERE a.proDesc = :proDesc"),
    @NamedQuery(name = "AdmProceso.findByProEstado", query = "SELECT a FROM AdmProceso a WHERE a.proEstado = :proEstado")})
public class AdmProceso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "pro_id")
    private Integer proId;
    @Size(max = 200)
    @Column(name = "pro_nombre")
    private String proNombre;
    @Size(max = 2147483647)
    @Column(name = "pro_desc")
    private String proDesc;
    @Column(name = "pro_estado")
    private Boolean proEstado;
    @OneToMany(mappedBy = "proId")
    private List<AdmNotificacion> admNotificacionList;
    @OneToMany(mappedBy = "proId")
    private List<AdmComponenteproceso> admComponenteprocesoList;

    public AdmProceso() {
    }

    public AdmProceso(Integer proId) {
        this.proId = proId;
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public String getProNombre() {
        return proNombre;
    }

    public void setProNombre(String proNombre) {
        this.proNombre = proNombre;
    }

    public String getProDesc() {
        return proDesc;
    }

    public void setProDesc(String proDesc) {
        this.proDesc = proDesc;
    }

    public Boolean getProEstado() {
        return proEstado;
    }

    public void setProEstado(Boolean proEstado) {
        this.proEstado = proEstado;
    }

    @XmlTransient
    public List<AdmNotificacion> getAdmNotificacionList() {
        return admNotificacionList;
    }

    public void setAdmNotificacionList(List<AdmNotificacion> admNotificacionList) {
        this.admNotificacionList = admNotificacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proId != null ? proId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdmProceso)) {
            return false;
        }
        AdmProceso other = (AdmProceso) object;
        if ((this.proId == null && other.proId != null) || (this.proId != null && !this.proId.equals(other.proId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.veeduria.adm.dao.AdmProceso[ proId=" + proId + " ]";
    }

    /**
     * @return the admComponenteprocesoList
     */
    public List<AdmComponenteproceso> getAdmComponenteprocesoList() {
        return admComponenteprocesoList;
    }

    /**
     * @param admComponenteprocesoList the admComponenteprocesoList to set
     */
    public void setAdmComponenteprocesoList(List<AdmComponenteproceso> admComponenteprocesoList) {
        this.admComponenteprocesoList = admComponenteprocesoList;
    }

}
