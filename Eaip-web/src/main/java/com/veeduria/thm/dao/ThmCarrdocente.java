/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.veeduria.thm.dao;

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
 * @author luz
 */
@Entity
@Table(name = "thm_carrdocente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ThmCarrdocente.findAll", query = "SELECT t FROM ThmCarrdocente t"),
    @NamedQuery(name = "ThmCarrdocente.findByDocId", query = "SELECT t FROM ThmCarrdocente t WHERE t.docId = :docId"),
    @NamedQuery(name = "ThmCarrdocente.findByDocDenomempleo", query = "SELECT t FROM ThmCarrdocente t WHERE t.docDenomempleo = :docDenomempleo"),
    @NamedQuery(name = "ThmCarrdocente.findByDocCodigo", query = "SELECT t FROM ThmCarrdocente t WHERE t.docCodigo = :docCodigo"),
    @NamedQuery(name = "ThmCarrdocente.findByDocGrado", query = "SELECT t FROM ThmCarrdocente t WHERE t.docGrado = :docGrado"),
    @NamedQuery(name = "ThmCarrdocente.findByDocTipodecargo", query = "SELECT t FROM ThmCarrdocente t WHERE t.docTipodecargo = :docTipodecargo"),
    @NamedQuery(name = "ThmCarrdocente.findByDocNiveljerarquico", query = "SELECT t FROM ThmCarrdocente t WHERE t.docNiveljerarquico = :docNiveljerarquico"),
    @NamedQuery(name = "ThmCarrdocente.findByDocDepestrucorg", query = "SELECT t FROM ThmCarrdocente t WHERE t.docDepestrucorg = :docDepestrucorg"),
    @NamedQuery(name = "ThmCarrdocente.findByDocAreafunctrabajo", query = "SELECT t FROM ThmCarrdocente t WHERE t.docAreafunctrabajo = :docAreafunctrabajo"),
    @NamedQuery(name = "ThmCarrdocente.findByDocTipodependencia", query = "SELECT t FROM ThmCarrdocente t WHERE t.docTipodependencia = :docTipodependencia"),
    @NamedQuery(name = "ThmCarrdocente.findByDocTipodocumento", query = "SELECT t FROM ThmCarrdocente t WHERE t.docTipodocumento = :docTipodocumento"),
    @NamedQuery(name = "ThmCarrdocente.findByDocNumdocumento", query = "SELECT t FROM ThmCarrdocente t WHERE t.docNumdocumento = :docNumdocumento"),
    @NamedQuery(name = "ThmCarrdocente.findByDocNombres", query = "SELECT t FROM ThmCarrdocente t WHERE t.docNombres = :docNombres"),
    @NamedQuery(name = "ThmCarrdocente.findByDocPrimerapellido", query = "SELECT t FROM ThmCarrdocente t WHERE t.docPrimerapellido = :docPrimerapellido"),
    @NamedQuery(name = "ThmCarrdocente.findByDocSegundoapellido", query = "SELECT t FROM ThmCarrdocente t WHERE t.docSegundoapellido = :docSegundoapellido"),
    @NamedQuery(name = "ThmCarrdocente.findByDocConteo", query = "SELECT t FROM ThmCarrdocente t WHERE t.docConteo = :docConteo"),
    @NamedQuery(name = "ThmCarrdocente.findByDocVacantedef1", query = "SELECT t FROM ThmCarrdocente t WHERE t.docVacantedef1 = :docVacantedef1"),
    @NamedQuery(name = "ThmCarrdocente.findByDocVacantedef2", query = "SELECT t FROM ThmCarrdocente t WHERE t.docVacantedef2 = :docVacantedef2"),
    @NamedQuery(name = "ThmCarrdocente.findByDocVacantetemp1", query = "SELECT t FROM ThmCarrdocente t WHERE t.docVacantetemp1 = :docVacantetemp1"),
    @NamedQuery(name = "ThmCarrdocente.findByDocVacantetemp2", query = "SELECT t FROM ThmCarrdocente t WHERE t.docVacantetemp2 = :docVacantetemp2"),
    @NamedQuery(name = "ThmCarrdocente.findByDocFechaingresoent", query = "SELECT t FROM ThmCarrdocente t WHERE t.docFechaingresoent = :docFechaingresoent"),
    @NamedQuery(name = "ThmCarrdocente.findByDocTipoactoadtivo", query = "SELECT t FROM ThmCarrdocente t WHERE t.docTipoactoadtivo = :docTipoactoadtivo"),
    @NamedQuery(name = "ThmCarrdocente.findByDocNumactoadtivo", query = "SELECT t FROM ThmCarrdocente t WHERE t.docNumactoadtivo = :docNumactoadtivo"),
    @NamedQuery(name = "ThmCarrdocente.findByDocFechaactoadtivo", query = "SELECT t FROM ThmCarrdocente t WHERE t.docFechaactoadtivo = :docFechaactoadtivo"),
    @NamedQuery(name = "ThmCarrdocente.findByDocFormavinculacion", query = "SELECT t FROM ThmCarrdocente t WHERE t.docFormavinculacion = :docFormavinculacion"),
    @NamedQuery(name = "ThmCarrdocente.findByDocFechanacimiento", query = "SELECT t FROM ThmCarrdocente t WHERE t.docFechanacimiento = :docFechanacimiento"),
    @NamedQuery(name = "ThmCarrdocente.findByDocIdentidadgenero", query = "SELECT t FROM ThmCarrdocente t WHERE t.docIdentidadgenero = :docIdentidadgenero"),
    @NamedQuery(name = "ThmCarrdocente.findByDocM", query = "SELECT t FROM ThmCarrdocente t WHERE t.docM = :docM"),
    @NamedQuery(name = "ThmCarrdocente.findByDocF", query = "SELECT t FROM ThmCarrdocente t WHERE t.docF = :docF"),
    @NamedQuery(name = "ThmCarrdocente.findByDocT", query = "SELECT t FROM ThmCarrdocente t WHERE t.docT = :docT"),
    @NamedQuery(name = "ThmCarrdocente.findByDocCabezafamilia", query = "SELECT t FROM ThmCarrdocente t WHERE t.docCabezafamilia = :docCabezafamilia"),
    @NamedQuery(name = "ThmCarrdocente.findByDocDiscapacidadfisica", query = "SELECT t FROM ThmCarrdocente t WHERE t.docDiscapacidadfisica = :docDiscapacidadfisica"),
    @NamedQuery(name = "ThmCarrdocente.findByDocGrupoetnico", query = "SELECT t FROM ThmCarrdocente t WHERE t.docGrupoetnico = :docGrupoetnico"),
    @NamedQuery(name = "ThmCarrdocente.findByDocSituacionadtivafn", query = "SELECT t FROM ThmCarrdocente t WHERE t.docSituacionadtivafn = :docSituacionadtivafn"),
    @NamedQuery(name = "ThmCarrdocente.findByDocCalificacionobtenida", query = "SELECT t FROM ThmCarrdocente t WHERE t.docCalificacionobtenida = :docCalificacionobtenida"),
    @NamedQuery(name = "ThmCarrdocente.findByDocAsignacionbasica", query = "SELECT t FROM ThmCarrdocente t WHERE t.docAsignacionbasica = :docAsignacionbasica"),
    @NamedQuery(name = "ThmCarrdocente.findByDocGastosrepresentacion", query = "SELECT t FROM ThmCarrdocente t WHERE t.docGastosrepresentacion = :docGastosrepresentacion"),
    @NamedQuery(name = "ThmCarrdocente.findByDocPorcgastosrepresentacion", query = "SELECT t FROM ThmCarrdocente t WHERE t.docPorcgastosrepresentacion = :docPorcgastosrepresentacion"),
    @NamedQuery(name = "ThmCarrdocente.findByDocPrimatecnica", query = "SELECT t FROM ThmCarrdocente t WHERE t.docPrimatecnica = :docPrimatecnica"),
    @NamedQuery(name = "ThmCarrdocente.findByDocPorcprimatecnica", query = "SELECT t FROM ThmCarrdocente t WHERE t.docPorcprimatecnica = :docPorcprimatecnica"),
    @NamedQuery(name = "ThmCarrdocente.findByDocNivelescolaridad", query = "SELECT t FROM ThmCarrdocente t WHERE t.docNivelescolaridad = :docNivelescolaridad"),
    @NamedQuery(name = "ThmCarrdocente.findByDocTitulopregrado", query = "SELECT t FROM ThmCarrdocente t WHERE t.docTitulopregrado = :docTitulopregrado"),
    @NamedQuery(name = "ThmCarrdocente.findByDocTituloposgrado", query = "SELECT t FROM ThmCarrdocente t WHERE t.docTituloposgrado = :docTituloposgrado"),
    @NamedQuery(name = "ThmCarrdocente.findByDocOtrotitulopregrado", query = "SELECT t FROM ThmCarrdocente t WHERE t.docOtrotitulopregrado = :docOtrotitulopregrado"),
    @NamedQuery(name = "ThmCarrdocente.findByDocPertenecesindicato", query = "SELECT t FROM ThmCarrdocente t WHERE t.docPertenecesindicato = :docPertenecesindicato"),
    @NamedQuery(name = "ThmCarrdocente.findByDocOrganizacionsindical", query = "SELECT t FROM ThmCarrdocente t WHERE t.docOrganizacionsindical = :docOrganizacionsindical"),
    @NamedQuery(name = "ThmCarrdocente.findByDocFechaafiliacion", query = "SELECT t FROM ThmCarrdocente t WHERE t.docFechaafiliacion = :docFechaafiliacion"),
    @NamedQuery(name = "ThmCarrdocente.findByDocTipovinculacion", query = "SELECT t FROM ThmCarrdocente t WHERE t.docTipovinculacion = :docTipovinculacion"),
    @NamedQuery(name = "ThmCarrdocente.findByDocDiasotorgadosmes", query = "SELECT t FROM ThmCarrdocente t WHERE t.docDiasotorgadosmes = :docDiasotorgadosmes"),
    @NamedQuery(name = "ThmCarrdocente.findByDocJustificacionpermiso", query = "SELECT t FROM ThmCarrdocente t WHERE t.docJustificacionpermiso = :docJustificacionpermiso")})
public class ThmCarrdocente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "doc_id")
    private Long docId;
    @Size(max = 1500)
    @Column(name = "doc_denomempleo")
    private String docDenomempleo;
    @Size(max = 500)
    @Column(name = "doc_codigo")
    private String docCodigo;
    @Size(max = 500)
    @Column(name = "doc_grado")
    private String docGrado;
    @Size(max = 1500)
    @Column(name = "doc_tipodecargo")
    private String docTipodecargo;
    @Size(max = 1500)
    @Column(name = "doc_niveljerarquico")
    private String docNiveljerarquico;
    @Size(max = 1500)
    @Column(name = "doc_depestrucorg")
    private String docDepestrucorg;
    @Size(max = 1500)
    @Column(name = "doc_areafunctrabajo")
    private String docAreafunctrabajo;
    @Size(max = 1500)
    @Column(name = "doc_tipodependencia")
    private String docTipodependencia;
    @Size(max = 50)
    @Column(name = "doc_tipodocumento")
    private String docTipodocumento;
    @Size(max = 100)
    @Column(name = "doc_numdocumento")
    private String docNumdocumento;
    @Size(max = 1500)
    @Column(name = "doc_nombres")
    private String docNombres;
    @Size(max = 1500)
    @Column(name = "doc_primerapellido")
    private String docPrimerapellido;
    @Size(max = 1500)
    @Column(name = "doc_segundoapellido")
    private String docSegundoapellido;
    @Size(max = 1500)
    @Column(name = "doc_conteo")
    private String docConteo;
    @Size(max = 1500)
    @Column(name = "doc_vacantedef1")
    private String docVacantedef1;
    @Size(max = 1500)
    @Column(name = "doc_vacantedef2")
    private String docVacantedef2;
    @Size(max = 1500)
    @Column(name = "doc_vacantetemp1")
    private String docVacantetemp1;
    @Size(max = 1500)
    @Column(name = "doc_vacantetemp2")
    private String docVacantetemp2;
    @Size(max = 1500)
    @Column(name = "doc_fechaingresoent")
    private String docFechaingresoent;
    @Size(max = 1500)
    @Column(name = "doc_tipoactoadtivo")
    private String docTipoactoadtivo;
    @Size(max = 100)
    @Column(name = "doc_numactoadtivo")
    private String docNumactoadtivo;
    @Size(max = 1500)
    @Column(name = "doc_fechaactoadtivo")
    private String docFechaactoadtivo;
    @Size(max = 1500)
    @Column(name = "doc_formavinculacion")
    private String docFormavinculacion;
    @Size(max = 1500)
    @Column(name = "doc_fechanacimiento")
    private String docFechanacimiento;
    @Size(max = 1500)
    @Column(name = "doc_identidadgenero")
    private String docIdentidadgenero;
    @Size(max = 50)
    @Column(name = "doc_m")
    private String docM;
    @Size(max = 50)
    @Column(name = "doc_f")
    private String docF;
    @Size(max = 50)
    @Column(name = "doc_t")
    private String docT;
    @Size(max = 1500)
    @Column(name = "doc_cabezafamilia")
    private String docCabezafamilia;
    @Size(max = 1500)
    @Column(name = "doc_discapacidadfisica")
    private String docDiscapacidadfisica;
    @Size(max = 1500)
    @Column(name = "doc_grupoetnico")
    private String docGrupoetnico;
    @Size(max = 1500)
    @Column(name = "doc_situacionadtivafn")
    private String docSituacionadtivafn;
    @Size(max = 1500)
    @Column(name = "doc_calificacionobtenida")
    private String docCalificacionobtenida;
    @Size(max = 1500)
    @Column(name = "doc_asignacionbasica")
    private String docAsignacionbasica;
    @Size(max = 1500)
    @Column(name = "doc_gastosrepresentacion")
    private String docGastosrepresentacion;
    @Size(max = 1500)
    @Column(name = "doc_porcgastosrepresentacion")
    private String docPorcgastosrepresentacion;
    @Size(max = 1500)
    @Column(name = "doc_primatecnica")
    private String docPrimatecnica;
    @Size(max = 1500)
    @Column(name = "doc_porcprimatecnica")
    private String docPorcprimatecnica;
    @Size(max = 1500)
    @Column(name = "doc_nivelescolaridad")
    private String docNivelescolaridad;
    @Size(max = 1500)
    @Column(name = "doc_titulopregrado")
    private String docTitulopregrado;
    @Size(max = 1500)
    @Column(name = "doc_tituloposgrado")
    private String docTituloposgrado;
    @Size(max = 1500)
    @Column(name = "doc_otrotitulopregrado")
    private String docOtrotitulopregrado;
    @Size(max = 1500)
    @Column(name = "doc_pertenecesindicato")
    private String docPertenecesindicato;
    @Size(max = 1500)
    @Column(name = "doc_organizacionsindical")
    private String docOrganizacionsindical;
    @Size(max = 1500)
    @Column(name = "doc_fechaafiliacion")
    private String docFechaafiliacion;
    @Size(max = 1500)
    @Column(name = "doc_tipovinculacion")
    private String docTipovinculacion;
    @Size(max = 1500)
    @Column(name = "doc_diasotorgadosmes")
    private String docDiasotorgadosmes;
    @Size(max = 1500)
    @Column(name = "doc_justificacionpermiso")
    private String docJustificacionpermiso;
    @JoinColumn(name = "lgreg_id", referencedColumnName = "lgreg_id")
    @ManyToOne
    private SysRegistrocarga lgregId;

    public ThmCarrdocente() {
    }

    public ThmCarrdocente(Long docId) {
        this.docId = docId;
    }

    public Long getDocId() {
        return docId;
    }

    public void setDocId(Long docId) {
        this.docId = docId;
    }

    public String getDocDenomempleo() {
        return docDenomempleo;
    }

    public void setDocDenomempleo(String docDenomempleo) {
        this.docDenomempleo = docDenomempleo;
    }

    public String getDocCodigo() {
        return docCodigo;
    }

    public void setDocCodigo(String docCodigo) {
        this.docCodigo = docCodigo;
    }

    public String getDocGrado() {
        return docGrado;
    }

    public void setDocGrado(String docGrado) {
        this.docGrado = docGrado;
    }

    public String getDocTipodecargo() {
        return docTipodecargo;
    }

    public void setDocTipodecargo(String docTipodecargo) {
        this.docTipodecargo = docTipodecargo;
    }

    public String getDocNiveljerarquico() {
        return docNiveljerarquico;
    }

    public void setDocNiveljerarquico(String docNiveljerarquico) {
        this.docNiveljerarquico = docNiveljerarquico;
    }

    public String getDocDepestrucorg() {
        return docDepestrucorg;
    }

    public void setDocDepestrucorg(String docDepestrucorg) {
        this.docDepestrucorg = docDepestrucorg;
    }

    public String getDocAreafunctrabajo() {
        return docAreafunctrabajo;
    }

    public void setDocAreafunctrabajo(String docAreafunctrabajo) {
        this.docAreafunctrabajo = docAreafunctrabajo;
    }

    public String getDocTipodependencia() {
        return docTipodependencia;
    }

    public void setDocTipodependencia(String docTipodependencia) {
        this.docTipodependencia = docTipodependencia;
    }

    public String getDocTipodocumento() {
        return docTipodocumento;
    }

    public void setDocTipodocumento(String docTipodocumento) {
        this.docTipodocumento = docTipodocumento;
    }

    public String getDocNumdocumento() {
        return docNumdocumento;
    }

    public void setDocNumdocumento(String docNumdocumento) {
        this.docNumdocumento = docNumdocumento;
    }

    public String getDocNombres() {
        return docNombres;
    }

    public void setDocNombres(String docNombres) {
        this.docNombres = docNombres;
    }

    public String getDocPrimerapellido() {
        return docPrimerapellido;
    }

    public void setDocPrimerapellido(String docPrimerapellido) {
        this.docPrimerapellido = docPrimerapellido;
    }

    public String getDocSegundoapellido() {
        return docSegundoapellido;
    }

    public void setDocSegundoapellido(String docSegundoapellido) {
        this.docSegundoapellido = docSegundoapellido;
    }

    public String getDocConteo() {
        return docConteo;
    }

    public void setDocConteo(String docConteo) {
        this.docConteo = docConteo;
    }

    public String getDocVacantedef1() {
        return docVacantedef1;
    }

    public void setDocVacantedef1(String docVacantedef1) {
        this.docVacantedef1 = docVacantedef1;
    }

    public String getDocVacantedef2() {
        return docVacantedef2;
    }

    public void setDocVacantedef2(String docVacantedef2) {
        this.docVacantedef2 = docVacantedef2;
    }

    public String getDocVacantetemp1() {
        return docVacantetemp1;
    }

    public void setDocVacantetemp1(String docVacantetemp1) {
        this.docVacantetemp1 = docVacantetemp1;
    }

    public String getDocVacantetemp2() {
        return docVacantetemp2;
    }

    public void setDocVacantetemp2(String docVacantetemp2) {
        this.docVacantetemp2 = docVacantetemp2;
    }

    public String getDocFechaingresoent() {
        return docFechaingresoent;
    }

    public void setDocFechaingresoent(String docFechaingresoent) {
        this.docFechaingresoent = docFechaingresoent;
    }

    public String getDocTipoactoadtivo() {
        return docTipoactoadtivo;
    }

    public void setDocTipoactoadtivo(String docTipoactoadtivo) {
        this.docTipoactoadtivo = docTipoactoadtivo;
    }

    public String getDocNumactoadtivo() {
        return docNumactoadtivo;
    }

    public void setDocNumactoadtivo(String docNumactoadtivo) {
        this.docNumactoadtivo = docNumactoadtivo;
    }

    public String getDocFechaactoadtivo() {
        return docFechaactoadtivo;
    }

    public void setDocFechaactoadtivo(String docFechaactoadtivo) {
        this.docFechaactoadtivo = docFechaactoadtivo;
    }

    public String getDocFormavinculacion() {
        return docFormavinculacion;
    }

    public void setDocFormavinculacion(String docFormavinculacion) {
        this.docFormavinculacion = docFormavinculacion;
    }

    public String getDocFechanacimiento() {
        return docFechanacimiento;
    }

    public void setDocFechanacimiento(String docFechanacimiento) {
        this.docFechanacimiento = docFechanacimiento;
    }

    public String getDocIdentidadgenero() {
        return docIdentidadgenero;
    }

    public void setDocIdentidadgenero(String docIdentidadgenero) {
        this.docIdentidadgenero = docIdentidadgenero;
    }

    public String getDocM() {
        return docM;
    }

    public void setDocM(String docM) {
        this.docM = docM;
    }

    public String getDocF() {
        return docF;
    }

    public void setDocF(String docF) {
        this.docF = docF;
    }

    public String getDocT() {
        return docT;
    }

    public void setDocT(String docT) {
        this.docT = docT;
    }

    public String getDocCabezafamilia() {
        return docCabezafamilia;
    }

    public void setDocCabezafamilia(String docCabezafamilia) {
        this.docCabezafamilia = docCabezafamilia;
    }

    public String getDocDiscapacidadfisica() {
        return docDiscapacidadfisica;
    }

    public void setDocDiscapacidadfisica(String docDiscapacidadfisica) {
        this.docDiscapacidadfisica = docDiscapacidadfisica;
    }

    public String getDocGrupoetnico() {
        return docGrupoetnico;
    }

    public void setDocGrupoetnico(String docGrupoetnico) {
        this.docGrupoetnico = docGrupoetnico;
    }

    public String getDocSituacionadtivafn() {
        return docSituacionadtivafn;
    }

    public void setDocSituacionadtivafn(String docSituacionadtivafn) {
        this.docSituacionadtivafn = docSituacionadtivafn;
    }

    public String getDocCalificacionobtenida() {
        return docCalificacionobtenida;
    }

    public void setDocCalificacionobtenida(String docCalificacionobtenida) {
        this.docCalificacionobtenida = docCalificacionobtenida;
    }

    public String getDocAsignacionbasica() {
        return docAsignacionbasica;
    }

    public void setDocAsignacionbasica(String docAsignacionbasica) {
        this.docAsignacionbasica = docAsignacionbasica;
    }

    public String getDocGastosrepresentacion() {
        return docGastosrepresentacion;
    }

    public void setDocGastosrepresentacion(String docGastosrepresentacion) {
        this.docGastosrepresentacion = docGastosrepresentacion;
    }

    public String getDocPorcgastosrepresentacion() {
        return docPorcgastosrepresentacion;
    }

    public void setDocPorcgastosrepresentacion(String docPorcgastosrepresentacion) {
        this.docPorcgastosrepresentacion = docPorcgastosrepresentacion;
    }

    public String getDocPrimatecnica() {
        return docPrimatecnica;
    }

    public void setDocPrimatecnica(String docPrimatecnica) {
        this.docPrimatecnica = docPrimatecnica;
    }

    public String getDocPorcprimatecnica() {
        return docPorcprimatecnica;
    }

    public void setDocPorcprimatecnica(String docPorcprimatecnica) {
        this.docPorcprimatecnica = docPorcprimatecnica;
    }

    public String getDocNivelescolaridad() {
        return docNivelescolaridad;
    }

    public void setDocNivelescolaridad(String docNivelescolaridad) {
        this.docNivelescolaridad = docNivelescolaridad;
    }

    public String getDocTitulopregrado() {
        return docTitulopregrado;
    }

    public void setDocTitulopregrado(String docTitulopregrado) {
        this.docTitulopregrado = docTitulopregrado;
    }

    public String getDocTituloposgrado() {
        return docTituloposgrado;
    }

    public void setDocTituloposgrado(String docTituloposgrado) {
        this.docTituloposgrado = docTituloposgrado;
    }

    public String getDocOtrotitulopregrado() {
        return docOtrotitulopregrado;
    }

    public void setDocOtrotitulopregrado(String docOtrotitulopregrado) {
        this.docOtrotitulopregrado = docOtrotitulopregrado;
    }

    public String getDocPertenecesindicato() {
        return docPertenecesindicato;
    }

    public void setDocPertenecesindicato(String docPertenecesindicato) {
        this.docPertenecesindicato = docPertenecesindicato;
    }

    public String getDocOrganizacionsindical() {
        return docOrganizacionsindical;
    }

    public void setDocOrganizacionsindical(String docOrganizacionsindical) {
        this.docOrganizacionsindical = docOrganizacionsindical;
    }

    public String getDocFechaafiliacion() {
        return docFechaafiliacion;
    }

    public void setDocFechaafiliacion(String docFechaafiliacion) {
        this.docFechaafiliacion = docFechaafiliacion;
    }

    public String getDocTipovinculacion() {
        return docTipovinculacion;
    }

    public void setDocTipovinculacion(String docTipovinculacion) {
        this.docTipovinculacion = docTipovinculacion;
    }

    public String getDocDiasotorgadosmes() {
        return docDiasotorgadosmes;
    }

    public void setDocDiasotorgadosmes(String docDiasotorgadosmes) {
        this.docDiasotorgadosmes = docDiasotorgadosmes;
    }

    public String getDocJustificacionpermiso() {
        return docJustificacionpermiso;
    }

    public void setDocJustificacionpermiso(String docJustificacionpermiso) {
        this.docJustificacionpermiso = docJustificacionpermiso;
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
        hash += (docId != null ? docId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ThmCarrdocente)) {
            return false;
        }
        ThmCarrdocente other = (ThmCarrdocente) object;
        if ((this.docId == null && other.docId != null) || (this.docId != null && !this.docId.equals(other.docId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.veeduria.dao.ThmCarrdocente[ docId=" + docId + " ]";
    }
    
}
