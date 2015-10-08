/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veeduria.web.base;

import com.veeduria.adm.AdmsistemaSLBean;
import com.veeduria.adm.dao.AdmEntidad;
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
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    public void vigilarCarpeta() {
        try {
            Properties properties = new Properties();

            properties.load(AplicacionJSFBean.class.getResourceAsStream("/configuracion/ConfiguracionGeneral.properties"));
            String rutaCargaMasiva = properties.getProperty("carpetaVigilada");
            String rutaEaip = rutaCargaMasiva.split(",")[0];
            Path pathRutaEaip = Paths.get(System.getProperty("user.home"), rutaEaip);
            if (!Files.exists(pathRutaEaip)) {
                Files.createDirectory(pathRutaEaip);
            }
            if (System.getProperty("os.name").toUpperCase().contains("WINDOWS")) {
                rutaCargaMasiva = rutaCargaMasiva.replace(",", "\\");
            } else {
                rutaCargaMasiva = rutaCargaMasiva.replace(",", "/");
            }

            Path rutaCarpetaVigilada = Paths.get(System.getProperty("user.home"), rutaCargaMasiva);
            if (!Files.exists(rutaCarpetaVigilada)) {
                Files.createDirectory(rutaCarpetaVigilada);
            }
            WatchService watcher = rutaCarpetaVigilada.getFileSystem().newWatchService();
            rutaCarpetaVigilada.register(watcher, StandardWatchEventKinds.ENTRY_CREATE);

            WatchKey watckKey = watcher.take();

            List<WatchEvent< ?>> events = watckKey.pollEvents();
            for (WatchEvent event : events) {
                System.out.println("Someone just created the file '" + event.context().toString() + "'.");

            }

        } catch (InterruptedException | IOException ex) {
            Logger.getLogger(AplicacionJSFBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @PostConstruct
    public void init() {

        cargarEntidad();
        vigilarCarpeta();

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
