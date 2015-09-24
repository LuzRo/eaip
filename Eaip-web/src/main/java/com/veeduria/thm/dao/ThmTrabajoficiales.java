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
 * @author fernando
 */
@Entity
@Table(name = "thm_trabajoficiales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ThmTrabajoficiales.findAll", query = "SELECT t FROM ThmTrabajoficiales t"),
    @NamedQuery(name = "ThmTrabajoficiales.findByOfiId", query = "SELECT t FROM ThmTrabajoficiales t WHERE t.ofiId = :ofiId"),
    @NamedQuery(name = "ThmTrabajoficiales.findByOfiNumcontrato", query = "SELECT t FROM ThmTrabajoficiales t WHERE t.ofiNumcontrato = :ofiNumcontrato"),
    @NamedQuery(name = "ThmTrabajoficiales.findByOfiFechacontrato", query = "SELECT t FROM ThmTrabajoficiales t WHERE t.ofiFechacontrato = :ofiFechacontrato"),
    @NamedQuery(name = "ThmTrabajoficiales.findByOfiFechainicio", query = "SELECT t FROM ThmTrabajoficiales t WHERE t.ofiFechainicio = :ofiFechainicio"),
    @NamedQuery(name = "ThmTrabajoficiales.findByOfiFechafin", query = "SELECT t FROM ThmTrabajoficiales t WHERE t.ofiFechafin = :ofiFechafin"),
    @NamedQuery(name = "ThmTrabajoficiales.findByOfiDenomempleo", query = "SELECT t FROM ThmTrabajoficiales t WHERE t.ofiDenomempleo = :ofiDenomempleo"),
    @NamedQuery(name = "ThmTrabajoficiales.findByOfiNivel", query = "SELECT t FROM ThmTrabajoficiales t WHERE t.ofiNivel = :ofiNivel"),
    @NamedQuery(name = "ThmTrabajoficiales.findByOfiCodigo", query = "SELECT t FROM ThmTrabajoficiales t WHERE t.ofiCodigo = :ofiCodigo"),
    @NamedQuery(name = "ThmTrabajoficiales.findByOfiGrado", query = "SELECT t FROM ThmTrabajoficiales t WHERE t.ofiGrado = :ofiGrado"),
    @NamedQuery(name = "ThmTrabajoficiales.findByOfiTipocontrato", query = "SELECT t FROM ThmTrabajoficiales t WHERE t.ofiTipocontrato = :ofiTipocontrato"),
    @NamedQuery(name = "ThmTrabajoficiales.findByOfiDepestrucorg", query = "SELECT t FROM ThmTrabajoficiales t WHERE t.ofiDepestrucorg = :ofiDepestrucorg"),
    @NamedQuery(name = "ThmTrabajoficiales.findByOfiAreafunctrabajo", query = "SELECT t FROM ThmTrabajoficiales t WHERE t.ofiAreafunctrabajo = :ofiAreafunctrabajo"),
    @NamedQuery(name = "ThmTrabajoficiales.findByOfiTipodocumento", query = "SELECT t FROM ThmTrabajoficiales t WHERE t.ofiTipodocumento = :ofiTipodocumento"),
    @NamedQuery(name = "ThmTrabajoficiales.findByOfiNumdocumento", query = "SELECT t FROM ThmTrabajoficiales t WHERE t.ofiNumdocumento = :ofiNumdocumento"),
    @NamedQuery(name = "ThmTrabajoficiales.findByOfiNombres", query = "SELECT t FROM ThmTrabajoficiales t WHERE t.ofiNombres = :ofiNombres"),
    @NamedQuery(name = "ThmTrabajoficiales.findByOfiPrimerapellido", query = "SELECT t FROM ThmTrabajoficiales t WHERE t.ofiPrimerapellido = :ofiPrimerapellido"),
    @NamedQuery(name = "ThmTrabajoficiales.findByOfiSegundoapellido", query = "SELECT t FROM ThmTrabajoficiales t WHERE t.ofiSegundoapellido = :ofiSegundoapellido"),
    @NamedQuery(name = "ThmTrabajoficiales.findByOfiGenero", query = "SELECT t FROM ThmTrabajoficiales t WHERE t.ofiGenero = :ofiGenero"),
    @NamedQuery(name = "ThmTrabajoficiales.findByOfiFechanacimiento", query = "SELECT t FROM ThmTrabajoficiales t WHERE t.ofiFechanacimiento = :ofiFechanacimiento"),
    @NamedQuery(name = "ThmTrabajoficiales.findByOfiCabezafamilia", query = "SELECT t FROM ThmTrabajoficiales t WHERE t.ofiCabezafamilia = :ofiCabezafamilia"),
    @NamedQuery(name = "ThmTrabajoficiales.findByOfiDiscapacidadfisica", query = "SELECT t FROM ThmTrabajoficiales t WHERE t.ofiDiscapacidadfisica = :ofiDiscapacidadfisica"),
    @NamedQuery(name = "ThmTrabajoficiales.findByOfiGrupoetnico", query = "SELECT t FROM ThmTrabajoficiales t WHERE t.ofiGrupoetnico = :ofiGrupoetnico"),
    @NamedQuery(name = "ThmTrabajoficiales.findByOfiConteo", query = "SELECT t FROM ThmTrabajoficiales t WHERE t.ofiConteo = :ofiConteo"),
    @NamedQuery(name = "ThmTrabajoficiales.findByOfiVacantes", query = "SELECT t FROM ThmTrabajoficiales t WHERE t.ofiVacantes = :ofiVacantes"),
    @NamedQuery(name = "ThmTrabajoficiales.findByOfiM", query = "SELECT t FROM ThmTrabajoficiales t WHERE t.ofiM = :ofiM"),
    @NamedQuery(name = "ThmTrabajoficiales.findByOfiF", query = "SELECT t FROM ThmTrabajoficiales t WHERE t.ofiF = :ofiF"),
    @NamedQuery(name = "ThmTrabajoficiales.findByOfiT", query = "SELECT t FROM ThmTrabajoficiales t WHERE t.ofiT = :ofiT"),
    @NamedQuery(name = "ThmTrabajoficiales.findByOfiSituacionadtivafn", query = "SELECT t FROM ThmTrabajoficiales t WHERE t.ofiSituacionadtivafn = :ofiSituacionadtivafn"),
    @NamedQuery(name = "ThmTrabajoficiales.findByOfiAsignacionbasica", query = "SELECT t FROM ThmTrabajoficiales t WHERE t.ofiAsignacionbasica = :ofiAsignacionbasica"),
    @NamedQuery(name = "ThmTrabajoficiales.findByOfiNivelescolaridad", query = "SELECT t FROM ThmTrabajoficiales t WHERE t.ofiNivelescolaridad = :ofiNivelescolaridad"),
    @NamedQuery(name = "ThmTrabajoficiales.findByOfiTitulopregrado", query = "SELECT t FROM ThmTrabajoficiales t WHERE t.ofiTitulopregrado = :ofiTitulopregrado"),
    @NamedQuery(name = "ThmTrabajoficiales.findByOfiTituloposgrado", query = "SELECT t FROM ThmTrabajoficiales t WHERE t.ofiTituloposgrado = :ofiTituloposgrado"),
    @NamedQuery(name = "ThmTrabajoficiales.findByOfiOtrotitulopregrado", query = "SELECT t FROM ThmTrabajoficiales t WHERE t.ofiOtrotitulopregrado = :ofiOtrotitulopregrado"),
    @NamedQuery(name = "ThmTrabajoficiales.findByOfiPertenecesindicato", query = "SELECT t FROM ThmTrabajoficiales t WHERE t.ofiPertenecesindicato = :ofiPertenecesindicato"),
    @NamedQuery(name = "ThmTrabajoficiales.findByOfiOrganizacionsindical", query = "SELECT t FROM ThmTrabajoficiales t WHERE t.ofiOrganizacionsindical = :ofiOrganizacionsindical"),
    @NamedQuery(name = "ThmTrabajoficiales.findByOfiFechaafiliacion", query = "SELECT t FROM ThmTrabajoficiales t WHERE t.ofiFechaafiliacion = :ofiFechaafiliacion"),
    @NamedQuery(name = "ThmTrabajoficiales.findByOfiTipovinculacion", query = "SELECT t FROM ThmTrabajoficiales t WHERE t.ofiTipovinculacion = :ofiTipovinculacion"),
    @NamedQuery(name = "ThmTrabajoficiales.findByOfiDiasotorgadosmes", query = "SELECT t FROM ThmTrabajoficiales t WHERE t.ofiDiasotorgadosmes = :ofiDiasotorgadosmes"),
    @NamedQuery(name = "ThmTrabajoficiales.findByOfiJustificacionpermiso", query = "SELECT t FROM ThmTrabajoficiales t WHERE t.ofiJustificacionpermiso = :ofiJustificacionpermiso")})
public class ThmTrabajoficiales implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ofi_id")
    private Long ofiId;
    @Size(max = 200)
    @Column(name = "ofi_numcontrato")
    private String ofiNumcontrato;
    @Size(max = 100)
    @Column(name = "ofi_fechacontrato")
    private String ofiFechacontrato;
    @Size(max = 100)
    @Column(name = "ofi_fechainicio")
    private String ofiFechainicio;
    @Size(max = 100)
    @Column(name = "ofi_fechafin")
    private String ofiFechafin;
    @Size(max = 1500)
    @Column(name = "ofi_denomempleo")
    private String ofiDenomempleo;
    @Size(max = 1500)
    @Column(name = "ofi_nivel")
    private String ofiNivel;
    @Size(max = 100)
    @Column(name = "ofi_codigo")
    private String ofiCodigo;
    @Size(max = 100)
    @Column(name = "ofi_grado")
    private String ofiGrado;
    @Size(max = 1500)
    @Column(name = "ofi_tipocontrato")
    private String ofiTipocontrato;
    @Size(max = 1500)
    @Column(name = "ofi_depestrucorg")
    private String ofiDepestrucorg;
    @Size(max = 1500)
    @Column(name = "ofi_areafunctrabajo")
    private String ofiAreafunctrabajo;
    @Size(max = 50)
    @Column(name = "ofi_tipodocumento")
    private String ofiTipodocumento;
    @Size(max = 100)
    @Column(name = "ofi_numdocumento")
    private String ofiNumdocumento;
    @Size(max = 1500)
    @Column(name = "ofi_nombres")
    private String ofiNombres;
    @Size(max = 1500)
    @Column(name = "ofi_primerapellido")
    private String ofiPrimerapellido;
    @Size(max = 1500)
    @Column(name = "ofi_segundoapellido")
    private String ofiSegundoapellido;
    @Size(max = 100)
    @Column(name = "ofi_genero")
    private String ofiGenero;
    @Size(max = 1500)
    @Column(name = "ofi_fechanacimiento")
    private String ofiFechanacimiento;
    @Size(max = 1500)
    @Column(name = "ofi_cabezafamilia")
    private String ofiCabezafamilia;
    @Size(max = 1500)
    @Column(name = "ofi_discapacidadfisica")
    private String ofiDiscapacidadfisica;
    @Size(max = 1500)
    @Column(name = "ofi_grupoetnico")
    private String ofiGrupoetnico;
    @Size(max = 1500)
    @Column(name = "ofi_conteo")
    private String ofiConteo;
    @Size(max = 1500)
    @Column(name = "ofi_vacantes")
    private String ofiVacantes;
    @Size(max = 50)
    @Column(name = "ofi_m")
    private String ofiM;
    @Size(max = 50)
    @Column(name = "ofi_f")
    private String ofiF;
    @Size(max = 50)
    @Column(name = "ofi_t")
    private String ofiT;
    @Size(max = 1500)
    @Column(name = "ofi_situacionadtivafn")
    private String ofiSituacionadtivafn;
    @Size(max = 1500)
    @Column(name = "ofi_asignacionbasica")
    private String ofiAsignacionbasica;
    @Size(max = 1500)
    @Column(name = "ofi_nivelescolaridad")
    private String ofiNivelescolaridad;
    @Size(max = 1500)
    @Column(name = "ofi_titulopregrado")
    private String ofiTitulopregrado;
    @Size(max = 1500)
    @Column(name = "ofi_tituloposgrado")
    private String ofiTituloposgrado;
    @Size(max = 1500)
    @Column(name = "ofi_otrotitulopregrado")
    private String ofiOtrotitulopregrado;
    @Size(max = 1500)
    @Column(name = "ofi_pertenecesindicato")
    private String ofiPertenecesindicato;
    @Size(max = 1500)
    @Column(name = "ofi_organizacionsindical")
    private String ofiOrganizacionsindical;
    @Size(max = 1500)
    @Column(name = "ofi_fechaafiliacion")
    private String ofiFechaafiliacion;
    @Size(max = 1500)
    @Column(name = "ofi_tipovinculacion")
    private String ofiTipovinculacion;
    @Size(max = 1500)
    @Column(name = "ofi_diasotorgadosmes")
    private String ofiDiasotorgadosmes;
    @Size(max = 1500)
    @Column(name = "ofi_justificacionpermiso")
    private String ofiJustificacionpermiso;
    @JoinColumn(name = "lgreg_id", referencedColumnName = "lgreg_id")
    @ManyToOne
    private SysRegistrocarga lgregId;

    public ThmTrabajoficiales() {
    }

    public ThmTrabajoficiales(Long ofiId) {
        this.ofiId = ofiId;
    }

    public Long getOfiId() {
        return ofiId;
    }

    public void setOfiId(Long ofiId) {
        this.ofiId = ofiId;
    }

    public String getOfiNumcontrato() {
        return ofiNumcontrato;
    }

    public void setOfiNumcontrato(String ofiNumcontrato) {
        this.ofiNumcontrato = ofiNumcontrato;
    }

    public String getOfiFechacontrato() {
        return ofiFechacontrato;
    }

    public void setOfiFechacontrato(String ofiFechacontrato) {
        this.ofiFechacontrato = ofiFechacontrato;
    }

    public String getOfiFechainicio() {
        return ofiFechainicio;
    }

    public void setOfiFechainicio(String ofiFechainicio) {
        this.ofiFechainicio = ofiFechainicio;
    }

    public String getOfiFechafin() {
        return ofiFechafin;
    }

    public void setOfiFechafin(String ofiFechafin) {
        this.ofiFechafin = ofiFechafin;
    }

    public String getOfiDenomempleo() {
        return ofiDenomempleo;
    }

    public void setOfiDenomempleo(String ofiDenomempleo) {
        this.ofiDenomempleo = ofiDenomempleo;
    }

    public String getOfiNivel() {
        return ofiNivel;
    }

    public void setOfiNivel(String ofiNivel) {
        this.ofiNivel = ofiNivel;
    }

    public String getOfiCodigo() {
        return ofiCodigo;
    }

    public void setOfiCodigo(String ofiCodigo) {
        this.ofiCodigo = ofiCodigo;
    }

    public String getOfiGrado() {
        return ofiGrado;
    }

    public void setOfiGrado(String ofiGrado) {
        this.ofiGrado = ofiGrado;
    }

    public String getOfiTipocontrato() {
        return ofiTipocontrato;
    }

    public void setOfiTipocontrato(String ofiTipocontrato) {
        this.ofiTipocontrato = ofiTipocontrato;
    }

    public String getOfiDepestrucorg() {
        return ofiDepestrucorg;
    }

    public void setOfiDepestrucorg(String ofiDepestrucorg) {
        this.ofiDepestrucorg = ofiDepestrucorg;
    }

    public String getOfiAreafunctrabajo() {
        return ofiAreafunctrabajo;
    }

    public void setOfiAreafunctrabajo(String ofiAreafunctrabajo) {
        this.ofiAreafunctrabajo = ofiAreafunctrabajo;
    }

    public String getOfiTipodocumento() {
        return ofiTipodocumento;
    }

    public void setOfiTipodocumento(String ofiTipodocumento) {
        this.ofiTipodocumento = ofiTipodocumento;
    }

    public String getOfiNumdocumento() {
        return ofiNumdocumento;
    }

    public void setOfiNumdocumento(String ofiNumdocumento) {
        this.ofiNumdocumento = ofiNumdocumento;
    }

    public String getOfiNombres() {
        return ofiNombres;
    }

    public void setOfiNombres(String ofiNombres) {
        this.ofiNombres = ofiNombres;
    }

    public String getOfiPrimerapellido() {
        return ofiPrimerapellido;
    }

    public void setOfiPrimerapellido(String ofiPrimerapellido) {
        this.ofiPrimerapellido = ofiPrimerapellido;
    }

    public String getOfiSegundoapellido() {
        return ofiSegundoapellido;
    }

    public void setOfiSegundoapellido(String ofiSegundoapellido) {
        this.ofiSegundoapellido = ofiSegundoapellido;
    }

    public String getOfiGenero() {
        return ofiGenero;
    }

    public void setOfiGenero(String ofiGenero) {
        this.ofiGenero = ofiGenero;
    }

    public String getOfiFechanacimiento() {
        return ofiFechanacimiento;
    }

    public void setOfiFechanacimiento(String ofiFechanacimiento) {
        this.ofiFechanacimiento = ofiFechanacimiento;
    }

    public String getOfiCabezafamilia() {
        return ofiCabezafamilia;
    }

    public void setOfiCabezafamilia(String ofiCabezafamilia) {
        this.ofiCabezafamilia = ofiCabezafamilia;
    }

    public String getOfiDiscapacidadfisica() {
        return ofiDiscapacidadfisica;
    }

    public void setOfiDiscapacidadfisica(String ofiDiscapacidadfisica) {
        this.ofiDiscapacidadfisica = ofiDiscapacidadfisica;
    }

    public String getOfiGrupoetnico() {
        return ofiGrupoetnico;
    }

    public void setOfiGrupoetnico(String ofiGrupoetnico) {
        this.ofiGrupoetnico = ofiGrupoetnico;
    }

    public String getOfiConteo() {
        return ofiConteo;
    }

    public void setOfiConteo(String ofiConteo) {
        this.ofiConteo = ofiConteo;
    }

    public String getOfiVacantes() {
        return ofiVacantes;
    }

    public void setOfiVacantes(String ofiVacantes) {
        this.ofiVacantes = ofiVacantes;
    }

    public String getOfiM() {
        return ofiM;
    }

    public void setOfiM(String ofiM) {
        this.ofiM = ofiM;
    }

    public String getOfiF() {
        return ofiF;
    }

    public void setOfiF(String ofiF) {
        this.ofiF = ofiF;
    }

    public String getOfiT() {
        return ofiT;
    }

    public void setOfiT(String ofiT) {
        this.ofiT = ofiT;
    }

    public String getOfiSituacionadtivafn() {
        return ofiSituacionadtivafn;
    }

    public void setOfiSituacionadtivafn(String ofiSituacionadtivafn) {
        this.ofiSituacionadtivafn = ofiSituacionadtivafn;
    }

    public String getOfiAsignacionbasica() {
        return ofiAsignacionbasica;
    }

    public void setOfiAsignacionbasica(String ofiAsignacionbasica) {
        this.ofiAsignacionbasica = ofiAsignacionbasica;
    }

    public String getOfiNivelescolaridad() {
        return ofiNivelescolaridad;
    }

    public void setOfiNivelescolaridad(String ofiNivelescolaridad) {
        this.ofiNivelescolaridad = ofiNivelescolaridad;
    }

    public String getOfiTitulopregrado() {
        return ofiTitulopregrado;
    }

    public void setOfiTitulopregrado(String ofiTitulopregrado) {
        this.ofiTitulopregrado = ofiTitulopregrado;
    }

    public String getOfiTituloposgrado() {
        return ofiTituloposgrado;
    }

    public void setOfiTituloposgrado(String ofiTituloposgrado) {
        this.ofiTituloposgrado = ofiTituloposgrado;
    }

    public String getOfiOtrotitulopregrado() {
        return ofiOtrotitulopregrado;
    }

    public void setOfiOtrotitulopregrado(String ofiOtrotitulopregrado) {
        this.ofiOtrotitulopregrado = ofiOtrotitulopregrado;
    }

    public String getOfiPertenecesindicato() {
        return ofiPertenecesindicato;
    }

    public void setOfiPertenecesindicato(String ofiPertenecesindicato) {
        this.ofiPertenecesindicato = ofiPertenecesindicato;
    }

    public String getOfiOrganizacionsindical() {
        return ofiOrganizacionsindical;
    }

    public void setOfiOrganizacionsindical(String ofiOrganizacionsindical) {
        this.ofiOrganizacionsindical = ofiOrganizacionsindical;
    }

    public String getOfiFechaafiliacion() {
        return ofiFechaafiliacion;
    }

    public void setOfiFechaafiliacion(String ofiFechaafiliacion) {
        this.ofiFechaafiliacion = ofiFechaafiliacion;
    }

    public String getOfiTipovinculacion() {
        return ofiTipovinculacion;
    }

    public void setOfiTipovinculacion(String ofiTipovinculacion) {
        this.ofiTipovinculacion = ofiTipovinculacion;
    }

    public String getOfiDiasotorgadosmes() {
        return ofiDiasotorgadosmes;
    }

    public void setOfiDiasotorgadosmes(String ofiDiasotorgadosmes) {
        this.ofiDiasotorgadosmes = ofiDiasotorgadosmes;
    }

    public String getOfiJustificacionpermiso() {
        return ofiJustificacionpermiso;
    }

    public void setOfiJustificacionpermiso(String ofiJustificacionpermiso) {
        this.ofiJustificacionpermiso = ofiJustificacionpermiso;
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
        hash += (ofiId != null ? ofiId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ThmTrabajoficiales)) {
            return false;
        }
        ThmTrabajoficiales other = (ThmTrabajoficiales) object;
        if ((this.ofiId == null && other.ofiId != null) || (this.ofiId != null && !this.ofiId.equals(other.ofiId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.veeduria.dao.ThmTrabajoficiales[ ofiId=" + ofiId + " ]";
    }
    
}
