/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veeduria.web.pctrl;

import com.veeduria.not.dao.PtcPuntoscontrolxprocesoxfunc;
import com.veeduria.web.base.TablaBaseFrm;
import java.util.Objects;

/**
 *
 * @author luz
 */
public class TablaPuntoCtrlXFunc extends TablaBaseFrm{

    private PtcPuntoscontrolxprocesoxfunc pp = new PtcPuntoscontrolxprocesoxfunc();

    public TablaPuntoCtrlXFunc() {
    }

    public TablaPuntoCtrlXFunc(PtcPuntoscontrolxprocesoxfunc pPp) {
        this.pp = pPp;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.pp);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TablaPuntoCtrlXFunc other = (TablaPuntoCtrlXFunc) obj;
        return Objects.equals(this.pp, other.pp);
    }

    
    /**
     * @return the pp
     */
    public PtcPuntoscontrolxprocesoxfunc getPp() {
        return pp;
    }

    /**
     * @param pp the pp to set
     */
    public void setPp(PtcPuntoscontrolxprocesoxfunc pp) {
        this.pp = pp;
    }
}
