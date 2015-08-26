/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veeduria.pre.dao;

import com.veeduria.adm.dao.AdmEntidad;
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
@Table(name = "pre_claseplancuenta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PreClaseplancuenta.findAll", query = "SELECT p FROM PreClaseplancuenta p"),
    @NamedQuery(name = "PreClaseplancuenta.findByCpcId", query = "SELECT p FROM PreClaseplancuenta p WHERE p.cpcId = :cpcId"),
    @NamedQuery(name = "PreClaseplancuenta.findByCpcNombre", query = "SELECT p FROM PreClaseplancuenta p WHERE p.cpcNombre = :cpcNombre"),
    @NamedQuery(name = "PreClaseplancuenta.findByCpcDescripcion", query = "SELECT p FROM PreClaseplancuenta p WHERE p.cpcDescripcion = :cpcDescripcion"),
    @NamedQuery(name = "PreClaseplancuenta.findByCpcEstado", query = "SELECT p FROM PreClaseplancuenta p WHERE p.cpcEstado = :cpcEstado"),
    @NamedQuery(name = "PreClaseplancuenta.findByIndversion", query = "SELECT p FROM PreClaseplancuenta p WHERE p.indversion = :indversion")})
public class PreClaseplancuenta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cpc_id")
    private Integer cpcId;
    @Size(max = 250)
    @Column(name = "cpc_nombre")
    private String cpcNombre;
    @Size(max = 2147483647)
    @Column(name = "cpc_descripcion")
    private String cpcDescripcion;
    @Column(name = "cpc_estado")
    private Boolean cpcEstado;
    @Column(name = "indversion")
    private Integer indversion;
    @OneToMany(mappedBy = "cpcId")
    private List<AdmEntidad> admEntidadList;
    @OneToMany(mappedBy = "cpcId")
    private List<PrePlancuenta> prePlancuentaList;

    public PreClaseplancuenta() {
    }

    public PreClaseplancuenta(Integer cpcId) {
        this.cpcId = cpcId;
    }

    public Integer getCpcId() {
        return cpcId;
    }

    public void setCpcId(Integer cpcId) {
        this.cpcId = cpcId;
    }

    public String getCpcNombre() {
        return cpcNombre;
    }

    public void setCpcNombre(String cpcNombre) {
        this.cpcNombre = cpcNombre;
    }

    public String getCpcDescripcion() {
        return cpcDescripcion;
    }

    public void setCpcDescripcion(String cpcDescripcion) {
        this.cpcDescripcion = cpcDescripcion;
    }

    public Boolean getCpcEstado() {
        return cpcEstado;
    }

    public void setCpcEstado(Boolean cpcEstado) {
        this.cpcEstado = cpcEstado;
    }

    public Integer getIndversion() {
        return indversion;
    }

    public void setIndversion(Integer indversion) {
        this.indversion = indversion;
    }

    @XmlTransient
    public List<AdmEntidad> getAdmEntidadList() {
        return admEntidadList;
    }

    public void setAdmEntidadList(List<AdmEntidad> admEntidadList) {
        this.admEntidadList = admEntidadList;
    }

    @XmlTransient
    public List<PrePlancuenta> getPrePlancuentaList() {
        return prePlancuentaList;
    }

    public void setPrePlancuentaList(List<PrePlancuenta> prePlancuentaList) {
        this.prePlancuentaList = prePlancuentaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cpcId != null ? cpcId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PreClaseplancuenta)) {
            return false;
        }
        PreClaseplancuenta other = (PreClaseplancuenta) object;
        if ((this.cpcId == null && other.cpcId != null) || (this.cpcId != null && !this.cpcId.equals(other.cpcId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.veeduria.adm.dao.PreClaseplancuenta[ cpcId=" + cpcId + " ]";
    }
    
}
