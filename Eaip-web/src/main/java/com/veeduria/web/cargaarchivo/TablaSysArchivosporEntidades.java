/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.veeduria.web.cargaarchivo;


import com.veeduria.sys.dao.SysArchivosporentidades;
import com.veeduria.web.base.TablaBaseFrm;
import java.util.Objects;

/**
 *
 * @author luz
 */
public class TablaSysArchivosporEntidades extends TablaBaseFrm{
    
    private SysArchivosporentidades thmArchivosporentidades = new SysArchivosporentidades();

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.thmArchivosporentidades);
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
        final TablaSysArchivosporEntidades other = (TablaSysArchivosporEntidades) obj;
        if (!Objects.equals(this.thmArchivosporentidades, other.thmArchivosporentidades)) {
            return false;
        }
        return true;
    }

    public TablaSysArchivosporEntidades() {
    }
    
    public TablaSysArchivosporEntidades(SysArchivosporentidades pThmArchivosporentidades){
        this.thmArchivosporentidades = pThmArchivosporentidades;
    
    }
    /**
     * @return the thmArchivosporentidades
     */
    public SysArchivosporentidades getThmArchivosporentidades() {
        return thmArchivosporentidades;
    }

    /**
     * @param thmArchivosporentidades the thmArchivosporentidades to set
     */
    public void setThmArchivosporentidades(SysArchivosporentidades thmArchivosporentidades) {
        this.thmArchivosporentidades = thmArchivosporentidades;
    }
    
}
