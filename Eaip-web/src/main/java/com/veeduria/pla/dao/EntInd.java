/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veeduria.pla.dao;

import java.io.Serializable;
import java.math.BigDecimal;
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
 * @author con1ead
 */
@Entity
@Table(name = "02_ent_ind")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EntInd.findAll", query = "SELECT e FROM EntInd e"),
    @NamedQuery(name = "EntInd.findByIndId", query = "SELECT e FROM EntInd e WHERE e.indId = :indId"),
    @NamedQuery(name = "EntInd.findByIndIdRep", query = "SELECT e FROM EntInd e WHERE e.indIdRep = :indIdRep"),
    @NamedQuery(name = "EntInd.findByIndCodigoPd", query = "SELECT e FROM EntInd e WHERE e.indCodigoPd = :indCodigoPd"),
    @NamedQuery(name = "EntInd.findByIndAnoProgRepr", query = "SELECT e FROM EntInd e WHERE e.indAnoProgRepr = :indAnoProgRepr"),
    @NamedQuery(name = "EntInd.findByIndVersionPa", query = "SELECT e FROM EntInd e WHERE e.indVersionPa = :indVersionPa"),
    @NamedQuery(name = "EntInd.findByIndCodigoSector", query = "SELECT e FROM EntInd e WHERE e.indCodigoSector = :indCodigoSector"),
    @NamedQuery(name = "EntInd.findByIndCodigoEntidad", query = "SELECT e FROM EntInd e WHERE e.indCodigoEntidad = :indCodigoEntidad"),
    @NamedQuery(name = "EntInd.findByIndCodigoInternoNivel7", query = "SELECT e FROM EntInd e WHERE e.indCodigoInternoNivel7 = :indCodigoInternoNivel7"),
    @NamedQuery(name = "EntInd.findByIndCodigoProyectoPri", query = "SELECT e FROM EntInd e WHERE e.indCodigoProyectoPri = :indCodigoProyectoPri"),
    @NamedQuery(name = "EntInd.findByIndCodigoMgr", query = "SELECT e FROM EntInd e WHERE e.indCodigoMgr = :indCodigoMgr"),
    @NamedQuery(name = "EntInd.findByIndCodigoIndicador", query = "SELECT e FROM EntInd e WHERE e.indCodigoIndicador = :indCodigoIndicador"),
    @NamedQuery(name = "EntInd.findByIndNombreIndicador", query = "SELECT e FROM EntInd e WHERE e.indNombreIndicador = :indNombreIndicador"),
    @NamedQuery(name = "EntInd.findByIndIndicadorTipoSuma", query = "SELECT e FROM EntInd e WHERE e.indIndicadorTipoSuma = :indIndicadorTipoSuma"),
    @NamedQuery(name = "EntInd.findByIndEstadoEnPa", query = "SELECT e FROM EntInd e WHERE e.indEstadoEnPa = :indEstadoEnPa"),
    @NamedQuery(name = "EntInd.findByIndDescEstadoIndPa", query = "SELECT e FROM EntInd e WHERE e.indDescEstadoIndPa = :indDescEstadoIndPa"),
    @NamedQuery(name = "EntInd.findByIndAno", query = "SELECT e FROM EntInd e WHERE e.indAno = :indAno"),
    @NamedQuery(name = "EntInd.findByIndProgInicialPd", query = "SELECT e FROM EntInd e WHERE e.indProgInicialPd = :indProgInicialPd"),
    @NamedQuery(name = "EntInd.findByIndProgActual", query = "SELECT e FROM EntInd e WHERE e.indProgActual = :indProgActual"),
    @NamedQuery(name = "EntInd.findByIndEjecucionVigencia", query = "SELECT e FROM EntInd e WHERE e.indEjecucionVigencia = :indEjecucionVigencia"),
    @NamedQuery(name = "EntInd.findByIndporcavVig", query = "SELECT e FROM EntInd e WHERE e.indporcavVig = :indporcavVig"),
    @NamedQuery(name = "EntInd.findByIndporcavTraPD", query = "SELECT e FROM EntInd e WHERE e.indporcavTraPD = :indporcavTraPD"),
    @NamedQuery(name = "EntInd.findByIndporcavPD", query = "SELECT e FROM EntInd e WHERE e.indporcavPD = :indporcavPD"),
    @NamedQuery(name = "EntInd.findByArchivo", query = "SELECT e FROM EntInd e WHERE e.archivo = :archivo"),
    @NamedQuery(name = "EntInd.findByTrimestre", query = "SELECT e FROM EntInd e WHERE e.trimestre = :trimestre"),
    @NamedQuery(name = "EntInd.findByIndAutonumerico", query = "SELECT e FROM EntInd e WHERE e.indAutonumerico = :indAutonumerico"),
    @NamedQuery(name = "EntInd.findByAnProgIncialPd", query = "SELECT e FROM EntInd e WHERE e.anProgIncialPd = :anProgIncialPd"),
    @NamedQuery(name = "EntInd.findByAnProgActual", query = "SELECT e FROM EntInd e WHERE e.anProgActual = :anProgActual"),
    @NamedQuery(name = "EntInd.findByAnEjecucionVigencia", query = "SELECT e FROM EntInd e WHERE e.anEjecucionVigencia = :anEjecucionVigencia"),
    @NamedQuery(name = "EntInd.findByAnindporcavVig", query = "SELECT e FROM EntInd e WHERE e.anindporcavVig = :anindporcavVig"),
    @NamedQuery(name = "EntInd.findByAnindporcavPD", query = "SELECT e FROM EntInd e WHERE e.anindporcavPD = :anindporcavPD")})
public class EntInd implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "ind_id")
    private String indId;
    @Size(max = 150)
    @Column(name = "ind_id_rep")
    private String indIdRep;
    @Column(name = "ind_codigo_pd")
    private Integer indCodigoPd;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ind_ano_prog_repr")
    private Double indAnoProgRepr;
    @Column(name = "ind_version_pa")
    private Double indVersionPa;
    @Column(name = "ind_codigo_sector")
    private Integer indCodigoSector;
    @Column(name = "ind_codigo_entidad")
    private Integer indCodigoEntidad;
    @Column(name = "ind_codigo_interno_nivel7")
    private Integer indCodigoInternoNivel7;
    @Column(name = "ind_codigo_proyecto_pri")
    private Integer indCodigoProyectoPri;
    @Column(name = "ind_codigo_mgr")
    private Double indCodigoMgr;
    @Column(name = "ind_codigo_indicador")
    private Integer indCodigoIndicador;
    @Size(max = 1500)
    @Column(name = "ind_nombre_indicador")
    private String indNombreIndicador;
    @Size(max = 30)
    @Column(name = "ind_indicador_tipo_suma")
    private String indIndicadorTipoSuma;
    @Column(name = "ind_estado_en_pa")
    private Double indEstadoEnPa;
    @Size(max = 1500)
    @Column(name = "ind_desc_estado_ind_pa")
    private String indDescEstadoIndPa;
    @Column(name = "ind_ano")
    private Double indAno;
    @Column(name = "ind_prog_inicial_pd")
    private BigDecimal indProgInicialPd;
    @Column(name = "ind_prog_actual")
    private BigDecimal indProgActual;
    @Column(name = "ind_ejecucion_vigencia")
    private BigDecimal indEjecucionVigencia;
    @Column(name = "ind_porc_av_Vig")
    private Double indporcavVig;
    @Column(name = "ind_porc_av_TraPD")
    private Double indporcavTraPD;
    @Column(name = "ind_porc_av_PD")
    private BigDecimal indporcavPD;
    @Size(max = 255)
    @Column(name = "archivo")
    private String archivo;
    @Column(name = "trimestre")
    private Double trimestre;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ind_autonumerico")
    private Long indAutonumerico;
    @Column(name = "an_prog_incial_pd")
    private BigDecimal anProgIncialPd;
    @Column(name = "an_prog_actual")
    private BigDecimal anProgActual;
    @Column(name = "an_ejecucion_vigencia")
    private BigDecimal anEjecucionVigencia;
    @Column(name = "an_ind_porc_av_Vig")
    private BigDecimal anindporcavVig;
    @Column(name = "an_ind_porc_av_PD")
    private BigDecimal anindporcavPD;

    public EntInd() {
    }

    public EntInd(Long indAutonumerico) {
        this.indAutonumerico = indAutonumerico;
    }

    public String getIndId() {
        return indId;
    }

    public void setIndId(String indId) {
        this.indId = indId;
    }

    public String getIndIdRep() {
        return indIdRep;
    }

    public void setIndIdRep(String indIdRep) {
        this.indIdRep = indIdRep;
    }

    public Integer getIndCodigoPd() {
        return indCodigoPd;
    }

    public void setIndCodigoPd(Integer indCodigoPd) {
        this.indCodigoPd = indCodigoPd;
    }

    public Double getIndAnoProgRepr() {
        return indAnoProgRepr;
    }

    public void setIndAnoProgRepr(Double indAnoProgRepr) {
        this.indAnoProgRepr = indAnoProgRepr;
    }

    public Double getIndVersionPa() {
        return indVersionPa;
    }

    public void setIndVersionPa(Double indVersionPa) {
        this.indVersionPa = indVersionPa;
    }

    public Integer getIndCodigoSector() {
        return indCodigoSector;
    }

    public void setIndCodigoSector(Integer indCodigoSector) {
        this.indCodigoSector = indCodigoSector;
    }

    public Integer getIndCodigoEntidad() {
        return indCodigoEntidad;
    }

    public void setIndCodigoEntidad(Integer indCodigoEntidad) {
        this.indCodigoEntidad = indCodigoEntidad;
    }

    public Integer getIndCodigoInternoNivel7() {
        return indCodigoInternoNivel7;
    }

    public void setIndCodigoInternoNivel7(Integer indCodigoInternoNivel7) {
        this.indCodigoInternoNivel7 = indCodigoInternoNivel7;
    }

    public Integer getIndCodigoProyectoPri() {
        return indCodigoProyectoPri;
    }

    public void setIndCodigoProyectoPri(Integer indCodigoProyectoPri) {
        this.indCodigoProyectoPri = indCodigoProyectoPri;
    }

    public Double getIndCodigoMgr() {
        return indCodigoMgr;
    }

    public void setIndCodigoMgr(Double indCodigoMgr) {
        this.indCodigoMgr = indCodigoMgr;
    }

    public Integer getIndCodigoIndicador() {
        return indCodigoIndicador;
    }

    public void setIndCodigoIndicador(Integer indCodigoIndicador) {
        this.indCodigoIndicador = indCodigoIndicador;
    }

    public String getIndNombreIndicador() {
        return indNombreIndicador;
    }

    public void setIndNombreIndicador(String indNombreIndicador) {
        this.indNombreIndicador = indNombreIndicador;
    }

    public String getIndIndicadorTipoSuma() {
        return indIndicadorTipoSuma;
    }

    public void setIndIndicadorTipoSuma(String indIndicadorTipoSuma) {
        this.indIndicadorTipoSuma = indIndicadorTipoSuma;
    }

    public Double getIndEstadoEnPa() {
        return indEstadoEnPa;
    }

    public void setIndEstadoEnPa(Double indEstadoEnPa) {
        this.indEstadoEnPa = indEstadoEnPa;
    }

    public String getIndDescEstadoIndPa() {
        return indDescEstadoIndPa;
    }

    public void setIndDescEstadoIndPa(String indDescEstadoIndPa) {
        this.indDescEstadoIndPa = indDescEstadoIndPa;
    }

    public Double getIndAno() {
        return indAno;
    }

    public void setIndAno(Double indAno) {
        this.indAno = indAno;
    }

    public BigDecimal getIndProgInicialPd() {
        return indProgInicialPd;
    }

    public void setIndProgInicialPd(BigDecimal indProgInicialPd) {
        this.indProgInicialPd = indProgInicialPd;
    }

    public BigDecimal getIndProgActual() {
        return indProgActual;
    }

    public void setIndProgActual(BigDecimal indProgActual) {
        this.indProgActual = indProgActual;
    }

    public BigDecimal getIndEjecucionVigencia() {
        return indEjecucionVigencia;
    }

    public void setIndEjecucionVigencia(BigDecimal indEjecucionVigencia) {
        this.indEjecucionVigencia = indEjecucionVigencia;
    }

    public Double getIndporcavVig() {
        return indporcavVig;
    }

    public void setIndporcavVig(Double indporcavVig) {
        this.indporcavVig = indporcavVig;
    }

    public Double getIndporcavTraPD() {
        return indporcavTraPD;
    }

    public void setIndporcavTraPD(Double indporcavTraPD) {
        this.indporcavTraPD = indporcavTraPD;
    }

    public BigDecimal getIndporcavPD() {
        return indporcavPD;
    }

    public void setIndporcavPD(BigDecimal indporcavPD) {
        this.indporcavPD = indporcavPD;
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

    public Long getIndAutonumerico() {
        return indAutonumerico;
    }

    public void setIndAutonumerico(Long indAutonumerico) {
        this.indAutonumerico = indAutonumerico;
    }

    public BigDecimal getAnProgIncialPd() {
        return anProgIncialPd;
    }

    public void setAnProgIncialPd(BigDecimal anProgIncialPd) {
        this.anProgIncialPd = anProgIncialPd;
    }

    public BigDecimal getAnProgActual() {
        return anProgActual;
    }

    public void setAnProgActual(BigDecimal anProgActual) {
        this.anProgActual = anProgActual;
    }

    public BigDecimal getAnEjecucionVigencia() {
        return anEjecucionVigencia;
    }

    public void setAnEjecucionVigencia(BigDecimal anEjecucionVigencia) {
        this.anEjecucionVigencia = anEjecucionVigencia;
    }

    public BigDecimal getAnindporcavVig() {
        return anindporcavVig;
    }

    public void setAnindporcavVig(BigDecimal anindporcavVig) {
        this.anindporcavVig = anindporcavVig;
    }

    public BigDecimal getAnindporcavPD() {
        return anindporcavPD;
    }

    public void setAnindporcavPD(BigDecimal anindporcavPD) {
        this.anindporcavPD = anindporcavPD;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (indAutonumerico != null ? indAutonumerico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntInd)) {
            return false;
        }
        EntInd other = (EntInd) object;
        if ((this.indAutonumerico == null && other.indAutonumerico != null) || (this.indAutonumerico != null && !this.indAutonumerico.equals(other.indAutonumerico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.veeduria.dao.EntInd[ indAutonumerico=" + indAutonumerico + " ]";
    }
    
}
