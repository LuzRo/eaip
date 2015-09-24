/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.veeduria.pla.dao;

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
 * @author con1ead
 */
@Entity
@Table(name = "pla_territorializacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlaTerritorializacion.findAll", query = "SELECT p FROM PlaTerritorializacion p"),
    @NamedQuery(name = "PlaTerritorializacion.findByPteId", query = "SELECT p FROM PlaTerritorializacion p WHERE p.pteId = :pteId"),
    @NamedQuery(name = "PlaTerritorializacion.findByPteCodigopd", query = "SELECT p FROM PlaTerritorializacion p WHERE p.pteCodigopd = :pteCodigopd"),
    @NamedQuery(name = "PlaTerritorializacion.findByPteNombrepd", query = "SELECT p FROM PlaTerritorializacion p WHERE p.pteNombrepd = :pteNombrepd"),
    @NamedQuery(name = "PlaTerritorializacion.findByPteAnogeo", query = "SELECT p FROM PlaTerritorializacion p WHERE p.pteAnogeo = :pteAnogeo"),
    @NamedQuery(name = "PlaTerritorializacion.findByPteVersiongeo", query = "SELECT p FROM PlaTerritorializacion p WHERE p.pteVersiongeo = :pteVersiongeo"),
    @NamedQuery(name = "PlaTerritorializacion.findByPteCodigoentidad", query = "SELECT p FROM PlaTerritorializacion p WHERE p.pteCodigoentidad = :pteCodigoentidad"),
    @NamedQuery(name = "PlaTerritorializacion.findByPteNombreentidad", query = "SELECT p FROM PlaTerritorializacion p WHERE p.pteNombreentidad = :pteNombreentidad"),
    @NamedQuery(name = "PlaTerritorializacion.findByPteCodigosector", query = "SELECT p FROM PlaTerritorializacion p WHERE p.pteCodigosector = :pteCodigosector"),
    @NamedQuery(name = "PlaTerritorializacion.findByPteNombresector", query = "SELECT p FROM PlaTerritorializacion p WHERE p.pteNombresector = :pteNombresector"),
    @NamedQuery(name = "PlaTerritorializacion.findByPteCodigolocalizacion", query = "SELECT p FROM PlaTerritorializacion p WHERE p.pteCodigolocalizacion = :pteCodigolocalizacion"),
    @NamedQuery(name = "PlaTerritorializacion.findByPteNombrelocalizacion", query = "SELECT p FROM PlaTerritorializacion p WHERE p.pteNombrelocalizacion = :pteNombrelocalizacion"),
    @NamedQuery(name = "PlaTerritorializacion.findByPteCodcomponenten1", query = "SELECT p FROM PlaTerritorializacion p WHERE p.pteCodcomponenten1 = :pteCodcomponenten1"),
    @NamedQuery(name = "PlaTerritorializacion.findByPteNomcomponenten1", query = "SELECT p FROM PlaTerritorializacion p WHERE p.pteNomcomponenten1 = :pteNomcomponenten1"),
    @NamedQuery(name = "PlaTerritorializacion.findByPteCodcomponenten2", query = "SELECT p FROM PlaTerritorializacion p WHERE p.pteCodcomponenten2 = :pteCodcomponenten2"),
    @NamedQuery(name = "PlaTerritorializacion.findByPteNomcomponenten2", query = "SELECT p FROM PlaTerritorializacion p WHERE p.pteNomcomponenten2 = :pteNomcomponenten2"),
    @NamedQuery(name = "PlaTerritorializacion.findByPteCodigoproyecto", query = "SELECT p FROM PlaTerritorializacion p WHERE p.pteCodigoproyecto = :pteCodigoproyecto"),
    @NamedQuery(name = "PlaTerritorializacion.findByPteNombreproyecto", query = "SELECT p FROM PlaTerritorializacion p WHERE p.pteNombreproyecto = :pteNombreproyecto"),
    @NamedQuery(name = "PlaTerritorializacion.findByPteCodigopunto", query = "SELECT p FROM PlaTerritorializacion p WHERE p.pteCodigopunto = :pteCodigopunto"),
    @NamedQuery(name = "PlaTerritorializacion.findByPteTipolocfisica", query = "SELECT p FROM PlaTerritorializacion p WHERE p.pteTipolocfisica = :pteTipolocfisica"),
    @NamedQuery(name = "PlaTerritorializacion.findByPteDirecciondesc", query = "SELECT p FROM PlaTerritorializacion p WHERE p.pteDirecciondesc = :pteDirecciondesc"),
    @NamedQuery(name = "PlaTerritorializacion.findByPteCodigometa", query = "SELECT p FROM PlaTerritorializacion p WHERE p.pteCodigometa = :pteCodigometa"),
    @NamedQuery(name = "PlaTerritorializacion.findByPteNombremeta", query = "SELECT p FROM PlaTerritorializacion p WHERE p.pteNombremeta = :pteNombremeta"),
    @NamedQuery(name = "PlaTerritorializacion.findByPteMagprogrva", query = "SELECT p FROM PlaTerritorializacion p WHERE p.pteMagprogrva = :pteMagprogrva"),
    @NamedQuery(name = "PlaTerritorializacion.findByPteMagejecrva", query = "SELECT p FROM PlaTerritorializacion p WHERE p.pteMagejecrva = :pteMagejecrva"),
    @NamedQuery(name = "PlaTerritorializacion.findByPteRecprogrva", query = "SELECT p FROM PlaTerritorializacion p WHERE p.pteRecprogrva = :pteRecprogrva"),
    @NamedQuery(name = "PlaTerritorializacion.findByPteRecejecrva", query = "SELECT p FROM PlaTerritorializacion p WHERE p.pteRecejecrva = :pteRecejecrva"),
    @NamedQuery(name = "PlaTerritorializacion.findByPteMagprogvig", query = "SELECT p FROM PlaTerritorializacion p WHERE p.pteMagprogvig = :pteMagprogvig"),
    @NamedQuery(name = "PlaTerritorializacion.findByPteMagejecvig", query = "SELECT p FROM PlaTerritorializacion p WHERE p.pteMagejecvig = :pteMagejecvig"),
    @NamedQuery(name = "PlaTerritorializacion.findByPteRecprogvig", query = "SELECT p FROM PlaTerritorializacion p WHERE p.pteRecprogvig = :pteRecprogvig"),
    @NamedQuery(name = "PlaTerritorializacion.findByPteRecejecvig", query = "SELECT p FROM PlaTerritorializacion p WHERE p.pteRecejecvig = :pteRecejecvig")})
public class PlaTerritorializacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pte_id")
    private Long pteId;
    @Size(max = 100)
    @Column(name = "pte_codigopd")
    private String pteCodigopd;
    @Size(max = 1500)
    @Column(name = "pte_nombrepd")
    private String pteNombrepd;
    @Size(max = 100)
    @Column(name = "pte_anogeo")
    private String pteAnogeo;
    @Size(max = 100)
    @Column(name = "pte_versiongeo")
    private String pteVersiongeo;
    @Size(max = 100)
    @Column(name = "pte_codigoentidad")
    private String pteCodigoentidad;
    @Size(max = 1500)
    @Column(name = "pte_nombreentidad")
    private String pteNombreentidad;
    @Size(max = 100)
    @Column(name = "pte_codigosector")
    private String pteCodigosector;
    @Size(max = 1500)
    @Column(name = "pte_nombresector")
    private String pteNombresector;
    @Size(max = 100)
    @Column(name = "pte_codigolocalizacion")
    private String pteCodigolocalizacion;
    @Size(max = 1500)
    @Column(name = "pte_nombrelocalizacion")
    private String pteNombrelocalizacion;
    @Size(max = 100)
    @Column(name = "pte_codcomponenten1")
    private String pteCodcomponenten1;
    @Size(max = 1500)
    @Column(name = "pte_nomcomponenten1")
    private String pteNomcomponenten1;
    @Size(max = 100)
    @Column(name = "pte_codcomponenten2")
    private String pteCodcomponenten2;
    @Size(max = 1500)
    @Column(name = "pte_nomcomponenten2")
    private String pteNomcomponenten2;
    @Size(max = 100)
    @Column(name = "pte_codigoproyecto")
    private String pteCodigoproyecto;
    @Size(max = 1500)
    @Column(name = "pte_nombreproyecto")
    private String pteNombreproyecto;
    @Size(max = 100)
    @Column(name = "pte_codigopunto")
    private String pteCodigopunto;
    @Size(max = 1500)
    @Column(name = "pte_tipolocfisica")
    private String pteTipolocfisica;
    @Size(max = 1500)
    @Column(name = "pte_direcciondesc")
    private String pteDirecciondesc;
    @Size(max = 100)
    @Column(name = "pte_codigometa")
    private String pteCodigometa;
    @Size(max = 1500)
    @Column(name = "pte_nombremeta")
    private String pteNombremeta;
    @Size(max = 100)
    @Column(name = "pte_magprogrva")
    private String pteMagprogrva;
    @Size(max = 100)
    @Column(name = "pte_magejecrva")
    private String pteMagejecrva;
    @Size(max = 200)
    @Column(name = "pte_recprogrva")
    private String pteRecprogrva;
    @Size(max = 200)
    @Column(name = "pte_recejecrva")
    private String pteRecejecrva;
    @Size(max = 100)
    @Column(name = "pte_magprogvig")
    private String pteMagprogvig;
    @Size(max = 100)
    @Column(name = "pte_magejecvig")
    private String pteMagejecvig;
    @Size(max = 200)
    @Column(name = "pte_recprogvig")
    private String pteRecprogvig;
    @Size(max = 200)
    @Column(name = "pte_recejecvig")
    private String pteRecejecvig;
    @JoinColumn(name = "lgreg_id", referencedColumnName = "lgreg_id")
    @ManyToOne(optional = false)
    private SysRegistrocarga lgregId;

    public PlaTerritorializacion() {
    }

    public PlaTerritorializacion(Long pteId) {
        this.pteId = pteId;
    }

    public Long getPteId() {
        return pteId;
    }

    public void setPteId(Long pteId) {
        this.pteId = pteId;
    }

    public String getPteCodigopd() {
        return pteCodigopd;
    }

    public void setPteCodigopd(String pteCodigopd) {
        this.pteCodigopd = pteCodigopd;
    }

    public String getPteNombrepd() {
        return pteNombrepd;
    }

    public void setPteNombrepd(String pteNombrepd) {
        this.pteNombrepd = pteNombrepd;
    }

    public String getPteAnogeo() {
        return pteAnogeo;
    }

    public void setPteAnogeo(String pteAnogeo) {
        this.pteAnogeo = pteAnogeo;
    }

    public String getPteVersiongeo() {
        return pteVersiongeo;
    }

    public void setPteVersiongeo(String pteVersiongeo) {
        this.pteVersiongeo = pteVersiongeo;
    }

    public String getPteCodigoentidad() {
        return pteCodigoentidad;
    }

    public void setPteCodigoentidad(String pteCodigoentidad) {
        this.pteCodigoentidad = pteCodigoentidad;
    }

    public String getPteNombreentidad() {
        return pteNombreentidad;
    }

    public void setPteNombreentidad(String pteNombreentidad) {
        this.pteNombreentidad = pteNombreentidad;
    }

    public String getPteCodigosector() {
        return pteCodigosector;
    }

    public void setPteCodigosector(String pteCodigosector) {
        this.pteCodigosector = pteCodigosector;
    }

    public String getPteNombresector() {
        return pteNombresector;
    }

    public void setPteNombresector(String pteNombresector) {
        this.pteNombresector = pteNombresector;
    }

    public String getPteCodigolocalizacion() {
        return pteCodigolocalizacion;
    }

    public void setPteCodigolocalizacion(String pteCodigolocalizacion) {
        this.pteCodigolocalizacion = pteCodigolocalizacion;
    }

    public String getPteNombrelocalizacion() {
        return pteNombrelocalizacion;
    }

    public void setPteNombrelocalizacion(String pteNombrelocalizacion) {
        this.pteNombrelocalizacion = pteNombrelocalizacion;
    }

    public String getPteCodcomponenten1() {
        return pteCodcomponenten1;
    }

    public void setPteCodcomponenten1(String pteCodcomponenten1) {
        this.pteCodcomponenten1 = pteCodcomponenten1;
    }

    public String getPteNomcomponenten1() {
        return pteNomcomponenten1;
    }

    public void setPteNomcomponenten1(String pteNomcomponenten1) {
        this.pteNomcomponenten1 = pteNomcomponenten1;
    }

    public String getPteCodcomponenten2() {
        return pteCodcomponenten2;
    }

    public void setPteCodcomponenten2(String pteCodcomponenten2) {
        this.pteCodcomponenten2 = pteCodcomponenten2;
    }

    public String getPteNomcomponenten2() {
        return pteNomcomponenten2;
    }

    public void setPteNomcomponenten2(String pteNomcomponenten2) {
        this.pteNomcomponenten2 = pteNomcomponenten2;
    }

    public String getPteCodigoproyecto() {
        return pteCodigoproyecto;
    }

    public void setPteCodigoproyecto(String pteCodigoproyecto) {
        this.pteCodigoproyecto = pteCodigoproyecto;
    }

    public String getPteNombreproyecto() {
        return pteNombreproyecto;
    }

    public void setPteNombreproyecto(String pteNombreproyecto) {
        this.pteNombreproyecto = pteNombreproyecto;
    }

    public String getPteCodigopunto() {
        return pteCodigopunto;
    }

    public void setPteCodigopunto(String pteCodigopunto) {
        this.pteCodigopunto = pteCodigopunto;
    }

    public String getPteTipolocfisica() {
        return pteTipolocfisica;
    }

    public void setPteTipolocfisica(String pteTipolocfisica) {
        this.pteTipolocfisica = pteTipolocfisica;
    }

    public String getPteDirecciondesc() {
        return pteDirecciondesc;
    }

    public void setPteDirecciondesc(String pteDirecciondesc) {
        this.pteDirecciondesc = pteDirecciondesc;
    }

    public String getPteCodigometa() {
        return pteCodigometa;
    }

    public void setPteCodigometa(String pteCodigometa) {
        this.pteCodigometa = pteCodigometa;
    }

    public String getPteNombremeta() {
        return pteNombremeta;
    }

    public void setPteNombremeta(String pteNombremeta) {
        this.pteNombremeta = pteNombremeta;
    }

    public String getPteMagprogrva() {
        return pteMagprogrva;
    }

    public void setPteMagprogrva(String pteMagprogrva) {
        this.pteMagprogrva = pteMagprogrva;
    }

    public String getPteMagejecrva() {
        return pteMagejecrva;
    }

    public void setPteMagejecrva(String pteMagejecrva) {
        this.pteMagejecrva = pteMagejecrva;
    }

    public String getPteRecprogrva() {
        return pteRecprogrva;
    }

    public void setPteRecprogrva(String pteRecprogrva) {
        this.pteRecprogrva = pteRecprogrva;
    }

    public String getPteRecejecrva() {
        return pteRecejecrva;
    }

    public void setPteRecejecrva(String pteRecejecrva) {
        this.pteRecejecrva = pteRecejecrva;
    }

    public String getPteMagprogvig() {
        return pteMagprogvig;
    }

    public void setPteMagprogvig(String pteMagprogvig) {
        this.pteMagprogvig = pteMagprogvig;
    }

    public String getPteMagejecvig() {
        return pteMagejecvig;
    }

    public void setPteMagejecvig(String pteMagejecvig) {
        this.pteMagejecvig = pteMagejecvig;
    }

    public String getPteRecprogvig() {
        return pteRecprogvig;
    }

    public void setPteRecprogvig(String pteRecprogvig) {
        this.pteRecprogvig = pteRecprogvig;
    }

    public String getPteRecejecvig() {
        return pteRecejecvig;
    }

    public void setPteRecejecvig(String pteRecejecvig) {
        this.pteRecejecvig = pteRecejecvig;
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
        hash += (pteId != null ? pteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlaTerritorializacion)) {
            return false;
        }
        PlaTerritorializacion other = (PlaTerritorializacion) object;
        if ((this.pteId == null && other.pteId != null) || (this.pteId != null && !this.pteId.equals(other.pteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.veeduria.dao.PlaTerritorializacion[ pteId=" + pteId + " ]";
    }
    
}
