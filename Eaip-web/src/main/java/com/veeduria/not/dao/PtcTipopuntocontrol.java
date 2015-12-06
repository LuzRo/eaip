/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veeduria.not.dao;

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
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author luz
 */
@Entity
@Table(name = "ptc_tipopuntocontrol")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PtcTipopuntocontrol.findAll", query = "SELECT p FROM PtcTipopuntocontrol p ORDER BY p.tcpNombre"),
    @NamedQuery(name = "PtcTipopuntocontrol.findByTpcId", query = "SELECT p FROM PtcTipopuntocontrol p WHERE p.tpcId = :tpcId"),
    @NamedQuery(name = "PtcTipopuntocontrol.findByTcpNombre", query = "SELECT p FROM PtcTipopuntocontrol p WHERE p.tcpNombre = :tcpNombre"),
    @NamedQuery(name = "PtcTipopuntocontrol.findByTpcEstado", query = "SELECT p FROM PtcTipopuntocontrol p WHERE p.tpcEstado = :tpcEstado")})
public class PtcTipopuntocontrol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "tpc_id")
    private Integer tpcId;
    @Size(max = 50)
    @Column(name = "tcp_nombre")
    private String tcpNombre;
    @Column(name = "tpc_estado")
    private Boolean tpcEstado;  
    @OneToMany(mappedBy = "tpcId")
    private List<PtcDefpuntoscontrol> ptcDefpuntoscontrolList;

    public PtcTipopuntocontrol() {
    }

    public PtcTipopuntocontrol(Integer tpcId) {
        this.tpcId = tpcId;
    }

    public Integer getTpcId() {
        return tpcId;
    }

    public void setTpcId(Integer tpcId) {
        this.tpcId = tpcId;
    }

    public String getTcpNombre() {
        return tcpNombre;
    }

    public void setTcpNombre(String tcpNombre) {
        this.tcpNombre = tcpNombre;
    }

    public Boolean getTpcEstado() {
        return tpcEstado;
    }

    public void setTpcEstado(Boolean tpcEstado) {
        this.tpcEstado = tpcEstado;
    }

    @XmlTransient
    public List<PtcDefpuntoscontrol> getPtcDefpuntoscontrolList() {
        return ptcDefpuntoscontrolList;
    }

    public void setPtcDefpuntoscontrolList(List<PtcDefpuntoscontrol> ptcDefpuntoscontrolList) {
        this.ptcDefpuntoscontrolList = ptcDefpuntoscontrolList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tpcId != null ? tpcId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PtcTipopuntocontrol)) {
            return false;
        }
        PtcTipopuntocontrol other = (PtcTipopuntocontrol) object;
        return !((this.tpcId == null && other.tpcId != null) || (this.tpcId != null && !this.tpcId.equals(other.tpcId)));
    }

    @Override
    public String toString() {
        return "com.veeduria.dao.PtcTipopuntocontrol[ tpcId=" + tpcId + " ]";
    }

   

}
