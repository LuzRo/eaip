/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veeduria.adm.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author luz
 */
@Entity
@Table(name = "adm_ajustexvalidacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdmAjustexvalidacion.findAll", query = "SELECT a FROM AdmAjustexvalidacion a"),
    @NamedQuery(name = "AdmAjustexvalidacion.findByAvaId", query = "SELECT a FROM AdmAjustexvalidacion a WHERE a.avaId = :avaId"),
    @NamedQuery(name = "AdmAjustexvalidacion.findByAvaEstado", query = "SELECT a FROM AdmAjustexvalidacion a WHERE a.avaEstado = :avaEstado"),
    @NamedQuery(name = "AdmAjustexvalidacion.findByIndVersion", query = "SELECT a FROM AdmAjustexvalidacion a WHERE a.indVersion = :indVersion"),
    @NamedQuery(name = "AdmAjustexvalidacion.findByAvaFechacreacion", query = "SELECT a FROM AdmAjustexvalidacion a WHERE a.avaFechacreacion = :avaFechacreacion"),
    @NamedQuery(name = "AdmAjustexvalidacion.ajustesActivos", query = "SELECT a FROM AdmAjustexvalidacion a JOIN a.valId val "
            + "JOIN a.ajuId aj WHERE aj.ajuEstado = :ajuEstado AND val.valId = :valId ORDER BY aj.ajuDescripcion")
    
})
public class AdmAjustexvalidacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ava_id")
    private Long avaId;
    @Column(name = "ava_estado")
    private Boolean avaEstado;
    @Column(name = "ind_version")
    private Integer indVersion;
    @Column(name = "ava_fechacreacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date avaFechacreacion;
    @JoinColumn(name = "aju_id", referencedColumnName = "aju_id")
    @ManyToOne
    private AdmDefajuste ajuId;
    @JoinColumn(name = "val_id", referencedColumnName = "val_id")
    @ManyToOne
    private AdmValidacargaarchivo valId;
    @OneToMany(mappedBy = "avaId")
    private List<AdmLoginconsistencias> admLoginconsistenciasList;

    public AdmAjustexvalidacion() {
    }

    public AdmAjustexvalidacion(Long avaId) {
        this.avaId = avaId;
    }

    public Long getAvaId() {
        return avaId;
    }

    public void setAvaId(Long avaId) {
        this.avaId = avaId;
    }

    public Boolean getAvaEstado() {
        return avaEstado;
    }

    public void setAvaEstado(Boolean avaEstado) {
        this.avaEstado = avaEstado;
    }

    public Integer getIndVersion() {
        return indVersion;
    }

    public void setIndVersion(Integer indVersion) {
        this.indVersion = indVersion;
    }

    public Date getAvaFechacreacion() {
        return avaFechacreacion;
    }

    public void setAvaFechacreacion(Date avaFechacreacion) {
        this.avaFechacreacion = avaFechacreacion;
    }

    public AdmDefajuste getAjuId() {
        return ajuId;
    }

    public void setAjuId(AdmDefajuste ajuId) {
        this.ajuId = ajuId;
    }

    public AdmValidacargaarchivo getValId() {
        return valId;
    }

    public void setValId(AdmValidacargaarchivo valId) {
        this.valId = valId;
    }

    @XmlTransient
    public List<AdmLoginconsistencias> getAdmLoginconsistenciasList() {
        return admLoginconsistenciasList;
    }

    public void setAdmLoginconsistenciasList(List<AdmLoginconsistencias> admLoginconsistenciasList) {
        this.admLoginconsistenciasList = admLoginconsistenciasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (avaId != null ? avaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdmAjustexvalidacion)) {
            return false;
        }
        AdmAjustexvalidacion other = (AdmAjustexvalidacion) object;
        if ((this.avaId == null && other.avaId != null) || (this.avaId != null && !this.avaId.equals(other.avaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.veeduria.dao.AdmAjustexvalidacion[ avaId=" + avaId + " ]";
    }

}
