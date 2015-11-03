/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veeduria.web.base;

import com.veeduria.sys.dao.SysInforme;
import com.veeduria.web.sys.jsf.AdministracionJSFBean;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipOutputStream;
import javax.annotation.Resource;
import javax.el.ELContext;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JExcelApiExporter;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import org.icefaces.util.JavaScriptRunner;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Months;
import org.joda.time.Years;

/**
 *
 * @author luz
 */
public abstract class BaseJSFBean implements Serializable {

    //<editor-fold defaultstate="collapsed" desc="Variables">
    @Resource(name = "jdbcVeeduria")
    protected DataSource jdbcVeeduria;
    protected String ruta_recursos = "/WEB-INF/classes/reportes/";

    protected SelectItem itemSeleccioneStr = new SelectItem("-1", "Seleccione>>");
    protected SelectItem itemSeleccioneInt = new SelectItem(-1, "Seleccione>>");
    protected SelectItem itemSeleccioneLng = new SelectItem(-1l, "Seleccione>>");
    protected FacesContext fc = FacesContext.getCurrentInstance();
    protected ELContext elc;
    protected Integer numPanel = 1;
    protected String strPagId = "";
    protected boolean blnImgError = false;
    protected String strDetalleIncons = "";

    public Integer getNumPanel() {
        return numPanel;
    }

    public void setNumPanel(Integer numPanel) {
        this.numPanel = numPanel;
    }

    protected ByteArrayOutputStream baosManejoZip = new ByteArrayOutputStream();
    private ZipOutputStream zipOutputStream;

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Funciones Comunes">
    protected boolean esNumero(String string) {
        if (string == null || string.isEmpty()) {
            return false;
        }
        int i = 0;
        if (string.charAt(0) == '-') {
            if (string.length() > 1) {
                i++;
            } else {
                return false;
            }
        }
        for (; i < string.length(); i++) {
            if (!Character.isDigit(string.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Ir al servlet que de descarga de archivos
     *
     * @param pRecursoDescarga
     */
    protected void irAServletDescarga(RecursoDescarga pRecursoDescarga) {
        try {
            fc = FacesContext.getCurrentInstance();
            ExternalContext ec = fc.getExternalContext();
            String contextoApp = ec.getApplicationContextPath();
            HttpSession hs = (HttpSession) ec.getSession(false);
            hs.setAttribute("rd", pRecursoDescarga);
            ec.redirect(contextoApp + "/DescargarArchivoServlet");
        } catch (IOException ex) {
            Logger.getLogger(BaseJSFBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void mostrarError(String errors) {
        blnImgError = true;

        getAdministracionJSFBean().setStrClaseStyleMensajes("styleMensajeError");
        FacesMessage message = new FacesMessage();
        message.setDetail(errors);
        message.setSummary("Error");
        message.setSeverity(FacesMessage.SEVERITY_ERROR);
        FacesContext.getCurrentInstance().addMessage(null, message);
        JavaScriptRunner.runScript(FacesContext.getCurrentInstance(), "myNotificacionBar.show();");

    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Funciones Abstractas">
    public abstract void init();

    public abstract void limpiarVariables();

    public abstract void navegacionLateral_ActionEvent(ActionEvent ae);

    public abstract boolean validarFormulario();
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="manejo zip">
    public boolean generarZipLstPdf(List<BinarioInforme> lstBinarioInformes) {

        try {

            zipOutputStream = new ZipOutputStream(baosManejoZip);
            for (BinarioInforme binarioInforme : lstBinarioInformes) {
                // Transfer bytes from the file to the ZIP file
                try {
                    byte[] bs = binarioInforme.getBaos().toByteArray();
                    InputStream inputStream = new ByteArrayInputStream(bs);
                    CRC32 crc = new CRC32();
                    ZipEntry zipEntry = new ZipEntry(binarioInforme.getNombreArchivo());

                    crc.update(bs);
                    zipEntry.setCrc(crc.getValue());
                    zipOutputStream.putNextEntry(zipEntry);

                    int len;
                    while ((len = inputStream.read(bs)) > 0) {
                        zipOutputStream.write(bs, 0, len);
                    }
                } catch (ZipException ze) {
                    continue;
                }
            }
            zipOutputStream.setLevel(6);
            zipOutputStream.finish();
            zipOutputStream.close();

            return true;
        } catch (IOException ex) {
            Logger.getLogger(BaseJSFBean.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Jasper">
//    /**
//     * Generar informe
//     *
//     * @param hmParamInf Parámetros del informe
//     * @param pAdmInforme Informe
//     * @param tipoExportacion Tipo exportación, 1 para excel, 2 para PDF y 3
//     * para html
//     */
//    public void genInforme(HashMap hmParamInf, SysInforme pSysInforme, Integer tipoExportacion) {
//        try {
//            fc = FacesContext.getCurrentInstance();
//            ExternalContext ec = fc.getExternalContext();
//            try (Connection con = jdbcVeeduria.getConnection()) {
//                InputStream inputStream = ec.getResourceAsStream(ruta_recursos + pSysInforme.getInfJasperruta() + File.separator + pSysInforme.getInfJasper());
//
//                JasperPrint jp = JasperFillManager.fillReport(inputStream, hmParamInf, con);
//                ByteArrayOutputStream baos = new ByteArrayOutputStream();
//                switch (tipoExportacion) {
//                    case 1:
//                        JExcelApiExporter jeae = new JExcelApiExporter();
//
//                        jeae.setParameter(JRXlsExporterParameter.INPUT_STREAM, inputStream);
//                        jeae.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, baos);
//                        jeae.setParameter(JRXlsExporterParameter.JASPER_PRINT, jp);
//                        jeae.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
//                        jeae.exportReport();
//                        jasperResourceExcel = new RecursosOut(pSysInforme.getInfNombre(), baos);
//                        break;
//
//                    case 2:
//
//                        JasperExportManager.exportReportToPdfStream(jp, baos);
//
//                        jasperResourcePDF = new RecursosOut(pSysInforme.getInfJasper(), baos);
//
//                        break;
//                    case 3:
//
//                        break;
//                    case 4:
//                        JRCsvExporter exporterCSV = new JRCsvExporter();
//                        exporterCSV.setParameter(JRXlsExporterParameter.JASPER_PRINT, jp);
//                        exporterCSV.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, baos);
//                        exporterCSV.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS, true);
//                        exporterCSV.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, true);
//                        exporterCSV.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, true);
//                        exporterCSV.setParameter(JRExporterParameter.CHARACTER_ENCODING, "UTF8");
//                        exporterCSV.exportReport();
//                        jrResourceCSV = new RecursosOut(pSysInforme.getInfJasper(), baos);
//                        break;
//                }
//            }
//
//        } catch (JRException | SQLException ex) {
//            Logger.getLogger(BaseJSFBean.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
    /**
     * Generar informe
     *
     * @param hmParamInf Parámetros del informe
     * @param pAdmInforme Informe
     * @param tipoExportacion Tipo exportación, 1 para excel, 2 para PDF, 3 para
     * html, 4 para CSV
     * @return Recurso binario resultado de la generación del informe
     */
    /**
     * Generar informe
     *
     * @param hmParamInf Parámetros del informe
     * @param pAdmInforme Informe
     * @param tipoExportacion Tipo exportación, 1 para excel, 2 para PDF, 3 para
     * html, 4 para CSV, 5 para xlsx
     * @return Recurso binario resultado de la generación del informe
     */
    protected RecursoDescarga genInfRecurso(HashMap hmParamInf, SysInforme pAdmInforme, Integer tipoExportacion) {
        try {
            fc = FacesContext.getCurrentInstance();
            ExternalContext ec = fc.getExternalContext();
            try (Connection con = jdbcVeeduria.getConnection()) {
                Path rutaReporte = Paths.get(ec.getRealPath(ruta_recursos + pAdmInforme.getInfJasperruta() + pAdmInforme.getInfJasper()));
                InputStream inputStream = Files.newInputStream(rutaReporte, LinkOption.NOFOLLOW_LINKS);
                hmParamInf.put("SUBREPORT_DIR", ec.getRealPath(ruta_recursos + pAdmInforme.getInfJasperruta()) + "/");
                JasperPrint jp = JasperFillManager.fillReport(inputStream, hmParamInf, con);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                RecursoDescarga jrResourceRetorna = null;
                switch (tipoExportacion) {
                    case 1:
                        JExcelApiExporter jeae = new JExcelApiExporter();

                        jeae.setParameter(JRXlsExporterParameter.INPUT_STREAM, inputStream);
                        jeae.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, baos);
                        jeae.setParameter(JRXlsExporterParameter.JASPER_PRINT, jp);
                        jeae.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
                        jeae.setParameter(JRExporterParameter.CHARACTER_ENCODING, "UTF8");
                        jeae.exportReport();
                        jrResourceRetorna = new RecursoDescarga(baos.toByteArray(), "application/xls", pAdmInforme.getInfNombre());

                        break;

                    case 2:

                        JasperExportManager.exportReportToPdfStream(jp, baos);

                        jrResourceRetorna = new RecursoDescarga(baos.toByteArray(), "application/pdf", pAdmInforme.getInfNombre());

                        break;
                    case 3:

                        break;
                    case 4:
                        JRCsvExporter exporterCSV = new JRCsvExporter();
                        exporterCSV.setParameter(JRXlsExporterParameter.JASPER_PRINT, jp);
                        exporterCSV.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, baos);
                        exporterCSV.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS, true);
                        exporterCSV.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, true);
                        exporterCSV.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, true);
                        exporterCSV.setParameter(JRExporterParameter.CHARACTER_ENCODING, "UTF8");
                        exporterCSV.exportReport();
                        jrResourceRetorna = new RecursoDescarga(baos.toByteArray(), "application/xls", pAdmInforme.getInfNombre() );
                        break;

                    case 5:
                        JRXlsxExporter exporterXLSX = new JRXlsxExporter();
                        exporterXLSX.setParameter(JRXlsExporterParameter.INPUT_STREAM, inputStream);
                        exporterXLSX.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, baos);
                        exporterXLSX.setParameter(JRXlsExporterParameter.JASPER_PRINT, jp);
                        exporterXLSX.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
                        exporterXLSX.setParameter(JRExporterParameter.CHARACTER_ENCODING, "UTF8");
                        exporterXLSX.exportReport();
                        jrResourceRetorna = new RecursoDescarga(baos.toByteArray(), "application/xlsx", pAdmInforme.getInfNombre() + ".xlsx");
                        break;
                }
                if (jrResourceRetorna != null) {
                    return jrResourceRetorna;
                } else {
                    return null;
                }

            }

        } catch (IOException | JRException | SQLException ex) {
            Logger.getLogger(BaseJSFBean.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="manejo fecha">
    public int getDiaDiferencia(Date pFecIni, Date pFecFin) {
        DateTime jdtFecIni = new DateTime(pFecIni);
        DateTime jdtFecFin = new DateTime(pFecFin);
        return Days.daysBetween(jdtFecIni.toDateMidnight(), jdtFecFin.toDateMidnight()).getDays();

    }

    public int getMesDiferencia(Date pFecIni, Date pFecFin) {
        DateTime jdtFecIni = new DateTime(pFecIni);
        DateTime jdtFecFin = new DateTime(pFecFin);
        return Months.monthsBetween(jdtFecIni.toDateMidnight(), jdtFecFin.toDateMidnight()).getMonths();

    }

    public int getAnioDiferencia(Date pFecIni, Date pFecFin) {
        DateTime jdtFecIni = new DateTime(pFecIni);
        DateTime jdtFecFin = new DateTime(pFecFin);
        return Years.yearsBetween(jdtFecIni.toDateMidnight(), jdtFecFin.toDateMidnight()).getYears();

    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="manejo listas">
    public Long cantElemSelLista(List<? extends TablaBaseFrm> lst) {
        //return lst.stream().filter(p -> p.isSeleccionado()).reduce(Collections.c null, null)
//        Long cantSel = 0L;
//        long count;
        return lst.stream().filter(p -> p.isSeleccionado()).count();
//        for (TablaBaseFrm tablaBaseFrm : lst) {
//            if (tablaBaseFrm.isSeleccionado()) {
//                cantSel = cantSel + 1;
//            }
//        }
//        return cantSel;
    }

    /**
     * Eliminar los elementos seleccionados de una tabla
     *
     * @param lst
     * @return Lista de elementos eliminados para hacer las operaciones
     * correspondientes
     */
    protected List retirarElemTabla(List<? extends TablaBaseFrm> lst) {
        List lstRerirar = new ArrayList();
        lst.stream().filter(p -> p.isSeleccionado()).forEach(p -> lstRerirar.add(p));
        lst.removeAll(lstRerirar);
//        for (Object object : lst) {
//            try {
//                Class claseObjLst = object.getClass();
//                Method metodo = claseObjLst.getMethod("isSeleccionado", new Class<?>[0]);
//                Object objResultSel = metodo.invoke(object, new Object[0]);
//                Boolean blnSel = (Boolean) objResultSel;
//                if (blnSel.booleanValue()) {
//                    lstRerirar.add(object);
//                }
//
//            } catch (SecurityException | NoSuchMethodException | IllegalAccessException |
//                    IllegalArgumentException | InvocationTargetException ex) {
//                Logger.getLogger(BaseJSFBean.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//        }

        return lstRerirar;
    }

    /**
     * Resaltar la fila seleccionada de una tabla, la lista debe ser de objetos
     * que hereden de la clase TablaBaseGrid
     *
     * @param lst
     * @param objSel
     */
    public void resaltarFilaTabla(List<? extends TablaBaseFrm> lst, TablaBaseFrm objSel) {
        lst.stream().forEach(p -> {
            if (p.equals(objSel)) {
                p.setSeleccionado(true);
                p.setClaseSel("seleccione");
            } else {
                p.setSeleccionado(false);
                p.setClaseSel("");
            }
        });

//        for (Object object : lst) {
//            if (object.equals(objSel)) {
//                try {
//                    Class claseObjLst = object.getClass();
//                    Class[] argSetSel = {Boolean.TYPE};
//
//                    Method metodo = claseObjLst.getMethod("setSeleccionado", argSetSel);
//                    Object[] objParam = {Boolean.TRUE};
//                    metodo.invoke(object, objParam);
//
//                    Class[] argSetClaseSel = {String.class};
//                    Method setClaseSel = claseObjLst.getMethod("setClaseSel", argSetClaseSel);
//
//                    Object[] objParamClase = {"seleccione"};
//                    setClaseSel.invoke(object, objParamClase);
//
//                } catch (IllegalAccessException | NoSuchMethodException | SecurityException |
//                        IllegalArgumentException | InvocationTargetException ex) {
//                    Logger.getLogger(BaseJSFBean.class.getName()).log(Level.WARNING, null, ex);
//                }
//
//            } else {
//                try {
//                    Class claseObjLst = object.getClass();
//                    Class[] argSetSel = {Boolean.TYPE};
//
//                    Method metodo = claseObjLst.getMethod("setSeleccionado", argSetSel);
//                    Object[] objParam = {Boolean.FALSE};
//                    metodo.invoke(object, objParam);
//
//                    Class[] argSetClaseSel = {String.class};
//                    Method setClaseSel = claseObjLst.getMethod("setClaseSel", argSetClaseSel);
//
//                    Object[] objParamClase = {""};
//                    setClaseSel.invoke(object, objParamClase);
//
//                } catch (IllegalAccessException | IllegalArgumentException |
//                        InvocationTargetException | NoSuchMethodException | SecurityException ex) {
//                    Logger.getLogger(BaseJSFBean.class.getName()).log(Level.SEVERE, null, ex);
//                }
//
//            }
//        }
    }

    /**
     * Cambiar el estado del campo seleccionado de una lista tipo tabla
     *
     * @param lst Lista
     * @param sel estado del campo
     */
    protected void selTodoLst(List<? extends TablaBaseFrm> lst, boolean sel) {
        lst.stream().forEach(p -> p.setSeleccionado(sel));

//        for (Object object : lst) {
//
//            Class claseObjLst = object.getClass();
//            try {
//                Class[] argSetSel = {Boolean.TYPE};
//
//                Method metodo = claseObjLst.getMethod("setSeleccionado", argSetSel);
//                Object[] objParam = {sel};
//
//                metodo.invoke(object, objParam);
//
//            } catch (IllegalAccessException | NoSuchMethodException | SecurityException |
//                    IllegalArgumentException | InvocationTargetException ex) {
//                Logger.getLogger(BaseJSFBean.class.getName()).log(Level.WARNING, null, ex);
//            }
//
//        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="referencia a otros jsf">
    public AdministracionJSFBean getAdministracionJSFBean() {

        fc = FacesContext.getCurrentInstance();
        elc = fc.getELContext();
        return (AdministracionJSFBean) elc.getELResolver().getValue(elc, null, "administracionJSFBean");
    }
    //</editor-fold>
}
