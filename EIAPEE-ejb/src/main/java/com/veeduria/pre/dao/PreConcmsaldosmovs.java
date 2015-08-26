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
@Table(name = "pre_concmsaldosmovs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PreConcmsaldosmovs.findAll", query = "SELECT p FROM PreConcmsaldosmovs p"),
    @NamedQuery(name = "PreConcmsaldosmovs.findByCsmCodconta", query = "SELECT p FROM PreConcmsaldosmovs p WHERE p.csmCodconta = :csmCodconta"),
    @NamedQuery(name = "PreConcmsaldosmovs.findByCsmNomconta", query = "SELECT p FROM PreConcmsaldosmovs p WHERE p.csmNomconta = :csmNomconta"),
    @NamedQuery(name = "PreConcmsaldosmovs.findByCsmSalinicial", query = "SELECT p FROM PreConcmsaldosmovs p WHERE p.csmSalinicial = :csmSalinicial"),
    @NamedQuery(name = "PreConcmsaldosmovs.findByCsmMovdebito", query = "SELECT p FROM PreConcmsaldosmovs p WHERE p.csmMovdebito = :csmMovdebito"),
    @NamedQuery(name = "PreConcmsaldosmovs.findByCsmMovcredito", query = "SELECT p FROM PreConcmsaldosmovs p WHERE p.csmMovcredito = :csmMovcredito"),
    @NamedQuery(name = "PreConcmsaldosmovs.findByCsmSalfinal", query = "SELECT p FROM PreConcmsaldosmovs p WHERE p.csmSalfinal = :csmSalfinal"),
    @NamedQuery(name = "PreConcmsaldosmovs.findByCsmSalfinalcorriente", query = "SELECT p FROM PreConcmsaldosmovs p WHERE p.csmSalfinalcorriente = :csmSalfinalcorriente"),
    @NamedQuery(name = "PreConcmsaldosmovs.findByCsmSalfinalnocorriente", query = "SELECT p FROM PreConcmsaldosmovs p WHERE p.csmSalfinalnocorriente = :csmSalfinalnocorriente"),
    @NamedQuery(name = "PreConcmsaldosmovs.findByCsmId", query = "SELECT p FROM PreConcmsaldosmovs p WHERE p.csmId = :csmId")})
public class PreConcmsaldosmovs implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 1500)
    @Column(name = "csm_codconta")
    private String csmCodconta;
    @Size(max = 1500)
    @Column(name = "csm_nomconta")
    private String csmNomconta;
    @Size(max = 1500)
    @Column(name = "csm_salinicial")
    private String csmSalinicial;
    @Size(max = 1500)
    @Column(name = "csm_movdebito")
    private String csmMovdebito;
    @Size(max = 1500)
    @Column(name = "csm_movcredito")
    private String csmMovcredito;
    @Size(max = 1500)
    @Column(name = "csm_salfinal")
    private String csmSalfinal;
    @Size(max = 1500)
    @Column(name = "csm_salfinalcorriente")
    private String csmSalfinalcorriente;
    @Size(max = 1500)
    @Column(name = "csm_salfinalnocorriente")
    private String csmSalfinalnocorriente;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "csm_id")
    private Integer csmId;
    @JoinColumn(name = "lgreg_id", referencedColumnName = "lgreg_id")
    @ManyToOne
    private SysRegistrocarga lgregId;

    public PreConcmsaldosmovs() {
    }

    public PreConcmsaldosmovs(Integer csmId) {
        this.csmId = csmId;
    }

    public String getCsmCodconta() {
        return csmCodconta;
    }

    public void setCsmCodconta(String csmCodconta) {
        this.csmCodconta = csmCodconta;
    }

    public String getCsmNomconta() {
        return csmNomconta;
    }

    public void setCsmNomconta(String csmNomconta) {
        this.csmNomconta = csmNomconta;
    }

    public String getCsmSalinicial() {
        return csmSalinicial;
    }

    public void setCsmSalinicial(String csmSalinicial) {
        this.csmSalinicial = csmSalinicial;
    }

    public String getCsmMovdebito() {
        return csmMovdebito;
    }

    public void setCsmMovdebito(String csmMovdebito) {
        this.csmMovdebito = csmMovdebito;
    }

    public String getCsmMovcredito() {
        return csmMovcredito;
    }

    public void setCsmMovcredito(String csmMovcredito) {
        this.csmMovcredito = csmMovcredito;
    }

    public String getCsmSalfinal() {
        return csmSalfinal;
    }

    public void setCsmSalfinal(String csmSalfinal) {
        this.csmSalfinal = csmSalfinal;
    }

    public String getCsmSalfinalcorriente() {
        return csmSalfinalcorriente;
    }

    public void setCsmSalfinalcorriente(String csmSalfinalcorriente) {
        this.csmSalfinalcorriente = csmSalfinalcorriente;
    }

    public String getCsmSalfinalnocorriente() {
        return csmSalfinalnocorriente;
    }

    public void setCsmSalfinalnocorriente(String csmSalfinalnocorriente) {
        this.csmSalfinalnocorriente = csmSalfinalnocorriente;
    }

    public Integer getCsmId() {
        return csmId;
    }

    public void setCsmId(Integer csmId) {
        this.csmId = csmId;
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
        hash += (csmId != null ? csmId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PreConcmsaldosmovs)) {
            return false;
        }
        PreConcmsaldosmovs other = (PreConcmsaldosmovs) object;
        if ((this.csmId == null && other.csmId != null) || (this.csmId != null && !this.csmId.equals(other.csmId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.veeduria.adm.dao.PreConcmsaldosmovs[ csmId=" + csmId + " ]";
    }
    
}
