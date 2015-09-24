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
@Table(name = "adm_natjuridica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdmNatjuridica.findAll", query = "SELECT a FROM AdmNatjuridica a"),
    @NamedQuery(name = "AdmNatjuridica.findByNatId", query = "SELECT a FROM AdmNatjuridica a WHERE a.natId = :natId"),
    @NamedQuery(name = "AdmNatjuridica.findByNatNombre", query = "SELECT a FROM AdmNatjuridica a WHERE a.natNombre = :natNombre")})
public class AdmNatjuridica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "nat_id")
    private Integer natId;
    @Size(max = 250)
    @Column(name = "nat_nombre")
    private String natNombre;
    @OneToMany(mappedBy = "natId")
    private List<AdmEntidad> admEntidadList;

    public AdmNatjuridica() {
    }

    public AdmNatjuridica(Integer natId) {
        this.natId = natId;
    }

    public Integer getNatId() {
        return natId;
    }

    public void setNatId(Integer natId) {
        this.natId = natId;
    }

    public String getNatNombre() {
        return natNombre;
    }

    public void setNatNombre(String natNombre) {
        this.natNombre = natNombre;
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
        hash += (natId != null ? natId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdmNatjuridica)) {
            return false;
        }
        AdmNatjuridica other = (AdmNatjuridica) object;
        if ((this.natId == null && other.natId != null) || (this.natId != null && !this.natId.equals(other.natId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.veeduria.adm.dao.AdmNatjuridica[ natId=" + natId + " ]";
    }
    
}
