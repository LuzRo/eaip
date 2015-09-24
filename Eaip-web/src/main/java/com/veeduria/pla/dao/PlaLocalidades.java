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
@Table(name = "pla_localidades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlaLocalidades.findAll", query = "SELECT p FROM PlaLocalidades p"),
    @NamedQuery(name = "PlaLocalidades.findByPloId", query = "SELECT p FROM PlaLocalidades p WHERE p.ploId = :ploId"),
    @NamedQuery(name = "PlaLocalidades.findByPloIdrep", query = "SELECT p FROM PlaLocalidades p WHERE p.ploIdrep = :ploIdrep"),
    @NamedQuery(name = "PlaLocalidades.findByPloCodigopd", query = "SELECT p FROM PlaLocalidades p WHERE p.ploCodigopd = :ploCodigopd"),
    @NamedQuery(name = "PlaLocalidades.findByPloNombrepd", query = "SELECT p FROM PlaLocalidades p WHERE p.ploNombrepd = :ploNombrepd"),
    @NamedQuery(name = "PlaLocalidades.findByPloSiglapd", query = "SELECT p FROM PlaLocalidades p WHERE p.ploSiglapd = :ploSiglapd"),
    @NamedQuery(name = "PlaLocalidades.findByPloAnoprogrepr", query = "SELECT p FROM PlaLocalidades p WHERE p.ploAnoprogrepr = :ploAnoprogrepr"),
    @NamedQuery(name = "PlaLocalidades.findByPloFechaseguim", query = "SELECT p FROM PlaLocalidades p WHERE p.ploFechaseguim = :ploFechaseguim"),
    @NamedQuery(name = "PlaLocalidades.findByPloRecursos", query = "SELECT p FROM PlaLocalidades p WHERE p.ploRecursos = :ploRecursos"),
    @NamedQuery(name = "PlaLocalidades.findByPloVersionpa", query = "SELECT p FROM PlaLocalidades p WHERE p.ploVersionpa = :ploVersionpa"),
    @NamedQuery(name = "PlaLocalidades.findByPloBtdescversionpa", query = "SELECT p FROM PlaLocalidades p WHERE p.ploBtdescversionpa = :ploBtdescversionpa"),
    @NamedQuery(name = "PlaLocalidades.findByPloCodigoentidad", query = "SELECT p FROM PlaLocalidades p WHERE p.ploCodigoentidad = :ploCodigoentidad"),
    @NamedQuery(name = "PlaLocalidades.findByPloNombreentidad", query = "SELECT p FROM PlaLocalidades p WHERE p.ploNombreentidad = :ploNombreentidad"),
    @NamedQuery(name = "PlaLocalidades.findByPloSiglaent", query = "SELECT p FROM PlaLocalidades p WHERE p.ploSiglaent = :ploSiglaent"),
    @NamedQuery(name = "PlaLocalidades.findByPloCodigosector", query = "SELECT p FROM PlaLocalidades p WHERE p.ploCodigosector = :ploCodigosector"),
    @NamedQuery(name = "PlaLocalidades.findByPloBtdesccodsector", query = "SELECT p FROM PlaLocalidades p WHERE p.ploBtdesccodsector = :ploBtdesccodsector"),
    @NamedQuery(name = "PlaLocalidades.findByPloCodcomponenten1", query = "SELECT p FROM PlaLocalidades p WHERE p.ploCodcomponenten1 = :ploCodcomponenten1"),
    @NamedQuery(name = "PlaLocalidades.findByPloNomcomponenten1", query = "SELECT p FROM PlaLocalidades p WHERE p.ploNomcomponenten1 = :ploNomcomponenten1"),
    @NamedQuery(name = "PlaLocalidades.findByPloCodcomponenten2", query = "SELECT p FROM PlaLocalidades p WHERE p.ploCodcomponenten2 = :ploCodcomponenten2"),
    @NamedQuery(name = "PlaLocalidades.findByPloNomcomponenten2", query = "SELECT p FROM PlaLocalidades p WHERE p.ploNomcomponenten2 = :ploNomcomponenten2"),
    @NamedQuery(name = "PlaLocalidades.findByPloCodcomponenten3", query = "SELECT p FROM PlaLocalidades p WHERE p.ploCodcomponenten3 = :ploCodcomponenten3"),
    @NamedQuery(name = "PlaLocalidades.findByPloNomcomponenten3", query = "SELECT p FROM PlaLocalidades p WHERE p.ploNomcomponenten3 = :ploNomcomponenten3"),
    @NamedQuery(name = "PlaLocalidades.findByPloCodcomponenten4", query = "SELECT p FROM PlaLocalidades p WHERE p.ploCodcomponenten4 = :ploCodcomponenten4"),
    @NamedQuery(name = "PlaLocalidades.findByPloNomcomponenten4", query = "SELECT p FROM PlaLocalidades p WHERE p.ploNomcomponenten4 = :ploNomcomponenten4"),
    @NamedQuery(name = "PlaLocalidades.findByPloCodcomponenten5", query = "SELECT p FROM PlaLocalidades p WHERE p.ploCodcomponenten5 = :ploCodcomponenten5"),
    @NamedQuery(name = "PlaLocalidades.findByPloNomcomponenten5", query = "SELECT p FROM PlaLocalidades p WHERE p.ploNomcomponenten5 = :ploNomcomponenten5"),
    @NamedQuery(name = "PlaLocalidades.findByPloCodcomponenten6", query = "SELECT p FROM PlaLocalidades p WHERE p.ploCodcomponenten6 = :ploCodcomponenten6"),
    @NamedQuery(name = "PlaLocalidades.findByPloNomcomponenten6", query = "SELECT p FROM PlaLocalidades p WHERE p.ploNomcomponenten6 = :ploNomcomponenten6"),
    @NamedQuery(name = "PlaLocalidades.findByPloCodcomponenten7", query = "SELECT p FROM PlaLocalidades p WHERE p.ploCodcomponenten7 = :ploCodcomponenten7"),
    @NamedQuery(name = "PlaLocalidades.findByPloNomcomponenten7", query = "SELECT p FROM PlaLocalidades p WHERE p.ploNomcomponenten7 = :ploNomcomponenten7"),
    @NamedQuery(name = "PlaLocalidades.findByPloCodigoproyecto", query = "SELECT p FROM PlaLocalidades p WHERE p.ploCodigoproyecto = :ploCodigoproyecto"),
    @NamedQuery(name = "PlaLocalidades.findByPloNomproyecto", query = "SELECT p FROM PlaLocalidades p WHERE p.ploNomproyecto = :ploNomproyecto"),
    @NamedQuery(name = "PlaLocalidades.findByPloVersionpy", query = "SELECT p FROM PlaLocalidades p WHERE p.ploVersionpy = :ploVersionpy"),
    @NamedQuery(name = "PlaLocalidades.findByPloCodinternometa", query = "SELECT p FROM PlaLocalidades p WHERE p.ploCodinternometa = :ploCodinternometa"),
    @NamedQuery(name = "PlaLocalidades.findByPloDescripcionmeta", query = "SELECT p FROM PlaLocalidades p WHERE p.ploDescripcionmeta = :ploDescripcionmeta"),
    @NamedQuery(name = "PlaLocalidades.findByPloTipoanualizacion", query = "SELECT p FROM PlaLocalidades p WHERE p.ploTipoanualizacion = :ploTipoanualizacion"),
    @NamedQuery(name = "PlaLocalidades.findByPloBtdesctipoanual", query = "SELECT p FROM PlaLocalidades p WHERE p.ploBtdesctipoanual = :ploBtdesctipoanual"),
    @NamedQuery(name = "PlaLocalidades.findByPloEstadoprogmeta", query = "SELECT p FROM PlaLocalidades p WHERE p.ploEstadoprogmeta = :ploEstadoprogmeta"),
    @NamedQuery(name = "PlaLocalidades.findByPloBtdescestadoprogmeta", query = "SELECT p FROM PlaLocalidades p WHERE p.ploBtdescestadoprogmeta = :ploBtdescestadoprogmeta"),
    @NamedQuery(name = "PlaLocalidades.findByPloOrigen", query = "SELECT p FROM PlaLocalidades p WHERE p.ploOrigen = :ploOrigen"),
    @NamedQuery(name = "PlaLocalidades.findByPloProgano1", query = "SELECT p FROM PlaLocalidades p WHERE p.ploProgano1 = :ploProgano1"),
    @NamedQuery(name = "PlaLocalidades.findByPloEjecano1", query = "SELECT p FROM PlaLocalidades p WHERE p.ploEjecano1 = :ploEjecano1"),
    @NamedQuery(name = "PlaLocalidades.findByPloAvanceano1", query = "SELECT p FROM PlaLocalidades p WHERE p.ploAvanceano1 = :ploAvanceano1"),
    @NamedQuery(name = "PlaLocalidades.findByPloProgano2", query = "SELECT p FROM PlaLocalidades p WHERE p.ploProgano2 = :ploProgano2"),
    @NamedQuery(name = "PlaLocalidades.findByPloEjecano2", query = "SELECT p FROM PlaLocalidades p WHERE p.ploEjecano2 = :ploEjecano2"),
    @NamedQuery(name = "PlaLocalidades.findByPloAvanceano2", query = "SELECT p FROM PlaLocalidades p WHERE p.ploAvanceano2 = :ploAvanceano2"),
    @NamedQuery(name = "PlaLocalidades.findByPloProgano3", query = "SELECT p FROM PlaLocalidades p WHERE p.ploProgano3 = :ploProgano3"),
    @NamedQuery(name = "PlaLocalidades.findByPloEjecano3", query = "SELECT p FROM PlaLocalidades p WHERE p.ploEjecano3 = :ploEjecano3"),
    @NamedQuery(name = "PlaLocalidades.findByPloAvanceano3", query = "SELECT p FROM PlaLocalidades p WHERE p.ploAvanceano3 = :ploAvanceano3"),
    @NamedQuery(name = "PlaLocalidades.findByPloProgano4", query = "SELECT p FROM PlaLocalidades p WHERE p.ploProgano4 = :ploProgano4"),
    @NamedQuery(name = "PlaLocalidades.findByPloEjecano4", query = "SELECT p FROM PlaLocalidades p WHERE p.ploEjecano4 = :ploEjecano4"),
    @NamedQuery(name = "PlaLocalidades.findByPloAvanceano4", query = "SELECT p FROM PlaLocalidades p WHERE p.ploAvanceano4 = :ploAvanceano4"),
    @NamedQuery(name = "PlaLocalidades.findByPloProgano5", query = "SELECT p FROM PlaLocalidades p WHERE p.ploProgano5 = :ploProgano5"),
    @NamedQuery(name = "PlaLocalidades.findByPloEjecano5", query = "SELECT p FROM PlaLocalidades p WHERE p.ploEjecano5 = :ploEjecano5"),
    @NamedQuery(name = "PlaLocalidades.findByPloAvanceano5", query = "SELECT p FROM PlaLocalidades p WHERE p.ploAvanceano5 = :ploAvanceano5"),
    @NamedQuery(name = "PlaLocalidades.findByPloProgtot", query = "SELECT p FROM PlaLocalidades p WHERE p.ploProgtot = :ploProgtot"),
    @NamedQuery(name = "PlaLocalidades.findByPloEjectot", query = "SELECT p FROM PlaLocalidades p WHERE p.ploEjectot = :ploEjectot"),
    @NamedQuery(name = "PlaLocalidades.findByPloAvancetot", query = "SELECT p FROM PlaLocalidades p WHERE p.ploAvancetot = :ploAvancetot"),
    @NamedQuery(name = "PlaLocalidades.findByPloProgrecano1", query = "SELECT p FROM PlaLocalidades p WHERE p.ploProgrecano1 = :ploProgrecano1"),
    @NamedQuery(name = "PlaLocalidades.findByPloEjecrecano1", query = "SELECT p FROM PlaLocalidades p WHERE p.ploEjecrecano1 = :ploEjecrecano1"),
    @NamedQuery(name = "PlaLocalidades.findByPloAvancerecano1", query = "SELECT p FROM PlaLocalidades p WHERE p.ploAvancerecano1 = :ploAvancerecano1"),
    @NamedQuery(name = "PlaLocalidades.findByPloProgrecano2", query = "SELECT p FROM PlaLocalidades p WHERE p.ploProgrecano2 = :ploProgrecano2"),
    @NamedQuery(name = "PlaLocalidades.findByPloEjecrecano2", query = "SELECT p FROM PlaLocalidades p WHERE p.ploEjecrecano2 = :ploEjecrecano2"),
    @NamedQuery(name = "PlaLocalidades.findByPloAvancerecano2", query = "SELECT p FROM PlaLocalidades p WHERE p.ploAvancerecano2 = :ploAvancerecano2"),
    @NamedQuery(name = "PlaLocalidades.findByPloProgrecano3", query = "SELECT p FROM PlaLocalidades p WHERE p.ploProgrecano3 = :ploProgrecano3"),
    @NamedQuery(name = "PlaLocalidades.findByPloEjecrecano3", query = "SELECT p FROM PlaLocalidades p WHERE p.ploEjecrecano3 = :ploEjecrecano3"),
    @NamedQuery(name = "PlaLocalidades.findByPloAvancerecano3", query = "SELECT p FROM PlaLocalidades p WHERE p.ploAvancerecano3 = :ploAvancerecano3"),
    @NamedQuery(name = "PlaLocalidades.findByPloProgrecano4", query = "SELECT p FROM PlaLocalidades p WHERE p.ploProgrecano4 = :ploProgrecano4"),
    @NamedQuery(name = "PlaLocalidades.findByPloEjecrecano4", query = "SELECT p FROM PlaLocalidades p WHERE p.ploEjecrecano4 = :ploEjecrecano4"),
    @NamedQuery(name = "PlaLocalidades.findByPloAvancerecano4", query = "SELECT p FROM PlaLocalidades p WHERE p.ploAvancerecano4 = :ploAvancerecano4"),
    @NamedQuery(name = "PlaLocalidades.findByPloProgrecano5", query = "SELECT p FROM PlaLocalidades p WHERE p.ploProgrecano5 = :ploProgrecano5"),
    @NamedQuery(name = "PlaLocalidades.findByPloEjecrecano5", query = "SELECT p FROM PlaLocalidades p WHERE p.ploEjecrecano5 = :ploEjecrecano5"),
    @NamedQuery(name = "PlaLocalidades.findByPloAvancerecano5", query = "SELECT p FROM PlaLocalidades p WHERE p.ploAvancerecano5 = :ploAvancerecano5"),
    @NamedQuery(name = "PlaLocalidades.findByPloProgrectot", query = "SELECT p FROM PlaLocalidades p WHERE p.ploProgrectot = :ploProgrectot"),
    @NamedQuery(name = "PlaLocalidades.findByPloEjecrectot", query = "SELECT p FROM PlaLocalidades p WHERE p.ploEjecrectot = :ploEjecrectot"),
    @NamedQuery(name = "PlaLocalidades.findByPloAvancerectot", query = "SELECT p FROM PlaLocalidades p WHERE p.ploAvancerectot = :ploAvancerectot"),
    @NamedQuery(name = "PlaLocalidades.findByPloObservaciones", query = "SELECT p FROM PlaLocalidades p WHERE p.ploObservaciones = :ploObservaciones")})
public class PlaLocalidades implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "plo_id")
    private Long ploId;
    @Size(max = 1500)
    @Column(name = "plo_idrep")
    private String ploIdrep;
    @Size(max = 100)
    @Column(name = "plo_codigopd")
    private String ploCodigopd;
    @Size(max = 1500)
    @Column(name = "plo_nombrepd")
    private String ploNombrepd;
    @Size(max = 200)
    @Column(name = "plo_siglapd")
    private String ploSiglapd;
    @Size(max = 100)
    @Column(name = "plo_anoprogrepr")
    private String ploAnoprogrepr;
    @Size(max = 500)
    @Column(name = "plo_fechaseguim")
    private String ploFechaseguim;
    @Size(max = 500)
    @Column(name = "plo_recursos")
    private String ploRecursos;
    @Size(max = 100)
    @Column(name = "plo_versionpa")
    private String ploVersionpa;
    @Size(max = 500)
    @Column(name = "plo_btdescversionpa")
    private String ploBtdescversionpa;
    @Size(max = 100)
    @Column(name = "plo_codigoentidad")
    private String ploCodigoentidad;
    @Size(max = 1500)
    @Column(name = "plo_nombreentidad")
    private String ploNombreentidad;
    @Size(max = 100)
    @Column(name = "plo_siglaent")
    private String ploSiglaent;
    @Size(max = 100)
    @Column(name = "plo_codigosector")
    private String ploCodigosector;
    @Size(max = 1500)
    @Column(name = "plo_btdesccodsector")
    private String ploBtdesccodsector;
    @Size(max = 100)
    @Column(name = "plo_codcomponenten1")
    private String ploCodcomponenten1;
    @Size(max = 1500)
    @Column(name = "plo_nomcomponenten1")
    private String ploNomcomponenten1;
    @Size(max = 100)
    @Column(name = "plo_codcomponenten2")
    private String ploCodcomponenten2;
    @Size(max = 1500)
    @Column(name = "plo_nomcomponenten2")
    private String ploNomcomponenten2;
    @Size(max = 100)
    @Column(name = "plo_codcomponenten3")
    private String ploCodcomponenten3;
    @Size(max = 1500)
    @Column(name = "plo_nomcomponenten3")
    private String ploNomcomponenten3;
    @Size(max = 100)
    @Column(name = "plo_codcomponenten4")
    private String ploCodcomponenten4;
    @Size(max = 1500)
    @Column(name = "plo_nomcomponenten4")
    private String ploNomcomponenten4;
    @Size(max = 100)
    @Column(name = "plo_codcomponenten5")
    private String ploCodcomponenten5;
    @Size(max = 1500)
    @Column(name = "plo_nomcomponenten5")
    private String ploNomcomponenten5;
    @Size(max = 100)
    @Column(name = "plo_codcomponenten6")
    private String ploCodcomponenten6;
    @Size(max = 1500)
    @Column(name = "plo_nomcomponenten6")
    private String ploNomcomponenten6;
    @Size(max = 100)
    @Column(name = "plo_codcomponenten7")
    private String ploCodcomponenten7;
    @Size(max = 1500)
    @Column(name = "plo_nomcomponenten7")
    private String ploNomcomponenten7;
    @Size(max = 100)
    @Column(name = "plo_codigoproyecto")
    private String ploCodigoproyecto;
    @Size(max = 1500)
    @Column(name = "plo_nomproyecto")
    private String ploNomproyecto;
    @Size(max = 100)
    @Column(name = "plo_versionpy")
    private String ploVersionpy;
    @Size(max = 100)
    @Column(name = "plo_codinternometa")
    private String ploCodinternometa;
    @Size(max = 1500)
    @Column(name = "plo_descripcionmeta")
    private String ploDescripcionmeta;
    @Size(max = 100)
    @Column(name = "plo_tipoanualizacion")
    private String ploTipoanualizacion;
    @Size(max = 500)
    @Column(name = "plo_btdesctipoanual")
    private String ploBtdesctipoanual;
    @Size(max = 100)
    @Column(name = "plo_estadoprogmeta")
    private String ploEstadoprogmeta;
    @Size(max = 500)
    @Column(name = "plo_btdescestadoprogmeta")
    private String ploBtdescestadoprogmeta;
    @Size(max = 100)
    @Column(name = "plo_origen")
    private String ploOrigen;
    @Size(max = 100)
    @Column(name = "plo_progano1")
    private String ploProgano1;
    @Size(max = 100)
    @Column(name = "plo_ejecano1")
    private String ploEjecano1;
    @Size(max = 100)
    @Column(name = "plo_avanceano1")
    private String ploAvanceano1;
    @Size(max = 100)
    @Column(name = "plo_progano2")
    private String ploProgano2;
    @Size(max = 100)
    @Column(name = "plo_ejecano2")
    private String ploEjecano2;
    @Size(max = 100)
    @Column(name = "plo_avanceano2")
    private String ploAvanceano2;
    @Size(max = 100)
    @Column(name = "plo_progano3")
    private String ploProgano3;
    @Size(max = 100)
    @Column(name = "plo_ejecano3")
    private String ploEjecano3;
    @Size(max = 100)
    @Column(name = "plo_avanceano3")
    private String ploAvanceano3;
    @Size(max = 100)
    @Column(name = "plo_progano4")
    private String ploProgano4;
    @Size(max = 100)
    @Column(name = "plo_ejecano4")
    private String ploEjecano4;
    @Size(max = 100)
    @Column(name = "plo_avanceano4")
    private String ploAvanceano4;
    @Size(max = 100)
    @Column(name = "plo_progano5")
    private String ploProgano5;
    @Size(max = 100)
    @Column(name = "plo_ejecano5")
    private String ploEjecano5;
    @Size(max = 100)
    @Column(name = "plo_avanceano5")
    private String ploAvanceano5;
    @Size(max = 100)
    @Column(name = "plo_progtot")
    private String ploProgtot;
    @Size(max = 100)
    @Column(name = "plo_ejectot")
    private String ploEjectot;
    @Size(max = 100)
    @Column(name = "plo_avancetot")
    private String ploAvancetot;
    @Size(max = 200)
    @Column(name = "plo_progrecano1")
    private String ploProgrecano1;
    @Size(max = 200)
    @Column(name = "plo_ejecrecano1")
    private String ploEjecrecano1;
    @Size(max = 200)
    @Column(name = "plo_avancerecano1")
    private String ploAvancerecano1;
    @Size(max = 200)
    @Column(name = "plo_progrecano2")
    private String ploProgrecano2;
    @Size(max = 200)
    @Column(name = "plo_ejecrecano2")
    private String ploEjecrecano2;
    @Size(max = 200)
    @Column(name = "plo_avancerecano2")
    private String ploAvancerecano2;
    @Size(max = 200)
    @Column(name = "plo_progrecano3")
    private String ploProgrecano3;
    @Size(max = 200)
    @Column(name = "plo_ejecrecano3")
    private String ploEjecrecano3;
    @Size(max = 200)
    @Column(name = "plo_avancerecano3")
    private String ploAvancerecano3;
    @Size(max = 200)
    @Column(name = "plo_progrecano4")
    private String ploProgrecano4;
    @Size(max = 200)
    @Column(name = "plo_ejecrecano4")
    private String ploEjecrecano4;
    @Size(max = 200)
    @Column(name = "plo_avancerecano4")
    private String ploAvancerecano4;
    @Size(max = 200)
    @Column(name = "plo_progrecano5")
    private String ploProgrecano5;
    @Size(max = 200)
    @Column(name = "plo_ejecrecano5")
    private String ploEjecrecano5;
    @Size(max = 200)
    @Column(name = "plo_avancerecano5")
    private String ploAvancerecano5;
    @Size(max = 200)
    @Column(name = "plo_progrectot")
    private String ploProgrectot;
    @Size(max = 200)
    @Column(name = "plo_ejecrectot")
    private String ploEjecrectot;
    @Size(max = 200)
    @Column(name = "plo_avancerectot")
    private String ploAvancerectot;
    @Size(max = 1500)
    @Column(name = "plo_observaciones")
    private String ploObservaciones;
    @JoinColumn(name = "lgreg_id", referencedColumnName = "lgreg_id")
    @ManyToOne(optional = false)
    private SysRegistrocarga lgregId;

    public PlaLocalidades() {
    }

    public PlaLocalidades(Long ploId) {
        this.ploId = ploId;
    }

    public Long getPloId() {
        return ploId;
    }

    public void setPloId(Long ploId) {
        this.ploId = ploId;
    }

    public String getPloIdrep() {
        return ploIdrep;
    }

    public void setPloIdrep(String ploIdrep) {
        this.ploIdrep = ploIdrep;
    }

    public String getPloCodigopd() {
        return ploCodigopd;
    }

    public void setPloCodigopd(String ploCodigopd) {
        this.ploCodigopd = ploCodigopd;
    }

    public String getPloNombrepd() {
        return ploNombrepd;
    }

    public void setPloNombrepd(String ploNombrepd) {
        this.ploNombrepd = ploNombrepd;
    }

    public String getPloSiglapd() {
        return ploSiglapd;
    }

    public void setPloSiglapd(String ploSiglapd) {
        this.ploSiglapd = ploSiglapd;
    }

    public String getPloAnoprogrepr() {
        return ploAnoprogrepr;
    }

    public void setPloAnoprogrepr(String ploAnoprogrepr) {
        this.ploAnoprogrepr = ploAnoprogrepr;
    }

    public String getPloFechaseguim() {
        return ploFechaseguim;
    }

    public void setPloFechaseguim(String ploFechaseguim) {
        this.ploFechaseguim = ploFechaseguim;
    }

    public String getPloRecursos() {
        return ploRecursos;
    }

    public void setPloRecursos(String ploRecursos) {
        this.ploRecursos = ploRecursos;
    }

    public String getPloVersionpa() {
        return ploVersionpa;
    }

    public void setPloVersionpa(String ploVersionpa) {
        this.ploVersionpa = ploVersionpa;
    }

    public String getPloBtdescversionpa() {
        return ploBtdescversionpa;
    }

    public void setPloBtdescversionpa(String ploBtdescversionpa) {
        this.ploBtdescversionpa = ploBtdescversionpa;
    }

    public String getPloCodigoentidad() {
        return ploCodigoentidad;
    }

    public void setPloCodigoentidad(String ploCodigoentidad) {
        this.ploCodigoentidad = ploCodigoentidad;
    }

    public String getPloNombreentidad() {
        return ploNombreentidad;
    }

    public void setPloNombreentidad(String ploNombreentidad) {
        this.ploNombreentidad = ploNombreentidad;
    }

    public String getPloSiglaent() {
        return ploSiglaent;
    }

    public void setPloSiglaent(String ploSiglaent) {
        this.ploSiglaent = ploSiglaent;
    }

    public String getPloCodigosector() {
        return ploCodigosector;
    }

    public void setPloCodigosector(String ploCodigosector) {
        this.ploCodigosector = ploCodigosector;
    }

    public String getPloBtdesccodsector() {
        return ploBtdesccodsector;
    }

    public void setPloBtdesccodsector(String ploBtdesccodsector) {
        this.ploBtdesccodsector = ploBtdesccodsector;
    }

    public String getPloCodcomponenten1() {
        return ploCodcomponenten1;
    }

    public void setPloCodcomponenten1(String ploCodcomponenten1) {
        this.ploCodcomponenten1 = ploCodcomponenten1;
    }

    public String getPloNomcomponenten1() {
        return ploNomcomponenten1;
    }

    public void setPloNomcomponenten1(String ploNomcomponenten1) {
        this.ploNomcomponenten1 = ploNomcomponenten1;
    }

    public String getPloCodcomponenten2() {
        return ploCodcomponenten2;
    }

    public void setPloCodcomponenten2(String ploCodcomponenten2) {
        this.ploCodcomponenten2 = ploCodcomponenten2;
    }

    public String getPloNomcomponenten2() {
        return ploNomcomponenten2;
    }

    public void setPloNomcomponenten2(String ploNomcomponenten2) {
        this.ploNomcomponenten2 = ploNomcomponenten2;
    }

    public String getPloCodcomponenten3() {
        return ploCodcomponenten3;
    }

    public void setPloCodcomponenten3(String ploCodcomponenten3) {
        this.ploCodcomponenten3 = ploCodcomponenten3;
    }

    public String getPloNomcomponenten3() {
        return ploNomcomponenten3;
    }

    public void setPloNomcomponenten3(String ploNomcomponenten3) {
        this.ploNomcomponenten3 = ploNomcomponenten3;
    }

    public String getPloCodcomponenten4() {
        return ploCodcomponenten4;
    }

    public void setPloCodcomponenten4(String ploCodcomponenten4) {
        this.ploCodcomponenten4 = ploCodcomponenten4;
    }

    public String getPloNomcomponenten4() {
        return ploNomcomponenten4;
    }

    public void setPloNomcomponenten4(String ploNomcomponenten4) {
        this.ploNomcomponenten4 = ploNomcomponenten4;
    }

    public String getPloCodcomponenten5() {
        return ploCodcomponenten5;
    }

    public void setPloCodcomponenten5(String ploCodcomponenten5) {
        this.ploCodcomponenten5 = ploCodcomponenten5;
    }

    public String getPloNomcomponenten5() {
        return ploNomcomponenten5;
    }

    public void setPloNomcomponenten5(String ploNomcomponenten5) {
        this.ploNomcomponenten5 = ploNomcomponenten5;
    }

    public String getPloCodcomponenten6() {
        return ploCodcomponenten6;
    }

    public void setPloCodcomponenten6(String ploCodcomponenten6) {
        this.ploCodcomponenten6 = ploCodcomponenten6;
    }

    public String getPloNomcomponenten6() {
        return ploNomcomponenten6;
    }

    public void setPloNomcomponenten6(String ploNomcomponenten6) {
        this.ploNomcomponenten6 = ploNomcomponenten6;
    }

    public String getPloCodcomponenten7() {
        return ploCodcomponenten7;
    }

    public void setPloCodcomponenten7(String ploCodcomponenten7) {
        this.ploCodcomponenten7 = ploCodcomponenten7;
    }

    public String getPloNomcomponenten7() {
        return ploNomcomponenten7;
    }

    public void setPloNomcomponenten7(String ploNomcomponenten7) {
        this.ploNomcomponenten7 = ploNomcomponenten7;
    }

    public String getPloCodigoproyecto() {
        return ploCodigoproyecto;
    }

    public void setPloCodigoproyecto(String ploCodigoproyecto) {
        this.ploCodigoproyecto = ploCodigoproyecto;
    }

    public String getPloNomproyecto() {
        return ploNomproyecto;
    }

    public void setPloNomproyecto(String ploNomproyecto) {
        this.ploNomproyecto = ploNomproyecto;
    }

    public String getPloVersionpy() {
        return ploVersionpy;
    }

    public void setPloVersionpy(String ploVersionpy) {
        this.ploVersionpy = ploVersionpy;
    }

    public String getPloCodinternometa() {
        return ploCodinternometa;
    }

    public void setPloCodinternometa(String ploCodinternometa) {
        this.ploCodinternometa = ploCodinternometa;
    }

    public String getPloDescripcionmeta() {
        return ploDescripcionmeta;
    }

    public void setPloDescripcionmeta(String ploDescripcionmeta) {
        this.ploDescripcionmeta = ploDescripcionmeta;
    }

    public String getPloTipoanualizacion() {
        return ploTipoanualizacion;
    }

    public void setPloTipoanualizacion(String ploTipoanualizacion) {
        this.ploTipoanualizacion = ploTipoanualizacion;
    }

    public String getPloBtdesctipoanual() {
        return ploBtdesctipoanual;
    }

    public void setPloBtdesctipoanual(String ploBtdesctipoanual) {
        this.ploBtdesctipoanual = ploBtdesctipoanual;
    }

    public String getPloEstadoprogmeta() {
        return ploEstadoprogmeta;
    }

    public void setPloEstadoprogmeta(String ploEstadoprogmeta) {
        this.ploEstadoprogmeta = ploEstadoprogmeta;
    }

    public String getPloBtdescestadoprogmeta() {
        return ploBtdescestadoprogmeta;
    }

    public void setPloBtdescestadoprogmeta(String ploBtdescestadoprogmeta) {
        this.ploBtdescestadoprogmeta = ploBtdescestadoprogmeta;
    }

    public String getPloOrigen() {
        return ploOrigen;
    }

    public void setPloOrigen(String ploOrigen) {
        this.ploOrigen = ploOrigen;
    }

    public String getPloProgano1() {
        return ploProgano1;
    }

    public void setPloProgano1(String ploProgano1) {
        this.ploProgano1 = ploProgano1;
    }

    public String getPloEjecano1() {
        return ploEjecano1;
    }

    public void setPloEjecano1(String ploEjecano1) {
        this.ploEjecano1 = ploEjecano1;
    }

    public String getPloAvanceano1() {
        return ploAvanceano1;
    }

    public void setPloAvanceano1(String ploAvanceano1) {
        this.ploAvanceano1 = ploAvanceano1;
    }

    public String getPloProgano2() {
        return ploProgano2;
    }

    public void setPloProgano2(String ploProgano2) {
        this.ploProgano2 = ploProgano2;
    }

    public String getPloEjecano2() {
        return ploEjecano2;
    }

    public void setPloEjecano2(String ploEjecano2) {
        this.ploEjecano2 = ploEjecano2;
    }

    public String getPloAvanceano2() {
        return ploAvanceano2;
    }

    public void setPloAvanceano2(String ploAvanceano2) {
        this.ploAvanceano2 = ploAvanceano2;
    }

    public String getPloProgano3() {
        return ploProgano3;
    }

    public void setPloProgano3(String ploProgano3) {
        this.ploProgano3 = ploProgano3;
    }

    public String getPloEjecano3() {
        return ploEjecano3;
    }

    public void setPloEjecano3(String ploEjecano3) {
        this.ploEjecano3 = ploEjecano3;
    }

    public String getPloAvanceano3() {
        return ploAvanceano3;
    }

    public void setPloAvanceano3(String ploAvanceano3) {
        this.ploAvanceano3 = ploAvanceano3;
    }

    public String getPloProgano4() {
        return ploProgano4;
    }

    public void setPloProgano4(String ploProgano4) {
        this.ploProgano4 = ploProgano4;
    }

    public String getPloEjecano4() {
        return ploEjecano4;
    }

    public void setPloEjecano4(String ploEjecano4) {
        this.ploEjecano4 = ploEjecano4;
    }

    public String getPloAvanceano4() {
        return ploAvanceano4;
    }

    public void setPloAvanceano4(String ploAvanceano4) {
        this.ploAvanceano4 = ploAvanceano4;
    }

    public String getPloProgano5() {
        return ploProgano5;
    }

    public void setPloProgano5(String ploProgano5) {
        this.ploProgano5 = ploProgano5;
    }

    public String getPloEjecano5() {
        return ploEjecano5;
    }

    public void setPloEjecano5(String ploEjecano5) {
        this.ploEjecano5 = ploEjecano5;
    }

    public String getPloAvanceano5() {
        return ploAvanceano5;
    }

    public void setPloAvanceano5(String ploAvanceano5) {
        this.ploAvanceano5 = ploAvanceano5;
    }

    public String getPloProgtot() {
        return ploProgtot;
    }

    public void setPloProgtot(String ploProgtot) {
        this.ploProgtot = ploProgtot;
    }

    public String getPloEjectot() {
        return ploEjectot;
    }

    public void setPloEjectot(String ploEjectot) {
        this.ploEjectot = ploEjectot;
    }

    public String getPloAvancetot() {
        return ploAvancetot;
    }

    public void setPloAvancetot(String ploAvancetot) {
        this.ploAvancetot = ploAvancetot;
    }

    public String getPloProgrecano1() {
        return ploProgrecano1;
    }

    public void setPloProgrecano1(String ploProgrecano1) {
        this.ploProgrecano1 = ploProgrecano1;
    }

    public String getPloEjecrecano1() {
        return ploEjecrecano1;
    }

    public void setPloEjecrecano1(String ploEjecrecano1) {
        this.ploEjecrecano1 = ploEjecrecano1;
    }

    public String getPloAvancerecano1() {
        return ploAvancerecano1;
    }

    public void setPloAvancerecano1(String ploAvancerecano1) {
        this.ploAvancerecano1 = ploAvancerecano1;
    }

    public String getPloProgrecano2() {
        return ploProgrecano2;
    }

    public void setPloProgrecano2(String ploProgrecano2) {
        this.ploProgrecano2 = ploProgrecano2;
    }

    public String getPloEjecrecano2() {
        return ploEjecrecano2;
    }

    public void setPloEjecrecano2(String ploEjecrecano2) {
        this.ploEjecrecano2 = ploEjecrecano2;
    }

    public String getPloAvancerecano2() {
        return ploAvancerecano2;
    }

    public void setPloAvancerecano2(String ploAvancerecano2) {
        this.ploAvancerecano2 = ploAvancerecano2;
    }

    public String getPloProgrecano3() {
        return ploProgrecano3;
    }

    public void setPloProgrecano3(String ploProgrecano3) {
        this.ploProgrecano3 = ploProgrecano3;
    }

    public String getPloEjecrecano3() {
        return ploEjecrecano3;
    }

    public void setPloEjecrecano3(String ploEjecrecano3) {
        this.ploEjecrecano3 = ploEjecrecano3;
    }

    public String getPloAvancerecano3() {
        return ploAvancerecano3;
    }

    public void setPloAvancerecano3(String ploAvancerecano3) {
        this.ploAvancerecano3 = ploAvancerecano3;
    }

    public String getPloProgrecano4() {
        return ploProgrecano4;
    }

    public void setPloProgrecano4(String ploProgrecano4) {
        this.ploProgrecano4 = ploProgrecano4;
    }

    public String getPloEjecrecano4() {
        return ploEjecrecano4;
    }

    public void setPloEjecrecano4(String ploEjecrecano4) {
        this.ploEjecrecano4 = ploEjecrecano4;
    }

    public String getPloAvancerecano4() {
        return ploAvancerecano4;
    }

    public void setPloAvancerecano4(String ploAvancerecano4) {
        this.ploAvancerecano4 = ploAvancerecano4;
    }

    public String getPloProgrecano5() {
        return ploProgrecano5;
    }

    public void setPloProgrecano5(String ploProgrecano5) {
        this.ploProgrecano5 = ploProgrecano5;
    }

    public String getPloEjecrecano5() {
        return ploEjecrecano5;
    }

    public void setPloEjecrecano5(String ploEjecrecano5) {
        this.ploEjecrecano5 = ploEjecrecano5;
    }

    public String getPloAvancerecano5() {
        return ploAvancerecano5;
    }

    public void setPloAvancerecano5(String ploAvancerecano5) {
        this.ploAvancerecano5 = ploAvancerecano5;
    }

    public String getPloProgrectot() {
        return ploProgrectot;
    }

    public void setPloProgrectot(String ploProgrectot) {
        this.ploProgrectot = ploProgrectot;
    }

    public String getPloEjecrectot() {
        return ploEjecrectot;
    }

    public void setPloEjecrectot(String ploEjecrectot) {
        this.ploEjecrectot = ploEjecrectot;
    }

    public String getPloAvancerectot() {
        return ploAvancerectot;
    }

    public void setPloAvancerectot(String ploAvancerectot) {
        this.ploAvancerectot = ploAvancerectot;
    }

    public String getPloObservaciones() {
        return ploObservaciones;
    }

    public void setPloObservaciones(String ploObservaciones) {
        this.ploObservaciones = ploObservaciones;
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
        hash += (ploId != null ? ploId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlaLocalidades)) {
            return false;
        }
        PlaLocalidades other = (PlaLocalidades) object;
        if ((this.ploId == null && other.ploId != null) || (this.ploId != null && !this.ploId.equals(other.ploId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.veeduria.dao.PlaLocalidades[ ploId=" + ploId + " ]";
    }
    
}
