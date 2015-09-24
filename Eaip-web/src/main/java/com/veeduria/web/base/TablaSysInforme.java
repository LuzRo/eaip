/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veeduria.web.base;

import com.veeduria.sys.dao.SysInforme;
import java.util.Objects;

/**
 *
 * @author luz
 */
public class TablaSysInforme extends TablaBaseFrm {

    SysInforme sysInforme = new SysInforme();

    public TablaSysInforme() {
    }

    public SysInforme getSysInforme() {
        return sysInforme;
    }

    public void setSysInforme(SysInforme sysInforme) {
        this.sysInforme = sysInforme;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.sysInforme);
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
        final TablaSysInforme other = (TablaSysInforme) obj;
        if (!Objects.equals(this.sysInforme, other.sysInforme)) {
            return false;
        }
        return true;
    }
}
