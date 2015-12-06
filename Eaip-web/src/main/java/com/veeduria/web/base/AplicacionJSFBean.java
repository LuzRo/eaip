/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veeduria.web.base;

import com.veeduria.adm.AdmsistemaSLBean;
import com.veeduria.adm.dao.AdmEntidad;
import com.veeduria.sys.ejb.VigilarCarpetaSLBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;

/**
 *
 * @author luz
 */
@Named
@ApplicationScoped
public class AplicacionJSFBean implements Serializable {

    @EJB
    AdmsistemaSLBean aslb;
    @EJB
    VigilarCarpetaSLBean vigilarCarpetaSLBean;

    private String a;

    private List<SelectItem> lstItemsEntidad = new ArrayList<>();
    private List<SelectItem> lstItemsPeriodo = new ArrayList<>();

    private void cargarEntidad() {

        lstItemsEntidad.clear();
        lstItemsEntidad.add(new SelectItem("-1", "Seleccione"));
        for (AdmEntidad ae : aslb.getLstEntidads()) {
            lstItemsEntidad.add(new SelectItem(ae.getEntId(), ae.getEntNombre()));
        }

    }

    /**
     *
     */
    @PostConstruct
    public void init() {

        cargarEntidad();
       vigilarCarpetaSLBean.vigilarCarpeta();
       

    }

    /**
     * @return the lstItemsEntidad
     */
    public List<SelectItem> getLstItemsEntidad() {
        return lstItemsEntidad;
    }

    /**
     * @param lstItemsEntidad the lstItemsEntidad to set
     */
    public void setLstItemsEntidad(List<SelectItem> lstItemsEntidad) {
        this.lstItemsEntidad = lstItemsEntidad;
    }

    /**
     * @return the lstItemsPeriodo
     */
    public List<SelectItem> getLstItemsPeriodo() {
        return lstItemsPeriodo;
    }

    /**
     * @param lstItemsPeriodo the lstItemsPeriodo to set
     */
    public void setLstItemsPeriodo(List<SelectItem> lstItemsPeriodo) {
        this.lstItemsPeriodo = lstItemsPeriodo;
    }

    /**
     * @return the a
     */
    public String getA() {
        return a;
    }

    /**
     * @param a the a to set
     */
    public void setA(String a) {
        this.a = a;
    }

    /**
     * @return the lstItemsSecEstructura
     */
    /**
     * @param lstItemsSecEstructura the lstItemsSecEstructura to set
     */
}
