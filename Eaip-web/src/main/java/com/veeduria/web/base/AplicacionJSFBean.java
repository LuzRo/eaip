/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veeduria.web.base;

import com.veeduria.adm.AdmsistemaSLBean;
import com.veeduria.adm.dao.AdmEntidad;
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
//        try {
//            Properties properties = new Properties();
//
//            properties.load(AplicacionJSFBean.class.getResourceAsStream("/configuracion/ConfiguracionGeneral.properties"));
//            String rutaCargaMasiva = properties.getProperty("carpetaVigilada");
//            String rutaEaip = rutaCargaMasiva.split(",")[0];
//            Path pathRutaEaip = Paths.get(System.getProperty("user.home"), rutaEaip);
//            if (!Files.exists(pathRutaEaip)) {
//                Files.createDirectory(pathRutaEaip);
//            }
//            if (System.getProperty("os.name").toUpperCase().contains("WINDOWS")) {
//                rutaCargaMasiva = rutaCargaMasiva.replace(",", "\\");
//            } else {
//                rutaCargaMasiva = rutaCargaMasiva.replace(",", "/");
//            }
//
//            Path rutaCarpetaVigilada = Paths.get(System.getProperty("user.home"), rutaCargaMasiva);
//            if (!Files.exists(rutaCarpetaVigilada)) {
//                Files.createDirectory(rutaCarpetaVigilada);
//            }
//            WatchService watcher = rutaCarpetaVigilada.getFileSystem().newWatchService();
//            rutaCarpetaVigilada.register(watcher, StandardWatchEventKinds.ENTRY_CREATE);
//
//            WatchKey watckKey = watcher.take();
//
//            List<WatchEvent< ?>> events = watckKey.pollEvents();
//            for (WatchEvent event : events) {
//                System.out.println("Someone just created the file '" + event.context().toString() + "'.");
//                try {
//                    HSSFWorkbook workbook = new HSSFWorkbook(Files.newInputStream(Paths.get(rutaCarpetaVigilada.toString(),
//                            event.context().toString())));
//
//                    //Get first sheet from the workbook
//                    HSSFSheet sheet = workbook.getSheetAt(0);
//
//                    //Iterate through each rows from first sheet
//                    Iterator<org.apache.poi.ss.usermodel.Row> rowIterator = sheet.iterator();
//                    while (rowIterator.hasNext()) {
//                        Row row = (Row) rowIterator.next();
//
//                        //For each row, iterate through each columns
//                        Iterator<Cell> cellIterator = row.cellIterator();
//                        while (cellIterator.hasNext()) {
//
//                            Cell cell = cellIterator.next();
//
//                            switch (cell.getCellType()) {
//                                case Cell.CELL_TYPE_BOOLEAN:
//                                    System.out.print(cell.getBooleanCellValue() + "\t\t");
//                                    break;
//                                case Cell.CELL_TYPE_NUMERIC:
//                                    System.out.print(cell.getNumericCellValue() + "\t\t");
//                                    break;
//                                case Cell.CELL_TYPE_STRING:
//                                    System.out.print(cell.getStringCellValue() + "\t\t");
//                                    break;
//                            }
//                        }
//                        System.out.println("");
//                    }
//
//                    FileOutputStream out
//                            = new FileOutputStream(new File(System.getProperty("user.home")+ File.separator + "test.xls"));
//                    workbook.write(out);
//                    out.close();
//
//                } catch (FileNotFoundException e) {
//                    e.printStackTrace();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//
//            }
//
//        } catch (InterruptedException | IOException ex) {
//            Logger.getLogger(AplicacionJSFBean.class.getName()).log(Level.SEVERE, null, ex);
//        }
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
