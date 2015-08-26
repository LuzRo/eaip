/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veeduria.cnt.dao;

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
 * @author fernando
 */
@Entity
@Table(name = "cnt_plancuetagastos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CntPlancuetagastos.findAll", query = "SELECT c FROM CntPlancuetagastos c"),
    @NamedQuery(name = "CntPlancuetagastos.findByPcoId", query = "SELECT c FROM CntPlancuetagastos c WHERE c.pcoId = :pcoId"),
    @NamedQuery(name = "CntPlancuetagastos.findByPcoTipocuenta", query = "SELECT c FROM CntPlancuetagastos c WHERE c.pcoTipocuenta = :pcoTipocuenta"),
    @NamedQuery(name = "CntPlancuetagastos.findByPcoNumcuenta", query = "SELECT c FROM CntPlancuetagastos c WHERE c.pcoNumcuenta = :pcoNumcuenta"),
    @NamedQuery(name = "CntPlancuetagastos.findByPcoNomcuenta", query = "SELECT c FROM CntPlancuetagastos c WHERE c.pcoNomcuenta = :pcoNomcuenta"),
    @NamedQuery(name = "CntPlancuetagastos.findByPcoVigencia", query = "SELECT c FROM CntPlancuetagastos c WHERE c.pcoVigencia = :pcoVigencia"),
    @NamedQuery(name = "CntPlancuetagastos.findByArchivo", query = "SELECT c FROM CntPlancuetagastos c WHERE c.archivo = :archivo"),
    @NamedQuery(name = "CntPlancuetagastos.findCuentaYPeriodo", query = "SELECT c FROM CntPlancuetagastos c WHERE c.pcoNumcuenta = :pcoNumcuenta AND c.pcoVigencia = :pcoVigencia "),
    @NamedQuery(name = "CntPlancuetagastos.findCuentaLikeNombre", query = "SELECT c FROM CntPlancuetagastos c WHERE c.pcoNomcuenta LIKE :pcoNomcuenta ORDER BY c.pcoNomcuenta")
})
public class CntPlancuetagastos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pco_id")
    private Long pcoId;
    @Size(max = 200)
    @Column(name = "pco_tipocuenta")
    private String pcoTipocuenta;
    @Size(max = 200)
    @Column(name = "pco_numcuenta")
    private String pcoNumcuenta;
    @Size(max = 2147483647)
    @Column(name = "pco_nomcuenta")
    private String pcoNomcuenta;
    @Column(name = "pco_vigencia")
    private Integer pcoVigencia;
    @Size(max = 400)
    @Column(name = "archivo")
    private String archivo;

    public CntPlancuetagastos() {
    }

    public CntPlancuetagastos(Long pcoId) {
        this.pcoId = pcoId;
    }

    public Long getPcoId() {
        return pcoId;
    }

    public void setPcoId(Long pcoId) {
        this.pcoId = pcoId;
    }

    public String getPcoTipocuenta() {
        return pcoTipocuenta;
    }

    public void setPcoTipocuenta(String pcoTipocuenta) {
        this.pcoTipocuenta = pcoTipocuenta;
    }

    public String getPcoNumcuenta() {
        return pcoNumcuenta;
    }

    public void setPcoNumcuenta(String pcoNumcuenta) {
        this.pcoNumcuenta = pcoNumcuenta;
    }

    public String getPcoNomcuenta() {
        return pcoNomcuenta;
    }

    public void setPcoNomcuenta(String pcoNomcuenta) {
        this.pcoNomcuenta = pcoNomcuenta;
    }

    public Integer getPcoVigencia() {
        return pcoVigencia;
    }

    public void setPcoVigencia(Integer pcoVigencia) {
        this.pcoVigencia = pcoVigencia;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pcoId != null ? pcoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CntPlancuetagastos)) {
            return false;
        }
        CntPlancuetagastos other = (CntPlancuetagastos) object;
        if ((this.pcoId == null && other.pcoId != null) || (this.pcoId != null && !this.pcoId.equals(other.pcoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.veeduria.dao.CntPlancuetagastos[ pcoId=" + pcoId + " ]";
    }

}
