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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author luz
 */
@Entity
@Table(name = "pre_cmgasto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PreCmgasto.findAll", query = "SELECT p FROM PreCmgasto p"),
    @NamedQuery(name = "PreCmgasto.findByCgasId", query = "SELECT p FROM PreCmgasto p WHERE p.cgasId = :cgasId"),
    @NamedQuery(name = "PreCmgasto.findByCgasCodcuenta", query = "SELECT p FROM PreCmgasto p WHERE p.cgasCodcuenta = :cgasCodcuenta"),
    @NamedQuery(name = "PreCmgasto.findByCgasNomcuenta", query = "SELECT p FROM PreCmgasto p WHERE p.cgasNomcuenta = :cgasNomcuenta"),
    @NamedQuery(name = "PreCmgasto.findByCgasApropinicial", query = "SELECT p FROM PreCmgasto p WHERE p.cgasApropinicial = :cgasApropinicial"),
    @NamedQuery(name = "PreCmgasto.findByCgasModificacion", query = "SELECT p FROM PreCmgasto p WHERE p.cgasModificacion = :cgasModificacion"),
    @NamedQuery(name = "PreCmgasto.findByCgasApropvigente", query = "SELECT p FROM PreCmgasto p WHERE p.cgasApropvigente = :cgasApropvigente"),
    @NamedQuery(name = "PreCmgasto.findByCgasSuspension", query = "SELECT p FROM PreCmgasto p WHERE p.cgasSuspension = :cgasSuspension"),
    @NamedQuery(name = "PreCmgasto.findByCgasApropdisponible", query = "SELECT p FROM PreCmgasto p WHERE p.cgasApropdisponible = :cgasApropdisponible"),
    @NamedQuery(name = "PreCmgasto.findByCgasCompmes", query = "SELECT p FROM PreCmgasto p WHERE p.cgasCompmes = :cgasCompmes"),
    @NamedQuery(name = "PreCmgasto.findByCgasCompacumulados", query = "SELECT p FROM PreCmgasto p WHERE p.cgasCompacumulados = :cgasCompacumulados"),
    @NamedQuery(name = "PreCmgasto.findByCgasPorejecptal", query = "SELECT p FROM PreCmgasto p WHERE p.cgasPorejecptal = :cgasPorejecptal"),
    @NamedQuery(name = "PreCmgasto.findByCgasAutogiromes", query = "SELECT p FROM PreCmgasto p WHERE p.cgasAutogiromes = :cgasAutogiromes"),
    @NamedQuery(name = "PreCmgasto.findByCgasAutogiroacum", query = "SELECT p FROM PreCmgasto p WHERE p.cgasAutogiroacum = :cgasAutogiroacum"),
    @NamedQuery(name = "PreCmgasto.findByCgasPorejecautogiro", query = "SELECT p FROM PreCmgasto p WHERE p.cgasPorejecautogiro = :cgasPorejecautogiro"),
    @NamedQuery(name = "PreCmgasto.findByDeflCgasApropinicial", query = "SELECT p FROM PreCmgasto p WHERE p.deflCgasApropinicial = :deflCgasApropinicial"),
    @NamedQuery(name = "PreCmgasto.findByDeflCgasModificacion", query = "SELECT p FROM PreCmgasto p WHERE p.deflCgasModificacion = :deflCgasModificacion"),
    @NamedQuery(name = "PreCmgasto.findByDeflCgasApropvigente", query = "SELECT p FROM PreCmgasto p WHERE p.deflCgasApropvigente = :deflCgasApropvigente"),
    @NamedQuery(name = "PreCmgasto.findByDeflCgasSuspension", query = "SELECT p FROM PreCmgasto p WHERE p.deflCgasSuspension = :deflCgasSuspension"),
    @NamedQuery(name = "PreCmgasto.findByDeflCgasApropdisponible", query = "SELECT p FROM PreCmgasto p WHERE p.deflCgasApropdisponible = :deflCgasApropdisponible"),
    @NamedQuery(name = "PreCmgasto.findByDeflCgasCompmes", query = "SELECT p FROM PreCmgasto p WHERE p.deflCgasCompmes = :deflCgasCompmes"),
    @NamedQuery(name = "PreCmgasto.findByDeflCgasCompacumulados", query = "SELECT p FROM PreCmgasto p WHERE p.deflCgasCompacumulados = :deflCgasCompacumulados"),
    @NamedQuery(name = "PreCmgasto.findByDeflCgasAutogiromes", query = "SELECT p FROM PreCmgasto p WHERE p.deflCgasAutogiromes = :deflCgasAutogiromes"),
    @NamedQuery(name = "PreCmgasto.findByDeflCgasAutogiroacum", query = "SELECT p FROM PreCmgasto p WHERE p.deflCgasAutogiroacum = :deflCgasAutogiroacum"),
    @NamedQuery(name = "PreCmgasto.findByCgasCodplandsllo", query = "SELECT p FROM PreCmgasto p WHERE p.cgasCodplandsllo = :cgasCodplandsllo"),
    @NamedQuery(name = "PreCmgasto.findByCgasCodprograma", query = "SELECT p FROM PreCmgasto p WHERE p.cgasCodprograma = :cgasCodprograma"),
    @NamedQuery(name = "PreCmgasto.findByGasCodnivel1", query = "SELECT p FROM PreCmgasto p WHERE p.gasCodnivel1 = :gasCodnivel1"),
    @NamedQuery(name = "PreCmgasto.findByGasCodnivel2", query = "SELECT p FROM PreCmgasto p WHERE p.gasCodnivel2 = :gasCodnivel2"),
    @NamedQuery(name = "PreCmgasto.findByGasCodnivel3", query = "SELECT p FROM PreCmgasto p WHERE p.gasCodnivel3 = :gasCodnivel3"),
    @NamedQuery(name = "PreCmgasto.findByGasCodnivel4", query = "SELECT p FROM PreCmgasto p WHERE p.gasCodnivel4 = :gasCodnivel4"),
    @NamedQuery(name = "PreCmgasto.findByGasCodnivel5", query = "SELECT p FROM PreCmgasto p WHERE p.gasCodnivel5 = :gasCodnivel5"),
    @NamedQuery(name = "PreCmgasto.findByGasCodnivel6", query = "SELECT p FROM PreCmgasto p WHERE p.gasCodnivel6 = :gasCodnivel6"),
    @NamedQuery(name = "PreCmgasto.findByGasCodnivel7", query = "SELECT p FROM PreCmgasto p WHERE p.gasCodnivel7 = :gasCodnivel7")})

public class PreCmgasto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cgas_id")
    private Long cgasId;
    @Size(max = 1500)
    @Column(name = "cgas_codcuenta")
    private String cgasCodcuenta;
    @Size(max = 1500)
    @Column(name = "cgas_nomcuenta")
    private String cgasNomcuenta;
    @Size(max = 1500)
    @Column(name = "cgas_apropinicial")
    private String cgasApropinicial;
    @Size(max = 1500)
    @Column(name = "cgas_modificacion")
    private String cgasModificacion;
    @Size(max = 1500)
    @Column(name = "cgas_apropvigente")
    private String cgasApropvigente;
    @Size(max = 1500)
    @Column(name = "cgas_suspension")
    private String cgasSuspension;
    @Size(max = 1500)
    @Column(name = "cgas_apropdisponible")
    private String cgasApropdisponible;
    @Size(max = 1500)
    @Column(name = "cgas_compmes")
    private String cgasCompmes;
    @Size(max = 1500)
    @Column(name = "cgas_compacumulados")
    private String cgasCompacumulados;
    @Size(max = 1500)
    @Column(name = "cgas_porejecptal")
    private String cgasPorejecptal;
    @Size(max = 1500)
    @Column(name = "cgas_autogiromes")
    private String cgasAutogiromes;
    @Size(max = 1500)
    @Column(name = "cgas_autogiroacum")
    private String cgasAutogiroacum;
    @Size(max = 1500)
    @Column(name = "cgas_porejecautogiro")
    private String cgasPorejecautogiro;
    @Column(name = "defl_cgas_apropinicial")
    private BigDecimal deflCgasApropinicial;
    @Column(name = "defl_cgas_modificacion")
    private BigDecimal deflCgasModificacion;
    @Column(name = "defl_cgas_apropvigente")
    private BigDecimal deflCgasApropvigente;
    @Column(name = "defl_cgas_suspension")
    private BigDecimal deflCgasSuspension;
    @Column(name = "defl_cgas_apropdisponible")
    private BigDecimal deflCgasApropdisponible;
    @Column(name = "defl_cgas_compmes")
    private BigDecimal deflCgasCompmes;
    @Column(name = "defl_cgas_compacumulados")
    private BigDecimal deflCgasCompacumulados;
    @Column(name = "defl_cgas_autogiromes")
    private BigDecimal deflCgasAutogiromes;
    @Column(name = "defl_cgas_autogiroacum")
    private BigDecimal deflCgasAutogiroacum;
    @Column(name = "cgas_codplandsllo")
    private Integer cgasCodplandsllo;
    @Size(max = 50)
    @Column(name = "cgas_codprograma")
    private String cgasCodprograma;
    @Size(max = 100)
    @Column(name = "gas_codnivel1")
    private String gasCodnivel1;
    @Size(max = 100)
    @Column(name = "gas_codnivel2")
    private String gasCodnivel2;
    @Size(max = 100)
    @Column(name = "gas_codnivel3")
    private String gasCodnivel3;
    @Size(max = 100)
    @Column(name = "gas_codnivel4")
    private String gasCodnivel4;
    @Size(max = 100)
    @Column(name = "gas_codnivel5")
    private String gasCodnivel5;
    @Size(max = 100)
    @Column(name = "gas_codnivel6")
    private String gasCodnivel6;
    @Size(max = 100)
    @Column(name = "gas_codnivel7")
    private String gasCodnivel7;
    @JoinColumn(name = "lgreg_id", referencedColumnName = "lgreg_id")
    @ManyToOne
    private SysRegistrocarga lgregId;

    public PreCmgasto() {
    }

    public PreCmgasto(Long cgasId) {
        this.cgasId = cgasId;
    }

    public Long getCgasId() {
        return cgasId;
    }

    public void setCgasId(Long cgasId) {
        this.cgasId = cgasId;
    }

    public String getCgasCodcuenta() {
        return cgasCodcuenta;
    }

    public void setCgasCodcuenta(String cgasCodcuenta) {
        this.cgasCodcuenta = cgasCodcuenta;
    }

    public String getCgasNomcuenta() {
        return cgasNomcuenta;
    }

    public void setCgasNomcuenta(String cgasNomcuenta) {
        this.cgasNomcuenta = cgasNomcuenta;
    }

    public String getCgasApropinicial() {
        return cgasApropinicial;
    }

    public void setCgasApropinicial(String cgasApropinicial) {
        this.cgasApropinicial = cgasApropinicial;
    }

    public String getCgasModificacion() {
        return cgasModificacion;
    }

    public void setCgasModificacion(String cgasModificacion) {
        this.cgasModificacion = cgasModificacion;
    }

    public String getCgasApropvigente() {
        return cgasApropvigente;
    }

    public void setCgasApropvigente(String cgasApropvigente) {
        this.cgasApropvigente = cgasApropvigente;
    }

    public String getCgasSuspension() {
        return cgasSuspension;
    }

    public void setCgasSuspension(String cgasSuspension) {
        this.cgasSuspension = cgasSuspension;
    }

    public String getCgasApropdisponible() {
        return cgasApropdisponible;
    }

    public void setCgasApropdisponible(String cgasApropdisponible) {
        this.cgasApropdisponible = cgasApropdisponible;
    }

    public String getCgasCompmes() {
        return cgasCompmes;
    }

    public void setCgasCompmes(String cgasCompmes) {
        this.cgasCompmes = cgasCompmes;
    }

    public String getCgasCompacumulados() {
        return cgasCompacumulados;
    }

    public void setCgasCompacumulados(String cgasCompacumulados) {
        this.cgasCompacumulados = cgasCompacumulados;
    }

    public String getCgasPorejecptal() {
        return cgasPorejecptal;
    }

    public void setCgasPorejecptal(String cgasPorejecptal) {
        this.cgasPorejecptal = cgasPorejecptal;
    }

    public String getCgasAutogiromes() {
        return cgasAutogiromes;
    }

    public void setCgasAutogiromes(String cgasAutogiromes) {
        this.cgasAutogiromes = cgasAutogiromes;
    }

    public String getCgasAutogiroacum() {
        return cgasAutogiroacum;
    }

    public void setCgasAutogiroacum(String cgasAutogiroacum) {
        this.cgasAutogiroacum = cgasAutogiroacum;
    }

    public String getCgasPorejecautogiro() {
        return cgasPorejecautogiro;
    }

    public void setCgasPorejecautogiro(String cgasPorejecautogiro) {
        this.cgasPorejecautogiro = cgasPorejecautogiro;
    }
    
     public BigDecimal getDeflCgasApropinicial() {
        return deflCgasApropinicial;
    }

    public void setDeflCgasApropinicial(BigDecimal deflCgasApropinicial) {
        this.deflCgasApropinicial = deflCgasApropinicial;
    }

    public BigDecimal getDeflCgasModificacion() {
        return deflCgasModificacion;
    }

    public void setDeflCgasModificacion(BigDecimal deflCgasModificacion) {
        this.deflCgasModificacion = deflCgasModificacion;
    }

    public BigDecimal getDeflCgasApropvigente() {
        return deflCgasApropvigente;
    }

    public void setDeflCgasApropvigente(BigDecimal deflCgasApropvigente) {
        this.deflCgasApropvigente = deflCgasApropvigente;
    }

    public BigDecimal getDeflCgasSuspension() {
        return deflCgasSuspension;
    }

    public void setDeflCgasSuspension(BigDecimal deflCgasSuspension) {
        this.deflCgasSuspension = deflCgasSuspension;
    }

    public BigDecimal getDeflCgasApropdisponible() {
        return deflCgasApropdisponible;
    }

    public void setDeflCgasApropdisponible(BigDecimal deflCgasApropdisponible) {
        this.deflCgasApropdisponible = deflCgasApropdisponible;
    }

    public BigDecimal getDeflCgasCompmes() {
        return deflCgasCompmes;
    }

    public void setDeflCgasCompmes(BigDecimal deflCgasCompmes) {
        this.deflCgasCompmes = deflCgasCompmes;
    }

    public BigDecimal getDeflCgasCompacumulados() {
        return deflCgasCompacumulados;
    }

    public void setDeflCgasCompacumulados(BigDecimal deflCgasCompacumulados) {
        this.deflCgasCompacumulados = deflCgasCompacumulados;
    }

    public BigDecimal getDeflCgasAutogiromes() {
        return deflCgasAutogiromes;
    }

    public void setDeflCgasAutogiromes(BigDecimal deflCgasAutogiromes) {
        this.deflCgasAutogiromes = deflCgasAutogiromes;
    }

    public BigDecimal getDeflCgasAutogiroacum() {
        return deflCgasAutogiroacum;
    }

    public void setDeflCgasAutogiroacum(BigDecimal deflCgasAutogiroacum) {
        this.deflCgasAutogiroacum = deflCgasAutogiroacum;
    }

    public Integer getCgasCodplandsllo() {
        return cgasCodplandsllo;
    }

    public void setCgasCodplandsllo(Integer cgasCodplandsllo) {
        this.cgasCodplandsllo = cgasCodplandsllo;
    }

    public String getCgasCodprograma() {
        return cgasCodprograma;
    }

    public void setCgasCodprograma(String cgasCodprograma) {
        this.cgasCodprograma = cgasCodprograma;
    }

    public String getGasCodnivel1() {
        return gasCodnivel1;
    }

    public void setGasCodnivel1(String gasCodnivel1) {
        this.gasCodnivel1 = gasCodnivel1;
    }

    public String getGasCodnivel2() {
        return gasCodnivel2;
    }

    public void setGasCodnivel2(String gasCodnivel2) {
        this.gasCodnivel2 = gasCodnivel2;
    }

    public String getGasCodnivel3() {
        return gasCodnivel3;
    }

    public void setGasCodnivel3(String gasCodnivel3) {
        this.gasCodnivel3 = gasCodnivel3;
    }

    public String getGasCodnivel4() {
        return gasCodnivel4;
    }

    public void setGasCodnivel4(String gasCodnivel4) {
        this.gasCodnivel4 = gasCodnivel4;
    }

    public String getGasCodnivel5() {
        return gasCodnivel5;
    }

    public void setGasCodnivel5(String gasCodnivel5) {
        this.gasCodnivel5 = gasCodnivel5;
    }

    public String getGasCodnivel6() {
        return gasCodnivel6;
    }

    public void setGasCodnivel6(String gasCodnivel6) {
        this.gasCodnivel6 = gasCodnivel6;
    }

    public String getGasCodnivel7() {
        return gasCodnivel7;
    }

    public void setGasCodnivel7(String gasCodnivel7) {
        this.gasCodnivel7 = gasCodnivel7;
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
        hash += (cgasId != null ? cgasId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PreCmgasto)) {
            return false;
        }
        PreCmgasto other = (PreCmgasto) object;
        if ((this.cgasId == null && other.cgasId != null) || (this.cgasId != null && !this.cgasId.equals(other.cgasId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.veeduria.adm.dao.PreCmgasto[ cgasId=" + cgasId + " ]";
    }

   

}
