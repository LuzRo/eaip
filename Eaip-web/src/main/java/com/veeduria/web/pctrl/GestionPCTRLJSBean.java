/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veeduria.web.pctrl;

import com.veeduria.not.dao.PtcLogpuntocontrol;
import com.veeduria.web.not.BaseNotificacion;
import com.veeduria.web.not.GestPctrlQLF;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

/**
 *
 * @author luz
 */
@SessionScoped
@Named
@GestPctrlQLF
public class GestionPCTRLJSBean extends BaseNotificacion implements Serializable {

    private List<TablaPuntoCtrlXFunc> lstTablaPctrlXFunc = new ArrayList<>();
    private TablaPuntoCtrlXFunc tablaPuntoCtrlXFuncSel = new TablaPuntoCtrlXFunc();
    private List<TablaLogPuntoControl> lstTablaLogPctrl = new ArrayList<>();
    private TablaLogPuntoControl tablaLogPctrlSel = new TablaLogPuntoControl();
    

    public void rowDtPtctrlXFunc_AE(ActionEvent ae) {
        tablaPuntoCtrlXFuncSel = (TablaPuntoCtrlXFunc) ae.getComponent().getAttributes().get("tablaPuntoCtrlXFuncSel");
        resaltarFilaTabla(lstTablaPctrlXFunc, tablaPuntoCtrlXFuncSel);
        cargarLogPctrlXPtc();

    }

    public void grabarLogPctrl_AE(ActionEvent ae) {
        grabarLogPtc();
        cargarLogPctrlXPtc();
    }
    
    private void cargarLogPctrlXPtc(){
        
     
        
      lstTablaLogPctrl = apcsfbe.getLstLogPctrlXPunto(tablaPuntoCtrlXFuncSel.getPp().getPpcId()).stream().
              map(e -> new TablaLogPuntoControl(e)).
              collect(Collectors.toList());
    }

    private void grabarLogPtc() {
        PtcLogpuntocontrol pl = tablaLogPctrlSel.getPl();
        pl.setSegFechacreacion(new Date());
        pl.setSegEst(Boolean.TRUE);
        pl.setPpcId(tablaPuntoCtrlXFuncSel.getPp());
        apcsfbe.grabarLogPuntoCtrl(tablaLogPctrlSel.getPl());
        tablaLogPctrlSel = new TablaLogPuntoControl();
    }

    @Override
    public void init() {
        apcsfbe = lookupAdmPuntosCtrlSFBEan();
        tablaNotifSel = getAdministracionJSFBean().getTablaNotifSel();
        lstTablaPctrlXFunc = apcsfbe.getLstPtcPCtrlXFuncXNotif(getAdministracionJSFBean().getSegusrSFBean().getFrnlogeado().getFrnId(),
                tablaNotifSel.getAn().getNotId()).stream().map(e -> new TablaPuntoCtrlXFunc(e)).collect(Collectors.toList());
    }

    @Override
    public void limpiarVariables() {
        apcsfbe.remove();
    }

    @Override
    public void navegacionLateral_ActionEvent(ActionEvent ae) {

    }

    @Override
    public boolean validarFormulario() {
        return true;
    }

    /**
     * @return the lstTablaPctrlXFunc
     */
    public List<TablaPuntoCtrlXFunc> getLstTablaPctrlXFunc() {
        return lstTablaPctrlXFunc;
    }

    /**
     * @param lstTablaPctrlXFunc the lstTablaPctrlXFunc to set
     */
    public void setLstTablaPctrlXFunc(List<TablaPuntoCtrlXFunc> lstTablaPctrlXFunc) {
        this.lstTablaPctrlXFunc = lstTablaPctrlXFunc;
    }

    /**
     * @return the tablaPuntoCtrlXFuncSel
     */
    public TablaPuntoCtrlXFunc getTablaPuntoCtrlXFuncSel() {
        return tablaPuntoCtrlXFuncSel;
    }

    /**
     * @param tablaPuntoCtrlXFuncSel the tablaPuntoCtrlXFuncSel to set
     */
    public void setTablaPuntoCtrlXFuncSel(TablaPuntoCtrlXFunc tablaPuntoCtrlXFuncSel) {
        this.tablaPuntoCtrlXFuncSel = tablaPuntoCtrlXFuncSel;
    }

    /**
     * @return the lstTablaLogPctrl
     */
    public List<TablaLogPuntoControl> getLstTablaLogPctrl() {
        return lstTablaLogPctrl;
    }

    /**
     * @param lstTablaLogPctrl the lstTablaLogPctrl to set
     */
    public void setLstTablaLogPctrl(List<TablaLogPuntoControl> lstTablaLogPctrl) {
        this.lstTablaLogPctrl = lstTablaLogPctrl;
    }

    /**
     * @return the tablaLogPctrlSel
     */
    public TablaLogPuntoControl getTablaLogPctrlSel() {
        return tablaLogPctrlSel;
    }

    /**
     * @param tablaLogPctrlSel the tablaLogPctrlSel to set
     */
    public void setTablaLogPctrlSel(TablaLogPuntoControl tablaLogPctrlSel) {
        this.tablaLogPctrlSel = tablaLogPctrlSel;
    }

}
