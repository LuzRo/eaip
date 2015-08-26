/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veeduria.dosfases.jsf;

import com.veeduria.adm.dao.AdmLoginconsistencias;
import com.veeduria.web.base.TablaBaseFrm;
import java.util.Objects;

/**
 *
 * @author fernando
 */
public class TablaLogIncons extends TablaBaseFrm {
    private AdmLoginconsistencias al = new AdmLoginconsistencias();

    public TablaLogIncons() {
    }
    
     public TablaLogIncons(AdmLoginconsistencias pAl) {
         this.al = pAl;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.al);
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
        final TablaLogIncons other = (TablaLogIncons) obj;
        if (!Objects.equals(this.al, other.al)) {
            return false;
        }
        return true;
    }
     
     

    /**
     * @return the al
     */
    public AdmLoginconsistencias getAl() {
        return al;
    }

    /**
     * @param al the al to set
     */
    public void setAl(AdmLoginconsistencias al) {
        this.al = al;
    }
}
