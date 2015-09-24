/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veeduria.reportes.jsf;

//import com.icesoft.faces.context.Resource;
import com.veeduria.adm.AdmsistemaSLBean;
import com.veeduria.adm.dao.AdmComponenteproceso;
import com.veeduria.adm.dao.AdmEntidad;
//import com.veeduria.adm.dao.AdmComponenteproceso;
import com.veeduria.adm.dao.AdmSectoradmin;
import com.veeduria.adm.dao.AdmSectorestruc;
import com.veeduria.adm.dao.AdmUnidadejec;
import com.veeduria.web.base.BaseJSFBean;
import com.veeduria.web.base.TablaAdmEntidad;
import com.veeduria.web.base.TablaSectorAdm;
import com.veeduria.web.cargaarchivo.jsf.CMPrepJSFBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.inject.Named;

/**
 *
 * @author luz
 */
@SessionScoped
@Named
public class ReportesProcesosJSFBean extends BaseJSFBean implements Serializable {

    @EJB
    private AdmsistemaSLBean aslb;
    private CMPrepJSFBean cmpjb;
    private List<TablaInforme> lstTablaInformes = new ArrayList<>();
    private TablaInforme tablaInformeSel = new TablaInforme();

    private Integer IntProcesoSel;
    /**
     * Ruta donde se almacenan los reportes
     */
    private ExternalContext ec = fc.getExternalContext();
    private Integer intTipoRep = 1;

    private List<SelectItem> lstInformes = new ArrayList<>();
    private List<SelectItem> lstSectorEstr = new ArrayList<>();
    private List<SelectItem> lstUnidadxEntidad = new ArrayList<>();
    private List<SelectItem> lstItemsEntidad = new ArrayList<>();
    private List<SelectItem> lstItemsEntidadSel = new ArrayList<>();

    private Integer intSectorEstr = -1;
    private List<SelectItem> lstSectorAdm = new ArrayList<>();
    private Integer intSectorAdm = -1;
    private Date fecha_ini;
    private Date fecha_fin;
    //private Integer ano = -1;
    private Integer intMes;
    private Integer intAño;
    private Integer intAñoInicial;
    private Integer intAñoFinal;
    private Integer intInfid;
    private String strNominforme;
    private String strEntsel;
    private String strEntNomsel;
    private String strUnidadEjecSel = "-1";
    protected List<SelectItem> lstItemsUnidEjecutora = new ArrayList<>();
    private Boolean blnMostrarSectorEstr = false;
    private Boolean blnMostrarSectorAdm = false;
    private Boolean blnMostrarUniEjecxEntidad = false;
    private Long lngUniXEnt = -1L;
    //protected com.icesoft.faces.context.Resource jrExcelPresupuesto;

    //<editor-fold defaultstate="collapsed" desc="Planeación">
    private List<SelectItem> lstItemsAdmComp = new ArrayList<>();
    private List<SelectItem> lstItemsSectorEstruc = new ArrayList<>();
    private Integer proIdSel;
    private Integer comIdSel;
    private List<TablaSectorAdm> lstTablaSectorAdms = new ArrayList<>();
    private List<TablaAdmEntidad> lstTablaAdmEntidad = new ArrayList<>();
    private TablaSectorAdm tablaSectorAdmSel = new TablaSectorAdm();
    private TablaAdmEntidad tablaAdmEntidadSel = new TablaAdmEntidad();
//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Presupuesto">

    private List<SelectItem> lstItemsSysCompxFrecxInf = new ArrayList<>();
    private List<SelectItem> lstItemsSysInfFrecuencia = new ArrayList<>();
    private String strFrecuenciaSel;
//</editor-fold>

    private String strTituloInf = "";

    public ReportesProcesosJSFBean() {
    }

    //<editor-fold defaultstate="collapsed" desc="Metodos del Bean">
    @Override
    public void init() {
        numPanel = 1;

        cargarSectores();
        cargarEntidad();
        cargarSectoradm();
        cargarUnidadEjec();

        switch (numPanel) {
            case 1:
                proIdSel = 1;
                cargarCompProc();
                cargarSectoradm();
                cargarEntidad();
                cargarInfXCompXFrecuencia();
                break;
            case 2:
                cargarDetTablaInfXIdComp();
                break;
            case 3:
                proIdSel = 5;
                cargarCompProc();
                cargarSectoradm();
                cargarDetTablaInfXIdComp();
                break;
            case 4:
                cargarDetTablaInf();
        }

        //strPagId = getPrincipalJSFBean().getNavegacion();
//        setStrPagId(getAdministracionJSFBean().getNavegacion());
//        lstSectorEstr.clear();
//        intSectorEstr = -1;
//        lstSectorAdm.clear();
//        intSectorAdm = -1;
//        blnMostrarSectorEstr = false;
//        blnMostrarSectorAdm = false;
//        blnMostrarUniEjecxEntidad = false;
//        lngUniXEnt = -1L;
//        lstUnidadxEntidad.clear();
////        cargarReportesProceso();
//        cmpjsb.cargarEntidadXSectoresXSectorad();
//        cmpjsb.cargarUnidadEjecxEntidad();
    }

    @Override
    public void limpiarVariables() {
        lstSectorEstr.clear();
        intSectorEstr = -1;
        lstSectorAdm.clear();
        intSectorAdm = -1;
        strUnidadEjecSel = "-1";
        strFrecuenciaSel = "-1";
        comIdSel = -1;
        fecha_ini = null;
        fecha_fin = null;
        intAño = -1;
        intMes = -1;
        //jrExcelPresupuesto = null;
        blnMostrarSectorEstr = false;
        blnMostrarSectorAdm = false;
        blnMostrarUniEjecxEntidad = false;
        lngUniXEnt = -1L;
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Procedimientos y Funciones">
    //<editor-fold defaultstate="collapsed" desc="Presupuesto">
    private void cargarDetTablaInfXFrecuencia() {
        lstTablaInformes = aslb.getDetporFrecuencia(strFrecuenciaSel).stream().map((e -> {
            return new TablaInforme(e);
        })).collect(Collectors.toList());
    }

    private void cargarDetTablaInfXIdComp() {
        lstTablaInformes = aslb.getLstSysInfXComp(comIdSel).stream().map((e -> {
            return new TablaInforme(e);
        })).collect(Collectors.toList());

    }

    private void cargarInfXCompXFrecuencia() {
        lstTablaInformes = aslb.getLstInformeporCompXFrecuencia(comIdSel, strFrecuenciaSel).stream().map((e -> {
            return new TablaInforme(e);
        })).collect(Collectors.toList());

    }

//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Planeación">
    private void cargarCompProc() {
        lstItemsAdmComp.clear();
        lstItemsAdmComp.add(itemSeleccioneInt);
        for (AdmComponenteproceso ac : aslb.getLstCompProcXProceso(proIdSel)) {
            lstItemsAdmComp.add(new SelectItem(ac.getComId(), ac.getComNombre()));
        }
    }
//</editor-fold>

    private void cargarTablaInf() {
        lstTablaInformes = aslb.getLstInformeporNumpanel(numPanel).
                stream().
                map((e -> {
                    return new TablaInforme(e);
                })).collect(Collectors.toList());

    }

    private void cargarSectoradm() {
        lstSectorAdm.clear();
        lstSectorAdm.add(itemSeleccioneInt);
        lstTablaSectorAdms.clear();
        for (AdmSectoradmin sa : aslb.getLstSectoradmin()) {
            lstSectorAdm.add(new SelectItem(sa.getSadId(), sa.getSadNombre()));
            lstTablaSectorAdms.add(new TablaSectorAdm(sa));
        }

    }

    private void cargarEntidad() {

        lstItemsEntidadSel.clear();
        lstItemsEntidadSel.add(itemSeleccioneStr);
        lstTablaAdmEntidad.clear();
        for (AdmEntidad ae : aslb.getLstEnt()) {
            lstItemsEntidadSel.add(new SelectItem(ae.getEntNombre()));
            lstTablaAdmEntidad.add(new TablaAdmEntidad(ae));
        }

    }

    private void cargarSectores() {

        lstSectorEstr.clear();
        lstSectorEstr.add(itemSeleccioneInt);
        for (AdmSectorestruc se : aslb.getLstSectorestrucs()) {
            lstSectorEstr.add(new SelectItem(se.getSesId(), se.getSesNombre()));
        }

    }

    private void cargarUnidadEjec() {

        lstItemsUnidEjecutora.clear();
        lstItemsUnidEjecutora.add(itemSeleccioneStr);
        for (AdmUnidadejec ue : aslb.getLstUnidadEjec()) {

            lstItemsUnidEjecutora.add(new SelectItem(ue.getEjeCodigo(), ue.getEjeNombre()));
        }
    }

    private void cargarDetTablaInf() {
        lstTablaInformes = aslb.getDetporNominforme(strNominforme).stream().map((e -> {
            return new TablaInforme(e);
        })).collect(Collectors.toList());

    }

    public void cargarEntidadXSectoresXSectorad() {

        lstItemsEntidad.clear();
        lstItemsEntidad.add(new SelectItem("-1", "Seleccione"));
        for (AdmEntidad aa : aslb.getLstEntxSexSa(intSectorEstr, intSectorAdm)) {
            lstItemsEntidad.add(new SelectItem(aa.getEntId(), aa.getEntNombre()));
//            lstItemsEntidad.clear();

        }

    }

    public void rowDtInformeSel_ActionEvent(ActionEvent ae) {
        tablaInformeSel = (TablaInforme) ae.getComponent().getAttributes().get("tablaInformeSel");
        resaltarFilaTabla(lstTablaInformes, tablaInformeSel);

        // jrExcelPresupuesto = genInfRecurso(null, tablaInformeSel.getSysInforme(), 1);
    }

    public void btnGenInforme_Action(ActionEvent ae) {
        HashMap hm = new HashMap();

        switch (numPanel) {
            case 2:
                switch (comIdSel) {
                    case 4:
                        hm.put("p_sad_id", tablaSectorAdmSel.getAs().getSadCodsegplan());
                        hm.put("p_trimestre", intMes);
                        hm.put("p_ano_prog_repr", intAño);
                        break;
                    case 8:
                        hm.put("p_sad_id", tablaSectorAdmSel.getAs().getSadId());
                        hm.put("p_ses_id", 3);
                        hm.put("p_mes", intMes);
                        hm.put("p_ano", intAño);
                        hm.put("p_nombsector", tablaSectorAdmSel.getAs().getSadNombre());
                        hm.put("p_ses_nombre", "CENTRAL Y DESCENTRALIZADO");
                        break;
                }
                break;
            case 1:
                switch (strFrecuenciaSel) {
                    case ("Anual"):
                        hm.put("p_ent_id", tablaAdmEntidadSel.getAs().getEntId());
                        hm.put("p_mes", intMes);
                        hm.put("p_ano_inicial", intAñoInicial);
                        hm.put("p_ano_final", intAñoFinal);
                        hm.put("p_ent_nombre", tablaAdmEntidadSel.getAs().getEntNombre());
                        break;
                    case ("Mensual"):
                        hm.put("p_ent_id", tablaAdmEntidadSel.getAs().getEntId());
                        hm.put("p_ano", intAño);
                        hm.put("p_ent_nombre", tablaAdmEntidadSel.getAs().getEntNombre());
                        break;

                }
                break;
            case 3:
                hm.put("p_sad_id", tablaSectorAdmSel.getAs().getSadId());
                break;
            case 4:
                hm.put("p_fecha_ini", fecha_ini);
                hm.put("p_fecha_fin", fecha_fin);
                break;

        }
        irAServletDescarga(genInfRecurso(hm, tablaInformeSel.getSysInforme(), 5));
    }

    public void ddlDetporInforme_ValueChange(ValueChangeEvent vce) {

        strNominforme = (String) vce.getNewValue();
        if (strNominforme != null && !strNominforme.equals("-1")) {

            cargarDetTablaInf();
        }

    }

    public void ddlDetInfporFrecuencia_ValueChange(ValueChangeEvent vce) {
        strFrecuenciaSel = (String) vce.getNewValue();
        if (strFrecuenciaSel != null && !strFrecuenciaSel.equals("-1")) {
            cargarDetTablaInfXFrecuencia();
        }
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Eventos">
    //<editor-fold defaultstate="collapsed" desc="Planeacion">
    public void rowDtSectAdmSel_ActionEvent(ActionEvent ae) {
        tablaSectorAdmSel = (TablaSectorAdm) ae.getComponent().getAttributes().get("tablaSectorAdmSel");
        resaltarFilaTabla(lstTablaSectorAdms, tablaSectorAdmSel);
    }

    public void ddlCompSel_VCE(ValueChangeEvent vce) {
        comIdSel = (Integer) vce.getNewValue();
        cargarDetTablaInfXIdComp();
    }

//    public void ddlCompoSel_VCE(ValueChangeEvent vce) {
//        comIdSel = (Integer) vce.getNewValue();
//        cargarInfXCompXFrecuencia();
//
//    }
//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Presupuesto">
    public void rowDtAdmEntidadSel_ActionEvent(ActionEvent ae) {
        tablaAdmEntidadSel = (TablaAdmEntidad) ae.getComponent().getAttributes().get("tablaAdmEntidadSel");
        resaltarFilaTabla(lstTablaAdmEntidad, tablaAdmEntidadSel);
    }

    public void ddlSectorAd_ValueChange(ValueChangeEvent vce) {

        intSectorAdm = (Integer) vce.getNewValue();
        if (intSectorAdm != -1 && intSectorEstr != -1) {

            cargarEntidadXSectoresXSectorad();

        }

    }

    public void ddlDetFrecSel_VCE(ValueChangeEvent vce) {
        strFrecuenciaSel = (String) vce.getNewValue();
        if (strFrecuenciaSel.equals("1") || strFrecuenciaSel.equals("-1")) {
            cargarDetTablaInfXIdComp();
        } else {
            cargarInfXCompXFrecuencia();
        }

    }

    //</editor-fold>
    //</editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Propiedades">
    public List<SelectItem> getLstSectorEstr() {
        return lstSectorEstr;
    }

    public void setLstSectorEstr(List<SelectItem> lstSectorEstr) {
        this.lstSectorEstr = lstSectorEstr;
    }

    /**
     * @return the lstSectorAdm
     */
    public List<SelectItem> getLstSectorAdm() {
        return lstSectorAdm;
    }

    /**
     * @param lstSectorAdm the lstSectorAdm to set
     */
    public void setLstSectorAdm(List<SelectItem> lstSectorAdm) {
        this.lstSectorAdm = lstSectorAdm;
    }

    /**
     * @return the intSectorEstr
     */
    public Integer getIntSectorEstr() {
        return intSectorEstr;
    }

    /**
     * @param intSectorEstr the intSectorEstr to set
     */
    public void setIntSectorEstr(Integer intSectorEstr) {
        this.intSectorEstr = intSectorEstr;
    }

    /**
     * @return the intSectorAdm
     */
    public Integer getIntSectorAdm() {
        return intSectorAdm;
    }

    /**
     * @param intSectorAdm the intSectorAdm to set
     */
    public void setIntSectorAdm(Integer intSectorAdm) {
        this.intSectorAdm = intSectorAdm;
    }

    /**
     * @return the intTipoRep
     */
    public Integer getIntTipoRep() {
        return intTipoRep;
    }

    /**
     * @param intTipoRep the intTipoRep to set
     */
    public void setIntTipoRep(Integer intTipoRep) {
        this.intTipoRep = intTipoRep;
    }

    /**
     * @return the blnMostrarSectorEstr
     */
    public Boolean getBlnMostrarSectorEstr() {
        return blnMostrarSectorEstr;
    }

    /**
     * @param blnMostrarSectorEstr the blnMostrarSectorEstr to set
     */
    public void setBlnMostrarSectorEstr(Boolean blnMostrarSectorEstr) {
        this.blnMostrarSectorEstr = blnMostrarSectorEstr;
    }

    /**
     * @return the blnMostrarSectorAdm
     */
    public Boolean getBlnMostrarSectorAdm() {
        return blnMostrarSectorAdm;
    }

    /**
     * @param blnMostrarSectorAdm the blnMostrarSectorAdm to set
     */
    public void setBlnMostrarSectorAdm(Boolean blnMostrarSectorAdm) {
        this.blnMostrarSectorAdm = blnMostrarSectorAdm;
    }

    /**
     * @return the strTituloInf
     */
    public String getStrTituloInf() {
        return strTituloInf;
    }

    /**
     * @param strTituloInf the strTituloInf to set
     */
    public void setStrTituloInf(String strTituloInf) {
        this.strTituloInf = strTituloInf;
    }

    /**
     * @return the lstInformes
     */
    public List<SelectItem> getLstInformes() {
        return lstInformes;
    }

    /**
     * @param lstInformes the lstInformes to set
     */
    public void setLstInformes(List<SelectItem> lstInformes) {
        this.lstInformes = lstInformes;
    }

    /**
     * @return the strPagId
     */
    public String getStrPagId() {
        return strPagId;
    }

    /**
     * @param strPagId the strPagId to set
     */
    public void setStrPagId(String strPagId) {
        this.strPagId = strPagId;
    }

    /**
     * @return the lstUnidadxEntidad
     */
    public List<SelectItem> getLstUnidadxEntidad() {
        return lstUnidadxEntidad;
    }

    /**
     * @param lstUnidadxEntidad the lstUnidadxEntidad to set
     */
    public void setLstUnidadxEntidad(List<SelectItem> lstUnidadxEntidad) {
        this.lstUnidadxEntidad = lstUnidadxEntidad;
    }

    /**
     * @return the blnMostrarUniEjecxEntidad
     */
    public Boolean getBlnMostrarUniEjecxEntidad() {
        return blnMostrarUniEjecxEntidad;
    }

    /**
     * @param blnMostrarUniEjecxEntidad the blnMostrarUniEjecxEntidad to set
     */
    public void setBlnMostrarUniEjecxEntidad(Boolean blnMostrarUniEjecxEntidad) {
        this.blnMostrarUniEjecxEntidad = blnMostrarUniEjecxEntidad;
    }

    /**
     * @return the lngUniXEnt
     */
    public Long getLngUniXEnt() {
        return lngUniXEnt;
    }

    /**
     * @param lngUniXEnt the lngUniXEnt to set
     */
    public void setLngUniXEnt(Long lngUniXEnt) {
        this.lngUniXEnt = lngUniXEnt;
    }

    /**
     * @return the strNominforme
     */
    public String getStrNominforme() {
        return strNominforme;
    }

    /**
     * @param strNominforme the strNominforme to set
     */
    public void setStrNominforme(String strNominforme) {
        this.strNominforme = strNominforme;
    }

    //</editor-fold>
    @Override
    public void navegacionLateral_ActionEvent(ActionEvent ae) {
        numPanel = Integer.parseInt(String.valueOf(ae.getComponent().getAttributes().get("numPanel")));

        switch (numPanel) {
            case 1:
                lstTablaInformes.clear();
                proIdSel = 1;
                cargarCompProc();
                //cargarSectoradm();
                cargarInfXCompXFrecuencia();
                cargarEntidad();
                break;
            case 2:
                lstTablaInformes.clear();
                proIdSel = 3;
                cargarCompProc();
                cargarSectoradm();
                break;
            case 3:
                lstTablaInformes.clear();
                proIdSel = 5;
                cargarCompProc();
                cargarSectoradm();
//                cargarTablaInf();
            case 4:
                lstTablaInformes.clear();
                proIdSel = 8;
                cargarDetTablaInf();
        }

    }

    @Override
    public boolean validarFormulario() {
        return true;
    }

    public List<TablaInforme> getLstTablaInformes() {
        return lstTablaInformes;
    }

    /**
     * @param lstTablaInformes the lstTablaInformes to set
     */
    public void setLstTablaInformes(List<TablaInforme> lstTablaInformes) {
        this.lstTablaInformes = lstTablaInformes;
    }

    /**
     * @return the tablaInformeSel
     */
    public TablaInforme getTablaInformeSel() {
        return tablaInformeSel;
    }

    /**
     * @param tablaInformeSel the tablaInformeSel to set
     */
    public void setTablaInformeSel(TablaInforme tablaInformeSel) {
        this.tablaInformeSel = tablaInformeSel;
    }

//    public Resource getJrExcelPresupuesto() {
//        return jrExcelPresupuesto;
//    }
//
//    public void setJrExcelPresupuesto(Resource jrExcelPresupuesto) {
//        this.jrExcelPresupuesto = jrExcelPresupuesto;
//    }
    /**
     * @return the IntProcesoSel
     */
    public Integer getIntProcesoSel() {
        return IntProcesoSel;
    }

    /**
     * @param IntProcesoSel the IntProcesoSel to set
     */
    public void setIntProcesoSel(Integer IntProcesoSel) {
        this.IntProcesoSel = IntProcesoSel;
    }

    /**
     * @return the strEntsel
     */
    public String getStrEntsel() {
        return strEntsel;
    }

    /**
     * @param strEntsel the strEntsel to set
     */
    public void setStrEntsel(String strEntsel) {
        this.strEntsel = strEntsel;
    }

    /**
     * @return the fecha_ini
     */
    public Date getFecha_ini() {
        return fecha_ini;
    }

    /**
     * @param fecha_ini the fecha_ini to set
     */
    public void setFecha_ini(Date fecha_ini) {
        this.fecha_ini = fecha_ini;
    }

    /**
     * @return the fecha_fin
     */
    public Date getFecha_fin() {
        return fecha_fin;
    }

    /**
     * @param fecha_fin the fecha_fin to set
     */
    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public List<SelectItem> getLstItemsUnidEjecutora() {
        return lstItemsUnidEjecutora;
    }

    public void setLstItemsUnidEjecutora(List<SelectItem> lstItemsUnidEjecutora) {
        this.lstItemsUnidEjecutora = lstItemsUnidEjecutora;
    }

    public String getStrUnidadEjecSel() {
        return strUnidadEjecSel;
    }

    public void setStrUnidadEjecSel(String strUnidadEjecSel) {
        this.strUnidadEjecSel = strUnidadEjecSel;
    }

    /**
     * @return the intMes
     */
    public Integer getIntMes() {
        return intMes;
    }

    /**
     * @param intMes the intMes to set
     */
    public void setIntMes(Integer intMes) {
        this.intMes = intMes;
    }

    /**
     * @return the intAño
     */
    public Integer getIntAño() {
        return intAño;
    }

    /**
     * @param intAño the intAño to set
     */
    public void setIntAño(Integer intAño) {
        this.intAño = intAño;
    }

    /**
     * @return the intInfid
     */
    public Integer getIntInfid() {
        return intInfid;
    }

    /**
     * @param intInfid the intInfid to set
     */
    public void setIntInfid(Integer intInfid) {
        this.intInfid = intInfid;
    }

    public List<SelectItem> getLstItemsEntidad() {
        return lstItemsEntidad;
    }

    public void setLstItemsEntidad(List<SelectItem> lstItemsEntidad) {
        this.lstItemsEntidad = lstItemsEntidad;
    }

    /**
     * @return the lstItemsAdmComp
     */
    public List<SelectItem> getLstItemsAdmComp() {
        return lstItemsAdmComp;
    }

    /**
     * @param lstItemsAdmComp the lstItemsAdmComp to set
     */
    public void setLstItemsAdmComp(List<SelectItem> lstItemsAdmComp) {
        this.lstItemsAdmComp = lstItemsAdmComp;
    }

    /**
     * @return the proIdSel
     */
    public Integer getProIdSel() {
        return proIdSel;
    }

    /**
     * @param proIdSel the proIdSel to set
     */
    public void setProIdSel(Integer proIdSel) {
        this.proIdSel = proIdSel;
    }

    /**
     * @return the comIdSel
     */
    public Integer getComIdSel() {
        return comIdSel;
    }

    /**
     * @param comIdSel the comIdSel to set
     */
    public void setComIdSel(Integer comIdSel) {
        this.comIdSel = comIdSel;
    }

    /**
     * @return the lstTablaSectorAdms
     */
    public List<TablaSectorAdm> getLstTablaSectorAdms() {
        return lstTablaSectorAdms;
    }

    /**
     * @param lstTablaSectorAdms the lstTablaSectorAdms to set
     */
    public void setLstTablaSectorAdms(List<TablaSectorAdm> lstTablaSectorAdms) {
        this.lstTablaSectorAdms = lstTablaSectorAdms;
    }

    /**
     * @return the tablaSectorAdmSel
     */
    public TablaSectorAdm getTablaSectorAdmSel() {
        return tablaSectorAdmSel;
    }

    /**
     * @param tablaSectorAdmSel the tablaSectorAdmSel to set
     */
    public void setTablaSectorAdmSel(TablaSectorAdm tablaSectorAdmSel) {
        this.tablaSectorAdmSel = tablaSectorAdmSel;
    }

    /**
     * @return the lstItemsSectorEstruc
     */
    public List<SelectItem> getLstItemsSectorEstruc() {
        return lstItemsSectorEstruc;
    }

    /**
     * @param lstItemsSectorEstruc the lstItemsSectorEstruc to set
     */
    public void setLstItemsSectorEstruc(List<SelectItem> lstItemsSectorEstruc) {
        this.lstItemsSectorEstruc = lstItemsSectorEstruc;
    }

    /**
     * @return the lstItemsSysCompxFrecxInf
     */
    public List<SelectItem> getLstItemsSysCompxFrecxInf() {
        return lstItemsSysCompxFrecxInf;
    }

    /**
     * @param lstItemsSysCompxFrecxInf the lstItemsSysCompxFrecxInf to set
     */
    public void setLstItemsSysCompxFrecxInf(List<SelectItem> lstItemsSysCompxFrecxInf) {
        this.lstItemsSysCompxFrecxInf = lstItemsSysCompxFrecxInf;
    }

    /**
     * @return the strFrecuenciaSel
     */
    public String getStrFrecuenciaSel() {
        return strFrecuenciaSel;
    }

    /**
     * @param strFrecuenciaSel the strFrecuenciaSel to set
     */
    public void setStrFrecuenciaSel(String strFrecuenciaSel) {
        this.strFrecuenciaSel = strFrecuenciaSel;
    }

    /**
     * @return the lstItemsSysInfFrecuencia
     */
    public List<SelectItem> getLstItemsSysInfFrecuencia() {
        return lstItemsSysInfFrecuencia;
    }

    /**
     * @param lstItemsSysInfFrecuencia the lstItemsSysInfFrecuencia to set
     */
    public void setLstItemsSysInfFrecuencia(List<SelectItem> lstItemsSysInfFrecuencia) {
        this.lstItemsSysInfFrecuencia = lstItemsSysInfFrecuencia;
    }

    /**
     * @return the lstItemsEntidadSel
     */
    public List<SelectItem> getLstItemsEntidadSel() {
        return lstItemsEntidadSel;
    }

    /**
     * @param lstItemsEntidadSel the lstItemsEntidadSel to set
     */
    public void setLstItemsEntidadSel(List<SelectItem> lstItemsEntidadSel) {
        this.lstItemsEntidadSel = lstItemsEntidadSel;
    }

    /**
     * @return the strEntNomsel
     */
    public String getStrEntNomsel() {
        return strEntNomsel;
    }

    /**
     * @param strEntNomsel the strEntNomsel to set
     */
    public void setStrEntNomsel(String strEntNomsel) {
        this.strEntNomsel = strEntNomsel;
    }

    /**
     * @return the tablaAdmEntidadSel
     */
    public TablaAdmEntidad getTablaAdmEntidadSel() {
        return tablaAdmEntidadSel;
    }

    /**
     * @param tablaAdmEntidadSel the tablaAdmEntidadSel to set
     */
    public void setTablaAdmEntidadSel(TablaAdmEntidad tablaAdmEntidadSel) {
        this.tablaAdmEntidadSel = tablaAdmEntidadSel;
    }

    /**
     * @return the intAñoInicial
     */
    public Integer getIntAñoInicial() {
        return intAñoInicial;
    }

    /**
     * @param intAñoInicial the intAñoInicial to set
     */
    public void setIntAñoInicial(Integer intAñoInicial) {
        this.intAñoInicial = intAñoInicial;
    }

    /**
     * @return the intAñoFinal
     */
    public Integer getIntAñoFinal() {
        return intAñoFinal;
    }

    /**
     * @param intAñoFinal the intAñoFinal to set
     */
    public void setIntAñoFinal(Integer intAñoFinal) {
        this.intAñoFinal = intAñoFinal;
    }

    /**
     * @return the lstTablaAdmEntidad
     */
    public List<TablaAdmEntidad> getLstTablaAdmEntidad() {
        return lstTablaAdmEntidad;
    }

    /**
     * @param lstTablaAdmEntidad the lstTablaAdmEntidad to set
     */
    public void setLstTablaAdmEntidad(List<TablaAdmEntidad> lstTablaAdmEntidad) {
        this.lstTablaAdmEntidad = lstTablaAdmEntidad;
    }

}
