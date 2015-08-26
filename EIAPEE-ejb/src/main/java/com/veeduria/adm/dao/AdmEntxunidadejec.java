/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veeduria.adm.dao;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author luz
 */
@Entity
@Table(name = "adm_entxunidadejec")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdmEntxunidadejec.findAll", query = "SELECT a FROM AdmEntxunidadejec a"),
    @NamedQuery(name = "AdmEntxunidadejec.findByEneId", query = "SELECT a FROM AdmEntxunidadejec a WHERE a.eneId = :eneId"),
    @NamedQuery(name = "AdmEntxunidadejec.findByEneNombre", query = "SELECT a FROM AdmEntxunidadejec a WHERE a.eneNombre = :eneNombre"),
    @NamedQuery(name = "AdmEntxunidadejec.findByEneEstado", query = "SELECT a FROM AdmEntxunidadejec a WHERE a.eneEstado = :eneEstado")})

public class AdmEntxunidadejec implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ene_id")
    private Integer eneId;
    @Size(max = 200)
    @Column(name = "ene_nombre")
    private String eneNombre;
    @Column(name = "ene_estado")
    private Boolean eneEstado;
    @JoinColumn(name = "eje_codigo", referencedColumnName = "eje_codigo")
    @ManyToOne
    private AdmUnidadejec ejeCodigo;
    @JoinColumn(name = "ent_id", referencedColumnName = "ent_id")
    @ManyToOne
    private AdmEntidad entId;

    public AdmEntxunidadejec() {
    }

    public AdmEntxunidadejec(Integer eneId) {
        this.eneId = eneId;
    }

    public Integer getEneId() {
        return eneId;
    }

    public void setEneId(Integer eneId) {
        this.eneId = eneId;
    }

    public String getEneNombre() {
        return eneNombre;
    }

    public void setEneNombre(String eneNombre) {
        this.eneNombre = eneNombre;
    }

    public Boolean getEneEstado() {
        return eneEstado;
    }

    public void setEneEstado(Boolean eneEstado) {
        this.eneEstado = eneEstado;
    }

    public AdmUnidadejec getEjeCodigo() {
        return ejeCodigo;
    }

    public void setEjeCodigo(AdmUnidadejec ejeCodigo) {
        this.ejeCodigo = ejeCodigo;
    }

    public AdmEntidad getEntId() {
        return entId;
    }

    public void setEntId(AdmEntidad entId) {
        this.entId = entId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eneId != null ? eneId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdmEntxunidadejec)) {
            return false;
        }
        AdmEntxunidadejec other = (AdmEntxunidadejec) object;
        if ((this.eneId == null && other.eneId != null) || (this.eneId != null && !this.eneId.equals(other.eneId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.veeduria.adm.dao.AdmEntxunidadejec[ eneId=" + eneId + " ]";
    }
    
}
