/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.veeduria.dosfases.jsf;

import com.veeduria.pre.dao.PreCmgastoinconsistencia;
import com.veeduria.web.base.TablaBaseFrm;
import com.veeduria.web.base.TablaPlanCG;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author luz
 */
public class TablaPrecmgastoinconsistencia extends TablaBaseFrm{
    
    private PreCmgastoinconsistencia precmgastoinconsistencia = new PreCmgastoinconsistencia();

    private List<TablaPlanCG> lstTpcg = new ArrayList<>();
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.precmgastoinconsistencia);
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
        final TablaPrecmgastoinconsistencia other = (TablaPrecmgastoinconsistencia) obj;
        return Objects.equals(this.precmgastoinconsistencia, other.precmgastoinconsistencia);
    }
    
    public TablaPrecmgastoinconsistencia(){
    }
    
    public TablaPrecmgastoinconsistencia(PreCmgastoinconsistencia pPreCmgastoinconsistencia){
        this.precmgastoinconsistencia = pPreCmgastoinconsistencia;
      }

    public PreCmgastoinconsistencia getPrecmgastoinconsistencia() {
        return precmgastoinconsistencia;
    }

    public void setPrecmgastoinconsistencia(PreCmgastoinconsistencia precmgastoinconsistencia) {
        this.precmgastoinconsistencia = precmgastoinconsistencia;
    }

    /**
     * @return the lstTpcg
     */
    public List<TablaPlanCG> getLstTpcg() {
        return lstTpcg;
    }

    /**
     * @param lstTpcg the lstTpcg to set
     */
    public void setLstTpcg(List<TablaPlanCG> lstTpcg) {
        this.lstTpcg = lstTpcg;
    }
    
    
}
