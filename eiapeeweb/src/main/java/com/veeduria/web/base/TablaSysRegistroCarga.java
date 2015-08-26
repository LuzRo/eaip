/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veeduria.web.base;

import com.veeduria.sys.dao.SysRegistrocarga;
import java.util.Objects;

/**
 *
 * @author luz
 */
public class TablaSysRegistroCarga extends TablaBaseFrm {

    private SysRegistrocarga sysRegistrocarga = new SysRegistrocarga();

    public TablaSysRegistroCarga() {
    }

    public TablaSysRegistroCarga(SysRegistrocarga pSysRegistrocarga) {
        this.sysRegistrocarga = pSysRegistrocarga;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.sysRegistrocarga);
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
        final TablaSysRegistroCarga other = (TablaSysRegistroCarga) obj;
        if (!Objects.equals(this.sysRegistrocarga, other.sysRegistrocarga)) {
            return false;
        }
        return true;
    }

    /**
     * @return the sysRegistrocarga
     */
    public SysRegistrocarga getSysRegistrocarga() {
        return sysRegistrocarga;
    }

    /**
     * @param sysRegistrocarga the sysRegistrocarga to set
     */
    public void setSysRegistrocarga(SysRegistrocarga sysRegistrocarga) {
        this.sysRegistrocarga = sysRegistrocarga;
    }
}
