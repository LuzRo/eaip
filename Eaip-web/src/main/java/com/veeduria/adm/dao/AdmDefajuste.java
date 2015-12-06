/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
@Table(name = "adm_defajuste")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdmDefajuste.findAll", query = "SELECT a FROM AdmDefajuste a"),
    @NamedQuery(name = "AdmDefajuste.findByAjuId", query = "SELECT a FROM AdmDefajuste a WHERE a.ajuId = :ajuId"),
    @NamedQuery(name = "AdmDefajuste.findByAjuDescripcion", query = "SELECT a FROM AdmDefajuste a WHERE a.ajuDescripcion = :ajuDescripcion"),
    @NamedQuery(name = "AdmDefajuste.findByAjuEstado", query = "SELECT a FROM AdmDefajuste a WHERE a.ajuEstado = :ajuEstado"),
    @NamedQuery(name = "AdmDefajuste.findByIndVersion", query = "SELECT a FROM AdmDefajuste a WHERE a.indVersion = :indVersion"),
    @NamedQuery(name = "AdmDefajuste.ajuXLogInc",query = "SELECT aj FROM AdmDefajuste aj WHERE aj.ajuId IN( SELECT DISTINCT a.ajuId FROM AdmDefajuste a  JOIN a.admAjustexvalidacionList axv JOIN axv.admLoginconsistenciasList li WHERE li.logId = :logId)")
})
public class AdmDefajuste implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "aju_id")
    private Long ajuId;
    @Size(max = 2147483647)
    @Column(name = "aju_descripcion")
    private String ajuDescripcion;
    @Column(name = "aju_estado")
    private Boolean ajuEstado;
    @Column(name = "ind_version")
    private Integer indVersion;
    @OneToMany(mappedBy = "ajuId")
    private List<AdmAjustexvalidacion> admAjustexvalidacionList;

    public AdmDefajuste() {
    }

    public AdmDefajuste(Long ajuId) {
        this.ajuId = ajuId;
    }

    public Long getAjuId() {
        return ajuId;
    }

    public void setAjuId(Long ajuId) {
        this.ajuId = ajuId;
    }

    public String getAjuDescripcion() {
        return ajuDescripcion;
    }

    public void setAjuDescripcion(String ajuDescripcion) {
        this.ajuDescripcion = ajuDescripcion;
    }

    public Boolean getAjuEstado() {
        return ajuEstado;
    }

    public void setAjuEstado(Boolean ajuEstado) {
        this.ajuEstado = ajuEstado;
    }

    public Integer getIndVersion() {
        return indVersion;
    }

    public void setIndVersion(Integer indVersion) {
        this.indVersion = indVersion;
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
        hash += (ajuId != null ? ajuId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdmDefajuste)) {
            return false;
        }
        AdmDefajuste other = (AdmDefajuste) object;
        if ((this.ajuId == null && other.ajuId != null) || (this.ajuId != null && !this.ajuId.equals(other.ajuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.veeduria.dao.AdmDefajuste[ ajuId=" + ajuId + " ]";
    }
    
}
