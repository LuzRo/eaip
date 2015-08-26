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
@Table(name = "pre_conoperarecipro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PreConoperarecipro.findAll", query = "SELECT p FROM PreConoperarecipro p"),
    @NamedQuery(name = "PreConoperarecipro.findByOprId", query = "SELECT p FROM PreConoperarecipro p WHERE p.oprId = :oprId"),
    @NamedQuery(name = "PreConoperarecipro.findByOprCodconsub", query = "SELECT p FROM PreConoperarecipro p WHERE p.oprCodconsub = :oprCodconsub"),
    @NamedQuery(name = "PreConoperarecipro.findByOprNomsubcuenta", query = "SELECT p FROM PreConoperarecipro p WHERE p.oprNomsubcuenta = :oprNomsubcuenta"),
    @NamedQuery(name = "PreConoperarecipro.findByOprCodentireci", query = "SELECT p FROM PreConoperarecipro p WHERE p.oprCodentireci = :oprCodentireci"),
    @NamedQuery(name = "PreConoperarecipro.findByOprNomentireci", query = "SELECT p FROM PreConoperarecipro p WHERE p.oprNomentireci = :oprNomentireci"),
    @NamedQuery(name = "PreConoperarecipro.findByOprVlrcorriente", query = "SELECT p FROM PreConoperarecipro p WHERE p.oprVlrcorriente = :oprVlrcorriente"),
    @NamedQuery(name = "PreConoperarecipro.findByOprVlrnocorriente", query = "SELECT p FROM PreConoperarecipro p WHERE p.oprVlrnocorriente = :oprVlrnocorriente")})
public class PreConoperarecipro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "opr_id")
    private Integer oprId;
    @Size(max = 1500)
    @Column(name = "opr_codconsub")
    private String oprCodconsub;
    @Size(max = 1500)
    @Column(name = "opr_nomsubcuenta")
    private String oprNomsubcuenta;
    @Size(max = 1500)
    @Column(name = "opr_codentireci")
    private String oprCodentireci;
    @Size(max = 1500)
    @Column(name = "opr_nomentireci")
    private String oprNomentireci;
    @Size(max = 1500)
    @Column(name = "opr_vlrcorriente")
    private String oprVlrcorriente;
    @Size(max = 1500)
    @Column(name = "opr_vlrnocorriente")
    private String oprVlrnocorriente;
    @JoinColumn(name = "lgreg_id", referencedColumnName = "lgreg_id")
    @ManyToOne
    private SysRegistrocarga lgregId;

    public PreConoperarecipro() {
    }

    public PreConoperarecipro(Integer oprId) {
        this.oprId = oprId;
    }

    public Integer getOprId() {
        return oprId;
    }

    public void setOprId(Integer oprId) {
        this.oprId = oprId;
    }

    public String getOprCodconsub() {
        return oprCodconsub;
    }

    public void setOprCodconsub(String oprCodconsub) {
        this.oprCodconsub = oprCodconsub;
    }

    public String getOprNomsubcuenta() {
        return oprNomsubcuenta;
    }

    public void setOprNomsubcuenta(String oprNomsubcuenta) {
        this.oprNomsubcuenta = oprNomsubcuenta;
    }

    public String getOprCodentireci() {
        return oprCodentireci;
    }

    public void setOprCodentireci(String oprCodentireci) {
        this.oprCodentireci = oprCodentireci;
    }

    public String getOprNomentireci() {
        return oprNomentireci;
    }

    public void setOprNomentireci(String oprNomentireci) {
        this.oprNomentireci = oprNomentireci;
    }

    public String getOprVlrcorriente() {
        return oprVlrcorriente;
    }

    public void setOprVlrcorriente(String oprVlrcorriente) {
        this.oprVlrcorriente = oprVlrcorriente;
    }

    public String getOprVlrnocorriente() {
        return oprVlrnocorriente;
    }

    public void setOprVlrnocorriente(String oprVlrnocorriente) {
        this.oprVlrnocorriente = oprVlrnocorriente;
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
        hash += (oprId != null ? oprId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PreConoperarecipro)) {
            return false;
        }
        PreConoperarecipro other = (PreConoperarecipro) object;
        if ((this.oprId == null && other.oprId != null) || (this.oprId != null && !this.oprId.equals(other.oprId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.veeduria.adm.dao.PreConoperarecipro[ oprId=" + oprId + " ]";
    }
    
}
