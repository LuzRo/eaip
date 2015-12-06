/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veeduria.adm.dao;

import com.veeduria.pre.dao.PreAccionincgasto;
import com.veeduria.pre.dao.PreCmgastoinconsistencia;
import com.veeduria.sys.dao.SysFuncionario;
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

/**
 *
 * @author luz
 */
@Entity
@Table(name = "adm_loginconsistencias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdmLoginconsistencias.findAll", query = "SELECT a FROM AdmLoginconsistencias a"),
    @NamedQuery(name = "AdmLoginconsistencias.findByLogId", query = "SELECT a FROM AdmLoginconsistencias a WHERE a.logId = :logId"),
    @NamedQuery(name = "AdmLoginconsistencias.findByLogFechaproceso", query = "SELECT a FROM AdmLoginconsistencias a WHERE a.logFechaproceso = :logFechaproceso"),
    @NamedQuery(name = "AdmLoginconsistencias.logIncXArchivoAplicado", query = "SELECT a FROM AdmLoginconsistencias a JOIN a.gerId ger"
            + " JOIN ger.ginId gin JOIN gin.lgregId lreg "
            + "WHERE lreg.lgregId = :lgregId AND a.logAplicado = :logAplicado ")
})
public class AdmLoginconsistencias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "log_id")
    private Long logId;
    @Column(name = "log_fechaproceso")
    @Temporal(TemporalType.TIMESTAMP)
    private Date logFechaproceso;
    @Column(name = "log_aplicado")
    private Boolean logAplicado;
    @JoinColumn(name = "ava_id", referencedColumnName = "ava_id")
    @ManyToOne
    private AdmAjustexvalidacion avaId;
    @JoinColumn(name = "ger_id", referencedColumnName = "ger_id")
    @ManyToOne
    private PreCmgastoinconsistencia gerId;
    @JoinColumn(name = "frn_id", referencedColumnName = "frn_id")
    @ManyToOne
    private SysFuncionario frnId;
    @OneToMany(mappedBy = "logId")
    private List<PreAccionincgasto> preAccionincgastoList;

    public AdmLoginconsistencias() {
    }

    public AdmLoginconsistencias(Long logId) {
        this.logId = logId;
    }

    public Long getLogId() {
        return logId;
    }

    public void setLogId(Long logId) {
        this.logId = logId;
    }

    public Date getLogFechaproceso() {
        return logFechaproceso;
    }

    public void setLogFechaproceso(Date logFechaproceso) {
        this.logFechaproceso = logFechaproceso;
    }

    public AdmAjustexvalidacion getAvaId() {
        return avaId;
    }

    public void setAvaId(AdmAjustexvalidacion avaId) {
        this.avaId = avaId;
    }

    public PreCmgastoinconsistencia getGerId() {
        return gerId;
    }

    public void setGerId(PreCmgastoinconsistencia gerId) {
        this.gerId = gerId;
    }

    public SysFuncionario getFrnId() {
        return frnId;
    }

    public void setFrnId(SysFuncionario frnId) {
        this.frnId = frnId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (logId != null ? logId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdmLoginconsistencias)) {
            return false;
        }
        AdmLoginconsistencias other = (AdmLoginconsistencias) object;
        if ((this.logId == null && other.logId != null) || (this.logId != null && !this.logId.equals(other.logId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.veeduria.dao.AdmLoginconsistencias[ logId=" + logId + " ]";
    }

    /**
     * @return the logAplicado
     */
    public Boolean getLogAplicado() {
        return logAplicado;
    }

    /**
     * @param logAplicado the logAplicado to set
     */
    public void setLogAplicado(Boolean logAplicado) {
        this.logAplicado = logAplicado;
    }

    /**
     * @return the preAccionincgastoList
     */
    public List<PreAccionincgasto> getPreAccionincgastoList() {
        return preAccionincgastoList;
    }

    /**
     * @param preAccionincgastoList the preAccionincgastoList to set
     */
    public void setPreAccionincgastoList(List<PreAccionincgasto> preAccionincgastoList) {
        this.preAccionincgastoList = preAccionincgastoList;
    }

}
