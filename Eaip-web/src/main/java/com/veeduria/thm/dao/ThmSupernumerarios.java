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
 * @author con1ead
 */
@Entity
@Table(name = "thm_supernumerarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ThmSupernumerarios.findAll", query = "SELECT t FROM ThmSupernumerarios t"),
    @NamedQuery(name = "ThmSupernumerarios.findBySupId", query = "SELECT t FROM ThmSupernumerarios t WHERE t.supId = :supId"),
    @NamedQuery(name = "ThmSupernumerarios.findBySupResolucion", query = "SELECT t FROM ThmSupernumerarios t WHERE t.supResolucion = :supResolucion"),
    @NamedQuery(name = "ThmSupernumerarios.findBySupFecharesolucion", query = "SELECT t FROM ThmSupernumerarios t WHERE t.supFecharesolucion = :supFecharesolucion"),
    @NamedQuery(name = "ThmSupernumerarios.findBySupFechainicio", query = "SELECT t FROM ThmSupernumerarios t WHERE t.supFechainicio = :supFechainicio"),
    @NamedQuery(name = "ThmSupernumerarios.findBySupFechaterminacion", query = "SELECT t FROM ThmSupernumerarios t WHERE t.supFechaterminacion = :supFechaterminacion"),
    @NamedQuery(name = "ThmSupernumerarios.findBySupDenomempleo", query = "SELECT t FROM ThmSupernumerarios t WHERE t.supDenomempleo = :supDenomempleo"),
    @NamedQuery(name = "ThmSupernumerarios.findBySupNivel", query = "SELECT t FROM ThmSupernumerarios t WHERE t.supNivel = :supNivel"),
    @NamedQuery(name = "ThmSupernumerarios.findBySupCodigo", query = "SELECT t FROM ThmSupernumerarios t WHERE t.supCodigo = :supCodigo"),
    @NamedQuery(name = "ThmSupernumerarios.findBySupGrado", query = "SELECT t FROM ThmSupernumerarios t WHERE t.supGrado = :supGrado"),
    @NamedQuery(name = "ThmSupernumerarios.findBySupDepestrucorg", query = "SELECT t FROM ThmSupernumerarios t WHERE t.supDepestrucorg = :supDepestrucorg"),
    @NamedQuery(name = "ThmSupernumerarios.findBySupAreafunctrabajo", query = "SELECT t FROM ThmSupernumerarios t WHERE t.supAreafunctrabajo = :supAreafunctrabajo"),
    @NamedQuery(name = "ThmSupernumerarios.findBySupTipodocumento", query = "SELECT t FROM ThmSupernumerarios t WHERE t.supTipodocumento = :supTipodocumento"),
    @NamedQuery(name = "ThmSupernumerarios.findBySupNumdocumento", query = "SELECT t FROM ThmSupernumerarios t WHERE t.supNumdocumento = :supNumdocumento"),
    @NamedQuery(name = "ThmSupernumerarios.findBySupNombres", query = "SELECT t FROM ThmSupernumerarios t WHERE t.supNombres = :supNombres"),
    @NamedQuery(name = "ThmSupernumerarios.findBySupPrimerapellido", query = "SELECT t FROM ThmSupernumerarios t WHERE t.supPrimerapellido = :supPrimerapellido"),
    @NamedQuery(name = "ThmSupernumerarios.findBySupSegundoapellido", query = "SELECT t FROM ThmSupernumerarios t WHERE t.supSegundoapellido = :supSegundoapellido"),
    @NamedQuery(name = "ThmSupernumerarios.findBySupGenero", query = "SELECT t FROM ThmSupernumerarios t WHERE t.supGenero = :supGenero"),
    @NamedQuery(name = "ThmSupernumerarios.findBySupFechanacimiento", query = "SELECT t FROM ThmSupernumerarios t WHERE t.supFechanacimiento = :supFechanacimiento"),
    @NamedQuery(name = "ThmSupernumerarios.findBySupCabezafamilia", query = "SELECT t FROM ThmSupernumerarios t WHERE t.supCabezafamilia = :supCabezafamilia"),
    @NamedQuery(name = "ThmSupernumerarios.findBySupDiscapacidadfisica", query = "SELECT t FROM ThmSupernumerarios t WHERE t.supDiscapacidadfisica = :supDiscapacidadfisica"),
    @NamedQuery(name = "ThmSupernumerarios.findBySupConteo", query = "SELECT t FROM ThmSupernumerarios t WHERE t.supConteo = :supConteo"),
    @NamedQuery(name = "ThmSupernumerarios.findBySupM", query = "SELECT t FROM ThmSupernumerarios t WHERE t.supM = :supM"),
    @NamedQuery(name = "ThmSupernumerarios.findBySupF", query = "SELECT t FROM ThmSupernumerarios t WHERE t.supF = :supF"),
    @NamedQuery(name = "ThmSupernumerarios.findBySupT", query = "SELECT t FROM ThmSupernumerarios t WHERE t.supT = :supT"),
    @NamedQuery(name = "ThmSupernumerarios.findBySupGrupoetnico", query = "SELECT t FROM ThmSupernumerarios t WHERE t.supGrupoetnico = :supGrupoetnico"),
    @NamedQuery(name = "ThmSupernumerarios.findBySupSituacionadtivafn", query = "SELECT t FROM ThmSupernumerarios t WHERE t.supSituacionadtivafn = :supSituacionadtivafn"),
    @NamedQuery(name = "ThmSupernumerarios.findBySupAsignacionbasica", query = "SELECT t FROM ThmSupernumerarios t WHERE t.supAsignacionbasica = :supAsignacionbasica"),
    @NamedQuery(name = "ThmSupernumerarios.findBySupPrimatecnica", query = "SELECT t FROM ThmSupernumerarios t WHERE t.supPrimatecnica = :supPrimatecnica"),
    @NamedQuery(name = "ThmSupernumerarios.findBySupPorcprimatecnica", query = "SELECT t FROM ThmSupernumerarios t WHERE t.supPorcprimatecnica = :supPorcprimatecnica"),
    @NamedQuery(name = "ThmSupernumerarios.findBySupNivelescolaridad", query = "SELECT t FROM ThmSupernumerarios t WHERE t.supNivelescolaridad = :supNivelescolaridad"),
    @NamedQuery(name = "ThmSupernumerarios.findBySupTitulopregrado", query = "SELECT t FROM ThmSupernumerarios t WHERE t.supTitulopregrado = :supTitulopregrado"),
    @NamedQuery(name = "ThmSupernumerarios.findBySupTituloposgrado", query = "SELECT t FROM ThmSupernumerarios t WHERE t.supTituloposgrado = :supTituloposgrado"),
    @NamedQuery(name = "ThmSupernumerarios.findBySupOtrotitulopregrado", query = "SELECT t FROM ThmSupernumerarios t WHERE t.supOtrotitulopregrado = :supOtrotitulopregrado"),
    @NamedQuery(name = "ThmSupernumerarios.findBySupPertenecesindicato", query = "SELECT t FROM ThmSupernumerarios t WHERE t.supPertenecesindicato = :supPertenecesindicato"),
    @NamedQuery(name = "ThmSupernumerarios.findBySupOrganizacionsindical", query = "SELECT t FROM ThmSupernumerarios t WHERE t.supOrganizacionsindical = :supOrganizacionsindical"),
    @NamedQuery(name = "ThmSupernumerarios.findBySupFechaafiliacion", query = "SELECT t FROM ThmSupernumerarios t WHERE t.supFechaafiliacion = :supFechaafiliacion"),
    @NamedQuery(name = "ThmSupernumerarios.findBySupTipovinculacion", query = "SELECT t FROM ThmSupernumerarios t WHERE t.supTipovinculacion = :supTipovinculacion"),
    @NamedQuery(name = "ThmSupernumerarios.findBySupDiasotorgadosmes", query = "SELECT t FROM ThmSupernumerarios t WHERE t.supDiasotorgadosmes = :supDiasotorgadosmes"),
    @NamedQuery(name = "ThmSupernumerarios.findBySupJustificacionpermiso", query = "SELECT t FROM ThmSupernumerarios t WHERE t.supJustificacionpermiso = :supJustificacionpermiso"),
    @NamedQuery(name = "ThmSupernumerarios.findBySupAnosenentidad", query = "SELECT t FROM ThmSupernumerarios t WHERE t.supAnosenentidad = :supAnosenentidad"),
    @NamedQuery(name = "ThmSupernumerarios.findBySupEdad", query = "SELECT t FROM ThmSupernumerarios t WHERE t.supEdad = :supEdad"),
    @NamedQuery(name = "ThmSupernumerarios.findBySupAnoreporte", query = "SELECT t FROM ThmSupernumerarios t WHERE t.supAnoreporte = :supAnoreporte"),
    @NamedQuery(name = "ThmSupernumerarios.findByEtdId", query = "SELECT t FROM ThmSupernumerarios t WHERE t.etdId = :etdId")})
public class ThmSupernumerarios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sup_id")
    private Long supId;
    @Size(max = 200)
    @Column(name = "sup_resolucion")
    private String supResolucion;
    @Size(max = 100)
    @Column(name = "sup_fecharesolucion")
    private String supFecharesolucion;
    @Size(max = 100)
    @Column(name = "sup_fechainicio")
    private String supFechainicio;
    @Size(max = 100)
    @Column(name = "sup_fechaterminacion")
    private String supFechaterminacion;
    @Size(max = 200)
    @Column(name = "sup_denomempleo")
    private String supDenomempleo;
    @Size(max = 200)
    @Column(name = "sup_nivel")
    private String supNivel;
    @Size(max = 100)
    @Column(name = "sup_codigo")
    private String supCodigo;
    @Size(max = 100)
    @Column(name = "sup_grado")
    private String supGrado;
    @Size(max = 1500)
    @Column(name = "sup_depestrucorg")
    private String supDepestrucorg;
    @Size(max = 1500)
    @Column(name = "sup_areafunctrabajo")
    private String supAreafunctrabajo;
    @Size(max = 50)
    @Column(name = "sup_tipodocumento")
    private String supTipodocumento;
    @Size(max = 100)
    @Column(name = "sup_numdocumento")
    private String supNumdocumento;
    @Size(max = 1500)
    @Column(name = "sup_nombres")
    private String supNombres;
    @Size(max = 1500)
    @Column(name = "sup_primerapellido")
    private String supPrimerapellido;
    @Size(max = 1500)
    @Column(name = "sup_segundoapellido")
    private String supSegundoapellido;
    @Size(max = 200)
    @Column(name = "sup_genero")
    private String supGenero;
    @Size(max = 100)
    @Column(name = "sup_fechanacimiento")
    private String supFechanacimiento;
    @Size(max = 100)
    @Column(name = "sup_cabezafamilia")
    private String supCabezafamilia;
    @Size(max = 100)
    @Column(name = "sup_discapacidadfisica")
    private String supDiscapacidadfisica;
    @Size(max = 300)
    @Column(name = "sup_conteo")
    private String supConteo;
    @Size(max = 100)
    @Column(name = "sup_m")
    private String supM;
    @Size(max = 100)
    @Column(name = "sup_f")
    private String supF;
    @Size(max = 100)
    @Column(name = "sup_t")
    private String supT;
    @Size(max = 1500)
    @Column(name = "sup_grupoetnico")
    private String supGrupoetnico;
    @Size(max = 1500)
    @Column(name = "sup_situacionadtivafn")
    private String supSituacionadtivafn;
    @Size(max = 1500)
    @Column(name = "sup_asignacionbasica")
    private String supAsignacionbasica;
    @Size(max = 1500)
    @Column(name = "sup_primatecnica")
    private String supPrimatecnica;
    @Size(max = 1500)
    @Column(name = "sup_porcprimatecnica")
    private String supPorcprimatecnica;
    @Size(max = 1500)
    @Column(name = "sup_nivelescolaridad")
    private String supNivelescolaridad;
    @Size(max = 1500)
    @Column(name = "sup_titulopregrado")
    private String supTitulopregrado;
    @Size(max = 1500)
    @Column(name = "sup_tituloposgrado")
    private String supTituloposgrado;
    @Size(max = 1500)
    @Column(name = "sup_otrotitulopregrado")
    private String supOtrotitulopregrado;
    @Size(max = 100)
    @Column(name = "sup_pertenecesindicato")
    private String supPertenecesindicato;
    @Size(max = 1500)
    @Column(name = "sup_organizacionsindical")
    private String supOrganizacionsindical;
    @Size(max = 100)
    @Column(name = "sup_fechaafiliacion")
    private String supFechaafiliacion;
    @Size(max = 1500)
    @Column(name = "sup_tipovinculacion")
    private String supTipovinculacion;
    @Size(max = 100)
    @Column(name = "sup_diasotorgadosmes")
    private String supDiasotorgadosmes;
    @Size(max = 1500)
    @Column(name = "sup_justificacionpermiso")
    private String supJustificacionpermiso;
    @Size(max = 100)
    @Column(name = "sup_anosenentidad")
    private String supAnosenentidad;
    @Size(max = 100)
    @Column(name = "sup_edad")
    private String supEdad;
    @Size(max = 100)
    @Column(name = "sup_anoreporte")
    private String supAnoreporte;
    @Column(name = "etd_id")
    private Integer etdId;
    @JoinColumn(name = "lgreg_id", referencedColumnName = "lgreg_id")
    @ManyToOne
    private SysRegistrocarga lgregId;
    @JoinColumn(name = "ene_id", referencedColumnName = "ene_id")
    @ManyToOne
    private ThmRfNivelescolaridad eneId;
    @JoinColumn(name = "enj_id", referencedColumnName = "enj_id")
    @ManyToOne
    private ThmRfNiveljerarquico enjId;

    public ThmSupernumerarios() {
    }

    public ThmSupernumerarios(Long supId) {
        this.supId = supId;
    }

    public Long getSupId() {
        return supId;
    }

    public void setSupId(Long supId) {
        this.supId = supId;
    }

    public String getSupResolucion() {
        return supResolucion;
    }

    public void setSupResolucion(String supResolucion) {
        this.supResolucion = supResolucion;
    }

    public String getSupFecharesolucion() {
        return supFecharesolucion;
    }

    public void setSupFecharesolucion(String supFecharesolucion) {
        this.supFecharesolucion = supFecharesolucion;
    }

    public String getSupFechainicio() {
        return supFechainicio;
    }

    public void setSupFechainicio(String supFechainicio) {
        this.supFechainicio = supFechainicio;
    }

    public String getSupFechaterminacion() {
        return supFechaterminacion;
    }

    public void setSupFechaterminacion(String supFechaterminacion) {
        this.supFechaterminacion = supFechaterminacion;
    }

    public String getSupDenomempleo() {
        return supDenomempleo;
    }

    public void setSupDenomempleo(String supDenomempleo) {
        this.supDenomempleo = supDenomempleo;
    }

    public String getSupNivel() {
        return supNivel;
    }

    public void setSupNivel(String supNivel) {
        this.supNivel = supNivel;
    }

    public String getSupCodigo() {
        return supCodigo;
    }

    public void setSupCodigo(String supCodigo) {
        this.supCodigo = supCodigo;
    }

    public String getSupGrado() {
        return supGrado;
    }

    public void setSupGrado(String supGrado) {
        this.supGrado = supGrado;
    }

    public String getSupDepestrucorg() {
        return supDepestrucorg;
    }

    public void setSupDepestrucorg(String supDepestrucorg) {
        this.supDepestrucorg = supDepestrucorg;
    }

    public String getSupAreafunctrabajo() {
        return supAreafunctrabajo;
    }

    public void setSupAreafunctrabajo(String supAreafunctrabajo) {
        this.supAreafunctrabajo = supAreafunctrabajo;
    }

    public String getSupTipodocumento() {
        return supTipodocumento;
    }

    public void setSupTipodocumento(String supTipodocumento) {
        this.supTipodocumento = supTipodocumento;
    }

    public String getSupNumdocumento() {
        return supNumdocumento;
    }

    public void setSupNumdocumento(String supNumdocumento) {
        this.supNumdocumento = supNumdocumento;
    }

    public String getSupNombres() {
        return supNombres;
    }

    public void setSupNombres(String supNombres) {
        this.supNombres = supNombres;
    }

    public String getSupPrimerapellido() {
        return supPrimerapellido;
    }

    public void setSupPrimerapellido(String supPrimerapellido) {
        this.supPrimerapellido = supPrimerapellido;
    }

    public String getSupSegundoapellido() {
        return supSegundoapellido;
    }

    public void setSupSegundoapellido(String supSegundoapellido) {
        this.supSegundoapellido = supSegundoapellido;
    }

    public String getSupGenero() {
        return supGenero;
    }

    public void setSupGenero(String supGenero) {
        this.supGenero = supGenero;
    }

    public String getSupFechanacimiento() {
        return supFechanacimiento;
    }

    public void setSupFechanacimiento(String supFechanacimiento) {
        this.supFechanacimiento = supFechanacimiento;
    }

    public String getSupCabezafamilia() {
        return supCabezafamilia;
    }

    public void setSupCabezafamilia(String supCabezafamilia) {
        this.supCabezafamilia = supCabezafamilia;
    }

    public String getSupDiscapacidadfisica() {
        return supDiscapacidadfisica;
    }

    public void setSupDiscapacidadfisica(String supDiscapacidadfisica) {
        this.supDiscapacidadfisica = supDiscapacidadfisica;
    }

    public String getSupConteo() {
        return supConteo;
    }

    public void setSupConteo(String supConteo) {
        this.supConteo = supConteo;
    }

    public String getSupM() {
        return supM;
    }

    public void setSupM(String supM) {
        this.supM = supM;
    }

    public String getSupF() {
        return supF;
    }

    public void setSupF(String supF) {
        this.supF = supF;
    }

    public String getSupT() {
        return supT;
    }

    public void setSupT(String supT) {
        this.supT = supT;
    }

    public String getSupGrupoetnico() {
        return supGrupoetnico;
    }

    public void setSupGrupoetnico(String supGrupoetnico) {
        this.supGrupoetnico = supGrupoetnico;
    }

    public String getSupSituacionadtivafn() {
        return supSituacionadtivafn;
    }

    public void setSupSituacionadtivafn(String supSituacionadtivafn) {
        this.supSituacionadtivafn = supSituacionadtivafn;
    }

    public String getSupAsignacionbasica() {
        return supAsignacionbasica;
    }

    public void setSupAsignacionbasica(String supAsignacionbasica) {
        this.supAsignacionbasica = supAsignacionbasica;
    }

    public String getSupPrimatecnica() {
        return supPrimatecnica;
    }

    public void setSupPrimatecnica(String supPrimatecnica) {
        this.supPrimatecnica = supPrimatecnica;
    }

    public String getSupPorcprimatecnica() {
        return supPorcprimatecnica;
    }

    public void setSupPorcprimatecnica(String supPorcprimatecnica) {
        this.supPorcprimatecnica = supPorcprimatecnica;
    }

    public String getSupNivelescolaridad() {
        return supNivelescolaridad;
    }

    public void setSupNivelescolaridad(String supNivelescolaridad) {
        this.supNivelescolaridad = supNivelescolaridad;
    }

    public String getSupTitulopregrado() {
        return supTitulopregrado;
    }

    public void setSupTitulopregrado(String supTitulopregrado) {
        this.supTitulopregrado = supTitulopregrado;
    }

    public String getSupTituloposgrado() {
        return supTituloposgrado;
    }

    public void setSupTituloposgrado(String supTituloposgrado) {
        this.supTituloposgrado = supTituloposgrado;
    }

    public String getSupOtrotitulopregrado() {
        return supOtrotitulopregrado;
    }

    public void setSupOtrotitulopregrado(String supOtrotitulopregrado) {
        this.supOtrotitulopregrado = supOtrotitulopregrado;
    }

    public String getSupPertenecesindicato() {
        return supPertenecesindicato;
    }

    public void setSupPertenecesindicato(String supPertenecesindicato) {
        this.supPertenecesindicato = supPertenecesindicato;
    }

    public String getSupOrganizacionsindical() {
        return supOrganizacionsindical;
    }

    public void setSupOrganizacionsindical(String supOrganizacionsindical) {
        this.supOrganizacionsindical = supOrganizacionsindical;
    }

    public String getSupFechaafiliacion() {
        return supFechaafiliacion;
    }

    public void setSupFechaafiliacion(String supFechaafiliacion) {
        this.supFechaafiliacion = supFechaafiliacion;
    }

    public String getSupTipovinculacion() {
        return supTipovinculacion;
    }

    public void setSupTipovinculacion(String supTipovinculacion) {
        this.supTipovinculacion = supTipovinculacion;
    }

    public String getSupDiasotorgadosmes() {
        return supDiasotorgadosmes;
    }

    public void setSupDiasotorgadosmes(String supDiasotorgadosmes) {
        this.supDiasotorgadosmes = supDiasotorgadosmes;
    }

    public String getSupJustificacionpermiso() {
        return supJustificacionpermiso;
    }

    public void setSupJustificacionpermiso(String supJustificacionpermiso) {
        this.supJustificacionpermiso = supJustificacionpermiso;
    }

    public String getSupAnosenentidad() {
        return supAnosenentidad;
    }

    public void setSupAnosenentidad(String supAnosenentidad) {
        this.supAnosenentidad = supAnosenentidad;
    }

    public String getSupEdad() {
        return supEdad;
    }

    public void setSupEdad(String supEdad) {
        this.supEdad = supEdad;
    }

    public String getSupAnoreporte() {
        return supAnoreporte;
    }

    public void setSupAnoreporte(String supAnoreporte) {
        this.supAnoreporte = supAnoreporte;
    }

    public Integer getEtdId() {
        return etdId;
    }

    public void setEtdId(Integer etdId) {
        this.etdId = etdId;
    }

    public SysRegistrocarga getLgregId() {
        return lgregId;
    }

    public void setLgregId(SysRegistrocarga lgregId) {
        this.lgregId = lgregId;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (supId != null ? supId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ThmSupernumerarios)) {
            return false;
        }
        ThmSupernumerarios other = (ThmSupernumerarios) object;
        return !((this.supId == null && other.supId != null) || (this.supId != null && !this.supId.equals(other.supId)));
    }

    @Override
    public String toString() {
        return "com.veeduria.dao.ThmSupernumerarios[ supId=" + supId + " ]";
    }
    
}
