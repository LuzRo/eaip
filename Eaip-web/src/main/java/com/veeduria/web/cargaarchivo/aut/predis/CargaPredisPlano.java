/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veeduria.web.cargaarchivo.aut.predis;

import com.veeduria.adm.dao.AdmEntidad;
import com.veeduria.adm.dao.AdmSectorestruc;
import com.veeduria.sys.dao.SysArchivosporentidades;
import com.veeduria.sys.dao.SysFuncionario;
import com.veeduria.sys.dao.SysRegistrocarga;
import com.veeduria.web.cargaarchivo.BaseCargaMasiva;
import com.veeduria.web.cargaarchivo.ICargaArchivo;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author fercris
 */
@Stateless
@LocalBean
public class CargaPredisPlano extends BaseCargaMasiva implements ICargaArchivo<Object> {

    @Override
    public void cargarArchivo() {

    }

    private String nombreArchivo;
    Path rutaArchivo;
    Path rutaCarpetaTrabajo;

    public void setRutaCarpetaTrabajo(Path rutaCarpetaTrabajo) {
        this.rutaCarpetaTrabajo = rutaCarpetaTrabajo;
    }
    String encabezado;
    private List<String> lstFilasArchivo;
    StringBuilder strBSql = new StringBuilder();

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    private boolean crearSysRegistroCarga(Path pArchivo) {
        try {
            lstFilasArchivo = Files.readAllLines(pArchivo, Charset.forName("ISO8859-1"));
            encabezado = lstFilasArchivo.get(0);
            sysRegistrocarga = new SysRegistrocarga();
            sysRegistrocarga.setLgregEstado(Boolean.TRUE);
            SysArchivosporentidades ta;
            String[] arrStrDatosArchivo = nombreArchivo.split("_", -1);
            String[] arrStrEncabezado = encabezado.trim().split(" ", -1);
            LocalDate lgregPeriodo = LocalDate.of(Integer.parseInt(arrStrEncabezado[1].replace("=", "")), Integer.parseInt(arrStrEncabezado[5]), 1);
            Double strCodigoEntPredis = Double.parseDouble(arrStrEncabezado[8]);
            AdmEntidad admEntidad = getAdmEntidadXCodPredis(strCodigoEntPredis);
            if (admEntidad == null) {
                return false;
            }
            AdmSectorestruc admSectorestruc = em.find(AdmSectorestruc.class, Integer.parseInt(arrStrDatosArchivo[3].replace(".zip", "")));

            if (admSectorestruc == null) {
                return false;
            }

            sysRegistrocarga.setLgregRutaarchivo(pArchivo.toString());
            sysRegistrocarga.setLgregNomarchivocarga(nombreArchivo);
            sysRegistrocarga.setFrnId(em.getReference(SysFuncionario.class, "123456"));
            sysRegistrocarga.setLgregFechacarga(new Date());
            sysRegistrocarga.setLgregPeriodo(Date.from(lgregPeriodo.atStartOfDay(ZoneId.systemDefault()).toInstant()));
            sysRegistrocarga.setEntId(admEntidad);
            sysRegistrocarga.setSesId(admSectorestruc);
            sysRegistrocarga.setLgregIdmsjcarga(1);
            sysRegistrocarga.setLgregTipomensaje("INFO");
            sysRegistrocarga = em.merge(sysRegistrocarga);
            em.flush();
            return sysRegistrocarga.getLgregId() != null;
        } catch (IOException ex) {
            Logger.getLogger(CargaPredisPlano.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    private void cargarZipPlanosPredis() {

    }

    public void leerPlanoPredis(Path pRutaArchivo) throws IOException {

        Files.walkFileTree(rutaCarpetaTrabajo, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file,
                    BasicFileAttributes attrs) throws IOException {
//                  
                procesarArchivo(file);
                

                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult preVisitDirectory(Path dir,
                    BasicFileAttributes attrs) throws IOException {

                return FileVisitResult.CONTINUE;
            }
        });

        System.getProperty("user.home");
        this.rutaArchivo = pRutaArchivo;
//        lstFilasArchivo = Files.readAllLines(pRutaArchivo, Charset.forName("ISO8859-1"));

    }

    public void procesarArchivo(Path pArchivo) {

        if (crearSysRegistroCarga(pArchivo)) {

            for (String dato : lstFilasArchivo) {
                if (lstFilasArchivo.indexOf(dato) != 0) {
                    strBSql.append("('");
                    strBSql.append(dato.substring(0, 88).trim());
                    strBSql.append("','");
                    strBSql.append(dato.substring(88, 338).trim());
                    strBSql.append("',");
                    strBSql.append(dato.substring(338, 370).trim().replace(",", ""));
                    strBSql.append(",");
                    strBSql.append(dato.substring(370, 402).trim().replace(",", ""));
                    strBSql.append(",");
                    strBSql.append(dato.substring(402, 434).trim().replace(",", ""));
                    strBSql.append(",");
                    strBSql.append(dato.substring(434, 466).trim().replace(",", ""));
                    strBSql.append(",");
                    strBSql.append(dato.substring(466, 498).trim().replace(",", ""));
                    strBSql.append(",");
                    strBSql.append(dato.substring(498, 530).trim().replace(",", ""));
                    strBSql.append(",");
                    strBSql.append(dato.substring(530, 562).trim().replace(",", ""));
                    strBSql.append(",");
                    strBSql.append(dato.substring(562, 574).trim().replace(",", ""));
                    strBSql.append(",");
                    strBSql.append(dato.substring(574, 606).trim().replace(",", ""));
                    strBSql.append(",");
                    strBSql.append(dato.substring(606, 638).trim().replace(",", ""));
                    strBSql.append(",");
                    strBSql.append(dato.substring(638, 650).trim().replace(",", ""));
                    strBSql.append(",");
                    strBSql.append(sysRegistrocarga.getLgregId());
                    strBSql.append("),");
                    strBSql.append(System.lineSeparator());
                }
            }
           // String strBSqlInsert = em.g
            int i = 0;
        }

    }

    /**
     * @return the nombreArchivo
     */
    public String getNombreArchivo() {
        return nombreArchivo;
    }

    /**
     * @param nombreArchivo the nombreArchivo to set
     */
    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

}
