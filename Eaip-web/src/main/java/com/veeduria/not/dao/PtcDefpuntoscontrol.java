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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author luz
 */
@Entity
@Table(name = "ptc_defpuntoscontrol")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PtcDefpuntoscontrol.findAll", query = "SELECT p FROM PtcDefpuntoscontrol p ORDER BY p.defDescripcion"),
    @NamedQuery(name = "PtcDefpuntoscontrol.findByDefId", query = "SELECT p FROM PtcDefpuntoscontrol p WHERE p.defId = :defId"),
    @NamedQuery(name = "PtcDefpuntoscontrol.findByDefCodigo", query = "SELECT p FROM PtcDefpuntoscontrol p WHERE p.defCodigo = :defCodigo"),
    @NamedQuery(name = "PtcDefpuntoscontrol.findByDefDescripcion", query = "SELECT p FROM PtcDefpuntoscontrol p WHERE p.defDescripcion = :defDescripcion"),
    @NamedQuery(name = "PtcDefpuntoscontrol.findByDefEstado", query = "SELECT p FROM PtcDefpuntoscontrol p WHERE p.defEstado = :defEstado"),
    @NamedQuery(name = "PtcDefpuntoscontrol.ptcDefXTipo", query = "SELECT p FROM PtcDefpuntoscontrol p JOIN p.tpcId tpc  WHERE tpc.tpcId  = :tpcId ORDER BY p.defDescripcion"),

})
public class PtcDefpuntoscontrol implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "def_id")
    private Integer defId;
    @Size(max = 50)
    @Column(name = "def_codigo")
    private String defCodigo;
    @Size(max = 2147483647)
    @Column(name = "def_descripcion")
    private String defDescripcion;
    @Column(name = "def_estado")
    private Boolean defEstado;
    @Column(name = "indversion")
    private Integer indversion;
    @JoinColumn(name = "tpc_id", referencedColumnName = "tpc_id")
    @ManyToOne
    private PtcTipopuntocontrol tpcId;
    @OneToMany(mappedBy = "defId")
    private List<PtcPuntoscontrolxprocesoxfunc> ptcPuntoscontrolxprocesoxfuncList;

    public PtcDefpuntoscontrol() {
    }

    public PtcDefpuntoscontrol(Integer defId) {
        this.defId = defId;
    }

    public Integer getDefId() {
        return defId;
    }

    public void setDefId(Integer defId) {
        this.defId = defId;
    }

    public String getDefCodigo() {
        return defCodigo;
    }

    public void setDefCodigo(String defCodigo) {
        this.defCodigo = defCodigo;
    }

    public String getDefDescripcion() {
        return defDescripcion;
    }

    public void setDefDescripcion(String defDescripcion) {
        this.defDescripcion = defDescripcion;
    }

    public Boolean getDefEstado() {
        return defEstado;
    }

    public void setDefEstado(Boolean defEstado) {
        this.defEstado = defEstado;
    }

    public Integer getIndversion() {
        return indversion;
    }

    public void setIndversion(Integer indversion) {
        this.indversion = indversion;
    }

    public PtcTipopuntocontrol getTpcId() {
        return tpcId;
    }

    public void setTpcId(PtcTipopuntocontrol tpcId) {
        this.tpcId = tpcId;
    }

    @XmlTransient
    public List<PtcPuntoscontrolxprocesoxfunc> getPtcPuntoscontrolxprocesoxfuncList() {
        return ptcPuntoscontrolxprocesoxfuncList;
    }

    public void setPtcPuntoscontrolxprocesoxfuncList(List<PtcPuntoscontrolxprocesoxfunc> ptcPuntoscontrolxprocesoxfuncList) {
        this.ptcPuntoscontrolxprocesoxfuncList = ptcPuntoscontrolxprocesoxfuncList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (defId != null ? defId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PtcDefpuntoscontrol)) {
            return false;
        }
        PtcDefpuntoscontrol other = (PtcDefpuntoscontrol) object;
        if ((this.defId == null && other.defId != null) || (this.defId != null && !this.defId.equals(other.defId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.veeduria.dao.PtcDefpuntoscontrol[ defId=" + defId + " ]";
    }
    
}
