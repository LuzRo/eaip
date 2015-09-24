/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veeduria.sys.dao;

import com.veeduria.adm.dao.AdmEntidad;
import com.veeduria.sys.dao.SysArchivo;
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
@Table(name = "sys_archivosporentidades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SysArchivosporentidades.findAll", query = "SELECT t FROM SysArchivosporentidades t"),
    @NamedQuery(name = "SysArchivosporentidades.findByApeId", query = "SELECT t FROM SysArchivosporentidades t WHERE t.apeId = :apeId"),
    @NamedQuery(name = "SysArchivosporentidades.findByApeInsert", query = "SELECT t FROM SysArchivosporentidades t WHERE t.apeInsert = :apeInsert"),
    @NamedQuery(name = "SysArchivosporentidades.findByApeColumnas", query = "SELECT t FROM SysArchivosporentidades t WHERE t.apeColumnas = :apeColumnas"),
    @NamedQuery(name = "SysArchivosporentidades.findByApeNomtabla", query = "SELECT t FROM SysArchivosporentidades t WHERE t.apeNomtabla = :apeNomtabla"),
    @NamedQuery(name = "SysArchivosporentidades.archivosPorEntidades", query = "SELECT t FROM SysArchivosporentidades t JOIN t.entId en JOIN t.arcId ar WHERE en.entId = :entId AND ar.arcId = :arcId ")})
public class SysArchivosporentidades implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ape_id")
    private Long apeId;
    @Size(max = 2147483647)
    @Column(name = "ape_insert")
    private String apeInsert;
    @Column(name = "ape_columnas")
    private Integer apeColumnas;
    @Size(max = 200)
    @Column(name = "ape_nomtabla")
    private String apeNomtabla;
    @JoinColumn(name = "arc_id", referencedColumnName = "arc_id")
    @ManyToOne
    private SysArchivo arcId;
    @JoinColumn(name = "ent_id", referencedColumnName = "ent_id")
    @ManyToOne
    private AdmEntidad entId;

    public SysArchivosporentidades() {
    }

    public SysArchivosporentidades(Long apeId) {
        this.apeId = apeId;
    }

    public Long getApeId() {
        return apeId;
    }

    public void setApeId(Long apeId) {
        this.apeId = apeId;
    }

    public String getApeInsert() {
        return apeInsert;
    }

    public void setApeInsert(String apeInsert) {
        this.apeInsert = apeInsert;
    }

    public Integer getApeColumnas() {
        return apeColumnas;
    }

    public void setApeColumnas(Integer apeColumnas) {
        this.apeColumnas = apeColumnas;
    }

    public String getApeNomtabla() {
        return apeNomtabla;
    }

    public void setApeNomtabla(String apeNomtabla) {
        this.apeNomtabla = apeNomtabla;
    }

    public SysArchivo getArcId() {
        return arcId;
    }

    public void setArcId(SysArchivo arcId) {
        this.arcId = arcId;
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
        hash += (apeId != null ? apeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SysArchivosporentidades)) {
            return false;
        }
        SysArchivosporentidades other = (SysArchivosporentidades) object;
        return (this.apeId != null || other.apeId == null) && (this.apeId == null || this.apeId.equals(other.apeId));
    }

    @Override
    public String toString() {
        return "com.veeduria.sys.dao.SysArchivosporentidades[ apeId=" + apeId + " ]";
    }
}
