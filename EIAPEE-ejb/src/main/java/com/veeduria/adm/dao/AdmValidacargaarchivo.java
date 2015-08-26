/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.veeduria.adm.dao;

import com.veeduria.pre.dao.PreCmgastoinconsistencia;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fernando
 */
@Entity
@Table(name = "adm_validacargaarchivo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdmValidacargaarchivo.findAll", query = "SELECT a FROM AdmValidacargaarchivo a"),
    @NamedQuery(name = "AdmValidacargaarchivo.findByValId", query = "SELECT a FROM AdmValidacargaarchivo a WHERE a.valId = :valId"),
    @NamedQuery(name = "AdmValidacargaarchivo.findByValDescripcion", query = "SELECT a FROM AdmValidacargaarchivo a WHERE a.valDescripcion = :valDescripcion"),
    @NamedQuery(name = "AdmValidacargaarchivo.findByValTablaorigen", query = "SELECT a FROM AdmValidacargaarchivo a WHERE a.valTablaorigen = :valTablaorigen")})
public class AdmValidacargaarchivo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "val_id")
    private Long valId;
    @Size(max = 2147483647)
    @Column(name = "val_descripcion")
    private String valDescripcion;
    @Size(max = 50)
    @Column(name = "val_tablaorigen")
    private String valTablaorigen;
    @OneToMany(mappedBy = "valId")
    private List<PreCmgastoinconsistencia> preCmgastoinconsistenciaList;
    @OneToMany(mappedBy = "valId")
    private List<AdmAjustexvalidacion> admAjustexvalidacionList;

    public AdmValidacargaarchivo() {
    }

    public AdmValidacargaarchivo(Long valId) {
        this.valId = valId;
    }

    public Long getValId() {
        return valId;
    }

    public void setValId(Long valId) {
        this.valId = valId;
    }

    public String getValDescripcion() {
        return valDescripcion;
    }

    public void setValDescripcion(String valDescripcion) {
        this.valDescripcion = valDescripcion;
    }

    public String getValTablaorigen() {
        return valTablaorigen;
    }

    public void setValTablaorigen(String valTablaorigen) {
        this.valTablaorigen = valTablaorigen;
    }

    @XmlTransient
    public List<PreCmgastoinconsistencia> getPreCmgastoinconsistenciaList() {
        return preCmgastoinconsistenciaList;
    }

    public void setPreCmgastoinconsistenciaList(List<PreCmgastoinconsistencia> preCmgastoinconsistenciaList) {
        this.preCmgastoinconsistenciaList = preCmgastoinconsistenciaList;
    }

    @XmlTransient
    public List<AdmAjustexvalidacion> getAdmAjustexvalidacionList() {
        return admAjustexvalidacionList;
    }

    public void setAdmAjustexvalidacionList(List<AdmAjustexvalidacion> admAjustexvalidacionList) {
        this.admAjustexvalidacionList = admAjustexvalidacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (valId != null ? valId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdmValidacargaarchivo)) {
            return false;
        }
        AdmValidacargaarchivo other = (AdmValidacargaarchivo) object;
        if ((this.valId == null && other.valId != null) || (this.valId != null && !this.valId.equals(other.valId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.veeduria.dao.AdmValidacargaarchivo[ valId=" + valId + " ]";
    }
    
}
