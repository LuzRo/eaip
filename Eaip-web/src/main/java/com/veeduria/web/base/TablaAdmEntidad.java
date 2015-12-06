/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veeduria.web.base;

import com.veeduria.adm.dao.AdmEntidad;
import java.util.Objects;

/**
 *
 * @author luz
 */
public class TablaAdmEntidad extends TablaBaseFrm {

    private AdmEntidad as = new AdmEntidad();

    public TablaAdmEntidad() {
    }

    public TablaAdmEntidad(AdmEntidad pAe) {
        this.as = pAe;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.as);
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
        final TablaAdmEntidad other = (TablaAdmEntidad) obj;
        return Objects.equals(this.as, other.as);
    }

    public AdmEntidad getAs() {
        return as;
    }

    public void setAs(AdmEntidad as) {
        this.as = as;
    }

}
