/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veeduria.pre.dao;

import com.veeduria.sys.dao.SysRegistrocarga;
import java.io.Serializable;
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
@Table(name = "pre_cmingresoiyc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PreCmingresoiyc.findAll", query = "SELECT p FROM PreCmingresoiyc p"),
    @NamedQuery(name = "PreCmingresoiyc.findByIicId", query = "SELECT p FROM PreCmingresoiyc p WHERE p.iicId = :iicId"),
    @NamedQuery(name = "PreCmingresoiyc.findByIicCodcuenta", query = "SELECT p FROM PreCmingresoiyc p WHERE p.iicCodcuenta = :iicCodcuenta"),
    @NamedQuery(name = "PreCmingresoiyc.findByIicNomcuenta", query = "SELECT p FROM PreCmingresoiyc p WHERE p.iicNomcuenta = :iicNomcuenta"),
    @NamedQuery(name = "PreCmingresoiyc.findByIicPptoinicial", query = "SELECT p FROM PreCmingresoiyc p WHERE p.iicPptoinicial = :iicPptoinicial"),
    @NamedQuery(name = "PreCmingresoiyc.findByIicModmes", query = "SELECT p FROM PreCmingresoiyc p WHERE p.iicModmes = :iicModmes"),
    @NamedQuery(name = "PreCmingresoiyc.findByIicModacumulado", query = "SELECT p FROM PreCmingresoiyc p WHERE p.iicModacumulado = :iicModacumulado"),
    @NamedQuery(name = "PreCmingresoiyc.findByIicPptodefinitivo", query = "SELECT p FROM PreCmingresoiyc p WHERE p.iicPptodefinitivo = :iicPptodefinitivo"),
    @NamedQuery(name = "PreCmingresoiyc.findByIicRecaudomes", query = "SELECT p FROM PreCmingresoiyc p WHERE p.iicRecaudomes = :iicRecaudomes"),
    @NamedQuery(name = "PreCmingresoiyc.findByIicRecaudoacum", query = "SELECT p FROM PreCmingresoiyc p WHERE p.iicRecaudoacum = :iicRecaudoacum"),
    @NamedQuery(name = "PreCmingresoiyc.findByIicPorejec", query = "SELECT p FROM PreCmingresoiyc p WHERE p.iicPorejec = :iicPorejec"),
    @NamedQuery(name = "PreCmingresoiyc.findByIicSaldorecaudar", query = "SELECT p FROM PreCmingresoiyc p WHERE p.iicSaldorecaudar = :iicSaldorecaudar"),
    @NamedQuery(name = "PreCmingresoiyc.findByIicReconocingresos", query = "SELECT p FROM PreCmingresoiyc p WHERE p.iicReconocingresos = :iicReconocingresos"),
    @NamedQuery(name = "PreCmingresoiyc.findByIicRecuadoacumu", query = "SELECT p FROM PreCmingresoiyc p WHERE p.iicRecuadoacumu = :iicRecuadoacumu")})
public class PreCmingresoiyc implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iic_id")
    private Long iicId;
    @Size(max = 1500)
    @Column(name = "iic_codcuenta")
    private String iicCodcuenta;
    @Size(max = 1500)
    @Column(name = "iic_nomcuenta")
    private String iicNomcuenta;
    @Size(max = 1500)
    @Column(name = "iic_pptoinicial")
    private String iicPptoinicial;
    @Size(max = 1500)
    @Column(name = "iic_modmes")
    private String iicModmes;
    @Size(max = 1500)
    @Column(name = "iic_modacumulado")
    private String iicModacumulado;
    @Size(max = 1500)
    @Column(name = "iic_pptodefinitivo")
    private String iicPptodefinitivo;
    @Size(max = 1500)
    @Column(name = "iic_recaudomes")
    private String iicRecaudomes;
    @Size(max = 1500)
    @Column(name = "iic_recaudoacum")
    private String iicRecaudoacum;
    @Size(max = 1500)
    @Column(name = "iic_porejec")
    private String iicPorejec;
    @Size(max = 1500)
    @Column(name = "iic_saldorecaudar")
    private String iicSaldorecaudar;
    @Size(max = 1500)
    @Column(name = "iic_reconocingresos")
    private String iicReconocingresos;
    @Size(max = 1500)
    @Column(name = "iic_recuadoacumu")
    private String iicRecuadoacumu;
    @JoinColumn(name = "lgreg_id", referencedColumnName = "lgreg_id")
    @ManyToOne
    private SysRegistrocarga lgregId;

    public PreCmingresoiyc() {
    }

    public PreCmingresoiyc(Long iicId) {
        this.iicId = iicId;
    }

    public Long getIicId() {
        return iicId;
    }

    public void setIicId(Long iicId) {
        this.iicId = iicId;
    }

    public String getIicCodcuenta() {
        return iicCodcuenta;
    }

    public void setIicCodcuenta(String iicCodcuenta) {
        this.iicCodcuenta = iicCodcuenta;
    }

    public String getIicNomcuenta() {
        return iicNomcuenta;
    }

    public void setIicNomcuenta(String iicNomcuenta) {
        this.iicNomcuenta = iicNomcuenta;
    }

    public String getIicPptoinicial() {
        return iicPptoinicial;
    }

    public void setIicPptoinicial(String iicPptoinicial) {
        this.iicPptoinicial = iicPptoinicial;
    }

    public String getIicModmes() {
        return iicModmes;
    }

    public void setIicModmes(String iicModmes) {
        this.iicModmes = iicModmes;
    }

    public String getIicModacumulado() {
        return iicModacumulado;
    }

    public void setIicModacumulado(String iicModacumulado) {
        this.iicModacumulado = iicModacumulado;
    }

    public String getIicPptodefinitivo() {
        return iicPptodefinitivo;
    }

    public void setIicPptodefinitivo(String iicPptodefinitivo) {
        this.iicPptodefinitivo = iicPptodefinitivo;
    }

    public String getIicRecaudomes() {
        return iicRecaudomes;
    }

    public void setIicRecaudomes(String iicRecaudomes) {
        this.iicRecaudomes = iicRecaudomes;
    }

    public String getIicRecaudoacum() {
        return iicRecaudoacum;
    }

    public void setIicRecaudoacum(String iicRecaudoacum) {
        this.iicRecaudoacum = iicRecaudoacum;
    }

    public String getIicPorejec() {
        return iicPorejec;
    }

    public void setIicPorejec(String iicPorejec) {
        this.iicPorejec = iicPorejec;
    }

    public String getIicSaldorecaudar() {
        return iicSaldorecaudar;
    }

    public void setIicSaldorecaudar(String iicSaldorecaudar) {
        this.iicSaldorecaudar = iicSaldorecaudar;
    }

    public String getIicReconocingresos() {
        return iicReconocingresos;
    }

    public void setIicReconocingresos(String iicReconocingresos) {
        this.iicReconocingresos = iicReconocingresos;
    }

    public String getIicRecuadoacumu() {
        return iicRecuadoacumu;
    }

    public void setIicRecuadoacumu(String iicRecuadoacumu) {
        this.iicRecuadoacumu = iicRecuadoacumu;
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
        hash += (iicId != null ? iicId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PreCmingresoiyc)) {
            return false;
        }
        PreCmingresoiyc other = (PreCmingresoiyc) object;
        if ((this.iicId == null && other.iicId != null) || (this.iicId != null && !this.iicId.equals(other.iicId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.veeduria.adm.dao.PreCmingresoiyc[ iicId=" + iicId + " ]";
    }
    
}
