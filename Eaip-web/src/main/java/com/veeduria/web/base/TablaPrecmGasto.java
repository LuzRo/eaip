/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veeduria.web.base;

import com.veeduria.pre.dao.PreCmgasto;
import java.util.Objects;

/**
 *
 * @author con1ead
 */
public class TablaPrecmGasto extends TablaBaseFrm {
    private PreCmgasto as = new PreCmgasto();

    public TablaPrecmGasto() {
    }
   
    public TablaPrecmGasto(PreCmgasto pCg){
        this.as=pCg;
    }
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.as);
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
        final TablaPrecmGasto other = (TablaPrecmGasto) obj;
        if (!Objects.equals(this.as, other.as)) {
            return false;
        }
        return true;
    }

    public PreCmgasto getAs() {
        return as;
    }

    public void setAs(PreCmgasto as) {
        this.as = as;
    }
    
    
    
}
