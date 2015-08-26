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
@Table(name = "pla_generalsec")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlaGeneralsec.findAll", query = "SELECT p FROM PlaGeneralsec p"),
    @NamedQuery(name = "PlaGeneralsec.findByPgeId", query = "SELECT p FROM PlaGeneralsec p WHERE p.pgeId = :pgeId"),
    @NamedQuery(name = "PlaGeneralsec.findByPgeGralid", query = "SELECT p FROM PlaGeneralsec p WHERE p.pgeGralid = :pgeGralid"),
    @NamedQuery(name = "PlaGeneralsec.findByPgeGralidrep", query = "SELECT p FROM PlaGeneralsec p WHERE p.pgeGralidrep = :pgeGralidrep"),
    @NamedQuery(name = "PlaGeneralsec.findByPgeGralcodigopd", query = "SELECT p FROM PlaGeneralsec p WHERE p.pgeGralcodigopd = :pgeGralcodigopd"),
    @NamedQuery(name = "PlaGeneralsec.findByPgeGralnombrepd", query = "SELECT p FROM PlaGeneralsec p WHERE p.pgeGralnombrepd = :pgeGralnombrepd"),
    @NamedQuery(name = "PlaGeneralsec.findByPgeGralanoprogrepr", query = "SELECT p FROM PlaGeneralsec p WHERE p.pgeGralanoprogrepr = :pgeGralanoprogrepr"),
    @NamedQuery(name = "PlaGeneralsec.findByPgeGralfechaseguim", query = "SELECT p FROM PlaGeneralsec p WHERE p.pgeGralfechaseguim = :pgeGralfechaseguim"),
    @NamedQuery(name = "PlaGeneralsec.findByPgeGralrecursos", query = "SELECT p FROM PlaGeneralsec p WHERE p.pgeGralrecursos = :pgeGralrecursos"),
    @NamedQuery(name = "PlaGeneralsec.findByPgeGralversionpa", query = "SELECT p FROM PlaGeneralsec p WHERE p.pgeGralversionpa = :pgeGralversionpa"),
    @NamedQuery(name = "PlaGeneralsec.findByPgeGralversionpadesc", query = "SELECT p FROM PlaGeneralsec p WHERE p.pgeGralversionpadesc = :pgeGralversionpadesc"),
    @NamedQuery(name = "PlaGeneralsec.findByPgeGralcodigosector", query = "SELECT p FROM PlaGeneralsec p WHERE p.pgeGralcodigosector = :pgeGralcodigosector"),
    @NamedQuery(name = "PlaGeneralsec.findByPgeGralsectordesc", query = "SELECT p FROM PlaGeneralsec p WHERE p.pgeGralsectordesc = :pgeGralsectordesc"),
    @NamedQuery(name = "PlaGeneralsec.findByPgeGralcodigoentidad", query = "SELECT p FROM PlaGeneralsec p WHERE p.pgeGralcodigoentidad = :pgeGralcodigoentidad"),
    @NamedQuery(name = "PlaGeneralsec.findByPgeGralnombreentidad", query = "SELECT p FROM PlaGeneralsec p WHERE p.pgeGralnombreentidad = :pgeGralnombreentidad"),
    @NamedQuery(name = "PlaGeneralsec.findByPgeGralcodcomponenten1", query = "SELECT p FROM PlaGeneralsec p WHERE p.pgeGralcodcomponenten1 = :pgeGralcodcomponenten1"),
    @NamedQuery(name = "PlaGeneralsec.findByPgeGralnomcomponenten1", query = "SELECT p FROM PlaGeneralsec p WHERE p.pgeGralnomcomponenten1 = :pgeGralnomcomponenten1"),
    @NamedQuery(name = "PlaGeneralsec.findByPgeGralcodcomponenten2", query = "SELECT p FROM PlaGeneralsec p WHERE p.pgeGralcodcomponenten2 = :pgeGralcodcomponenten2"),
    @NamedQuery(name = "PlaGeneralsec.findByPgeGralnomcomponenten2", query = "SELECT p FROM PlaGeneralsec p WHERE p.pgeGralnomcomponenten2 = :pgeGralnomcomponenten2"),
    @NamedQuery(name = "PlaGeneralsec.findByPgeGralcodcomponenten3", query = "SELECT p FROM PlaGeneralsec p WHERE p.pgeGralcodcomponenten3 = :pgeGralcodcomponenten3"),
    @NamedQuery(name = "PlaGeneralsec.findByPgeGralnomcomponenten3", query = "SELECT p FROM PlaGeneralsec p WHERE p.pgeGralnomcomponenten3 = :pgeGralnomcomponenten3"),
    @NamedQuery(name = "PlaGeneralsec.findByPgeGralcodcomponenten4", query = "SELECT p FROM PlaGeneralsec p WHERE p.pgeGralcodcomponenten4 = :pgeGralcodcomponenten4"),
    @NamedQuery(name = "PlaGeneralsec.findByPgeGralnomcomponenten4", query = "SELECT p FROM PlaGeneralsec p WHERE p.pgeGralnomcomponenten4 = :pgeGralnomcomponenten4"),
    @NamedQuery(name = "PlaGeneralsec.findByPgeGralcodcomponenten5", query = "SELECT p FROM PlaGeneralsec p WHERE p.pgeGralcodcomponenten5 = :pgeGralcodcomponenten5"),
    @NamedQuery(name = "PlaGeneralsec.findByPgeGralnomcomponenten5", query = "SELECT p FROM PlaGeneralsec p WHERE p.pgeGralnomcomponenten5 = :pgeGralnomcomponenten5"),
    @NamedQuery(name = "PlaGeneralsec.findByPgeGralcodcomponenten6", query = "SELECT p FROM PlaGeneralsec p WHERE p.pgeGralcodcomponenten6 = :pgeGralcodcomponenten6"),
    @NamedQuery(name = "PlaGeneralsec.findByPgeGralnomcomponenten6", query = "SELECT p FROM PlaGeneralsec p WHERE p.pgeGralnomcomponenten6 = :pgeGralnomcomponenten6"),
    @NamedQuery(name = "PlaGeneralsec.findByPgeGralcodcomponenten7", query = "SELECT p FROM PlaGeneralsec p WHERE p.pgeGralcodcomponenten7 = :pgeGralcodcomponenten7"),
    @NamedQuery(name = "PlaGeneralsec.findByPgeGralnomcomponenten7", query = "SELECT p FROM PlaGeneralsec p WHERE p.pgeGralnomcomponenten7 = :pgeGralnomcomponenten7"),
    @NamedQuery(name = "PlaGeneralsec.findByPgeGralcodinternonivel7", query = "SELECT p FROM PlaGeneralsec p WHERE p.pgeGralcodinternonivel7 = :pgeGralcodinternonivel7"),
    @NamedQuery(name = "PlaGeneralsec.findByPgeGralcodproyectopri", query = "SELECT p FROM PlaGeneralsec p WHERE p.pgeGralcodproyectopri = :pgeGralcodproyectopri"),
    @NamedQuery(name = "PlaGeneralsec.findByPgeGraldescproyectopri", query = "SELECT p FROM PlaGeneralsec p WHERE p.pgeGraldescproyectopri = :pgeGraldescproyectopri"),
    @NamedQuery(name = "PlaGeneralsec.findByPgeGralcodigomgr", query = "SELECT p FROM PlaGeneralsec p WHERE p.pgeGralcodigomgr = :pgeGralcodigomgr"),
    @NamedQuery(name = "PlaGeneralsec.findByPgeGraldescmgr", query = "SELECT p FROM PlaGeneralsec p WHERE p.pgeGraldescmgr = :pgeGraldescmgr"),
    @NamedQuery(name = "PlaGeneralsec.findByPgeGralrecprogano1", query = "SELECT p FROM PlaGeneralsec p WHERE p.pgeGralrecprogano1 = :pgeGralrecprogano1"),
    @NamedQuery(name = "PlaGeneralsec.findByPgeGralrecejecano1", query = "SELECT p FROM PlaGeneralsec p WHERE p.pgeGralrecejecano1 = :pgeGralrecejecano1"),
    @NamedQuery(name = "PlaGeneralsec.findByPgeGralrecporcano1", query = "SELECT p FROM PlaGeneralsec p WHERE p.pgeGralrecporcano1 = :pgeGralrecporcano1"),
    @NamedQuery(name = "PlaGeneralsec.findByPgeGralrecprogano2", query = "SELECT p FROM PlaGeneralsec p WHERE p.pgeGralrecprogano2 = :pgeGralrecprogano2"),
    @NamedQuery(name = "PlaGeneralsec.findByPgeGralrecejecano2", query = "SELECT p FROM PlaGeneralsec p WHERE p.pgeGralrecejecano2 = :pgeGralrecejecano2"),
    @NamedQuery(name = "PlaGeneralsec.findByPgeGralrecporcano2", query = "SELECT p FROM PlaGeneralsec p WHERE p.pgeGralrecporcano2 = :pgeGralrecporcano2"),
    @NamedQuery(name = "PlaGeneralsec.findByPgeGralrecprogano3", query = "SELECT p FROM PlaGeneralsec p WHERE p.pgeGralrecprogano3 = :pgeGralrecprogano3"),
    @NamedQuery(name = "PlaGeneralsec.findByPgeGralrecejecano3", query = "SELECT p FROM PlaGeneralsec p WHERE p.pgeGralrecejecano3 = :pgeGralrecejecano3"),
    @NamedQuery(name = "PlaGeneralsec.findByPgeGralrecporcano3", query = "SELECT p FROM PlaGeneralsec p WHERE p.pgeGralrecporcano3 = :pgeGralrecporcano3"),
    @NamedQuery(name = "PlaGeneralsec.findByPgeGralrecprogano4", query = "SELECT p FROM PlaGeneralsec p WHERE p.pgeGralrecprogano4 = :pgeGralrecprogano4"),
    @NamedQuery(name = "PlaGeneralsec.findByPgeGralrecejecano4", query = "SELECT p FROM PlaGeneralsec p WHERE p.pgeGralrecejecano4 = :pgeGralrecejecano4"),
    @NamedQuery(name = "PlaGeneralsec.findByPgeGralrecporcano4", query = "SELECT p FROM PlaGeneralsec p WHERE p.pgeGralrecporcano4 = :pgeGralrecporcano4"),
    @NamedQuery(name = "PlaGeneralsec.findByPgeGralrecprogano5", query = "SELECT p FROM PlaGeneralsec p WHERE p.pgeGralrecprogano5 = :pgeGralrecprogano5"),
    @NamedQuery(name = "PlaGeneralsec.findByPgeGralrecejecano5", query = "SELECT p FROM PlaGeneralsec p WHERE p.pgeGralrecejecano5 = :pgeGralrecejecano5"),
    @NamedQuery(name = "PlaGeneralsec.findByPgeGralrecporcano5", query = "SELECT p FROM PlaGeneralsec p WHERE p.pgeGralrecporcano5 = :pgeGralrecporcano5"),
    @NamedQuery(name = "PlaGeneralsec.findByPgeGralrecprogtot", query = "SELECT p FROM PlaGeneralsec p WHERE p.pgeGralrecprogtot = :pgeGralrecprogtot"),
    @NamedQuery(name = "PlaGeneralsec.findByPgeGralrecejectot", query = "SELECT p FROM PlaGeneralsec p WHERE p.pgeGralrecejectot = :pgeGralrecejectot"),
    @NamedQuery(name = "PlaGeneralsec.findByPgeGralrecporctot", query = "SELECT p FROM PlaGeneralsec p WHERE p.pgeGralrecporctot = :pgeGralrecporctot")})
public class PlaGeneralsec implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pge_id")
    private Long pgeId;
    @Size(max = 1500)
    @Column(name = "pge_gralid")
    private String pgeGralid;
    @Size(max = 500)
    @Column(name = "pge_gralidrep")
    private String pgeGralidrep;
    @Size(max = 100)
    @Column(name = "pge_gralcodigopd")
    private String pgeGralcodigopd;
    @Size(max = 1500)
    @Column(name = "pge_gralnombrepd")
    private String pgeGralnombrepd;
    @Size(max = 100)
    @Column(name = "pge_gralanoprogrepr")
    private String pgeGralanoprogrepr;
    @Size(max = 500)
    @Column(name = "pge_gralfechaseguim")
    private String pgeGralfechaseguim;
    @Size(max = 500)
    @Column(name = "pge_gralrecursos")
    private String pgeGralrecursos;
    @Size(max = 100)
    @Column(name = "pge_gralversionpa")
    private String pgeGralversionpa;
    @Size(max = 500)
    @Column(name = "pge_gralversionpadesc")
    private String pgeGralversionpadesc;
    @Size(max = 100)
    @Column(name = "pge_gralcodigosector")
    private String pgeGralcodigosector;
    @Size(max = 1500)
    @Column(name = "pge_gralsectordesc")
    private String pgeGralsectordesc;
    @Size(max = 100)
    @Column(name = "pge_gralcodigoentidad")
    private String pgeGralcodigoentidad;
    @Size(max = 1500)
    @Column(name = "pge_gralnombreentidad")
    private String pgeGralnombreentidad;
    @Size(max = 100)
    @Column(name = "pge_gralcodcomponenten1")
    private String pgeGralcodcomponenten1;
    @Size(max = 1500)
    @Column(name = "pge_gralnomcomponenten1")
    private String pgeGralnomcomponenten1;
    @Size(max = 100)
    @Column(name = "pge_gralcodcomponenten2")
    private String pgeGralcodcomponenten2;
    @Size(max = 1500)
    @Column(name = "pge_gralnomcomponenten2")
    private String pgeGralnomcomponenten2;
    @Size(max = 100)
    @Column(name = "pge_gralcodcomponenten3")
    private String pgeGralcodcomponenten3;
    @Size(max = 1500)
    @Column(name = "pge_gralnomcomponenten3")
    private String pgeGralnomcomponenten3;
    @Size(max = 100)
    @Column(name = "pge_gralcodcomponenten4")
    private String pgeGralcodcomponenten4;
    @Size(max = 1500)
    @Column(name = "pge_gralnomcomponenten4")
    private String pgeGralnomcomponenten4;
    @Size(max = 100)
    @Column(name = "pge_gralcodcomponenten5")
    private String pgeGralcodcomponenten5;
    @Size(max = 1500)
    @Column(name = "pge_gralnomcomponenten5")
    private String pgeGralnomcomponenten5;
    @Size(max = 100)
    @Column(name = "pge_gralcodcomponenten6")
    private String pgeGralcodcomponenten6;
    @Size(max = 1500)
    @Column(name = "pge_gralnomcomponenten6")
    private String pgeGralnomcomponenten6;
    @Size(max = 100)
    @Column(name = "pge_gralcodcomponenten7")
    private String pgeGralcodcomponenten7;
    @Size(max = 1500)
    @Column(name = "pge_gralnomcomponenten7")
    private String pgeGralnomcomponenten7;
    @Size(max = 100)
    @Column(name = "pge_gralcodinternonivel7")
    private String pgeGralcodinternonivel7;
    @Size(max = 100)
    @Column(name = "pge_gralcodproyectopri")
    private String pgeGralcodproyectopri;
    @Size(max = 1500)
    @Column(name = "pge_graldescproyectopri")
    private String pgeGraldescproyectopri;
    @Size(max = 100)
    @Column(name = "pge_gralcodigomgr")
    private String pgeGralcodigomgr;
    @Size(max = 1500)
    @Column(name = "pge_graldescmgr")
    private String pgeGraldescmgr;
    @Size(max = 200)
    @Column(name = "pge_gralrecprogano1")
    private String pgeGralrecprogano1;
    @Size(max = 200)
    @Column(name = "pge_gralrecejecano1")
    private String pgeGralrecejecano1;
    @Size(max = 200)
    @Column(name = "pge_gralrecporcano1")
    private String pgeGralrecporcano1;
    @Size(max = 200)
    @Column(name = "pge_gralrecprogano2")
    private String pgeGralrecprogano2;
    @Size(max = 200)
    @Column(name = "pge_gralrecejecano2")
    private String pgeGralrecejecano2;
    @Size(max = 200)
    @Column(name = "pge_gralrecporcano2")
    private String pgeGralrecporcano2;
    @Size(max = 200)
    @Column(name = "pge_gralrecprogano3")
    private String pgeGralrecprogano3;
    @Size(max = 200)
    @Column(name = "pge_gralrecejecano3")
    private String pgeGralrecejecano3;
    @Size(max = 200)
    @Column(name = "pge_gralrecporcano3")
    private String pgeGralrecporcano3;
    @Size(max = 200)
    @Column(name = "pge_gralrecprogano4")
    private String pgeGralrecprogano4;
    @Size(max = 200)
    @Column(name = "pge_gralrecejecano4")
    private String pgeGralrecejecano4;
    @Size(max = 200)
    @Column(name = "pge_gralrecporcano4")
    private String pgeGralrecporcano4;
    @Size(max = 200)
    @Column(name = "pge_gralrecprogano5")
    private String pgeGralrecprogano5;
    @Size(max = 200)
    @Column(name = "pge_gralrecejecano5")
    private String pgeGralrecejecano5;
    @Size(max = 200)
    @Column(name = "pge_gralrecporcano5")
    private String pgeGralrecporcano5;
    @Size(max = 200)
    @Column(name = "pge_gralrecprogtot")
    private String pgeGralrecprogtot;
    @Size(max = 200)
    @Column(name = "pge_gralrecejectot")
    private String pgeGralrecejectot;
    @Size(max = 200)
    @Column(name = "pge_gralrecporctot")
    private String pgeGralrecporctot;
    @JoinColumn(name = "lgreg_id", referencedColumnName = "lgreg_id")
    @ManyToOne(optional = false)
    private SysRegistrocarga lgregId;

    public PlaGeneralsec() {
    }

    public PlaGeneralsec(Long pgeId) {
        this.pgeId = pgeId;
    }

    public Long getPgeId() {
        return pgeId;
    }

    public void setPgeId(Long pgeId) {
        this.pgeId = pgeId;
    }

    public String getPgeGralid() {
        return pgeGralid;
    }

    public void setPgeGralid(String pgeGralid) {
        this.pgeGralid = pgeGralid;
    }

    public String getPgeGralidrep() {
        return pgeGralidrep;
    }

    public void setPgeGralidrep(String pgeGralidrep) {
        this.pgeGralidrep = pgeGralidrep;
    }

    public String getPgeGralcodigopd() {
        return pgeGralcodigopd;
    }

    public void setPgeGralcodigopd(String pgeGralcodigopd) {
        this.pgeGralcodigopd = pgeGralcodigopd;
    }

    public String getPgeGralnombrepd() {
        return pgeGralnombrepd;
    }

    public void setPgeGralnombrepd(String pgeGralnombrepd) {
        this.pgeGralnombrepd = pgeGralnombrepd;
    }

    public String getPgeGralanoprogrepr() {
        return pgeGralanoprogrepr;
    }

    public void setPgeGralanoprogrepr(String pgeGralanoprogrepr) {
        this.pgeGralanoprogrepr = pgeGralanoprogrepr;
    }

    public String getPgeGralfechaseguim() {
        return pgeGralfechaseguim;
    }

    public void setPgeGralfechaseguim(String pgeGralfechaseguim) {
        this.pgeGralfechaseguim = pgeGralfechaseguim;
    }

    public String getPgeGralrecursos() {
        return pgeGralrecursos;
    }

    public void setPgeGralrecursos(String pgeGralrecursos) {
        this.pgeGralrecursos = pgeGralrecursos;
    }

    public String getPgeGralversionpa() {
        return pgeGralversionpa;
    }

    public void setPgeGralversionpa(String pgeGralversionpa) {
        this.pgeGralversionpa = pgeGralversionpa;
    }

    public String getPgeGralversionpadesc() {
        return pgeGralversionpadesc;
    }

    public void setPgeGralversionpadesc(String pgeGralversionpadesc) {
        this.pgeGralversionpadesc = pgeGralversionpadesc;
    }

    public String getPgeGralcodigosector() {
        return pgeGralcodigosector;
    }

    public void setPgeGralcodigosector(String pgeGralcodigosector) {
        this.pgeGralcodigosector = pgeGralcodigosector;
    }

    public String getPgeGralsectordesc() {
        return pgeGralsectordesc;
    }

    public void setPgeGralsectordesc(String pgeGralsectordesc) {
        this.pgeGralsectordesc = pgeGralsectordesc;
    }

    public String getPgeGralcodigoentidad() {
        return pgeGralcodigoentidad;
    }

    public void setPgeGralcodigoentidad(String pgeGralcodigoentidad) {
        this.pgeGralcodigoentidad = pgeGralcodigoentidad;
    }

    public String getPgeGralnombreentidad() {
        return pgeGralnombreentidad;
    }

    public void setPgeGralnombreentidad(String pgeGralnombreentidad) {
        this.pgeGralnombreentidad = pgeGralnombreentidad;
    }

    public String getPgeGralcodcomponenten1() {
        return pgeGralcodcomponenten1;
    }

    public void setPgeGralcodcomponenten1(String pgeGralcodcomponenten1) {
        this.pgeGralcodcomponenten1 = pgeGralcodcomponenten1;
    }

    public String getPgeGralnomcomponenten1() {
        return pgeGralnomcomponenten1;
    }

    public void setPgeGralnomcomponenten1(String pgeGralnomcomponenten1) {
        this.pgeGralnomcomponenten1 = pgeGralnomcomponenten1;
    }

    public String getPgeGralcodcomponenten2() {
        return pgeGralcodcomponenten2;
    }

    public void setPgeGralcodcomponenten2(String pgeGralcodcomponenten2) {
        this.pgeGralcodcomponenten2 = pgeGralcodcomponenten2;
    }

    public String getPgeGralnomcomponenten2() {
        return pgeGralnomcomponenten2;
    }

    public void setPgeGralnomcomponenten2(String pgeGralnomcomponenten2) {
        this.pgeGralnomcomponenten2 = pgeGralnomcomponenten2;
    }

    public String getPgeGralcodcomponenten3() {
        return pgeGralcodcomponenten3;
    }

    public void setPgeGralcodcomponenten3(String pgeGralcodcomponenten3) {
        this.pgeGralcodcomponenten3 = pgeGralcodcomponenten3;
    }

    public String getPgeGralnomcomponenten3() {
        return pgeGralnomcomponenten3;
    }

    public void setPgeGralnomcomponenten3(String pgeGralnomcomponenten3) {
        this.pgeGralnomcomponenten3 = pgeGralnomcomponenten3;
    }

    public String getPgeGralcodcomponenten4() {
        return pgeGralcodcomponenten4;
    }

    public void setPgeGralcodcomponenten4(String pgeGralcodcomponenten4) {
        this.pgeGralcodcomponenten4 = pgeGralcodcomponenten4;
    }

    public String getPgeGralnomcomponenten4() {
        return pgeGralnomcomponenten4;
    }

    public void setPgeGralnomcomponenten4(String pgeGralnomcomponenten4) {
        this.pgeGralnomcomponenten4 = pgeGralnomcomponenten4;
    }

    public String getPgeGralcodcomponenten5() {
        return pgeGralcodcomponenten5;
    }

    public void setPgeGralcodcomponenten5(String pgeGralcodcomponenten5) {
        this.pgeGralcodcomponenten5 = pgeGralcodcomponenten5;
    }

    public String getPgeGralnomcomponenten5() {
        return pgeGralnomcomponenten5;
    }

    public void setPgeGralnomcomponenten5(String pgeGralnomcomponenten5) {
        this.pgeGralnomcomponenten5 = pgeGralnomcomponenten5;
    }

    public String getPgeGralcodcomponenten6() {
        return pgeGralcodcomponenten6;
    }

    public void setPgeGralcodcomponenten6(String pgeGralcodcomponenten6) {
        this.pgeGralcodcomponenten6 = pgeGralcodcomponenten6;
    }

    public String getPgeGralnomcomponenten6() {
        return pgeGralnomcomponenten6;
    }

    public void setPgeGralnomcomponenten6(String pgeGralnomcomponenten6) {
        this.pgeGralnomcomponenten6 = pgeGralnomcomponenten6;
    }

    public String getPgeGralcodcomponenten7() {
        return pgeGralcodcomponenten7;
    }

    public void setPgeGralcodcomponenten7(String pgeGralcodcomponenten7) {
        this.pgeGralcodcomponenten7 = pgeGralcodcomponenten7;
    }

    public String getPgeGralnomcomponenten7() {
        return pgeGralnomcomponenten7;
    }

    public void setPgeGralnomcomponenten7(String pgeGralnomcomponenten7) {
        this.pgeGralnomcomponenten7 = pgeGralnomcomponenten7;
    }

    public String getPgeGralcodinternonivel7() {
        return pgeGralcodinternonivel7;
    }

    public void setPgeGralcodinternonivel7(String pgeGralcodinternonivel7) {
        this.pgeGralcodinternonivel7 = pgeGralcodinternonivel7;
    }

    public String getPgeGralcodproyectopri() {
        return pgeGralcodproyectopri;
    }

    public void setPgeGralcodproyectopri(String pgeGralcodproyectopri) {
        this.pgeGralcodproyectopri = pgeGralcodproyectopri;
    }

    public String getPgeGraldescproyectopri() {
        return pgeGraldescproyectopri;
    }

    public void setPgeGraldescproyectopri(String pgeGraldescproyectopri) {
        this.pgeGraldescproyectopri = pgeGraldescproyectopri;
    }

    public String getPgeGralcodigomgr() {
        return pgeGralcodigomgr;
    }

    public void setPgeGralcodigomgr(String pgeGralcodigomgr) {
        this.pgeGralcodigomgr = pgeGralcodigomgr;
    }

    public String getPgeGraldescmgr() {
        return pgeGraldescmgr;
    }

    public void setPgeGraldescmgr(String pgeGraldescmgr) {
        this.pgeGraldescmgr = pgeGraldescmgr;
    }

    public String getPgeGralrecprogano1() {
        return pgeGralrecprogano1;
    }

    public void setPgeGralrecprogano1(String pgeGralrecprogano1) {
        this.pgeGralrecprogano1 = pgeGralrecprogano1;
    }

    public String getPgeGralrecejecano1() {
        return pgeGralrecejecano1;
    }

    public void setPgeGralrecejecano1(String pgeGralrecejecano1) {
        this.pgeGralrecejecano1 = pgeGralrecejecano1;
    }

    public String getPgeGralrecporcano1() {
        return pgeGralrecporcano1;
    }

    public void setPgeGralrecporcano1(String pgeGralrecporcano1) {
        this.pgeGralrecporcano1 = pgeGralrecporcano1;
    }

    public String getPgeGralrecprogano2() {
        return pgeGralrecprogano2;
    }

    public void setPgeGralrecprogano2(String pgeGralrecprogano2) {
        this.pgeGralrecprogano2 = pgeGralrecprogano2;
    }

    public String getPgeGralrecejecano2() {
        return pgeGralrecejecano2;
    }

    public void setPgeGralrecejecano2(String pgeGralrecejecano2) {
        this.pgeGralrecejecano2 = pgeGralrecejecano2;
    }

    public String getPgeGralrecporcano2() {
        return pgeGralrecporcano2;
    }

    public void setPgeGralrecporcano2(String pgeGralrecporcano2) {
        this.pgeGralrecporcano2 = pgeGralrecporcano2;
    }

    public String getPgeGralrecprogano3() {
        return pgeGralrecprogano3;
    }

    public void setPgeGralrecprogano3(String pgeGralrecprogano3) {
        this.pgeGralrecprogano3 = pgeGralrecprogano3;
    }

    public String getPgeGralrecejecano3() {
        return pgeGralrecejecano3;
    }

    public void setPgeGralrecejecano3(String pgeGralrecejecano3) {
        this.pgeGralrecejecano3 = pgeGralrecejecano3;
    }

    public String getPgeGralrecporcano3() {
        return pgeGralrecporcano3;
    }

    public void setPgeGralrecporcano3(String pgeGralrecporcano3) {
        this.pgeGralrecporcano3 = pgeGralrecporcano3;
    }

    public String getPgeGralrecprogano4() {
        return pgeGralrecprogano4;
    }

    public void setPgeGralrecprogano4(String pgeGralrecprogano4) {
        this.pgeGralrecprogano4 = pgeGralrecprogano4;
    }

    public String getPgeGralrecejecano4() {
        return pgeGralrecejecano4;
    }

    public void setPgeGralrecejecano4(String pgeGralrecejecano4) {
        this.pgeGralrecejecano4 = pgeGralrecejecano4;
    }

    public String getPgeGralrecporcano4() {
        return pgeGralrecporcano4;
    }

    public void setPgeGralrecporcano4(String pgeGralrecporcano4) {
        this.pgeGralrecporcano4 = pgeGralrecporcano4;
    }

    public String getPgeGralrecprogano5() {
        return pgeGralrecprogano5;
    }

    public void setPgeGralrecprogano5(String pgeGralrecprogano5) {
        this.pgeGralrecprogano5 = pgeGralrecprogano5;
    }

    public String getPgeGralrecejecano5() {
        return pgeGralrecejecano5;
    }

    public void setPgeGralrecejecano5(String pgeGralrecejecano5) {
        this.pgeGralrecejecano5 = pgeGralrecejecano5;
    }

    public String getPgeGralrecporcano5() {
        return pgeGralrecporcano5;
    }

    public void setPgeGralrecporcano5(String pgeGralrecporcano5) {
        this.pgeGralrecporcano5 = pgeGralrecporcano5;
    }

    public String getPgeGralrecprogtot() {
        return pgeGralrecprogtot;
    }

    public void setPgeGralrecprogtot(String pgeGralrecprogtot) {
        this.pgeGralrecprogtot = pgeGralrecprogtot;
    }

    public String getPgeGralrecejectot() {
        return pgeGralrecejectot;
    }

    public void setPgeGralrecejectot(String pgeGralrecejectot) {
        this.pgeGralrecejectot = pgeGralrecejectot;
    }

    public String getPgeGralrecporctot() {
        return pgeGralrecporctot;
    }

    public void setPgeGralrecporctot(String pgeGralrecporctot) {
        this.pgeGralrecporctot = pgeGralrecporctot;
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
        hash += (pgeId != null ? pgeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlaGeneralsec)) {
            return false;
        }
        PlaGeneralsec other = (PlaGeneralsec) object;
        if ((this.pgeId == null && other.pgeId != null) || (this.pgeId != null && !this.pgeId.equals(other.pgeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.veeduria.dao.PlaGeneralsec[ pgeId=" + pgeId + " ]";
    }
    
}
