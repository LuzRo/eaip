/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veeduria.thm.dao;

import com.veeduria.sys.dao.SysRegistrocarga;
import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author con1ead
 */
@Entity
@Table(name = "thm_temporal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ThmTemporal.findAll", query = "SELECT t FROM ThmTemporal t"),
    @NamedQuery(name = "ThmTemporal.findByTemId", query = "SELECT t FROM ThmTemporal t WHERE t.temId = :temId"),
    @NamedQuery(name = "ThmTemporal.findByTemDenomempleo", query = "SELECT t FROM ThmTemporal t WHERE t.temDenomempleo = :temDenomempleo"),
    @NamedQuery(name = "ThmTemporal.findByTemCodigo", query = "SELECT t FROM ThmTemporal t WHERE t.temCodigo = :temCodigo"),
    @NamedQuery(name = "ThmTemporal.findByTemGrado", query = "SELECT t FROM ThmTemporal t WHERE t.temGrado = :temGrado"),
    @NamedQuery(name = "ThmTemporal.findByTemTipodecargo", query = "SELECT t FROM ThmTemporal t WHERE t.temTipodecargo = :temTipodecargo"),
    @NamedQuery(name = "ThmTemporal.findByTemNiveljerarquico", query = "SELECT t FROM ThmTemporal t WHERE t.temNiveljerarquico = :temNiveljerarquico"),
    @NamedQuery(name = "ThmTemporal.findByTemDepestrucorg", query = "SELECT t FROM ThmTemporal t WHERE t.temDepestrucorg = :temDepestrucorg"),
    @NamedQuery(name = "ThmTemporal.findByTemAreafunctrabajo", query = "SELECT t FROM ThmTemporal t WHERE t.temAreafunctrabajo = :temAreafunctrabajo"),
    @NamedQuery(name = "ThmTemporal.findByTemTipodependencia", query = "SELECT t FROM ThmTemporal t WHERE t.temTipodependencia = :temTipodependencia"),
    @NamedQuery(name = "ThmTemporal.findByTemTipodocumento", query = "SELECT t FROM ThmTemporal t WHERE t.temTipodocumento = :temTipodocumento"),
    @NamedQuery(name = "ThmTemporal.findByTemNumdocumento", query = "SELECT t FROM ThmTemporal t WHERE t.temNumdocumento = :temNumdocumento"),
    @NamedQuery(name = "ThmTemporal.findByTemNombres", query = "SELECT t FROM ThmTemporal t WHERE t.temNombres = :temNombres"),
    @NamedQuery(name = "ThmTemporal.findByTemPrimerapellido", query = "SELECT t FROM ThmTemporal t WHERE t.temPrimerapellido = :temPrimerapellido"),
    @NamedQuery(name = "ThmTemporal.findByTemSegundoapellido", query = "SELECT t FROM ThmTemporal t WHERE t.temSegundoapellido = :temSegundoapellido"),
    @NamedQuery(name = "ThmTemporal.findByTemConteo", query = "SELECT t FROM ThmTemporal t WHERE t.temConteo = :temConteo"),
    @NamedQuery(name = "ThmTemporal.findByTemVacantedef1", query = "SELECT t FROM ThmTemporal t WHERE t.temVacantedef1 = :temVacantedef1"),
    @NamedQuery(name = "ThmTemporal.findByTemVacantedef2", query = "SELECT t FROM ThmTemporal t WHERE t.temVacantedef2 = :temVacantedef2"),
    @NamedQuery(name = "ThmTemporal.findByTemVacantettem1", query = "SELECT t FROM ThmTemporal t WHERE t.temVacantettem1 = :temVacantettem1"),
    @NamedQuery(name = "ThmTemporal.findByTemVacantettem2", query = "SELECT t FROM ThmTemporal t WHERE t.temVacantettem2 = :temVacantettem2"),
    @NamedQuery(name = "ThmTemporal.findByTemFechaingresoent", query = "SELECT t FROM ThmTemporal t WHERE t.temFechaingresoent = :temFechaingresoent"),
    @NamedQuery(name = "ThmTemporal.findByTemTipoactoadtivo", query = "SELECT t FROM ThmTemporal t WHERE t.temTipoactoadtivo = :temTipoactoadtivo"),
    @NamedQuery(name = "ThmTemporal.findByTemNumactoadtivo", query = "SELECT t FROM ThmTemporal t WHERE t.temNumactoadtivo = :temNumactoadtivo"),
    @NamedQuery(name = "ThmTemporal.findByTemFechaactoadtivo", query = "SELECT t FROM ThmTemporal t WHERE t.temFechaactoadtivo = :temFechaactoadtivo"),
    @NamedQuery(name = "ThmTemporal.findByTemFormavinculacion", query = "SELECT t FROM ThmTemporal t WHERE t.temFormavinculacion = :temFormavinculacion"),
    @NamedQuery(name = "ThmTemporal.findByTemFechanacimiento", query = "SELECT t FROM ThmTemporal t WHERE t.temFechanacimiento = :temFechanacimiento"),
    @NamedQuery(name = "ThmTemporal.findByTemIdentidadgenero", query = "SELECT t FROM ThmTemporal t WHERE t.temIdentidadgenero = :temIdentidadgenero"),
    @NamedQuery(name = "ThmTemporal.findByTemM", query = "SELECT t FROM ThmTemporal t WHERE t.temM = :temM"),
    @NamedQuery(name = "ThmTemporal.findByTemF", query = "SELECT t FROM ThmTemporal t WHERE t.temF = :temF"),
    @NamedQuery(name = "ThmTemporal.findByTemT", query = "SELECT t FROM ThmTemporal t WHERE t.temT = :temT"),
    @NamedQuery(name = "ThmTemporal.findByTemCabezafamilia", query = "SELECT t FROM ThmTemporal t WHERE t.temCabezafamilia = :temCabezafamilia"),
    @NamedQuery(name = "ThmTemporal.findByTemDiscapacidadfisica", query = "SELECT t FROM ThmTemporal t WHERE t.temDiscapacidadfisica = :temDiscapacidadfisica"),
    @NamedQuery(name = "ThmTemporal.findByTemGrupoetnico", query = "SELECT t FROM ThmTemporal t WHERE t.temGrupoetnico = :temGrupoetnico"),
    @NamedQuery(name = "ThmTemporal.findByTemSituacionadtivafn", query = "SELECT t FROM ThmTemporal t WHERE t.temSituacionadtivafn = :temSituacionadtivafn"),
    @NamedQuery(name = "ThmTemporal.findByTemCalificacionobtenida", query = "SELECT t FROM ThmTemporal t WHERE t.temCalificacionobtenida = :temCalificacionobtenida"),
    @NamedQuery(name = "ThmTemporal.findByTemAsignacionbasica", query = "SELECT t FROM ThmTemporal t WHERE t.temAsignacionbasica = :temAsignacionbasica"),
    @NamedQuery(name = "ThmTemporal.findByTemGastosrepresentacion", query = "SELECT t FROM ThmTemporal t WHERE t.temGastosrepresentacion = :temGastosrepresentacion"),
    @NamedQuery(name = "ThmTemporal.findByTemPorcgastosrepresentacion", query = "SELECT t FROM ThmTemporal t WHERE t.temPorcgastosrepresentacion = :temPorcgastosrepresentacion"),
    @NamedQuery(name = "ThmTemporal.findByTemPrimatecnica", query = "SELECT t FROM ThmTemporal t WHERE t.temPrimatecnica = :temPrimatecnica"),
    @NamedQuery(name = "ThmTemporal.findByTemPorcprimatecnica", query = "SELECT t FROM ThmTemporal t WHERE t.temPorcprimatecnica = :temPorcprimatecnica"),
    @NamedQuery(name = "ThmTemporal.findByTemNivelescolaridad", query = "SELECT t FROM ThmTemporal t WHERE t.temNivelescolaridad = :temNivelescolaridad"),
    @NamedQuery(name = "ThmTemporal.findByTemTitulopregrado", query = "SELECT t FROM ThmTemporal t WHERE t.temTitulopregrado = :temTitulopregrado"),
    @NamedQuery(name = "ThmTemporal.findByTemTituloposgrado", query = "SELECT t FROM ThmTemporal t WHERE t.temTituloposgrado = :temTituloposgrado"),
    @NamedQuery(name = "ThmTemporal.findByTemOtrotitulopregrado", query = "SELECT t FROM ThmTemporal t WHERE t.temOtrotitulopregrado = :temOtrotitulopregrado"),
    @NamedQuery(name = "ThmTemporal.findByTemPertenecesindicato", query = "SELECT t FROM ThmTemporal t WHERE t.temPertenecesindicato = :temPertenecesindicato"),
    @NamedQuery(name = "ThmTemporal.findByTemOrganizacionsindical", query = "SELECT t FROM ThmTemporal t WHERE t.temOrganizacionsindical = :temOrganizacionsindical"),
    @NamedQuery(name = "ThmTemporal.findByTemFechaafiliacion", query = "SELECT t FROM ThmTemporal t WHERE t.temFechaafiliacion = :temFechaafiliacion"),
    @NamedQuery(name = "ThmTemporal.findByTemTipovinculacion", query = "SELECT t FROM ThmTemporal t WHERE t.temTipovinculacion = :temTipovinculacion"),
    @NamedQuery(name = "ThmTemporal.findByTemDiasotorgadosmes", query = "SELECT t FROM ThmTemporal t WHERE t.temDiasotorgadosmes = :temDiasotorgadosmes"),
    @NamedQuery(name = "ThmTemporal.findByTemJustificacionpermiso", query = "SELECT t FROM ThmTemporal t WHERE t.temJustificacionpermiso = :temJustificacionpermiso"),
    @NamedQuery(name = "ThmTemporal.findByTemPorplanta", query = "SELECT t FROM ThmTemporal t WHERE t.temPorplanta = :temPorplanta"),
    @NamedQuery(name = "ThmTemporal.findByTemFechaing", query = "SELECT t FROM ThmTemporal t WHERE t.temFechaing = :temFechaing"),
    @NamedQuery(name = "ThmTemporal.findByTemFechanac", query = "SELECT t FROM ThmTemporal t WHERE t.temFechanac = :temFechanac")})
public class ThmTemporal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tem_id")
    private Long temId;
    @Size(max = 1500)
    @Column(name = "tem_denomempleo")
    private String temDenomempleo;
    @Size(max = 500)
    @Column(name = "tem_codigo")
    private String temCodigo;
    @Size(max = 500)
    @Column(name = "tem_grado")
    private String temGrado;
    @Size(max = 1500)
    @Column(name = "tem_tipodecargo")
    private String temTipodecargo;
    @Size(max = 1500)
    @Column(name = "tem_niveljerarquico")
    private String temNiveljerarquico;
    @Size(max = 1500)
    @Column(name = "tem_depestrucorg")
    private String temDepestrucorg;
    @Size(max = 1500)
    @Column(name = "tem_areafunctrabajo")
    private String temAreafunctrabajo;
    @Size(max = 1500)
    @Column(name = "tem_tipodependencia")
    private String temTipodependencia;
    @Size(max = 50)
    @Column(name = "tem_tipodocumento")
    private String temTipodocumento;
    @Size(max = 100)
    @Column(name = "tem_numdocumento")
    private String temNumdocumento;
    @Size(max = 1500)
    @Column(name = "tem_nombres")
    private String temNombres;
    @Size(max = 1500)
    @Column(name = "tem_primerapellido")
    private String temPrimerapellido;
    @Size(max = 1500)
    @Column(name = "tem_segundoapellido")
    private String temSegundoapellido;
    @Size(max = 1500)
    @Column(name = "tem_conteo")
    private String temConteo;
    @Size(max = 1500)
    @Column(name = "tem_vacantedef1")
    private String temVacantedef1;
    @Size(max = 1500)
    @Column(name = "tem_vacantedef2")
    private String temVacantedef2;
    @Size(max = 1500)
    @Column(name = "tem_vacantettem1")
    private String temVacantettem1;
    @Size(max = 1500)
    @Column(name = "tem_vacantettem2")
    private String temVacantettem2;
    @Size(max = 1500)
    @Column(name = "tem_fechaingresoent")
    private String temFechaingresoent;
    @Size(max = 1500)
    @Column(name = "tem_tipoactoadtivo")
    private String temTipoactoadtivo;
    @Size(max = 100)
    @Column(name = "tem_numactoadtivo")
    private String temNumactoadtivo;
    @Size(max = 1500)
    @Column(name = "tem_fechaactoadtivo")
    private String temFechaactoadtivo;
    @Size(max = 1500)
    @Column(name = "tem_formavinculacion")
    private String temFormavinculacion;
    @Size(max = 1500)
    @Column(name = "tem_fechanacimiento")
    private String temFechanacimiento;
    @Size(max = 1500)
    @Column(name = "tem_identidadgenero")
    private String temIdentidadgenero;
    @Size(max = 50)
    @Column(name = "tem_m")
    private String temM;
    @Size(max = 50)
    @Column(name = "tem_f")
    private String temF;
    @Size(max = 50)
    @Column(name = "tem_t")
    private String temT;
    @Size(max = 1500)
    @Column(name = "tem_cabezafamilia")
    private String temCabezafamilia;
    @Size(max = 1500)
    @Column(name = "tem_discapacidadfisica")
    private String temDiscapacidadfisica;
    @Size(max = 1500)
    @Column(name = "tem_grupoetnico")
    private String temGrupoetnico;
    @Size(max = 1500)
    @Column(name = "tem_situacionadtivafn")
    private String temSituacionadtivafn;
    @Size(max = 1500)
    @Column(name = "tem_calificacionobtenida")
    private String temCalificacionobtenida;
    @Size(max = 1500)
    @Column(name = "tem_asignacionbasica")
    private String temAsignacionbasica;
    @Size(max = 1500)
    @Column(name = "tem_gastosrepresentacion")
    private String temGastosrepresentacion;
    @Size(max = 1500)
    @Column(name = "tem_porcgastosrepresentacion")
    private String temPorcgastosrepresentacion;
    @Size(max = 1500)
    @Column(name = "tem_primatecnica")
    private String temPrimatecnica;
    @Size(max = 1500)
    @Column(name = "tem_porcprimatecnica")
    private String temPorcprimatecnica;
    @Size(max = 1500)
    @Column(name = "tem_nivelescolaridad")
    private String temNivelescolaridad;
    @Size(max = 1500)
    @Column(name = "tem_titulopregrado")
    private String temTitulopregrado;
    @Size(max = 1500)
    @Column(name = "tem_tituloposgrado")
    private String temTituloposgrado;
    @Size(max = 1500)
    @Column(name = "tem_otrotitulopregrado")
    private String temOtrotitulopregrado;
    @Size(max = 1500)
    @Column(name = "tem_pertenecesindicato")
    private String temPertenecesindicato;
    @Size(max = 1500)
    @Column(name = "tem_organizacionsindical")
    private String temOrganizacionsindical;
    @Size(max = 1500)
    @Column(name = "tem_fechaafiliacion")
    private String temFechaafiliacion;
    @Size(max = 1500)
    @Column(name = "tem_tipovinculacion")
    private String temTipovinculacion;
    @Size(max = 1500)
    @Column(name = "tem_diasotorgadosmes")
    private String temDiasotorgadosmes;
    @Size(max = 1500)
    @Column(name = "tem_justificacionpermiso")
    private String temJustificacionpermiso;
    @Column(name = "tem_porplanta")
    private Integer temPorplanta;
    @Column(name = "tem_fechaing")
    @Temporal(TemporalType.DATE)
    private Date temFechaing;
    @Column(name = "tem_fechanac")
    @Temporal(TemporalType.DATE)
    private Date temFechanac;
    @JoinColumn(name = "lgreg_id", referencedColumnName = "lgreg_id")
    @ManyToOne
    private SysRegistrocarga lgregId;
    @JoinColumn(name = "for_id", referencedColumnName = "for_id")
    @ManyToOne
    private ThmRfFormavinculacion forId;
    @JoinColumn(name = "ene_id", referencedColumnName = "ene_id")
    @ManyToOne
    private ThmRfNivelescolaridad eneId;
    @JoinColumn(name = "enj_id", referencedColumnName = "enj_id")
    @ManyToOne
    private ThmRfNiveljerarquico enjId;
    @JoinColumn(name = "etc_id", referencedColumnName = "etc_id")
    @ManyToOne
    private ThmRfTipocargo etcId;
    @JoinColumn(name = "etd_id", referencedColumnName = "etd_id")
    @ManyToOne
    private ThmRfTipodependencia etdId;

    public ThmTemporal() {
    }

    public ThmTemporal(Long temId) {
        this.temId = temId;
    }

    public Long getTemId() {
        return temId;
    }

    public void setTemId(Long temId) {
        this.temId = temId;
    }

    public String getTemDenomempleo() {
        return temDenomempleo;
    }

    public void setTemDenomempleo(String temDenomempleo) {
        this.temDenomempleo = temDenomempleo;
    }

    public String getTemCodigo() {
        return temCodigo;
    }

    public void setTemCodigo(String temCodigo) {
        this.temCodigo = temCodigo;
    }

    public String getTemGrado() {
        return temGrado;
    }

    public void setTemGrado(String temGrado) {
        this.temGrado = temGrado;
    }

    public String getTemTipodecargo() {
        return temTipodecargo;
    }

    public void setTemTipodecargo(String temTipodecargo) {
        this.temTipodecargo = temTipodecargo;
    }

    public String getTemNiveljerarquico() {
        return temNiveljerarquico;
    }

    public void setTemNiveljerarquico(String temNiveljerarquico) {
        this.temNiveljerarquico = temNiveljerarquico;
    }

    public String getTemDepestrucorg() {
        return temDepestrucorg;
    }

    public void setTemDepestrucorg(String temDepestrucorg) {
        this.temDepestrucorg = temDepestrucorg;
    }

    public String getTemAreafunctrabajo() {
        return temAreafunctrabajo;
    }

    public void setTemAreafunctrabajo(String temAreafunctrabajo) {
        this.temAreafunctrabajo = temAreafunctrabajo;
    }

    public String getTemTipodependencia() {
        return temTipodependencia;
    }

    public void setTemTipodependencia(String temTipodependencia) {
        this.temTipodependencia = temTipodependencia;
    }

    public String getTemTipodocumento() {
        return temTipodocumento;
    }

    public void setTemTipodocumento(String temTipodocumento) {
        this.temTipodocumento = temTipodocumento;
    }

    public String getTemNumdocumento() {
        return temNumdocumento;
    }

    public void setTemNumdocumento(String temNumdocumento) {
        this.temNumdocumento = temNumdocumento;
    }

    public String getTemNombres() {
        return temNombres;
    }

    public void setTemNombres(String temNombres) {
        this.temNombres = temNombres;
    }

    public String getTemPrimerapellido() {
        return temPrimerapellido;
    }

    public void setTemPrimerapellido(String temPrimerapellido) {
        this.temPrimerapellido = temPrimerapellido;
    }

    public String getTemSegundoapellido() {
        return temSegundoapellido;
    }

    public void setTemSegundoapellido(String temSegundoapellido) {
        this.temSegundoapellido = temSegundoapellido;
    }

    public String getTemConteo() {
        return temConteo;
    }

    public void setTemConteo(String temConteo) {
        this.temConteo = temConteo;
    }

    public String getTemVacantedef1() {
        return temVacantedef1;
    }

    public void setTemVacantedef1(String temVacantedef1) {
        this.temVacantedef1 = temVacantedef1;
    }

    public String getTemVacantedef2() {
        return temVacantedef2;
    }

    public void setTemVacantedef2(String temVacantedef2) {
        this.temVacantedef2 = temVacantedef2;
    }

    public String getTemVacantettem1() {
        return temVacantettem1;
    }

    public void setTemVacantettem1(String temVacantettem1) {
        this.temVacantettem1 = temVacantettem1;
    }

    public String getTemVacantettem2() {
        return temVacantettem2;
    }

    public void setTemVacantettem2(String temVacantettem2) {
        this.temVacantettem2 = temVacantettem2;
    }

    public String getTemFechaingresoent() {
        return temFechaingresoent;
    }

    public void setTemFechaingresoent(String temFechaingresoent) {
        this.temFechaingresoent = temFechaingresoent;
    }

    public String getTemTipoactoadtivo() {
        return temTipoactoadtivo;
    }

    public void setTemTipoactoadtivo(String temTipoactoadtivo) {
        this.temTipoactoadtivo = temTipoactoadtivo;
    }

    public String getTemNumactoadtivo() {
        return temNumactoadtivo;
    }

    public void setTemNumactoadtivo(String temNumactoadtivo) {
        this.temNumactoadtivo = temNumactoadtivo;
    }

    public String getTemFechaactoadtivo() {
        return temFechaactoadtivo;
    }

    public void setTemFechaactoadtivo(String temFechaactoadtivo) {
        this.temFechaactoadtivo = temFechaactoadtivo;
    }

    public String getTemFormavinculacion() {
        return temFormavinculacion;
    }

    public void setTemFormavinculacion(String temFormavinculacion) {
        this.temFormavinculacion = temFormavinculacion;
    }

    public String getTemFechanacimiento() {
        return temFechanacimiento;
    }

    public void setTemFechanacimiento(String temFechanacimiento) {
        this.temFechanacimiento = temFechanacimiento;
    }

    public String getTemIdentidadgenero() {
        return temIdentidadgenero;
    }

    public void setTemIdentidadgenero(String temIdentidadgenero) {
        this.temIdentidadgenero = temIdentidadgenero;
    }

    public String getTemM() {
        return temM;
    }

    public void setTemM(String temM) {
        this.temM = temM;
    }

    public String getTemF() {
        return temF;
    }

    public void setTemF(String temF) {
        this.temF = temF;
    }

    public String getTemT() {
        return temT;
    }

    public void setTemT(String temT) {
        this.temT = temT;
    }

    public String getTemCabezafamilia() {
        return temCabezafamilia;
    }

    public void setTemCabezafamilia(String temCabezafamilia) {
        this.temCabezafamilia = temCabezafamilia;
    }

    public String getTemDiscapacidadfisica() {
        return temDiscapacidadfisica;
    }

    public void setTemDiscapacidadfisica(String temDiscapacidadfisica) {
        this.temDiscapacidadfisica = temDiscapacidadfisica;
    }

    public String getTemGrupoetnico() {
        return temGrupoetnico;
    }

    public void setTemGrupoetnico(String temGrupoetnico) {
        this.temGrupoetnico = temGrupoetnico;
    }

    public String getTemSituacionadtivafn() {
        return temSituacionadtivafn;
    }

    public void setTemSituacionadtivafn(String temSituacionadtivafn) {
        this.temSituacionadtivafn = temSituacionadtivafn;
    }

    public String getTemCalificacionobtenida() {
        return temCalificacionobtenida;
    }

    public void setTemCalificacionobtenida(String temCalificacionobtenida) {
        this.temCalificacionobtenida = temCalificacionobtenida;
    }

    public String getTemAsignacionbasica() {
        return temAsignacionbasica;
    }

    public void setTemAsignacionbasica(String temAsignacionbasica) {
        this.temAsignacionbasica = temAsignacionbasica;
    }

    public String getTemGastosrepresentacion() {
        return temGastosrepresentacion;
    }

    public void setTemGastosrepresentacion(String temGastosrepresentacion) {
        this.temGastosrepresentacion = temGastosrepresentacion;
    }

    public String getTemPorcgastosrepresentacion() {
        return temPorcgastosrepresentacion;
    }

    public void setTemPorcgastosrepresentacion(String temPorcgastosrepresentacion) {
        this.temPorcgastosrepresentacion = temPorcgastosrepresentacion;
    }

    public String getTemPrimatecnica() {
        return temPrimatecnica;
    }

    public void setTemPrimatecnica(String temPrimatecnica) {
        this.temPrimatecnica = temPrimatecnica;
    }

    public String getTemPorcprimatecnica() {
        return temPorcprimatecnica;
    }

    public void setTemPorcprimatecnica(String temPorcprimatecnica) {
        this.temPorcprimatecnica = temPorcprimatecnica;
    }

    public String getTemNivelescolaridad() {
        return temNivelescolaridad;
    }

    public void setTemNivelescolaridad(String temNivelescolaridad) {
        this.temNivelescolaridad = temNivelescolaridad;
    }

    public String getTemTitulopregrado() {
        return temTitulopregrado;
    }

    public void setTemTitulopregrado(String temTitulopregrado) {
        this.temTitulopregrado = temTitulopregrado;
    }

    public String getTemTituloposgrado() {
        return temTituloposgrado;
    }

    public void setTemTituloposgrado(String temTituloposgrado) {
        this.temTituloposgrado = temTituloposgrado;
    }

    public String getTemOtrotitulopregrado() {
        return temOtrotitulopregrado;
    }

    public void setTemOtrotitulopregrado(String temOtrotitulopregrado) {
        this.temOtrotitulopregrado = temOtrotitulopregrado;
    }

    public String getTemPertenecesindicato() {
        return temPertenecesindicato;
    }

    public void setTemPertenecesindicato(String temPertenecesindicato) {
        this.temPertenecesindicato = temPertenecesindicato;
    }

    public String getTemOrganizacionsindical() {
        return temOrganizacionsindical;
    }

    public void setTemOrganizacionsindical(String temOrganizacionsindical) {
        this.temOrganizacionsindical = temOrganizacionsindical;
    }

    public String getTemFechaafiliacion() {
        return temFechaafiliacion;
    }

    public void setTemFechaafiliacion(String temFechaafiliacion) {
        this.temFechaafiliacion = temFechaafiliacion;
    }

    public String getTemTipovinculacion() {
        return temTipovinculacion;
    }

    public void setTemTipovinculacion(String temTipovinculacion) {
        this.temTipovinculacion = temTipovinculacion;
    }

    public String getTemDiasotorgadosmes() {
        return temDiasotorgadosmes;
    }

    public void setTemDiasotorgadosmes(String temDiasotorgadosmes) {
        this.temDiasotorgadosmes = temDiasotorgadosmes;
    }

    public String getTemJustificacionpermiso() {
        return temJustificacionpermiso;
    }

    public void setTemJustificacionpermiso(String temJustificacionpermiso) {
        this.temJustificacionpermiso = temJustificacionpermiso;
    }

    public Integer getTemPorplanta() {
        return temPorplanta;
    }

    public void setTemPorplanta(Integer temPorplanta) {
        this.temPorplanta = temPorplanta;
    }

    public Date getTemFechaing() {
        return temFechaing;
    }

    public void setTemFechaing(Date temFechaing) {
        this.temFechaing = temFechaing;
    }

    public Date getTemFechanac() {
        return temFechanac;
    }

    public void setTemFechanac(Date temFechanac) {
        this.temFechanac = temFechanac;
    }

    public SysRegistrocarga getLgregId() {
        return lgregId;
    }

    public void setLgregId(SysRegistrocarga lgregId) {
        this.lgregId = lgregId;
    }

    public ThmRfFormavinculacion getForId() {
        return forId;
    }

    public void setForId(ThmRfFormavinculacion forId) {
        this.forId = forId;
    }

    public ThmRfNivelescolaridad getEneId() {
        return eneId;
    }

    public void setEneId(ThmRfNivelescolaridad eneId) {
        this.eneId = eneId;
    }

    public ThmRfNiveljerarquico getEnjId() {
        return enjId;
    }

    public void setEnjId(ThmRfNiveljerarquico enjId) {
        this.enjId = enjId;
    }

    public ThmRfTipocargo getEtcId() {
        return etcId;
    }

    public void setEtcId(ThmRfTipocargo etcId) {
        this.etcId = etcId;
    }

    public ThmRfTipodependencia getEtdId() {
        return etdId;
    }

    public void setEtdId(ThmRfTipodependencia etdId) {
        this.etdId = etdId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (temId != null ? temId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ThmTemporal)) {
            return false;
        }
        ThmTemporal other = (ThmTemporal) object;
        return !((this.temId == null && other.temId != null) || (this.temId != null && !this.temId.equals(other.temId)));
    }

    @Override
    public String toString() {
        return "com.veeduria.dao.ThmTemporal[ temId=" + temId + " ]";
    }
    
}
