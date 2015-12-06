/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.veeduria.pre.dao;

import com.veeduria.sys.dao.SysRegistrocarga;
import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "pre_cmreserva")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PreCmreserva.findAll", query = "SELECT p FROM PreCmreserva p"),
    @NamedQuery(name = "PreCmreserva.findByResId", query = "SELECT p FROM PreCmreserva p WHERE p.resId = :resId"),
    @NamedQuery(name = "PreCmreserva.findByResVigencia", query = "SELECT p FROM PreCmreserva p WHERE p.resVigencia = :resVigencia"),
    @NamedQuery(name = "PreCmreserva.findByResEntidad", query = "SELECT p FROM PreCmreserva p WHERE p.resEntidad = :resEntidad"),
    @NamedQuery(name = "PreCmreserva.findByResUniejec", query = "SELECT p FROM PreCmreserva p WHERE p.resUniejec = :resUniejec"),
    @NamedQuery(name = "PreCmreserva.findByResCodigo", query = "SELECT p FROM PreCmreserva p WHERE p.resCodigo = :resCodigo"),
    @NamedQuery(name = "PreCmreserva.findByResDescripcion", query = "SELECT p FROM PreCmreserva p WHERE p.resDescripcion = :resDescripcion"),
    @NamedQuery(name = "PreCmreserva.findByResInterno", query = "SELECT p FROM PreCmreserva p WHERE p.resInterno = :resInterno"),
    @NamedQuery(name = "PreCmreserva.findByResResconstituida", query = "SELECT p FROM PreCmreserva p WHERE p.resResconstituida = :resResconstituida"),
    @NamedQuery(name = "PreCmreserva.findByResAnulacionmes", query = "SELECT p FROM PreCmreserva p WHERE p.resAnulacionmes = :resAnulacionmes"),
    @NamedQuery(name = "PreCmreserva.findByResAnulacionacum", query = "SELECT p FROM PreCmreserva p WHERE p.resAnulacionacum = :resAnulacionacum"),
    @NamedQuery(name = "PreCmreserva.findByResAutogiromes", query = "SELECT p FROM PreCmreserva p WHERE p.resAutogiromes = :resAutogiromes"),
    @NamedQuery(name = "PreCmreserva.findByResAutogiroacum", query = "SELECT p FROM PreCmreserva p WHERE p.resAutogiroacum = :resAutogiroacum")})
public class PreCmreserva implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "res_id")
    private Long resId;
    @Size(max = 50)
    @Column(name = "res_vigencia")
    private String resVigencia;
    @Size(max = 50)
    @Column(name = "res_entidad")
    private String resEntidad;
    @Size(max = 50)
    @Column(name = "res_uniejec")
    private String resUniejec;
    @Size(max = 1500)
    @Column(name = "res_codigo")
    private String resCodigo;
    @Size(max = 1500)
    @Column(name = "res_descripcion")
    private String resDescripcion;
    @Size(max = 50)
    @Column(name = "res_interno")
    private String resInterno;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "res_resconstituida")
    private BigDecimal resResconstituida;
    @Column(name = "res_anulacionmes")
    private BigDecimal resAnulacionmes;
    @Column(name = "res_anulacionacum")
    private BigDecimal resAnulacionacum;
    @Column(name = "res_autogiromes")
    private BigDecimal resAutogiromes;
    @Column(name = "res_autogiroacum")
    private BigDecimal resAutogiroacum;
    @JoinColumn(name = "lgreg_id", referencedColumnName = "lgreg_id")
    @ManyToOne
    private SysRegistrocarga lgregId;

    public PreCmreserva() {
    }

    public PreCmreserva(Long resId) {
        this.resId = resId;
    }

    public Long getResId() {
        return resId;
    }

    public void setResId(Long resId) {
        this.resId = resId;
    }

    public String getResVigencia() {
        return resVigencia;
    }

    public void setResVigencia(String resVigencia) {
        this.resVigencia = resVigencia;
    }

    public String getResEntidad() {
        return resEntidad;
    }

    public void setResEntidad(String resEntidad) {
        this.resEntidad = resEntidad;
    }

    public String getResUniejec() {
        return resUniejec;
    }

    public void setResUniejec(String resUniejec) {
        this.resUniejec = resUniejec;
    }

    public String getResCodigo() {
        return resCodigo;
    }

    public void setResCodigo(String resCodigo) {
        this.resCodigo = resCodigo;
    }

    public String getResDescripcion() {
        return resDescripcion;
    }

    public void setResDescripcion(String resDescripcion) {
        this.resDescripcion = resDescripcion;
    }

    public String getResInterno() {
        return resInterno;
    }

    public void setResInterno(String resInterno) {
        this.resInterno = resInterno;
    }

    public BigDecimal getResResconstituida() {
        return resResconstituida;
    }

    public void setResResconstituida(BigDecimal resResconstituida) {
        this.resResconstituida = resResconstituida;
    }

    public BigDecimal getResAnulacionmes() {
        return resAnulacionmes;
    }

    public void setResAnulacionmes(BigDecimal resAnulacionmes) {
        this.resAnulacionmes = resAnulacionmes;
    }

    public BigDecimal getResAnulacionacum() {
        return resAnulacionacum;
    }

    public void setResAnulacionacum(BigDecimal resAnulacionacum) {
        this.resAnulacionacum = resAnulacionacum;
    }

    public BigDecimal getResAutogiromes() {
        return resAutogiromes;
    }

    public void setResAutogiromes(BigDecimal resAutogiromes) {
        this.resAutogiromes = resAutogiromes;
    }

    public BigDecimal getResAutogiroacum() {
        return resAutogiroacum;
    }

    public void setResAutogiroacum(BigDecimal resAutogiroacum) {
        this.resAutogiroacum = resAutogiroacum;
    }

    public SysRegistrocarga getLgregId() {
        return lgregId;
    }

    public void setLgregId(SysRegistrocarga lgregId) {
        this.lgregId = lgregId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (resId != null ? resId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PreCmreserva)) {
            return false;
        }
        PreCmreserva other = (PreCmreserva) object;
        if ((this.resId == null && other.resId != null) || (this.resId != null && !this.resId.equals(other.resId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.veeduria.dao.PreCmreserva[ resId=" + resId + " ]";
    }
    
}
