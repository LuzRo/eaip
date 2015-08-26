/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veeduria.not.dao;

import com.veeduria.adm.dao.AdmProceso;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fernando
 */
@Entity
@Table(name = "ptc_puntoscontrolxprocesoxfunc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PtcPuntoscontrolxprocesoxfunc.findAll", query = "SELECT p FROM PtcPuntoscontrolxprocesoxfunc p"),
    @NamedQuery(name = "PtcPuntoscontrolxprocesoxfunc.findByPpcId", query = "SELECT p FROM PtcPuntoscontrolxprocesoxfunc p WHERE p.ppcId = :ppcId"),
    @NamedQuery(name = "PtcPuntoscontrolxprocesoxfunc.findByPpcFrecuencia", query = "SELECT p FROM PtcPuntoscontrolxprocesoxfunc p WHERE p.ppcFrecuencia = :ppcFrecuencia"),
    @NamedQuery(name = "PtcPuntoscontrolxprocesoxfunc.findByPpcFechacorte", query = "SELECT p FROM PtcPuntoscontrolxprocesoxfunc p WHERE p.ppcFechacorte = :ppcFechacorte"),
    @NamedQuery(name = "PtcPuntoscontrolxprocesoxfunc.findByPpcVersion", query = "SELECT p FROM PtcPuntoscontrolxprocesoxfunc p WHERE p.ppcVersion = :ppcVersion"),
    @NamedQuery(name = "PtcPuntoscontrolxprocesoxfunc.puntoCtrlXFuncXNot", query = "SELECT p FROM PtcPuntoscontrolxprocesoxfunc p JOIN p.ntfrId nxf JOIN nxf.notId notif JOIN nxf.frnId fnr WHERE notif.notId = :notId AND fnr.frnId = :fnrId ORDER BY notif.notFfinal DESC")

})
public class PtcPuntoscontrolxprocesoxfunc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ppc_id")
    private Long ppcId;
    @Size(max = 100)
    @Column(name = "ppc_frecuencia")
    private String ppcFrecuencia;
    @Column(name = "ppc_fechacorte")
    @Temporal(TemporalType.DATE)
    private Date ppcFechacorte;
    @Column(name = "ppc_version")
    private Boolean ppcVersion;
    @Column(name = "indversion")
    private Integer indversion;
    @Column(name = "ppc_est")
    private Boolean ppcEst;
    @JoinColumn(name = "ntfr_id", referencedColumnName = "ntfr_id")
    @ManyToOne
    private AdmNotxfuncionario ntfrId;
    @JoinColumn(name = "pro_id", referencedColumnName = "pro_id")
    @ManyToOne
    private AdmProceso proId;
    @JoinColumn(name = "def_id", referencedColumnName = "def_id")
    @ManyToOne
    private PtcDefpuntoscontrol defId;
    @OneToMany(mappedBy = "ppcId")
    private List<PtcLogpuntocontrol> ptcLogpuntocontrolList;

    public PtcPuntoscontrolxprocesoxfunc() {
    }

    public PtcPuntoscontrolxprocesoxfunc(Long ppcId) {
        this.ppcId = ppcId;
    }

    public Long getPpcId() {
        return ppcId;
    }

    public void setPpcId(Long ppcId) {
        this.ppcId = ppcId;
    }

    public String getPpcFrecuencia() {
        return ppcFrecuencia;
    }

    public void setPpcFrecuencia(String ppcFrecuencia) {
        this.ppcFrecuencia = ppcFrecuencia;
    }

    public Date getPpcFechacorte() {
        return ppcFechacorte;
    }

    public void setPpcFechacorte(Date ppcFechacorte) {
        this.ppcFechacorte = ppcFechacorte;
    }

    public Boolean getPpcVersion() {
        return ppcVersion;
    }

    public void setPpcVersion(Boolean ppcVersion) {
        this.ppcVersion = ppcVersion;
    }

    public Integer getIndversion() {
        return indversion;
    }

    public void setIndversion(Integer indversion) {
        this.indversion = indversion;
    }

    public AdmNotxfuncionario getNtfrId() {
        return ntfrId;
    }

    public void setNtfrId(AdmNotxfuncionario ntfrId) {
        this.ntfrId = ntfrId;
    }

    public AdmProceso getProId() {
        return proId;
    }

    public void setProId(AdmProceso proId) {
        this.proId = proId;
    }

    public PtcDefpuntoscontrol getDefId() {
        return defId;
    }

    public void setDefId(PtcDefpuntoscontrol defId) {
        this.defId = defId;
    }

    @XmlTransient
    public List<PtcLogpuntocontrol> getPtcLogpuntocontrolList() {
        return ptcLogpuntocontrolList;
    }

    public void setPtcLogpuntocontrolList(List<PtcLogpuntocontrol> ptcLogpuntocontrolList) {
        this.ptcLogpuntocontrolList = ptcLogpuntocontrolList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ppcId != null ? ppcId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PtcPuntoscontrolxprocesoxfunc)) {
            return false;
        }
        PtcPuntoscontrolxprocesoxfunc other = (PtcPuntoscontrolxprocesoxfunc) object;
        if ((this.ppcId == null && other.ppcId != null) || (this.ppcId != null && !this.ppcId.equals(other.ppcId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.veeduria.dao.PtcPuntoscontrolxprocesoxfunc[ ppcId=" + ppcId + " ]";
    }

    /**
     * @return the ppcEst
     */
    public Boolean getPpcEst() {
        return ppcEst;
    }

    /**
     * @param ppcEst the ppcEst to set
     */
    public void setPpcEst(Boolean ppcEst) {
        this.ppcEst = ppcEst;
    }

}
