/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veeduria.adm.dao;

import com.veeduria.pre.dao.PreClaseplancuenta;
import com.veeduria.sys.dao.SysRegistrocarga;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "adm_entidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdmEntidad.findAll", query = "SELECT a FROM AdmEntidad a ORDER BY a.entNombre"),
    @NamedQuery(name = "AdmEntidad.findByEntId", query = "SELECT a FROM AdmEntidad a WHERE a.entId = :entId"),
    @NamedQuery(name = "AdmEntidad.findByEntNombre", query = "SELECT a FROM AdmEntidad a WHERE a.entNombre = :entNombre"),
    @NamedQuery(name = "AdmEntidad.findByEntDescripcion", query = "SELECT a FROM AdmEntidad a WHERE a.entDescripcion = :entDescripcion"),
    @NamedQuery(name = "AdmEntidad.findByEntRegimen", query = "SELECT a FROM AdmEntidad a WHERE a.entRegimen = :entRegimen"),
    @NamedQuery(name = "AdmEntidad.findByEntSigla", query = "SELECT a FROM AdmEntidad a WHERE a.entSigla = :entSigla"),
    @NamedQuery(name = "AdmEntidad.findByEntEstado", query = "SELECT a FROM AdmEntidad a WHERE a.entEstado = :entEstado"),
    @NamedQuery(name = "AdmEntidad.findByEntNiveles", query = "SELECT a FROM AdmEntidad a WHERE a.entNiveles = :entNiveles"),
    @NamedQuery(name = "AdmEntidad.entxSe", query = "SELECT a FROM AdmEntidad a JOIN a.sesId s WHERE s.sesId = :sesId"),
    @NamedQuery(name = "AdmEntidad.entxSa", query = "SELECT a FROM AdmEntidad a JOIN a.sadId sa WHERE sa.sadId = :sadId"),
    @NamedQuery(name = "AdmEntidad.entxTe", query = "SELECT a FROM AdmEntidad a JOIN a.tpeId t WHERE t.tpeId = :tpeId"),
    @NamedQuery(name = "AdmEntidad.entxSexSa", query = "SELECT a FROM AdmEntidad a JOIN a.sesId se JOIN a.sadId sa WHERE se.sesId = :sesId AND sa.sadId = :sadId"),
    @NamedQuery(name = "AdmEntidad.detxCodigo", query = "SELECT a FROM AdmEntidad a WHERE a.entNombre = :entNombre"),
    @NamedQuery(name = "AdmEntidad.findByEntCdsiscontable", query = "SELECT a FROM AdmEntidad a WHERE a.entCdsiscontable = :entCdsiscontable"),
    @NamedQuery(name = "AdmEntidad.findByEntCdpredis", query = "SELECT a FROM AdmEntidad a WHERE a.entCdpredis = :entCdpredis"),
    @NamedQuery(name = "AdmEntidad.findByEntCdsivicof", query = "SELECT a FROM AdmEntidad a WHERE a.entCdsivicof = :entCdsivicof"),
    @NamedQuery(name = "AdmEntidad.findByEntCdsegplan", query = "SELECT a FROM AdmEntidad a WHERE a.entCdsegplan = :entCdsegplan")})

public class AdmEntidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ent_id")
    private String entId;
    @Size(max = 250)
    @Column(name = "ent_nombre")
    private String entNombre;
    @Size(max = 2147483647)
    @Column(name = "ent_descripcion")
    private String entDescripcion;
    @Size(max = 50)
    @Column(name = "ent_regimen")
    private String entRegimen;
    @Size(max = 50)
    @Column(name = "ent_sigla")
    private String entSigla;
    @Column(name = "ent_estado")
    private Boolean entEstado;
    @Size(max = 100)
    @Column(name = "ent_niveles")
    private String entNiveles;
    @Size(max = 50)
    @Column(name = "ent_cdsiscontable")
    private String entCdsiscontable;
    @Size(max = 50)
    @Column(name = "ent_cdpredis")
    private String entCdpredis;
    @Size(max = 50)
    @Column(name = "ent_cdsivicof")
    private String entCdsivicof;
    @Size(max = 50)
    @Column(name = "ent_cdsegplan")
    private String entCdsegplan;
    @JoinColumn(name = "cpc_id", referencedColumnName = "cpc_id")
    @ManyToOne
    private PreClaseplancuenta cpcId;
    @JoinColumn(name = "tpe_id", referencedColumnName = "tpe_id")
    @ManyToOne
    private AdmTipoentidad tpeId;
    @JoinColumn(name = "ses_id", referencedColumnName = "ses_id")
    @ManyToOne
    private AdmSectorestruc sesId;
    @JoinColumn(name = "sad_id", referencedColumnName = "sad_id")
    @ManyToOne
    private AdmSectoradmin sadId;
    @JoinColumn(name = "nat_id", referencedColumnName = "nat_id")
    @ManyToOne
    private AdmNatjuridica natId;
    @OneToMany(mappedBy = "entId")
    private List<AdmEntiproc> admEntiprocList;
    @OneToMany(mappedBy = "entId")
    private List<AdmEntxunidadejec> admEntxunidadejecList;
    @OneToMany(mappedBy = "entId")
    private List<SysRegistrocarga> sysRegistrocargaList;

    public AdmEntidad() {
    }

    public AdmEntidad(String entId) {
        this.entId = entId;
    }

    public String getEntId() {
        return entId;
    }

    public void setEntId(String entId) {
        this.entId = entId;
    }

    public String getEntNombre() {
        return entNombre;
    }

    public void setEntNombre(String entNombre) {
        this.entNombre = entNombre;
    }

    public String getEntDescripcion() {
        return entDescripcion;
    }

    public void setEntDescripcion(String entDescripcion) {
        this.entDescripcion = entDescripcion;
    }

    public String getEntRegimen() {
        return entRegimen;
    }

    public void setEntRegimen(String entRegimen) {
        this.entRegimen = entRegimen;
    }

    public String getEntSigla() {
        return entSigla;
    }

    public void setEntSigla(String entSigla) {
        this.entSigla = entSigla;
    }

    public Boolean getEntEstado() {
        return entEstado;
    }

    public void setEntEstado(Boolean entEstado) {
        this.entEstado = entEstado;
    }

    @XmlTransient
    public List<AdmEntiproc> getAdmEntiprocList() {
        return admEntiprocList;
    }

    public void setAdmEntiprocList(List<AdmEntiproc> admEntiprocList) {
        this.admEntiprocList = admEntiprocList;
    }

    public AdmTipoentidad getTpeId() {
        return tpeId;
    }

    public void setTpeId(AdmTipoentidad tpeId) {
        this.tpeId = tpeId;
    }

    public AdmSectorestruc getSesId() {
        return sesId;
    }

    public void setSesId(AdmSectorestruc sesId) {
        this.sesId = sesId;
    }

    public AdmSectoradmin getSadId() {
        return sadId;
    }

    public void setSadId(AdmSectoradmin sadId) {
        this.sadId = sadId;
    }

    @XmlTransient
    public List<AdmEntxunidadejec> getAdmEntxunidadejecList() {
        return admEntxunidadejecList;
    }

    public void setAdmEntxunidadejecList(List<AdmEntxunidadejec> admEntxunidadejecList) {
        this.admEntxunidadejecList = admEntxunidadejecList;
    }

    @XmlTransient
    public List<SysRegistrocarga> getSysRegistrocargaList() {
        return sysRegistrocargaList;
    }

    public void setSysRegistrocargaList(List<SysRegistrocarga> sysRegistrocargaList) {
        this.sysRegistrocargaList = sysRegistrocargaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (entId != null ? entId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdmEntidad)) {
            return false;
        }
        AdmEntidad other = (AdmEntidad) object;
        if ((this.entId == null && other.entId != null) || (this.entId != null && !this.entId.equals(other.entId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.veeduria.adm.dao.AdmEntidad[ entId=" + entId + " ]";
    }

    /**
     * @return the cpcId
     */
    public PreClaseplancuenta getCpcId() {
        return cpcId;
    }

    /**
     * @param cpcId the cpcId to set
     */
    public void setCpcId(PreClaseplancuenta cpcId) {
        this.cpcId = cpcId;
    }

    /**
     * @return the natId
     */
    public AdmNatjuridica getNatId() {
        return natId;
    }

    /**
     * @param natId the natId to set
     */
    public void setNatId(AdmNatjuridica natId) {
        this.natId = natId;
    }

    /**
     * @return the entNiveles
     */
    public String getEntNiveles() {
        return entNiveles;
    }

    /**
     * @param entNiveles the entNiveles to set
     */
    public void setEntNiveles(String entNiveles) {
        this.entNiveles = entNiveles;
    }

    /**
     * @return the entCdsiscontable
     */
    public String getEntCdsiscontable() {
        return entCdsiscontable;
    }

    /**
     * @param entCdsiscontable the entCdsiscontable to set
     */
    public void setEntCdsiscontable(String entCdsiscontable) {
        this.entCdsiscontable = entCdsiscontable;
    }

    /**
     * @return the entCdpredis
     */
    public String getEntCdpredis() {
        return entCdpredis;
    }

    /**
     * @param entCdpredis the entCdpredis to set
     */
    public void setEntCdpredis(String entCdpredis) {
        this.entCdpredis = entCdpredis;
    }

    /**
     * @return the entCdsivicof
     */
    public String getEntCdsivicof() {
        return entCdsivicof;
    }

    /**
     * @param entCdsivicof the entCdsivicof to set
     */
    public void setEntCdsivicof(String entCdsivicof) {
        this.entCdsivicof = entCdsivicof;
    }

    /**
     * @return the entCdsegplan
     */
    public String getEntCdsegplan() {
        return entCdsegplan;
    }

    /**
     * @param entCdsegplan the entCdsegplan to set
     */
    public void setEntCdsegplan(String entCdsegplan) {
        this.entCdsegplan = entCdsegplan;
    }
}
