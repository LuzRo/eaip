/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veeduria.sys.dao;

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
@Table(name = "sys_rol")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SysRol.findAll", query = "SELECT s FROM SysRol s"),
    @NamedQuery(name = "SysRol.findByRolId", query = "SELECT s FROM SysRol s WHERE s.rolId = :rolId"),
    @NamedQuery(name = "SysRol.findByRolNombre", query = "SELECT s FROM SysRol s WHERE s.rolNombre = :rolNombre"),
    @NamedQuery(name = "SysRol.findByRolDesc", query = "SELECT s FROM SysRol s WHERE s.rolDesc = :rolDesc"),
    @NamedQuery(name = "SysRol.findByRolEstado", query = "SELECT s FROM SysRol s WHERE s.rolEstado = :rolEstado")})
public class SysRol implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "rol_id")
    private Integer rolId;
    @Size(max = 250)
    @Column(name = "rol_nombre")
    private String rolNombre;
    @Size(max = 2147483647)
    @Column(name = "rol_desc")
    private String rolDesc;
    @Column(name = "rol_estado")
    private Boolean rolEstado;
    @OneToMany(mappedBy = "rolId")
    private List<SysRolxfrn> sysRolxfrnList;
    @OneToMany(mappedBy = "rolId")
    private List<SysSubmodxrol> sysSubmodxrolList;

    public SysRol() {
    }

    public SysRol(Integer rolId) {
        this.rolId = rolId;
    }

    public Integer getRolId() {
        return rolId;
    }

    public void setRolId(Integer rolId) {
        this.rolId = rolId;
    }

    public String getRolNombre() {
        return rolNombre;
    }

    public void setRolNombre(String rolNombre) {
        this.rolNombre = rolNombre;
    }

    public String getRolDesc() {
        return rolDesc;
    }

    public void setRolDesc(String rolDesc) {
        this.rolDesc = rolDesc;
    }

    public Boolean getRolEstado() {
        return rolEstado;
    }

    public void setRolEstado(Boolean rolEstado) {
        this.rolEstado = rolEstado;
    }

    @XmlTransient
    public List<SysRolxfrn> getSysRolxfrnList() {
        return sysRolxfrnList;
    }

    public void setSysRolxfrnList(List<SysRolxfrn> sysRolxfrnList) {
        this.sysRolxfrnList = sysRolxfrnList;
    }

    @XmlTransient
    public List<SysSubmodxrol> getSysSubmodxrolList() {
        return sysSubmodxrolList;
    }

    public void setSysSubmodxrolList(List<SysSubmodxrol> sysSubmodxrolList) {
        this.sysSubmodxrolList = sysSubmodxrolList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rolId != null ? rolId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SysRol)) {
            return false;
        }
        SysRol other = (SysRol) object;
        if ((this.rolId == null && other.rolId != null) || (this.rolId != null && !this.rolId.equals(other.rolId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.veeduria.adm.dao.SysRol[ rolId=" + rolId + " ]";
    }
    
}
