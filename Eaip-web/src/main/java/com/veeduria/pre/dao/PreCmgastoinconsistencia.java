/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.veeduria.pre.dao;

import com.veeduria.adm.dao.AdmLoginconsistencias;
import com.veeduria.adm.dao.AdmValidacargaarchivo;
import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author luz
 */
@Entity
@Table(name = "pre_cmgastoinconsistencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PreCmgastoinconsistencia.findAll", query = "SELECT p FROM PreCmgastoinconsistencia p"),
    @NamedQuery(name = "PreCmgastoinconsistencia.findByGerId", query = "SELECT p FROM PreCmgastoinconsistencia p WHERE p.gerId = :gerId"),
    @NamedQuery(name = "PreCmgastoinconsistencia.findByGerProcesado", query = "SELECT p FROM PreCmgastoinconsistencia p WHERE p.gerProcesado = :gerProcesado"),
    @NamedQuery(name = "PreCmgastoinconsistencia.inconsistenciasporArchivo", query = "SELECT p FROM PreCmgastoinconsistencia p JOIN p.ginId gi JOIN gi.lgregId lg WHERE lg.lgregId = :lgregId ORDER BY gi.ginCodcuenta"),
    @NamedQuery(name = "PreCmgastoinconsistencia.detInconsistencia", query = "SELECT p FROM PreCmgastoinconsistencia p JOIN p.valId va WHERE va.valDescripcion = :valDescripcion"),
    
})

public class PreCmgastoinconsistencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ger_id")
    private Long gerId;
    @Column(name = "ger_procesado")
    private Boolean gerProcesado;
    @JoinColumn(name = "val_id", referencedColumnName = "val_id")
    @ManyToOne
    private AdmValidacargaarchivo valId;
    @JoinColumn(name = "gin_id", referencedColumnName = "gin_id")
    @ManyToOne
    private PreCmgastoinicial ginId;
    @OneToMany(mappedBy = "gerId")
    private List<AdmLoginconsistencias> admLoginconsistenciasList;

    public PreCmgastoinconsistencia() {
    }

    public PreCmgastoinconsistencia(Long gerId) {
        this.gerId = gerId;
    }

    public Long getGerId() {
        return gerId;
    }

    public void setGerId(Long gerId) {
        this.gerId = gerId;
    }

    public Boolean getGerProcesado() {
        return gerProcesado;
    }

    public void setGerProcesado(Boolean gerProcesado) {
        this.gerProcesado = gerProcesado;
    }

    public AdmValidacargaarchivo getValId() {
        return valId;
    }

    public void setValId(AdmValidacargaarchivo valId) {
        this.valId = valId;
    }

    public PreCmgastoinicial getGinId() {
        return ginId;
    }

    public void setGinId(PreCmgastoinicial ginId) {
        this.ginId = ginId;
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
        hash += (gerId != null ? gerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PreCmgastoinconsistencia)) {
            return false;
        }
        PreCmgastoinconsistencia other = (PreCmgastoinconsistencia) object;
        if ((this.gerId == null && other.gerId != null) || (this.gerId != null && !this.gerId.equals(other.gerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.veeduria.dao.PreCmgastoinconsistencia[ gerId=" + gerId + " ]";
    }
    
}
