/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veeduria.pre.dao;

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
 * @author luis
 */
@Entity
@Table(name = "pre_cmingreso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PreCmingreso.findAll", query = "SELECT p FROM PreCmingreso p"),
    @NamedQuery(name = "PreCmingreso.findByCingId", query = "SELECT p FROM PreCmingreso p WHERE p.cingId = :cingId"),
    @NamedQuery(name = "PreCmingreso.findByCodCuenta", query = "SELECT p FROM PreCmingreso p WHERE p.codCuenta = :codCuenta"),
    @NamedQuery(name = "PreCmingreso.findByNomCuenta", query = "SELECT p FROM PreCmingreso p WHERE p.nomCuenta = :nomCuenta"),
    @NamedQuery(name = "PreCmingreso.findByPptoInicial", query = "SELECT p FROM PreCmingreso p WHERE p.pptoInicial = :pptoInicial"),
    @NamedQuery(name = "PreCmingreso.findByModMes", query = "SELECT p FROM PreCmingreso p WHERE p.modMes = :modMes"),
    @NamedQuery(name = "PreCmingreso.findByModAcumulado", query = "SELECT p FROM PreCmingreso p WHERE p.modAcumulado = :modAcumulado"),
    @NamedQuery(name = "PreCmingreso.findByPptoDefinitivo", query = "SELECT p FROM PreCmingreso p WHERE p.pptoDefinitivo = :pptoDefinitivo"),
    @NamedQuery(name = "PreCmingreso.findByRecuadoMes", query = "SELECT p FROM PreCmingreso p WHERE p.recuadoMes = :recuadoMes"),
    @NamedQuery(name = "PreCmingreso.findByRecuadoAcum", query = "SELECT p FROM PreCmingreso p WHERE p.recuadoAcum = :recuadoAcum"),
    @NamedQuery(name = "PreCmingreso.findByPorEjec", query = "SELECT p FROM PreCmingreso p WHERE p.porEjec = :porEjec"),
    @NamedQuery(name = "PreCmingreso.findBySaldoRecaudar", query = "SELECT p FROM PreCmingreso p WHERE p.saldoRecaudar = :saldoRecaudar"),
    @NamedQuery(name = "PreCmingreso.findByRecurReser", query = "SELECT p FROM PreCmingreso p WHERE p.recurReser = :recurReser"),
    @NamedQuery(name = "PreCmingreso.findByIngrFinal", query = "SELECT p FROM PreCmingreso p WHERE p.ingrFinal = :ingrFinal")})
public class PreCmingreso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cing_id")
    private Long cingId;
    @Size(max = 1500)
    @Column(name = "cing_codcuenta")
    private String codCuenta;
    @Size(max = 1500)
    @Column(name = "cing_nomcuenta")
    private String nomCuenta;
    @Size(max = 1500)
    @Column(name = "cing_pptoinicial")
    private String pptoInicial;
    @Size(max = 1500)
    @Column(name = "cing_modmes")
    private String modMes;
    @Size(max = 1500)
    @Column(name = "cing_modacumulado")
    private String modAcumulado;
    @Size(max = 1500)
    @Column(name = "cing_pptodefinitivo")
    private String pptoDefinitivo;
    @Size(max = 1500)
    @Column(name = "cing_recuadomes")
    private String recuadoMes;
    @Size(max = 1500)
    @Column(name = "cing_recuadoacum")
    private String recuadoAcum;
    @Size(max = 1500)
    @Column(name = "cing_porejec")
    private String porEjec;
    @Size(max = 1500)
    @Column(name = "cing_saldorecaudar")
    private String saldoRecaudar;
    @Size(max = 1500)
    @Column(name = "cing_recurreser")
    private String recurReser;
    @Size(max = 1500)
    @Column(name = "cing_ingrfinal")

    private String ingrFinal;
    @JoinColumn(name = "lgreg_id", referencedColumnName = "lgreg_id")
    @ManyToOne
    private SysRegistrocarga lgregId;

    public PreCmingreso() {
    }

    public PreCmingreso(Long cingId) {
        this.cingId = cingId;
    }

    public Long getCingId() {
        return cingId;
    }

    public void setCingId(Long cingId) {
        this.cingId = cingId;
    }

    public String getCodCuenta() {
        return codCuenta;
    }

    public void setCodCuenta(String codCuenta) {
        this.codCuenta = codCuenta;
    }

    public String getNomCuenta() {
        return nomCuenta;
    }

    public void setNomCuenta(String nomCuenta) {
        this.nomCuenta = nomCuenta;
    }

    public String getPptoInicial() {
        return pptoInicial;
    }

    public void setPptoInicial(String pptoInicial) {
        this.pptoInicial = pptoInicial;
    }

    public String getModMes() {
        return modMes;
    }

    public void setModMes(String modMes) {
        this.modMes = modMes;
    }

    public String getModAcumulado() {
        return modAcumulado;
    }

    public void setModAcumulado(String modAcumulado) {
        this.modAcumulado = modAcumulado;
    }

    public String getPptoDefinitivo() {
        return pptoDefinitivo;
    }

    public void setPptoDefinitivo(String pptoDefinitivo) {
        this.pptoDefinitivo = pptoDefinitivo;
    }

    public String getRecuadoMes() {
        return recuadoMes;
    }

    public void setRecuadoMes(String recuadoMes) {
        this.recuadoMes = recuadoMes;
    }

    public String getRecuadoAcum() {
        return recuadoAcum;
    }

    public void setRecuadoAcum(String recuadoAcum) {
        this.recuadoAcum = recuadoAcum;
    }

    public String getPorEjec() {
        return porEjec;
    }

    public void setPorEjec(String porEjec) {
        this.porEjec = porEjec;
    }

    public String getSaldoRecaudar() {
        return saldoRecaudar;
    }

    public void setSaldoRecaudar(String saldoRecaudar) {
        this.saldoRecaudar = saldoRecaudar;
    }

    public String getRecurReser() {
        return recurReser;
    }

    public void setRecurReser(String recurReser) {
        this.recurReser = recurReser;
    }

    public String getIngrFinal() {
        return ingrFinal;
    }

    public void setIngrFinal(String ingrFinal) {
        this.ingrFinal = ingrFinal;
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
        hash += (cingId != null ? cingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PreCmingreso)) {
            return false;
        }
        PreCmingreso other = (PreCmingreso) object;
        if ((this.cingId == null && other.cingId != null) || (this.cingId != null && !this.cingId.equals(other.cingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.veeduria.dao.PreCmingreso[ cingId=" + cingId + " ]";
    }
    
}