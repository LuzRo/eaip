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
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import org.postgresql.core.types.PGDouble;
import org.postgresql.ds.PGSimpleDataSource;

/**
 *
 * @author fercris
 */
@Stateless
@LocalBean
public class CargaPredisPlano extends BaseCargaMasiva implements ICargaArchivo<Object> {

    @Resource(name = "jdbcVeeduria")
    private DataSource jdbcVeeduria;

    @Override
    public void cargarArchivo() {

    }

    private String nombreArchivo;
    Path rutaArchivo;
    Path rutaCarpetaTrabajo;
    private Connection con;
    String encabezado;
    private List<String> lstFilasArchivo;
    StringBuilder strBSql = new StringBuilder();

    public void iniciarInsertStringIngresos() {
        strBSql.delete(0, strBSql.length());
        strBSql.append(" INSERT INTO pre_cmingreso(");
        strBSql.append("  cing_codcuenta, cing_nomcuenta, cing_pptoinicial, cing_modmes, ");
        strBSql.append("  cing_modacumulado, cing_pptodefinitivo, cing_recuadomes, cing_recuadoacum, ");
        strBSql.append("  cing_porejec, cing_saldorecaudar, cing_recurreser, cing_ingrfinal,lgreg_id) VALUES");
    }

    public void setRutaCarpetaTrabajo(Path rutaCarpetaTrabajo) {
        this.rutaCarpetaTrabajo = rutaCarpetaTrabajo;
    }

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
            AdmSectorestruc admSectorestruc = em.find(AdmSectorestruc.class, Integer.parseInt(arrStrDatosArchivo[2].replace(".zip", "")));

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

    public void leerPlanoPredisGastos(String pNombreArchivo, Path pRutaCarpetaTrabajo) throws IOException {
        this.nombreArchivo = pNombreArchivo;
        rutaCarpetaTrabajo = pRutaCarpetaTrabajo;

        try {
            PGSimpleDataSource pgsds = new PGSimpleDataSource();
            pgsds.setUser("veeduria");
            pgsds.setPassword("veeduria");
            pgsds.setServerName("localhost");
            pgsds.setDatabaseName("eaip");
            pgsds.setPortNumber(5432);

            con = pgsds.getConnection();
            Files.walkFileTree(rutaCarpetaTrabajo, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file,
                        BasicFileAttributes attrs) throws IOException {
//
                    procesarArchivoGastos(file);

                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult preVisitDirectory(Path dir,
                        BasicFileAttributes attrs) throws IOException {

                    return FileVisitResult.CONTINUE;
                }
            });

        } catch (SQLException ex) {
            Logger.getLogger(CargaPredisPlano.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(CargaPredisPlano.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        //Borrar carpeta de trabajo
        Files.walkFileTree(rutaCarpetaTrabajo, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file,
                    BasicFileAttributes attrs) throws IOException {
                Files.delete(file);

                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult preVisitDirectory(Path dir,
                    BasicFileAttributes attrs) throws IOException {

                return FileVisitResult.CONTINUE;
            }

        });
       

    }

    public void leerPlanoPredisIngresos(String pNombreArchivo, Path pRutaCarpetaTrabajo) throws IOException {
        this.nombreArchivo = pNombreArchivo;
        rutaCarpetaTrabajo = pRutaCarpetaTrabajo;

        try {
            PGSimpleDataSource pgsds = new PGSimpleDataSource();
            pgsds.setUser("veeduria");
            pgsds.setPassword("veeduria");
            pgsds.setServerName("localhost");
            pgsds.setDatabaseName("eaip");
            pgsds.setPortNumber(5432);

            con = pgsds.getConnection();
            Files.walkFileTree(rutaCarpetaTrabajo, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file,
                        BasicFileAttributes attrs) throws IOException {
//
                    procesarArchivoIngresos(file);

                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult preVisitDirectory(Path dir,
                        BasicFileAttributes attrs) throws IOException {

                    return FileVisitResult.CONTINUE;
                }
            });

        } catch (SQLException ex) {
            Logger.getLogger(CargaPredisPlano.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(CargaPredisPlano.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        //Borrar carpeta de trabajo
        Files.walkFileTree(rutaCarpetaTrabajo, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file,
                    BasicFileAttributes attrs) throws IOException {
                Files.delete(file);

                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult preVisitDirectory(Path dir,
                    BasicFileAttributes attrs) throws IOException {

                return FileVisitResult.CONTINUE;
            }

        });
        Files.delete(rutaCarpetaTrabajo);

    }

    public void procesarArchivoGastos(Path pArchivo) {

        try {
            lstFilasArchivo = Files.readAllLines(pArchivo, Charset.forName("ISO8859-1"));
            encabezado = lstFilasArchivo.get(0);

            if (!lstFilasArchivo.isEmpty()) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String[] arrStrDatosArchivo = nombreArchivo.split("_", -1);
                String[] arrStrEncabezado = encabezado.trim().split(" ", -1);
                LocalDate lgregPeriodo = LocalDate.of(Integer.parseInt(arrStrEncabezado[1].replace("=", "")), Integer.parseInt(arrStrEncabezado[5]), 1);
                Double strCodigoEntPredis = Double.parseDouble(arrStrEncabezado[8]);
                String entId = "";

                Statement smt = con.createStatement();

                ResultSet rs = smt.executeQuery("select nextval('sys_registrocarga_lgreg_id_seq')");
                Long lgregId = -1L;
                while (rs.next()) {
                    lgregId = rs.getLong(1);
                }

                rs = smt.executeQuery("SELECT ent_id FROM adm_entidad WHERE ent_cdpredis = " + arrStrEncabezado[8]);
                while (rs.next()) {
                    entId = rs.getString("ent_id");
                }

                if (lgregId != -1L) {

                    StringBuilder strBSqlSysRC = new StringBuilder();
                    strBSqlSysRC.append(" INSERT INTO sys_registrocarga(\n"
                            + "            lgreg_id,   lgreg_fechacarga, \n"
                            + "            frn_id, lgreg_estado, lgreg_mensajecarga, ent_id, lgreg_periodo, \n"
                            + "            ses_id,  lgreg_tipomensaje, lgreg_nomarchivocarga, \n"
                            + "            lgreg_idmsjcarga) VALUES ");

                    strBSqlSysRC.append("(");
                    strBSqlSysRC.append(lgregId);
                    strBSqlSysRC.append(",'");
                    strBSqlSysRC.append(sdf.format(new Date()));
                    strBSqlSysRC.append("','");
                    strBSqlSysRC.append("123456");
                    strBSqlSysRC.append("',");
                    strBSqlSysRC.append("true");
                    strBSqlSysRC.append(",'");
                    strBSqlSysRC.append("Carga automática");
                    strBSqlSysRC.append("','");
                    strBSqlSysRC.append(entId);
                    strBSqlSysRC.append("','");
                    strBSqlSysRC.append(sdf.format(Date.from(lgregPeriodo.atStartOfDay(ZoneId.systemDefault()).toInstant())));
                    strBSqlSysRC.append("',");
                    strBSqlSysRC.append(Integer.parseInt(arrStrDatosArchivo[2].replace(".zip", "")));
                    strBSqlSysRC.append(",'");
                    strBSqlSysRC.append("INFO");
                    strBSqlSysRC.append("','");
                    strBSqlSysRC.append(pArchivo.toString());
                    strBSqlSysRC.append("',");
                    strBSqlSysRC.append(1);
                    strBSqlSysRC.append(")");

                    smt.executeUpdate(strBSqlSysRC.toString());

                    strBSql.delete(0, strBSql.length());

                    strBSql.append(" INSERT INTO pre_cmgasto(");
                    strBSql.append(" cgas_codcuenta, cgas_nomcuenta, cgas_apropinicial, cgas_modificacion, ");
                    strBSql.append(" cgas_apropvigente, cgas_suspension, cgas_apropdisponible, cgas_compmes,  ");
                    strBSql.append(" cgas_compacumulados, cgas_porejecptal, cgas_autogiromes, cgas_autogiroacum, ");
                    strBSql.append(" cgas_porejecautogiro, lgreg_id) VALUES");
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
                            strBSql.append(lgregId);
                            strBSql.append("),");

                        }
                    }
                    // String strBSqlInsert = em.g
                    strBSql.delete(strBSql.length() - 1, strBSql.length());

                    smt.executeUpdate(strBSql.toString());
                }
            }
        } catch (SQLException | IOException ex) {
            Logger.getLogger(CargaPredisPlano.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void procesarArchivoIngresos(Path pArchivo) {

        try {
            lstFilasArchivo = Files.readAllLines(pArchivo, Charset.forName("ISO8859-1"));
            encabezado = lstFilasArchivo.get(0);

            if (!lstFilasArchivo.isEmpty()) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String[] arrStrDatosArchivo = nombreArchivo.split("_", -1);
                String[] arrStrEncabezado = encabezado.trim().split(" ", -1);
                LocalDate lgregPeriodo = LocalDate.of(Integer.parseInt(arrStrEncabezado[1].replace("=", "")), Integer.parseInt(arrStrEncabezado[5]), 1);
                Double strCodigoEntPredis = Double.parseDouble(arrStrEncabezado[8]);
                String entId = "";

                Statement smt = con.createStatement();

                ResultSet rs = smt.executeQuery("select nextval('sys_registrocarga_lgreg_id_seq')");
                Long lgregId = -1L;
                while (rs.next()) {
                    lgregId = rs.getLong(1);
                }

                rs = smt.executeQuery("SELECT ent_id FROM adm_entidad WHERE ent_cdpredis = " + arrStrEncabezado[8]);
                while (rs.next()) {
                    entId = rs.getString("ent_id");
                }

                if (lgregId != -1L) {

                    StringBuilder strBSqlSysRC = new StringBuilder();
                    strBSqlSysRC.append(" INSERT INTO sys_registrocarga(\n"
                            + "            lgreg_id,   lgreg_fechacarga, \n"
                            + "            frn_id, lgreg_estado, lgreg_mensajecarga, ent_id, lgreg_periodo, \n"
                            + "            ses_id,  lgreg_tipomensaje, lgreg_nomarchivocarga, \n"
                            + "            lgreg_idmsjcarga) VALUES ");

                    strBSqlSysRC.append("(");
                    strBSqlSysRC.append(lgregId);
                    strBSqlSysRC.append(",'");
                    strBSqlSysRC.append(sdf.format(new Date()));
                    strBSqlSysRC.append("','");
                    strBSqlSysRC.append("123456");
                    strBSqlSysRC.append("',");
                    strBSqlSysRC.append("true");
                    strBSqlSysRC.append(",'");
                    strBSqlSysRC.append("Carga automática");
                    strBSqlSysRC.append("','");
                    strBSqlSysRC.append(entId);
                    strBSqlSysRC.append("','");
                    strBSqlSysRC.append(sdf.format(Date.from(lgregPeriodo.atStartOfDay(ZoneId.systemDefault()).toInstant())));
                    strBSqlSysRC.append("',");
                    strBSqlSysRC.append(Integer.parseInt(arrStrDatosArchivo[2].replace(".zip", "")));
                    strBSqlSysRC.append(",'");
                    strBSqlSysRC.append("INFO");
                    strBSqlSysRC.append("','");
                    strBSqlSysRC.append(pArchivo.toString());
                    strBSqlSysRC.append("',");
                    strBSqlSysRC.append(1);
                    strBSqlSysRC.append(")");

                    smt.executeUpdate(strBSqlSysRC.toString());

                    strBSql.delete(0, strBSql.length());

                    strBSql.delete(0, strBSql.length());
                    strBSql.append(" INSERT INTO pre_cmingreso(");
                    strBSql.append("  cing_codcuenta, cing_nomcuenta, cing_pptoinicial, cing_modmes, ");
                    strBSql.append("  cing_modacumulado, cing_pptodefinitivo, cing_recuadomes, cing_recuadoacum, ");
                    strBSql.append("  cing_porejec, cing_saldorecaudar, cing_recurreser, cing_ingrfinal,lgreg_id) VALUES");
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
                            strBSql.append(lgregId);
                            strBSql.append("),");

                        }
                    }
                    // String strBSqlInsert = em.g
                    strBSql.delete(strBSql.length() - 1, strBSql.length());

                    smt.executeUpdate(strBSql.toString());
                }
            }
        } catch (SQLException | IOException ex) {
            Logger.getLogger(CargaPredisPlano.class.getName()).log(Level.SEVERE, null, ex);
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
