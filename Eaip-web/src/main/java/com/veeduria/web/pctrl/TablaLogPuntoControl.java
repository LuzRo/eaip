/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veeduria.web.pctrl;

import com.veeduria.not.dao.PtcLogpuntocontrol;
import com.veeduria.web.base.TablaBaseFrm;
import java.util.Objects;

/**
 *
 * @author fernando
 */
public class TablaLogPuntoControl extends TablaBaseFrm {

    private PtcLogpuntocontrol pl = new PtcLogpuntocontrol();

    public TablaLogPuntoControl() {
    }

    public TablaLogPuntoControl(PtcLogpuntocontrol pPl) {
        this.pl = pPl;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.pl);
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
        final TablaLogPuntoControl other = (TablaLogPuntoControl) obj;
        return Objects.equals(this.pl, other.pl);
    }

    /**
     * @return the pl
     */
    public PtcLogpuntocontrol getPl() {
        return pl;
    }

    /**
     * @param pl the pl to set
     */
    public void setPl(PtcLogpuntocontrol pl) {
        this.pl = pl;
    }

}
