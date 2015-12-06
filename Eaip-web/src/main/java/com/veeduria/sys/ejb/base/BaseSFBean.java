/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veeduria.sys.ejb.base;

import com.veeduria.adm.dao.AdmDefajuste;
import com.veeduria.adm.dao.AdmProceso;
import com.veeduria.cnt.dao.CntPlancuetagastos;
import com.veeduria.sys.dao.SysFuncionario;
import com.veeduria.sys.dao.SysRegistrocarga;
import java.sql.Connection;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.Remove;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;

/**
 *
 * @author luz
 */
public abstract class BaseSFBean {

    @PersistenceContext
    protected EntityManager em;

    @Resource(name = "jdbcVeeduria")
    protected DataSource jdbcVeeduria;

    protected Connection con = null;
    
    //<editor-fold defaultstate="collapsed" desc="Funcionario">
      public List<SysFuncionario> getLstFunc(){
       return em.createNamedQuery("SysFuncionario.findAll").getResultList();
      }
      
      public List<SysFuncionario> getLstSysFuncXRol(Integer pRolId){
       return em.createNamedQuery("SysFuncionario.funcXRol").
               setParameter("rolId", pRolId).
               getResultList();
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Proceso">
      public List<AdmProceso> getLstAdmProc(){
       return em.createNamedQuery("AdmProceso.findAll").getResultList();
      }
//</editor-fold>

    public List<SysRegistrocarga> getLstSRCXValidado(Boolean pLgregValidado) {
        return em.createNamedQuery("SysRegistrocarga.findByLgregValidado")
                .setParameter("lgregValidado", pLgregValidado)
                .getResultList();

    }

    public List<SysRegistrocarga> getLstSRCConLogInc(Boolean pLogAplicado) {
        return em.createNamedQuery("SysRegistrocarga.sysRegConLogInc").
                setParameter("logAplicado", pLogAplicado).
                getResultList();
    }
    
    public AdmDefajuste getAdmDefAjXInc(Long pLogId){
        return (AdmDefajuste) em.createNamedQuery("AdmDefajuste.ajuXLogInc").
                setParameter("logId", pLogId).
                getSingleResult();
    }

    public List<CntPlancuetagastos> getLstPCGXCuentaXVig(String pPcoNumcuenta, Integer pPcoVigencia) {
        return em.createNamedQuery("CntPlancuetagastos.findCuentaYPeriodo")
                .setParameter("pcoNumcuenta", pPcoNumcuenta)
                .setParameter("pcoVigencia", pPcoVigencia)
                .getResultList();

    }
    
     public List<CntPlancuetagastos> getLstPCGXCuentaXNombre(String pPcoNomcuenta) {
        return em.createNamedQuery("CntPlancuetagastos.findCuentaLikeNombre")
                .setParameter("pcoNomcuenta", "%"+pPcoNomcuenta+"%")                
                .getResultList();

    }

    @Remove
    public void remove() {
    }
}
