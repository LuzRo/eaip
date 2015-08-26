/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veeduria.not.dao;

import com.veeduria.adm.dao.AdmProceso;
import com.veeduria.sys.dao.SysRolxfrn;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author luz
 */
@Entity
@Table(name = "adm_notificacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdmNotificacion.findAll", query = "SELECT a FROM AdmNotificacion a"),
    @NamedQuery(name = "AdmNotificacion.findByNotId", query = "SELECT a FROM AdmNotificacion a WHERE a.notId = :notId"),
    @NamedQuery(name = "AdmNotificacion.findByNotMensaje", query = "SELECT a FROM AdmNotificacion a WHERE a.notMensaje = :notMensaje"),
    @NamedQuery(name = "AdmNotificacion.findByNotPrioridad", query = "SELECT a FROM AdmNotificacion a WHERE a.notPrioridad = :notPrioridad"),
    @NamedQuery(name = "AdmNotificacion.findByNotFinicio", query = "SELECT a FROM AdmNotificacion a WHERE a.notFinicio = :notFinicio"),
    @NamedQuery(name = "AdmNotificacion.findByNotFfinal", query = "SELECT a FROM AdmNotificacion a WHERE a.notFfinal = :notFfinal"),
    @NamedQuery(name = "AdmNotificacion.findByNotFcreacion", query = "SELECT a FROM AdmNotificacion a WHERE a.notFcreacion = :notFcreacion"),
    @NamedQuery(name = "AdmNotificacion.findByNotAtendida", query = "SELECT a FROM AdmNotificacion a WHERE a.notAtendida = :notAtendida"),
    @NamedQuery(name = "AdmNotificacion.findByNotHoraatendida", query = "SELECT a FROM AdmNotificacion a WHERE a.notHoraatendida = :notHoraatendida"),
    @NamedQuery(name = "AdmNotificacion.notXFrn", query = "SELECT a FROM AdmNotificacion a JOIN a.admNotxfuncionarioList nxf JOIN nxf.frnId frn WHERE frn.frnId = :frnId AND nxf.ntfrAtendida = :ntfrAtendida  ORDER BY a.proId.proNombre, a.notFfinal, a.notPrioridad DESC")
})
public class AdmNotificacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)  
    @Column(name = "not_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long notId;
    @Size(max = 2147483647)
    @Column(name = "not_mensaje")
    private String notMensaje;
    @Size(max = 50)
    @Column(name = "not_prioridad")
    private String notPrioridad;
    @Column(name = "not_finicio")
    @Temporal(TemporalType.DATE)
    private Date notFinicio;
    @Column(name = "not_ffinal")
    @Temporal(TemporalType.DATE)
    private Date notFfinal;
    @Column(name = "not_fcreacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date notFcreacion;
    @Column(name = "not_atendida")
    private Boolean notAtendida;
    @Column(name = "not_horaatendida")
    @Temporal(TemporalType.TIMESTAMP)
    private Date notHoraatendida;
    @OneToMany(mappedBy = "notId")
    private List<AdmNotxfuncionario> admNotxfuncionarioList;
    @JoinColumn(name = "rlfr_id", referencedColumnName = "rlfr_id")
    @ManyToOne
    private SysRolxfrn rlfrId;
    @JoinColumn(name = "pro_id", referencedColumnName = "pro_id")
    @ManyToOne
    private AdmProceso proId;

    public AdmNotificacion() {
    }

    public AdmNotificacion(Long notId) {
        this.notId = notId;
    }

    public Long getNotId() {
        return notId;
    }

    public void setNotId(Long notId) {
        this.notId = notId;
    }

    public String getNotMensaje() {
        return notMensaje;
    }

    public void setNotMensaje(String notMensaje) {
        this.notMensaje = notMensaje;
    }

    public String getNotPrioridad() {
        return notPrioridad;
    }

    public void setNotPrioridad(String notPrioridad) {
        this.notPrioridad = notPrioridad;
    }

    public Date getNotFinicio() {
        return notFinicio;
    }

    public void setNotFinicio(Date notFinicio) {
        this.notFinicio = notFinicio;
    }

    public Date getNotFfinal() {
        return notFfinal;
    }

    public void setNotFfinal(Date notFfinal) {
        this.notFfinal = notFfinal;
    }

    public Date getNotFcreacion() {
        return notFcreacion;
    }

    public void setNotFcreacion(Date notFcreacion) {
        this.notFcreacion = notFcreacion;
    }

    public Boolean getNotAtendida() {
        return notAtendida;
    }

    public void setNotAtendida(Boolean notAtendida) {
        this.notAtendida = notAtendida;
    }

    public Date getNotHoraatendida() {
        return notHoraatendida;
    }

    public void setNotHoraatendida(Date notHoraatendida) {
        this.notHoraatendida = notHoraatendida;
    }

    @XmlTransient
    public List<AdmNotxfuncionario> getAdmNotxfuncionarioList() {
        return admNotxfuncionarioList;
    }

    public void setAdmNotxfuncionarioList(List<AdmNotxfuncionario> admNotxfuncionarioList) {
        this.admNotxfuncionarioList = admNotxfuncionarioList;
    }

    public SysRolxfrn getRlfrId() {
        return rlfrId;
    }

    public void setRlfrId(SysRolxfrn rlfrId) {
        this.rlfrId = rlfrId;
    }

    public AdmProceso getProId() {
        return proId;
    }

    public void setProId(AdmProceso proId) {
        this.proId = proId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (notId != null ? notId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdmNotificacion)) {
            return false;
        }
        AdmNotificacion other = (AdmNotificacion) object;
        if ((this.notId == null && other.notId != null) || (this.notId != null && !this.notId.equals(other.notId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.veeduria.adm.dao.AdmNotificacion[ notId=" + notId + " ]";
    }

}
