/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veeduria.sys.dao;

import com.veeduria.adm.dao.AdmComponenteproceso;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "sys_informe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SysInforme.findAll", query = "SELECT s FROM SysInforme s"),
    @NamedQuery(name = "SysInforme.findByInfId", query = "SELECT s FROM SysInforme s WHERE s.infId = :infId"),
    @NamedQuery(name = "SysInforme.findByInfNombre", query = "SELECT s FROM SysInforme s WHERE s.infNombre = :infNombre"),
    @NamedQuery(name = "SysInforme.findByInfDetalle", query = "SELECT s FROM SysInforme s WHERE s.infDetalle = :infDetalle"),
    @NamedQuery(name = "SysInforme.findByInfJasper", query = "SELECT s FROM SysInforme s WHERE s.infJasper = :infJasper"),
    @NamedQuery(name = "SysInforme.findByInfJasperruta", query = "SELECT s FROM SysInforme s WHERE s.infJasperruta = :infJasperruta"),
    @NamedQuery(name = "SysInforme.findByInfEst", query = "SELECT s FROM SysInforme s WHERE s.infEst = :infEst"),
    @NamedQuery(name = "SysInforme.findByIndversion", query = "SELECT s FROM SysInforme s WHERE s.indversion = :indversion"),
    @NamedQuery(name = "SysInforme.findByNumpanel", query = "SELECT s FROM SysInforme s WHERE s.numpanel = :numpanel "),
    @NamedQuery(name = "SysInforme.findByInfFrecuencia", query = "SELECT s FROM SysInforme s WHERE s.infFrecuencia = :infFrecuencia"),
    @NamedQuery(name = "SysInforme.infxFuncionario", query = "SELECT s FROM SysInforme s JOIN s.sysInfxfrnList infr JOIN infr.frnId inf WHERE inf.frnId = :frnId "),
    @NamedQuery(name = "SysInforme.detxNominforme", query = "SELECT s FROM SysInforme s WHERE s.infNombre = :infNombre"),
    @NamedQuery(name = "SysInforme.detxFrecuencia", query = "SELECT s FROM SysInforme s WHERE s.infFrecuencia = :infFrecuencia"),
    @NamedQuery(name = "SysInforme.infXCompXfre", query = "SELECT s FROM SysInforme s JOIN s.comId com WHERE com.comId = :comId AND s.infFrecuencia = :infFrecuencia ORDER BY s.infNombre"),
    @NamedQuery(name = "SysInforme.infXComp", query = "SELECT s FROM SysInforme s JOIN s.comId comp WHERE comp.comId = :comId ORDER BY s.infNombre")})

public class SysInforme implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "inf_id")
    private Integer infId;
    @Size(max = 100)
    @Column(name = "inf_nombre")
    private String infNombre;
    @Size(max = 2147483647)
    @Column(name = "inf_detalle")
    private String infDetalle;
    @Size(max = 150)
    @Column(name = "inf_jasper")
    private String infJasper;
    @Size(max = 500)
    @Column(name = "inf_jasperruta")
    private String infJasperruta;
    @Column(name = "inf_est")
    private Boolean infEst;
    @Column(name = "indversion")
    private Integer indversion;
    @Column(name = "numpanel")
    private Integer numpanel;
    @Size(max = 200)
    @Column(name = "inf_frecuencia")
    private String infFrecuencia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "infId")
    private List<SysInfxrol> sysInfxrolList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "infId")
    private List<SysInfxfrn> sysInfxfrnList;
    @OneToMany(mappedBy = "infId")
    @JoinColumn(name = "com_id", referencedColumnName = "com_id")
    @ManyToOne
    private AdmComponenteproceso comId;

    public SysInforme() {
    }

    public SysInforme(Integer infId) {
        this.infId = infId;
    }

    public Integer getInfId() {
        return infId;
    }

    public void setInfId(Integer infId) {
        this.infId = infId;
    }

    public String getInfNombre() {
        return infNombre;
    }

    public void setInfNombre(String infNombre) {
        this.infNombre = infNombre;
    }

    public String getInfDetalle() {
        return infDetalle;
    }

    public void setInfDetalle(String infDetalle) {
        this.infDetalle = infDetalle;
    }

    public String getInfJasper() {
        return infJasper;
    }

    public void setInfJasper(String infJasper) {
        this.infJasper = infJasper;
    }

    public String getInfJasperruta() {
        return infJasperruta;
    }

    public void setInfJasperruta(String infJasperruta) {
        this.infJasperruta = infJasperruta;
    }

    public Boolean getInfEst() {
        return infEst;
    }

    public void setInfEst(Boolean infEst) {
        this.infEst = infEst;
    }

    public Integer getIndversion() {
        return indversion;
    }

    public void setIndversion(Integer indversion) {
        this.indversion = indversion;
    }

    @XmlTransient
    public List<SysInfxrol> getSysInfxrolList() {
        return sysInfxrolList;
    }

    public void setSysInfxrolList(List<SysInfxrol> sysInfxrolList) {
        this.sysInfxrolList = sysInfxrolList;
    }

    @XmlTransient
    public List<SysInfxfrn> getSysInfxfrnList() {
        return sysInfxfrnList;
    }

    public void setSysInfxfrnList(List<SysInfxfrn> sysInfxfrnList) {
        this.sysInfxfrnList = sysInfxfrnList;
    }

    public Integer getNumpanel() {
        return numpanel;
    }

    public void setNumpanel(Integer numpanel) {
        this.numpanel = numpanel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (infId != null ? infId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SysInforme)) {
            return false;
        }
        SysInforme other = (SysInforme) object;
        if ((this.infId == null && other.infId != null) || (this.infId != null && !this.infId.equals(other.infId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.veeduria.adm.dao.SysInforme[ infId=" + infId + " ]";
    }

    /**
     * @return the comId
     */
    public AdmComponenteproceso getComId() {
        return comId;
    }

    /**
     * @param comId the comId to set
     */
    public void setComId(AdmComponenteproceso comId) {
        this.comId = comId;
    }

    public String getFreNombre() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getComNombre() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the infFrecuencia
     */
    public String getInfFrecuencia() {
        return infFrecuencia;
    }

    /**
     * @param infFrecuencia the infFrecuencia to set
     */
    public void setInfFrecuencia(String infFrecuencia) {
        this.infFrecuencia = infFrecuencia;
    }

}
