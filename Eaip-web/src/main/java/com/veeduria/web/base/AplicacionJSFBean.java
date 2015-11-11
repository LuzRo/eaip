/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veeduria.web.base;

import com.veeduria.adm.AdmsistemaSLBean;
import com.veeduria.adm.dao.AdmEntidad;
import com.veeduria.sys.ejb.VigilarCarpetaSLBean;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;

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
