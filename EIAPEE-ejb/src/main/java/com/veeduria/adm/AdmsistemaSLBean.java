/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veeduria.adm;

import com.veeduria.adm.dao.AdmComponenteproceso;
import com.veeduria.adm.dao.AdmEntidad;
import com.veeduria.adm.dao.AdmSectoradmin;
import com.veeduria.adm.dao.AdmSectorestruc;
import com.veeduria.adm.dao.AdmUnidadejec;
import com.veeduria.sys.dao.SysArchivo;
import com.veeduria.sys.dao.SysInforme;
import com.veeduria.sys.dao.SysMenuprin;
import com.veeduria.sys.dao.SysModulos;
import com.veeduria.sys.dao.SysRegistrocarga;
import com.veeduria.sys.dao.SysSubmodproc;
import com.veeduria.sys.dao.SysArchivosporentidades;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author luz
 */
@Stateless
@LocalBean
public class AdmsistemaSLBean {

    @PersistenceContext
    EntityManager em;

//    public List<SysArchivo> getLstArchivos() {
//
//        Query q = em.createNamedQuery("SysArchivo.findAll");
//        return q.getResultList();
//
//    }
    public List<SysArchivo> getLstArchivos(Integer pCpcId) {

        Query q = em.createNamedQuery("SysArchivo.archivoporCpcId");
        q.setParameter("cpcId", pCpcId);
        return q.getResultList();
    }

    public List<SysArchivo> getLstArchivosPrespuesto(List<String> pLststrParametros) {

        StringBuilder strbpP = new StringBuilder();
        strbpP.append("SELECT s FROM SysArchivo s WHERE s.cpcId.cpcId NOT IN (");
        for (String string : pLststrParametros) {
            strbpP.append(string);
            strbpP.append(",");
        }
        strbpP.replace(strbpP.length() - 1, strbpP.length(), "");
        strbpP.append(")");
        Query q = em.createQuery(strbpP.toString());
        return q.getResultList();
    }

    public List<SysArchivosporentidades> getLstArchivosporentidades(String pEntId, Integer pArcId) {

        Query q = em.createNamedQuery("SysArchivosporentidades.archivosPorEntidades");
        q.setParameter("entId", pEntId);
        q.setParameter("arcId", pArcId);
        return q.getResultList();
    }

    public AdmEntidad getLstEntidadporId(String pEntId) {

        Query q = em.createNamedQuery("AdmEntidad.findByEntId");
        q.setParameter("entId", pEntId);
        return (AdmEntidad) q.getSingleResult();
    }

    public SysArchivosporentidades getArchivosporentidades(String pEntId, Integer pArcId) {
        try {
            Query q = em.createNamedQuery("SysArchivosporentidades.archivosPorEntidades");
            q.setParameter("entId", pEntId);
            q.setParameter("arcId", pArcId);
            return (SysArchivosporentidades) q.getSingleResult();
        } catch (NoResultException | NonUniqueResultException ex) {
            return null;

        }
    }

    public SysRegistrocarga grabarRegistrocarga(SysRegistrocarga pSysRegistrocarga) {
        AdmEntidad ae = em.getReference(AdmEntidad.class, pSysRegistrocarga.getEntId().getEntId());
        AdmSectorestruc as = em.getReference(AdmSectorestruc.class, pSysRegistrocarga.getSesId().getSesId());
        AdmUnidadejec au = em.getReference(AdmUnidadejec.class, pSysRegistrocarga.getEjeCodigo().getEjeCodigo());
        pSysRegistrocarga.setEntId(ae);
        pSysRegistrocarga.setSesId(as);
        pSysRegistrocarga.setEjeCodigo(au);
        return em.merge(pSysRegistrocarga);
    }

    public List<AdmEntidad> getLstEntidads() {

        Query q = em.createNamedQuery("AdmEntidad.findAll");
        return q.getResultList();
    }

    public List<SysMenuprin> getLstMenuprins() {

        Query q = em.createNamedQuery("SysMenuprin.findAll");
        return q.getResultList();
    }

    public List<SysMenuprin> getLstMenuprinsxFrn(String pfrnId) {

        Query q = em.createNamedQuery("SysMenuprin.menxFrn");
        q.setParameter("frnId", pfrnId);
        q.setParameter("menEst", Boolean.TRUE);
        return q.getResultList();

    }

    public List<SysModulos> getLstModulosxMenu(Integer pmenId) {

        Query q = em.createNamedQuery("SysModulos.modulosXMenu");
        q.setParameter("menId", pmenId);
        q.setParameter("procEstado", Boolean.TRUE);
        return q.getResultList();
    }

    public List<SysSubmodproc> getLstSubmodproc() {

        Query q = em.createNamedQuery("SysSubmodproc.findAll");
        return q.getResultList();
    }

    public List<SysSubmodproc> getLstSubmodprocxFrn(String pfrnId) {

        Query q = em.createNamedQuery("SysSubmodproc.submodxFrn");
        q.setParameter("frnId", pfrnId);
        return q.getResultList();
    }

    public List<SysSubmodproc> getLstSubmodprocxMod(Integer pprocId) {

        Query q = em.createNamedQuery("SysSubmodproc.submodxMod");
        q.setParameter("procId", pprocId);
        return q.getResultList();
    }

    public List<SysSubmodproc> getLstSubmodprocxModXFrn(String pFrnId, Integer pProcId) {
        Query q = em.createNamedQuery("SysSubmodproc.submodxModulosXFuncionario");
        q.setParameter("procId", pProcId);
        q.setParameter("frnId", pFrnId);
        return q.getResultList();
    }

    public List<AdmEntidad> getLstEnt() {
        Query q = em.createNamedQuery("AdmEntidad.findAll");
        return q.getResultList();
    }

    public List<AdmEntidad> getLstEntxSe(Integer pSesId) {
        Query q = em.createNamedQuery("AdmEntidad.entxSe");
        q.setParameter("sesId", pSesId);
        return q.getResultList();
    }

    public List<AdmEntidad> getLstEntxTe(Integer pTpeId) {
        Query q = em.createNamedQuery("AdmEntidad.entxTe");
        q.setParameter("tpeId", pTpeId);
        return q.getResultList();

    }

    public List<AdmEntidad> getLstEntxSa(Integer pSadId) {

        Query q = em.createNamedQuery("AdmEntidad.entxSa");
        q.setParameter("sadId", pSadId);
        return q.getResultList();
    }

    public List<AdmEntidad> getLstEntxSexSa(Integer pSesId, Integer pSadId) {

        Query q = em.createNamedQuery("AdmEntidad.entxSexSa");
        q.setParameter("sesId", pSesId);
        q.setParameter("sadId", pSadId);
        return q.getResultList();
    }

    public List<AdmUnidadejec> getLstUnidadejecxEnt(String pEntId) {

        Query q = em.createNamedQuery("AdmUnidadejec.unixEntidad");
        q.setParameter("entId", pEntId);
        return q.getResultList();

    }

    public List<SysInforme> getLstInformeporFuncionario(String pFrnId) {

        Query q = em.createNamedQuery("SysInforme.infxFuncionario");
        q.setParameter("frnId", pFrnId);
        return q.getResultList();

    }

    public List<SysInforme> getLstInformeporNumpanel(Integer pNumpanel) {

        Query q = em.createNamedQuery("SysInforme.findByNumpanel");
        q.setParameter("numpanel", pNumpanel);
        return q.getResultList();
    }

//    public List <AdmSectoradmin> getLstSecadxSeces (Integer pSesId){
//    
//        Query q = em.createNamedQuery("AdmSectoradmin.secadminxsecestr");
//        q.setParameter("sesId", pSesId);
//        return q.getResultList();
//        
//    }
    public List<AdmSectorestruc> getLstSectorestrucs() {

        Query q = em.createNamedQuery("AdmSectorestruc.findAll");
        return q.getResultList();
    }

    public List<AdmUnidadejec> getLstUnidadEjec() {

        Query q = em.createNamedQuery("AdmUnidadejec.findAll");
        return q.getResultList();
    }

    public List<AdmSectoradmin> getLstSectoradmin() {

        Query q = em.createNamedQuery("AdmSectoradmin.findAll");
        return q.getResultList();

    }

    public SysInforme getSysInformeXId(Integer pInfId) {
        return em.find(SysInforme.class, pInfId);
    }

    public List<SysInforme> getSysInformeXEst(Boolean pInfEst) {
        Query q = em.createNamedQuery("SysInforme.findByInfEst");
        q.setParameter("infEst", pInfEst);
        return q.getResultList();
    }

    public Long getNomcargaDuplicados(String pLgregNomarchivocarga, Integer pLgregIdmsjcarga) {

        Query q = em.createNamedQuery("SysRegistrocarga.nomarchcargaporIdcarga");
        q.setParameter("lgregNomarchivocarga", pLgregNomarchivocarga);
        q.setParameter("lgregIdmsjcarga", pLgregIdmsjcarga);
        return (Long) q.getSingleResult();
    }

    public List<SysInforme> getDetporNominforme(String pInfNombre) {

        Query q = em.createNamedQuery("SysInforme.detxNominforme");
        q.setParameter("infNombre", pInfNombre);
        return q.getResultList();
    }

    public List<SysInforme> getDetporFrecuencia(String pInfFrecuencia) {
        Query q = em.createNamedQuery("SysInforme.detxFrecuencia");
        q.setParameter("infFrecuencia", pInfFrecuencia);
        return q.getResultList();
    }

    public List<SysInforme> getLstSysInfXComp(Integer pCompId) {
        return em.createNamedQuery("SysInforme.infXComp").
                setParameter("comId", pCompId).
                getResultList();
    }

    public List<SysInforme> getLstInformeporCompXFrecuencia(Integer pComId, String pInfFrecuencia) {
        Query q = em.createNamedQuery("SysInforme.infXCompXfre");
        q.setParameter("comId", pComId);
        q.setParameter("infFrecuencia", pInfFrecuencia);
        return q.getResultList();
    }


    /*public List<SysInforme> getLstNomComponente(String pcomNombre) {
     return em.createNamedQuery("AdmComponenteproceso.findByComNombre").
     setParameter("comNombre", pcomNombre).getResultList();
     }*/
    public List<AdmComponenteproceso> getLstCompProcXProceso(Integer pProId) {
        return em.createNamedQuery("AdmComponenteproceso.compXProc").
                setParameter("proId", pProId).
                getResultList();
    }

    public List<AdmSectoradmin> getLstAdmSectoradmin() {
        return em.createNamedQuery("AdmSectoradmin.findAll").
                getResultList();
    }
    /**
     * Grabar log informe
     *
     * @param pLogInforme
     * @return
     */
//    @TransactionAttribute(TransactionAttributeType.REQUIRED)
//    public LogInforme grabarLogInforme(LogInforme pLogInforme) {
//        pLogInforme = em.merge(pLogInforme);
//        return pLogInforme;
//
//    }
}
