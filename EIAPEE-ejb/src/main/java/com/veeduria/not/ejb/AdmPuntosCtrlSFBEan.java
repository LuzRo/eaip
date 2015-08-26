/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veeduria.not.ejb;

import com.veeduria.adm.dao.AdmProceso;
import com.veeduria.not.dao.AdmNotificacion;
import com.veeduria.not.dao.AdmNotxfuncionario;
import com.veeduria.not.dao.PtcDefpuntoscontrol;
import com.veeduria.not.dao.PtcLogpuntocontrol;
import com.veeduria.not.dao.PtcPuntoscontrolxprocesoxfunc;
import com.veeduria.not.dao.PtcTipopuntocontrol;
import com.veeduria.sys.ejb.base.BaseSFBean;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;

/**
 *
 * @author fernando
 */
@Stateful
@LocalBean
public class AdmPuntosCtrlSFBEan extends BaseSFBean {

    private AdmNotificacion admNotifSel = new AdmNotificacion();

    public List<AdmNotificacion> getLlstNotifXFuncXEstado(String pFnrId, Boolean pNtfrAtendida) {
        return em.createNamedQuery("AdmNotificacion.notXFrn").
                setParameter("frnId", pFnrId).
                setParameter("ntfrAtendida", pNtfrAtendida).
                getResultList();

    }

    public List<PtcPuntoscontrolxprocesoxfunc> getLstPtcPCtrlXFuncXNotif(String pFnrId, Long pNotId) {

        return em.createNamedQuery("PtcPuntoscontrolxprocesoxfunc.puntoCtrlXFuncXNot").
                setParameter("fnrId", pFnrId).
                setParameter("notId", pNotId).
                getResultList();
    }

    public List<PtcLogpuntocontrol> getLstLogPctrlXPunto(Long pPpcId) {
        return em.createNamedQuery("PtcLogpuntocontrol.logXPunto").
                setParameter("ppcId", pPpcId).
                getResultList();
    }

    public void grabarLogPuntoCtrl(PtcLogpuntocontrol pLpc) {
        pLpc = em.merge(pLpc);
    }

    public List<AdmProceso> getLstAdmProcesos() {
        return em.createNamedQuery("AdmProceso.findAll").getResultList();
    }

    public List<PtcDefpuntoscontrol> getLstDefPTC() {
        return em.createNamedQuery("PtcDefpuntoscontrol.findAll").getResultList();
    }

    public List<PtcDefpuntoscontrol> getLstDefPTCXTipo(Integer pTpcId) {
        return em.createNamedQuery("PtcDefpuntoscontrol.ptcDefXTipo").
                setParameter("tpcId", pTpcId).
                getResultList();
    }

    public List<PtcTipopuntocontrol> getLstTPC() {
        return em.createNamedQuery("PtcTipopuntocontrol.findAll").
                getResultList();
    }

    public void grabarNotif(AdmNotificacion pAn) {
        admNotifSel = em.merge(pAn);
    }

    public void grabarListaPctXFunc(List<PtcPuntoscontrolxprocesoxfunc> pLstPctXFunc) {
        for (PtcPuntoscontrolxprocesoxfunc pp : pLstPctXFunc) {
            AdmNotxfuncionario nxf = pp.getNtfrId();
            nxf = em.merge(nxf);
            pp.setNtfrId(nxf);
            pp = em.merge(pp);

        }
    }

    public void grabarPuntoCtrl(PtcDefpuntoscontrol pPp) {
        PtcTipopuntocontrol pt = em.getReference(PtcTipopuntocontrol.class, pPp.getTpcId().getTpcId());
        pPp.setTpcId(pt);
        pPp = em.merge(pPp);
    }

    /**
     * @return the admNotifSel
     */
    public AdmNotificacion getAdmNotifSel() {
        return admNotifSel;
    }

}
