/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veeduria.web.not;

import com.veeduria.not.dao.AdmNotificacion;
import com.veeduria.not.dao.AdmNotxfuncionario;
import com.veeduria.not.dao.PtcDefpuntoscontrol;
import com.veeduria.not.dao.PtcPuntoscontrolxprocesoxfunc;
import com.veeduria.not.dao.PtcTipopuntocontrol;
import com.veeduria.not.ejb.AdmPuntosCtrlSFBEan;
import com.veeduria.sys.ejb.CargadosfasesSFBean;
import com.veeduria.web.base.BaseJSFBean;
import com.veeduria.web.base.TablaAdmProc;
import com.veeduria.web.base.TablaSysFunc;
import com.veeduria.web.not.BaseNotificacion;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author fernando
 */
@SessionScoped
@Named
@NotificacionQLF
public class NotificacionJSFBean extends BaseNotificacion implements Serializable {

    private Integer tipoPtcSel;
    private Integer tipoPtcGrabarSel;
    private List<SelectItem> lstItemsTipoPtc = new ArrayList<>();
    private boolean estadoPctGrabar;

    private List<TablaPtcDef> lstTablaPtcDef = new ArrayList<>();
    private TablaPtcDef tablaPtcDefSel = new TablaPtcDef();

    private List<TablaAdmProc> lstTablaAdmProc = new ArrayList<>();
    private TablaAdmProc tablaAdmProcSel = new TablaAdmProc();
    private boolean selTodoProc;
    private boolean selTodoFnr;

    //<editor-fold defaultstate="collapsed" desc="Funciones de carga">
    private void cargarTipoPtc() {
        lstItemsTipoPtc.clear();
        lstItemsTipoPtc.add(itemSeleccioneInt);
        lstItemsTipoPtc.addAll(apcsfbe.getLstTPC().stream().
                map(e -> new SelectItem(e.getTpcId(), e.getTcpNombre())).
                collect(Collectors.toList()));

    }

    private void cargarPtcDefXTipo() {
        if (tipoPtcSel.equals(-1)) {
            lstTablaPtcDef = apcsfbe.getLstDefPTC().stream().map(e -> new TablaPtcDef(e)).collect(Collectors.toList());
        } else {
            lstTablaPtcDef = apcsfbe.getLstDefPTCXTipo(tipoPtcSel).stream().map(e -> new TablaPtcDef(e)).collect(Collectors.toList());
        }
    }

    private void cargarTablaFunc() {
        lstTablaSysFunc = apcsfbe.getLstFunc().stream().map(e -> new TablaSysFunc(e)).collect(Collectors.toList());
    }

    private void cargarProcs() {
        lstTablaAdmProc = apcsfbe.getLstAdmProc().stream().map(e -> new TablaAdmProc(e)).collect(Collectors.toList());
    }

//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Funciones de grabacion">
    public void grabarPuntoControl_AE(ActionEvent ae) {
        PtcDefpuntoscontrol pd = tablaPtcDefSel.getPd();
        pd.setTpcId(new PtcTipopuntocontrol(tipoPtcGrabarSel));
        pd.setDefEstado(estadoPctGrabar);
        apcsfbe.grabarPuntoCtrl(pd);
        tablaPtcDefSel = new TablaPtcDef();
        cargarPtcDefXTipo();
    }

    private void grabarNotificacion() {
        tablaNotifSel.getAn().setNotFcreacion(new Date());
        tablaNotifSel.getAn().setProId(tablaAdmProcSel.getAp());
        apcsfbe.grabarNotif(tablaNotifSel.getAn());

        apcsfbe.grabarListaPctXFunc(lstTablaSysFunc.stream().
                filter((tsf) -> (tsf.isSeleccionado())).
                map((tsf) -> {
                    AdmNotxfuncionario an = new AdmNotxfuncionario();
                    PtcPuntoscontrolxprocesoxfunc pp = new PtcPuntoscontrolxprocesoxfunc();
                    an.setFrnId(tsf.getSf());
                    an.setNotId(apcsfbe.getAdmNotifSel());
                    an.setNtfrEstado(Boolean.TRUE);
                    an.setNtfrAtendida(Boolean.FALSE);
                    pp.setDefId(tablaPtcDefSel.getPd());
                    pp.setProId(tablaAdmProcSel.getAp());
                    pp.setPpcEst(Boolean.TRUE);
                    pp.setNtfrId(an);
                    return pp;
                }).collect(Collectors.toList()));

        selTodoLst(lstTablaSysFunc, false);
        tablaNotifSel = new TablaNotif();

    }
//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Eventos">

    public void ddlTipoPtcGrabar_VCE(ValueChangeEvent vce) {
        tipoPtcGrabarSel = (Integer) vce.getNewValue();
    }

    public void rowDtProc_AE(ActionEvent ae) {
        tablaAdmProcSel = (TablaAdmProc) ae.getComponent().getAttributes().get("tablaAdmProcSel");
        resaltarFilaTabla(lstTablaAdmProc, tablaAdmProcSel);
    }

    public void selTodoProc_VCE(ValueChangeEvent vce) {
        selTodoProc = (boolean) vce.getNewValue();
        selTodoLst(lstTablaAdmProc, selTodoProc);
    }

    public void selTodoFnr_VCE(ValueChangeEvent vce) {
        selTodoFnr = (boolean) vce.getNewValue();
        selTodoLst(lstTablaSysFunc, selTodoFnr);
    }

    public void grabarNotificacion_AE(ActionEvent ae) {
        grabarNotificacion();
    }

    public void ddlTipoPtc_VCE(ValueChangeEvent vce) {
        tipoPtcSel = (Integer) vce.getNewValue();
        cargarPtcDefXTipo();
    }

    public void rowDtPtcdef_AE(ActionEvent ae) {
        tablaPtcDefSel = (TablaPtcDef) ae.getComponent().getAttributes().get("tablaPtcDefSel");
        estadoPctGrabar = tablaPtcDefSel.getPd().getDefEstado();
        tipoPtcGrabarSel = tablaPtcDefSel.getPd().getTpcId().getTpcId();
         tipoPtcSel = tablaPtcDefSel.getPd().getTpcId().getTpcId();
        tablaPtcDefSel.getPd().getTpcId().setTpcId(tipoPtcSel);
        resaltarFilaTabla(lstTablaPtcDef, tablaPtcDefSel);
    }
//</editor-fold>

    @Override
    public void init() {
        apcsfbe = lookupAdmPuntosCtrlSFBEan();
        cargarTipoPtc();
        tipoPtcSel = -1;
        cargarPtcDefXTipo();
        cargarTablaFunc();
        cargarProcs();
        setSelTodoProc(false);
    }

    @Override
    public void limpiarVariables() {
        apcsfbe.remove();
    }

    @Override
    public void navegacionLateral_ActionEvent(ActionEvent ae) {
        numPanel = Integer.parseInt(String.valueOf(ae.getComponent().getAttributes().get("numPanel")));
        switch (numPanel) {
            case 1:

                break;
        }
    }

    @Override
    public boolean validarFormulario() {
        return true;
    }

    //<editor-fold defaultstate="collapsed" desc="Propiedades">
    /**
     * @return the lstTablaPtcDef
     */
    public List<TablaPtcDef> getLstTablaPtcDef() {
        return lstTablaPtcDef;
    }

    /**
     * @param lstTablaPtcDef the lstTablaPtcDef to set
     */
    public void setLstTablaPtcDef(List<TablaPtcDef> lstTablaPtcDef) {
        this.lstTablaPtcDef = lstTablaPtcDef;
    }

    /**
     * @return the tipoPtcSel
     */
    public Integer getTipoPtcSel() {
        return tipoPtcSel;
    }

    /**
     * @param tipoPtcSel the tipoPtcSel to set
     */
    public void setTipoPtcSel(Integer tipoPtcSel) {
        this.tipoPtcSel = tipoPtcSel;
    }

    /**
     * @return the lstItemsTipoPtc
     */
    public List<SelectItem> getLstItemsTipoPtc() {
        return lstItemsTipoPtc;
    }

    /**
     * @param lstItemsTipoPtc the lstItemsTipoPtc to set
     */
    public void setLstItemsTipoPtc(List<SelectItem> lstItemsTipoPtc) {
        this.lstItemsTipoPtc = lstItemsTipoPtc;
    }

    /**
     * @return the tablaPtcDefSel
     */
    public TablaPtcDef getTablaPtcDefSel() {
        return tablaPtcDefSel;
    }

    /**
     * @param tablaPtcDefSel the tablaPtcDefSel to set
     */
    public void setTablaPtcDefSel(TablaPtcDef tablaPtcDefSel) {
        this.tablaPtcDefSel = tablaPtcDefSel;
    }

    /**
     * @return the lstTablaAdmProc
     */
    public List<TablaAdmProc> getLstTablaAdmProc() {
        return lstTablaAdmProc;
    }

    /**
     * @param lstTablaAdmProc the lstTablaAdmProc to set
     */
    public void setLstTablaAdmProc(List<TablaAdmProc> lstTablaAdmProc) {
        this.lstTablaAdmProc = lstTablaAdmProc;
    }

    /**
     * @return the tablaAdmProcSel
     */
    public TablaAdmProc getTablaAdmProcSel() {
        return tablaAdmProcSel;
    }

    /**
     * @param tablaAdmProcSel the tablaAdmProcSel to set
     */
    public void setTablaAdmProcSel(TablaAdmProc tablaAdmProcSel) {
        this.tablaAdmProcSel = tablaAdmProcSel;
    }

    /**
     * @return the selTodoProc
     */
    public boolean isSelTodoProc() {
        return selTodoProc;
    }

    /**
     * @param selTodoProc the selTodoProc to set
     */
    public void setSelTodoProc(boolean selTodoProc) {
        this.selTodoProc = selTodoProc;
    }

    /**
     * @return the selTodoFnr
     */
    public boolean isSelTodoFnr() {
        return selTodoFnr;
    }

    /**
     * @param selTodoFnr the selTodoFnr to set
     */
    public void setSelTodoFnr(boolean selTodoFnr) {
        this.selTodoFnr = selTodoFnr;
    }

//</editor-fold>
    /**
     * @return the tipoPtcGrabarSel
     */
    public Integer getTipoPtcGrabarSel() {
        return tipoPtcGrabarSel;
    }

    /**
     * @param tipoPtcGrabarSel the tipoPtcGrabarSel to set
     */
    public void setTipoPtcGrabarSel(Integer tipoPtcGrabarSel) {
        this.tipoPtcGrabarSel = tipoPtcGrabarSel;
    }

    /**
     * @return the estadoPctGrabar
     */
    public boolean isEstadoPctGrabar() {
        return estadoPctGrabar;
    }

    /**
     * @param estadoPctGrabar the estadoPctGrabar to set
     */
    public void setEstadoPctGrabar(boolean estadoPctGrabar) {
        this.estadoPctGrabar = estadoPctGrabar;
    }
}
