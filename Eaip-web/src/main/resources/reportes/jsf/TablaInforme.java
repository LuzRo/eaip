/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veeduria.reportes.jsf;

import com.veeduria.sys.dao.SysInforme;
import com.veeduria.web.base.TablaBaseFrm;
import java.util.Objects;

/**
 *
 * @author luz
 */
public class TablaInforme extends TablaBaseFrm {

    private SysInforme sysInforme = new SysInforme();

    public TablaInforme() {
    }

    public TablaInforme(SysInforme pSysInforme) {
        this.sysInforme = pSysInforme;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.sysInforme);
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
        final TablaInforme other = (TablaInforme) obj;
        return Objects.equals(this.sysInforme, other.sysInforme);
    }

    public SysInforme getSysInforme() {
        return sysInforme;
    }

    public void setSysInforme(SysInforme sysInforme) {
        this.sysInforme = sysInforme;
    }

}
