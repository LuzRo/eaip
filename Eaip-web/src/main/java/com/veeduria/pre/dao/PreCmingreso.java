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
 * @author con1ead
 */
@Entity
@Table(name = "pre_cmingreso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PreCmingreso.findAll", query = "SELECT p FROM PreCmingreso p"),
    @NamedQuery(name = "PreCmingreso.findByCingId", query = "SELECT p FROM PreCmingreso p WHERE p.cingId = :cingId"),
    @NamedQuery(name = "PreCmingreso.findByCingCodcuenta", query = "SELECT p FROM PreCmingreso p WHERE p.cingCodcuenta = :cingCodcuenta"),
    @NamedQuery(name = "PreCmingreso.findByCingNomcuenta", query = "SELECT p FROM PreCmingreso p WHERE p.cingNomcuenta = :cingNomcuenta"),
    @NamedQuery(name = "PreCmingreso.findByCingPptoinicial", query = "SELECT p FROM PreCmingreso p WHERE p.cingPptoinicial = :cingPptoinicial"),
    @NamedQuery(name = "PreCmingreso.findByCingModmes", query = "SELECT p FROM PreCmingreso p WHERE p.cingModmes = :cingModmes"),
    @NamedQuery(name = "PreCmingreso.findByCingModacumulado", query = "SELECT p FROM PreCmingreso p WHERE p.cingModacumulado = :cingModacumulado"),
    @NamedQuery(name = "PreCmingreso.findByCingPptodefinitivo", query = "SELECT p FROM PreCmingreso p WHERE p.cingPptodefinitivo = :cingPptodefinitivo"),
    @NamedQuery(name = "PreCmingreso.findByCingRecuadomes", query = "SELECT p FROM PreCmingreso p WHERE p.cingRecuadomes = :cingRecuadomes"),
    @NamedQuery(name = "PreCmingreso.findByCingRecuadoacum", query = "SELECT p FROM PreCmingreso p WHERE p.cingRecuadoacum = :cingRecuadoacum"),
    @NamedQuery(name = "PreCmingreso.findByCingPorejec", query = "SELECT p FROM PreCmingreso p WHERE p.cingPorejec = :cingPorejec"),
    @NamedQuery(name = "PreCmingreso.findByCingSaldorecaudar", query = "SELECT p FROM PreCmingreso p WHERE p.cingSaldorecaudar = :cingSaldorecaudar"),
    @NamedQuery(name = "PreCmingreso.findByCingRecurreser", query = "SELECT p FROM PreCmingreso p WHERE p.cingRecurreser = :cingRecurreser"),
    @NamedQuery(name = "PreCmingreso.findByCingIngrfinal", query = "SELECT p FROM PreCmingreso p WHERE p.cingIngrfinal = :cingIngrfinal"),
    @NamedQuery(name = "PreCmingreso.findByCingAno", query = "SELECT p FROM PreCmingreso p WHERE p.cingAno = :cingAno"),
    @NamedQuery(name = "PreCmingreso.findByDeflCingPptoinicial", query = "SELECT p FROM PreCmingreso p WHERE p.deflCingPptoinicial = :deflCingPptoinicial"),
    @NamedQuery(name = "PreCmingreso.findByDeflCingModmes", query = "SELECT p FROM PreCmingreso p WHERE p.deflCingModmes = :deflCingModmes"),
    @NamedQuery(name = "PreCmingreso.findByDeflCingModacumulado", query = "SELECT p FROM PreCmingreso p WHERE p.deflCingModacumulado = :deflCingModacumulado"),
    @NamedQuery(name = "PreCmingreso.findByDeflCingPptodefinitivo", query = "SELECT p FROM PreCmingreso p WHERE p.deflCingPptodefinitivo = :deflCingPptodefinitivo"),
    @NamedQuery(name = "PreCmingreso.findByDeflCingRecuadomes", query = "SELECT p FROM PreCmingreso p WHERE p.deflCingRecuadomes = :deflCingRecuadomes"),
    @NamedQuery(name = "PreCmingreso.findByDeflCingRecuadoacum", query = "SELECT p FROM PreCmingreso p WHERE p.deflCingRecuadoacum = :deflCingRecuadoacum"),
    @NamedQuery(name = "PreCmingreso.findByDeflCingSaldorecaudar", query = "SELECT p FROM PreCmingreso p WHERE p.deflCingSaldorecaudar = :deflCingSaldorecaudar"),
    @NamedQuery(name = "PreCmingreso.findByDeflCingRecurreser", query = "SELECT p FROM PreCmingreso p WHERE p.deflCingRecurreser = :deflCingRecurreser"),
    @NamedQuery(name = "PreCmingreso.findByDeflCingIngrfinal", query = "SELECT p FROM PreCmingreso p WHERE p.deflCingIngrfinal = :deflCingIngrfinal"),
    @NamedQuery(name = "PreCmingreso.findByCingCodnivel1", query = "SELECT p FROM PreCmingreso p WHERE p.cingCodnivel1 = :cingCodnivel1"),
    @NamedQuery(name = "PreCmingreso.findByCingCodnivel2", query = "SELECT p FROM PreCmingreso p WHERE p.cingCodnivel2 = :cingCodnivel2"),
    @NamedQuery(name = "PreCmingreso.findByCingCodnivel3", query = "SELECT p FROM PreCmingreso p WHERE p.cingCodnivel3 = :cingCodnivel3"),
    @NamedQuery(name = "PreCmingreso.findByCingCodnivel4", query = "SELECT p FROM PreCmingreso p WHERE p.cingCodnivel4 = :cingCodnivel4"),
    @NamedQuery(name = "PreCmingreso.findByCingCodnivel5", query = "SELECT p FROM PreCmingreso p WHERE p.cingCodnivel5 = :cingCodnivel5"),
    @NamedQuery(name = "PreCmingreso.findByCingCodnivel6", query = "SELECT p FROM PreCmingreso p WHERE p.cingCodnivel6 = :cingCodnivel6"),
    @NamedQuery(name = "PreCmingreso.findByCingCodnivel7", query = "SELECT p FROM PreCmingreso p WHERE p.cingCodnivel7 = :cingCodnivel7")})
public class PreCmingreso implements Serializable {
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
    @Column(name = "cing_recurreser")
    private BigDecimal cingRecurreser;
    @Column(name = "cing_ingrfinal")
    private BigDecimal cingIngrfinal;
    @Column(name = "cing_ano")
    private Integer cingAno;
    @Column(name = "defl_cing_pptoinicial")
    private BigDecimal deflCingPptoinicial;
    @Column(name = "defl_cing_modmes")
    private BigDecimal deflCingModmes;
    @Column(name = "defl_cing_modacumulado")
    private BigDecimal deflCingModacumulado;
    @Column(name = "defl_cing_pptodefinitivo")
    private BigDecimal deflCingPptodefinitivo;
    @Column(name = "defl_cing_recuadomes")
    private BigDecimal deflCingRecuadomes;
    @Column(name = "defl_cing_recuadoacum")
    private BigDecimal deflCingRecuadoacum;
    @Column(name = "defl_cing_saldorecaudar")
    private BigDecimal deflCingSaldorecaudar;
    @Column(name = "defl_cing_recurreser")
    private BigDecimal deflCingRecurreser;
    @Column(name = "defl_cing_ingrfinal")
    private BigDecimal deflCingIngrfinal;
    @Size(max = 50)
    @Column(name = "cing_codnivel1")
    private String cingCodnivel1;
    @Size(max = 50)
    @Column(name = "cing_codnivel2")
    private String cingCodnivel2;
    @Size(max = 50)
    @Column(name = "cing_codnivel3")
    private String cingCodnivel3;
    @Size(max = 50)
    @Column(name = "cing_codnivel4")
    private String cingCodnivel4;
    @Size(max = 50)
    @Column(name = "cing_codnivel5")
    private String cingCodnivel5;
    @Size(max = 50)
    @Column(name = "cing_codnivel6")
    private String cingCodnivel6;
    @Size(max = 50)
    @Column(name = "cing_codnivel7")
    private String cingCodnivel7;
    @JoinColumn(name = "lgreg_id", referencedColumnName = "lgreg_id")
    @ManyToOne
    private SysRegistrocarga lgregId;

    public PreCmingreso() {
    }

    public PreCmingreso(Long cingId) {
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

    public BigDecimal getCingRecurreser() {
        return cingRecurreser;
    }

    public void setCingRecurreser(BigDecimal cingRecurreser) {
        this.cingRecurreser = cingRecurreser;
    }

    public BigDecimal getCingIngrfinal() {
        return cingIngrfinal;
    }

    public void setCingIngrfinal(BigDecimal cingIngrfinal) {
        this.cingIngrfinal = cingIngrfinal;
    }

    public Integer getCingAño() {
        return cingAno;
    }

    public void setCingAño(Integer cingAno) {
        this.cingAno = cingAno;
    }

    public BigDecimal getDeflCingPptoinicial() {
        return deflCingPptoinicial;
    }

    public void setDeflCingPptoinicial(BigDecimal deflCingPptoinicial) {
        this.deflCingPptoinicial = deflCingPptoinicial;
    }

    public BigDecimal getDeflCingModmes() {
        return deflCingModmes;
    }

    public void setDeflCingModmes(BigDecimal deflCingModmes) {
        this.deflCingModmes = deflCingModmes;
    }

    public BigDecimal getDeflCingModacumulado() {
        return deflCingModacumulado;
    }

    public void setDeflCingModacumulado(BigDecimal deflCingModacumulado) {
        this.deflCingModacumulado = deflCingModacumulado;
    }

    public BigDecimal getDeflCingPptodefinitivo() {
        return deflCingPptodefinitivo;
    }

    public void setDeflCingPptodefinitivo(BigDecimal deflCingPptodefinitivo) {
        this.deflCingPptodefinitivo = deflCingPptodefinitivo;
    }

    public BigDecimal getDeflCingRecuadomes() {
        return deflCingRecuadomes;
    }

    public void setDeflCingRecuadomes(BigDecimal deflCingRecuadomes) {
        this.deflCingRecuadomes = deflCingRecuadomes;
    }

    public BigDecimal getDeflCingRecuadoacum() {
        return deflCingRecuadoacum;
    }

    public void setDeflCingRecuadoacum(BigDecimal deflCingRecuadoacum) {
        this.deflCingRecuadoacum = deflCingRecuadoacum;
    }

    public BigDecimal getDeflCingSaldorecaudar() {
        return deflCingSaldorecaudar;
    }

    public void setDeflCingSaldorecaudar(BigDecimal deflCingSaldorecaudar) {
        this.deflCingSaldorecaudar = deflCingSaldorecaudar;
    }

    public BigDecimal getDeflCingRecurreser() {
        return deflCingRecurreser;
    }

    public void setDeflCingRecurreser(BigDecimal deflCingRecurreser) {
        this.deflCingRecurreser = deflCingRecurreser;
    }

    public BigDecimal getDeflCingIngrfinal() {
        return deflCingIngrfinal;
    }

    public void setDeflCingIngrfinal(BigDecimal deflCingIngrfinal) {
        this.deflCingIngrfinal = deflCingIngrfinal;
    }

    public String getCingCodnivel1() {
        return cingCodnivel1;
    }

    public void setCingCodnivel1(String cingCodnivel1) {
        this.cingCodnivel1 = cingCodnivel1;
    }

    public String getCingCodnivel2() {
        return cingCodnivel2;
    }

    public void setCingCodnivel2(String cingCodnivel2) {
        this.cingCodnivel2 = cingCodnivel2;
    }

    public String getCingCodnivel3() {
        return cingCodnivel3;
    }

    public void setCingCodnivel3(String cingCodnivel3) {
        this.cingCodnivel3 = cingCodnivel3;
    }

    public String getCingCodnivel4() {
        return cingCodnivel4;
    }

    public void setCingCodnivel4(String cingCodnivel4) {
        this.cingCodnivel4 = cingCodnivel4;
    }

    public String getCingCodnivel5() {
        return cingCodnivel5;
    }

    public void setCingCodnivel5(String cingCodnivel5) {
        this.cingCodnivel5 = cingCodnivel5;
    }

    public String getCingCodnivel6() {
        return cingCodnivel6;
    }

    public void setCingCodnivel6(String cingCodnivel6) {
        this.cingCodnivel6 = cingCodnivel6;
    }

    public String getCingCodnivel7() {
        return cingCodnivel7;
    }

    public void setCingCodnivel7(String cingCodnivel7) {
        this.cingCodnivel7 = cingCodnivel7;
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
        if (!(object instanceof PreCmingreso)) {
            return false;
        }
        PreCmingreso other = (PreCmingreso) object;
        return !((this.cingId == null && other.cingId != null) || (this.cingId != null && !this.cingId.equals(other.cingId)));
    }

    @Override
    public String toString() {
        return "com.veeduria.dao.PreCmingreso[ cingId=" + cingId + " ]";
    }
    
}
