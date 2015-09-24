/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veeduria.com.dao;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "con_cmsaldosmovs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConCmsaldosmovs.findAll", query = "SELECT c FROM ConCmsaldosmovs c"),
    @NamedQuery(name = "ConCmsaldosmovs.findByCsmId", query = "SELECT c FROM ConCmsaldosmovs c WHERE c.csmId = :csmId"),
    @NamedQuery(name = "ConCmsaldosmovs.findByCsmCodconta", query = "SELECT c FROM ConCmsaldosmovs c WHERE c.csmCodconta = :csmCodconta"),
    @NamedQuery(name = "ConCmsaldosmovs.findByCsmNomconta", query = "SELECT c FROM ConCmsaldosmovs c WHERE c.csmNomconta = :csmNomconta"),
    @NamedQuery(name = "ConCmsaldosmovs.findByCsmSalinicial", query = "SELECT c FROM ConCmsaldosmovs c WHERE c.csmSalinicial = :csmSalinicial"),
    @NamedQuery(name = "ConCmsaldosmovs.findByCsmMovdebito", query = "SELECT c FROM ConCmsaldosmovs c WHERE c.csmMovdebito = :csmMovdebito"),
    @NamedQuery(name = "ConCmsaldosmovs.findByCsmMovcredito", query = "SELECT c FROM ConCmsaldosmovs c WHERE c.csmMovcredito = :csmMovcredito"),
    @NamedQuery(name = "ConCmsaldosmovs.findByCsmSalfinal", query = "SELECT c FROM ConCmsaldosmovs c WHERE c.csmSalfinal = :csmSalfinal"),
    @NamedQuery(name = "ConCmsaldosmovs.findByCsmSalfinalcorriente", query = "SELECT c FROM ConCmsaldosmovs c WHERE c.csmSalfinalcorriente = :csmSalfinalcorriente"),
    @NamedQuery(name = "ConCmsaldosmovs.findByCsmSalfinalnocorriente", query = "SELECT c FROM ConCmsaldosmovs c WHERE c.csmSalfinalnocorriente = :csmSalfinalnocorriente")})
public class ConCmsaldosmovs implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "csm_id")
    private Long csmId;
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

    public ConCmsaldosmovs() {
    }

    public ConCmsaldosmovs(Long csmId) {
        this.csmId = csmId;
    }

    public Long getCsmId() {
        return csmId;
    }

    public void setCsmId(Long csmId) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (csmId != null ? csmId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConCmsaldosmovs)) {
            return false;
        }
        ConCmsaldosmovs other = (ConCmsaldosmovs) object;
        if ((this.csmId == null && other.csmId != null) || (this.csmId != null && !this.csmId.equals(other.csmId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.veeduria.adm.dao.ConCmsaldosmovs[ csmId=" + csmId + " ]";
    }
    
}
