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
 * @author luz
 */
@Entity
@Table(name = "thm_empleados")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ThmEmpleados.findAll", query = "SELECT t FROM ThmEmpleados t"),
    @NamedQuery(name = "ThmEmpleados.findByEmpId", query = "SELECT t FROM ThmEmpleados t WHERE t.empId = :empId"),
    @NamedQuery(name = "ThmEmpleados.findByEmpDenomempleo", query = "SELECT t FROM ThmEmpleados t WHERE t.empDenomempleo = :empDenomempleo"),
    @NamedQuery(name = "ThmEmpleados.findByEmpCodigo", query = "SELECT t FROM ThmEmpleados t WHERE t.empCodigo = :empCodigo"),
    @NamedQuery(name = "ThmEmpleados.findByEmpGrado", query = "SELECT t FROM ThmEmpleados t WHERE t.empGrado = :empGrado"),
    @NamedQuery(name = "ThmEmpleados.findByEmpTipodecargo", query = "SELECT t FROM ThmEmpleados t WHERE t.empTipodecargo = :empTipodecargo"),
    @NamedQuery(name = "ThmEmpleados.findByEmpNiveljerarquico", query = "SELECT t FROM ThmEmpleados t WHERE t.empNiveljerarquico = :empNiveljerarquico"),
    @NamedQuery(name = "ThmEmpleados.findByEmpDepestrucorg", query = "SELECT t FROM ThmEmpleados t WHERE t.empDepestrucorg = :empDepestrucorg"),
    @NamedQuery(name = "ThmEmpleados.findByEmpAreafunctrabajo", query = "SELECT t FROM ThmEmpleados t WHERE t.empAreafunctrabajo = :empAreafunctrabajo"),
    @NamedQuery(name = "ThmEmpleados.findByEmpTipodependencia", query = "SELECT t FROM ThmEmpleados t WHERE t.empTipodependencia = :empTipodependencia"),
    @NamedQuery(name = "ThmEmpleados.findByEmpTipodocumento", query = "SELECT t FROM ThmEmpleados t WHERE t.empTipodocumento = :empTipodocumento"),
    @NamedQuery(name = "ThmEmpleados.findByEmpNumdocumento", query = "SELECT t FROM ThmEmpleados t WHERE t.empNumdocumento = :empNumdocumento"),
    @NamedQuery(name = "ThmEmpleados.findByEmpNombres", query = "SELECT t FROM ThmEmpleados t WHERE t.empNombres = :empNombres"),
    @NamedQuery(name = "ThmEmpleados.findByEmpPrimerapellido", query = "SELECT t FROM ThmEmpleados t WHERE t.empPrimerapellido = :empPrimerapellido"),
    @NamedQuery(name = "ThmEmpleados.findByEmpSegundoapellido", query = "SELECT t FROM ThmEmpleados t WHERE t.empSegundoapellido = :empSegundoapellido"),
    @NamedQuery(name = "ThmEmpleados.findByEmpConteo", query = "SELECT t FROM ThmEmpleados t WHERE t.empConteo = :empConteo"),
    @NamedQuery(name = "ThmEmpleados.findByEmpVacantedef1", query = "SELECT t FROM ThmEmpleados t WHERE t.empVacantedef1 = :empVacantedef1"),
    @NamedQuery(name = "ThmEmpleados.findByEmpVacantedef2", query = "SELECT t FROM ThmEmpleados t WHERE t.empVacantedef2 = :empVacantedef2"),
    @NamedQuery(name = "ThmEmpleados.findByEmpVacantetemp1", query = "SELECT t FROM ThmEmpleados t WHERE t.empVacantetemp1 = :empVacantetemp1"),
    @NamedQuery(name = "ThmEmpleados.findByEmpVacantetemp2", query = "SELECT t FROM ThmEmpleados t WHERE t.empVacantetemp2 = :empVacantetemp2"),
    @NamedQuery(name = "ThmEmpleados.findByEmpFechaingresoent", query = "SELECT t FROM ThmEmpleados t WHERE t.empFechaingresoent = :empFechaingresoent"),
    @NamedQuery(name = "ThmEmpleados.findByEmpTipoactoadtivo", query = "SELECT t FROM ThmEmpleados t WHERE t.empTipoactoadtivo = :empTipoactoadtivo"),
    @NamedQuery(name = "ThmEmpleados.findByEmpNumactoadtivo", query = "SELECT t FROM ThmEmpleados t WHERE t.empNumactoadtivo = :empNumactoadtivo"),
    @NamedQuery(name = "ThmEmpleados.findByEmpFechaactoadtivo", query = "SELECT t FROM ThmEmpleados t WHERE t.empFechaactoadtivo = :empFechaactoadtivo"),
    @NamedQuery(name = "ThmEmpleados.findByEmpFechaposesion", query = "SELECT t FROM ThmEmpleados t WHERE t.empFechaposesion = :empFechaposesion"),
    @NamedQuery(name = "ThmEmpleados.findByEmpFormavinculacion", query = "SELECT t FROM ThmEmpleados t WHERE t.empFormavinculacion = :empFormavinculacion"),
    @NamedQuery(name = "ThmEmpleados.findByEmpFechanacimiento", query = "SELECT t FROM ThmEmpleados t WHERE t.empFechanacimiento = :empFechanacimiento"),
    @NamedQuery(name = "ThmEmpleados.findByEmpIdentidadgenero", query = "SELECT t FROM ThmEmpleados t WHERE t.empIdentidadgenero = :empIdentidadgenero"),
    @NamedQuery(name = "ThmEmpleados.findByEmpM", query = "SELECT t FROM ThmEmpleados t WHERE t.empM = :empM"),
    @NamedQuery(name = "ThmEmpleados.findByEmpF", query = "SELECT t FROM ThmEmpleados t WHERE t.empF = :empF"),
    @NamedQuery(name = "ThmEmpleados.findByEmpT", query = "SELECT t FROM ThmEmpleados t WHERE t.empT = :empT"),
    @NamedQuery(name = "ThmEmpleados.findByEmpCabezafamilia", query = "SELECT t FROM ThmEmpleados t WHERE t.empCabezafamilia = :empCabezafamilia"),
    @NamedQuery(name = "ThmEmpleados.findByEmpDiscapacidadfisica", query = "SELECT t FROM ThmEmpleados t WHERE t.empDiscapacidadfisica = :empDiscapacidadfisica"),
    @NamedQuery(name = "ThmEmpleados.findByEmpGrupoetnico", query = "SELECT t FROM ThmEmpleados t WHERE t.empGrupoetnico = :empGrupoetnico"),
    @NamedQuery(name = "ThmEmpleados.findByEmpSituacionadtivafn", query = "SELECT t FROM ThmEmpleados t WHERE t.empSituacionadtivafn = :empSituacionadtivafn"),
    @NamedQuery(name = "ThmEmpleados.findByEmpCalificacionobtenida", query = "SELECT t FROM ThmEmpleados t WHERE t.empCalificacionobtenida = :empCalificacionobtenida"),
    @NamedQuery(name = "ThmEmpleados.findByEmpAsignacionbasica", query = "SELECT t FROM ThmEmpleados t WHERE t.empAsignacionbasica = :empAsignacionbasica"),
    @NamedQuery(name = "ThmEmpleados.findByEmpGastosrepresentacion", query = "SELECT t FROM ThmEmpleados t WHERE t.empGastosrepresentacion = :empGastosrepresentacion"),
    @NamedQuery(name = "ThmEmpleados.findByEmpPorcgastosrepresentacion", query = "SELECT t FROM ThmEmpleados t WHERE t.empPorcgastosrepresentacion = :empPorcgastosrepresentacion"),
    @NamedQuery(name = "ThmEmpleados.findByEmpPrimatecnica", query = "SELECT t FROM ThmEmpleados t WHERE t.empPrimatecnica = :empPrimatecnica"),
    @NamedQuery(name = "ThmEmpleados.findByEmpPorcprimatecnica", query = "SELECT t FROM ThmEmpleados t WHERE t.empPorcprimatecnica = :empPorcprimatecnica"),
    @NamedQuery(name = "ThmEmpleados.findByEmpNivelescolaridad", query = "SELECT t FROM ThmEmpleados t WHERE t.empNivelescolaridad = :empNivelescolaridad"),
    @NamedQuery(name = "ThmEmpleados.findByEmpTitulopregrado", query = "SELECT t FROM ThmEmpleados t WHERE t.empTitulopregrado = :empTitulopregrado"),
    @NamedQuery(name = "ThmEmpleados.findByEmpTituloposgrado", query = "SELECT t FROM ThmEmpleados t WHERE t.empTituloposgrado = :empTituloposgrado"),
    @NamedQuery(name = "ThmEmpleados.findByEmpOtrotitulopregrado", query = "SELECT t FROM ThmEmpleados t WHERE t.empOtrotitulopregrado = :empOtrotitulopregrado"),
    @NamedQuery(name = "ThmEmpleados.findByEmpPertenecesindicato", query = "SELECT t FROM ThmEmpleados t WHERE t.empPertenecesindicato = :empPertenecesindicato"),
    @NamedQuery(name = "ThmEmpleados.findByEmpOrganizacionsindical", query = "SELECT t FROM ThmEmpleados t WHERE t.empOrganizacionsindical = :empOrganizacionsindical"),
    @NamedQuery(name = "ThmEmpleados.findByEmpFechaafiliacion", query = "SELECT t FROM ThmEmpleados t WHERE t.empFechaafiliacion = :empFechaafiliacion"),
    @NamedQuery(name = "ThmEmpleados.findByEmpTipovinculacion", query = "SELECT t FROM ThmEmpleados t WHERE t.empTipovinculacion = :empTipovinculacion"),
    @NamedQuery(name = "ThmEmpleados.findByEmpDiasotorgadosmes", query = "SELECT t FROM ThmEmpleados t WHERE t.empDiasotorgadosmes = :empDiasotorgadosmes"),
    @NamedQuery(name = "ThmEmpleados.findByEmpJustificacionpermiso", query = "SELECT t FROM ThmEmpleados t WHERE t.empJustificacionpermiso = :empJustificacionpermiso"),
    @NamedQuery(name = "ThmEmpleados.findByEmpFechanac", query = "SELECT t FROM ThmEmpleados t WHERE t.empFechanac = :empFechanac"),
    @NamedQuery(name = "ThmEmpleados.findByEmpFechaing", query = "SELECT t FROM ThmEmpleados t WHERE t.empFechaing = :empFechaing"),
    @NamedQuery(name = "ThmEmpleados.findByEmpFechaingtexto", query = "SELECT t FROM ThmEmpleados t WHERE t.empFechaingtexto = :empFechaingtexto"),
    @NamedQuery(name = "ThmEmpleados.findByEmpFechanactexto", query = "SELECT t FROM ThmEmpleados t WHERE t.empFechanactexto = :empFechanactexto")})
public class ThmEmpleados implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "emp_id")
    private Long empId;
    @Size(max = 1500)
    @Column(name = "emp_denomempleo")
    private String empDenomempleo;
    @Size(max = 500)
    @Column(name = "emp_codigo")
    private String empCodigo;
    @Size(max = 500)
    @Column(name = "emp_grado")
    private String empGrado;
    @Size(max = 1500)
    @Column(name = "emp_tipodecargo")
    private String empTipodecargo;
    @Size(max = 1500)
    @Column(name = "emp_niveljerarquico")
    private String empNiveljerarquico;
    @Size(max = 1500)
    @Column(name = "emp_depestrucorg")
    private String empDepestrucorg;
    @Size(max = 1500)
    @Column(name = "emp_areafunctrabajo")
    private String empAreafunctrabajo;
    @Size(max = 1500)
    @Column(name = "emp_tipodependencia")
    private String empTipodependencia;
    @Size(max = 50)
    @Column(name = "emp_tipodocumento")
    private String empTipodocumento;
    @Size(max = 100)
    @Column(name = "emp_numdocumento")
    private String empNumdocumento;
    @Size(max = 1500)
    @Column(name = "emp_nombres")
    private String empNombres;
    @Size(max = 1500)
    @Column(name = "emp_primerapellido")
    private String empPrimerapellido;
    @Size(max = 1500)
    @Column(name = "emp_segundoapellido")
    private String empSegundoapellido;
    @Size(max = 1500)
    @Column(name = "emp_conteo")
    private String empConteo;
    @Size(max = 1500)
    @Column(name = "emp_vacantedef1")
    private String empVacantedef1;
    @Size(max = 1500)
    @Column(name = "emp_vacantedef2")
    private String empVacantedef2;
    @Size(max = 1500)
    @Column(name = "emp_vacantetemp1")
    private String empVacantetemp1;
    @Size(max = 1500)
    @Column(name = "emp_vacantetemp2")
    private String empVacantetemp2;
    @Size(max = 1500)
    @Column(name = "emp_fechaingresoent")
    private String empFechaingresoent;
    @Size(max = 1500)
    @Column(name = "emp_tipoactoadtivo")
    private String empTipoactoadtivo;
    @Size(max = 100)
    @Column(name = "emp_numactoadtivo")
    private String empNumactoadtivo;
    @Size(max = 1500)
    @Column(name = "emp_fechaactoadtivo")
    private String empFechaactoadtivo;
    @Size(max = 1500)
    @Column(name = "emp_fechaposesion")
    private String empFechaposesion;
    @Size(max = 1500)
    @Column(name = "emp_formavinculacion")
    private String empFormavinculacion;
    @Size(max = 1500)
    @Column(name = "emp_fechanacimiento")
    private String empFechanacimiento;
    @Size(max = 1500)
    @Column(name = "emp_identidadgenero")
    private String empIdentidadgenero;
    @Size(max = 50)
    @Column(name = "emp_m")
    private String empM;
    @Size(max = 50)
    @Column(name = "emp_f")
    private String empF;
    @Size(max = 50)
    @Column(name = "emp_t")
    private String empT;
    @Size(max = 1500)
    @Column(name = "emp_cabezafamilia")
    private String empCabezafamilia;
    @Size(max = 1500)
    @Column(name = "emp_discapacidadfisica")
    private String empDiscapacidadfisica;
    @Size(max = 1500)
    @Column(name = "emp_grupoetnico")
    private String empGrupoetnico;
    @Size(max = 1500)
    @Column(name = "emp_situacionadtivafn")
    private String empSituacionadtivafn;
    @Size(max = 1500)
    @Column(name = "emp_calificacionobtenida")
    private String empCalificacionobtenida;
    @Size(max = 1500)
    @Column(name = "emp_asignacionbasica")
    private String empAsignacionbasica;
    @Size(max = 1500)
    @Column(name = "emp_gastosrepresentacion")
    private String empGastosrepresentacion;
    @Size(max = 1500)
    @Column(name = "emp_porcgastosrepresentacion")
    private String empPorcgastosrepresentacion;
    @Size(max = 1500)
    @Column(name = "emp_primatecnica")
    private String empPrimatecnica;
    @Size(max = 1500)
    @Column(name = "emp_porcprimatecnica")
    private String empPorcprimatecnica;
    @Size(max = 1500)
    @Column(name = "emp_nivelescolaridad")
    private String empNivelescolaridad;
    @Size(max = 1500)
    @Column(name = "emp_titulopregrado")
    private String empTitulopregrado;
    @Size(max = 1500)
    @Column(name = "emp_tituloposgrado")
    private String empTituloposgrado;
    @Size(max = 1500)
    @Column(name = "emp_otrotitulopregrado")
    private String empOtrotitulopregrado;
    @Size(max = 1500)
    @Column(name = "emp_pertenecesindicato")
    private String empPertenecesindicato;
    @Size(max = 1500)
    @Column(name = "emp_organizacionsindical")
    private String empOrganizacionsindical;
    @Size(max = 1500)
    @Column(name = "emp_fechaafiliacion")
    private String empFechaafiliacion;
    @Size(max = 1500)
    @Column(name = "emp_tipovinculacion")
    private String empTipovinculacion;
    @Size(max = 1500)
    @Column(name = "emp_diasotorgadosmes")
    private String empDiasotorgadosmes;
    @Size(max = 1500)
    @Column(name = "emp_justificacionpermiso")
    private String empJustificacionpermiso;
    @Column(name = "emp_fechanac")
    @Temporal(TemporalType.DATE)
    private Date empFechanac;
    @Column(name = "emp_fechaing")
    @Temporal(TemporalType.DATE)
    private Date empFechaing;
    @Size(max = 1000)
    @Column(name = "emp_fechaingtexto")
    private String empFechaingtexto;
    @Size(max = 1000)
    @Column(name = "emp_fechanactexto")
    private String empFechanactexto;
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

    public ThmEmpleados() {
    }

    public ThmEmpleados(Long empId) {
        this.empId = empId;
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getEmpDenomempleo() {
        return empDenomempleo;
    }

    public void setEmpDenomempleo(String empDenomempleo) {
        this.empDenomempleo = empDenomempleo;
    }

    public String getEmpCodigo() {
        return empCodigo;
    }

    public void setEmpCodigo(String empCodigo) {
        this.empCodigo = empCodigo;
    }

    public String getEmpGrado() {
        return empGrado;
    }

    public void setEmpGrado(String empGrado) {
        this.empGrado = empGrado;
    }

    public String getEmpTipodecargo() {
        return empTipodecargo;
    }

    public void setEmpTipodecargo(String empTipodecargo) {
        this.empTipodecargo = empTipodecargo;
    }

    public String getEmpNiveljerarquico() {
        return empNiveljerarquico;
    }

    public void setEmpNiveljerarquico(String empNiveljerarquico) {
        this.empNiveljerarquico = empNiveljerarquico;
    }

    public String getEmpDepestrucorg() {
        return empDepestrucorg;
    }

    public void setEmpDepestrucorg(String empDepestrucorg) {
        this.empDepestrucorg = empDepestrucorg;
    }

    public String getEmpAreafunctrabajo() {
        return empAreafunctrabajo;
    }

    public void setEmpAreafunctrabajo(String empAreafunctrabajo) {
        this.empAreafunctrabajo = empAreafunctrabajo;
    }

    public String getEmpTipodependencia() {
        return empTipodependencia;
    }

    public void setEmpTipodependencia(String empTipodependencia) {
        this.empTipodependencia = empTipodependencia;
    }

    public String getEmpTipodocumento() {
        return empTipodocumento;
    }

    public void setEmpTipodocumento(String empTipodocumento) {
        this.empTipodocumento = empTipodocumento;
    }

    public String getEmpNumdocumento() {
        return empNumdocumento;
    }

    public void setEmpNumdocumento(String empNumdocumento) {
        this.empNumdocumento = empNumdocumento;
    }

    public String getEmpNombres() {
        return empNombres;
    }

    public void setEmpNombres(String empNombres) {
        this.empNombres = empNombres;
    }

    public String getEmpPrimerapellido() {
        return empPrimerapellido;
    }

    public void setEmpPrimerapellido(String empPrimerapellido) {
        this.empPrimerapellido = empPrimerapellido;
    }

    public String getEmpSegundoapellido() {
        return empSegundoapellido;
    }

    public void setEmpSegundoapellido(String empSegundoapellido) {
        this.empSegundoapellido = empSegundoapellido;
    }

    public String getEmpConteo() {
        return empConteo;
    }

    public void setEmpConteo(String empConteo) {
        this.empConteo = empConteo;
    }

    public String getEmpVacantedef1() {
        return empVacantedef1;
    }

    public void setEmpVacantedef1(String empVacantedef1) {
        this.empVacantedef1 = empVacantedef1;
    }

    public String getEmpVacantedef2() {
        return empVacantedef2;
    }

    public void setEmpVacantedef2(String empVacantedef2) {
        this.empVacantedef2 = empVacantedef2;
    }

    public String getEmpVacantetemp1() {
        return empVacantetemp1;
    }

    public void setEmpVacantetemp1(String empVacantetemp1) {
        this.empVacantetemp1 = empVacantetemp1;
    }

    public String getEmpVacantetemp2() {
        return empVacantetemp2;
    }

    public void setEmpVacantetemp2(String empVacantetemp2) {
        this.empVacantetemp2 = empVacantetemp2;
    }

    public String getEmpFechaingresoent() {
        return empFechaingresoent;
    }

    public void setEmpFechaingresoent(String empFechaingresoent) {
        this.empFechaingresoent = empFechaingresoent;
    }

    public String getEmpTipoactoadtivo() {
        return empTipoactoadtivo;
    }

    public void setEmpTipoactoadtivo(String empTipoactoadtivo) {
        this.empTipoactoadtivo = empTipoactoadtivo;
    }

    public String getEmpNumactoadtivo() {
        return empNumactoadtivo;
    }

    public void setEmpNumactoadtivo(String empNumactoadtivo) {
        this.empNumactoadtivo = empNumactoadtivo;
    }

    public String getEmpFechaactoadtivo() {
        return empFechaactoadtivo;
    }

    public void setEmpFechaactoadtivo(String empFechaactoadtivo) {
        this.empFechaactoadtivo = empFechaactoadtivo;
    }

    public String getEmpFechaposesion() {
        return empFechaposesion;
    }

    public void setEmpFechaposesion(String empFechaposesion) {
        this.empFechaposesion = empFechaposesion;
    }

    public String getEmpFormavinculacion() {
        return empFormavinculacion;
    }

    public void setEmpFormavinculacion(String empFormavinculacion) {
        this.empFormavinculacion = empFormavinculacion;
    }

    public String getEmpFechanacimiento() {
        return empFechanacimiento;
    }

    public void setEmpFechanacimiento(String empFechanacimiento) {
        this.empFechanacimiento = empFechanacimiento;
    }

    public String getEmpIdentidadgenero() {
        return empIdentidadgenero;
    }

    public void setEmpIdentidadgenero(String empIdentidadgenero) {
        this.empIdentidadgenero = empIdentidadgenero;
    }

    public String getEmpM() {
        return empM;
    }

    public void setEmpM(String empM) {
        this.empM = empM;
    }

    public String getEmpF() {
        return empF;
    }

    public void setEmpF(String empF) {
        this.empF = empF;
    }

    public String getEmpT() {
        return empT;
    }

    public void setEmpT(String empT) {
        this.empT = empT;
    }

    public String getEmpCabezafamilia() {
        return empCabezafamilia;
    }

    public void setEmpCabezafamilia(String empCabezafamilia) {
        this.empCabezafamilia = empCabezafamilia;
    }

    public String getEmpDiscapacidadfisica() {
        return empDiscapacidadfisica;
    }

    public void setEmpDiscapacidadfisica(String empDiscapacidadfisica) {
        this.empDiscapacidadfisica = empDiscapacidadfisica;
    }

    public String getEmpGrupoetnico() {
        return empGrupoetnico;
    }

    public void setEmpGrupoetnico(String empGrupoetnico) {
        this.empGrupoetnico = empGrupoetnico;
    }

    public String getEmpSituacionadtivafn() {
        return empSituacionadtivafn;
    }

    public void setEmpSituacionadtivafn(String empSituacionadtivafn) {
        this.empSituacionadtivafn = empSituacionadtivafn;
    }

    public String getEmpCalificacionobtenida() {
        return empCalificacionobtenida;
    }

    public void setEmpCalificacionobtenida(String empCalificacionobtenida) {
        this.empCalificacionobtenida = empCalificacionobtenida;
    }

    public String getEmpAsignacionbasica() {
        return empAsignacionbasica;
    }

    public void setEmpAsignacionbasica(String empAsignacionbasica) {
        this.empAsignacionbasica = empAsignacionbasica;
    }

    public String getEmpGastosrepresentacion() {
        return empGastosrepresentacion;
    }

    public void setEmpGastosrepresentacion(String empGastosrepresentacion) {
        this.empGastosrepresentacion = empGastosrepresentacion;
    }

    public String getEmpPorcgastosrepresentacion() {
        return empPorcgastosrepresentacion;
    }

    public void setEmpPorcgastosrepresentacion(String empPorcgastosrepresentacion) {
        this.empPorcgastosrepresentacion = empPorcgastosrepresentacion;
    }

    public String getEmpPrimatecnica() {
        return empPrimatecnica;
    }

    public void setEmpPrimatecnica(String empPrimatecnica) {
        this.empPrimatecnica = empPrimatecnica;
    }

    public String getEmpPorcprimatecnica() {
        return empPorcprimatecnica;
    }

    public void setEmpPorcprimatecnica(String empPorcprimatecnica) {
        this.empPorcprimatecnica = empPorcprimatecnica;
    }

    public String getEmpNivelescolaridad() {
        return empNivelescolaridad;
    }

    public void setEmpNivelescolaridad(String empNivelescolaridad) {
        this.empNivelescolaridad = empNivelescolaridad;
    }

    public String getEmpTitulopregrado() {
        return empTitulopregrado;
    }

    public void setEmpTitulopregrado(String empTitulopregrado) {
        this.empTitulopregrado = empTitulopregrado;
    }

    public String getEmpTituloposgrado() {
        return empTituloposgrado;
    }

    public void setEmpTituloposgrado(String empTituloposgrado) {
        this.empTituloposgrado = empTituloposgrado;
    }

    public String getEmpOtrotitulopregrado() {
        return empOtrotitulopregrado;
    }

    public void setEmpOtrotitulopregrado(String empOtrotitulopregrado) {
        this.empOtrotitulopregrado = empOtrotitulopregrado;
    }

    public String getEmpPertenecesindicato() {
        return empPertenecesindicato;
    }

    public void setEmpPertenecesindicato(String empPertenecesindicato) {
        this.empPertenecesindicato = empPertenecesindicato;
    }

    public String getEmpOrganizacionsindical() {
        return empOrganizacionsindical;
    }

    public void setEmpOrganizacionsindical(String empOrganizacionsindical) {
        this.empOrganizacionsindical = empOrganizacionsindical;
    }

    public String getEmpFechaafiliacion() {
        return empFechaafiliacion;
    }

    public void setEmpFechaafiliacion(String empFechaafiliacion) {
        this.empFechaafiliacion = empFechaafiliacion;
    }

    public String getEmpTipovinculacion() {
        return empTipovinculacion;
    }

    public void setEmpTipovinculacion(String empTipovinculacion) {
        this.empTipovinculacion = empTipovinculacion;
    }

    public String getEmpDiasotorgadosmes() {
        return empDiasotorgadosmes;
    }

    public void setEmpDiasotorgadosmes(String empDiasotorgadosmes) {
        this.empDiasotorgadosmes = empDiasotorgadosmes;
    }

    public String getEmpJustificacionpermiso() {
        return empJustificacionpermiso;
    }

    public void setEmpJustificacionpermiso(String empJustificacionpermiso) {
        this.empJustificacionpermiso = empJustificacionpermiso;
    }

    public Date getEmpFechanac() {
        return empFechanac;
    }

    public void setEmpFechanac(Date empFechanac) {
        this.empFechanac = empFechanac;
    }

    public Date getEmpFechaing() {
        return empFechaing;
    }

    public void setEmpFechaing(Date empFechaing) {
        this.empFechaing = empFechaing;
    }

    public String getEmpFechaingtexto() {
        return empFechaingtexto;
    }

    public void setEmpFechaingtexto(String empFechaingtexto) {
        this.empFechaingtexto = empFechaingtexto;
    }

    public String getEmpFechanactexto() {
        return empFechanactexto;
    }

    public void setEmpFechanactexto(String empFechanactexto) {
        this.empFechanactexto = empFechanactexto;
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
        hash += (empId != null ? empId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ThmEmpleados)) {
            return false;
        }
        ThmEmpleados other = (ThmEmpleados) object;
        return !((this.empId == null && other.empId != null) || (this.empId != null && !this.empId.equals(other.empId)));
    }

    @Override
    public String toString() {
        return "com.veeduria.dao.ThmEmpleados[ empId=" + empId + " ]";
    }
    
}
