/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veeduria.pre.dao;

import com.veeduria.adm.dao.AdmLoginconsistencias;
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
@Table(name = "pre_accionincgasto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PreAccionincgasto.findAll", query = "SELECT p FROM PreAccionincgasto p"),
    @NamedQuery(name = "PreAccionincgasto.findByAigId", query = "SELECT p FROM PreAccionincgasto p WHERE p.aigId = :aigId"),
    @NamedQuery(name = "PreAccionincgasto.findByAidCodcntorg", query = "SELECT p FROM PreAccionincgasto p WHERE p.aidCodcntorg = :aidCodcntorg"),
    @NamedQuery(name = "PreAccionincgasto.findByAidCodcnthomlogado", query = "SELECT p FROM PreAccionincgasto p WHERE p.aidCodcnthomlogado = :aidCodcnthomlogado"),
    @NamedQuery(name = "PreAccionincgasto.findByAidEst", query = "SELECT p FROM PreAccionincgasto p WHERE p.aidEst = :aidEst")})
public class PreAccionincgasto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "aig_id")
    private Long aigId;
    @Size(max = 200)
    @Column(name = "aid_codcntorg")
    private String aidCodcntorg;
    @Size(max = 200)
    @Column(name = "aid_codcnthomlogado")
    private String aidCodcnthomlogado;
    @Column(name = "aid_est")
    private Boolean aidEst;
    @JoinColumn(name = "log_id", referencedColumnName = "log_id")
    @ManyToOne
    private AdmLoginconsistencias logId;

    public PreAccionincgasto() {
    }

    public PreAccionincgasto(Long aigId) {
        this.aigId = aigId;
    }

    public Long getAigId() {
        return aigId;
    }

    public void setAigId(Long aigId) {
        this.aigId = aigId;
    }

    public String getAidCodcntorg() {
        return aidCodcntorg;
    }

    public void setAidCodcntorg(String aidCodcntorg) {
        this.aidCodcntorg = aidCodcntorg;
    }

    public String getAidCodcnthomlogado() {
        return aidCodcnthomlogado;
    }

    public void setAidCodcnthomlogado(String aidCodcnthomlogado) {
        this.aidCodcnthomlogado = aidCodcnthomlogado;
    }

    public Boolean getAidEst() {
        return aidEst;
    }

    public void setAidEst(Boolean aidEst) {
        this.aidEst = aidEst;
    }

    public AdmLoginconsistencias getLogId() {
        return logId;
    }

    public void setLogId(AdmLoginconsistencias logId) {
        this.logId = logId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aigId != null ? aigId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PreAccionincgasto)) {
            return false;
        }
        PreAccionincgasto other = (PreAccionincgasto) object;
        if ((this.aigId == null && other.aigId != null) || (this.aigId != null && !this.aigId.equals(other.aigId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.veeduria.dao.PreAccionincgasto[ aigId=" + aigId + " ]";
    }
    
}
