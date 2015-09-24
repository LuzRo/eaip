/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veeduria.web.base;

import java.io.Serializable;

/**
 *
 * @author luz
 */
public abstract class TablaBaseFrm implements ITablaBaseFrm, Serializable{


    protected boolean seleccionado = false;
    protected String claseSel = "";
    protected String claseError = "";    
    protected boolean blnEditar = false;
    protected boolean blnNuevo = false;
    protected String strEstado = "";
    protected String claseEst = "";
    protected String estiloFila="";

    /**
     * @return the seleccionado
     */
    @Override
    public boolean isSeleccionado() {
        return seleccionado;
    }

    /**
     * @param seleccionado the seleccionado to set
     */
    @Override
    public void setSeleccionado(boolean seleccionado) {
        this.seleccionado = seleccionado;
    }

    /**
     * @return the claseSel
     */
    @Override
    public String getClaseSel() {
        return claseSel;
    }

    /**
     * @param claseSel the claseSel to set
     */
    @Override
    public void setClaseSel(String claseSel) {
        this.claseSel = claseSel;
    }

    /**
     * @return the claseError
     */
    @Override
    public String getClaseError() {
        return claseError;
    }

    /**
     * @param claseError the claseError to set
     */
    @Override
    public void setClaseError(String claseError) {
        this.claseError = claseError;
    }


    /**
     * @return the blnEditar
     */
    @Override
    public boolean isBlnEditar() {
        return blnEditar;
    }

    /**
     * @param blnEditar the blnEditar to set
     */
    @Override
    public void setBlnEditar(boolean blnEditar) {
        this.blnEditar = blnEditar;
    }

    /**
     * @return the blnNuevo
     */
    @Override
    public boolean isBlnNuevo() {
        return blnNuevo;
    }

    /**
     * @param blnNuevo the blnNuevo to set
     */
    @Override
    public void setBlnNuevo(boolean blnNuevo) {
        this.blnNuevo = blnNuevo;
    }

    /**
     * @return the strEstado
     */
    @Override
    public String getStrEstado() {
        return strEstado;
    }

    /**
     * @param strEstado the strEstado to set
     */
    @Override
    public void setStrEstado(String strEstado) {
        this.strEstado = strEstado;
    }

    /**
     * @return the claseEst
     */
    @Override
    public String getClaseEst() {
        return claseEst;
    }

    /**
     * @param claseEst the claseEst to set
     */
    @Override
    public void setClaseEst(String claseEst) {
        this.claseEst = claseEst;
    }

    /**
     * @return the estiloFila
     */
    @Override
    public String getEstiloFila() {
        return estiloFila;
    }

    /**
     * @param estiloFila the estiloFila to set
     */
    @Override
    public void setEstiloFila(String estiloFila) {
        this.estiloFila = estiloFila;
    }

  
}
