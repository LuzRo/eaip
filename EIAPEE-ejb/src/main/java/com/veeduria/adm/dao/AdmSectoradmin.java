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
@Table(name = "adm_sectoradmin")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdmSectoradmin.findAll", query = "SELECT a FROM AdmSectoradmin a ORDER BY a.sadNombre"),
    @NamedQuery(name = "AdmSectoradmin.findBySadId", query = "SELECT a FROM AdmSectoradmin a WHERE a.sadId = :sadId"),
    @NamedQuery(name = "AdmSectoradmin.findBySadNombre", query = "SELECT a FROM AdmSectoradmin a WHERE a.sadNombre = :sadNombre")})
public class AdmSectoradmin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "sad_id")
    private Integer sadId;
    @Size(max = 250)
    @Column(name = "sad_nombre")
    private String sadNombre;
    @Column(name = "sad_codsegplan")
    private Integer sadCodsegplan;
    @OneToMany(mappedBy = "sadId")
    private List<AdmEntidad> admEntidadList;

    public AdmSectoradmin() {
    }

    public AdmSectoradmin(Integer sadId) {
        this.sadId = sadId;
    }

    public Integer getSadId() {
        return sadId;
    }

    public void setSadId(Integer sadId) {
        this.sadId = sadId;
    }

    public String getSadNombre() {
        return sadNombre;
    }

    public void setSadNombre(String sadNombre) {
        this.sadNombre = sadNombre;
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
        hash += (sadId != null ? sadId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdmSectoradmin)) {
            return false;
        }
        AdmSectoradmin other = (AdmSectoradmin) object;
        return !((this.sadId == null && other.sadId != null) || (this.sadId != null && !this.sadId.equals(other.sadId)));
    }

    @Override
    public String toString() {
        return "com.veeduria.adm.dao.AdmSectoradmin[ sadId=" + sadId + " ]";
    }

    /**
     * @return the sadCodsegplan
     */
    public Integer getSadCodsegplan() {
        return sadCodsegplan;
    }

    /**
     * @param sadCodsegplan the sadCodsegplan to set
     */
    public void setSadCodsegplan(Integer sadCodsegplan) {
        this.sadCodsegplan = sadCodsegplan;
    }
}
