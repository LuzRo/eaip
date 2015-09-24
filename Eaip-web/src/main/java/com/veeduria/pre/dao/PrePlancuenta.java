/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veeduria.pre.dao;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author luz
 */
@Entity
@Table(name = "pre_plancuenta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrePlancuenta.findAll", query = "SELECT p FROM PrePlancuenta p"),
    @NamedQuery(name = "PrePlancuenta.findByPlnCodigo", query = "SELECT p FROM PrePlancuenta p WHERE p.plnCodigo = :plnCodigo"),
    @NamedQuery(name = "PrePlancuenta.findByPlnNombre", query = "SELECT p FROM PrePlancuenta p WHERE p.plnNombre = :plnNombre"),
    @NamedQuery(name = "PrePlancuenta.findByPlnEstado", query = "SELECT p FROM PrePlancuenta p WHERE p.plnEstado = :plnEstado"),
    @NamedQuery(name = "PrePlancuenta.findByPlnPrincipal", query = "SELECT p FROM PrePlancuenta p WHERE p.plnPrincipal = :plnPrincipal"),
    @NamedQuery(name = "PrePlancuenta.findByPlnDescripcion", query = "SELECT p FROM PrePlancuenta p WHERE p.plnDescripcion = :plnDescripcion"),
    @NamedQuery(name = "PrePlancuenta.findByPlnId", query = "SELECT p FROM PrePlancuenta p WHERE p.plnId = :plnId")})
public class PrePlancuenta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "pln_codigo")
    private String plnCodigo;
    @Size(max = 1500)
    @Column(name = "pln_nombre")
    private String plnNombre;
    @Column(name = "pln_estado")
    private Boolean plnEstado;
    @Column(name = "pln_principal")
    private Boolean plnPrincipal;
    @Size(max = 2147483647)
    @Column(name = "pln_descripcion")
    private String plnDescripcion;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pln_id")
    private Long plnId;
    @JoinColumn(name = "cpc_id", referencedColumnName = "cpc_id")
    @ManyToOne
    private PreClaseplancuenta cpcId;

    public PrePlancuenta() {
    }

    public PrePlancuenta(Long plnId) {
        this.plnId = plnId;
    }

    public PrePlancuenta(Long plnId, String plnCodigo) {
        this.plnId = plnId;
        this.plnCodigo = plnCodigo;
    }

    public String getPlnCodigo() {
        return plnCodigo;
    }

    public void setPlnCodigo(String plnCodigo) {
        this.plnCodigo = plnCodigo;
    }

    public String getPlnNombre() {
        return plnNombre;
    }

    public void setPlnNombre(String plnNombre) {
        this.plnNombre = plnNombre;
    }

    public Boolean getPlnEstado() {
        return plnEstado;
    }

    public void setPlnEstado(Boolean plnEstado) {
        this.plnEstado = plnEstado;
    }

    public Boolean getPlnPrincipal() {
        return plnPrincipal;
    }

    public void setPlnPrincipal(Boolean plnPrincipal) {
        this.plnPrincipal = plnPrincipal;
    }

    public String getPlnDescripcion() {
        return plnDescripcion;
    }

    public void setPlnDescripcion(String plnDescripcion) {
        this.plnDescripcion = plnDescripcion;
    }

    public Long getPlnId() {
        return plnId;
    }

    public void setPlnId(Long plnId) {
        this.plnId = plnId;
    }

    public PreClaseplancuenta getCpcId() {
        return cpcId;
    }

    public void setCpcId(PreClaseplancuenta cpcId) {
        this.cpcId = cpcId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (plnId != null ? plnId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrePlancuenta)) {
            return false;
        }
        PrePlancuenta other = (PrePlancuenta) object;
        if ((this.plnId == null && other.plnId != null) || (this.plnId != null && !this.plnId.equals(other.plnId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.veeduria.adm.dao.PrePlancuenta[ plnId=" + plnId + " ]";
    }
    
}
