/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veeduria.web.base;

import com.veeduria.cnt.dao.CntPlancuetagastos;
import java.util.Objects;

/**
 *
 * @author luz
 */
public class TablaPlanCG extends TablaBaseFrm{
    private CntPlancuetagastos cntPCG = new CntPlancuetagastos();

    public TablaPlanCG() {
    }

    public TablaPlanCG(CntPlancuetagastos cp) {
        this.cntPCG = cp;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.cntPCG);
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
        final TablaPlanCG other = (TablaPlanCG) obj;
        return Objects.equals(this.cntPCG, other.cntPCG);
    }
    
    /**
     * @return the cntPCG
     */
    public CntPlancuetagastos getCntPCG() {
        return cntPCG;
    }

    /**
     * @param cntPCG the cntPCG to set
     */
    public void setCntPCG(CntPlancuetagastos cntPCG) {
        this.cntPCG = cntPCG;
    }
}
