/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veeduria.web.base;

import com.veeduria.adm.dao.AdmSectoradmin;
import java.util.Objects;

/**
 *
 * @author fernando
 */
public class TablaSectorAdm extends TablaBaseFrm{
    private AdmSectoradmin as = new AdmSectoradmin();

    public TablaSectorAdm() {
    }
    public TablaSectorAdm(AdmSectoradmin pAs) {
        this.as= pAs;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.as);
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
        final TablaSectorAdm other = (TablaSectorAdm) obj;
        return Objects.equals(this.as, other.as);
    }
    
    
    

    /**
     * @return the as
     */
    public AdmSectoradmin getAs() {
        return as;
    }

    /**
     * @param as the as to set
     */
    public void setAs(AdmSectoradmin as) {
        this.as = as;
    }
}
