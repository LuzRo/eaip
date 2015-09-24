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
@Table(name = "adm_unidadejec")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdmUnidadejec.findAll", query = "SELECT a FROM AdmUnidadejec a"),
    @NamedQuery(name = "AdmUnidadejec.findByEjeCodigo", query = "SELECT a FROM AdmUnidadejec a WHERE a.ejeCodigo = :ejeCodigo"),
    @NamedQuery(name = "AdmUnidadejec.findByEjeNombre", query = "SELECT a FROM AdmUnidadejec a WHERE a.ejeNombre = :ejeNombre"),
    @NamedQuery(name = "AdmUnidadejec.findByEjeDescripcion", query = "SELECT a FROM AdmUnidadejec a WHERE a.ejeDescripcion = :ejeDescripcion"),
    @NamedQuery(name = "AdmUnidadejec.findByEjeEstado", query = "SELECT a FROM AdmUnidadejec a WHERE a.ejeEstado = :ejeEstado"),
@NamedQuery(name = "AdmUnidadejec.unixEntidad", query = "SELECT a FROM AdmUnidadejec a JOIN a.admEntxunidadejecList uen JOIN uen.entId en WHERE en.entId = :entId ")})
public class AdmUnidadejec implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "eje_codigo")
    private String ejeCodigo;
    @Size(max = 200)
    @Column(name = "eje_nombre")
    private String ejeNombre;
    @Size(max = 200)
    @Column(name = "eje_descripcion")
    private String ejeDescripcion;
    @Column(name = "eje_estado")
    private Boolean ejeEstado;
    @OneToMany(mappedBy = "ejeCodigo")
    private List<AdmEntxunidadejec> admEntxunidadejecList;

    public AdmUnidadejec() {
    }

    public AdmUnidadejec(String ejeCodigo) {
        this.ejeCodigo = ejeCodigo;
    }

    public String getEjeCodigo() {
        return ejeCodigo;
    }

    public void setEjeCodigo(String ejeCodigo) {
        this.ejeCodigo = ejeCodigo;
    }

    public String getEjeNombre() {
        return ejeNombre;
    }

    public void setEjeNombre(String ejeNombre) {
        this.ejeNombre = ejeNombre;
    }

    public String getEjeDescripcion() {
        return ejeDescripcion;
    }

    public void setEjeDescripcion(String ejeDescripcion) {
        this.ejeDescripcion = ejeDescripcion;
    }

    public Boolean getEjeEstado() {
        return ejeEstado;
    }

    public void setEjeEstado(Boolean ejeEstado) {
        this.ejeEstado = ejeEstado;
    }

    @XmlTransient
    public List<AdmEntxunidadejec> getAdmEntxunidadejecList() {
        return admEntxunidadejecList;
    }

    public void setAdmEntxunidadejecList(List<AdmEntxunidadejec> admEntxunidadejecList) {
        this.admEntxunidadejecList = admEntxunidadejecList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ejeCodigo != null ? ejeCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdmUnidadejec)) {
            return false;
        }
        AdmUnidadejec other = (AdmUnidadejec) object;
        if ((this.ejeCodigo == null && other.ejeCodigo != null) || (this.ejeCodigo != null && !this.ejeCodigo.equals(other.ejeCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.veeduria.adm.dao.AdmUnidadejec[ ejeCodigo=" + ejeCodigo + " ]";
    }
}
