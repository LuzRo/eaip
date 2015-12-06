/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veeduria.pla.dao;

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
@Table(name = "01_entidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entidad.findAll", query = "SELECT e FROM Entidad e"),
    @NamedQuery(name = "Entidad.findByGralIdRep", query = "SELECT e FROM Entidad e WHERE e.gralIdRep = :gralIdRep"),
    @NamedQuery(name = "Entidad.findByGralId", query = "SELECT e FROM Entidad e WHERE e.gralId = :gralId"),
    @NamedQuery(name = "Entidad.findByGralCodigoPd", query = "SELECT e FROM Entidad e WHERE e.gralCodigoPd = :gralCodigoPd"),
    @NamedQuery(name = "Entidad.findByGralNombrePd", query = "SELECT e FROM Entidad e WHERE e.gralNombrePd = :gralNombrePd"),
    @NamedQuery(name = "Entidad.findByGralAnoProgRepr", query = "SELECT e FROM Entidad e WHERE e.gralAnoProgRepr = :gralAnoProgRepr"),
    @NamedQuery(name = "Entidad.findByGralFechaSeguimiento", query = "SELECT e FROM Entidad e WHERE e.gralFechaSeguimiento = :gralFechaSeguimiento"),
    @NamedQuery(name = "Entidad.findByGralRecursos", query = "SELECT e FROM Entidad e WHERE e.gralRecursos = :gralRecursos"),
    @NamedQuery(name = "Entidad.findByGralVersionPa", query = "SELECT e FROM Entidad e WHERE e.gralVersionPa = :gralVersionPa"),
    @NamedQuery(name = "Entidad.findByGralVersionPaDesc", query = "SELECT e FROM Entidad e WHERE e.gralVersionPaDesc = :gralVersionPaDesc"),
    @NamedQuery(name = "Entidad.findByGralCodigoSector", query = "SELECT e FROM Entidad e WHERE e.gralCodigoSector = :gralCodigoSector"),
    @NamedQuery(name = "Entidad.findByGralSector", query = "SELECT e FROM Entidad e WHERE e.gralSector = :gralSector"),
    @NamedQuery(name = "Entidad.findByGralCodigoEntidad", query = "SELECT e FROM Entidad e WHERE e.gralCodigoEntidad = :gralCodigoEntidad"),
    @NamedQuery(name = "Entidad.findByGralNombreEntidad", query = "SELECT e FROM Entidad e WHERE e.gralNombreEntidad = :gralNombreEntidad"),
    @NamedQuery(name = "Entidad.findByGralCodigoComponenteN1", query = "SELECT e FROM Entidad e WHERE e.gralCodigoComponenteN1 = :gralCodigoComponenteN1"),
    @NamedQuery(name = "Entidad.findByGralNombreComponenteN1", query = "SELECT e FROM Entidad e WHERE e.gralNombreComponenteN1 = :gralNombreComponenteN1"),
    @NamedQuery(name = "Entidad.findByGralCodigoComponenteN2", query = "SELECT e FROM Entidad e WHERE e.gralCodigoComponenteN2 = :gralCodigoComponenteN2"),
    @NamedQuery(name = "Entidad.findByGralNombreComponenteN2", query = "SELECT e FROM Entidad e WHERE e.gralNombreComponenteN2 = :gralNombreComponenteN2"),
    @NamedQuery(name = "Entidad.findByGralCodigoComponenteN3", query = "SELECT e FROM Entidad e WHERE e.gralCodigoComponenteN3 = :gralCodigoComponenteN3"),
    @NamedQuery(name = "Entidad.findByGralNombreComponenteN3", query = "SELECT e FROM Entidad e WHERE e.gralNombreComponenteN3 = :gralNombreComponenteN3"),
    @NamedQuery(name = "Entidad.findByGralCodigoComponenteN4", query = "SELECT e FROM Entidad e WHERE e.gralCodigoComponenteN4 = :gralCodigoComponenteN4"),
    @NamedQuery(name = "Entidad.findByGralNombreComponenteN4", query = "SELECT e FROM Entidad e WHERE e.gralNombreComponenteN4 = :gralNombreComponenteN4"),
    @NamedQuery(name = "Entidad.findByGralCodigoComponenteN5", query = "SELECT e FROM Entidad e WHERE e.gralCodigoComponenteN5 = :gralCodigoComponenteN5"),
    @NamedQuery(name = "Entidad.findByGralNombreComponenteN5", query = "SELECT e FROM Entidad e WHERE e.gralNombreComponenteN5 = :gralNombreComponenteN5"),
    @NamedQuery(name = "Entidad.findByGralCodigoComponenteN6", query = "SELECT e FROM Entidad e WHERE e.gralCodigoComponenteN6 = :gralCodigoComponenteN6"),
    @NamedQuery(name = "Entidad.findByGralNombreComponenteN6", query = "SELECT e FROM Entidad e WHERE e.gralNombreComponenteN6 = :gralNombreComponenteN6"),
    @NamedQuery(name = "Entidad.findByGralCodigoComponenteN7", query = "SELECT e FROM Entidad e WHERE e.gralCodigoComponenteN7 = :gralCodigoComponenteN7"),
    @NamedQuery(name = "Entidad.findByGralNombreComponenteN7", query = "SELECT e FROM Entidad e WHERE e.gralNombreComponenteN7 = :gralNombreComponenteN7"),
    @NamedQuery(name = "Entidad.findByGralCodigoInternoNivel7", query = "SELECT e FROM Entidad e WHERE e.gralCodigoInternoNivel7 = :gralCodigoInternoNivel7"),
    @NamedQuery(name = "Entidad.findByGralCodigoProyectoPri", query = "SELECT e FROM Entidad e WHERE e.gralCodigoProyectoPri = :gralCodigoProyectoPri"),
    @NamedQuery(name = "Entidad.findByGralDescripcionProyectoPri", query = "SELECT e FROM Entidad e WHERE e.gralDescripcionProyectoPri = :gralDescripcionProyectoPri"),
    @NamedQuery(name = "Entidad.findByGralCodigoMgr", query = "SELECT e FROM Entidad e WHERE e.gralCodigoMgr = :gralCodigoMgr"),
    @NamedQuery(name = "Entidad.findByGralDescripcionMgr", query = "SELECT e FROM Entidad e WHERE e.gralDescripcionMgr = :gralDescripcionMgr"),
    @NamedQuery(name = "Entidad.findByGralRecProgAno1", query = "SELECT e FROM Entidad e WHERE e.gralRecProgAno1 = :gralRecProgAno1"),
    @NamedQuery(name = "Entidad.findByGralRecEjecAno1", query = "SELECT e FROM Entidad e WHERE e.gralRecEjecAno1 = :gralRecEjecAno1"),
    @NamedQuery(name = "Entidad.findByGralRecPorcAno1", query = "SELECT e FROM Entidad e WHERE e.gralRecPorcAno1 = :gralRecPorcAno1"),
    @NamedQuery(name = "Entidad.findByGralRecProgAno2", query = "SELECT e FROM Entidad e WHERE e.gralRecProgAno2 = :gralRecProgAno2"),
    @NamedQuery(name = "Entidad.findByGralRecEjecAno2", query = "SELECT e FROM Entidad e WHERE e.gralRecEjecAno2 = :gralRecEjecAno2"),
    @NamedQuery(name = "Entidad.findByGralRecPorcAno2", query = "SELECT e FROM Entidad e WHERE e.gralRecPorcAno2 = :gralRecPorcAno2"),
    @NamedQuery(name = "Entidad.findByGralRecProgAno3", query = "SELECT e FROM Entidad e WHERE e.gralRecProgAno3 = :gralRecProgAno3"),
    @NamedQuery(name = "Entidad.findByGralRecEjecAno3", query = "SELECT e FROM Entidad e WHERE e.gralRecEjecAno3 = :gralRecEjecAno3"),
    @NamedQuery(name = "Entidad.findByGralRecPorcAno3", query = "SELECT e FROM Entidad e WHERE e.gralRecPorcAno3 = :gralRecPorcAno3"),
    @NamedQuery(name = "Entidad.findByGralRecProgAno4", query = "SELECT e FROM Entidad e WHERE e.gralRecProgAno4 = :gralRecProgAno4"),
    @NamedQuery(name = "Entidad.findByGralRecEjecAno4", query = "SELECT e FROM Entidad e WHERE e.gralRecEjecAno4 = :gralRecEjecAno4"),
    @NamedQuery(name = "Entidad.findByGralRecPorcAno4", query = "SELECT e FROM Entidad e WHERE e.gralRecPorcAno4 = :gralRecPorcAno4"),
    @NamedQuery(name = "Entidad.findByGralRecProgAno5", query = "SELECT e FROM Entidad e WHERE e.gralRecProgAno5 = :gralRecProgAno5"),
    @NamedQuery(name = "Entidad.findByGralRecEjecAno5", query = "SELECT e FROM Entidad e WHERE e.gralRecEjecAno5 = :gralRecEjecAno5"),
    @NamedQuery(name = "Entidad.findByGralRecPorcAno5", query = "SELECT e FROM Entidad e WHERE e.gralRecPorcAno5 = :gralRecPorcAno5"),
    @NamedQuery(name = "Entidad.findByGralRecProgTot", query = "SELECT e FROM Entidad e WHERE e.gralRecProgTot = :gralRecProgTot"),
    @NamedQuery(name = "Entidad.findByGralRecEjecTot", query = "SELECT e FROM Entidad e WHERE e.gralRecEjecTot = :gralRecEjecTot"),
    @NamedQuery(name = "Entidad.findByGralRecPorcTot", query = "SELECT e FROM Entidad e WHERE e.gralRecPorcTot = :gralRecPorcTot"),
    @NamedQuery(name = "Entidad.findByArchivo", query = "SELECT e FROM Entidad e WHERE e.archivo = :archivo"),
    @NamedQuery(name = "Entidad.findByTrimestre", query = "SELECT e FROM Entidad e WHERE e.trimestre = :trimestre"),
    @NamedQuery(name = "Entidad.findByGralAutonumerico", query = "SELECT e FROM Entidad e WHERE e.gralAutonumerico = :gralAutonumerico")})
public class Entidad implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "gral_id_rep")
    private Double gralIdRep;
    @Size(max = 1500)
    @Column(name = "gral_id")
    private String gralId;
    @Column(name = "gral_codigo_pd")
    private Double gralCodigoPd;
    @Size(max = 1500)
    @Column(name = "gral_nombre_pd")
    private String gralNombrePd;
    @Column(name = "gral_ano_prog_repr")
    private Double gralAnoProgRepr;
    @Size(max = 1500)
    @Column(name = "gral_fecha_seguimiento")
    private String gralFechaSeguimiento;
    @Size(max = 1500)
    @Column(name = "gral_recursos")
    private String gralRecursos;
    @Column(name = "gral_version_pa")
    private Double gralVersionPa;
    @Size(max = 1500)
    @Column(name = "gral_version_pa_desc")
    private String gralVersionPaDesc;
    @Column(name = "gral_codigo_sector")
    private Integer gralCodigoSector;
    @Size(max = 1500)
    @Column(name = "gral_sector")
    private String gralSector;
    @Column(name = "gral_codigo_entidad")
    private Double gralCodigoEntidad;
    @Size(max = 1500)
    @Column(name = "gral_nombre_entidad")
    private String gralNombreEntidad;
    @Column(name = "gral_codigo_componente_n1")
    private Double gralCodigoComponenteN1;
    @Size(max = 1500)
    @Column(name = "gral_nombre_componente_n1")
    private String gralNombreComponenteN1;
    @Column(name = "gral_codigo_componente_n2")
    private Double gralCodigoComponenteN2;
    @Size(max = 1500)
    @Column(name = "gral_nombre_componente_n2")
    private String gralNombreComponenteN2;
    @Column(name = "gral_codigo_componente_n3")
    private Double gralCodigoComponenteN3;
    @Size(max = 1500)
    @Column(name = "gral_nombre_componente_n3")
    private String gralNombreComponenteN3;
    @Column(name = "gral_codigo_componente_n4")
    private Double gralCodigoComponenteN4;
    @Size(max = 1500)
    @Column(name = "gral_nombre_componente_n4")
    private String gralNombreComponenteN4;
    @Column(name = "gral_codigo_componente_n5")
    private Double gralCodigoComponenteN5;
    @Size(max = 1500)
    @Column(name = "gral_nombre_componente_n5")
    private String gralNombreComponenteN5;
    @Column(name = "gral_codigo_componente_n6")
    private Double gralCodigoComponenteN6;
    @Size(max = 1500)
    @Column(name = "gral_nombre_componente_n6")
    private String gralNombreComponenteN6;
    @Column(name = "gral_codigo_componente_n7")
    private Double gralCodigoComponenteN7;
    @Size(max = 1500)
    @Column(name = "gral_nombre_componente_n7")
    private String gralNombreComponenteN7;
    @Column(name = "gral_codigo_interno_nivel7")
    private Double gralCodigoInternoNivel7;
    @Column(name = "gral_codigo_proyecto_pri")
    private Double gralCodigoProyectoPri;
    @Size(max = 1500)
    @Column(name = "gral_descripcion_proyecto_pri")
    private String gralDescripcionProyectoPri;
    @Column(name = "gral_codigo_mgr")
    private Double gralCodigoMgr;
    @Size(max = 2147483647)
    @Column(name = "gral_descripcion_mgr")
    private String gralDescripcionMgr;
    @Column(name = "gral_rec_prog_ano1")
    private Double gralRecProgAno1;
    @Column(name = "gral_rec_ejec_ano1")
    private Double gralRecEjecAno1;
    @Column(name = "gral_rec_porc_ano1")
    private Double gralRecPorcAno1;
    @Column(name = "gral_rec_prog_ano2")
    private Double gralRecProgAno2;
    @Column(name = "gral_rec_ejec_ano2")
    private Double gralRecEjecAno2;
    @Column(name = "gral_rec_porc_ano2")
    private Double gralRecPorcAno2;
    @Column(name = "gral_rec_prog_ano3")
    private Double gralRecProgAno3;
    @Column(name = "gral_rec_ejec_ano3")
    private Double gralRecEjecAno3;
    @Column(name = "gral_rec_porc_ano3")
    private Double gralRecPorcAno3;
    @Column(name = "gral_rec_prog_ano4")
    private Double gralRecProgAno4;
    @Column(name = "gral_rec_ejec_ano4")
    private Double gralRecEjecAno4;
    @Column(name = "gral_rec_porc_ano4")
    private Double gralRecPorcAno4;
    @Column(name = "gral_rec_prog_ano5")
    private Double gralRecProgAno5;
    @Column(name = "gral_rec_ejec_ano5")
    private Double gralRecEjecAno5;
    @Column(name = "gral_rec_porc_ano5")
    private Double gralRecPorcAno5;
    @Column(name = "gral_rec_prog_tot")
    private Double gralRecProgTot;
    @Column(name = "gral_rec_ejec_tot")
    private Double gralRecEjecTot;
    @Column(name = "gral_rec_porc_tot")
    private Double gralRecPorcTot;
    @Size(max = 1500)
    @Column(name = "archivo")
    private String archivo;
    @Column(name = "trimestre")
    private Double trimestre;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "gral_autonumerico")
    private Long gralAutonumerico;

    public Entidad() {
    }

    public Entidad(Long gralAutonumerico) {
        this.gralAutonumerico = gralAutonumerico;
    }

    public Double getGralIdRep() {
        return gralIdRep;
    }

    public void setGralIdRep(Double gralIdRep) {
        this.gralIdRep = gralIdRep;
    }

    public String getGralId() {
        return gralId;
    }

    public void setGralId(String gralId) {
        this.gralId = gralId;
    }

    public Double getGralCodigoPd() {
        return gralCodigoPd;
    }

    public void setGralCodigoPd(Double gralCodigoPd) {
        this.gralCodigoPd = gralCodigoPd;
    }

    public String getGralNombrePd() {
        return gralNombrePd;
    }

    public void setGralNombrePd(String gralNombrePd) {
        this.gralNombrePd = gralNombrePd;
    }

    public Double getGralAnoProgRepr() {
        return gralAnoProgRepr;
    }

    public void setGralAnoProgRepr(Double gralAnoProgRepr) {
        this.gralAnoProgRepr = gralAnoProgRepr;
    }

    public String getGralFechaSeguimiento() {
        return gralFechaSeguimiento;
    }

    public void setGralFechaSeguimiento(String gralFechaSeguimiento) {
        this.gralFechaSeguimiento = gralFechaSeguimiento;
    }

    public String getGralRecursos() {
        return gralRecursos;
    }

    public void setGralRecursos(String gralRecursos) {
        this.gralRecursos = gralRecursos;
    }

    public Double getGralVersionPa() {
        return gralVersionPa;
    }

    public void setGralVersionPa(Double gralVersionPa) {
        this.gralVersionPa = gralVersionPa;
    }

    public String getGralVersionPaDesc() {
        return gralVersionPaDesc;
    }

    public void setGralVersionPaDesc(String gralVersionPaDesc) {
        this.gralVersionPaDesc = gralVersionPaDesc;
    }

    public Integer getGralCodigoSector() {
        return gralCodigoSector;
    }

    public void setGralCodigoSector(Integer gralCodigoSector) {
        this.gralCodigoSector = gralCodigoSector;
    }

    public String getGralSector() {
        return gralSector;
    }

    public void setGralSector(String gralSector) {
        this.gralSector = gralSector;
    }

    public Double getGralCodigoEntidad() {
        return gralCodigoEntidad;
    }

    public void setGralCodigoEntidad(Double gralCodigoEntidad) {
        this.gralCodigoEntidad = gralCodigoEntidad;
    }

    public String getGralNombreEntidad() {
        return gralNombreEntidad;
    }

    public void setGralNombreEntidad(String gralNombreEntidad) {
        this.gralNombreEntidad = gralNombreEntidad;
    }

    public Double getGralCodigoComponenteN1() {
        return gralCodigoComponenteN1;
    }

    public void setGralCodigoComponenteN1(Double gralCodigoComponenteN1) {
        this.gralCodigoComponenteN1 = gralCodigoComponenteN1;
    }

    public String getGralNombreComponenteN1() {
        return gralNombreComponenteN1;
    }

    public void setGralNombreComponenteN1(String gralNombreComponenteN1) {
        this.gralNombreComponenteN1 = gralNombreComponenteN1;
    }

    public Double getGralCodigoComponenteN2() {
        return gralCodigoComponenteN2;
    }

    public void setGralCodigoComponenteN2(Double gralCodigoComponenteN2) {
        this.gralCodigoComponenteN2 = gralCodigoComponenteN2;
    }

    public String getGralNombreComponenteN2() {
        return gralNombreComponenteN2;
    }

    public void setGralNombreComponenteN2(String gralNombreComponenteN2) {
        this.gralNombreComponenteN2 = gralNombreComponenteN2;
    }

    public Double getGralCodigoComponenteN3() {
        return gralCodigoComponenteN3;
    }

    public void setGralCodigoComponenteN3(Double gralCodigoComponenteN3) {
        this.gralCodigoComponenteN3 = gralCodigoComponenteN3;
    }

    public String getGralNombreComponenteN3() {
        return gralNombreComponenteN3;
    }

    public void setGralNombreComponenteN3(String gralNombreComponenteN3) {
        this.gralNombreComponenteN3 = gralNombreComponenteN3;
    }

    public Double getGralCodigoComponenteN4() {
        return gralCodigoComponenteN4;
    }

    public void setGralCodigoComponenteN4(Double gralCodigoComponenteN4) {
        this.gralCodigoComponenteN4 = gralCodigoComponenteN4;
    }

    public String getGralNombreComponenteN4() {
        return gralNombreComponenteN4;
    }

    public void setGralNombreComponenteN4(String gralNombreComponenteN4) {
        this.gralNombreComponenteN4 = gralNombreComponenteN4;
    }

    public Double getGralCodigoComponenteN5() {
        return gralCodigoComponenteN5;
    }

    public void setGralCodigoComponenteN5(Double gralCodigoComponenteN5) {
        this.gralCodigoComponenteN5 = gralCodigoComponenteN5;
    }

    public String getGralNombreComponenteN5() {
        return gralNombreComponenteN5;
    }

    public void setGralNombreComponenteN5(String gralNombreComponenteN5) {
        this.gralNombreComponenteN5 = gralNombreComponenteN5;
    }

    public Double getGralCodigoComponenteN6() {
        return gralCodigoComponenteN6;
    }

    public void setGralCodigoComponenteN6(Double gralCodigoComponenteN6) {
        this.gralCodigoComponenteN6 = gralCodigoComponenteN6;
    }

    public String getGralNombreComponenteN6() {
        return gralNombreComponenteN6;
    }

    public void setGralNombreComponenteN6(String gralNombreComponenteN6) {
        this.gralNombreComponenteN6 = gralNombreComponenteN6;
    }

    public Double getGralCodigoComponenteN7() {
        return gralCodigoComponenteN7;
    }

    public void setGralCodigoComponenteN7(Double gralCodigoComponenteN7) {
        this.gralCodigoComponenteN7 = gralCodigoComponenteN7;
    }

    public String getGralNombreComponenteN7() {
        return gralNombreComponenteN7;
    }

    public void setGralNombreComponenteN7(String gralNombreComponenteN7) {
        this.gralNombreComponenteN7 = gralNombreComponenteN7;
    }

    public Double getGralCodigoInternoNivel7() {
        return gralCodigoInternoNivel7;
    }

    public void setGralCodigoInternoNivel7(Double gralCodigoInternoNivel7) {
        this.gralCodigoInternoNivel7 = gralCodigoInternoNivel7;
    }

    public Double getGralCodigoProyectoPri() {
        return gralCodigoProyectoPri;
    }

    public void setGralCodigoProyectoPri(Double gralCodigoProyectoPri) {
        this.gralCodigoProyectoPri = gralCodigoProyectoPri;
    }

    public String getGralDescripcionProyectoPri() {
        return gralDescripcionProyectoPri;
    }

    public void setGralDescripcionProyectoPri(String gralDescripcionProyectoPri) {
        this.gralDescripcionProyectoPri = gralDescripcionProyectoPri;
    }

    public Double getGralCodigoMgr() {
        return gralCodigoMgr;
    }

    public void setGralCodigoMgr(Double gralCodigoMgr) {
        this.gralCodigoMgr = gralCodigoMgr;
    }

    public String getGralDescripcionMgr() {
        return gralDescripcionMgr;
    }

    public void setGralDescripcionMgr(String gralDescripcionMgr) {
        this.gralDescripcionMgr = gralDescripcionMgr;
    }

    public Double getGralRecProgAno1() {
        return gralRecProgAno1;
    }

    public void setGralRecProgAno1(Double gralRecProgAno1) {
        this.gralRecProgAno1 = gralRecProgAno1;
    }

    public Double getGralRecEjecAno1() {
        return gralRecEjecAno1;
    }

    public void setGralRecEjecAno1(Double gralRecEjecAno1) {
        this.gralRecEjecAno1 = gralRecEjecAno1;
    }

    public Double getGralRecPorcAno1() {
        return gralRecPorcAno1;
    }

    public void setGralRecPorcAno1(Double gralRecPorcAno1) {
        this.gralRecPorcAno1 = gralRecPorcAno1;
    }

    public Double getGralRecProgAno2() {
        return gralRecProgAno2;
    }

    public void setGralRecProgAno2(Double gralRecProgAno2) {
        this.gralRecProgAno2 = gralRecProgAno2;
    }

    public Double getGralRecEjecAno2() {
        return gralRecEjecAno2;
    }

    public void setGralRecEjecAno2(Double gralRecEjecAno2) {
        this.gralRecEjecAno2 = gralRecEjecAno2;
    }

    public Double getGralRecPorcAno2() {
        return gralRecPorcAno2;
    }

    public void setGralRecPorcAno2(Double gralRecPorcAno2) {
        this.gralRecPorcAno2 = gralRecPorcAno2;
    }

    public Double getGralRecProgAno3() {
        return gralRecProgAno3;
    }

    public void setGralRecProgAno3(Double gralRecProgAno3) {
        this.gralRecProgAno3 = gralRecProgAno3;
    }

    public Double getGralRecEjecAno3() {
        return gralRecEjecAno3;
    }

    public void setGralRecEjecAno3(Double gralRecEjecAno3) {
        this.gralRecEjecAno3 = gralRecEjecAno3;
    }

    public Double getGralRecPorcAno3() {
        return gralRecPorcAno3;
    }

    public void setGralRecPorcAno3(Double gralRecPorcAno3) {
        this.gralRecPorcAno3 = gralRecPorcAno3;
    }

    public Double getGralRecProgAno4() {
        return gralRecProgAno4;
    }

    public void setGralRecProgAno4(Double gralRecProgAno4) {
        this.gralRecProgAno4 = gralRecProgAno4;
    }

    public Double getGralRecEjecAno4() {
        return gralRecEjecAno4;
    }

    public void setGralRecEjecAno4(Double gralRecEjecAno4) {
        this.gralRecEjecAno4 = gralRecEjecAno4;
    }

    public Double getGralRecPorcAno4() {
        return gralRecPorcAno4;
    }

    public void setGralRecPorcAno4(Double gralRecPorcAno4) {
        this.gralRecPorcAno4 = gralRecPorcAno4;
    }

    public Double getGralRecProgAno5() {
        return gralRecProgAno5;
    }

    public void setGralRecProgAno5(Double gralRecProgAno5) {
        this.gralRecProgAno5 = gralRecProgAno5;
    }

    public Double getGralRecEjecAno5() {
        return gralRecEjecAno5;
    }

    public void setGralRecEjecAno5(Double gralRecEjecAno5) {
        this.gralRecEjecAno5 = gralRecEjecAno5;
    }

    public Double getGralRecPorcAno5() {
        return gralRecPorcAno5;
    }

    public void setGralRecPorcAno5(Double gralRecPorcAno5) {
        this.gralRecPorcAno5 = gralRecPorcAno5;
    }

    public Double getGralRecProgTot() {
        return gralRecProgTot;
    }

    public void setGralRecProgTot(Double gralRecProgTot) {
        this.gralRecProgTot = gralRecProgTot;
    }

    public Double getGralRecEjecTot() {
        return gralRecEjecTot;
    }

    public void setGralRecEjecTot(Double gralRecEjecTot) {
        this.gralRecEjecTot = gralRecEjecTot;
    }

    public Double getGralRecPorcTot() {
        return gralRecPorcTot;
    }

    public void setGralRecPorcTot(Double gralRecPorcTot) {
        this.gralRecPorcTot = gralRecPorcTot;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public Double getTrimestre() {
        return trimestre;
    }

    public void setTrimestre(Double trimestre) {
        this.trimestre = trimestre;
    }

    public Long getGralAutonumerico() {
        return gralAutonumerico;
    }

    public void setGralAutonumerico(Long gralAutonumerico) {
        this.gralAutonumerico = gralAutonumerico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gralAutonumerico != null ? gralAutonumerico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entidad)) {
            return false;
        }
        Entidad other = (Entidad) object;
        if ((this.gralAutonumerico == null && other.gralAutonumerico != null) || (this.gralAutonumerico != null && !this.gralAutonumerico.equals(other.gralAutonumerico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.veeduria.dao.Entidad[ gralAutonumerico=" + gralAutonumerico + " ]";
    }
    
}
