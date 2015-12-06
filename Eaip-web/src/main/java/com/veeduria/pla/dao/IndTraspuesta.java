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
 * @author luz
 */
@Entity
@Table(name = "02_ind_traspuesta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IndTraspuesta.findAll", query = "SELECT i FROM IndTraspuesta i"),
    @NamedQuery(name = "IndTraspuesta.findByIndIdRep", query = "SELECT i FROM IndTraspuesta i WHERE i.indIdRep = :indIdRep"),
    @NamedQuery(name = "IndTraspuesta.findByIndCodigoPd", query = "SELECT i FROM IndTraspuesta i WHERE i.indCodigoPd = :indCodigoPd"),
    @NamedQuery(name = "IndTraspuesta.findByIndAnoProgRepr", query = "SELECT i FROM IndTraspuesta i WHERE i.indAnoProgRepr = :indAnoProgRepr"),
    @NamedQuery(name = "IndTraspuesta.findByIndVersionPa", query = "SELECT i FROM IndTraspuesta i WHERE i.indVersionPa = :indVersionPa"),
    @NamedQuery(name = "IndTraspuesta.findByIndCodigoSector", query = "SELECT i FROM IndTraspuesta i WHERE i.indCodigoSector = :indCodigoSector"),
    @NamedQuery(name = "IndTraspuesta.findByIndCodigoEntidad", query = "SELECT i FROM IndTraspuesta i WHERE i.indCodigoEntidad = :indCodigoEntidad"),
    @NamedQuery(name = "IndTraspuesta.findByIndCodigoInternoNivel7", query = "SELECT i FROM IndTraspuesta i WHERE i.indCodigoInternoNivel7 = :indCodigoInternoNivel7"),
    @NamedQuery(name = "IndTraspuesta.findByIndCodigoProyectoPri", query = "SELECT i FROM IndTraspuesta i WHERE i.indCodigoProyectoPri = :indCodigoProyectoPri"),
    @NamedQuery(name = "IndTraspuesta.findByIndCodigoMgr", query = "SELECT i FROM IndTraspuesta i WHERE i.indCodigoMgr = :indCodigoMgr"),
    @NamedQuery(name = "IndTraspuesta.findByIndCodigoIndicador", query = "SELECT i FROM IndTraspuesta i WHERE i.indCodigoIndicador = :indCodigoIndicador"),
    @NamedQuery(name = "IndTraspuesta.findByIndNombreIndicador", query = "SELECT i FROM IndTraspuesta i WHERE i.indNombreIndicador = :indNombreIndicador"),
    @NamedQuery(name = "IndTraspuesta.findByIndIndicadorTipoSuma", query = "SELECT i FROM IndTraspuesta i WHERE i.indIndicadorTipoSuma = :indIndicadorTipoSuma"),
    @NamedQuery(name = "IndTraspuesta.findByIndEstadoEnPa", query = "SELECT i FROM IndTraspuesta i WHERE i.indEstadoEnPa = :indEstadoEnPa"),
    @NamedQuery(name = "IndTraspuesta.findByIndDescEstadoIndPa", query = "SELECT i FROM IndTraspuesta i WHERE i.indDescEstadoIndPa = :indDescEstadoIndPa"),
    @NamedQuery(name = "IndTraspuesta.findByArchivo", query = "SELECT i FROM IndTraspuesta i WHERE i.archivo = :archivo"),
    @NamedQuery(name = "IndTraspuesta.findByTrimestre", query = "SELECT i FROM IndTraspuesta i WHERE i.trimestre = :trimestre"),
    @NamedQuery(name = "IndTraspuesta.findByIndProgInicialPd2012", query = "SELECT i FROM IndTraspuesta i WHERE i.indProgInicialPd2012 = :indProgInicialPd2012"),
    @NamedQuery(name = "IndTraspuesta.findByIndProgInicialPd2013", query = "SELECT i FROM IndTraspuesta i WHERE i.indProgInicialPd2013 = :indProgInicialPd2013"),
    @NamedQuery(name = "IndTraspuesta.findByIndProgInicialPd2014", query = "SELECT i FROM IndTraspuesta i WHERE i.indProgInicialPd2014 = :indProgInicialPd2014"),
    @NamedQuery(name = "IndTraspuesta.findByIndProgInicialPd2015", query = "SELECT i FROM IndTraspuesta i WHERE i.indProgInicialPd2015 = :indProgInicialPd2015"),
    @NamedQuery(name = "IndTraspuesta.findByIndProgInicialPd2016", query = "SELECT i FROM IndTraspuesta i WHERE i.indProgInicialPd2016 = :indProgInicialPd2016"),
    @NamedQuery(name = "IndTraspuesta.findByIndProgActual2012", query = "SELECT i FROM IndTraspuesta i WHERE i.indProgActual2012 = :indProgActual2012"),
    @NamedQuery(name = "IndTraspuesta.findByIndProgActual2013", query = "SELECT i FROM IndTraspuesta i WHERE i.indProgActual2013 = :indProgActual2013"),
    @NamedQuery(name = "IndTraspuesta.findByIndProgActual2014", query = "SELECT i FROM IndTraspuesta i WHERE i.indProgActual2014 = :indProgActual2014"),
    @NamedQuery(name = "IndTraspuesta.findByIndProgActual2015", query = "SELECT i FROM IndTraspuesta i WHERE i.indProgActual2015 = :indProgActual2015"),
    @NamedQuery(name = "IndTraspuesta.findByIndProgActual2016", query = "SELECT i FROM IndTraspuesta i WHERE i.indProgActual2016 = :indProgActual2016"),
    @NamedQuery(name = "IndTraspuesta.findByIndEjecucionVigencia2012", query = "SELECT i FROM IndTraspuesta i WHERE i.indEjecucionVigencia2012 = :indEjecucionVigencia2012"),
    @NamedQuery(name = "IndTraspuesta.findByIndEjecucionVigencia2013", query = "SELECT i FROM IndTraspuesta i WHERE i.indEjecucionVigencia2013 = :indEjecucionVigencia2013"),
    @NamedQuery(name = "IndTraspuesta.findByIndEjecucionVigencia2014", query = "SELECT i FROM IndTraspuesta i WHERE i.indEjecucionVigencia2014 = :indEjecucionVigencia2014"),
    @NamedQuery(name = "IndTraspuesta.findByIndEjecucionVigencia2015", query = "SELECT i FROM IndTraspuesta i WHERE i.indEjecucionVigencia2015 = :indEjecucionVigencia2015"),
    @NamedQuery(name = "IndTraspuesta.findByIndEjecucionVigencia2016", query = "SELECT i FROM IndTraspuesta i WHERE i.indEjecucionVigencia2016 = :indEjecucionVigencia2016"),
    @NamedQuery(name = "IndTraspuesta.findByIndporcavVig2012", query = "SELECT i FROM IndTraspuesta i WHERE i.indporcavVig2012 = :indporcavVig2012"),
    @NamedQuery(name = "IndTraspuesta.findByIndporcavVig2013", query = "SELECT i FROM IndTraspuesta i WHERE i.indporcavVig2013 = :indporcavVig2013"),
    @NamedQuery(name = "IndTraspuesta.findByIndporcavVig2014", query = "SELECT i FROM IndTraspuesta i WHERE i.indporcavVig2014 = :indporcavVig2014"),
    @NamedQuery(name = "IndTraspuesta.findByIndporcavVig2015", query = "SELECT i FROM IndTraspuesta i WHERE i.indporcavVig2015 = :indporcavVig2015"),
    @NamedQuery(name = "IndTraspuesta.findByIndporcavVig2016", query = "SELECT i FROM IndTraspuesta i WHERE i.indporcavVig2016 = :indporcavVig2016"),
    @NamedQuery(name = "IndTraspuesta.findByIndporcavTraPD2012", query = "SELECT i FROM IndTraspuesta i WHERE i.indporcavTraPD2012 = :indporcavTraPD2012"),
    @NamedQuery(name = "IndTraspuesta.findByIndporcavTraPD2013", query = "SELECT i FROM IndTraspuesta i WHERE i.indporcavTraPD2013 = :indporcavTraPD2013"),
    @NamedQuery(name = "IndTraspuesta.findByIndporcavTraPD2014", query = "SELECT i FROM IndTraspuesta i WHERE i.indporcavTraPD2014 = :indporcavTraPD2014"),
    @NamedQuery(name = "IndTraspuesta.findByIndporcavTraPD2015", query = "SELECT i FROM IndTraspuesta i WHERE i.indporcavTraPD2015 = :indporcavTraPD2015"),
    @NamedQuery(name = "IndTraspuesta.findByIndporcavTraPD2016", query = "SELECT i FROM IndTraspuesta i WHERE i.indporcavTraPD2016 = :indporcavTraPD2016"),
    @NamedQuery(name = "IndTraspuesta.findByIndporcavPD2012", query = "SELECT i FROM IndTraspuesta i WHERE i.indporcavPD2012 = :indporcavPD2012"),
    @NamedQuery(name = "IndTraspuesta.findByIndporcavPD2013", query = "SELECT i FROM IndTraspuesta i WHERE i.indporcavPD2013 = :indporcavPD2013"),
    @NamedQuery(name = "IndTraspuesta.findByIndporcavPD2014", query = "SELECT i FROM IndTraspuesta i WHERE i.indporcavPD2014 = :indporcavPD2014"),
    @NamedQuery(name = "IndTraspuesta.findByIndporcavPD2015", query = "SELECT i FROM IndTraspuesta i WHERE i.indporcavPD2015 = :indporcavPD2015"),
    @NamedQuery(name = "IndTraspuesta.findByIndporcavPD2016", query = "SELECT i FROM IndTraspuesta i WHERE i.indporcavPD2016 = :indporcavPD2016"),
    @NamedQuery(name = "IndTraspuesta.findByAnIndProgInicialPd2012", query = "SELECT i FROM IndTraspuesta i WHERE i.anIndProgInicialPd2012 = :anIndProgInicialPd2012"),
    @NamedQuery(name = "IndTraspuesta.findByAnIndProgInicialPd2013", query = "SELECT i FROM IndTraspuesta i WHERE i.anIndProgInicialPd2013 = :anIndProgInicialPd2013"),
    @NamedQuery(name = "IndTraspuesta.findByAnIndProgInicialPd2014", query = "SELECT i FROM IndTraspuesta i WHERE i.anIndProgInicialPd2014 = :anIndProgInicialPd2014"),
    @NamedQuery(name = "IndTraspuesta.findByAnIndProgInicialPd2015", query = "SELECT i FROM IndTraspuesta i WHERE i.anIndProgInicialPd2015 = :anIndProgInicialPd2015"),
    @NamedQuery(name = "IndTraspuesta.findByAnIndProgInicialPd2016", query = "SELECT i FROM IndTraspuesta i WHERE i.anIndProgInicialPd2016 = :anIndProgInicialPd2016"),
    @NamedQuery(name = "IndTraspuesta.findByAnIndProgActual2012", query = "SELECT i FROM IndTraspuesta i WHERE i.anIndProgActual2012 = :anIndProgActual2012"),
    @NamedQuery(name = "IndTraspuesta.findByAnIndProgActual2013", query = "SELECT i FROM IndTraspuesta i WHERE i.anIndProgActual2013 = :anIndProgActual2013"),
    @NamedQuery(name = "IndTraspuesta.findByAnIndProgActual2014", query = "SELECT i FROM IndTraspuesta i WHERE i.anIndProgActual2014 = :anIndProgActual2014"),
    @NamedQuery(name = "IndTraspuesta.findByAnIndProgActual2015", query = "SELECT i FROM IndTraspuesta i WHERE i.anIndProgActual2015 = :anIndProgActual2015"),
    @NamedQuery(name = "IndTraspuesta.findByAnIndProgActual2016", query = "SELECT i FROM IndTraspuesta i WHERE i.anIndProgActual2016 = :anIndProgActual2016"),
    @NamedQuery(name = "IndTraspuesta.findByAnIndEjecucionVigencia2012", query = "SELECT i FROM IndTraspuesta i WHERE i.anIndEjecucionVigencia2012 = :anIndEjecucionVigencia2012"),
    @NamedQuery(name = "IndTraspuesta.findByAnIndEjecucionVigencia2013", query = "SELECT i FROM IndTraspuesta i WHERE i.anIndEjecucionVigencia2013 = :anIndEjecucionVigencia2013"),
    @NamedQuery(name = "IndTraspuesta.findByAnIndEjecucionVigencia2014", query = "SELECT i FROM IndTraspuesta i WHERE i.anIndEjecucionVigencia2014 = :anIndEjecucionVigencia2014"),
    @NamedQuery(name = "IndTraspuesta.findByAnIndEjecucionVigencia2015", query = "SELECT i FROM IndTraspuesta i WHERE i.anIndEjecucionVigencia2015 = :anIndEjecucionVigencia2015"),
    @NamedQuery(name = "IndTraspuesta.findByAnIndEjecucionVigencia2016", query = "SELECT i FROM IndTraspuesta i WHERE i.anIndEjecucionVigencia2016 = :anIndEjecucionVigencia2016"),
    @NamedQuery(name = "IndTraspuesta.findByAnProgTot", query = "SELECT i FROM IndTraspuesta i WHERE i.anProgTot = :anProgTot"),
    @NamedQuery(name = "IndTraspuesta.findByAnEjecTot", query = "SELECT i FROM IndTraspuesta i WHERE i.anEjecTot = :anEjecTot"),
    @NamedQuery(name = "IndTraspuesta.findByAnAvance2012", query = "SELECT i FROM IndTraspuesta i WHERE i.anAvance2012 = :anAvance2012"),
    @NamedQuery(name = "IndTraspuesta.findByAnAvance2013", query = "SELECT i FROM IndTraspuesta i WHERE i.anAvance2013 = :anAvance2013"),
    @NamedQuery(name = "IndTraspuesta.findByAnAvance2014", query = "SELECT i FROM IndTraspuesta i WHERE i.anAvance2014 = :anAvance2014"),
    @NamedQuery(name = "IndTraspuesta.findByAnAvance2015", query = "SELECT i FROM IndTraspuesta i WHERE i.anAvance2015 = :anAvance2015"),
    @NamedQuery(name = "IndTraspuesta.findByAnAvance2016", query = "SELECT i FROM IndTraspuesta i WHERE i.anAvance2016 = :anAvance2016"),
    @NamedQuery(name = "IndTraspuesta.findByAnAvanceTot", query = "SELECT i FROM IndTraspuesta i WHERE i.anAvanceTot = :anAvanceTot"),
    @NamedQuery(name = "IndTraspuesta.findByAnAcumIndProgInicialPd2012", query = "SELECT i FROM IndTraspuesta i WHERE i.anAcumIndProgInicialPd2012 = :anAcumIndProgInicialPd2012"),
    @NamedQuery(name = "IndTraspuesta.findByAnAcumIndProgInicialPd2013", query = "SELECT i FROM IndTraspuesta i WHERE i.anAcumIndProgInicialPd2013 = :anAcumIndProgInicialPd2013"),
    @NamedQuery(name = "IndTraspuesta.findByAnAcumIndProgInicialPd2014", query = "SELECT i FROM IndTraspuesta i WHERE i.anAcumIndProgInicialPd2014 = :anAcumIndProgInicialPd2014"),
    @NamedQuery(name = "IndTraspuesta.findByAnAcumIndProgInicialPd2015", query = "SELECT i FROM IndTraspuesta i WHERE i.anAcumIndProgInicialPd2015 = :anAcumIndProgInicialPd2015"),
    @NamedQuery(name = "IndTraspuesta.findByAnAcumIndProgInicialPd2016", query = "SELECT i FROM IndTraspuesta i WHERE i.anAcumIndProgInicialPd2016 = :anAcumIndProgInicialPd2016"),
    @NamedQuery(name = "IndTraspuesta.findByAnAcumIndProgActual2012", query = "SELECT i FROM IndTraspuesta i WHERE i.anAcumIndProgActual2012 = :anAcumIndProgActual2012"),
    @NamedQuery(name = "IndTraspuesta.findByAnAcumIndProgActual2013", query = "SELECT i FROM IndTraspuesta i WHERE i.anAcumIndProgActual2013 = :anAcumIndProgActual2013"),
    @NamedQuery(name = "IndTraspuesta.findByAnAcumIndProgActual2014", query = "SELECT i FROM IndTraspuesta i WHERE i.anAcumIndProgActual2014 = :anAcumIndProgActual2014"),
    @NamedQuery(name = "IndTraspuesta.findByAnAcumIndProgActual2015", query = "SELECT i FROM IndTraspuesta i WHERE i.anAcumIndProgActual2015 = :anAcumIndProgActual2015"),
    @NamedQuery(name = "IndTraspuesta.findByAnAcumIndProgActual2016", query = "SELECT i FROM IndTraspuesta i WHERE i.anAcumIndProgActual2016 = :anAcumIndProgActual2016"),
    @NamedQuery(name = "IndTraspuesta.findByAnAcumIndEjecucionVigencia2012", query = "SELECT i FROM IndTraspuesta i WHERE i.anAcumIndEjecucionVigencia2012 = :anAcumIndEjecucionVigencia2012"),
    @NamedQuery(name = "IndTraspuesta.findByAnAcumIndEjecucionVigencia2013", query = "SELECT i FROM IndTraspuesta i WHERE i.anAcumIndEjecucionVigencia2013 = :anAcumIndEjecucionVigencia2013"),
    @NamedQuery(name = "IndTraspuesta.findByAnAcumIndEjecucionVigencia2014", query = "SELECT i FROM IndTraspuesta i WHERE i.anAcumIndEjecucionVigencia2014 = :anAcumIndEjecucionVigencia2014"),
    @NamedQuery(name = "IndTraspuesta.findByAnAcumIndEjecucionVigencia2015", query = "SELECT i FROM IndTraspuesta i WHERE i.anAcumIndEjecucionVigencia2015 = :anAcumIndEjecucionVigencia2015"),
    @NamedQuery(name = "IndTraspuesta.findByAnAcumIndEjecucionVigencia2016", query = "SELECT i FROM IndTraspuesta i WHERE i.anAcumIndEjecucionVigencia2016 = :anAcumIndEjecucionVigencia2016"),
    @NamedQuery(name = "IndTraspuesta.findByTrindId", query = "SELECT i FROM IndTraspuesta i WHERE i.trindId = :trindId"),
    @NamedQuery(name = "IndTraspuesta.findByIndProgInicialPdCaltot", query = "SELECT i FROM IndTraspuesta i WHERE i.indProgInicialPdCaltot = :indProgInicialPdCaltot"),
    @NamedQuery(name = "IndTraspuesta.findByIndProgActualCaltot", query = "SELECT i FROM IndTraspuesta i WHERE i.indProgActualCaltot = :indProgActualCaltot"),
    @NamedQuery(name = "IndTraspuesta.findByIndEjecucionVigenciaCaltot", query = "SELECT i FROM IndTraspuesta i WHERE i.indEjecucionVigenciaCaltot = :indEjecucionVigenciaCaltot")})
public class IndTraspuesta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 150)
    @Column(name = "ind_id_rep")
    private String indIdRep;
    @Column(name = "ind_codigo_pd")
    private Integer indCodigoPd;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ind_ano_prog_repr")
    private Double indAnoProgRepr;
    @Column(name = "ind_version_pa")
    private Integer indVersionPa;
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
    @Size(max = 255)
    @Column(name = "archivo")
    private String archivo;
    @Column(name = "trimestre")
    private Integer trimestre;
    @Column(name = "ind_prog_inicial_pd_2012")
    private BigDecimal indProgInicialPd2012;
    @Column(name = "ind_prog_inicial_pd_2013")
    private BigDecimal indProgInicialPd2013;
    @Column(name = "ind_prog_inicial_pd_2014")
    private BigDecimal indProgInicialPd2014;
    @Column(name = "ind_prog_inicial_pd_2015")
    private BigDecimal indProgInicialPd2015;
    @Column(name = "ind_prog_inicial_pd_2016")
    private BigDecimal indProgInicialPd2016;
    @Column(name = "ind_prog_actual_2012")
    private BigDecimal indProgActual2012;
    @Column(name = "ind_prog_actual_2013")
    private BigDecimal indProgActual2013;
    @Column(name = "ind_prog_actual_2014")
    private BigDecimal indProgActual2014;
    @Column(name = "ind_prog_actual_2015")
    private BigDecimal indProgActual2015;
    @Column(name = "ind_prog_actual_2016")
    private BigDecimal indProgActual2016;
    @Column(name = "ind_ejecucion_vigencia_2012")
    private BigDecimal indEjecucionVigencia2012;
    @Column(name = "ind_ejecucion_vigencia_2013")
    private BigDecimal indEjecucionVigencia2013;
    @Column(name = "ind_ejecucion_vigencia_2014")
    private BigDecimal indEjecucionVigencia2014;
    @Column(name = "ind_ejecucion_vigencia_2015")
    private BigDecimal indEjecucionVigencia2015;
    @Column(name = "ind_ejecucion_vigencia_2016")
    private BigDecimal indEjecucionVigencia2016;
    @Column(name = "ind_porc_av_Vig_2012")
    private Double indporcavVig2012;
    @Column(name = "ind_porc_av_Vig_2013")
    private Double indporcavVig2013;
    @Column(name = "ind_porc_av_Vig_2014")
    private Double indporcavVig2014;
    @Column(name = "ind_porc_av_Vig_2015")
    private Double indporcavVig2015;
    @Column(name = "ind_porc_av_Vig_2016")
    private Double indporcavVig2016;
    @Column(name = "ind_porc_av_TraPD_2012")
    private Double indporcavTraPD2012;
    @Column(name = "ind_porc_av_TraPD_2013")
    private Double indporcavTraPD2013;
    @Column(name = "ind_porc_av_TraPD_2014")
    private Double indporcavTraPD2014;
    @Column(name = "ind_porc_av_TraPD_2015")
    private Double indporcavTraPD2015;
    @Column(name = "ind_porc_av_TraPD_2016")
    private Double indporcavTraPD2016;
    @Column(name = "ind_porc_av_PD_2012")
    private BigDecimal indporcavPD2012;
    @Column(name = "ind_porc_av_PD_2013")
    private BigDecimal indporcavPD2013;
    @Column(name = "ind_porc_av_PD_2014")
    private BigDecimal indporcavPD2014;
    @Column(name = "ind_porc_av_PD_2015")
    private BigDecimal indporcavPD2015;
    @Column(name = "ind_porc_av_PD_2016")
    private BigDecimal indporcavPD2016;
    @Column(name = "an_ind_prog_inicial_pd_2012")
    private BigDecimal anIndProgInicialPd2012;
    @Column(name = "an_ind_prog_inicial_pd_2013")
    private BigDecimal anIndProgInicialPd2013;
    @Column(name = "an_ind_prog_inicial_pd_2014")
    private BigDecimal anIndProgInicialPd2014;
    @Column(name = "an_ind_prog_inicial_pd_2015")
    private BigDecimal anIndProgInicialPd2015;
    @Column(name = "an_ind_prog_inicial_pd_2016")
    private BigDecimal anIndProgInicialPd2016;
    @Column(name = "an_ind_prog_actual_2012")
    private BigDecimal anIndProgActual2012;
    @Column(name = "an_ind_prog_actual_2013")
    private BigDecimal anIndProgActual2013;
    @Column(name = "an_ind_prog_actual_2014")
    private BigDecimal anIndProgActual2014;
    @Column(name = "an_ind_prog_actual_2015")
    private BigDecimal anIndProgActual2015;
    @Column(name = "an_ind_prog_actual_2016")
    private BigDecimal anIndProgActual2016;
    @Column(name = "an_ind_ejecucion_vigencia_2012")
    private BigDecimal anIndEjecucionVigencia2012;
    @Column(name = "an_ind_ejecucion_vigencia_2013")
    private BigDecimal anIndEjecucionVigencia2013;
    @Column(name = "an_ind_ejecucion_vigencia_2014")
    private BigDecimal anIndEjecucionVigencia2014;
    @Column(name = "an_ind_ejecucion_vigencia_2015")
    private BigDecimal anIndEjecucionVigencia2015;
    @Column(name = "an_ind_ejecucion_vigencia_2016")
    private BigDecimal anIndEjecucionVigencia2016;
    @Column(name = "an_prog_tot")
    private BigDecimal anProgTot;
    @Column(name = "an_ejec_tot")
    private BigDecimal anEjecTot;
    @Column(name = "an_avance_2012")
    private BigDecimal anAvance2012;
    @Column(name = "an_avance_2013")
    private BigDecimal anAvance2013;
    @Column(name = "an_avance_2014")
    private BigDecimal anAvance2014;
    @Column(name = "an_avance_2015")
    private BigDecimal anAvance2015;
    @Column(name = "an_avance_2016")
    private BigDecimal anAvance2016;
    @Column(name = "an_avance_tot")
    private BigDecimal anAvanceTot;
    @Column(name = "an_acum_ind_prog_inicial_pd_2012")
    private BigDecimal anAcumIndProgInicialPd2012;
    @Column(name = "an_acum_ind_prog_inicial_pd_2013")
    private BigDecimal anAcumIndProgInicialPd2013;
    @Column(name = "an_acum_ind_prog_inicial_pd_2014")
    private BigDecimal anAcumIndProgInicialPd2014;
    @Column(name = "an_acum_ind_prog_inicial_pd_2015")
    private BigDecimal anAcumIndProgInicialPd2015;
    @Column(name = "an_acum_ind_prog_inicial_pd_2016")
    private BigDecimal anAcumIndProgInicialPd2016;
    @Column(name = "an_acum_ind_prog_actual_2012")
    private BigDecimal anAcumIndProgActual2012;
    @Column(name = "an_acum_ind_prog_actual_2013")
    private BigDecimal anAcumIndProgActual2013;
    @Column(name = "an_acum_ind_prog_actual_2014")
    private BigDecimal anAcumIndProgActual2014;
    @Column(name = "an_acum_ind_prog_actual_2015")
    private BigDecimal anAcumIndProgActual2015;
    @Column(name = "an_acum_ind_prog_actual_2016")
    private BigDecimal anAcumIndProgActual2016;
    @Column(name = "an_acum_ind_ejecucion_vigencia_2012")
    private BigDecimal anAcumIndEjecucionVigencia2012;
    @Column(name = "an_acum_ind_ejecucion_vigencia_2013")
    private BigDecimal anAcumIndEjecucionVigencia2013;
    @Column(name = "an_acum_ind_ejecucion_vigencia_2014")
    private BigDecimal anAcumIndEjecucionVigencia2014;
    @Column(name = "an_acum_ind_ejecucion_vigencia_2015")
    private BigDecimal anAcumIndEjecucionVigencia2015;
    @Column(name = "an_acum_ind_ejecucion_vigencia_2016")
    private BigDecimal anAcumIndEjecucionVigencia2016;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "trind_id")
    private Long trindId;
    @Column(name = "ind_prog_inicial_pd_caltot")
    private BigDecimal indProgInicialPdCaltot;
    @Column(name = "ind_prog_actual_caltot")
    private BigDecimal indProgActualCaltot;
    @Column(name = "ind_ejecucion_vigencia_caltot")
    private BigDecimal indEjecucionVigenciaCaltot;

    public IndTraspuesta() {
    }

    public IndTraspuesta(Long trindId) {
        this.trindId = trindId;
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

    public Integer getIndVersionPa() {
        return indVersionPa;
    }

    public void setIndVersionPa(Integer indVersionPa) {
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

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public Integer getTrimestre() {
        return trimestre;
    }

    public void setTrimestre(Integer trimestre) {
        this.trimestre = trimestre;
    }

    public BigDecimal getIndProgInicialPd2012() {
        return indProgInicialPd2012;
    }

    public void setIndProgInicialPd2012(BigDecimal indProgInicialPd2012) {
        this.indProgInicialPd2012 = indProgInicialPd2012;
    }

    public BigDecimal getIndProgInicialPd2013() {
        return indProgInicialPd2013;
    }

    public void setIndProgInicialPd2013(BigDecimal indProgInicialPd2013) {
        this.indProgInicialPd2013 = indProgInicialPd2013;
    }

    public BigDecimal getIndProgInicialPd2014() {
        return indProgInicialPd2014;
    }

    public void setIndProgInicialPd2014(BigDecimal indProgInicialPd2014) {
        this.indProgInicialPd2014 = indProgInicialPd2014;
    }

    public BigDecimal getIndProgInicialPd2015() {
        return indProgInicialPd2015;
    }

    public void setIndProgInicialPd2015(BigDecimal indProgInicialPd2015) {
        this.indProgInicialPd2015 = indProgInicialPd2015;
    }

    public BigDecimal getIndProgInicialPd2016() {
        return indProgInicialPd2016;
    }

    public void setIndProgInicialPd2016(BigDecimal indProgInicialPd2016) {
        this.indProgInicialPd2016 = indProgInicialPd2016;
    }

    public BigDecimal getIndProgActual2012() {
        return indProgActual2012;
    }

    public void setIndProgActual2012(BigDecimal indProgActual2012) {
        this.indProgActual2012 = indProgActual2012;
    }

    public BigDecimal getIndProgActual2013() {
        return indProgActual2013;
    }

    public void setIndProgActual2013(BigDecimal indProgActual2013) {
        this.indProgActual2013 = indProgActual2013;
    }

    public BigDecimal getIndProgActual2014() {
        return indProgActual2014;
    }

    public void setIndProgActual2014(BigDecimal indProgActual2014) {
        this.indProgActual2014 = indProgActual2014;
    }

    public BigDecimal getIndProgActual2015() {
        return indProgActual2015;
    }

    public void setIndProgActual2015(BigDecimal indProgActual2015) {
        this.indProgActual2015 = indProgActual2015;
    }

    public BigDecimal getIndProgActual2016() {
        return indProgActual2016;
    }

    public void setIndProgActual2016(BigDecimal indProgActual2016) {
        this.indProgActual2016 = indProgActual2016;
    }

    public BigDecimal getIndEjecucionVigencia2012() {
        return indEjecucionVigencia2012;
    }

    public void setIndEjecucionVigencia2012(BigDecimal indEjecucionVigencia2012) {
        this.indEjecucionVigencia2012 = indEjecucionVigencia2012;
    }

    public BigDecimal getIndEjecucionVigencia2013() {
        return indEjecucionVigencia2013;
    }

    public void setIndEjecucionVigencia2013(BigDecimal indEjecucionVigencia2013) {
        this.indEjecucionVigencia2013 = indEjecucionVigencia2013;
    }

    public BigDecimal getIndEjecucionVigencia2014() {
        return indEjecucionVigencia2014;
    }

    public void setIndEjecucionVigencia2014(BigDecimal indEjecucionVigencia2014) {
        this.indEjecucionVigencia2014 = indEjecucionVigencia2014;
    }

    public BigDecimal getIndEjecucionVigencia2015() {
        return indEjecucionVigencia2015;
    }

    public void setIndEjecucionVigencia2015(BigDecimal indEjecucionVigencia2015) {
        this.indEjecucionVigencia2015 = indEjecucionVigencia2015;
    }

    public BigDecimal getIndEjecucionVigencia2016() {
        return indEjecucionVigencia2016;
    }

    public void setIndEjecucionVigencia2016(BigDecimal indEjecucionVigencia2016) {
        this.indEjecucionVigencia2016 = indEjecucionVigencia2016;
    }

    public Double getIndporcavVig2012() {
        return indporcavVig2012;
    }

    public void setIndporcavVig2012(Double indporcavVig2012) {
        this.indporcavVig2012 = indporcavVig2012;
    }

    public Double getIndporcavVig2013() {
        return indporcavVig2013;
    }

    public void setIndporcavVig2013(Double indporcavVig2013) {
        this.indporcavVig2013 = indporcavVig2013;
    }

    public Double getIndporcavVig2014() {
        return indporcavVig2014;
    }

    public void setIndporcavVig2014(Double indporcavVig2014) {
        this.indporcavVig2014 = indporcavVig2014;
    }

    public Double getIndporcavVig2015() {
        return indporcavVig2015;
    }

    public void setIndporcavVig2015(Double indporcavVig2015) {
        this.indporcavVig2015 = indporcavVig2015;
    }

    public Double getIndporcavVig2016() {
        return indporcavVig2016;
    }

    public void setIndporcavVig2016(Double indporcavVig2016) {
        this.indporcavVig2016 = indporcavVig2016;
    }

    public Double getIndporcavTraPD2012() {
        return indporcavTraPD2012;
    }

    public void setIndporcavTraPD2012(Double indporcavTraPD2012) {
        this.indporcavTraPD2012 = indporcavTraPD2012;
    }

    public Double getIndporcavTraPD2013() {
        return indporcavTraPD2013;
    }

    public void setIndporcavTraPD2013(Double indporcavTraPD2013) {
        this.indporcavTraPD2013 = indporcavTraPD2013;
    }

    public Double getIndporcavTraPD2014() {
        return indporcavTraPD2014;
    }

    public void setIndporcavTraPD2014(Double indporcavTraPD2014) {
        this.indporcavTraPD2014 = indporcavTraPD2014;
    }

    public Double getIndporcavTraPD2015() {
        return indporcavTraPD2015;
    }

    public void setIndporcavTraPD2015(Double indporcavTraPD2015) {
        this.indporcavTraPD2015 = indporcavTraPD2015;
    }

    public Double getIndporcavTraPD2016() {
        return indporcavTraPD2016;
    }

    public void setIndporcavTraPD2016(Double indporcavTraPD2016) {
        this.indporcavTraPD2016 = indporcavTraPD2016;
    }

    public BigDecimal getIndporcavPD2012() {
        return indporcavPD2012;
    }

    public void setIndporcavPD2012(BigDecimal indporcavPD2012) {
        this.indporcavPD2012 = indporcavPD2012;
    }

    public BigDecimal getIndporcavPD2013() {
        return indporcavPD2013;
    }

    public void setIndporcavPD2013(BigDecimal indporcavPD2013) {
        this.indporcavPD2013 = indporcavPD2013;
    }

    public BigDecimal getIndporcavPD2014() {
        return indporcavPD2014;
    }

    public void setIndporcavPD2014(BigDecimal indporcavPD2014) {
        this.indporcavPD2014 = indporcavPD2014;
    }

    public BigDecimal getIndporcavPD2015() {
        return indporcavPD2015;
    }

    public void setIndporcavPD2015(BigDecimal indporcavPD2015) {
        this.indporcavPD2015 = indporcavPD2015;
    }

    public BigDecimal getIndporcavPD2016() {
        return indporcavPD2016;
    }

    public void setIndporcavPD2016(BigDecimal indporcavPD2016) {
        this.indporcavPD2016 = indporcavPD2016;
    }

    public BigDecimal getAnIndProgInicialPd2012() {
        return anIndProgInicialPd2012;
    }

    public void setAnIndProgInicialPd2012(BigDecimal anIndProgInicialPd2012) {
        this.anIndProgInicialPd2012 = anIndProgInicialPd2012;
    }

    public BigDecimal getAnIndProgInicialPd2013() {
        return anIndProgInicialPd2013;
    }

    public void setAnIndProgInicialPd2013(BigDecimal anIndProgInicialPd2013) {
        this.anIndProgInicialPd2013 = anIndProgInicialPd2013;
    }

    public BigDecimal getAnIndProgInicialPd2014() {
        return anIndProgInicialPd2014;
    }

    public void setAnIndProgInicialPd2014(BigDecimal anIndProgInicialPd2014) {
        this.anIndProgInicialPd2014 = anIndProgInicialPd2014;
    }

    public BigDecimal getAnIndProgInicialPd2015() {
        return anIndProgInicialPd2015;
    }

    public void setAnIndProgInicialPd2015(BigDecimal anIndProgInicialPd2015) {
        this.anIndProgInicialPd2015 = anIndProgInicialPd2015;
    }

    public BigDecimal getAnIndProgInicialPd2016() {
        return anIndProgInicialPd2016;
    }

    public void setAnIndProgInicialPd2016(BigDecimal anIndProgInicialPd2016) {
        this.anIndProgInicialPd2016 = anIndProgInicialPd2016;
    }

    public BigDecimal getAnIndProgActual2012() {
        return anIndProgActual2012;
    }

    public void setAnIndProgActual2012(BigDecimal anIndProgActual2012) {
        this.anIndProgActual2012 = anIndProgActual2012;
    }

    public BigDecimal getAnIndProgActual2013() {
        return anIndProgActual2013;
    }

    public void setAnIndProgActual2013(BigDecimal anIndProgActual2013) {
        this.anIndProgActual2013 = anIndProgActual2013;
    }

    public BigDecimal getAnIndProgActual2014() {
        return anIndProgActual2014;
    }

    public void setAnIndProgActual2014(BigDecimal anIndProgActual2014) {
        this.anIndProgActual2014 = anIndProgActual2014;
    }

    public BigDecimal getAnIndProgActual2015() {
        return anIndProgActual2015;
    }

    public void setAnIndProgActual2015(BigDecimal anIndProgActual2015) {
        this.anIndProgActual2015 = anIndProgActual2015;
    }

    public BigDecimal getAnIndProgActual2016() {
        return anIndProgActual2016;
    }

    public void setAnIndProgActual2016(BigDecimal anIndProgActual2016) {
        this.anIndProgActual2016 = anIndProgActual2016;
    }

    public BigDecimal getAnIndEjecucionVigencia2012() {
        return anIndEjecucionVigencia2012;
    }

    public void setAnIndEjecucionVigencia2012(BigDecimal anIndEjecucionVigencia2012) {
        this.anIndEjecucionVigencia2012 = anIndEjecucionVigencia2012;
    }

    public BigDecimal getAnIndEjecucionVigencia2013() {
        return anIndEjecucionVigencia2013;
    }

    public void setAnIndEjecucionVigencia2013(BigDecimal anIndEjecucionVigencia2013) {
        this.anIndEjecucionVigencia2013 = anIndEjecucionVigencia2013;
    }

    public BigDecimal getAnIndEjecucionVigencia2014() {
        return anIndEjecucionVigencia2014;
    }

    public void setAnIndEjecucionVigencia2014(BigDecimal anIndEjecucionVigencia2014) {
        this.anIndEjecucionVigencia2014 = anIndEjecucionVigencia2014;
    }

    public BigDecimal getAnIndEjecucionVigencia2015() {
        return anIndEjecucionVigencia2015;
    }

    public void setAnIndEjecucionVigencia2015(BigDecimal anIndEjecucionVigencia2015) {
        this.anIndEjecucionVigencia2015 = anIndEjecucionVigencia2015;
    }

    public BigDecimal getAnIndEjecucionVigencia2016() {
        return anIndEjecucionVigencia2016;
    }

    public void setAnIndEjecucionVigencia2016(BigDecimal anIndEjecucionVigencia2016) {
        this.anIndEjecucionVigencia2016 = anIndEjecucionVigencia2016;
    }

    public BigDecimal getAnProgTot() {
        return anProgTot;
    }

    public void setAnProgTot(BigDecimal anProgTot) {
        this.anProgTot = anProgTot;
    }

    public BigDecimal getAnEjecTot() {
        return anEjecTot;
    }

    public void setAnEjecTot(BigDecimal anEjecTot) {
        this.anEjecTot = anEjecTot;
    }

    public BigDecimal getAnAvance2012() {
        return anAvance2012;
    }

    public void setAnAvance2012(BigDecimal anAvance2012) {
        this.anAvance2012 = anAvance2012;
    }

    public BigDecimal getAnAvance2013() {
        return anAvance2013;
    }

    public void setAnAvance2013(BigDecimal anAvance2013) {
        this.anAvance2013 = anAvance2013;
    }

    public BigDecimal getAnAvance2014() {
        return anAvance2014;
    }

    public void setAnAvance2014(BigDecimal anAvance2014) {
        this.anAvance2014 = anAvance2014;
    }

    public BigDecimal getAnAvance2015() {
        return anAvance2015;
    }

    public void setAnAvance2015(BigDecimal anAvance2015) {
        this.anAvance2015 = anAvance2015;
    }

    public BigDecimal getAnAvance2016() {
        return anAvance2016;
    }

    public void setAnAvance2016(BigDecimal anAvance2016) {
        this.anAvance2016 = anAvance2016;
    }

    public BigDecimal getAnAvanceTot() {
        return anAvanceTot;
    }

    public void setAnAvanceTot(BigDecimal anAvanceTot) {
        this.anAvanceTot = anAvanceTot;
    }

    public BigDecimal getAnAcumIndProgInicialPd2012() {
        return anAcumIndProgInicialPd2012;
    }

    public void setAnAcumIndProgInicialPd2012(BigDecimal anAcumIndProgInicialPd2012) {
        this.anAcumIndProgInicialPd2012 = anAcumIndProgInicialPd2012;
    }

    public BigDecimal getAnAcumIndProgInicialPd2013() {
        return anAcumIndProgInicialPd2013;
    }

    public void setAnAcumIndProgInicialPd2013(BigDecimal anAcumIndProgInicialPd2013) {
        this.anAcumIndProgInicialPd2013 = anAcumIndProgInicialPd2013;
    }

    public BigDecimal getAnAcumIndProgInicialPd2014() {
        return anAcumIndProgInicialPd2014;
    }

    public void setAnAcumIndProgInicialPd2014(BigDecimal anAcumIndProgInicialPd2014) {
        this.anAcumIndProgInicialPd2014 = anAcumIndProgInicialPd2014;
    }

    public BigDecimal getAnAcumIndProgInicialPd2015() {
        return anAcumIndProgInicialPd2015;
    }

    public void setAnAcumIndProgInicialPd2015(BigDecimal anAcumIndProgInicialPd2015) {
        this.anAcumIndProgInicialPd2015 = anAcumIndProgInicialPd2015;
    }

    public BigDecimal getAnAcumIndProgInicialPd2016() {
        return anAcumIndProgInicialPd2016;
    }

    public void setAnAcumIndProgInicialPd2016(BigDecimal anAcumIndProgInicialPd2016) {
        this.anAcumIndProgInicialPd2016 = anAcumIndProgInicialPd2016;
    }

    public BigDecimal getAnAcumIndProgActual2012() {
        return anAcumIndProgActual2012;
    }

    public void setAnAcumIndProgActual2012(BigDecimal anAcumIndProgActual2012) {
        this.anAcumIndProgActual2012 = anAcumIndProgActual2012;
    }

    public BigDecimal getAnAcumIndProgActual2013() {
        return anAcumIndProgActual2013;
    }

    public void setAnAcumIndProgActual2013(BigDecimal anAcumIndProgActual2013) {
        this.anAcumIndProgActual2013 = anAcumIndProgActual2013;
    }

    public BigDecimal getAnAcumIndProgActual2014() {
        return anAcumIndProgActual2014;
    }

    public void setAnAcumIndProgActual2014(BigDecimal anAcumIndProgActual2014) {
        this.anAcumIndProgActual2014 = anAcumIndProgActual2014;
    }

    public BigDecimal getAnAcumIndProgActual2015() {
        return anAcumIndProgActual2015;
    }

    public void setAnAcumIndProgActual2015(BigDecimal anAcumIndProgActual2015) {
        this.anAcumIndProgActual2015 = anAcumIndProgActual2015;
    }

    public BigDecimal getAnAcumIndProgActual2016() {
        return anAcumIndProgActual2016;
    }

    public void setAnAcumIndProgActual2016(BigDecimal anAcumIndProgActual2016) {
        this.anAcumIndProgActual2016 = anAcumIndProgActual2016;
    }

    public BigDecimal getAnAcumIndEjecucionVigencia2012() {
        return anAcumIndEjecucionVigencia2012;
    }

    public void setAnAcumIndEjecucionVigencia2012(BigDecimal anAcumIndEjecucionVigencia2012) {
        this.anAcumIndEjecucionVigencia2012 = anAcumIndEjecucionVigencia2012;
    }

    public BigDecimal getAnAcumIndEjecucionVigencia2013() {
        return anAcumIndEjecucionVigencia2013;
    }

    public void setAnAcumIndEjecucionVigencia2013(BigDecimal anAcumIndEjecucionVigencia2013) {
        this.anAcumIndEjecucionVigencia2013 = anAcumIndEjecucionVigencia2013;
    }

    public BigDecimal getAnAcumIndEjecucionVigencia2014() {
        return anAcumIndEjecucionVigencia2014;
    }

    public void setAnAcumIndEjecucionVigencia2014(BigDecimal anAcumIndEjecucionVigencia2014) {
        this.anAcumIndEjecucionVigencia2014 = anAcumIndEjecucionVigencia2014;
    }

    public BigDecimal getAnAcumIndEjecucionVigencia2015() {
        return anAcumIndEjecucionVigencia2015;
    }

    public void setAnAcumIndEjecucionVigencia2015(BigDecimal anAcumIndEjecucionVigencia2015) {
        this.anAcumIndEjecucionVigencia2015 = anAcumIndEjecucionVigencia2015;
    }

    public BigDecimal getAnAcumIndEjecucionVigencia2016() {
        return anAcumIndEjecucionVigencia2016;
    }

    public void setAnAcumIndEjecucionVigencia2016(BigDecimal anAcumIndEjecucionVigencia2016) {
        this.anAcumIndEjecucionVigencia2016 = anAcumIndEjecucionVigencia2016;
    }

    public Long getTrindId() {
        return trindId;
    }

    public void setTrindId(Long trindId) {
        this.trindId = trindId;
    }

    public BigDecimal getIndProgInicialPdCaltot() {
        return indProgInicialPdCaltot;
    }

    public void setIndProgInicialPdCaltot(BigDecimal indProgInicialPdCaltot) {
        this.indProgInicialPdCaltot = indProgInicialPdCaltot;
    }

    public BigDecimal getIndProgActualCaltot() {
        return indProgActualCaltot;
    }

    public void setIndProgActualCaltot(BigDecimal indProgActualCaltot) {
        this.indProgActualCaltot = indProgActualCaltot;
    }

    public BigDecimal getIndEjecucionVigenciaCaltot() {
        return indEjecucionVigenciaCaltot;
    }

    public void setIndEjecucionVigenciaCaltot(BigDecimal indEjecucionVigenciaCaltot) {
        this.indEjecucionVigenciaCaltot = indEjecucionVigenciaCaltot;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (trindId != null ? trindId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IndTraspuesta)) {
            return false;
        }
        IndTraspuesta other = (IndTraspuesta) object;
        if ((this.trindId == null && other.trindId != null) || (this.trindId != null && !this.trindId.equals(other.trindId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.veeduria.dao.IndTraspuesta[ trindId=" + trindId + " ]";
    }
    
}
