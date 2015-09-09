/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veeduria.web.not;

import com.veeduria.not.ejb.AdmPuntosCtrlSFBEan;
import com.veeduria.web.base.BaseJSFBean;
import com.veeduria.web.base.TablaSysFunc;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.event.ActionEvent;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author fernando
 */
public class BaseNotificacion extends BaseJSFBean {

    protected List<TablaNotif> lstTablaNotifs = new ArrayList<>();
    protected TablaNotif tablaNotifSel = new TablaNotif();

    protected AdmPuntosCtrlSFBEan lookupAdmPuntosCtrlSFBEan() {
        try {
            Context c = new InitialContext();      
            return (AdmPuntosCtrlSFBEan) c.lookup("java:global/EIAPEE-ear/eiapeeweb-3/AdmPuntosCtrlSFBEan!com.veeduria.not.ejb.AdmPuntosCtrlSFBEan");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    protected AdmPuntosCtrlSFBEan apcsfbe;

    protected List<TablaSysFunc> lstTablaSysFunc = new ArrayList<>();
    protected TablaSysFunc tablaSysFuncSel = new TablaSysFunc();

    @Override
    public void init() {
     
    }
    
    

    @Override
    public void limpiarVariables() {

    }

    @Override
    public void navegacionLateral_ActionEvent(ActionEvent ae) {

    }

    @Override
    public boolean validarFormulario() {
        return true;
    }

    /**
     * @return the lstTablaSysFunc
     */
    public List<TablaSysFunc> getLstTablaSysFunc() {
        return lstTablaSysFunc;
    }

    /**
     * @param lstTablaSysFunc the lstTablaSysFunc to set
     */
    public void setLstTablaSysFunc(List<TablaSysFunc> lstTablaSysFunc) {
        this.lstTablaSysFunc = lstTablaSysFunc;
    }

    /**
     * @return the tablaSysFuncSel
     */
    public TablaSysFunc getTablaSysFuncSel() {
        return tablaSysFuncSel;
    }

    /**
     * @param tablaSysFuncSel the tablaSysFuncSel to set
     */
    public void setTablaSysFuncSel(TablaSysFunc tablaSysFuncSel) {
        this.tablaSysFuncSel = tablaSysFuncSel;
    }

    /**
     * @return the lstTablaNotifs
     */
    public List<TablaNotif> getLstTablaNotifs() {
        return lstTablaNotifs;
    }

    /**
     * @param lstTablaNotifs the lstTablaNotifs to set
     */
    public void setLstTablaNotifs(List<TablaNotif> lstTablaNotifs) {
        this.lstTablaNotifs = lstTablaNotifs;
    }

    /**
     * @return the tablaNotifSel
     */
    public TablaNotif getTablaNotifSel() {
        return tablaNotifSel;
    }

    /**
     * @param tablaNotifSel the tablaNotifSel to set
     */
    public void setTablaNotifSel(TablaNotif tablaNotifSel) {
        this.tablaNotifSel = tablaNotifSel;
    }
}
