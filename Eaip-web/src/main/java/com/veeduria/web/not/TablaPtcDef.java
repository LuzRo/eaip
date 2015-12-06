/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veeduria.web.not;

import com.veeduria.not.dao.PtcDefpuntoscontrol;
import com.veeduria.web.base.TablaBaseFrm;
import java.util.Objects;

/**
 *
 * @author luz
 */
public class TablaPtcDef extends TablaBaseFrm {

    private PtcDefpuntoscontrol pd = new PtcDefpuntoscontrol();

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.pd);
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
        final TablaPtcDef other = (TablaPtcDef) obj;
        if (!Objects.equals(this.pd, other.pd)) {
            return false;
        }
        return true;
    }

    public TablaPtcDef() {
    }

    public TablaPtcDef(PtcDefpuntoscontrol pPd) {
        this.pd = pPd;
    }

    /**
     * @return the pd
     */
    public PtcDefpuntoscontrol getPd() {
        return pd;
    }

    /**
     * @param pd the pd to set
     */
    public void setPd(PtcDefpuntoscontrol pd) {
        this.pd = pd;
    }
}
