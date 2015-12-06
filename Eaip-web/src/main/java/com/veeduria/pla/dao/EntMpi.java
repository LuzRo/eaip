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
@Table(name = "03_ent_mpi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EntMpi.findAll", query = "SELECT e FROM EntMpi e"),
    @NamedQuery(name = "EntMpi.findByPyId", query = "SELECT e FROM EntMpi e WHERE e.pyId = :pyId"),
    @NamedQuery(name = "EntMpi.findByPyIdRep", query = "SELECT e FROM EntMpi e WHERE e.pyIdRep = :pyIdRep"),
    @NamedQuery(name = "EntMpi.findByPyCodigoPd", query = "SELECT e FROM EntMpi e WHERE e.pyCodigoPd = :pyCodigoPd"),
    @NamedQuery(name = "EntMpi.findByPyAnoProgRepr", query = "SELECT e FROM EntMpi e WHERE e.pyAnoProgRepr = :pyAnoProgRepr"),
    @NamedQuery(name = "EntMpi.findByPyVersionPa", query = "SELECT e FROM EntMpi e WHERE e.pyVersionPa = :pyVersionPa"),
    @NamedQuery(name = "EntMpi.findByPyCodigoSector", query = "SELECT e FROM EntMpi e WHERE e.pyCodigoSector = :pyCodigoSector"),
    @NamedQuery(name = "EntMpi.findByPyCodigoEntidad", query = "SELECT e FROM EntMpi e WHERE e.pyCodigoEntidad = :pyCodigoEntidad"),
    @NamedQuery(name = "EntMpi.findByPyCodigoInternoNivel7", query = "SELECT e FROM EntMpi e WHERE e.pyCodigoInternoNivel7 = :pyCodigoInternoNivel7"),
    @NamedQuery(name = "EntMpi.findByPyCodigoProyectoPri", query = "SELECT e FROM EntMpi e WHERE e.pyCodigoProyectoPri = :pyCodigoProyectoPri"),
    @NamedQuery(name = "EntMpi.findByPyCodigoMgr", query = "SELECT e FROM EntMpi e WHERE e.pyCodigoMgr = :pyCodigoMgr"),
    @NamedQuery(name = "EntMpi.findByPyCodigoProyecto", query = "SELECT e FROM EntMpi e WHERE e.pyCodigoProyecto = :pyCodigoProyecto"),
    @NamedQuery(name = "EntMpi.findByPyN7Diferente", query = "SELECT e FROM EntMpi e WHERE e.pyN7Diferente = :pyN7Diferente"),
    @NamedQuery(name = "EntMpi.findByPyNombreProyecto", query = "SELECT e FROM EntMpi e WHERE e.pyNombreProyecto = :pyNombreProyecto"),
    @NamedQuery(name = "EntMpi.findByPyCodigoInternoMeta", query = "SELECT e FROM EntMpi e WHERE e.pyCodigoInternoMeta = :pyCodigoInternoMeta"),
    @NamedQuery(name = "EntMpi.findByPyMpiTipoSuma", query = "SELECT e FROM EntMpi e WHERE e.pyMpiTipoSuma = :pyMpiTipoSuma"),
    @NamedQuery(name = "EntMpi.findByPyDescripcionMeta", query = "SELECT e FROM EntMpi e WHERE e.pyDescripcionMeta = :pyDescripcionMeta"),
    @NamedQuery(name = "EntMpi.findByPyEstadoProgMetaDesc", query = "SELECT e FROM EntMpi e WHERE e.pyEstadoProgMetaDesc = :pyEstadoProgMetaDesc"),
    @NamedQuery(name = "EntMpi.findByPyMagProgAno1", query = "SELECT e FROM EntMpi e WHERE e.pyMagProgAno1 = :pyMagProgAno1"),
    @NamedQuery(name = "EntMpi.findByPyMagEjecAno1", query = "SELECT e FROM EntMpi e WHERE e.pyMagEjecAno1 = :pyMagEjecAno1"),
    @NamedQuery(name = "EntMpi.findByPyMagPorcAno1", query = "SELECT e FROM EntMpi e WHERE e.pyMagPorcAno1 = :pyMagPorcAno1"),
    @NamedQuery(name = "EntMpi.findByPyMagProgAno2", query = "SELECT e FROM EntMpi e WHERE e.pyMagProgAno2 = :pyMagProgAno2"),
    @NamedQuery(name = "EntMpi.findByPyMagEjecAno2", query = "SELECT e FROM EntMpi e WHERE e.pyMagEjecAno2 = :pyMagEjecAno2"),
    @NamedQuery(name = "EntMpi.findByPyMagPorcAno2", query = "SELECT e FROM EntMpi e WHERE e.pyMagPorcAno2 = :pyMagPorcAno2"),
    @NamedQuery(name = "EntMpi.findByPyMagProgAno3", query = "SELECT e FROM EntMpi e WHERE e.pyMagProgAno3 = :pyMagProgAno3"),
    @NamedQuery(name = "EntMpi.findByPyMagEjecAno3", query = "SELECT e FROM EntMpi e WHERE e.pyMagEjecAno3 = :pyMagEjecAno3"),
    @NamedQuery(name = "EntMpi.findByPyMagPorcAno3", query = "SELECT e FROM EntMpi e WHERE e.pyMagPorcAno3 = :pyMagPorcAno3"),
    @NamedQuery(name = "EntMpi.findByPyMagProgAno4", query = "SELECT e FROM EntMpi e WHERE e.pyMagProgAno4 = :pyMagProgAno4"),
    @NamedQuery(name = "EntMpi.findByPyMagEjecAno4", query = "SELECT e FROM EntMpi e WHERE e.pyMagEjecAno4 = :pyMagEjecAno4"),
    @NamedQuery(name = "EntMpi.findByPyMagPorcAno4", query = "SELECT e FROM EntMpi e WHERE e.pyMagPorcAno4 = :pyMagPorcAno4"),
    @NamedQuery(name = "EntMpi.findByPyMagProgAno5", query = "SELECT e FROM EntMpi e WHERE e.pyMagProgAno5 = :pyMagProgAno5"),
    @NamedQuery(name = "EntMpi.findByPyMagEjecAno5", query = "SELECT e FROM EntMpi e WHERE e.pyMagEjecAno5 = :pyMagEjecAno5"),
    @NamedQuery(name = "EntMpi.findByPyMagPorcAno5", query = "SELECT e FROM EntMpi e WHERE e.pyMagPorcAno5 = :pyMagPorcAno5"),
    @NamedQuery(name = "EntMpi.findByPyMagProgTot", query = "SELECT e FROM EntMpi e WHERE e.pyMagProgTot = :pyMagProgTot"),
    @NamedQuery(name = "EntMpi.findByPyMagEjecTot", query = "SELECT e FROM EntMpi e WHERE e.pyMagEjecTot = :pyMagEjecTot"),
    @NamedQuery(name = "EntMpi.findByPyMagPorcTot", query = "SELECT e FROM EntMpi e WHERE e.pyMagPorcTot = :pyMagPorcTot"),
    @NamedQuery(name = "EntMpi.findByPyRecProgAno1", query = "SELECT e FROM EntMpi e WHERE e.pyRecProgAno1 = :pyRecProgAno1"),
    @NamedQuery(name = "EntMpi.findByPyRecEjecAno1", query = "SELECT e FROM EntMpi e WHERE e.pyRecEjecAno1 = :pyRecEjecAno1"),
    @NamedQuery(name = "EntMpi.findByPyRecPorcAno1", query = "SELECT e FROM EntMpi e WHERE e.pyRecPorcAno1 = :pyRecPorcAno1"),
    @NamedQuery(name = "EntMpi.findByPyRecProgAno2", query = "SELECT e FROM EntMpi e WHERE e.pyRecProgAno2 = :pyRecProgAno2"),
    @NamedQuery(name = "EntMpi.findByPyRecEjecAno2", query = "SELECT e FROM EntMpi e WHERE e.pyRecEjecAno2 = :pyRecEjecAno2"),
    @NamedQuery(name = "EntMpi.findByPyRecPorcAno2", query = "SELECT e FROM EntMpi e WHERE e.pyRecPorcAno2 = :pyRecPorcAno2"),
    @NamedQuery(name = "EntMpi.findByPyRecProgAno3", query = "SELECT e FROM EntMpi e WHERE e.pyRecProgAno3 = :pyRecProgAno3"),
    @NamedQuery(name = "EntMpi.findByPyRecEjecAno3", query = "SELECT e FROM EntMpi e WHERE e.pyRecEjecAno3 = :pyRecEjecAno3"),
    @NamedQuery(name = "EntMpi.findByPyRecPorcAno3", query = "SELECT e FROM EntMpi e WHERE e.pyRecPorcAno3 = :pyRecPorcAno3"),
    @NamedQuery(name = "EntMpi.findByPyRecProgAno4", query = "SELECT e FROM EntMpi e WHERE e.pyRecProgAno4 = :pyRecProgAno4"),
    @NamedQuery(name = "EntMpi.findByPyRecEjecAno4", query = "SELECT e FROM EntMpi e WHERE e.pyRecEjecAno4 = :pyRecEjecAno4"),
    @NamedQuery(name = "EntMpi.findByPyRecPorcAno4", query = "SELECT e FROM EntMpi e WHERE e.pyRecPorcAno4 = :pyRecPorcAno4"),
    @NamedQuery(name = "EntMpi.findByPyRecProgAno5", query = "SELECT e FROM EntMpi e WHERE e.pyRecProgAno5 = :pyRecProgAno5"),
    @NamedQuery(name = "EntMpi.findByPyRecEjecAno5", query = "SELECT e FROM EntMpi e WHERE e.pyRecEjecAno5 = :pyRecEjecAno5"),
    @NamedQuery(name = "EntMpi.findByPyRecPorcAno5", query = "SELECT e FROM EntMpi e WHERE e.pyRecPorcAno5 = :pyRecPorcAno5"),
    @NamedQuery(name = "EntMpi.findByPyRecProgTot", query = "SELECT e FROM EntMpi e WHERE e.pyRecProgTot = :pyRecProgTot"),
    @NamedQuery(name = "EntMpi.findByPyRecEjecTot", query = "SELECT e FROM EntMpi e WHERE e.pyRecEjecTot = :pyRecEjecTot"),
    @NamedQuery(name = "EntMpi.findByPyRecPorcTot", query = "SELECT e FROM EntMpi e WHERE e.pyRecPorcTot = :pyRecPorcTot"),
    @NamedQuery(name = "EntMpi.findByArchivo", query = "SELECT e FROM EntMpi e WHERE e.archivo = :archivo"),
    @NamedQuery(name = "EntMpi.findByTrimestre", query = "SELECT e FROM EntMpi e WHERE e.trimestre = :trimestre"),
    @NamedQuery(name = "EntMpi.findByNombreEntidad", query = "SELECT e FROM EntMpi e WHERE e.nombreEntidad = :nombreEntidad"),
    @NamedQuery(name = "EntMpi.findByNombreSector", query = "SELECT e FROM EntMpi e WHERE e.nombreSector = :nombreSector"),
    @NamedQuery(name = "EntMpi.findByPyEstadoProgMeta", query = "SELECT e FROM EntMpi e WHERE e.pyEstadoProgMeta = :pyEstadoProgMeta"),
    @NamedQuery(name = "EntMpi.findByMpicargaId", query = "SELECT e FROM EntMpi e WHERE e.mpicargaId = :mpicargaId")})
public class EntMpi implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "py_id")
    private String pyId;
    @Size(max = 100)
    @Column(name = "py_id_rep")
    private String pyIdRep;
    @Column(name = "py_codigo_pd")
    private Integer pyCodigoPd;
    @Column(name = "py_ano_prog_repr")
    private Integer pyAnoProgRepr;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "py_version_pa")
    private Double pyVersionPa;
    @Column(name = "py_codigo_sector")
    private Integer pyCodigoSector;
    @Column(name = "py_codigo_entidad")
    private Integer pyCodigoEntidad;
    @Column(name = "py_codigo_interno_nivel7")
    private Integer pyCodigoInternoNivel7;
    @Column(name = "py_codigo_proyecto_pri")
    private Integer pyCodigoProyectoPri;
    @Column(name = "py_codigo_mgr")
    private Integer pyCodigoMgr;
    @Column(name = "py_codigo_proyecto")
    private Integer pyCodigoProyecto;
    @Column(name = "py_n7_diferente")
    private Integer pyN7Diferente;
    @Size(max = 1500)
    @Column(name = "py_nombre_proyecto")
    private String pyNombreProyecto;
    @Column(name = "py_codigo_interno_meta")
    private Integer pyCodigoInternoMeta;
    @Column(name = "py_mpi_tipo_suma")
    private Double pyMpiTipoSuma;
    @Size(max = 1500)
    @Column(name = "py_descripcion_meta")
    private String pyDescripcionMeta;
    @Size(max = 1500)
    @Column(name = "py_estado_prog_meta_desc")
    private String pyEstadoProgMetaDesc;
    @Column(name = "py_mag_prog_ano1")
    private Double pyMagProgAno1;
    @Column(name = "py_mag_ejec_ano1")
    private Double pyMagEjecAno1;
    @Column(name = "py_mag_porc_ano1")
    private Double pyMagPorcAno1;
    @Column(name = "py_mag_prog_ano2")
    private Double pyMagProgAno2;
    @Column(name = "py_mag_ejec_ano2")
    private Double pyMagEjecAno2;
    @Column(name = "py_mag_porc_ano2")
    private Double pyMagPorcAno2;
    @Column(name = "py_mag_prog_ano3")
    private Double pyMagProgAno3;
    @Column(name = "py_mag_ejec_ano3")
    private Double pyMagEjecAno3;
    @Column(name = "py_mag_porc_ano3")
    private Double pyMagPorcAno3;
    @Column(name = "py_mag_prog_ano4")
    private Double pyMagProgAno4;
    @Column(name = "py_mag_ejec_ano4")
    private Double pyMagEjecAno4;
    @Column(name = "py_mag_porc_ano4")
    private Double pyMagPorcAno4;
    @Column(name = "py_mag_prog_ano5")
    private Double pyMagProgAno5;
    @Column(name = "py_mag_ejec_ano5")
    private Double pyMagEjecAno5;
    @Column(name = "py_mag_porc_ano5")
    private Double pyMagPorcAno5;
    @Size(max = 1500)
    @Column(name = "py_mag_prog_tot")
    private String pyMagProgTot;
    @Size(max = 1500)
    @Column(name = "py_mag_ejec_tot")
    private String pyMagEjecTot;
    @Size(max = 1500)
    @Column(name = "py_mag_porc_tot")
    private String pyMagPorcTot;
    @Column(name = "py_rec_prog_ano1")
    private Double pyRecProgAno1;
    @Column(name = "py_rec_ejec_ano1")
    private Double pyRecEjecAno1;
    @Column(name = "py_rec_porc_ano1")
    private Double pyRecPorcAno1;
    @Column(name = "py_rec_prog_ano2")
    private Double pyRecProgAno2;
    @Column(name = "py_rec_ejec_ano2")
    private Double pyRecEjecAno2;
    @Column(name = "py_rec_porc_ano2")
    private Double pyRecPorcAno2;
    @Column(name = "py_rec_prog_ano3")
    private Double pyRecProgAno3;
    @Column(name = "py_rec_ejec_ano3")
    private Double pyRecEjecAno3;
    @Column(name = "py_rec_porc_ano3")
    private Double pyRecPorcAno3;
    @Column(name = "py_rec_prog_ano4")
    private Double pyRecProgAno4;
    @Column(name = "py_rec_ejec_ano4")
    private Double pyRecEjecAno4;
    @Column(name = "py_rec_porc_ano4")
    private Double pyRecPorcAno4;
    @Column(name = "py_rec_prog_ano5")
    private Double pyRecProgAno5;
    @Column(name = "py_rec_ejec_ano5")
    private Double pyRecEjecAno5;
    @Column(name = "py_rec_porc_ano5")
    private Double pyRecPorcAno5;
    @Column(name = "py_rec_prog_tot")
    private Double pyRecProgTot;
    @Column(name = "py_rec_ejec_tot")
    private Double pyRecEjecTot;
    @Column(name = "py_rec_porc_tot")
    private Double pyRecPorcTot;
    @Size(max = 255)
    @Column(name = "archivo")
    private String archivo;
    @Column(name = "trimestre")
    private Short trimestre;
    @Size(max = 1500)
    @Column(name = "nombre_entidad")
    private String nombreEntidad;
    @Size(max = 1500)
    @Column(name = "nombre_sector")
    private String nombreSector;
    @Column(name = "py_estado_prog_meta")
    private Integer pyEstadoProgMeta;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "mpicarga_id")
    private Long mpicargaId;

    public EntMpi() {
    }

    public EntMpi(Long mpicargaId) {
        this.mpicargaId = mpicargaId;
    }

    public String getPyId() {
        return pyId;
    }

    public void setPyId(String pyId) {
        this.pyId = pyId;
    }

    public String getPyIdRep() {
        return pyIdRep;
    }

    public void setPyIdRep(String pyIdRep) {
        this.pyIdRep = pyIdRep;
    }

    public Integer getPyCodigoPd() {
        return pyCodigoPd;
    }

    public void setPyCodigoPd(Integer pyCodigoPd) {
        this.pyCodigoPd = pyCodigoPd;
    }

    public Integer getPyAnoProgRepr() {
        return pyAnoProgRepr;
    }

    public void setPyAnoProgRepr(Integer pyAnoProgRepr) {
        this.pyAnoProgRepr = pyAnoProgRepr;
    }

    public Double getPyVersionPa() {
        return pyVersionPa;
    }

    public void setPyVersionPa(Double pyVersionPa) {
        this.pyVersionPa = pyVersionPa;
    }

    public Integer getPyCodigoSector() {
        return pyCodigoSector;
    }

    public void setPyCodigoSector(Integer pyCodigoSector) {
        this.pyCodigoSector = pyCodigoSector;
    }

    public Integer getPyCodigoEntidad() {
        return pyCodigoEntidad;
    }

    public void setPyCodigoEntidad(Integer pyCodigoEntidad) {
        this.pyCodigoEntidad = pyCodigoEntidad;
    }

    public Integer getPyCodigoInternoNivel7() {
        return pyCodigoInternoNivel7;
    }

    public void setPyCodigoInternoNivel7(Integer pyCodigoInternoNivel7) {
        this.pyCodigoInternoNivel7 = pyCodigoInternoNivel7;
    }

    public Integer getPyCodigoProyectoPri() {
        return pyCodigoProyectoPri;
    }

    public void setPyCodigoProyectoPri(Integer pyCodigoProyectoPri) {
        this.pyCodigoProyectoPri = pyCodigoProyectoPri;
    }

    public Integer getPyCodigoMgr() {
        return pyCodigoMgr;
    }

    public void setPyCodigoMgr(Integer pyCodigoMgr) {
        this.pyCodigoMgr = pyCodigoMgr;
    }

    public Integer getPyCodigoProyecto() {
        return pyCodigoProyecto;
    }

    public void setPyCodigoProyecto(Integer pyCodigoProyecto) {
        this.pyCodigoProyecto = pyCodigoProyecto;
    }

    public Integer getPyN7Diferente() {
        return pyN7Diferente;
    }

    public void setPyN7Diferente(Integer pyN7Diferente) {
        this.pyN7Diferente = pyN7Diferente;
    }

    public String getPyNombreProyecto() {
        return pyNombreProyecto;
    }

    public void setPyNombreProyecto(String pyNombreProyecto) {
        this.pyNombreProyecto = pyNombreProyecto;
    }

    public Integer getPyCodigoInternoMeta() {
        return pyCodigoInternoMeta;
    }

    public void setPyCodigoInternoMeta(Integer pyCodigoInternoMeta) {
        this.pyCodigoInternoMeta = pyCodigoInternoMeta;
    }

    public Double getPyMpiTipoSuma() {
        return pyMpiTipoSuma;
    }

    public void setPyMpiTipoSuma(Double pyMpiTipoSuma) {
        this.pyMpiTipoSuma = pyMpiTipoSuma;
    }

    public String getPyDescripcionMeta() {
        return pyDescripcionMeta;
    }

    public void setPyDescripcionMeta(String pyDescripcionMeta) {
        this.pyDescripcionMeta = pyDescripcionMeta;
    }

    public String getPyEstadoProgMetaDesc() {
        return pyEstadoProgMetaDesc;
    }

    public void setPyEstadoProgMetaDesc(String pyEstadoProgMetaDesc) {
        this.pyEstadoProgMetaDesc = pyEstadoProgMetaDesc;
    }

    public Double getPyMagProgAno1() {
        return pyMagProgAno1;
    }

    public void setPyMagProgAno1(Double pyMagProgAno1) {
        this.pyMagProgAno1 = pyMagProgAno1;
    }

    public Double getPyMagEjecAno1() {
        return pyMagEjecAno1;
    }

    public void setPyMagEjecAno1(Double pyMagEjecAno1) {
        this.pyMagEjecAno1 = pyMagEjecAno1;
    }

    public Double getPyMagPorcAno1() {
        return pyMagPorcAno1;
    }

    public void setPyMagPorcAno1(Double pyMagPorcAno1) {
        this.pyMagPorcAno1 = pyMagPorcAno1;
    }

    public Double getPyMagProgAno2() {
        return pyMagProgAno2;
    }

    public void setPyMagProgAno2(Double pyMagProgAno2) {
        this.pyMagProgAno2 = pyMagProgAno2;
    }

    public Double getPyMagEjecAno2() {
        return pyMagEjecAno2;
    }

    public void setPyMagEjecAno2(Double pyMagEjecAno2) {
        this.pyMagEjecAno2 = pyMagEjecAno2;
    }

    public Double getPyMagPorcAno2() {
        return pyMagPorcAno2;
    }

    public void setPyMagPorcAno2(Double pyMagPorcAno2) {
        this.pyMagPorcAno2 = pyMagPorcAno2;
    }

    public Double getPyMagProgAno3() {
        return pyMagProgAno3;
    }

    public void setPyMagProgAno3(Double pyMagProgAno3) {
        this.pyMagProgAno3 = pyMagProgAno3;
    }

    public Double getPyMagEjecAno3() {
        return pyMagEjecAno3;
    }

    public void setPyMagEjecAno3(Double pyMagEjecAno3) {
        this.pyMagEjecAno3 = pyMagEjecAno3;
    }

    public Double getPyMagPorcAno3() {
        return pyMagPorcAno3;
    }

    public void setPyMagPorcAno3(Double pyMagPorcAno3) {
        this.pyMagPorcAno3 = pyMagPorcAno3;
    }

    public Double getPyMagProgAno4() {
        return pyMagProgAno4;
    }

    public void setPyMagProgAno4(Double pyMagProgAno4) {
        this.pyMagProgAno4 = pyMagProgAno4;
    }

    public Double getPyMagEjecAno4() {
        return pyMagEjecAno4;
    }

    public void setPyMagEjecAno4(Double pyMagEjecAno4) {
        this.pyMagEjecAno4 = pyMagEjecAno4;
    }

    public Double getPyMagPorcAno4() {
        return pyMagPorcAno4;
    }

    public void setPyMagPorcAno4(Double pyMagPorcAno4) {
        this.pyMagPorcAno4 = pyMagPorcAno4;
    }

    public Double getPyMagProgAno5() {
        return pyMagProgAno5;
    }

    public void setPyMagProgAno5(Double pyMagProgAno5) {
        this.pyMagProgAno5 = pyMagProgAno5;
    }

    public Double getPyMagEjecAno5() {
        return pyMagEjecAno5;
    }

    public void setPyMagEjecAno5(Double pyMagEjecAno5) {
        this.pyMagEjecAno5 = pyMagEjecAno5;
    }

    public Double getPyMagPorcAno5() {
        return pyMagPorcAno5;
    }

    public void setPyMagPorcAno5(Double pyMagPorcAno5) {
        this.pyMagPorcAno5 = pyMagPorcAno5;
    }

    public String getPyMagProgTot() {
        return pyMagProgTot;
    }

    public void setPyMagProgTot(String pyMagProgTot) {
        this.pyMagProgTot = pyMagProgTot;
    }

    public String getPyMagEjecTot() {
        return pyMagEjecTot;
    }

    public void setPyMagEjecTot(String pyMagEjecTot) {
        this.pyMagEjecTot = pyMagEjecTot;
    }

    public String getPyMagPorcTot() {
        return pyMagPorcTot;
    }

    public void setPyMagPorcTot(String pyMagPorcTot) {
        this.pyMagPorcTot = pyMagPorcTot;
    }

    public Double getPyRecProgAno1() {
        return pyRecProgAno1;
    }

    public void setPyRecProgAno1(Double pyRecProgAno1) {
        this.pyRecProgAno1 = pyRecProgAno1;
    }

    public Double getPyRecEjecAno1() {
        return pyRecEjecAno1;
    }

    public void setPyRecEjecAno1(Double pyRecEjecAno1) {
        this.pyRecEjecAno1 = pyRecEjecAno1;
    }

    public Double getPyRecPorcAno1() {
        return pyRecPorcAno1;
    }

    public void setPyRecPorcAno1(Double pyRecPorcAno1) {
        this.pyRecPorcAno1 = pyRecPorcAno1;
    }

    public Double getPyRecProgAno2() {
        return pyRecProgAno2;
    }

    public void setPyRecProgAno2(Double pyRecProgAno2) {
        this.pyRecProgAno2 = pyRecProgAno2;
    }

    public Double getPyRecEjecAno2() {
        return pyRecEjecAno2;
    }

    public void setPyRecEjecAno2(Double pyRecEjecAno2) {
        this.pyRecEjecAno2 = pyRecEjecAno2;
    }

    public Double getPyRecPorcAno2() {
        return pyRecPorcAno2;
    }

    public void setPyRecPorcAno2(Double pyRecPorcAno2) {
        this.pyRecPorcAno2 = pyRecPorcAno2;
    }

    public Double getPyRecProgAno3() {
        return pyRecProgAno3;
    }

    public void setPyRecProgAno3(Double pyRecProgAno3) {
        this.pyRecProgAno3 = pyRecProgAno3;
    }

    public Double getPyRecEjecAno3() {
        return pyRecEjecAno3;
    }

    public void setPyRecEjecAno3(Double pyRecEjecAno3) {
        this.pyRecEjecAno3 = pyRecEjecAno3;
    }

    public Double getPyRecPorcAno3() {
        return pyRecPorcAno3;
    }

    public void setPyRecPorcAno3(Double pyRecPorcAno3) {
        this.pyRecPorcAno3 = pyRecPorcAno3;
    }

    public Double getPyRecProgAno4() {
        return pyRecProgAno4;
    }

    public void setPyRecProgAno4(Double pyRecProgAno4) {
        this.pyRecProgAno4 = pyRecProgAno4;
    }

    public Double getPyRecEjecAno4() {
        return pyRecEjecAno4;
    }

    public void setPyRecEjecAno4(Double pyRecEjecAno4) {
        this.pyRecEjecAno4 = pyRecEjecAno4;
    }

    public Double getPyRecPorcAno4() {
        return pyRecPorcAno4;
    }

    public void setPyRecPorcAno4(Double pyRecPorcAno4) {
        this.pyRecPorcAno4 = pyRecPorcAno4;
    }

    public Double getPyRecProgAno5() {
        return pyRecProgAno5;
    }

    public void setPyRecProgAno5(Double pyRecProgAno5) {
        this.pyRecProgAno5 = pyRecProgAno5;
    }

    public Double getPyRecEjecAno5() {
        return pyRecEjecAno5;
    }

    public void setPyRecEjecAno5(Double pyRecEjecAno5) {
        this.pyRecEjecAno5 = pyRecEjecAno5;
    }

    public Double getPyRecPorcAno5() {
        return pyRecPorcAno5;
    }

    public void setPyRecPorcAno5(Double pyRecPorcAno5) {
        this.pyRecPorcAno5 = pyRecPorcAno5;
    }

    public Double getPyRecProgTot() {
        return pyRecProgTot;
    }

    public void setPyRecProgTot(Double pyRecProgTot) {
        this.pyRecProgTot = pyRecProgTot;
    }

    public Double getPyRecEjecTot() {
        return pyRecEjecTot;
    }

    public void setPyRecEjecTot(Double pyRecEjecTot) {
        this.pyRecEjecTot = pyRecEjecTot;
    }

    public Double getPyRecPorcTot() {
        return pyRecPorcTot;
    }

    public void setPyRecPorcTot(Double pyRecPorcTot) {
        this.pyRecPorcTot = pyRecPorcTot;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public Short getTrimestre() {
        return trimestre;
    }

    public void setTrimestre(Short trimestre) {
        this.trimestre = trimestre;
    }

    public String getNombreEntidad() {
        return nombreEntidad;
    }

    public void setNombreEntidad(String nombreEntidad) {
        this.nombreEntidad = nombreEntidad;
    }

    public String getNombreSector() {
        return nombreSector;
    }

    public void setNombreSector(String nombreSector) {
        this.nombreSector = nombreSector;
    }

    public Integer getPyEstadoProgMeta() {
        return pyEstadoProgMeta;
    }

    public void setPyEstadoProgMeta(Integer pyEstadoProgMeta) {
        this.pyEstadoProgMeta = pyEstadoProgMeta;
    }

    public Long getMpicargaId() {
        return mpicargaId;
    }

    public void setMpicargaId(Long mpicargaId) {
        this.mpicargaId = mpicargaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mpicargaId != null ? mpicargaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntMpi)) {
            return false;
        }
        EntMpi other = (EntMpi) object;
        if ((this.mpicargaId == null && other.mpicargaId != null) || (this.mpicargaId != null && !this.mpicargaId.equals(other.mpicargaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.veeduria.dao.EntMpi[ mpicargaId=" + mpicargaId + " ]";
    }
    
}
