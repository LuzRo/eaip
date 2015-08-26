/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veeduria.web.base;

/**
 *
 * @author fernando
 * @param <T>
 */
public interface ITablaBaseFrm<T> {

    

    public boolean isSeleccionado();

    public void setSeleccionado(boolean seleccionado);

    public String getClaseSel();

    public void setClaseSel(String claseSel);

    public String getClaseError();

    public void setClaseError(String claseError);

    public boolean isBlnEditar();

    public void setBlnEditar(boolean blnEditar);

    public boolean isBlnNuevo();

    public void setBlnNuevo(boolean blnNuevo);

    public String getStrEstado();

    public void setStrEstado(String strEstado);

    public String getClaseEst();

    public void setClaseEst(String claseEst);

    public String getEstiloFila();

    public void setEstiloFila(String estiloFila);
}
