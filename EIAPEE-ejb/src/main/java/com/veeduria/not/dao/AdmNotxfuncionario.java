/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veeduria.not.dao;

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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author luz
 */
@Entity
@Table(name = "adm_notxfuncionario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdmNotxfuncionario.findAll", query = "SELECT a FROM AdmNotxfuncionario a"),
    @NamedQuery(name = "AdmNotxfuncionario.findByNtfrId", query = "SELECT a FROM AdmNotxfuncionario a WHERE a.ntfrId = :ntfrId"),
    @NamedQuery(name = "AdmNotxfuncionario.findByNtfrEstado", query = "SELECT a FROM AdmNotxfuncionario a WHERE a.ntfrEstado = :ntfrEstado")})
public class AdmNotxfuncionario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
     @GeneratedValue(strategy = GenerationType.IDENTITY)    
    @Column(name = "ntfr_id")
    private Integer ntfrId;
    @Column(name = "ntfr_estado")
    private Boolean ntfrEstado;
    @Column(name = "ntfr_atendida")
    private Boolean ntfrAtendida;
    @Column(name = "ntfr_fechaatendida")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date ntfrFechaatendida;
    @JoinColumn(name = "frn_id", referencedColumnName = "frn_id")
    @ManyToOne
    private SysFuncionario frnId;
    @JoinColumn(name = "not_id", referencedColumnName = "not_id")
    @ManyToOne
    private AdmNotificacion notId;
     @OneToMany(mappedBy = "ntfrId")
    private List<PtcPuntoscontrolxprocesoxfunc> ptcPuntoscontrolxprocesoxfuncList;

    public AdmNotxfuncionario() {
    }

    public AdmNotxfuncionario(Integer ntfrId) {
        this.ntfrId = ntfrId;
    }

    public Integer getNtfrId() {
        return ntfrId;
    }

    public void setNtfrId(Integer ntfrId) {
        this.ntfrId = ntfrId;
    }

    public Boolean getNtfrEstado() {
        return ntfrEstado;
    }

    public void setNtfrEstado(Boolean ntfrEstado) {
        this.ntfrEstado = ntfrEstado;
    }

    public SysFuncionario getFrnId() {
        return frnId;
    }

    public void setFrnId(SysFuncionario frnId) {
        this.frnId = frnId;
    }

    public AdmNotificacion getNotId() {
        return notId;
    }

    public void setNotId(AdmNotificacion notId) {
        this.notId = notId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ntfrId != null ? ntfrId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdmNotxfuncionario)) {
            return false;
        }
        AdmNotxfuncionario other = (AdmNotxfuncionario) object;
        if ((this.ntfrId == null && other.ntfrId != null) || (this.ntfrId != null && !this.ntfrId.equals(other.ntfrId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.veeduria.adm.dao.AdmNotxfuncionario[ ntfrId=" + ntfrId + " ]";
    }

    /**
     * @return the ptcPuntoscontrolxprocesoxfuncList
     */
    public List<PtcPuntoscontrolxprocesoxfunc> getPtcPuntoscontrolxprocesoxfuncList() {
        return ptcPuntoscontrolxprocesoxfuncList;
    }

    /**
     * @param ptcPuntoscontrolxprocesoxfuncList the ptcPuntoscontrolxprocesoxfuncList to set
     */
    public void setPtcPuntoscontrolxprocesoxfuncList(List<PtcPuntoscontrolxprocesoxfunc> ptcPuntoscontrolxprocesoxfuncList) {
        this.ptcPuntoscontrolxprocesoxfuncList = ptcPuntoscontrolxprocesoxfuncList;
    }

    /**
     * @return the ntfrAtendida
     */
    public Boolean getNtfrAtendida() {
        return ntfrAtendida;
    }

    /**
     * @param ntfrAtendida the ntfrAtendida to set
     */
    public void setNtfrAtendida(Boolean ntfrAtendida) {
        this.ntfrAtendida = ntfrAtendida;
    }

    /**
     * @return the ntfrFechaatendida
     */
    public Date getNtfrFechaatendida() {
        return ntfrFechaatendida;
    }

    /**
     * @param ntfrFechaatendida the ntfrFechaatendida to set
     */
    public void setNtfrFechaatendida(Date ntfrFechaatendida) {
        this.ntfrFechaatendida = ntfrFechaatendida;
    }
    
}
