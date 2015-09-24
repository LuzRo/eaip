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
@Table(name = "adm_sectorestruc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdmSectorestruc.findAll", query = "SELECT a FROM AdmSectorestruc a ORDER BY a.sesNombre"),
    @NamedQuery(name = "AdmSectorestruc.findBySesId", query = "SELECT a FROM AdmSectorestruc a WHERE a.sesId = :sesId"),
    @NamedQuery(name = "AdmSectorestruc.findBySesNombre", query = "SELECT a FROM AdmSectorestruc a WHERE a.sesNombre = :sesNombre")})
public class AdmSectorestruc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ses_id")
    private Integer sesId;
    @Size(max = 250)
    @Column(name = "ses_nombre")
    private String sesNombre;
    @OneToMany(mappedBy = "sesId")
    private List<AdmEntidad> admEntidadList;

    public AdmSectorestruc() {
    }

    public AdmSectorestruc(Integer sesId) {
        this.sesId = sesId;
    }

    public Integer getSesId() {
        return sesId;
    }

    public void setSesId(Integer sesId) {
        this.sesId = sesId;
    }

    public String getSesNombre() {
        return sesNombre;
    }

    public void setSesNombre(String sesNombre) {
        this.sesNombre = sesNombre;
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
        hash += (sesId != null ? sesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdmSectorestruc)) {
            return false;
        }
        AdmSectorestruc other = (AdmSectorestruc) object;
        if ((this.sesId == null && other.sesId != null) || (this.sesId != null && !this.sesId.equals(other.sesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.veeduria.adm.dao.AdmSectorestruc[ sesId=" + sesId + " ]";
    }
}
