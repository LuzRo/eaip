/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veeduria.dosfases.jsf;

import com.veeduria.adm.dao.AdmAjustexvalidacion;
import com.veeduria.adm.dao.AdmLoginconsistencias;
import com.veeduria.cnt.dao.CntPlancuetagastos;
import com.veeduria.pre.dao.PreAccionincgasto;
import com.veeduria.pre.dao.PreCmgastoinconsistencia;
import com.veeduria.pre.dao.PreCmgastoinicial;
import com.veeduria.sys.dao.SysRegistrocarga;
import com.veeduria.web.base.TablaPlanCG;
import com.veeduria.web.base.TablaSysRegistroCarga;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Named;
//import mondrian.spi.Dialect;
import org.joda.time.DateTime;
import org.joda.time.DateTimeFieldType;

/**
 *
 * @author luz
 */
@SessionScoped
@Named
public class InconsPrespJSFBean extends ProcCargadosFasesBase {

    //<editor-fold defaultstate="collapsed" desc="Variables">
    private List<TablaAjuXVal> lstTablaAjuXVals = new ArrayList<>();
    private TablaAjuXVal tablaAjuXValSel = new TablaAjuXVal();
    private List<TablaSysRegistroCarga> lstTablaSysRegistroCarga = new ArrayList<>();
    private TablaSysRegistroCarga tablaSysRegistroCargaSel = new TablaSysRegistroCarga();
    private List<TablaSysRegistroCarga> lstTablaSysRegCargLog = new ArrayList<>();
    private TablaSysRegistroCarga tablaSysRegCargLogSel = new TablaSysRegistroCarga();

    private List<TablaPrecmgastoinconsistencia> lstTablapcginc = new ArrayList<>();
    private TablaPrecmgastoinconsistencia tablapcgincSel = new TablaPrecmgastoinconsistencia();
    private String strNombrearchivo;
    private List<TablaLogIncons> lstTablaLogIncons = new ArrayList<>();
    private TablaLogIncons tablaLogInconsSel = new TablaLogIncons();

    private List<TablaPlanCG> lstTablaPlanCG = new ArrayList<>();
    private TablaPlanCG tablaPlanCGSel = new TablaPlanCG();
    private String strNomCuentaBusc;
    private Long intAjuId;
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Eventos">
    public void rowDtnconsXArch_ActionEvent(ActionEvent ae) {
        tablapcgincSel = (TablaPrecmgastoinconsistencia) ae.getComponent().getAttributes().get("tablapcgincSel");
        resaltarFilaTabla(lstTablapcginc, tablapcgincSel);
        cargarAjustXInc();
    }

    public void rowDtAjuxval_AE(ActionEvent ae) {
        tablaAjuXValSel = (TablaAjuXVal) ae.getComponent().getAttributes().get("tablaAjuXValSel");
        resaltarFilaTabla(lstTablaAjuXVals, tablaAjuXValSel);

    }

    public void rowDtArchIncons_ActionEvent(ActionEvent ae) {
        tablaSysRegistroCargaSel = (TablaSysRegistroCarga) ae.getComponent().getAttributes().get("tablaSysRegistroCargaSel");
        resaltarFilaTabla(lstTablaSysRegistroCarga, tablaSysRegistroCargaSel);
        cargarTblGasInc();
        limpiarTablaAjusteXVal();
    }

    public void btnDtAjuxvalAplicar_AE(ActionEvent ae) {
        List<AdmLoginconsistencias> lstLogIncGrabar
                = lstTablaAjuXVals.stream().filter((taxv) -> (taxv.isSeleccionado())).map((taxv) -> {
                    AdmLoginconsistencias al = new AdmLoginconsistencias();
                    al.setAvaId(taxv.getAjxval());
                    al.setFrnId(getAdministracionJSFBean().getSysfuncionario());
                    al.setGerId(tablapcgincSel.getPrecmgastoinconsistencia());
                    al.setLogFechaproceso(new Date());
                    al.setLogAplicado(Boolean.FALSE);
                    return al;
                }).collect(Collectors.toList());
        if (!lstLogIncGrabar.isEmpty()) {
            cdfsfb.grabarLstLogIncnsGasto(lstLogIncGrabar);
        }

    }

    //<editor-fold defaultstate="collapsed" desc="Gestion inconsistencias">
    public void btnHomologarCuanta_AE(ActionEvent ae) {
        PreAccionincgasto pa = new PreAccionincgasto();
        pa.setLogId(tablaLogInconsSel.getAl());
        pa.setAidCodcntorg(tablaLogInconsSel.getAl().getGerId().getGinId().getGinCodcuenta());
        pa.setAidCodcnthomlogado(tablaPlanCGSel.getCntPCG().getPcoNumcuenta());
        cdfsfb.grabarHomolgacionGasto(pa);
        tablaLogInconsSel.getAl().setLogAplicado(Boolean.TRUE);
        cdfsfb.editarLogIncGasto(tablaLogInconsSel.getAl());
        cargarLogIncXSrc();
        

    }

    public void btnAgregarCuanta_AE(ActionEvent ae) {

    }

    public void btnAjustarCodCuanta_AE(ActionEvent ae) {

    }

    public void txtBuscarCntG_VCE(ValueChangeEvent vce) {
        strNomCuentaBusc = (String) vce.getNewValue();
        lstTablaPlanCG.clear();
        cdfsfb.getLstPCGXCuentaXNombre(strNomCuentaBusc).stream().map((e -> {
            return new TablaPlanCG(e);
        })).forEach(lstTablaPlanCG::add);

    }

    public void rowDtPlanCG_AE(ActionEvent ae) {
        tablaPlanCGSel = (TablaPlanCG) ae.getComponent().getAttributes().get("tablaPlanCGSel");
    }

    public void rowDtArchInconsLog_ActionEvent(ActionEvent ae) {
        tablaSysRegCargLogSel = (TablaSysRegistroCarga) ae.getComponent().getAttributes().get("tablaSysRegCargLogSel");
        resaltarFilaTabla(lstTablaSysRegCargLog, tablaSysRegCargLogSel);
        cargarLogIncXSrc();
    }

    public void rowDtLogInc_AE(ActionEvent ae) {
        tablaLogInconsSel = (TablaLogIncons) ae.getComponent().getAttributes().get("tablaLogInconsSel");
        intAjuId = tablaLogInconsSel.getAl().getAvaId().getAjuId().getAjuId();
        //intAjuId = cdfsfb.getAdmDefAjXInc(tablaLogInconsSel.getAl().getLogId()).getAjuId();
        resaltarFilaTabla(lstTablaLogIncons, tablaLogInconsSel);
        cargarPlanCGXInc();
    }

    private void cargarPlanCGXInc() {
        lstTablaPlanCG.clear();
        PreCmgastoinicial pc = tablaLogInconsSel.getAl().getGerId().getGinId();
        SysRegistrocarga src = tablaLogInconsSel.getAl().getGerId().getGinId().getLgregId();
        DateTime dtPeriodo = new DateTime(src.getLgregPeriodo());
        cdfsfb.getLstPCGXCuentaXVig(pc.getGinCodcuenta(),
                dtPeriodo.get(DateTimeFieldType.year())).
                stream().
                map((e -> {
                    return new TablaPlanCG(e);
                })).forEach(lstTablaPlanCG::add);

    }

    private void cargarSRCConLogInc() {

        lstTablaSysRegCargLog = cdfsfb.getLstSRCConLogInc(Boolean.FALSE).stream().
                map(e -> new TablaSysRegistroCarga(e)).
                collect(Collectors.toList());

    }

    public void cargarLogIncXSrc() {
        lstTablaLogIncons = cdfsfb.
                getLstAdlLogInc(tablaSysRegCargLogSel.getSysRegistrocarga().getLgregId(), Boolean.FALSE).
                stream().
                map(e -> new TablaLogIncons(e)).
                collect(Collectors.toList());

    }

//</editor-fold>
//</editor-fold>
    @Override
    public void init() {
        numPanel = 1;
        cdfsfb = lookupCargadosfasesSFBeanBean();
        cargarArchConInc();
    }

    @Override
    public void limpiarVariables() {
        cdfsfb.remove();
    }

    @Override
    public void navegacionLateral_ActionEvent(ActionEvent ae) {
        numPanel = Integer.parseInt(String.valueOf(ae.getComponent().getAttributes().get("numPanel")));
        switch (numPanel) {
            case 4:
                cargarSRCConLogInc();
                break;
        }

    }

    @Override
    public boolean validarFormulario() {
        return true;
    }

    private void cargarArchConInc() {
        lstTablaSysRegistroCarga.clear();
        cdfsfb.getLstSRCXValidado(Boolean.TRUE).stream().map((e -> {
            return new TablaSysRegistroCarga(e);
        })).forEach(lstTablaSysRegistroCarga::add);

    }

    private void cargarAjustXInc() {
        lstTablaAjuXVals.clear();
        cdfsfb.getLstAjxval(tablapcgincSel.getPrecmgastoinconsistencia().getValId().getValId()).
                stream().
                map((e -> {
                    return new TablaAjuXVal(e);
                })).forEach(lstTablaAjuXVals::add);

    }

    private void cargarTblGasInc() {

        lstTablapcginc.clear();

        cdfsfb.getLstInconsistenciasxArchivo(tablaSysRegistroCargaSel.getSysRegistrocarga().getLgregId()).
                stream().
                map((gi) -> {
                    TablaPrecmgastoinconsistencia tpgi = new TablaPrecmgastoinconsistencia(gi);
                    DateTime dt = new DateTime(gi.getGinId().getLgregId().getLgregPeriodo());
                    cdfsfb.getLstPCGXCuentaXVig(gi.getGinId().getGinCodcuenta(), dt.get(DateTimeFieldType.year())).
                    stream().
                    map((cp -> {
                        return new TablaPlanCG(cp);
                    })).
                    forEach((tpgi.getLstTpcg()::add));

                    return tpgi;
                }).forEach(lstTablapcginc::add);
    }

    private void cargarDetInconsistencia() {
        lstTablapcginc.clear();
        cdfsfb.getDetporInconsistencia(strDetalleIncons).
                stream().
                map((gi -> {
                    TablaPrecmgastoinconsistencia tpgi = new TablaPrecmgastoinconsistencia(gi);
                    DateTime dt = new DateTime(gi.getGinId().getLgregId().getLgregPeriodo());
                    cdfsfb.getLstPCGXCuentaXVig(gi.getGinId().getGinCodcuenta(), dt.get(DateTimeFieldType.year())).
                    stream().
                    map((cp -> {
                        return new TablaPlanCG(cp);
                    })).forEach(tpgi.getLstTpcg()::add);

                    return tpgi;
                })).forEach(lstTablapcginc::add);

//        cdfsfb.getDetporInconsistencia(strDetalleIncons).stream().map((gi) -> {
//            TablaPrecmgastoinconsistencia tpgi = new TablaPrecmgastoinconsistencia(gi);
//            DateTime dt = new DateTime(gi.getGinId().getLgregId().getLgregPeriodo());
//            for (CntPlancuetagastos cp : cdfsfb.getLstPCGXCuentaXVig(gi.getGinId().getGinCodcuenta(), dt.get(DateTimeFieldType.year()))) {
//                tpgi.getLstTpcg().add(new TablaPlanCG(cp));
//            }
//            return gi;
//        }).forEach((gi) -> {
//            lstTablapcginc.add(new TablaPrecmgastoinconsistencia(gi));
//        });
    }

    public void ddlDetporArchivo_ValueChange(ValueChangeEvent vce) {
        strDetalleIncons = (String) vce.getNewValue();
        if (strDetalleIncons != null && !strDetalleIncons.equals("-1")) {
            cargarDetInconsistencia();
        }
    }

    private void limpiarTablaAjusteXVal() {
        lstTablaAjuXVals.clear();
    }

    //<editor-fold defaultstate="collapsed" desc="Propiedades">
    /**
     * @return the lstTablapcginc
     */
    public List<TablaPrecmgastoinconsistencia> getLstTablapcginc() {
        return lstTablapcginc;
    }

    /**
     * @param lstTablapcginc the lstTablapcginc to set
     */
    public void setLstTablapcginc(List<TablaPrecmgastoinconsistencia> lstTablapcginc) {
        this.lstTablapcginc = lstTablapcginc;
    }

    /**
     * @return the strNombrearchivo
     */
    public String getStrNombrearchivo() {
        return strNombrearchivo;
    }

    /**
     * @param strNombrearchivo the strNombrearchivo to set
     */
    public void setStrNombrearchivo(String strNombrearchivo) {
        this.strNombrearchivo = strNombrearchivo;
    }

    /**
     * @return the lstTablaSysRegistroCarga
     */
    public List<TablaSysRegistroCarga> getLstTablaSysRegistroCarga() {
        return lstTablaSysRegistroCarga;
    }

    /**
     * @param lstTablaSysRegistroCarga the lstTablaSysRegistroCarga to set
     */
    public void setLstTablaSysRegistroCarga(List<TablaSysRegistroCarga> lstTablaSysRegistroCarga) {
        this.lstTablaSysRegistroCarga = lstTablaSysRegistroCarga;
    }

    /**
     * @return the tablaSysRegistroCargaSel
     */
    public TablaSysRegistroCarga getTablaSysRegistroCargaSel() {
        return tablaSysRegistroCargaSel;
    }

    /**
     * @param tablaSysRegistroCargaSel the tablaSysRegistroCargaSel to set
     */
    public void setTablaSysRegistroCargaSel(TablaSysRegistroCarga tablaSysRegistroCargaSel) {
        this.tablaSysRegistroCargaSel = tablaSysRegistroCargaSel;
    }

    /**
     * @return the tablapcgincSel
     */
    public TablaPrecmgastoinconsistencia getTablapcgincSel() {
        return tablapcgincSel;
    }

    /**
     * @param tablapcgincSel the tablapcgincSel to set
     */
    public void setTablapcgincSel(TablaPrecmgastoinconsistencia tablapcgincSel) {
        this.tablapcgincSel = tablapcgincSel;
    }

    //</editor-fold>
    /**
     * @return the lstTablaAjuXVals
     */
    public List<TablaAjuXVal> getLstTablaAjuXVals() {
        return lstTablaAjuXVals;
    }

    /**
     * @param lstTablaAjuXVals the lstTablaAjuXVals to set
     */
    public void setLstTablaAjuXVals(List<TablaAjuXVal> lstTablaAjuXVals) {
        this.lstTablaAjuXVals = lstTablaAjuXVals;
    }

    /**
     * @return the tablaAjuXValSel
     */
    public TablaAjuXVal getTablaAjuXValSel() {
        return tablaAjuXValSel;
    }

    /**
     * @param tablaAjuXValSel the tablaAjuXValSel to set
     */
    public void setTablaAjuXValSel(TablaAjuXVal tablaAjuXValSel) {
        this.tablaAjuXValSel = tablaAjuXValSel;
    }

    /**
     * @return the lstTablaLogIncons
     */
    public List<TablaLogIncons> getLstTablaLogIncons() {
        return lstTablaLogIncons;
    }

    /**
     * @param lstTablaLogIncons the lstTablaLogIncons to set
     */
    public void setLstTablaLogIncons(List<TablaLogIncons> lstTablaLogIncons) {
        this.lstTablaLogIncons = lstTablaLogIncons;
    }

    /**
     * @return the tablaLogInconsSel
     */
    public TablaLogIncons getTablaLogInconsSel() {
        return tablaLogInconsSel;
    }

    /**
     * @param tablaLogInconsSel the tablaLogInconsSel to set
     */
    public void setTablaLogInconsSel(TablaLogIncons tablaLogInconsSel) {
        this.tablaLogInconsSel = tablaLogInconsSel;
    }

    /**
     * @return the lstTablaSysRegCargLog
     */
    public List<TablaSysRegistroCarga> getLstTablaSysRegCargLog() {
        return lstTablaSysRegCargLog;
    }

    /**
     * @param lstTablaSysRegCargLog the lstTablaSysRegCargLog to set
     */
    public void setLstTablaSysRegCargLog(List<TablaSysRegistroCarga> lstTablaSysRegCargLog) {
        this.lstTablaSysRegCargLog = lstTablaSysRegCargLog;
    }

    /**
     * @return the tablaSysRegCargLogSel
     */
    public TablaSysRegistroCarga getTablaSysRegCargLogSel() {
        return tablaSysRegCargLogSel;
    }

    /**
     * @param tablaSysRegCargLogSel the tablaSysRegCargLogSel to set
     */
    public void setTablaSysRegCargLogSel(TablaSysRegistroCarga tablaSysRegCargLogSel) {
        this.tablaSysRegCargLogSel = tablaSysRegCargLogSel;
    }

    /**
     * @return the lstTablaPlanCG
     */
    public List<TablaPlanCG> getLstTablaPlanCG() {
        return lstTablaPlanCG;
    }

    /**
     * @param lstTablaPlanCG the lstTablaPlanCG to set
     */
    public void setLstTablaPlanCG(List<TablaPlanCG> lstTablaPlanCG) {
        this.lstTablaPlanCG = lstTablaPlanCG;
    }

    /**
     * @return the tablaPlanCGSel
     */
    public TablaPlanCG getTablaPlanCGSel() {
        return tablaPlanCGSel;
    }

    /**
     * @param tablaPlanCGSel the tablaPlanCGSel to set
     */
    public void setTablaPlanCGSel(TablaPlanCG tablaPlanCGSel) {
        this.tablaPlanCGSel = tablaPlanCGSel;
    }

    /**
     * @return the strNomCuentaBusc
     */
    public String getStrNomCuentaBusc() {
        return strNomCuentaBusc;
    }

    /**
     * @param strNomCuentaBusc the strNomCuentaBusc to set
     */
    public void setStrNomCuentaBusc(String strNomCuentaBusc) {
        this.strNomCuentaBusc = strNomCuentaBusc;
    }

    /**
     * @return the intAjuId
     */
    public Long getIntAjuId() {
        return intAjuId;
    }

    /**
     * @param intAjuId the intAjuId to set
     */
    public void setIntAjuId(Long intAjuId) {
        this.intAjuId = intAjuId;
    }

}
