/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veeduria.web.cargaarchivo;

import com.veeduria.sys.dao.SysArchivo;
import com.veeduria.web.base.TablaBaseFrm;
import java.util.Objects;

/**
 *
 * @author luz
 */
public class TablaSysArchivo extends TablaBaseFrm{

    private SysArchivo sysArchivo = new SysArchivo();

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.sysArchivo);
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
        final TablaSysArchivo other = (TablaSysArchivo) obj;
        if (!Objects.equals(this.sysArchivo, other.sysArchivo)) {
            return false;
        }
        return true;
    }

    public TablaSysArchivo() {
    }

    public TablaSysArchivo(SysArchivo pSysArchivo) {
        this.sysArchivo = pSysArchivo;
    }

    /**
     * @return the sysArchivo
     */
    public SysArchivo getSysArchivo() {
        return sysArchivo;
    }

    /**
     * @param sysArchivo the sysArchivo to set
     */
    public void setSysArchivo(SysArchivo sysArchivo) {
        this.sysArchivo = sysArchivo;
    }


}
