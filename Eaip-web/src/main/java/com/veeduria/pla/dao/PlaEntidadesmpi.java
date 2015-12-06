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
 * @author luz
 */
@Entity
@Table(name = "pla_entidadesmpi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlaEntidadesmpi.findAll", query = "SELECT p FROM PlaEntidadesmpi p"),
    @NamedQuery(name = "PlaEntidadesmpi.findByPenId", query = "SELECT p FROM PlaEntidadesmpi p WHERE p.penId = :penId"),
    @NamedQuery(name = "PlaEntidadesmpi.findByPenPyid", query = "SELECT p FROM PlaEntidadesmpi p WHERE p.penPyid = :penPyid"),
    @NamedQuery(name = "PlaEntidadesmpi.findByPenPyidrep", query = "SELECT p FROM PlaEntidadesmpi p WHERE p.penPyidrep = :penPyidrep"),
    @NamedQuery(name = "PlaEntidadesmpi.findByPenPycodigopd", query = "SELECT p FROM PlaEntidadesmpi p WHERE p.penPycodigopd = :penPycodigopd"),
    @NamedQuery(name = "PlaEntidadesmpi.findByPenPyanoprogrepr", query = "SELECT p FROM PlaEntidadesmpi p WHERE p.penPyanoprogrepr = :penPyanoprogrepr"),
    @NamedQuery(name = "PlaEntidadesmpi.findByPenPyversionpa", query = "SELECT p FROM PlaEntidadesmpi p WHERE p.penPyversionpa = :penPyversionpa"),
    @NamedQuery(name = "PlaEntidadesmpi.findByPenPycodigosector", query = "SELECT p FROM PlaEntidadesmpi p WHERE p.penPycodigosector = :penPycodigosector"),
    @NamedQuery(name = "PlaEntidadesmpi.findByPenPycodigoentidad", query = "SELECT p FROM PlaEntidadesmpi p WHERE p.penPycodigoentidad = :penPycodigoentidad"),
    @NamedQuery(name = "PlaEntidadesmpi.findByPenPycodigointernonivel7", query = "SELECT p FROM PlaEntidadesmpi p WHERE p.penPycodigointernonivel7 = :penPycodigointernonivel7"),
    @NamedQuery(name = "PlaEntidadesmpi.findByPenPycodigoproyectopri", query = "SELECT p FROM PlaEntidadesmpi p WHERE p.penPycodigoproyectopri = :penPycodigoproyectopri"),
    @NamedQuery(name = "PlaEntidadesmpi.findByPenPycodigomgr", query = "SELECT p FROM PlaEntidadesmpi p WHERE p.penPycodigomgr = :penPycodigomgr"),
    @NamedQuery(name = "PlaEntidadesmpi.findByPenPycodigoproyecto", query = "SELECT p FROM PlaEntidadesmpi p WHERE p.penPycodigoproyecto = :penPycodigoproyecto"),
    @NamedQuery(name = "PlaEntidadesmpi.findByPenPyn7diferente", query = "SELECT p FROM PlaEntidadesmpi p WHERE p.penPyn7diferente = :penPyn7diferente"),
    @NamedQuery(name = "PlaEntidadesmpi.findByPenPynombreproyecto", query = "SELECT p FROM PlaEntidadesmpi p WHERE p.penPynombreproyecto = :penPynombreproyecto"),
    @NamedQuery(name = "PlaEntidadesmpi.findByPenPycodigointernometa", query = "SELECT p FROM PlaEntidadesmpi p WHERE p.penPycodigointernometa = :penPycodigointernometa"),
    @NamedQuery(name = "PlaEntidadesmpi.findByPenPympitiposuma", query = "SELECT p FROM PlaEntidadesmpi p WHERE p.penPympitiposuma = :penPympitiposuma"),
    @NamedQuery(name = "PlaEntidadesmpi.findByPenPydescrmeta", query = "SELECT p FROM PlaEntidadesmpi p WHERE p.penPydescrmeta = :penPydescrmeta"),
    @NamedQuery(name = "PlaEntidadesmpi.findByPenPyestadoprogmetadesc", query = "SELECT p FROM PlaEntidadesmpi p WHERE p.penPyestadoprogmetadesc = :penPyestadoprogmetadesc"),
    @NamedQuery(name = "PlaEntidadesmpi.findByPenPymagprogano1", query = "SELECT p FROM PlaEntidadesmpi p WHERE p.penPymagprogano1 = :penPymagprogano1"),
    @NamedQuery(name = "PlaEntidadesmpi.findByPenPymagejecano1", query = "SELECT p FROM PlaEntidadesmpi p WHERE p.penPymagejecano1 = :penPymagejecano1"),
    @NamedQuery(name = "PlaEntidadesmpi.findByPenPymagporcano1", query = "SELECT p FROM PlaEntidadesmpi p WHERE p.penPymagporcano1 = :penPymagporcano1"),
    @NamedQuery(name = "PlaEntidadesmpi.findByPenPymagprogano2", query = "SELECT p FROM PlaEntidadesmpi p WHERE p.penPymagprogano2 = :penPymagprogano2"),
    @NamedQuery(name = "PlaEntidadesmpi.findByPenPymagejecano2", query = "SELECT p FROM PlaEntidadesmpi p WHERE p.penPymagejecano2 = :penPymagejecano2"),
    @NamedQuery(name = "PlaEntidadesmpi.findByPenPymagporcano2", query = "SELECT p FROM PlaEntidadesmpi p WHERE p.penPymagporcano2 = :penPymagporcano2"),
    @NamedQuery(name = "PlaEntidadesmpi.findByPenPymagprogano3", query = "SELECT p FROM PlaEntidadesmpi p WHERE p.penPymagprogano3 = :penPymagprogano3"),
    @NamedQuery(name = "PlaEntidadesmpi.findByPenPymagejecano3", query = "SELECT p FROM PlaEntidadesmpi p WHERE p.penPymagejecano3 = :penPymagejecano3"),
    @NamedQuery(name = "PlaEntidadesmpi.findByPenPymagporcano3", query = "SELECT p FROM PlaEntidadesmpi p WHERE p.penPymagporcano3 = :penPymagporcano3"),
    @NamedQuery(name = "PlaEntidadesmpi.findByPenPymagprogano4", query = "SELECT p FROM PlaEntidadesmpi p WHERE p.penPymagprogano4 = :penPymagprogano4"),
    @NamedQuery(name = "PlaEntidadesmpi.findByPenPymagejecano4", query = "SELECT p FROM PlaEntidadesmpi p WHERE p.penPymagejecano4 = :penPymagejecano4"),
    @NamedQuery(name = "PlaEntidadesmpi.findByPenPymagporcano4", query = "SELECT p FROM PlaEntidadesmpi p WHERE p.penPymagporcano4 = :penPymagporcano4"),
    @NamedQuery(name = "PlaEntidadesmpi.findByPenPymagprogano5", query = "SELECT p FROM PlaEntidadesmpi p WHERE p.penPymagprogano5 = :penPymagprogano5"),
    @NamedQuery(name = "PlaEntidadesmpi.findByPenPymagejecano5", query = "SELECT p FROM PlaEntidadesmpi p WHERE p.penPymagejecano5 = :penPymagejecano5"),
    @NamedQuery(name = "PlaEntidadesmpi.findByPenPymagporcano5", query = "SELECT p FROM PlaEntidadesmpi p WHERE p.penPymagporcano5 = :penPymagporcano5"),
    @NamedQuery(name = "PlaEntidadesmpi.findByPenPymagprogtot", query = "SELECT p FROM PlaEntidadesmpi p WHERE p.penPymagprogtot = :penPymagprogtot"),
    @NamedQuery(name = "PlaEntidadesmpi.findByPenPymagejectot", query = "SELECT p FROM PlaEntidadesmpi p WHERE p.penPymagejectot = :penPymagejectot"),
    @NamedQuery(name = "PlaEntidadesmpi.findByPenPymagporctot", query = "SELECT p FROM PlaEntidadesmpi p WHERE p.penPymagporctot = :penPymagporctot"),
    @NamedQuery(name = "PlaEntidadesmpi.findByPenPyrecprogano1", query = "SELECT p FROM PlaEntidadesmpi p WHERE p.penPyrecprogano1 = :penPyrecprogano1"),
    @NamedQuery(name = "PlaEntidadesmpi.findByPenPyrecejecano1", query = "SELECT p FROM PlaEntidadesmpi p WHERE p.penPyrecejecano1 = :penPyrecejecano1"),
    @NamedQuery(name = "PlaEntidadesmpi.findByPenPyrecporcano1", query = "SELECT p FROM PlaEntidadesmpi p WHERE p.penPyrecporcano1 = :penPyrecporcano1"),
    @NamedQuery(name = "PlaEntidadesmpi.findByPenPyrecprogano2", query = "SELECT p FROM PlaEntidadesmpi p WHERE p.penPyrecprogano2 = :penPyrecprogano2"),
    @NamedQuery(name = "PlaEntidadesmpi.findByPenPyrecejecano2", query = "SELECT p FROM PlaEntidadesmpi p WHERE p.penPyrecejecano2 = :penPyrecejecano2"),
    @NamedQuery(name = "PlaEntidadesmpi.findByPenPyrecporcano2", query = "SELECT p FROM PlaEntidadesmpi p WHERE p.penPyrecporcano2 = :penPyrecporcano2"),
    @NamedQuery(name = "PlaEntidadesmpi.findByPenPyrecprogano3", query = "SELECT p FROM PlaEntidadesmpi p WHERE p.penPyrecprogano3 = :penPyrecprogano3"),
    @NamedQuery(name = "PlaEntidadesmpi.findByPenPyrecejecano3", query = "SELECT p FROM PlaEntidadesmpi p WHERE p.penPyrecejecano3 = :penPyrecejecano3"),
    @NamedQuery(name = "PlaEntidadesmpi.findByPenPyrecporcano3", query = "SELECT p FROM PlaEntidadesmpi p WHERE p.penPyrecporcano3 = :penPyrecporcano3"),
    @NamedQuery(name = "PlaEntidadesmpi.findByPenPyrecprogano4", query = "SELECT p FROM PlaEntidadesmpi p WHERE p.penPyrecprogano4 = :penPyrecprogano4"),
    @NamedQuery(name = "PlaEntidadesmpi.findByPenPyrecejecano4", query = "SELECT p FROM PlaEntidadesmpi p WHERE p.penPyrecejecano4 = :penPyrecejecano4"),
    @NamedQuery(name = "PlaEntidadesmpi.findByPenPyrecporcano4", query = "SELECT p FROM PlaEntidadesmpi p WHERE p.penPyrecporcano4 = :penPyrecporcano4"),
    @NamedQuery(name = "PlaEntidadesmpi.findByPenPyrecprogano5", query = "SELECT p FROM PlaEntidadesmpi p WHERE p.penPyrecprogano5 = :penPyrecprogano5"),
    @NamedQuery(name = "PlaEntidadesmpi.findByPenPyrecejecano5", query = "SELECT p FROM PlaEntidadesmpi p WHERE p.penPyrecejecano5 = :penPyrecejecano5"),
    @NamedQuery(name = "PlaEntidadesmpi.findByPenPyrecporcano5", query = "SELECT p FROM PlaEntidadesmpi p WHERE p.penPyrecporcano5 = :penPyrecporcano5"),
    @NamedQuery(name = "PlaEntidadesmpi.findByPenPyrecprogtot", query = "SELECT p FROM PlaEntidadesmpi p WHERE p.penPyrecprogtot = :penPyrecprogtot"),
    @NamedQuery(name = "PlaEntidadesmpi.findByPenPyrecejectot", query = "SELECT p FROM PlaEntidadesmpi p WHERE p.penPyrecejectot = :penPyrecejectot"),
    @NamedQuery(name = "PlaEntidadesmpi.findByPenPyrecporctot", query = "SELECT p FROM PlaEntidadesmpi p WHERE p.penPyrecporctot = :penPyrecporctot")})
public class PlaEntidadesmpi implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pen_id")
    private Long penId;
    @Size(max = 1500)
    @Column(name = "pen_pyid")
    private String penPyid;
    @Size(max = 500)
    @Column(name = "pen_pyidrep")
    private String penPyidrep;
    @Size(max = 100)
    @Column(name = "pen_pycodigopd")
    private String penPycodigopd;
    @Size(max = 100)
    @Column(name = "pen_pyanoprogrepr")
    private String penPyanoprogrepr;
    @Size(max = 100)
    @Column(name = "pen_pyversionpa")
    private String penPyversionpa;
    @Size(max = 100)
    @Column(name = "pen_pycodigosector")
    private String penPycodigosector;
    @Size(max = 100)
    @Column(name = "pen_pycodigoentidad")
    private String penPycodigoentidad;
    @Size(max = 100)
    @Column(name = "pen_pycodigointernonivel7")
    private String penPycodigointernonivel7;
    @Size(max = 100)
    @Column(name = "pen_pycodigoproyectopri")
    private String penPycodigoproyectopri;
    @Size(max = 100)
    @Column(name = "pen_pycodigomgr")
    private String penPycodigomgr;
    @Size(max = 100)
    @Column(name = "pen_pycodigoproyecto")
    private String penPycodigoproyecto;
    @Size(max = 100)
    @Column(name = "pen_pyn7diferente")
    private String penPyn7diferente;
    @Size(max = 1500)
    @Column(name = "pen_pynombreproyecto")
    private String penPynombreproyecto;
    @Size(max = 100)
    @Column(name = "pen_pycodigointernometa")
    private String penPycodigointernometa;
    @Size(max = 1500)
    @Column(name = "pen_pympitiposuma")
    private String penPympitiposuma;
    @Size(max = 1500)
    @Column(name = "pen_pydescrmeta")
    private String penPydescrmeta;
    @Size(max = 1500)
    @Column(name = "pen_pyestadoprogmetadesc")
    private String penPyestadoprogmetadesc;
    @Size(max = 100)
    @Column(name = "pen_pymagprogano1")
    private String penPymagprogano1;
    @Size(max = 100)
    @Column(name = "pen_pymagejecano1")
    private String penPymagejecano1;
    @Size(max = 100)
    @Column(name = "pen_pymagporcano1")
    private String penPymagporcano1;
    @Size(max = 100)
    @Column(name = "pen_pymagprogano2")
    private String penPymagprogano2;
    @Size(max = 100)
    @Column(name = "pen_pymagejecano2")
    private String penPymagejecano2;
    @Size(max = 100)
    @Column(name = "pen_pymagporcano2")
    private String penPymagporcano2;
    @Size(max = 100)
    @Column(name = "pen_pymagprogano3")
    private String penPymagprogano3;
    @Size(max = 100)
    @Column(name = "pen_pymagejecano3")
    private String penPymagejecano3;
    @Size(max = 100)
    @Column(name = "pen_pymagporcano3")
    private String penPymagporcano3;
    @Size(max = 100)
    @Column(name = "pen_pymagprogano4")
    private String penPymagprogano4;
    @Size(max = 100)
    @Column(name = "pen_pymagejecano4")
    private String penPymagejecano4;
    @Size(max = 100)
    @Column(name = "pen_pymagporcano4")
    private String penPymagporcano4;
    @Size(max = 100)
    @Column(name = "pen_pymagprogano5")
    private String penPymagprogano5;
    @Size(max = 100)
    @Column(name = "pen_pymagejecano5")
    private String penPymagejecano5;
    @Size(max = 100)
    @Column(name = "pen_pymagporcano5")
    private String penPymagporcano5;
    @Size(max = 100)
    @Column(name = "pen_pymagprogtot")
    private String penPymagprogtot;
    @Size(max = 100)
    @Column(name = "pen_pymagejectot")
    private String penPymagejectot;
    @Size(max = 100)
    @Column(name = "pen_pymagporctot")
    private String penPymagporctot;
    @Size(max = 200)
    @Column(name = "pen_pyrecprogano1")
    private String penPyrecprogano1;
    @Size(max = 200)
    @Column(name = "pen_pyrecejecano1")
    private String penPyrecejecano1;
    @Size(max = 200)
    @Column(name = "pen_pyrecporcano1")
    private String penPyrecporcano1;
    @Size(max = 200)
    @Column(name = "pen_pyrecprogano2")
    private String penPyrecprogano2;
    @Size(max = 200)
    @Column(name = "pen_pyrecejecano2")
    private String penPyrecejecano2;
    @Size(max = 200)
    @Column(name = "pen_pyrecporcano2")
    private String penPyrecporcano2;
    @Size(max = 200)
    @Column(name = "pen_pyrecprogano3")
    private String penPyrecprogano3;
    @Size(max = 200)
    @Column(name = "pen_pyrecejecano3")
    private String penPyrecejecano3;
    @Size(max = 200)
    @Column(name = "pen_pyrecporcano3")
    private String penPyrecporcano3;
    @Size(max = 200)
    @Column(name = "pen_pyrecprogano4")
    private String penPyrecprogano4;
    @Size(max = 200)
    @Column(name = "pen_pyrecejecano4")
    private String penPyrecejecano4;
    @Size(max = 200)
    @Column(name = "pen_pyrecporcano4")
    private String penPyrecporcano4;
    @Size(max = 200)
    @Column(name = "pen_pyrecprogano5")
    private String penPyrecprogano5;
    @Size(max = 200)
    @Column(name = "pen_pyrecejecano5")
    private String penPyrecejecano5;
    @Size(max = 200)
    @Column(name = "pen_pyrecporcano5")
    private String penPyrecporcano5;
    @Size(max = 200)
    @Column(name = "pen_pyrecprogtot")
    private String penPyrecprogtot;
    @Size(max = 200)
    @Column(name = "pen_pyrecejectot")
    private String penPyrecejectot;
    @Size(max = 200)
    @Column(name = "pen_pyrecporctot")
    private String penPyrecporctot;
    @JoinColumn(name = "lgreg_id", referencedColumnName = "lgreg_id")
    @ManyToOne(optional = false)
    private SysRegistrocarga lgregId;

    public PlaEntidadesmpi() {
    }

    public PlaEntidadesmpi(Long penId) {
        this.penId = penId;
    }

    public Long getPenId() {
        return penId;
    }

    public void setPenId(Long penId) {
        this.penId = penId;
    }

    public String getPenPyid() {
        return penPyid;
    }

    public void setPenPyid(String penPyid) {
        this.penPyid = penPyid;
    }

    public String getPenPyidrep() {
        return penPyidrep;
    }

    public void setPenPyidrep(String penPyidrep) {
        this.penPyidrep = penPyidrep;
    }

    public String getPenPycodigopd() {
        return penPycodigopd;
    }

    public void setPenPycodigopd(String penPycodigopd) {
        this.penPycodigopd = penPycodigopd;
    }

    public String getPenPyanoprogrepr() {
        return penPyanoprogrepr;
    }

    public void setPenPyanoprogrepr(String penPyanoprogrepr) {
        this.penPyanoprogrepr = penPyanoprogrepr;
    }

    public String getPenPyversionpa() {
        return penPyversionpa;
    }

    public void setPenPyversionpa(String penPyversionpa) {
        this.penPyversionpa = penPyversionpa;
    }

    public String getPenPycodigosector() {
        return penPycodigosector;
    }

    public void setPenPycodigosector(String penPycodigosector) {
        this.penPycodigosector = penPycodigosector;
    }

    public String getPenPycodigoentidad() {
        return penPycodigoentidad;
    }

    public void setPenPycodigoentidad(String penPycodigoentidad) {
        this.penPycodigoentidad = penPycodigoentidad;
    }

    public String getPenPycodigointernonivel7() {
        return penPycodigointernonivel7;
    }

    public void setPenPycodigointernonivel7(String penPycodigointernonivel7) {
        this.penPycodigointernonivel7 = penPycodigointernonivel7;
    }

    public String getPenPycodigoproyectopri() {
        return penPycodigoproyectopri;
    }

    public void setPenPycodigoproyectopri(String penPycodigoproyectopri) {
        this.penPycodigoproyectopri = penPycodigoproyectopri;
    }

    public String getPenPycodigomgr() {
        return penPycodigomgr;
    }

    public void setPenPycodigomgr(String penPycodigomgr) {
        this.penPycodigomgr = penPycodigomgr;
    }

    public String getPenPycodigoproyecto() {
        return penPycodigoproyecto;
    }

    public void setPenPycodigoproyecto(String penPycodigoproyecto) {
        this.penPycodigoproyecto = penPycodigoproyecto;
    }

    public String getPenPyn7diferente() {
        return penPyn7diferente;
    }

    public void setPenPyn7diferente(String penPyn7diferente) {
        this.penPyn7diferente = penPyn7diferente;
    }

    public String getPenPynombreproyecto() {
        return penPynombreproyecto;
    }

    public void setPenPynombreproyecto(String penPynombreproyecto) {
        this.penPynombreproyecto = penPynombreproyecto;
    }

    public String getPenPycodigointernometa() {
        return penPycodigointernometa;
    }

    public void setPenPycodigointernometa(String penPycodigointernometa) {
        this.penPycodigointernometa = penPycodigointernometa;
    }

    public String getPenPympitiposuma() {
        return penPympitiposuma;
    }

    public void setPenPympitiposuma(String penPympitiposuma) {
        this.penPympitiposuma = penPympitiposuma;
    }

    public String getPenPydescrmeta() {
        return penPydescrmeta;
    }

    public void setPenPydescrmeta(String penPydescrmeta) {
        this.penPydescrmeta = penPydescrmeta;
    }

    public String getPenPyestadoprogmetadesc() {
        return penPyestadoprogmetadesc;
    }

    public void setPenPyestadoprogmetadesc(String penPyestadoprogmetadesc) {
        this.penPyestadoprogmetadesc = penPyestadoprogmetadesc;
    }

    public String getPenPymagprogano1() {
        return penPymagprogano1;
    }

    public void setPenPymagprogano1(String penPymagprogano1) {
        this.penPymagprogano1 = penPymagprogano1;
    }

    public String getPenPymagejecano1() {
        return penPymagejecano1;
    }

    public void setPenPymagejecano1(String penPymagejecano1) {
        this.penPymagejecano1 = penPymagejecano1;
    }

    public String getPenPymagporcano1() {
        return penPymagporcano1;
    }

    public void setPenPymagporcano1(String penPymagporcano1) {
        this.penPymagporcano1 = penPymagporcano1;
    }

    public String getPenPymagprogano2() {
        return penPymagprogano2;
    }

    public void setPenPymagprogano2(String penPymagprogano2) {
        this.penPymagprogano2 = penPymagprogano2;
    }

    public String getPenPymagejecano2() {
        return penPymagejecano2;
    }

    public void setPenPymagejecano2(String penPymagejecano2) {
        this.penPymagejecano2 = penPymagejecano2;
    }

    public String getPenPymagporcano2() {
        return penPymagporcano2;
    }

    public void setPenPymagporcano2(String penPymagporcano2) {
        this.penPymagporcano2 = penPymagporcano2;
    }

    public String getPenPymagprogano3() {
        return penPymagprogano3;
    }

    public void setPenPymagprogano3(String penPymagprogano3) {
        this.penPymagprogano3 = penPymagprogano3;
    }

    public String getPenPymagejecano3() {
        return penPymagejecano3;
    }

    public void setPenPymagejecano3(String penPymagejecano3) {
        this.penPymagejecano3 = penPymagejecano3;
    }

    public String getPenPymagporcano3() {
        return penPymagporcano3;
    }

    public void setPenPymagporcano3(String penPymagporcano3) {
        this.penPymagporcano3 = penPymagporcano3;
    }

    public String getPenPymagprogano4() {
        return penPymagprogano4;
    }

    public void setPenPymagprogano4(String penPymagprogano4) {
        this.penPymagprogano4 = penPymagprogano4;
    }

    public String getPenPymagejecano4() {
        return penPymagejecano4;
    }

    public void setPenPymagejecano4(String penPymagejecano4) {
        this.penPymagejecano4 = penPymagejecano4;
    }

    public String getPenPymagporcano4() {
        return penPymagporcano4;
    }

    public void setPenPymagporcano4(String penPymagporcano4) {
        this.penPymagporcano4 = penPymagporcano4;
    }

    public String getPenPymagprogano5() {
        return penPymagprogano5;
    }

    public void setPenPymagprogano5(String penPymagprogano5) {
        this.penPymagprogano5 = penPymagprogano5;
    }

    public String getPenPymagejecano5() {
        return penPymagejecano5;
    }

    public void setPenPymagejecano5(String penPymagejecano5) {
        this.penPymagejecano5 = penPymagejecano5;
    }

    public String getPenPymagporcano5() {
        return penPymagporcano5;
    }

    public void setPenPymagporcano5(String penPymagporcano5) {
        this.penPymagporcano5 = penPymagporcano5;
    }

    public String getPenPymagprogtot() {
        return penPymagprogtot;
    }

    public void setPenPymagprogtot(String penPymagprogtot) {
        this.penPymagprogtot = penPymagprogtot;
    }

    public String getPenPymagejectot() {
        return penPymagejectot;
    }

    public void setPenPymagejectot(String penPymagejectot) {
        this.penPymagejectot = penPymagejectot;
    }

    public String getPenPymagporctot() {
        return penPymagporctot;
    }

    public void setPenPymagporctot(String penPymagporctot) {
        this.penPymagporctot = penPymagporctot;
    }

    public String getPenPyrecprogano1() {
        return penPyrecprogano1;
    }

    public void setPenPyrecprogano1(String penPyrecprogano1) {
        this.penPyrecprogano1 = penPyrecprogano1;
    }

    public String getPenPyrecejecano1() {
        return penPyrecejecano1;
    }

    public void setPenPyrecejecano1(String penPyrecejecano1) {
        this.penPyrecejecano1 = penPyrecejecano1;
    }

    public String getPenPyrecporcano1() {
        return penPyrecporcano1;
    }

    public void setPenPyrecporcano1(String penPyrecporcano1) {
        this.penPyrecporcano1 = penPyrecporcano1;
    }

    public String getPenPyrecprogano2() {
        return penPyrecprogano2;
    }

    public void setPenPyrecprogano2(String penPyrecprogano2) {
        this.penPyrecprogano2 = penPyrecprogano2;
    }

    public String getPenPyrecejecano2() {
        return penPyrecejecano2;
    }

    public void setPenPyrecejecano2(String penPyrecejecano2) {
        this.penPyrecejecano2 = penPyrecejecano2;
    }

    public String getPenPyrecporcano2() {
        return penPyrecporcano2;
    }

    public void setPenPyrecporcano2(String penPyrecporcano2) {
        this.penPyrecporcano2 = penPyrecporcano2;
    }

    public String getPenPyrecprogano3() {
        return penPyrecprogano3;
    }

    public void setPenPyrecprogano3(String penPyrecprogano3) {
        this.penPyrecprogano3 = penPyrecprogano3;
    }

    public String getPenPyrecejecano3() {
        return penPyrecejecano3;
    }

    public void setPenPyrecejecano3(String penPyrecejecano3) {
        this.penPyrecejecano3 = penPyrecejecano3;
    }

    public String getPenPyrecporcano3() {
        return penPyrecporcano3;
    }

    public void setPenPyrecporcano3(String penPyrecporcano3) {
        this.penPyrecporcano3 = penPyrecporcano3;
    }

    public String getPenPyrecprogano4() {
        return penPyrecprogano4;
    }

    public void setPenPyrecprogano4(String penPyrecprogano4) {
        this.penPyrecprogano4 = penPyrecprogano4;
    }

    public String getPenPyrecejecano4() {
        return penPyrecejecano4;
    }

    public void setPenPyrecejecano4(String penPyrecejecano4) {
        this.penPyrecejecano4 = penPyrecejecano4;
    }

    public String getPenPyrecporcano4() {
        return penPyrecporcano4;
    }

    public void setPenPyrecporcano4(String penPyrecporcano4) {
        this.penPyrecporcano4 = penPyrecporcano4;
    }

    public String getPenPyrecprogano5() {
        return penPyrecprogano5;
    }

    public void setPenPyrecprogano5(String penPyrecprogano5) {
        this.penPyrecprogano5 = penPyrecprogano5;
    }

    public String getPenPyrecejecano5() {
        return penPyrecejecano5;
    }

    public void setPenPyrecejecano5(String penPyrecejecano5) {
        this.penPyrecejecano5 = penPyrecejecano5;
    }

    public String getPenPyrecporcano5() {
        return penPyrecporcano5;
    }

    public void setPenPyrecporcano5(String penPyrecporcano5) {
        this.penPyrecporcano5 = penPyrecporcano5;
    }

    public String getPenPyrecprogtot() {
        return penPyrecprogtot;
    }

    public void setPenPyrecprogtot(String penPyrecprogtot) {
        this.penPyrecprogtot = penPyrecprogtot;
    }

    public String getPenPyrecejectot() {
        return penPyrecejectot;
    }

    public void setPenPyrecejectot(String penPyrecejectot) {
        this.penPyrecejectot = penPyrecejectot;
    }

    public String getPenPyrecporctot() {
        return penPyrecporctot;
    }

    public void setPenPyrecporctot(String penPyrecporctot) {
        this.penPyrecporctot = penPyrecporctot;
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
        hash += (penId != null ? penId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlaEntidadesmpi)) {
            return false;
        }
        PlaEntidadesmpi other = (PlaEntidadesmpi) object;
        if ((this.penId == null && other.penId != null) || (this.penId != null && !this.penId.equals(other.penId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.veeduria.dao.PlaEntidadesmpi[ penId=" + penId + " ]";
    }
    
}
