/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veeduria.not.dao;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author luz
 */
@Entity
@Table(name = "ptc_logpuntocontrol")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PtcLogpuntocontrol.findAll", query = "SELECT p FROM PtcLogpuntocontrol p"),
    @NamedQuery(name = "PtcLogpuntocontrol.findBySegId", query = "SELECT p FROM PtcLogpuntocontrol p WHERE p.segId = :segId"),
    @NamedQuery(name = "PtcLogpuntocontrol.findBySegFechacreacion", query = "SELECT p FROM PtcLogpuntocontrol p WHERE p.segFechacreacion = :segFechacreacion"),
    @NamedQuery(name = "PtcLogpuntocontrol.findBySegActividad", query = "SELECT p FROM PtcLogpuntocontrol p WHERE p.segActividad = :segActividad"),
 @NamedQuery(name = "PtcLogpuntocontrol.logXPunto", query = "SELECT p FROM PtcLogpuntocontrol p JOIN p.ppcId ppc WHERE ppc.ppcId = :ppcId ORDER BY p.segFechacreacion DESC")
})
public class PtcLogpuntocontrol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "seg_id")
    private Long segId;
    @Column(name = "seg_fechacreacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date segFechacreacion;
    @Size(max = 2147483647)
    @Column(name = "seg_actividad")
    private String segActividad;
    @Column(name = "seg_est")
    private Boolean segEst;
    @Column(name = "indversion")
    @Version
    private Integer indversion;
    @JoinColumn(name = "ppc_id", referencedColumnName = "ppc_id")
    @ManyToOne
    private PtcPuntoscontrolxprocesoxfunc ppcId;

    public PtcLogpuntocontrol() {
    }

    public PtcLogpuntocontrol(Long segId) {
        this.segId = segId;
    }

    public Long getSegId() {
        return segId;
    }

    public void setSegId(Long segId) {
        this.segId = segId;
    }

    public Date getSegFechacreacion() {
        return segFechacreacion;
    }

    public void setSegFechacreacion(Date segFechacreacion) {
        this.segFechacreacion = segFechacreacion;
    }

    public String getSegActividad() {
        return segActividad;
    }

    public void setSegActividad(String segActividad) {
        this.segActividad = segActividad;
    }

    public PtcPuntoscontrolxprocesoxfunc getPpcId() {
        return ppcId;
    }

    public void setPpcId(PtcPuntoscontrolxprocesoxfunc ppcId) {
        this.ppcId = ppcId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (segId != null ? segId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PtcLogpuntocontrol)) {
            return false;
        }
        PtcLogpuntocontrol other = (PtcLogpuntocontrol) object;
        if ((this.segId == null && other.segId != null) || (this.segId != null && !this.segId.equals(other.segId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.veeduria.dao.PtcLogpuntocontrol[ segId=" + segId + " ]";
    }

    /**
     * @return the segEst
     */
    public Boolean getSegEst() {
        return segEst;
    }

    /**
     * @param segEst the segEst to set
     */
    public void setSegEst(Boolean segEst) {
        this.segEst = segEst;
    }

    /**
     * @return the indversion
     */
    public Integer getIndversion() {
        return indversion;
    }

    /**
     * @param indversion the indversion to set
     */
    public void setIndversion(Integer indversion) {
        this.indversion = indversion;
    }

}
