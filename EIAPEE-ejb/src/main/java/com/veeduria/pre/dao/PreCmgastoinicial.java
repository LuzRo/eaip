/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.veeduria.pre.dao;

import com.veeduria.cnt.dao.CntPlancuetagastos;
import com.veeduria.sys.dao.SysRegistrocarga;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
 * @author fernando
 */
@Entity
@Table(name = "pre_cmgastoinicial")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PreCmgastoinicial.findAll", query = "SELECT p FROM PreCmgastoinicial p"),
    @NamedQuery(name = "PreCmgastoinicial.findByGinId", query = "SELECT p FROM PreCmgastoinicial p WHERE p.ginId = :ginId"),
    @NamedQuery(name = "PreCmgastoinicial.findByGinCodcuenta", query = "SELECT p FROM PreCmgastoinicial p WHERE p.ginCodcuenta = :ginCodcuenta"),
    @NamedQuery(name = "PreCmgastoinicial.findByGinNomcuenta", query = "SELECT p FROM PreCmgastoinicial p WHERE p.ginNomcuenta = :ginNomcuenta"),
    @NamedQuery(name = "PreCmgastoinicial.findByGinApropinicial", query = "SELECT p FROM PreCmgastoinicial p WHERE p.ginApropinicial = :ginApropinicial"),
    @NamedQuery(name = "PreCmgastoinicial.findByGinModificacion", query = "SELECT p FROM PreCmgastoinicial p WHERE p.ginModificacion = :ginModificacion"),
    @NamedQuery(name = "PreCmgastoinicial.findByGinApropvigente", query = "SELECT p FROM PreCmgastoinicial p WHERE p.ginApropvigente = :ginApropvigente"),
    @NamedQuery(name = "PreCmgastoinicial.findByGinSuspension", query = "SELECT p FROM PreCmgastoinicial p WHERE p.ginSuspension = :ginSuspension"),
    @NamedQuery(name = "PreCmgastoinicial.findByGinApropdisponible", query = "SELECT p FROM PreCmgastoinicial p WHERE p.ginApropdisponible = :ginApropdisponible"),
    @NamedQuery(name = "PreCmgastoinicial.findByGinCompmes", query = "SELECT p FROM PreCmgastoinicial p WHERE p.ginCompmes = :ginCompmes"),
    @NamedQuery(name = "PreCmgastoinicial.findByGinCompacumulados", query = "SELECT p FROM PreCmgastoinicial p WHERE p.ginCompacumulados = :ginCompacumulados"),
    @NamedQuery(name = "PreCmgastoinicial.findByGinPorejecptal", query = "SELECT p FROM PreCmgastoinicial p WHERE p.ginPorejecptal = :ginPorejecptal"),
    @NamedQuery(name = "PreCmgastoinicial.findByGinAutogiromes", query = "SELECT p FROM PreCmgastoinicial p WHERE p.ginAutogiromes = :ginAutogiromes"),
    @NamedQuery(name = "PreCmgastoinicial.findByGinAutogiroacum", query = "SELECT p FROM PreCmgastoinicial p WHERE p.ginAutogiroacum = :ginAutogiroacum"),
    @NamedQuery(name = "PreCmgastoinicial.findByGinPorejecautogiro", query = "SELECT p FROM PreCmgastoinicial p WHERE p.ginPorejecautogiro = :ginPorejecautogiro")})
public class PreCmgastoinicial implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "gin_id")
    private Long ginId;
    @Size(max = 1500)
    @Column(name = "gin_codcuenta")
    private String ginCodcuenta;
    @Size(max = 1500)
    @Column(name = "gin_nomcuenta")
    private String ginNomcuenta;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "gin_apropinicial")
    private BigDecimal ginApropinicial;
    @Column(name = "gin_modificacion")
    private BigDecimal ginModificacion;
    @Column(name = "gin_apropvigente")
    private BigDecimal ginApropvigente;
    @Column(name = "gin_suspension")
    private BigDecimal ginSuspension;
    @Column(name = "gin_apropdisponible")
    private BigDecimal ginApropdisponible;
    @Column(name = "gin_compmes")
    private BigDecimal ginCompmes;
    @Column(name = "gin_compacumulados")
    private BigDecimal ginCompacumulados;
    @Column(name = "gin_porejecptal")
    private BigDecimal ginPorejecptal;
    @Column(name = "gin_autogiromes")
    private BigDecimal ginAutogiromes;
    @Column(name = "gin_autogiroacum")
    private BigDecimal ginAutogiroacum;
    @Column(name = "gin_porejecautogiro")
    private BigDecimal ginPorejecautogiro;
    @OneToMany(mappedBy = "ginId")
    private List<PreCmgastoinconsistencia> preCmgastoinconsistenciaList;
    @JoinColumn(name = "lgreg_id", referencedColumnName = "lgreg_id")
    @ManyToOne
    private SysRegistrocarga lgregId;
   

    public PreCmgastoinicial() {
    }

    public PreCmgastoinicial(Long ginId) {
        this.ginId = ginId;
    }

    public Long getGinId() {
        return ginId;
    }

    public void setGinId(Long ginId) {
        this.ginId = ginId;
    }

    public String getGinCodcuenta() {
        return ginCodcuenta;
    }

    public void setGinCodcuenta(String ginCodcuenta) {
        this.ginCodcuenta = ginCodcuenta;
    }

    public String getGinNomcuenta() {
        return ginNomcuenta;
    }

    public void setGinNomcuenta(String ginNomcuenta) {
        this.ginNomcuenta = ginNomcuenta;
    }

    public BigDecimal getGinApropinicial() {
        return ginApropinicial;
    }

    public void setGinApropinicial(BigDecimal ginApropinicial) {
        this.ginApropinicial = ginApropinicial;
    }

    public BigDecimal getGinModificacion() {
        return ginModificacion;
    }

    public void setGinModificacion(BigDecimal ginModificacion) {
        this.ginModificacion = ginModificacion;
    }

    public BigDecimal getGinApropvigente() {
        return ginApropvigente;
    }

    public void setGinApropvigente(BigDecimal ginApropvigente) {
        this.ginApropvigente = ginApropvigente;
    }

    public BigDecimal getGinSuspension() {
        return ginSuspension;
    }

    public void setGinSuspension(BigDecimal ginSuspension) {
        this.ginSuspension = ginSuspension;
    }

    public BigDecimal getGinApropdisponible() {
        return ginApropdisponible;
    }

    public void setGinApropdisponible(BigDecimal ginApropdisponible) {
        this.ginApropdisponible = ginApropdisponible;
    }

    public BigDecimal getGinCompmes() {
        return ginCompmes;
    }

    public void setGinCompmes(BigDecimal ginCompmes) {
        this.ginCompmes = ginCompmes;
    }

    public BigDecimal getGinCompacumulados() {
        return ginCompacumulados;
    }

    public void setGinCompacumulados(BigDecimal ginCompacumulados) {
        this.ginCompacumulados = ginCompacumulados;
    }

    public BigDecimal getGinPorejecptal() {
        return ginPorejecptal;
    }

    public void setGinPorejecptal(BigDecimal ginPorejecptal) {
        this.ginPorejecptal = ginPorejecptal;
    }

    public BigDecimal getGinAutogiromes() {
        return ginAutogiromes;
    }

    public void setGinAutogiromes(BigDecimal ginAutogiromes) {
        this.ginAutogiromes = ginAutogiromes;
    }

    public BigDecimal getGinAutogiroacum() {
        return ginAutogiroacum;
    }

    public void setGinAutogiroacum(BigDecimal ginAutogiroacum) {
        this.ginAutogiroacum = ginAutogiroacum;
    }

    public BigDecimal getGinPorejecautogiro() {
        return ginPorejecautogiro;
    }

    public void setGinPorejecautogiro(BigDecimal ginPorejecautogiro) {
        this.ginPorejecautogiro = ginPorejecautogiro;
    }

    @XmlTransient
    public List<PreCmgastoinconsistencia> getPreCmgastoinconsistenciaList() {
        return preCmgastoinconsistenciaList;
    }

    public void setPreCmgastoinconsistenciaList(List<PreCmgastoinconsistencia> preCmgastoinconsistenciaList) {
        this.preCmgastoinconsistenciaList = preCmgastoinconsistenciaList;
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
        hash += (ginId != null ? ginId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PreCmgastoinicial)) {
            return false;
        }
        PreCmgastoinicial other = (PreCmgastoinicial) object;
        if ((this.ginId == null && other.ginId != null) || (this.ginId != null && !this.ginId.equals(other.ginId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.veeduria.dao.PreCmgastoinicial[ ginId=" + ginId + " ]";
    }
    
}
