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
@Table(name = "cnt_plancuetaingreso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CntPlancuetaingreso.findAll", query = "SELECT c FROM CntPlancuetaingreso c"),
    @NamedQuery(name = "CntPlancuetaingreso.findByPcomId", query = "SELECT c FROM CntPlancuetaingreso c WHERE c.pcomId = :pcomId"),
    @NamedQuery(name = "CntPlancuetaingreso.findByPcomTipoEntidad", query = "SELECT c FROM CntPlancuetaingreso c WHERE c.pcomTipoEntidad = :pcomTipoEntidad"),
    @NamedQuery(name = "CntPlancuetaingreso.findByPcomCodCuenta", query = "SELECT c FROM CntPlancuetaingreso c WHERE c.pcomCodCuenta = :pcomCodCuenta"),
    @NamedQuery(name = "CntPlancuetaingreso.findByPcomVigencia", query = "SELECT c FROM CntPlancuetaingreso c WHERE c.pcomVigencia = :pcomVigencia"),
    @NamedQuery(name = "CntPlancuetaingreso.findByPcomNombreCuenta", query = "SELECT c FROM CntPlancuetaingreso c WHERE c.pcomNombreCuenta = :pcomNombreCuenta"),
    @NamedQuery(name = "CntPlancuetaingreso.findByPcomCodigoEntidad", query = "SELECT c FROM CntPlancuetaingreso c WHERE c.pcomCodigoEntidad = :pcomCodigoEntidad"),
    @NamedQuery(name = "CntPlancuetaingreso.findByPcomNombreEntidad", query = "SELECT c FROM CntPlancuetaingreso c WHERE c.pcomNombreEntidad = :pcomNombreEntidad"),
    @NamedQuery(name = "CntPlancuetaingreso.findByPcomArchivo", query = "SELECT c FROM CntPlancuetaingreso c WHERE c.pcomArchivo = :pcomArchivo"),
    @NamedQuery(name = "CntPlancuetaingreso.findByPcomArchivorev", query = "SELECT c FROM CntPlancuetaingreso c WHERE c.pcomArchivorev = :pcomArchivorev")})
public class CntPlancuetaingreso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pcom_id")
    private Long pcomId;
    @Size(max = 1500)
    @Column(name = "pcom_tipo_entidad")
    private String pcomTipoEntidad;
    @Size(max = 1500)
    @Column(name = "pcom_cod_cuenta")
    private String pcomCodCuenta;
    @Column(name = "pcom_vigencia")
    private Integer pcomVigencia;
    @Size(max = 2147483647)
    @Column(name = "pcom_nombre_cuenta")
    private String pcomNombreCuenta;
    @Size(max = 1500)
    @Column(name = "pcom_codigo_entidad")
    private String pcomCodigoEntidad;
    @Size(max = 2147483647)
    @Column(name = "pcom_nombre_entidad")
    private String pcomNombreEntidad;
    @Size(max = 1500)
    @Column(name = "pcom_archivo")
    private String pcomArchivo;
    @Size(max = 1500)
    @Column(name = "pcom_archivorev")
    private String pcomArchivorev;

    public CntPlancuetaingreso() {
    }

    public CntPlancuetaingreso(Long pcomId) {
        this.pcomId = pcomId;
    }

    public Long getPcomId() {
        return pcomId;
    }

    public void setPcomId(Long pcomId) {
        this.pcomId = pcomId;
    }

    public String getPcomTipoEntidad() {
        return pcomTipoEntidad;
    }

    public void setPcomTipoEntidad(String pcomTipoEntidad) {
        this.pcomTipoEntidad = pcomTipoEntidad;
    }

    public String getPcomCodCuenta() {
        return pcomCodCuenta;
    }

    public void setPcomCodCuenta(String pcomCodCuenta) {
        this.pcomCodCuenta = pcomCodCuenta;
    }

    public Integer getPcomVigencia() {
        return pcomVigencia;
    }

    public void setPcomVigencia(Integer pcomVigencia) {
        this.pcomVigencia = pcomVigencia;
    }

    public String getPcomNombreCuenta() {
        return pcomNombreCuenta;
    }

    public void setPcomNombreCuenta(String pcomNombreCuenta) {
        this.pcomNombreCuenta = pcomNombreCuenta;
    }

    public String getPcomCodigoEntidad() {
        return pcomCodigoEntidad;
    }

    public void setPcomCodigoEntidad(String pcomCodigoEntidad) {
        this.pcomCodigoEntidad = pcomCodigoEntidad;
    }

    public String getPcomNombreEntidad() {
        return pcomNombreEntidad;
    }

    public void setPcomNombreEntidad(String pcomNombreEntidad) {
        this.pcomNombreEntidad = pcomNombreEntidad;
    }

    public String getPcomArchivo() {
        return pcomArchivo;
    }

    public void setPcomArchivo(String pcomArchivo) {
        this.pcomArchivo = pcomArchivo;
    }

    public String getPcomArchivorev() {
        return pcomArchivorev;
    }

    public void setPcomArchivorev(String pcomArchivorev) {
        this.pcomArchivorev = pcomArchivorev;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pcomId != null ? pcomId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CntPlancuetaingreso)) {
            return false;
        }
        CntPlancuetaingreso other = (CntPlancuetaingreso) object;
        if ((this.pcomId == null && other.pcomId != null) || (this.pcomId != null && !this.pcomId.equals(other.pcomId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.veeduria.dao.CntPlancuetaingreso[ pcomId=" + pcomId + " ]";
    }
    
}
