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
    @NamedQuery(name = "PreCmgasto.findByCgasPorejecautogiro", query = "SELECT p FROM PreCmgasto p WHERE p.cgasPorejecautogiro = :cgasPorejecautogiro")})
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
