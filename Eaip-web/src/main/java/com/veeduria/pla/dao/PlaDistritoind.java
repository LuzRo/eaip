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
@Table(name = "pla_distritoind")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlaDistritoind.findAll", query = "SELECT p FROM PlaDistritoind p"),
    @NamedQuery(name = "PlaDistritoind.findByPdiId", query = "SELECT p FROM PlaDistritoind p WHERE p.pdiId = :pdiId"),
    @NamedQuery(name = "PlaDistritoind.findByPdiIndidrep", query = "SELECT p FROM PlaDistritoind p WHERE p.pdiIndidrep = :pdiIndidrep"),
    @NamedQuery(name = "PlaDistritoind.findByPdiIndid", query = "SELECT p FROM PlaDistritoind p WHERE p.pdiIndid = :pdiIndid"),
    @NamedQuery(name = "PlaDistritoind.findByPdiIndcodigopd", query = "SELECT p FROM PlaDistritoind p WHERE p.pdiIndcodigopd = :pdiIndcodigopd"),
    @NamedQuery(name = "PlaDistritoind.findByPdiIndanoprogrepr", query = "SELECT p FROM PlaDistritoind p WHERE p.pdiIndanoprogrepr = :pdiIndanoprogrepr"),
    @NamedQuery(name = "PlaDistritoind.findByPdiIndversionpa", query = "SELECT p FROM PlaDistritoind p WHERE p.pdiIndversionpa = :pdiIndversionpa"),
    @NamedQuery(name = "PlaDistritoind.findByPdiIndcodigosector", query = "SELECT p FROM PlaDistritoind p WHERE p.pdiIndcodigosector = :pdiIndcodigosector"),
    @NamedQuery(name = "PlaDistritoind.findByPdiIndcodigoentidad", query = "SELECT p FROM PlaDistritoind p WHERE p.pdiIndcodigoentidad = :pdiIndcodigoentidad"),
    @NamedQuery(name = "PlaDistritoind.findByPdiIndcodigointernonivel7", query = "SELECT p FROM PlaDistritoind p WHERE p.pdiIndcodigointernonivel7 = :pdiIndcodigointernonivel7"),
    @NamedQuery(name = "PlaDistritoind.findByPdiIndcodigoproyectopri", query = "SELECT p FROM PlaDistritoind p WHERE p.pdiIndcodigoproyectopri = :pdiIndcodigoproyectopri"),
    @NamedQuery(name = "PlaDistritoind.findByPdiIndcodigomgr", query = "SELECT p FROM PlaDistritoind p WHERE p.pdiIndcodigomgr = :pdiIndcodigomgr"),
    @NamedQuery(name = "PlaDistritoind.findByPdiIndcodigoindicador", query = "SELECT p FROM PlaDistritoind p WHERE p.pdiIndcodigoindicador = :pdiIndcodigoindicador"),
    @NamedQuery(name = "PlaDistritoind.findByPdiIndnombreindicador", query = "SELECT p FROM PlaDistritoind p WHERE p.pdiIndnombreindicador = :pdiIndnombreindicador"),
    @NamedQuery(name = "PlaDistritoind.findByPdiIndindicadortiposuma", query = "SELECT p FROM PlaDistritoind p WHERE p.pdiIndindicadortiposuma = :pdiIndindicadortiposuma"),
    @NamedQuery(name = "PlaDistritoind.findByPdiIndestadoenpa", query = "SELECT p FROM PlaDistritoind p WHERE p.pdiIndestadoenpa = :pdiIndestadoenpa"),
    @NamedQuery(name = "PlaDistritoind.findByPdiInddescestadopa", query = "SELECT p FROM PlaDistritoind p WHERE p.pdiInddescestadopa = :pdiInddescestadopa"),
    @NamedQuery(name = "PlaDistritoind.findByPdiIndano", query = "SELECT p FROM PlaDistritoind p WHERE p.pdiIndano = :pdiIndano"),
    @NamedQuery(name = "PlaDistritoind.findByPdiIndproinicialpd", query = "SELECT p FROM PlaDistritoind p WHERE p.pdiIndproinicialpd = :pdiIndproinicialpd"),
    @NamedQuery(name = "PlaDistritoind.findByPdiIndprogactual", query = "SELECT p FROM PlaDistritoind p WHERE p.pdiIndprogactual = :pdiIndprogactual"),
    @NamedQuery(name = "PlaDistritoind.findByPdiIndejecvigencia", query = "SELECT p FROM PlaDistritoind p WHERE p.pdiIndejecvigencia = :pdiIndejecvigencia"),
    @NamedQuery(name = "PlaDistritoind.findByPdiIndporcvig", query = "SELECT p FROM PlaDistritoind p WHERE p.pdiIndporcvig = :pdiIndporcvig"),
    @NamedQuery(name = "PlaDistritoind.findByPdiIndporcavtrapd", query = "SELECT p FROM PlaDistritoind p WHERE p.pdiIndporcavtrapd = :pdiIndporcavtrapd"),
    @NamedQuery(name = "PlaDistritoind.findByPdiIndporcavpd", query = "SELECT p FROM PlaDistritoind p WHERE p.pdiIndporcavpd = :pdiIndporcavpd")})

public class PlaDistritoind implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pdi_id")
    private Long pdiId;
    @Size(max = 500)
    @Column(name = "pdi_indidrep")
    private String pdiIndidrep;
    @Size(max = 1500)
    @Column(name = "pdi_indid")
    private String pdiIndid;
    @Size(max = 100)
    @Column(name = "pdi_indcodigopd")
    private String pdiIndcodigopd;
    @Size(max = 100)
    @Column(name = "pdi_indanoprogrepr")
    private String pdiIndanoprogrepr;
    @Size(max = 100)
    @Column(name = "pdi_indversionpa")
    private String pdiIndversionpa;
    @Size(max = 100)
    @Column(name = "pdi_indcodigosector")
    private String pdiIndcodigosector;
    @Size(max = 100)
    @Column(name = "pdi_indcodigoentidad")
    private String pdiIndcodigoentidad;
    @Size(max = 100)
    @Column(name = "pdi_indcodigointernonivel7")
    private String pdiIndcodigointernonivel7;
    @Size(max = 100)
    @Column(name = "pdi_indcodigoproyectopri")
    private String pdiIndcodigoproyectopri;
    @Size(max = 100)
    @Column(name = "pdi_indcodigomgr")
    private String pdiIndcodigomgr;
    @Size(max = 100)
    @Column(name = "pdi_indcodigoindicador")
    private String pdiIndcodigoindicador;
    @Size(max = 1500)
    @Column(name = "pdi_indnombreindicador")
    private String pdiIndnombreindicador;
    @Size(max = 1500)
    @Column(name = "pdi_indindicadortiposuma")
    private String pdiIndindicadortiposuma;
    @Size(max = 100)
    @Column(name = "pdi_indestadoenpa")
    private String pdiIndestadoenpa;
    @Size(max = 1500)
    @Column(name = "pdi_inddescestadopa")
    private String pdiInddescestadopa;
    @Size(max = 100)
    @Column(name = "pdi_indano")
    private String pdiIndano;
    @Size(max = 100)
    @Column(name = "pdi_indproinicialpd")
    private String pdiIndproinicialpd;
    @Size(max = 100)
    @Column(name = "pdi_indprogactual")
    private String pdiIndprogactual;
    @Size(max = 100)
    @Column(name = "pdi_indejecvigencia")
    private String pdiIndejecvigencia;
    @Size(max = 100)
    @Column(name = "pdi_indporcvig")
    private String pdiIndporcvig;
    @Size(max = 100)
    @Column(name = "pdi_indporcavtrapd")
    private String pdiIndporcavtrapd;
    @Size(max = 100)
    @Column(name = "pdi_indporcavpd")
    private String pdiIndporcavpd;
    @JoinColumn(name = "lgreg_id", referencedColumnName = "lgreg_id")
    @ManyToOne(optional = false)
    private SysRegistrocarga lgregId;

    public PlaDistritoind() {
    }

    public PlaDistritoind(Long pdiId) {
        this.pdiId = pdiId;
    }

    public Long getPdiId() {
        return pdiId;
    }

    public void setPdiId(Long pdiId) {
        this.pdiId = pdiId;
    }

    public String getPdiIndid() {
        return pdiIndid;
    }

    public void setPdiIndid(String pdiIndid) {
        this.pdiIndid = pdiIndid;
    }

    public String getPdiIndidrep() {
        return pdiIndidrep;
    }

    public void setPdiIndidrep(String pdiIndidrep) {
        this.pdiIndidrep = pdiIndidrep;
    }

    public String getPdiIndcodigopd() {
        return pdiIndcodigopd;
    }

    public void setPdiIndcodigopd(String pdiIndcodigopd) {
        this.pdiIndcodigopd = pdiIndcodigopd;
    }

    public String getPdiIndanoprogrepr() {
        return pdiIndanoprogrepr;
    }

    public void setPdiIndanoprogrepr(String pdiIndanoprogrepr) {
        this.pdiIndanoprogrepr = pdiIndanoprogrepr;
    }

    public String getPdiIndversionpa() {
        return pdiIndversionpa;
    }

    public void setPdiIndversionpa(String pdiIndversionpa) {
        this.pdiIndversionpa = pdiIndversionpa;
    }

    public String getPdiIndcodigosector() {
        return pdiIndcodigosector;
    }

    public void setPdiIndcodigosector(String pdiIndcodigosector) {
        this.pdiIndcodigosector = pdiIndcodigosector;
    }

    public String getPdiIndcodigoentidad() {
        return pdiIndcodigoentidad;
    }

    public void setPdiIndcodigoentidad(String pdiIndcodigoentidad) {
        this.pdiIndcodigoentidad = pdiIndcodigoentidad;
    }

    public String getPdiIndcodigointernonivel7() {
        return pdiIndcodigointernonivel7;
    }

    public void setPdiIndcodigointernonivel7(String pdiIndcodigointernonivel7) {
        this.pdiIndcodigointernonivel7 = pdiIndcodigointernonivel7;
    }

    public String getPdiIndcodigoproyectopri() {
        return pdiIndcodigoproyectopri;
    }

    public void setPdiIndcodigoproyectopri(String pdiIndcodigoproyectopri) {
        this.pdiIndcodigoproyectopri = pdiIndcodigoproyectopri;
    }

    public String getPdiIndcodigomgr() {
        return pdiIndcodigomgr;
    }

    public void setPdiIndcodigomgr(String pdiIndcodigomgr) {
        this.pdiIndcodigomgr = pdiIndcodigomgr;
    }

    public String getPdiIndcodigoindicador() {
        return pdiIndcodigoindicador;
    }

    public void setPdiIndcodigoindicador(String pdiIndcodigoindicador) {
        this.pdiIndcodigoindicador = pdiIndcodigoindicador;
    }

    public String getPdiIndnombreindicador() {
        return pdiIndnombreindicador;
    }

    public void setPdiIndnombreindicador(String pdiIndnombreindicador) {
        this.pdiIndnombreindicador = pdiIndnombreindicador;
    }

    public String getPdiIndindicadortiposuma() {
        return pdiIndindicadortiposuma;
    }

    public void setPdiIndindicadortiposuma(String pdiIndindicadortiposuma) {
        this.pdiIndindicadortiposuma = pdiIndindicadortiposuma;
    }

    public String getPdiIndestadoenpa() {
        return pdiIndestadoenpa;
    }

    public void setPdiIndestadoenpa(String pdiIndestadoenpa) {
        this.pdiIndestadoenpa = pdiIndestadoenpa;
    }

    public String getPdiInddescestadopa() {
        return pdiInddescestadopa;
    }

    public void setPdiInddescestadopa(String pdiInddescestadopa) {
        this.pdiInddescestadopa = pdiInddescestadopa;
    }

    public String getPdiIndaño() {
        return pdiIndano;
    }

    public void setPdiIndaño(String pdiIndano) {
        this.pdiIndano = pdiIndano;
    }

    public String getPdiIndproinicialpd() {
        return pdiIndproinicialpd;
    }

    public void setPdiIndproinicialpd(String pdiIndproinicialpd) {
        this.pdiIndproinicialpd = pdiIndproinicialpd;
    }

    public String getPdiIndprogactual() {
        return pdiIndprogactual;
    }

    public void setPdiIndprogactual(String pdiIndprogactual) {
        this.pdiIndprogactual = pdiIndprogactual;
    }

    public String getPdiIndejecvigencia() {
        return pdiIndejecvigencia;
    }

    public void setPdiIndejecvigencia(String pdiIndejecvigencia) {
        this.pdiIndejecvigencia = pdiIndejecvigencia;
    }

    public String getPdiIndporcvig() {
        return pdiIndporcvig;
    }

    public void setPdiIndporcvig(String pdiIndporcvig) {
        this.pdiIndporcvig = pdiIndporcvig;
    }

    public String getPdiIndporctrapd() {
        return pdiIndporcavtrapd;
    }

    public void setPdiIndporctrapd(String pdiIndporctrapd) {
        this.pdiIndporcavtrapd = pdiIndporctrapd;
    }
    
        /**
     * @return the pdiIndporcavpd
     */
    public String getPdiIndporcavpd() {
        return pdiIndporcavpd;
    }

    /**
     * @param pdiIndporcavpd the pdiIndporcavpd to set
     */
    public void setPdiIndporcavpd(String pdiIndporcavpd) {
        this.pdiIndporcavpd = pdiIndporcavpd;
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
        hash += (pdiId != null ? pdiId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlaDistritoind)) {
            return false;
        }
        PlaDistritoind other = (PlaDistritoind) object;
        if ((this.pdiId == null && other.pdiId != null) || (this.pdiId != null && !this.pdiId.equals(other.pdiId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.veeduria.dao.PlaDistritoind[ pdiId=" + pdiId + " ]";
    }


    
}
