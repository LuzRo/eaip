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
@Table(name = "thm_contratistas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ThmContratistas.findAll", query = "SELECT t FROM ThmContratistas t"),
    @NamedQuery(name = "ThmContratistas.findByConId", query = "SELECT t FROM ThmContratistas t WHERE t.conId = :conId"),
    @NamedQuery(name = "ThmContratistas.findByConNumcontrato", query = "SELECT t FROM ThmContratistas t WHERE t.conNumcontrato = :conNumcontrato"),
    @NamedQuery(name = "ThmContratistas.findByConNombres", query = "SELECT t FROM ThmContratistas t WHERE t.conNombres = :conNombres"),
    @NamedQuery(name = "ThmContratistas.findByConApellido1", query = "SELECT t FROM ThmContratistas t WHERE t.conApellido1 = :conApellido1"),
    @NamedQuery(name = "ThmContratistas.findByConApellido2", query = "SELECT t FROM ThmContratistas t WHERE t.conApellido2 = :conApellido2"),
    @NamedQuery(name = "ThmContratistas.findByConCedula", query = "SELECT t FROM ThmContratistas t WHERE t.conCedula = :conCedula"),
    @NamedQuery(name = "ThmContratistas.findByConObjetocontrato", query = "SELECT t FROM ThmContratistas t WHERE t.conObjetocontrato = :conObjetocontrato"),
    @NamedQuery(name = "ThmContratistas.findByConFechainicio", query = "SELECT t FROM ThmContratistas t WHERE t.conFechainicio = :conFechainicio"),
    @NamedQuery(name = "ThmContratistas.findByConFechafin", query = "SELECT t FROM ThmContratistas t WHERE t.conFechafin = :conFechafin"),
    @NamedQuery(name = "ThmContratistas.findByConValorcontrato", query = "SELECT t FROM ThmContratistas t WHERE t.conValorcontrato = :conValorcontrato"),
    @NamedQuery(name = "ThmContratistas.findByConGenero", query = "SELECT t FROM ThmContratistas t WHERE t.conGenero = :conGenero")})
public class ThmContratistas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "con_id")
    private Long conId;
    @Size(max = 200)
    @Column(name = "con_numcontrato")
    private String conNumcontrato;
    @Size(max = 300)
    @Column(name = "con_nombres")
    private String conNombres;
    @Size(max = 200)
    @Column(name = "con_apellido1")
    private String conApellido1;
    @Size(max = 200)
    @Column(name = "con_apellido2")
    private String conApellido2;
    @Size(max = 200)
    @Column(name = "con_cedula")
    private String conCedula;
    @Size(max = 1500)
    @Column(name = "con_objetocontrato")
    private String conObjetocontrato;
    @Size(max = 100)
    @Column(name = "con_fechainicio")
    private String conFechainicio;
    @Size(max = 100)
    @Column(name = "con_fechafin")
    private String conFechafin;
    @Size(max = 15000)
    @Column(name = "con_valorcontrato")
    private String conValorcontrato;
    @Size(max = 100)
    @Column(name = "con_genero")
    private String conGenero;
    @JoinColumn(name = "lgreg_id", referencedColumnName = "lgreg_id")
    @ManyToOne
    private SysRegistrocarga lgregId;

    public ThmContratistas() {
    }

    public ThmContratistas(Long conId) {
        this.conId = conId;
    }

    public Long getConId() {
        return conId;
    }

    public void setConId(Long conId) {
        this.conId = conId;
    }

    public String getConNumcontrato() {
        return conNumcontrato;
    }

    public void setConNumcontrato(String conNumcontrato) {
        this.conNumcontrato = conNumcontrato;
    }

    public String getConNombres() {
        return conNombres;
    }

    public void setConNombres(String conNombres) {
        this.conNombres = conNombres;
    }

    public String getConApellido1() {
        return conApellido1;
    }

    public void setConApellido1(String conApellido1) {
        this.conApellido1 = conApellido1;
    }

    public String getConApellido2() {
        return conApellido2;
    }

    public void setConApellido2(String conApellido2) {
        this.conApellido2 = conApellido2;
    }

    public String getConCedula() {
        return conCedula;
    }

    public void setConCedula(String conCedula) {
        this.conCedula = conCedula;
    }

    public String getConObjetocontrato() {
        return conObjetocontrato;
    }

    public void setConObjetocontrato(String conObjetocontrato) {
        this.conObjetocontrato = conObjetocontrato;
    }

    public String getConFechainicio() {
        return conFechainicio;
    }

    public void setConFechainicio(String conFechainicio) {
        this.conFechainicio = conFechainicio;
    }

    public String getConFechafin() {
        return conFechafin;
    }

    public void setConFechafin(String conFechafin) {
        this.conFechafin = conFechafin;
    }

    public String getConValorcontrato() {
        return conValorcontrato;
    }

    public void setConValorcontrato(String conValorcontrato) {
        this.conValorcontrato = conValorcontrato;
    }

    public String getConGenero() {
        return conGenero;
    }

    public void setConGenero(String conGenero) {
        this.conGenero = conGenero;
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
        hash += (conId != null ? conId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ThmContratistas)) {
            return false;
        }
        ThmContratistas other = (ThmContratistas) object;
        if ((this.conId == null && other.conId != null) || (this.conId != null && !this.conId.equals(other.conId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.veeduria.dao.ThmContratistas[ conId=" + conId + " ]";
    }
    
}
