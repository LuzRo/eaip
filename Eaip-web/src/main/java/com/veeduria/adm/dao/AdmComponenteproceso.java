/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veeduria.adm.dao;

import com.veeduria.sys.dao.SysInforme;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * @author fernando
 */
@Entity
@Table(name = "adm_componenteproceso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdmComponenteproceso.findAll", query = "SELECT a FROM AdmComponenteproceso a"),
    @NamedQuery(name = "AdmComponenteproceso.findByComId", query = "SELECT a FROM AdmComponenteproceso a WHERE a.comId = :comId"),
    @NamedQuery(name = "AdmComponenteproceso.findByComNombre", query = "SELECT a FROM AdmComponenteproceso a WHERE a.comNombre = :comNombre"),
    @NamedQuery(name = "AdmComponenteproceso.findByIdVersion", query = "SELECT a FROM AdmComponenteproceso a WHERE a.idVersion = :idVersion"),
    @NamedQuery(name = "AdmComponenteproceso.findByComDescripcion", query = "SELECT a FROM AdmComponenteproceso a WHERE a.comDescripcion = :comDescripcion"),
    @NamedQuery(name = "AdmComponenteproceso.findByComEstado", query = "SELECT a FROM AdmComponenteproceso a WHERE a.comEstado = :comEstado"),
     @NamedQuery(name = "AdmComponenteproceso.compXProc", query = "SELECT a FROM AdmComponenteproceso a JOIN a.proId pro WHERE pro.proId = :proId ORDER BY a.comNombre")
})
public class AdmComponenteproceso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "com_id")
    private Integer comId;
    @Size(max = 300)
    @Column(name = "com_nombre")
    private String comNombre;
    @Column(name = "id_version")
    private Integer idVersion;
    @Size(max = 300)
    @Column(name = "com_descripcion")
    private String comDescripcion;
    @Column(name = "com_estado")
    private Boolean comEstado;
    @JoinColumn(name = "pro_id", referencedColumnName = "pro_id")
    @ManyToOne
    private AdmProceso proId;
    @OneToMany(mappedBy = "comId")
    private List<SysInforme> sysInformeList;

    public AdmComponenteproceso() {
    }

    public AdmComponenteproceso(Integer comId) {
        this.comId = comId;
    }

    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
    }

    public String getComNombre() {
        return comNombre;
    }

    public void setComNombre(String comNombre) {
        this.comNombre = comNombre;
    }

    public Integer getIdVersion() {
        return idVersion;
    }

    public void setIdVersion(Integer idVersion) {
        this.idVersion = idVersion;
    }

    public String getComDescripcion() {
        return comDescripcion;
    }

    public void setComDescripcion(String comDescripcion) {
        this.comDescripcion = comDescripcion;
    }

    public Boolean getComEstado() {
        return comEstado;
    }

    public void setComEstado(Boolean comEstado) {
        this.comEstado = comEstado;
    }

    public AdmProceso getProId() {
        return proId;
    }

    public void setProId(AdmProceso proId) {
        this.proId = proId;
    }

    @XmlTransient
    public List<SysInforme> getSysInformeList() {
        return sysInformeList;
    }

    public void setSysInformeList(List<SysInforme> sysInformeList) {
        this.sysInformeList = sysInformeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (comId != null ? comId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdmComponenteproceso)) {
            return false;
        }
        AdmComponenteproceso other = (AdmComponenteproceso) object;
        if ((this.comId == null && other.comId != null) || (this.comId != null && !this.comId.equals(other.comId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.veeduria.dao.AdmComponenteproceso[ comId=" + comId + " ]";
    }
    
}
