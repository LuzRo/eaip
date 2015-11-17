/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veeduria.web.cargaarchivo;

import com.veeduria.adm.AdmsistemaSLBean;
import com.veeduria.adm.dao.AdmEntidad;
import com.veeduria.adm.dao.AdmSectorestruc;
import com.veeduria.adm.dao.AdmUnidadejec;
import com.veeduria.dosfases.jsf.ProcCargadosFasesBase;
import com.veeduria.sys.dao.SysRegistrocarga;
import com.veeduria.sys.dao.SysArchivosporentidades;
import com.veeduria.web.base.BaseJSFBean;
import com.veeduria.web.cargaarchivo.jsf.CMPrepJSFBean;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang3.text.translate.UnicodeEscaper;

/**
 *
 * @author luz
 */
public class BaseCargaArchivo extends BaseJSFBean {

    //<editor-fold defaultstate="collapsed" desc="Variables">
    protected String mensaje;
    protected Integer filasArchCont;
    protected Integer intArchivoXCpcIdSel;
//    protected Integer intArchivoThSel;
//    private List<TablaSysArchivo> lstTablaSysArchivos = new ArrayList<>();
    private List<TablaSysArchivosporEntidades> lstTablaThmArchivosporEntidades = new ArrayList<>();
    private TablaSysArchivo tablaTablaSysArchivoSel = new TablaSysArchivo();
//    private TablaSysArchivosporEntidades tablaTablaThmArchivosporEntidadesSel = new TablaSysArchivosporEntidades();
    private String msjArea;
    protected String strEntIdSel;
    protected String strUnidadEjecSel;
    protected Integer intSectorEsSel;
    private Integer intSectorAdSel;
    protected Date lgregPeriodo;
    @EJB
    protected AdmsistemaSLBean aslb;
    protected AdmEntidad ent_id;
    protected AdmSectorestruc ses_id;
    protected AdmUnidadejec eje_codigo;
    protected SysRegistrocarga sr = new SysRegistrocarga();
    private List<AdmEntidad> lstEntidad = new ArrayList<>();
    UnicodeEscaper escaper = UnicodeEscaper.above(127);
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Funciones de carga">
    public boolean cargarArchivoProceso(File comp) throws InterruptedException {
        sr = new SysRegistrocarga();
        try {
            HttpSession hs = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            String carpetaSession = System.getProperty("user.home") + File.separator + "archivoscarga" + File.separator + hs.getId();
            File fileCarchivoSession = new File(carpetaSession);

            if (!fileCarchivoSession.exists()) {
                fileCarchivoSession.mkdir();
            }
            File retirarEspacios = new File(comp.getParent() + File.separator + comp.getName().replace(" ", ""));
            comp.renameTo(retirarEspacios);
            File archivoSalida = new File(carpetaSession + File.separator + retirarEspacios.getName());
            mensaje = null;
            Connection con = jdbcVeeduria.getConnection();

            try {

                Process pr = Runtime.getRuntime().exec("file -bi " + retirarEspacios.getAbsolutePath());
                pr.waitFor();
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(pr.getInputStream())
                );
                String codificacion = null;
                String line;
                while ((line = reader.readLine()) != null) {
                    codificacion = line;
                }
                if (codificacion != null) {
                    String[] cod = codificacion.split("=");
                    if (cod.length == 2) {
                        transofrmarCodif(retirarEspacios, cod[1], archivoSalida, "utf8");

                    }
                }
                if (aslb.getNomcargaDuplicados(archivoSalida.getName(), 1) > 0L) {

                    mensaje = "Este archivo ya ha sido cargado";
                    return false;
                } else {

                    sr.setLgregEstado(Boolean.TRUE);
                    SysArchivosporentidades ta;

                    sr.setLgregRutaarchivo(archivoSalida.getAbsolutePath());
                    sr.setLgregNomarchivocarga(archivoSalida.getName());
                    sr.setFrnId(getAdministracionJSFBean().getSysfuncionario());
                    sr.setLgregFechacarga(new Date());
                    sr.setLgregPeriodo(lgregPeriodo);
                    sr.setEntId(ent_id);
                    sr.setSesId(new AdmSectorestruc(intSectorEsSel));
                    sr.setLgregIdmsjcarga(1);
                    sr.setLgregTipomensaje("INFO");

                    ta = aslb.getArchivosporentidades(strEntIdSel, getAdministracionJSFBean().getTablaSysArchivoSel().getSysArchivo().getArcId());
                    switch (getAdministracionJSFBean().getNavegacion()) {
                        case "cargarArchivosPLA":
                            ta = aslb.getArchivosporentidades(strEntIdSel, intArchivoXCpcIdSel);
                            sr.setLgregNomarchivo(ta.getApeNomtabla());
                            sr.setSesId(new AdmSectorestruc(4));
                            sr.setEjeCodigo(new AdmUnidadejec("03"));
                            sr = aslb.grabarRegistrocarga(sr);
                            break;
                        case "cargarArchivosTH":
                            ta = aslb.getArchivosporentidades(strEntIdSel, intArchivoXCpcIdSel);
                            sr.setLgregNomarchivo(ta.getApeNomtabla());
                            sr.setEjeCodigo(new AdmUnidadejec("03"));
                            sr = aslb.grabarRegistrocarga(sr);
                            break;
                        case "cargarArchivoPre":
                            ta = aslb.getArchivosporentidades(strEntIdSel, getAdministracionJSFBean().getTablaSysArchivoSel().getSysArchivo().getArcId());
                            sr.setLgregNomarchivo(ta.getApeNomtabla());
                            sr.setEjeCodigo(new AdmUnidadejec(strUnidadEjecSel));
                            sr = aslb.grabarRegistrocarga(sr);
                            break;
                        case "cargarArchivoCont":
                            ta = aslb.getArchivosporentidades(strEntIdSel, getAdministracionJSFBean().getTablaSysArchivoSel().getSysArchivo().getArcId());
                            sr.setLgregNomarchivo(ta.getApeNomtabla());
                            sr.setEjeCodigo(new AdmUnidadejec("03"));
                            sr = aslb.grabarRegistrocarga(sr);
                            break;
                         case "cargarArchivosContr":
                            ta = aslb.getArchivosporentidades(strEntIdSel, getAdministracionJSFBean().getTablaSysArchivoSel().getSysArchivo().getArcId());
                            sr.setLgregNomarchivo(ta.getApeNomtabla());
                            sr.setEjeCodigo(new AdmUnidadejec("03"));
                            sr = aslb.grabarRegistrocarga(sr);
                            break;

                    }

                    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(archivoSalida), "utf8"));
                    StringBuilder responseData = new StringBuilder();
                    List<String> lstFilasArchivo = new ArrayList<>();
                   Files.lines(FileSystems.getDefault().getPath(archivoSalida.getCanonicalPath()),
                           StandardCharsets.UTF_8).
                           forEach(e -> lstFilasArchivo.add(e.replace("'", "")));
//                    while ((line = br.readLine()) != null) {
//                        lstFilasArchivo.add(line.replace("'", ""));
//                    }
//                    RandomAccessFile accessFile = new RandomAccessFile(archivoSalida, "r");
//                    FileChannel fileChannel = accessFile.getChannel();
//                    ByteBuffer poblBuffer = ByteBuffer.allocate(new Long(archivoSalida.length()).intValue());
//                    long bytesLeidos = fileChannel.read(poblBuffer);

                    StringBuilder strBNombreCuenta = new StringBuilder();

                    List<String[]> lstArrayParaInsertar = new ArrayList<>();
//                    Logger.getLogger(getClass().getName()).log(Level.INFO, null, "Tamaño archivo: " + bytesLeidos);
//                    poblBuffer.rewind();
                    StringBuilder strB = new StringBuilder();

//                    while (poblBuffer.hasRemaining()) {
//                        strB.append((char) poblBuffer.get());
//                        //No cargar los espacios en blanco
//                        if (strB.charAt(strB.length() - 1) == '\'') {
//                            strB.deleteCharAt(strB.length() - 1);
//                        }
//                    }
                    String[] arrStrFilasArch = new String[lstFilasArchivo.size()];

                    for (int i = 0; i < lstFilasArchivo.size(); i++) {
                        arrStrFilasArch[i] = lstFilasArchivo.get(i);
                    }

                    filasArchCont = arrStrFilasArch.length;

                    Integer colArchivoEsperada = ta.getApeColumnas();

                    String[] caracteresSepara = {"|", ";", "\t", "\n"};
                    String caracterSepara = "";
                    boolean aplicaCaracterSepara = false;
                    for (String strSepara : caracteresSepara) {

                        Pattern p = Pattern.compile(Pattern.quote(strSepara));
                        for (String strFila : arrStrFilasArch) {

                            if (p.split(strFila, -1).length >= colArchivoEsperada - 1) {
                                caracterSepara = strSepara;
                                aplicaCaracterSepara = true;
                                break;
                            }

                        }
                        if (aplicaCaracterSepara) {
                            break;
                        }

                    }
                    if (aplicaCaracterSepara) {

                        Pattern p = Pattern.compile(Pattern.quote(caracterSepara));
                        filasArchCont = arrStrFilasArch.length;

                        boolean error = false;
                        int filaError = 0;
                        int cols = 0;
                        arrStrMatrizArch = new Object[filasArchCont][colArchivoEsperada];
                        //<editor-fold defaultstate="collapsed" desc="Validar para talento humano salto de linea en celdas">
                        if (ta.getArcId().getArcId().equals(7) || ta.getArcId().getArcId().equals(14)) {
                            List<String> lstStrDatos = new ArrayList<>();
                            for (int i = 0; i < filasArchCont; i++) {

                                cols = p.split(arrStrFilasArch[i], -1).length;

                                if (cols > 0 && cols < colArchivoEsperada) {

                                    if (!lstStrDatos.isEmpty()) {
                                        List<String> lstDatosDerecha = Arrays.asList(p.split(arrStrFilasArch[i], -1));

                                        lstStrDatos.set(lstStrDatos.size() - 1, lstStrDatos.get(lstStrDatos.size() - 1) + lstDatosDerecha.get(0));

                                        lstStrDatos.addAll(lstDatosDerecha.subList(1, lstDatosDerecha.size()));
                                    } else {
                                        lstStrDatos.addAll(Arrays.asList(p.split(arrStrFilasArch[i], -1)));
                                    }

                                    if (lstStrDatos.size() == colArchivoEsperada) {

                                        System.arraycopy(lstStrDatos.toArray(), 0, arrStrMatrizArch[i], 0, colArchivoEsperada);
                                        lstStrDatos.clear();

                                    }

//           
                                } else if (cols == colArchivoEsperada) {
                                    String[] arrStrCols = p.split(arrStrFilasArch[i], -1);
                                    System.arraycopy(arrStrCols, 0, arrStrMatrizArch[i], 0, colArchivoEsperada);
                                } else if (cols > colArchivoEsperada) {
                                    error = true;
                                    filaError = i;
                                    mensaje = "Cantidad de columnas no esperadas se esperaban :" + colArchivoEsperada;
                                    sr.setLgregTipomensaje("SEVERE");
                                    sr.setLgregMensajecarga(mensaje);
                                    sr.setLgregNomarchivocarga(archivoSalida.getName());
                                    sr.setLgregIdmsjcarga(3);
                                    sr = aslb.grabarRegistrocarga(sr);
                                    break;
                                }

                            }

                            if (error) {
                                return false;
                            } else {

                                List<Object[]> lstArrFilas = new ArrayList<>();

                                for (int i = 0; i < filasArchCont; i++) {
                                    int cantNulls = 0;
                                    for (int j = 0; j < colArchivoEsperada; j++) {
                                        String str = (String) arrStrMatrizArch[i][j];
                                        if (str == null) {
                                            cantNulls++;
                                        } else if (str.equals("null")) {
                                            cantNulls++;
                                        }

                                    }
                                    if (cantNulls == 0) {
                                        lstArrFilas.add(arrStrMatrizArch[i]);
                                    }
                                }

                                Object[][] arrStrMatrizReducida = new Object[lstArrFilas.size()][colArchivoEsperada];

                                for (int i = 0; i < lstArrFilas.size(); i++) {
                                    System.arraycopy(lstArrFilas.get(i), 0, arrStrMatrizReducida[i], 0, colArchivoEsperada);
                                }

                                StringBuilder strBSqlCmdCargaArchivo = new StringBuilder(ta.getApeInsert());
                                strBSqlCmdCargaArchivo.append(" VALUES ");
                                try {
                                    for (int i = 0; i < lstArrFilas.size(); i++) {
                                        strBSqlCmdCargaArchivo.append("('");
                                        for (int j = 0; j < colArchivoEsperada; j++) {
                                            String strDato = String.valueOf(arrStrMatrizReducida[i][j]).trim();
                                            if (strDato.contains(".") || strDato.contains(",")) {
                                                strDato = escaper.translate(strDato);
                                                if (esNumero(strDato.replace(",", "").replace(".", "").replace("$", "").replace("%", ""))) {
                                                    if (strDato.replace("%", "").replace("$", "").lastIndexOf(".") == strDato.replace("%", "").replace("$", "").length() - 3
                                                            || strDato.lastIndexOf(".") == strDato.replace("%", "").replace("$", "").length() - 2) {
                                                        strDato = strDato.replace(",", "").replace("%", "").replace("$", "");
                                                    }
                                                    if (strDato.replace("%", "").replace("$", "").lastIndexOf(",") == strDato.replace("%", "").replace("$", "").length() - 3
                                                            || strDato.replace("%", "").replace("$", "").lastIndexOf(",") == strDato.replace("%", "").replace("$", "").length() - 2) {
                                                        strDato = strDato.replace(".", "");
                                                        strDato = strDato.replace(",", ".").replace("%", "").replace("$", "");
                                                    }
                                                    strBSqlCmdCargaArchivo.append(strDato);
                                                } else {

                                                    strBSqlCmdCargaArchivo.append(arrStrMatrizReducida[i][j]);
                                                }
                                            } else {
                                                strBSqlCmdCargaArchivo.append(arrStrMatrizReducida[i][j]);

                                            }

                                            strBSqlCmdCargaArchivo.append("','");
                                        }

                                        strBSqlCmdCargaArchivo.append(sr.getLgregId());
                                        strBSqlCmdCargaArchivo.append("','");
                                        strBSqlCmdCargaArchivo.replace(strBSqlCmdCargaArchivo.length() - 2, strBSqlCmdCargaArchivo.length(), "),");
                                    }
                                    strBSqlCmdCargaArchivo.replace(strBSqlCmdCargaArchivo.length() - 1, strBSqlCmdCargaArchivo.length(), "");
                                    mensaje = "Archivo cargado exitosamente";
                                    sr.setLgregTipomensaje("INFO");
                                    sr.setLgregMensajecarga(mensaje);
                                    sr.setLgregNomarchivocarga(archivoSalida.getName());
                                    sr.setLgregIdmsjcarga(1);
                                    sr = aslb.grabarRegistrocarga(sr);
                                } catch (IndexOutOfBoundsException ioobe) {
                                    mensaje = "Cantidad de columnas no esperadas se esperaban :" + colArchivoEsperada;
                                    sr.setLgregTipomensaje("SEVERE");
                                    sr.setLgregMensajecarga(mensaje);
                                    sr.setLgregNomarchivocarga(archivoSalida.getName());
                                    sr.setLgregIdmsjcarga(3);
                                    sr = aslb.grabarRegistrocarga(sr);
                                }

                                Statement stm = con.createStatement();
                                long tiempoInicial = System.currentTimeMillis();

                                stm.executeUpdate(strBSqlCmdCargaArchivo.toString());

                                long tiempoFinal = System.currentTimeMillis();
                                long tiempoOperacion = tiempoFinal - tiempoInicial;

                                return true;
                            }
                        }

                        //</editor-fold>
                        StringBuilder strbInsertLog = new StringBuilder("INSERT INTO arc_logcarga(");
                        strbInsertLog.append(" car_nivel, car_mensaje, car_nomarchivo, car_fila, car_fechaproceso, ");
                        strbInsertLog.append(" frn_id, lgreg_id) VALUES ");

                        for (int i = 0; i < filasArchCont; i++) {

                            cols = p.split(arrStrFilasArch[i], -1).length;
                            if (cols != colArchivoEsperada) {
                                strbInsertLog.append("('Estructura', 'Error en estructura de archivo ', '");
                                strbInsertLog.append(archivoSalida.getCanonicalPath());
                                strbInsertLog.append("', 'en la fila ");
                                strbInsertLog.append(i + 1);
                                strbInsertLog.append("',");
                                strbInsertLog.append("now() , '");
                                strbInsertLog.append(getAdministracionJSFBean().getSysfuncionario().getFrnId());
                                strbInsertLog.append("',");
                                strbInsertLog.append(sr.getLgregId());
                                strbInsertLog.append("),\n");
                                error = true;
                                filaError = i;

                            } else {
                                String[] arrStrCols = p.split(arrStrFilasArch[i], -1);
                                System.arraycopy(arrStrCols, 0, arrStrMatrizArch[i], 0, colArchivoEsperada);
                            }

                        }

                        if (error) {
                            strbInsertLog.delete(strbInsertLog.length() - 2, strbInsertLog.length());
                            Statement st = con.createStatement();
                            st.executeUpdate(strbInsertLog.toString());
                        }
                        if (error) {
                            if (cols == 1) {
                                mensaje = "Fila vacia en la linea :" + (filaError + 1);
                                sr.setLgregTipomensaje("SEVERE");
                                sr.setLgregMensajecarga(mensaje);
                                sr.setLgregNomarchivocarga(archivoSalida.getName());
                                sr.setLgregIdmsjcarga(4);
                                sr = aslb.grabarRegistrocarga(sr);
                            } else {

                                mensaje = "Cantidad de columnas no esperadas se esperaban : "
                                        + colArchivoEsperada + " en la fila: " + (filaError + 1)
                                        + " Se encontraron " + cols;
                                sr.setLgregTipomensaje("SEVERE");
                                sr.setLgregMensajecarga(mensaje);
                                sr.setLgregIdmsjcarga(3);
                                sr.setLgregNomarchivocarga(archivoSalida.getName());
                                sr = aslb.grabarRegistrocarga(sr);

                            }
                            Logger.getLogger(getClass().getName()).log(Level.INFO, null, mensaje);

                            return false;
                        } else {

                            StringBuilder strBSqlCmdCargaArchivo = new StringBuilder(ta.getApeInsert());
                            strBSqlCmdCargaArchivo.append(" VALUES ");
                            try {
                                for (int i = 0; i < filasArchCont; i++) {
                                    strBSqlCmdCargaArchivo.append("('");
                                    for (int j = 0; j < colArchivoEsperada; j++) {
                                        String strDato = String.valueOf(arrStrMatrizArch[i][j]).trim();
                                        if (strDato.contains(".") || strDato.contains(",")) {
                                            strDato = escaper.translate(strDato);
                                            if (esNumero(strDato.replace(",", "").replace(".", "").replace("$", "").replace("%", ""))) {
                                                if (strDato.replace("%", "").replace("$", "").lastIndexOf(".") == strDato.replace("%", "").replace("$", "").length() - 3
                                                        || strDato.lastIndexOf(".") == strDato.replace("%", "").replace("$", "").length() - 2) {
                                                    strDato = strDato.replace(",", "").replace("%", "").replace("$", "");
                                                }
                                                if (strDato.replace("%", "").replace("$", "").lastIndexOf(",") == strDato.replace("%", "").replace("$", "").length() - 3
                                                        || strDato.replace("%", "").replace("$", "").lastIndexOf(",") == strDato.replace("%", "").replace("$", "").length() - 2) {
                                                    strDato = strDato.replace(".", "");
                                                    strDato = strDato.replace(",", ".").replace("%", "").replace("$", "");
                                                }
                                                strBSqlCmdCargaArchivo.append(strDato);
                                            } else {

                                                strBSqlCmdCargaArchivo.append(arrStrMatrizArch[i][j]);
                                            }
                                        } else {
                                            strBSqlCmdCargaArchivo.append(arrStrMatrizArch[i][j]);

                                        }

                                        strBSqlCmdCargaArchivo.append("','");
                                    }

                                    strBSqlCmdCargaArchivo.append(sr.getLgregId());
                                    strBSqlCmdCargaArchivo.append("','");
                                    strBSqlCmdCargaArchivo.replace(strBSqlCmdCargaArchivo.length() - 2, strBSqlCmdCargaArchivo.length(), "),");
                                }
                                strBSqlCmdCargaArchivo.replace(strBSqlCmdCargaArchivo.length() - 1, strBSqlCmdCargaArchivo.length(), "");
                                mensaje = "Archivo cargado exitosamente";
                                sr.setLgregTipomensaje("INFO");
                                sr.setLgregMensajecarga(mensaje);
                                sr.setLgregNomarchivocarga(archivoSalida.getName());
                                sr.setLgregIdmsjcarga(1);
                                 sr.setLgregValidado(Boolean.FALSE);
                                sr = aslb.grabarRegistrocarga(sr);
                            } catch (IndexOutOfBoundsException ioobe) {
                                mensaje = "Cantidad de columnas no esperadas se esperaban :" + colArchivoEsperada;
                                sr.setLgregTipomensaje("SEVERE");
                                sr.setLgregMensajecarga(mensaje);
                                sr.setLgregNomarchivocarga(archivoSalida.getName());
                                sr.setLgregIdmsjcarga(3);
                                sr = aslb.grabarRegistrocarga(sr);
                            }

                            Statement stm = con.createStatement();
                            long tiempoInicial = System.currentTimeMillis();

                            stm.executeUpdate(strBSqlCmdCargaArchivo.toString());

//                 
                            long tiempoFinal = System.currentTimeMillis();
                            long tiempoOperacion = tiempoFinal - tiempoInicial;

                            return true;
                        }

                    } else {

                        for (String string : arrStrFilasArch) {
                            String[] strArrFila = new String[colArchivoEsperada];
                            List<String> lstStrPalabrasFila = new ArrayList<>();
                            List<String> lstStrNumerosFila = new ArrayList<>();
                            StringTokenizer st = new StringTokenizer(string, " ");
                            Integer cantidadTokens = st.countTokens();
                            if (cantidadTokens != 0) {

                                while (st.hasMoreElements()) {
                                    // Object object = stringTokenizer.nextElement();
                                    String strElToken = st.nextToken();
                                    if (strElToken.contains(".") || strElToken.contains(",")) {
                                        if (esNumero(strElToken.replace(",", "").replace(".", ""))) {
                                            lstStrNumerosFila.add(strElToken.replace(",", ""));
                                        } else {
                                            lstStrPalabrasFila.add(strElToken);
                                        }
                                    } else {
                                        lstStrPalabrasFila.add(strElToken);

                                    }

                                }

                            }

                            strArrFila[0] = lstStrPalabrasFila.get(0);
                            strBNombreCuenta.delete(0, strBNombreCuenta.capacity());
                            for (int i = 1; i < lstStrPalabrasFila.size(); i++) {
                                strBNombreCuenta.append(lstStrPalabrasFila.get(i));
                                strBNombreCuenta.append(" ");
                            }

                            strArrFila[1] = strBNombreCuenta.toString().trim();
                            int i = 2;
                            if (lstStrNumerosFila.size() > colArchivoEsperada - 2) {
                                System.out.println("ERROR ");
                            } else {
                                for (String strNumero : lstStrNumerosFila) {
                                    strArrFila[i] = strNumero;
                                    i++;
                                }
                            }
                            lstArrayParaInsertar.add(strArrFila);
                            System.out.println("Cantidad palabras: " + lstStrPalabrasFila.size());
                            System.out.println("Cantidad números: " + lstStrNumerosFila.size());

                        }

                        StringBuilder strBSqlCmdCopiaAut = new StringBuilder();

                        sr = aslb.grabarRegistrocarga(sr);
                        strBSqlCmdCopiaAut.append(ta.getApeInsert());

                        strBSqlCmdCopiaAut.append(" VALUES ");
                        try {
                            for (String[] strArrFilaInsertar : lstArrayParaInsertar) {

                                boolean blnValidaNull = false;
                                for (String string : strArrFilaInsertar) {
                                    if (string == null) {
                                        blnValidaNull = true;
                                    }

                                }
                                if (blnValidaNull) {
                                    continue;
                                }
                                strBSqlCmdCopiaAut.append("('");
                                for (int j = 0; j < colArchivoEsperada; j++) {
                                    strBSqlCmdCopiaAut.append(strArrFilaInsertar[j]);
                                    strBSqlCmdCopiaAut.append("','");
                                }

                                strBSqlCmdCopiaAut.append(sr.getLgregId());
                                strBSqlCmdCopiaAut.append("','");
                                strBSqlCmdCopiaAut.replace(strBSqlCmdCopiaAut.length() - 2, strBSqlCmdCopiaAut.length(), "),");
                            }
                            strBSqlCmdCopiaAut.replace(strBSqlCmdCopiaAut.length() - 1, strBSqlCmdCopiaAut.length(), "");
                            mensaje = "Archivo cargado exitosamente";
                            sr.setLgregTipomensaje("INFO");
                            sr.setLgregMensajecarga(mensaje);
                            sr.setLgregNomarchivocarga(archivoSalida.getName());
                            sr.setLgregIdmsjcarga(1);
                            sr.setLgregValidado(Boolean.FALSE);
                            sr = aslb.grabarRegistrocarga(sr);
                            

                        } catch (IndexOutOfBoundsException ioobe) {

                            sr.setLgregMensajecarga(mensaje);
                        }

                        Statement stm = con.createStatement();
                        long tiempoInicial = System.currentTimeMillis();

                        stm.executeUpdate(strBSqlCmdCopiaAut.toString());

                        long tiempoFinal = System.currentTimeMillis();
                        long tiempoOperacion = tiempoFinal - tiempoInicial;
                        Logger.getLogger(getClass().getName()).log(Level.INFO, null, tiempoOperacion);
                        
                        return true;

                    }

                }
            } catch (SQLException | IOException ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
                mensaje = "Error en estructura de archivo ";
                sr.setLgregTipomensaje("SEVERE");
                sr.setLgregMensajecarga(mensaje);
                sr.setLgregNomarchivocarga(archivoSalida.getName());
                sr.setLgregIdmsjcarga(2);
                sr = aslb.grabarRegistrocarga(sr);
                sr = new SysRegistrocarga();

                return false;
            } finally {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
                    mensaje = "Error al cerrar la conexion";
                    sr.setLgregTipomensaje("SEVERE");
                    sr.setLgregMensajecarga(mensaje);
                    sr.setLgregNomarchivocarga(archivoSalida.getName());
                    sr = aslb.grabarRegistrocarga(sr);
                    sr = new SysRegistrocarga();
                    //return false;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(CMPrepJSFBean.class.getName()).log(Level.SEVERE, null, ex);
            sr = new SysRegistrocarga();

            return false;
        }

    }

    public static void transofrmarCodif(File source, String srcEncoding, File target, String tgtEncoding) throws IOException {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(source), srcEncoding));
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(target), tgtEncoding));
            char[] buffer = new char[16384];
            int read;
            while ((read = br.read(buffer)) != -1) {
                bw.write(buffer, 0, read);
            }
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } finally {
                if (bw != null) {
                    bw.close();
                }
            }
        }
    }

//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Referencias a otros JSFBEans">
    public ProcCargadosFasesBase getProcesoCargadosFasesJSFBean() {
        fc = FacesContext.getCurrentInstance();
        elc = fc.getELContext();
        return (ProcCargadosFasesBase) elc.getELResolver().getValue(elc, null, "procesoCargadosFasesJSFBean");
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Propiedades">
    /**
     * Contenido archivo de control
     */
    protected Object[][] arrStrMatrizArch;
    /**
     * Salto de linea en "\n" por defecto
     */
    protected String strSaltoLinea = "\n";

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getStrUnidadEjecSel() {
        return strUnidadEjecSel;
    }

    /**
     * @param strUnidadEjecSel the strUnidadEjecSel to set
     */
    public void setStrUnidadEjecSel(String strUnidadEjecSel) {
        this.strUnidadEjecSel = strUnidadEjecSel;
    }

    public Integer getIntSectorEsSel() {
        return intSectorEsSel;
    }

    public void setIntSectorEsSel(Integer intSectorEsSel) {
        this.intSectorEsSel = intSectorEsSel;
    }

    /**
     * @return the tablaTablaSysArchivoSel
     */
    public TablaSysArchivo getTablaTablaSysArchivoSel() {
        return tablaTablaSysArchivoSel;
    }

    /**
     * @param tablaTablaSysArchivoSel the tablaTablaSysArchivoSel to set
     */
    public void setTablaTablaSysArchivoSel(TablaSysArchivo tablaTablaSysArchivoSel) {
        this.tablaTablaSysArchivoSel = tablaTablaSysArchivoSel;
    }

    /**
     * @return the lstTablaSysArchivos
     */
//    public List<TablaSysArchivo> getLstTablaSysArchivos() {
//        return lstTablaSysArchivos;
//    }
    /**
     * @param lstTablaSysArchivos the lstTablaSysArchivos to set
     */
//    public void setLstTablaSysArchivos(List<TablaSysArchivo> lstTablaSysArchivos) {
//        this.lstTablaSysArchivos = lstTablaSysArchivos;
//    }
    /**
     * @return the msjArea
     */
    public String getMsjArea() {
        return msjArea;
    }

    /**
     * @param msjArea the msjArea to set
     */
    public void setMsjArea(String msjArea) {
        this.msjArea = msjArea;
    }

    /**
     * @return the strEntIdSel
     */
    public String getStrEntIdSel() {
        return strEntIdSel;
    }

    /**
     * @param strEntIdSel the strEntIdSel to set
     */
    public void setStrEntIdSel(String strEntIdSel) {
        this.strEntIdSel = strEntIdSel;
    }

    public Date getLgregPeriodo() {
        return lgregPeriodo;
    }

    public void setLgregPeriodo(Date lgregPeriodo) {
        this.lgregPeriodo = lgregPeriodo;
    }

    public List<TablaSysArchivosporEntidades> getLstTablaThmArchivosporEntidades() {
        return lstTablaThmArchivosporEntidades;
    }

    public void setLstTablaThmArchivosporEntidades(List<TablaSysArchivosporEntidades> lstTablaThmArchivosporEntidades) {
        this.lstTablaThmArchivosporEntidades = lstTablaThmArchivosporEntidades;
    }

    @Override
    public void limpiarVariables() {
    }

    @Override
    public void navegacionLateral_ActionEvent(ActionEvent ae) {
    }

    @Override
    public boolean validarFormulario() {
        return true;
    }

    @Override
    public void init() {
    }

    /**
     * @return the lstEntidad
     */
    public List<AdmEntidad> getLstEntidad() {
        return lstEntidad;
    }

    /**
     * @param lstEntidad the lstEntidad to set
     */
    public void setLstEntidad(List<AdmEntidad> lstEntidad) {
        this.lstEntidad = lstEntidad;
    }

    /**
     * @return the intSectorAdSel
     */
    public Integer getIntSectorAdSel() {
        return intSectorAdSel;
    }

    /**
     * @param intSectorAdSel the intSectorAdSel to set
     */
    public void setIntSectorAdSel(Integer intSectorAdSel) {
        this.intSectorAdSel = intSectorAdSel;
    }
//</editor-fold>
}
