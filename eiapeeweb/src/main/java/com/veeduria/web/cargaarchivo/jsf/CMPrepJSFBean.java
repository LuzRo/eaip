/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veeduria.web.cargaarchivo.jsf;

import com.veeduria.adm.dao.AdmEntidad;
import com.veeduria.adm.dao.AdmSectoradmin;
import com.veeduria.adm.dao.AdmSectorestruc;
import com.veeduria.adm.dao.AdmUnidadejec;
import com.veeduria.dosfases.jsf.ProcCargadosFasesBase;
import com.veeduria.sys.dao.SysArchivo;
import com.veeduria.sys.dao.SysInforme;
import com.veeduria.sys.dao.SysRegistrocarga;
import com.veeduria.sys.dao.SysArchivosporentidades;
import com.veeduria.web.base.RecursoDescarga;
import com.veeduria.web.base.TablaSysInforme;
import com.veeduria.web.cargaarchivo.BaseCargaArchivo;
import com.veeduria.web.cargaarchivo.TablaSysArchivosporEntidades;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import org.icefaces.ace.component.fileentry.FileEntry;
import org.icefaces.ace.component.fileentry.FileEntryEvent;
import org.icefaces.ace.component.fileentry.FileEntryResults;
//import javax.servlet.http.HttpSession;
//import org.joda.time.DateTime;

/**
 *
 * @author luz
 */
@Named(value = "cMPrepJSFBean")
@SessionScoped
public class CMPrepJSFBean extends BaseCargaArchivo implements Serializable {

    protected Integer intSectorAdSel;
    private Integer intArchivoXArcIdSel;
    private SysInforme sysInformeSel = new SysInforme();
    private List<SelectItem> lstItemsArchivo = new ArrayList<>();
    private List<SelectItem> lstItemsEntidad = new ArrayList<>();
    private List<SelectItem> lstItemsPeriodo = new ArrayList<>();
    protected List<SelectItem> lstItemsSecEstructura = new ArrayList<>();
    protected List<SelectItem> lstItemsSecAdmin = new ArrayList<>();
    protected List<TablaSysInforme> lstTablaSysInforme = new ArrayList<>();
    protected List<SelectItem> lstItemsUnidEjecutora = new ArrayList<>();
    private List<TablaSysArchivosporEntidades> lstTablaSysArchivosporEntidades = new ArrayList<>();
    private String navegacion;
    boolean blnInconsistencias = false;

    public CMPrepJSFBean() {
    }

    public void ddlSectorEs_ValueChange(ValueChangeEvent vce) {

        intSectorEsSel = (Integer) vce.getNewValue();
        if (intSectorAdSel != -1 && intSectorEsSel != -1) {

            cargarEntidadXSectoresXSectorad();
        }

    }

    public void ddlEntidad_ValueChange(ValueChangeEvent vce) {

        strEntIdSel = (String) vce.getNewValue();
        cargarUnidadEjecxEntidad();
        switch (getAdministracionJSFBean().getNavegacion()) {
            case "cargarArchivoPre":
                cargarUnidadEjecxEntidad();
                break;
            case "cargarArchivosPLA":
                cargarArchivosporEntidad();
                break;
            case "cargarArchivosTH":
                cargarUnidadEjecxEntidad();
                break;

        }

    }

    public void ddlSectorAd_ValueChange(ValueChangeEvent vce) {

        intSectorAdSel = (Integer) vce.getNewValue();
        if (intSectorAdSel != -1 && intSectorEsSel != -1) {

            cargarEntidadXSectoresXSectorad();

        }

    }

    public void ddlArchivosel_ValueChange(ValueChangeEvent vce) {

        intArchivoXArcIdSel = (Integer) vce.getNewValue();
//        cargarNomArchivo();

    }

//    public void ddlArchivoTHsel_ValueChange(ValueChangeEvent vce) {
//
//        intArchivoThSel = (Integer) vce.getNewValue();
//        if (intArchivoThSel != -1 && intArchivoThSel != -1) {
//
//            cargarNomArchivoTH();
//        }
//    }
    public void btnVolver_ActionEvent(ActionEvent ae) {

//        if (navegacion.equals("cargarArchivoIngreso") || navegacion.equals("cargarArchivoGasto")) {
        navegacion = "cargarArchivos";
//        }
        limpiarVariables();

    }

    public String btnVolver_Action() {

        return navegacion;

    }

    public void rowDtTablaSysInforme_ActionEvent(ActionEvent ae) {

        TablaSysInforme tsi = (TablaSysInforme) ae.getComponent().getAttributes().get("sysInformeSel");
        sysInformeSel = tsi.getSysInforme();
        HashMap hs = new HashMap();
        hs.put("p_lgreg_id", 1835L);
        RecursoDescarga rd = genInfRecurso(hs, sysInformeSel, 1);
        irAServletDescarga(rd);
    }

    public void ifArchivoProceso_ActionEvent(FileEntryEvent fee) throws InterruptedException {

        FileEntry fileEntry = (FileEntry) fee.getSource();
        FileEntryResults results = fileEntry.getResults();
        for (FileEntryResults.FileInfo fileInfo : results.getFiles()) {
            if (fileInfo.isSaved()) {
//                ruta = fileInfo.getPhysicalPath();
                File encAut = fileInfo.getFile();
                ent_id = new AdmEntidad(strEntIdSel);
                cargarArchivoProceso(encAut);
//                if (cargarArchivoProceso(encAut)) {
//                    blnInconsistencias = getProcesoCargadosFasesJSFBean().getCdfsfb().insertInconsGasto(sr.getLgregId());
//                }
//                if (blnInconsistencias) {
//                    mostrarError("Archivo cargado correctamente con inconsistencias, revisar detalle.");
//                }
                //fileZipRips = fileInfo.getFile();
                //descomprimirZip();
                return;
            }
        }
        limpiarVariables();

    }

    //</editor-fold>
    private void cargarEntidadXSectores() {

        lstItemsEntidad.clear();
        lstItemsEntidad.add(itemSeleccioneStr);
        for (AdmEntidad as : aslb.getLstEntxSe(intSectorEsSel)) {
            lstItemsEntidad.add(new SelectItem(as.getEntId(), as.getEntNombre()));
        }
    }

    private void cargarSectores() {

        lstItemsSecEstructura.clear();
        lstItemsSecEstructura.add(itemSeleccioneInt);
        aslb.getLstSectorestrucs().stream().map((se -> {
            return new SelectItem(se.getSesId(), se.getSesNombre());

        })).forEach(lstItemsSecEstructura::add);

    }

    private void cargarEntidadXSectorad() {

        lstItemsEntidad.clear();
        lstItemsEntidad.add(itemSeleccioneStr);
        aslb.getLstEntxSa(intSectorAdSel).stream().map((aa -> {
            return new SelectItem(aa.getEntId(), aa.getEntNombre());
        })).forEach(lstItemsEntidad::add);

    }

    public void cargarUnidadEjecxEntidad() {

        lstItemsUnidEjecutora.clear();
        lstItemsUnidEjecutora.add(itemSeleccioneStr);
        aslb.getLstUnidadejecxEnt(strEntIdSel).stream().map((ue -> {
            return new SelectItem(ue.getEjeCodigo(), ue.getEjeNombre());
        })).forEach(lstItemsUnidEjecutora::add);

    }

    private void cargarTablaArchivosporEntidades() {

        lstTablaSysArchivosporEntidades = aslb.getLstArchivosporentidades(strEntIdSel,
                getAdministracionJSFBean().getTablaSysArchivoSel().getSysArchivo().getArcId()).
                stream().map((e -> {
                    return new TablaSysArchivosporEntidades(e);
                })).collect(Collectors.toList());

//        lstTablaSysArchivosporEntidades.clear();
//        for (SysArchivosporentidades sysArchivosporentidades : aslb.getLstArchivosporentidades(strEntIdSel,
//                getAdministracionJSFBean().getTablaSysArchivoSel().getSysArchivo().getArcId())) {
//
//            TablaSysArchivosporEntidades tae = new TablaSysArchivosporEntidades(sysArchivosporentidades);
//            lstTablaSysArchivosporEntidades.add(tae);
//        }
    }

    private void cargarArchivosporEntidad() {

        lstItemsEntidad.clear();
        lstItemsEntidad.add(new SelectItem("-1", "Seleccione"));
        AdmEntidad e = aslb.getLstEntidadporId("95");
        lstItemsEntidad.add(new SelectItem(e.getEntId(), e.getEntNombre()));

    }

    private void cargarInformeXFuncionario() {

        lstTablaSysInforme.clear();
        for (SysInforme si : aslb.getLstInformeporFuncionario(getAdministracionJSFBean().getSysfuncionario().getFrnId())) {
            TablaSysInforme tsi = new TablaSysInforme();
            tsi.setSysInforme(si);
            lstTablaSysInforme.add(tsi);
        }
    }

    public void cargarEntidadXSectoresXSectorad() {

        lstItemsEntidad.clear();
        lstItemsEntidad.add(new SelectItem("-1", "Seleccione"));
        for (AdmEntidad aa : aslb.getLstEntxSexSa(intSectorEsSel, intSectorAdSel)) {
            lstItemsEntidad.add(new SelectItem(aa.getEntId(), aa.getEntNombre()));
//            lstItemsEntidad.clear();

        }

    }

    public void cargarNomArchivo() {

        if (intArchivoXCpcIdSel != -1) {
            lstItemsArchivo.clear();
            lstItemsArchivo.add(new SelectItem(-1, "Seleccione"));
            for (SysArchivo sy : aslb.getLstArchivos(intArchivoXCpcIdSel)) {

                lstItemsArchivo.add(new SelectItem(sy.getArcId(), sy.getArcNombre()));
            }
        }

    }

//    public void cargarNomArchivoTH() {
//
//        lstItemsArchivo.clear();
//        lstItemsArchivo.add(new SelectItem("-1", "Seleccione"));
//        for (SysArchivo sy : aslb.getLstArchivos(intArchivoThSel)) {
//
//            lstItemsArchivo.add(new SelectItem(sy.getArcId(), sy.getArcNombre()));
//        }
//
//    }
    public void cargarNomArchivoPresupuesto() {

        lstItemsArchivo.clear();
        lstItemsArchivo.add(new SelectItem("-1", "Seleccione"));
        List<String> lstParametros = new ArrayList<>();
        lstParametros.add("5");
        lstParametros.add("6");
        for (SysArchivo sy : aslb.getLstArchivosPrespuesto(lstParametros)) {

            lstItemsArchivo.add(new SelectItem(sy.getArcId(), sy.getArcNombre()));

        }

    }

    private void cargarSectoradm() {
        lstItemsSecAdmin.clear();
        lstItemsSecAdmin.add(itemSeleccioneInt);
        for (AdmSectoradmin sa : aslb.getLstSectoradmin()) {
            lstItemsSecAdmin.add(new SelectItem(sa.getSadId(), sa.getSadNombre()));

        }

    }

//     private void cargarSectorEstructura(){
//       
//           lstItemsSecEstructura.clear();
//           lstItemsSecEstructura.add(new SelectItem("-1", "Seleccione"));
//           for (AdmEntidad as: aslb.getLstEntxSe(intSectorEsSel)){
//               lstItemsSecEstructura.add(new SelectItem(as.getSesId(), as.getSesNombre()));
//               
//           }
//           
//       }
    @Override
    public void init() {
        navegacion = getAdministracionJSFBean().getNavegacion();
        intSectorAdSel = -1;
        intSectorEsSel = -1;
        intArchivoXCpcIdSel = -1;
        switch (navegacion) {
            case "cargarArchivoPre":
                intArchivoXCpcIdSel = 3;
                break;
            case "cargarArchivosPLA":
                intArchivoXCpcIdSel = 5;
                break;
            case "cargarArchivosTH":
                intArchivoXCpcIdSel = 6;
                break;
        }
        cargarNomArchivo();
        //cargarUnidadEjecxEntidad();

        cargarSectores();
        cargarSectoradm();
        cargarInformeXFuncionario();

        cargarTablaArchivosporEntidades();
        cargarArchivosporEntidad();

    }

    public List<SelectItem> getLstItemsSecEstructura() {
        return lstItemsSecEstructura;
    }

    public void setLstItemsSecEstructura(List<SelectItem> lstItemsSecEstructura) {
        this.lstItemsSecEstructura = lstItemsSecEstructura;
    }

    public List<SelectItem> getLstItemsEntidad() {
        return lstItemsEntidad;
    }

    public void setLstItemsEntidad(List<SelectItem> lstItemsEntidad) {
        this.lstItemsEntidad = lstItemsEntidad;
    }

    public List<SelectItem> getLstItemsPeriodo() {
        return lstItemsPeriodo;
    }

    public void setLstItemsPeriodo(List<SelectItem> lstItemsPeriodo) {
        this.lstItemsPeriodo = lstItemsPeriodo;
    }

    @Override
    public Integer getIntSectorAdSel() {
        return intSectorAdSel;
    }

    @Override
    public void setIntSectorAdSel(Integer intSectorAdSel) {
        this.intSectorAdSel = intSectorAdSel;
    }

    public List<SelectItem> getLstItemsSecAdmin() {
        return lstItemsSecAdmin;
    }

    public void setLstItemsSecAdmin(List<SelectItem> lstItemsSecAdmin) {
        this.lstItemsSecAdmin = lstItemsSecAdmin;
    }

    public Integer getIntArchivoXCpcIdSel() {
        return intArchivoXCpcIdSel;
    }

//    public Integer getIntArchivoSel() {
//        return intArchivoXCpcIdSel;
//    }
    /**
     * @param intArchivoXCpcIdSel the intArchivoXCpcIdSel to set
     */
    public void setIntArchivoXCpcIdSel(Integer intArchivoXCpcIdSel) {
        this.intArchivoXCpcIdSel = intArchivoXCpcIdSel;
    }

//    public void setIntArchivoPlaSel(Integer intArchivoPlaSel) {
//        this.intArchivoPlaSel = intArchivoPlaSel;
//    }
    public List<SelectItem> getLstItemsArchivo() {
        return lstItemsArchivo;
    }

    public void setLstItemsArchivo(List<SelectItem> lstItemsArchivo) {
        this.lstItemsArchivo = lstItemsArchivo;
    }

    @Override
    public void limpiarVariables() {

        intSectorAdSel = -1;
        intSectorEsSel = -1;
        strEntIdSel = "-1";
        strUnidadEjecSel = "-1";
        intArchivoXCpcIdSel = -1;
        lgregPeriodo = null;
        mensaje = "";
        sr = new SysRegistrocarga();

    }

    @Override
    public void navegacionLateral_ActionEvent(ActionEvent ae) {
    }

    @Override
    public boolean validarFormulario() {
        return true;
    }

    /**
     * @return the sysInformeSel
     */
    public SysInforme getSysInformeSel() {
        return sysInformeSel;
    }

    /**
     * @param sysInformeSel the sysInformeSel to set
     */
    public void setSysInformeSel(SysInforme sysInformeSel) {
        this.sysInformeSel = sysInformeSel;
    }

    /**
     * @return the lstTablaSysInforme
     */
    public List<TablaSysInforme> getLstTablaSysInforme() {
        return lstTablaSysInforme;
    }

    /**
     * @param lstTablaSysInforme the lstTablaSysInforme to set
     */
    public void setLstTablaSysInforme(List<TablaSysInforme> lstTablaSysInforme) {
        this.lstTablaSysInforme = lstTablaSysInforme;
    }

    /**
     * @return the lstItemsUnidEjecutora
     */
    public List<SelectItem> getLstItemsUnidEjecutora() {
        return lstItemsUnidEjecutora;
    }

    public String getNavegacion() {
        return navegacion;
    }

    public void setNavegacion(String navegacion) {
        this.navegacion = navegacion;
    }

    /**
     * @param lstItemsUnidEjecutora the lstItemsUnidEjecutora to set
     */
    public void setLstItemsUnidEjecutora(List<SelectItem> lstItemsUnidEjecutora) {
        this.lstItemsUnidEjecutora = lstItemsUnidEjecutora;
    }

    /**
     * @return the lstTablaSysArchivosporEntidades
     */
    public List<TablaSysArchivosporEntidades> getLstTablaSysArchivosporEntidades() {
        return lstTablaSysArchivosporEntidades;
    }

    /**
     * @param lstTablaThmArchivosporEntidades the
     * lstTablaSysArchivosporEntidades to set
     */
    public void setLstTablaSysArchivosporEntidades(List<TablaSysArchivosporEntidades> lstTablaThmArchivosporEntidades) {
        this.lstTablaSysArchivosporEntidades = lstTablaThmArchivosporEntidades;
    }

    /**
     * @return the intArchivoXArcIdSel
     */
    public Integer getIntArchivoXArcIdSel() {
        return intArchivoXArcIdSel;
    }

    /**
     * @param intArchivoXArcIdSel the intArchivoXArcIdSel to set
     */
    public void setIntArchivoXArcIdSel(Integer intArchivoXArcIdSel) {
        this.intArchivoXArcIdSel = intArchivoXArcIdSel;
    }
    /**
     * @return the strUnidadEjecSel
     */
}
