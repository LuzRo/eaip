/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veeduria.web.not;

import com.veeduria.not.dao.AdmNotificacion;
import com.veeduria.web.base.TablaBaseFrm;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author luz
 */
public class TablaNotif extends TablaBaseFrm {

    private AdmNotificacion an = new AdmNotificacion();
    private Date fechaCorteNot;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.an);
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
        final TablaNotif other = (TablaNotif) obj;
        return Objects.equals(this.an, other.an);
    }

    public TablaNotif() {
    }

    public TablaNotif(AdmNotificacion pAn) {
        this.an = pAn;
    }

    public AdmNotificacion getAn() {
        return an;
    }

    public void setAn(AdmNotificacion an) {
        this.an = an;
    }

    /**
     * @return the fechaCorteNot
     */
    public Date getFechaCorteNot() {
        return fechaCorteNot;
    }

    /**
     * @param fechaCorteNot the fechaCorteNot to set
     */
    public void setFechaCorteNot(Date fechaCorteNot) {
        this.fechaCorteNot = fechaCorteNot;
    }

}
