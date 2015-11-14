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
@Table(name = "pre_cmgastoiyc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PreCmgastoiyc.findAll", query = "SELECT p FROM PreCmgastoiyc p"),
    @NamedQuery(name = "PreCmgastoiyc.findByGicId", query = "SELECT p FROM PreCmgastoiyc p WHERE p.gicId = :gicId"),
    @NamedQuery(name = "PreCmgastoiyc.findByGicCodcuenta", query = "SELECT p FROM PreCmgastoiyc p WHERE p.gicCodcuenta = :gicCodcuenta"),
    @NamedQuery(name = "PreCmgastoiyc.findByGicNomcuenta", query = "SELECT p FROM PreCmgastoiyc p WHERE p.gicNomcuenta = :gicNomcuenta"),
    @NamedQuery(name = "PreCmgastoiyc.findByGicApropinicial", query = "SELECT p FROM PreCmgastoiyc p WHERE p.gicApropinicial = :gicApropinicial"),
    @NamedQuery(name = "PreCmgastoiyc.findByGicModmes", query = "SELECT p FROM PreCmgastoiyc p WHERE p.gicModmes = :gicModmes"),
    @NamedQuery(name = "PreCmgastoiyc.findByGicModacumulado", query = "SELECT p FROM PreCmgastoiyc p WHERE p.gicModacumulado = :gicModacumulado"),
    @NamedQuery(name = "PreCmgastoiyc.findByGicApropvigente", query = "SELECT p FROM PreCmgastoiyc p WHERE p.gicApropvigente = :gicApropvigente"),
    @NamedQuery(name = "PreCmgastoiyc.findByGicApropsuspend", query = "SELECT p FROM PreCmgastoiyc p WHERE p.gicApropsuspend = :gicApropsuspend"),
    @NamedQuery(name = "PreCmgastoiyc.findByGicApropdisponible", query = "SELECT p FROM PreCmgastoiyc p WHERE p.gicApropdisponible = :gicApropdisponible"),
    @NamedQuery(name = "PreCmgastoiyc.findByGicCompmes", query = "SELECT p FROM PreCmgastoiyc p WHERE p.gicCompmes = :gicCompmes"),
    @NamedQuery(name = "PreCmgastoiyc.findByGicCompacumulados", query = "SELECT p FROM PreCmgastoiyc p WHERE p.gicCompacumulados = :gicCompacumulados"),
    @NamedQuery(name = "PreCmgastoiyc.findByGicPorejecptal", query = "SELECT p FROM PreCmgastoiyc p WHERE p.gicPorejecptal = :gicPorejecptal"),
    @NamedQuery(name = "PreCmgastoiyc.findByGicGiromes", query = "SELECT p FROM PreCmgastoiyc p WHERE p.gicGiromes = :gicGiromes"),
    @NamedQuery(name = "PreCmgastoiyc.findByGicGiroacumul", query = "SELECT p FROM PreCmgastoiyc p WHERE p.gicGiroacumul = :gicGiroacumul"),
    @NamedQuery(name = "PreCmgastoiyc.findByGicPorcgiro", query = "SELECT p FROM PreCmgastoiyc p WHERE p.gicPorcgiro = :gicPorcgiro")})
public class PreCmgastoiyc implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "gic_id")
    private Long gicId;
    @Size(max = 1500)
    @Column(name = "gic_codcuenta")
    private String gicCodcuenta;
    @Size(max = 1500)
    @Column(name = "gic_nomcuenta")
    private String gicNomcuenta;
    @Size(max = 1500)
    @Column(name = "gic_apropinicial")
    private String gicApropinicial;
    @Size(max = 1500)
    @Column(name = "gic_modmes")
    private String gicModmes;
    @Size(max = 1500)
    @Column(name = "gic_modacumulado")
    private String gicModacumulado;
    @Size(max = 1500)
    @Column(name = "gic_apropvigente")
    private String gicApropvigente;
    @Size(max = 1500)
    @Column(name = "gic_apropsuspend")
    private String gicApropsuspend;
    @Size(max = 1500)
    @Column(name = "gic_apropdisponible")
    private String gicApropdisponible;
    @Size(max = 1500)
    @Column(name = "gic_compmes")
    private String gicCompmes;
    @Size(max = 1500)
    @Column(name = "gic_compacumulados")
    private String gicCompacumulados;
    @Size(max = 1500)
    @Column(name = "gic_porejecptal")
    private String gicPorejecptal;
    @Size(max = 1500)
    @Column(name = "gic_giromes")
    private String gicGiromes;
    @Size(max = 1500)
    @Column(name = "gic_giroacumul")
    private String gicGiroacumul;
    @Size(max = 1500)
    @Column(name = "gic_porcgiro")
    private String gicPorcgiro;
    @JoinColumn(name = "lgreg_id", referencedColumnName = "lgreg_id")
    @ManyToOne
    private SysRegistrocarga lgregId;

    public PreCmgastoiyc() {
    }

    public PreCmgastoiyc(Long gicId) {
        this.gicId = gicId;
    }

    public Long getGicId() {
        return gicId;
    }

    public void setGicId(Long gicId) {
        this.gicId = gicId;
    }

    public String getGicCodcuenta() {
        return gicCodcuenta;
    }

    public void setGicCodcuenta(String gicCodcuenta) {
        this.gicCodcuenta = gicCodcuenta;
    }

    public String getGicNomcuenta() {
        return gicNomcuenta;
    }

    public void setGicNomcuenta(String gicNomcuenta) {
        this.gicNomcuenta = gicNomcuenta;
    }

    public String getGicApropinicial() {
        return gicApropinicial;
    }

    public void setGicApropinicial(String gicApropinicial) {
        this.gicApropinicial = gicApropinicial;
    }

    public String getGicModmes() {
        return gicModmes;
    }

    public void setGicModmes(String gicModmes) {
        this.gicModmes = gicModmes;
    }

    public String getGicModacumulado() {
        return gicModacumulado;
    }

    public void setGicModacumulado(String gicModacumulado) {
        this.gicModacumulado = gicModacumulado;
    }

    public String getGicApropvigente() {
        return gicApropvigente;
    }

    public void setGicApropvigente(String gicApropvigente) {
        this.gicApropvigente = gicApropvigente;
    }

    public String getGicApropsuspend() {
        return gicApropsuspend;
    }

    public void setGicApropsuspend(String gicApropsuspend) {
        this.gicApropsuspend = gicApropsuspend;
    }

    public String getGicApropdisponible() {
        return gicApropdisponible;
    }

    public void setGicApropdisponible(String gicApropdisponible) {
        this.gicApropdisponible = gicApropdisponible;
    }

    public String getGicCompmes() {
        return gicCompmes;
    }

    public void setGicCompmes(String gicCompmes) {
        this.gicCompmes = gicCompmes;
    }

    public String getGicCompacumulados() {
        return gicCompacumulados;
    }

    public void setGicCompacumulados(String gicCompacumulados) {
        this.gicCompacumulados = gicCompacumulados;
    }

    public String getGicPorejecptal() {
        return gicPorejecptal;
    }

    public void setGicPorejecptal(String gicPorejecptal) {
        this.gicPorejecptal = gicPorejecptal;
    }

    public String getGicGiromes() {
        return gicGiromes;
    }

    public void setGicGiromes(String gicGiromes) {
        this.gicGiromes = gicGiromes;
    }

    public String getGicGiroacumul() {
        return gicGiroacumul;
    }

    public void setGicGiroacumul(String gicGiroacumul) {
        this.gicGiroacumul = gicGiroacumul;
    }

    public String getGicPorcgiro() {
        return gicPorcgiro;
    }

    public void setGicPorcgiro(String gicPorcgiro) {
        this.gicPorcgiro = gicPorcgiro;
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
        hash += (gicId != null ? gicId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PreCmgastoiyc)) {
            return false;
        }
        PreCmgastoiyc other = (PreCmgastoiyc) object;
        if ((this.gicId == null && other.gicId != null) || (this.gicId != null && !this.gicId.equals(other.gicId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.veeduria.adm.dao.PreCmgastoiyc[ gicId=" + gicId + " ]";
    }
    
}
