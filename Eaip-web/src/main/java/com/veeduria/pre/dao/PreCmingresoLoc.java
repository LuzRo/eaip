/*
 * To change this template, choose Tools | Templates
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
@Table(name = "pre_cmingreso_loc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PreCmingresoLoc.findAll", query = "SELECT p FROM PreCmingresoLoc p"),
    @NamedQuery(name = "PreCmingresoLoc.findByCingId", query = "SELECT p FROM PreCmingresoLoc p WHERE p.cingId = :cingId"),
    @NamedQuery(name = "PreCmingresoLoc.findByCingCodcuenta", query = "SELECT p FROM PreCmingresoLoc p WHERE p.cingCodcuenta = :cingCodcuenta"),
    @NamedQuery(name = "PreCmingresoLoc.findByCingNomcuenta", query = "SELECT p FROM PreCmingresoLoc p WHERE p.cingNomcuenta = :cingNomcuenta"),
    @NamedQuery(name = "PreCmingresoLoc.findByCingPptoinicial", query = "SELECT p FROM PreCmingresoLoc p WHERE p.cingPptoinicial = :cingPptoinicial"),
    @NamedQuery(name = "PreCmingresoLoc.findByCingModmes", query = "SELECT p FROM PreCmingresoLoc p WHERE p.cingModmes = :cingModmes"),
    @NamedQuery(name = "PreCmingresoLoc.findByCingModacumulado", query = "SELECT p FROM PreCmingresoLoc p WHERE p.cingModacumulado = :cingModacumulado"),
    @NamedQuery(name = "PreCmingresoLoc.findByCingPptodefinitivo", query = "SELECT p FROM PreCmingresoLoc p WHERE p.cingPptodefinitivo = :cingPptodefinitivo"),
    @NamedQuery(name = "PreCmingresoLoc.findByCingRecuadomes", query = "SELECT p FROM PreCmingresoLoc p WHERE p.cingRecuadomes = :cingRecuadomes"),
    @NamedQuery(name = "PreCmingresoLoc.findByCingRecuadoacum", query = "SELECT p FROM PreCmingresoLoc p WHERE p.cingRecuadoacum = :cingRecuadoacum"),
    @NamedQuery(name = "PreCmingresoLoc.findByCingPorejec", query = "SELECT p FROM PreCmingresoLoc p WHERE p.cingPorejec = :cingPorejec"),
    @NamedQuery(name = "PreCmingresoLoc.findByCingSaldorecaudar", query = "SELECT p FROM PreCmingresoLoc p WHERE p.cingSaldorecaudar = :cingSaldorecaudar")})

public class PreCmingresoLoc implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cing_id")
    private Long cingId;
    @Size(max = 1500)
    @Column(name = "cing_codcuenta")
    private String cingCodcuenta;
    @Size(max = 1500)
    @Column(name = "cing_nomcuenta")
    private String cingNomcuenta;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cing_pptoinicial")
    private BigDecimal cingPptoinicial;
    @Column(name = "cing_modmes")
    private BigDecimal cingModmes;
    @Column(name = "cing_modacumulado")
    private BigDecimal cingModacumulado;
    @Column(name = "cing_pptodefinitivo")
    private BigDecimal cingPptodefinitivo;
    @Column(name = "cing_recuadomes")
    private BigDecimal cingRecuadomes;
    @Column(name = "cing_recuadoacum")
    private BigDecimal cingRecuadoacum;
    @Column(name = "cing_porejec")
    private BigDecimal cingPorejec;
    @Column(name = "cing_saldorecaudar")
    private BigDecimal cingSaldorecaudar;
    @JoinColumn(name = "lgreg_id", referencedColumnName = "lgreg_id")
    @ManyToOne
    private SysRegistrocarga lgregId;

    public PreCmingresoLoc() {
    }

    public PreCmingresoLoc(Long cingId) {
        this.cingId = cingId;
    }

    public Long getCingId() {
        return cingId;
    }

    public void setCingId(Long cingId) {
        this.cingId = cingId;
    }

    public String getCingCodcuenta() {
        return cingCodcuenta;
    }

    public void setCingCodcuenta(String cingCodcuenta) {
        this.cingCodcuenta = cingCodcuenta;
    }

    public String getCingNomcuenta() {
        return cingNomcuenta;
    }

    public void setCingNomcuenta(String cingNomcuenta) {
        this.cingNomcuenta = cingNomcuenta;
    }

    public BigDecimal getCingPptoinicial() {
        return cingPptoinicial;
    }

    public void setCingPptoinicial(BigDecimal cingPptoinicial) {
        this.cingPptoinicial = cingPptoinicial;
    }

    public BigDecimal getCingModmes() {
        return cingModmes;
    }

    public void setCingModmes(BigDecimal cingModmes) {
        this.cingModmes = cingModmes;
    }

    public BigDecimal getCingModacumulado() {
        return cingModacumulado;
    }

    public void setCingModacumulado(BigDecimal cingModacumulado) {
        this.cingModacumulado = cingModacumulado;
    }

    public BigDecimal getCingPptodefinitivo() {
        return cingPptodefinitivo;
    }

    public void setCingPptodefinitivo(BigDecimal cingPptodefinitivo) {
        this.cingPptodefinitivo = cingPptodefinitivo;
    }

    public BigDecimal getCingRecuadomes() {
        return cingRecuadomes;
    }

    public void setCingRecuadomes(BigDecimal cingRecuadomes) {
        this.cingRecuadomes = cingRecuadomes;
    }

    public BigDecimal getCingRecuadoacum() {
        return cingRecuadoacum;
    }

    public void setCingRecuadoacum(BigDecimal cingRecuadoacum) {
        this.cingRecuadoacum = cingRecuadoacum;
    }

    public BigDecimal getCingPorejec() {
        return cingPorejec;
    }

    public void setCingPorejec(BigDecimal cingPorejec) {
        this.cingPorejec = cingPorejec;
    }

    public BigDecimal getCingSaldorecaudar() {
        return cingSaldorecaudar;
    }

    public void setCingSaldorecaudar(BigDecimal cingSaldorecaudar) {
        this.cingSaldorecaudar = cingSaldorecaudar;
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
        hash += (cingId != null ? cingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PreCmingresoLoc)) {
            return false;
        }
        PreCmingresoLoc other = (PreCmingresoLoc) object;
        if ((this.cingId == null && other.cingId != null) || (this.cingId != null && !this.cingId.equals(other.cingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.veeduria.adm.dao.PreCmingresoLoc[ cingId=" + cingId + " ]";
    }
    
}
