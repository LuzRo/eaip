/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veeduria.sys.ejb;

import com.veeduria.web.base.AplicacionJSFBean;
import com.veeduria.web.cargaarchivo.aut.predis.CargaPredisPlano;
import com.veeduria.web.cargaarchivo.aut.th.CargaPlanta;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author luz
 */
@Stateless
@LocalBean
public class VigilarCarpetaSLBean {

    @PersistenceContext
    EntityManager em;

    @EJB
    CargaPredisPlano cargaPredisPlano;

    @PostConstruct
    public void init() {

    }

    CargaPlanta cargaPlanta = new CargaPlanta();

    private void carpetaVigilada() {
        for (;;) {

            try {
                Properties properties = new Properties();

                properties.load(AplicacionJSFBean.class.getResourceAsStream("/configuracion/ConfiguracionGeneral.properties"));
                String rutaCargaMasiva = properties.getProperty("carpetaVigilada");
                String rutaCarpetaTrabajo = properties.getProperty("carpetaTrabajoPredis");
                String rutaEaip = rutaCargaMasiva.split(",")[0];
                Path pathRutaEaip = Paths.get(System.getProperty("user.home"), rutaEaip);
                if (!Files.exists(pathRutaEaip)) {
                    Files.createDirectory(pathRutaEaip);
                }
                if (System.getProperty("os.name").toUpperCase().contains("WINDOWS")) {
                    rutaCargaMasiva = rutaCargaMasiva.replace(",", "\\");
                    rutaCarpetaTrabajo = rutaCarpetaTrabajo.replace(",", "\\");
                } else {
                    rutaCargaMasiva = rutaCargaMasiva.replace(",", "/");
                    rutaCarpetaTrabajo = rutaCarpetaTrabajo.replace(",", "/");
                }

                Path rutaCarpetaVigilada = Paths.get(System.getProperty("user.home"), rutaCargaMasiva);
                if (!Files.exists(rutaCarpetaVigilada)) {
                    Files.createDirectory(rutaCarpetaVigilada);
                }
                Path pathRutaCarpetaTrabajo = Paths.get(System.getProperty("user.home"), rutaCarpetaTrabajo);
                if (!Files.exists(pathRutaCarpetaTrabajo)) {
                    Files.createDirectory(pathRutaCarpetaTrabajo);
                }

                WatchService watcher = rutaCarpetaVigilada.getFileSystem().newWatchService();
                rutaCarpetaVigilada.register(watcher, StandardWatchEventKinds.ENTRY_CREATE);

                WatchKey watckKey = watcher.take();

                List<WatchEvent< ?>> events = watckKey.pollEvents();
                for (WatchEvent<?> event : events) {
                    System.out.println("Archivo creado '" + event.context().toString() + "'.");
                    System.out.println("Ruta completa: " + rutaCarpetaVigilada.toString() + "/" + event.context().toString());
                    String[] arrStrNombreArchivo = event.context().toString().split("_", -1);
                    if (event.context().toString().endsWith(".xls")) {

                        cargaPlanta.cargarArchivoEmpleados(Paths.get(rutaCarpetaVigilada.toString(), event.context().toString()));
                    }
                    if (event.context().toString().endsWith(".zip")) {

                        if (arrStrNombreArchivo.length == 3) {
                           
                            Path rutaZip = Paths.get(rutaCarpetaVigilada.toString(), event.context().toString());
                          
                            cargaPredisPlano.unzip(rutaZip.toString(), pathRutaCarpetaTrabajo.toString());
                            

                            switch (arrStrNombreArchivo[1]) {
                                case "gastos":
                                    cargaPredisPlano.leerPlanoPredisGastos(event.context().toString(),pathRutaCarpetaTrabajo);
                                    break;
                                case "ingresos":
                                    cargaPredisPlano.leerPlanoPredisIngresos(event.context().toString(),pathRutaCarpetaTrabajo);
                                    break;
                            }
                        }

//                       cargaPredisPlano.procesarArchivoGastos();
                    }

                }

            } catch (InterruptedException | IOException ex) {
                Logger.getLogger(AplicacionJSFBean.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    @Asynchronous
    public Future<String> vigilarCarpeta() {
        String estado = "";
        carpetaVigilada();
        return new AsyncResult<>(estado);
    }
}
