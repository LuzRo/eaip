/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veeduria.dosfases.jsf;

import com.veeduria.cnt.dao.CntPlancuetagastos;
import com.veeduria.pre.dao.PreCmgastoinconsistencia;
import com.veeduria.sys.dao.SysRegistrocarga;
import com.veeduria.sys.ejb.CargadosfasesSFBean;
import com.veeduria.web.base.BaseJSFBean;
import com.veeduria.web.base.TablaPlanCG;
import com.veeduria.web.base.TablaSysRegistroCarga;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Named;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.joda.time.DateTime;
import org.joda.time.DateTimeFieldType;

/**
 *
 * @author fernando
 */

public abstract class ProcCargadosFasesBase extends BaseJSFBean implements Serializable {

    //<editor-fold defaultstate="collapsed" desc="Inconsistencias gastos">
  

    //<editor-fold defaultstate="collapsed" desc="Variables">
    protected CargadosfasesSFBean cdfsfb = null;

   
//</editor-fold>



    protected CargadosfasesSFBean lookupCargadosfasesSFBeanBean() {
        try {
            Context c = new InitialContext();
            return (CargadosfasesSFBean) c.lookup("java:global/Eaip-web/CargadosfasesSFBean!com.veeduria.sys.ejb.CargadosfasesSFBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

  


    /**
     * @return the strDetalleIncons
     */
    public String getStrDetalleIncons() {
        return strDetalleIncons;
    }

    /**
     * @param strDetalleIncons the strDetalleIncons to set
     */
    public void setStrDetalleIncons(String strDetalleIncons) {
        this.strDetalleIncons = strDetalleIncons;
    }

  
    public CargadosfasesSFBean getCdfsfb() {
        return cdfsfb;
    }

  
}
//</editor-fold>
