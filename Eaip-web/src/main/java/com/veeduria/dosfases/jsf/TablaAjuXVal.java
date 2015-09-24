/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veeduria.dosfases.jsf;

import com.veeduria.adm.dao.AdmAjustexvalidacion;
import com.veeduria.web.base.TablaBaseFrm;
import java.util.Objects;

/**
 *
 * @author fernando
 */
public class TablaAjuXVal extends TablaBaseFrm{
    
    private AdmAjustexvalidacion ajxval = new AdmAjustexvalidacion();

    public TablaAjuXVal() {
    }
    
      public TablaAjuXVal(AdmAjustexvalidacion aa) {
          this.ajxval = aa;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.ajxval);
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
        final TablaAjuXVal other = (TablaAjuXVal) obj;
        return Objects.equals(this.ajxval, other.ajxval);
    }

    /**
     * @return the ajxval
     */
    public AdmAjustexvalidacion getAjxval() {
        return ajxval;
    }

    /**
     * @param ajxval the ajxval to set
     */
    public void setAjxval(AdmAjustexvalidacion ajxval) {
        this.ajxval = ajxval;
    }
      
      
    
}
