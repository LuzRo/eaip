/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veeduria.web.base;

import com.veeduria.adm.dao.AdmProceso;
import java.util.Objects;

/**
 *
 * @author fernando
 */
public class TablaAdmProc extends TablaBaseFrm {

    private AdmProceso ap = new AdmProceso();

    public TablaAdmProc() {
    }

    public TablaAdmProc(AdmProceso pAp) {
        this.ap = pAp;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.ap);
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
        final TablaAdmProc other = (TablaAdmProc) obj;
        return Objects.equals(this.ap, other.ap);
    }

    /**
     * @return the ap
     */
    public AdmProceso getAp() {
        return ap;
    }

    /**
     * @param ap the ap to set
     */
    public void setAp(AdmProceso ap) {
        this.ap = ap;
    }

}
