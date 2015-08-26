/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veeduria.sys.dao;

import com.veeduria.pre.dao.PreClaseplancuenta;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author luz
 */
@Entity
@Table(name = "sys_archivo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SysArchivo.findAll", query = "SELECT s FROM SysArchivo s ORDER BY s.cpcId.cpcNombre"),
    @NamedQuery(name = "SysArchivo.findByArcId", query = "SELECT s FROM SysArchivo s WHERE s.arcId = :arcId"),
    @NamedQuery(name = "SysArchivo.findByArcNombre", query = "SELECT s FROM SysArchivo s WHERE s.arcNombre = :arcNombre"),
    @NamedQuery(name = "SysArchivo.findByArcDescripcion", query = "SELECT s FROM SysArchivo s WHERE s.arcDescripcion = :arcDescripcion"),
    @NamedQuery(name = "SysArchivo.findByArcEstado", query = "SELECT s FROM SysArchivo s WHERE s.arcEstado = :arcEstado"),
    @NamedQuery(name = "SysArchivo.findByArcInsert", query = "SELECT s FROM SysArchivo s WHERE s.arcInsert = :arcInsert"),
    @NamedQuery(name = "SysArchivo.findByArcColumnas", query = "SELECT s FROM SysArchivo s WHERE s.arcColumnas = :arcColumnas"),
    @NamedQuery(name = "SysArchivo.findByArcTabla", query = "SELECT s FROM SysArchivo s WHERE s.arcTabla = :arcTabla"),
    @NamedQuery(name = "SysArchivo.findByArcNavegacion", query = "SELECT s FROM SysArchivo s WHERE s.arcNavegacion = :arcNavegacion"),
    @NamedQuery(name = "SysArchivo.entporClaseCuenta", query = "SELECT s FROM SysArchivo s JOIN s.cpcId c JOIN c.admEntidadList e WHERE e.cpcId = :cpcId"),
    @NamedQuery(name = "SysArchivo.archivoporCpcId", query = "SELECT s FROM SysArchivo s WHERE s.cpcId.cpcId = :cpcId ORDER BY s.arcNombre")})

public class SysArchivo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "arc_id")
    private Integer arcId;
    @Size(max = 250)
    @Column(name = "arc_nombre")
    private String arcNombre;
    @Size(max = 2147483647)
    @Column(name = "arc_descripcion")
    private String arcDescripcion;
    @Column(name = "arc_estado")
    private Boolean arcEstado;
    @Size(max = 2147483647)
    @Column(name = "arc_insert")
    private String arcInsert;
    @Column(name = "arc_columnas")
    private Integer arcColumnas;
    @Size(max = 50)
    @Column(name = "arc_tabla")
    private String arcTabla;
    @Size(max = 100)
    @Column(name = "arc_navegacion")
    private String arcNavegacion;
    @JoinColumn(name = "cpc_id", referencedColumnName = "cpc_id")
    @ManyToOne
    private PreClaseplancuenta cpcId;

    public SysArchivo() {
    }

    public SysArchivo(Integer arcId) {
        this.arcId = arcId;
    }

    public Integer getArcId() {
        return arcId;
    }

    public void setArcId(Integer arcId) {
        this.arcId = arcId;
    }

    public String getArcNombre() {
        return arcNombre;
    }

    public void setArcNombre(String arcNombre) {
        this.arcNombre = arcNombre;
    }

    public String getArcDescripcion() {
        return arcDescripcion;
    }

    public void setArcDescripcion(String arcDescripcion) {
        this.arcDescripcion = arcDescripcion;
    }

    public Boolean getArcEstado() {
        return arcEstado;
    }

    public void setArcEstado(Boolean arcEstado) {
        this.arcEstado = arcEstado;
    }

    public String getArcInsert() {
        return arcInsert;
    }

    public void setArcInsert(String arcInsert) {
        this.arcInsert = arcInsert;
    }

    public Integer getArcColumnas() {
        return arcColumnas;
    }

    public void setArcColumnas(Integer arcColumnas) {
        this.arcColumnas = arcColumnas;
    }

    public String getArcTabla() {
        return arcTabla;
    }

    public void setArcTabla(String arcTabla) {
        this.arcTabla = arcTabla;
    }

    public String getArcNavegacion() {
        return arcNavegacion;
    }

    public void setArcNavegacion(String arcNavegacion) {
        this.arcNavegacion = arcNavegacion;
    }

    public PreClaseplancuenta getCpcId() {
        return cpcId;
    }

    public void setCpcId(PreClaseplancuenta cpcId) {
        this.cpcId = cpcId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (arcId != null ? arcId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SysArchivo)) {
            return false;
        }
        SysArchivo other = (SysArchivo) object;
        if ((this.arcId == null && other.arcId != null) || (this.arcId != null && !this.arcId.equals(other.arcId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.veeduria.adm.dao.SysArchivo[ arcId=" + arcId + " ]";
    }
}
