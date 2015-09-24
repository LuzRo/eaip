/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veeduria.web.sys.jsf;

import com.veeduria.adm.AdmsistemaSLBean;
import com.veeduria.not.dao.AdmNotificacion;
import com.veeduria.not.ejb.AdmPuntosCtrlSFBEan;
import com.veeduria.sys.dao.SysArchivo;
import com.veeduria.sys.dao.SysFuncionario;
import com.veeduria.sys.dao.SysMenuprin;
import com.veeduria.sys.dao.SysModulos;
import com.veeduria.sys.dao.SysSubmodproc;
import com.veeduria.sys.ejb.SegusrSFBean;
import com.veeduria.sys.dao.SysArchivosporentidades;
import com.veeduria.sys.ejb.CargadosfasesSFBean;
import com.veeduria.web.base.BaseJSFBean;
import com.veeduria.web.cargaarchivo.TablaSysArchivosporEntidades;
import com.veeduria.web.cargaarchivo.TablaSysArchivo;
import com.veeduria.web.cargaarchivo.jsf.CMPrepJSFBean;
import com.veeduria.web.not.TablaNotif;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.el.ExpressionFactory;
import javax.el.MethodExpression;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.MethodExpressionActionListener;
import javax.inject.Named;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.icefaces.ace.component.ajax.AjaxBehavior;
import org.icefaces.ace.component.menuitem.MenuItem;
import org.icefaces.ace.component.submenu.Submenu;
import org.icefaces.ace.model.DefaultMenuModel;
import org.icefaces.ace.model.MenuModel;
import org.icefaces.util.JavaScriptRunner;

/**
 *
 * @author luz
 */
@SessionScoped //Las instancias de esa clase van a estar en la sesion web
@Named // La clase puede ser visible por los controles del JSF, puedo identificar la clase por nombre
public class AdministracionJSFBean extends BaseJSFBean implements Serializable {

    private List<SysArchivo> lstArchivos = new ArrayList<>();
    private List<SysArchivosporentidades> lstArchivosEntidades = new ArrayList<>();
    private List<TablaSysArchivo> lstTablaSysArchivos = new ArrayList<>();
    private TablaSysArchivosporEntidades tablaThmArchivosporEntidadesSel = new TablaSysArchivosporEntidades();
    private TablaSysArchivo tablaSysArchivoSel = new TablaSysArchivo();
    private List<TablaNotif> lstTablaNotifs = new ArrayList<>();
    private TablaNotif tablaNotifSel = new TablaNotif();
    boolean renderNavegacion = false; //si la persona se logea con exito muestra el menu, de lo contrario no.
    private MenuModel menuModel;
    @EJB
    AdmsistemaSLBean aslb;
    private SegusrSFBean segusrSFBean;
    private SysFuncionario sysfuncionario = new SysFuncionario();
    private String navegacion;
    private String beanDest = "";
    //private ELContext elc;
    private String strClaseStyleMensajes = "styleMensajeError";

    private SegusrSFBean lookupSegusrSFBeanBean() {
        try {
            Context c = new InitialContext();
            return (SegusrSFBean) c.lookup("java:global/EIAPEE-ear/eiapeeweb-3/SegusrSFBean!com.veeduria.sys.ejb.SegusrSFBean");
           
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    protected AdmPuntosCtrlSFBEan lookupAdmPuntosCtrlSFBEan() {
        try {
            Context c = new InitialContext();
            return (AdmPuntosCtrlSFBEan) c.lookup("java:global/EIAPEE-ear/eiapeeweb-3/AdmPuntosCtrlSFBEan!com.veeduria.not.ejb.AdmPuntosCtrlSFBEan");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private AdmPuntosCtrlSFBEan apcsfbe;

    public CMPrepJSFBean getCMPrepJSFBean() {
        fc = FacesContext.getCurrentInstance();
        elc = fc.getELContext();

        return (CMPrepJSFBean) elc.getELResolver().getValue(elc, null, "cMPrepJSFBean");
    }

    //<editor-fold defaultstate="collapsed" desc="Notificaciones">
    public String rowDtNotif_A() {
        return "gestPuntosControl";
    }

    public void rowDtNotif_AE(ActionEvent ae) {
        tablaNotifSel = (TablaNotif) ae.getComponent().getAttributes().get("tablaNotifSel");
        resaltarFilaTabla(lstTablaNotifs, tablaNotifSel);
        navMenu_ActionEvent(ae);
    }

    private void cargarNotsPendientes() {
        lstTablaNotifs.clear();
        for (AdmNotificacion an : apcsfbe.getLlstNotifXFuncXEstado(getSegusrSFBean().getFrnlogeado().getFrnId(), Boolean.FALSE)) {
            lstTablaNotifs.add(new TablaNotif(an));
        }
    }
//</editor-fold>

    public void cargarMenuNav() {
        fc = FacesContext.getCurrentInstance();
        elc = fc.getELContext();
//        menuBar.setOrientation("Horizaontal");

        //Vertical --Opción para el menu en posición Vertical
        //menu 
        menuModel = new DefaultMenuModel();
        ExpressionFactory factory = FacesContext.getCurrentInstance().getApplication().getExpressionFactory();
        MethodExpression methodsexpression = factory.createMethodExpression(FacesContext.getCurrentInstance().getELContext(), "#{administracionJSFBean.navMenu_ActionEvent}", null, new Class[]{ActionEvent.class});
        MethodExpressionActionListener actionListener = new MethodExpressionActionListener(methodsexpression);

        for (SysMenuprin menuapp : aslb.getLstMenuprinsxFrn(getSegusrSFBean().getFrnlogeado().getFrnId())) {
//            Column column = new Column();
            //column.setStyleClass("estiloMenu");
            Submenu menuItemApp = new Submenu();

            //Agregar menu de aplicación a la barra de menu
            menuItemApp.setId("miMenu" + menuapp.getMenId());
            menuItemApp.setLabel(menuapp.getMenNombre());
            menuItemApp.setTransient(true);
            menuItemApp.setStyleClass("letraMenuSubMenu");
            menuItemApp.setStyle("font-style: normal;font-weight: 500; color: #000000 !important;text-decoration:none; z-index: 35; font-size: 12px");

            menuModel.addSubmenu(menuItemApp);
//            menuItemApp.getChildren().add(column);

            //Consultar la lista de modulos por menu
            menuapp.setSysModulosList(aslb.getLstModulosxMenu(menuapp.getMenId()));

            for (SysModulos modapp : menuapp.getSysModulosList()) {

                Submenu menuItemMod = new Submenu();
                menuItemMod.setId("miMod" + modapp.getProcId());
                menuItemMod.setLabel(modapp.getProcNombre());
                menuItemMod.setStyleClass("letraMenuSubMenu");
                menuItemMod.setStyle("font-style: normal;font-weight: normal; color: #000000 !important;text-decoration:none; z-index: 35; font-size: 11px;");
                //Consultar la lista de submódulos por modulo

                modapp.setSysSubmodprocList(aslb.getLstSubmodprocxModXFrn(getSegusrSFBean().getFrnlogeado().getFrnId(), modapp.getProcId()));
                //        setAdmSubmodappList(mssfbl.getLstSubmodappXModXCpe(mssfbl.getColxempLog().getCpeId(),
                //      modapp.getModId()));
//                column.getChildren().add(menuItemMod);

                menuItemApp.getChildren().add(menuItemMod);
                //agregar el modulo al menu

                for (SysSubmodproc sysSubmodproc : modapp.getSysSubmodprocList()) {
                    MenuItem menuItemSubMod = new MenuItem();
                    menuItemSubMod.setId("miSubMod" + sysSubmodproc.getSubId());
                    menuItemSubMod.setValue(sysSubmodproc.getSubNombre());
                    menuItemSubMod.setStyle("font-style: normal;font-weight: bold;color: #000000;text-decoration: underline; z-index: 35; font-size: 11px;");
                    menuItemSubMod.setActionExpression(factory.createMethodExpression(FacesContext.getCurrentInstance().getELContext(),
                            "#{administracionJSFBean.navMenu_Action}", null, new Class<?>[0]));
                    menuItemSubMod.addActionListener(actionListener);
                    menuItemSubMod.getAttributes().put("navegacion", sysSubmodproc.getSubReglanav());
                    menuItemSubMod.getAttributes().put("jsfbean", sysSubmodproc.getSubJsfbean());
                    //menuItemSubMod.set(false);
                    menuItemSubMod.setImmediate(true);
                    menuItemMod.getChildren().add(menuItemSubMod);
                    addAjaxBehaviorTo(menuItemSubMod);
                }
            }
        }
    }

    public void btnInicio_ActionEvent(ActionEvent ae) {
    }

    private void addAjaxBehaviorTo(MenuItem menuItem) {
        AjaxBehavior ajaxBehavior = new AjaxBehavior();
        ajaxBehavior.setExecute("@form");
        ajaxBehavior.setRender("@form");
        menuItem.addClientBehavior("activate", ajaxBehavior);
    }

    /**
     * ActionListener para la barra de menu principal
     *
     * @param ae
     */
    public void navMenu_ActionEvent(ActionEvent ae) {
        Map<String, Object> map = ae.getComponent().getAttributes();
        navegacion = (String) map.get("navegacion");
        System.out.println(navegacion);
        if (navegacion.equals("salir")) {
            renderNavegacion = false;
            // RequestContext context = RequestContext.getCurrentInstance();
            //context.execute("cerrarPagina();");
//            cpjsfb.limpiarVariables();
            getSegusrSFBean().remove();
            apcsfbe.remove();
        } else {
            try {
                beanAnt = beanDest;
                beanDest = (String) map.get("jsfbean");
                elc = FacesContext.getCurrentInstance().getELContext();
                Object objDestJSFBean = elc.getELResolver().getValue(elc, null, beanDest);
                Class cls = objDestJSFBean.getClass();

                if (!beanAnt.isEmpty()) {
                    Object objAntJSFBean = elc.getELResolver().getValue(elc, null, beanAnt);
                    Class clsAnt = objAntJSFBean.getClass();
                    Method mthdLimpiarVar = clsAnt.getDeclaredMethod("limpiarVariables", new Class<?>[0]);
                    mthdLimpiarVar.invoke(objAntJSFBean, new Object[0]);
                }

                Method mthdInit = cls.getDeclaredMethod("init", new Class<?>[0]);
                mthdInit.invoke(objDestJSFBean, new Object[0]);

            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException |
                    NoSuchMethodException | SecurityException ex) {
                Logger.getLogger(AdministracionJSFBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public String navMenu_Action() {
        System.out.println(navegacion);
        return navegacion;
    }
    //<editor-fold defaultstate="collapsed" desc="Eventos">

    public void dtRowListaArchivos_ActionEvent(ActionEvent ae) {

        tablaSysArchivoSel = (TablaSysArchivo) ae.getComponent().getAttributes().get("archivo");
        getCMPrepJSFBean().init();
        getCMPrepJSFBean().setTablaTablaSysArchivoSel(tablaSysArchivoSel);
        navegacion = tablaSysArchivoSel.getSysArchivo().getArcNavegacion();
    }

    public String dtRowListaArchivos_Action() {

        return navegacion;

    }
    //</editor-fold>

    public String getNavegacion() {
        return navegacion;
    }

    public String ingresar_Action() {
        return navegacion;
    }

    public void setNavegacion(String navegacion) {
        this.navegacion = navegacion;
    }

    public void ingresar_ActionEvent(ActionEvent ae) {
        segusrSFBean = lookupSegusrSFBeanBean();
        getSegusrSFBean().validaringreso(sysfuncionario);
        sysfuncionario = getSegusrSFBean().getFrnlogeado();
        if (sysfuncionario.getFrnId() != null) {
            renderNavegacion = true;
            navegacion = "ingresar";
            cargarMenuNav();
            apcsfbe = lookupAdmPuntosCtrlSFBEan();
            cargarNotsPendientes();

        } else {
            getSegusrSFBean().remove();
            navegacion = "";
            renderNavegacion = false;
            FacesMessage message = new FacesMessage();
            message.setDetail("Usuario o clave incorrecto");
            message.setSummary("Error");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, message);
            JavaScriptRunner.runScript(FacesContext.getCurrentInstance(), "mensajeInicio.show();");
        }

    }

    public void btnSalir_ActionEvent(ActionEvent ae) {
        getSegusrSFBean().remove();
    }

    @PostConstruct
    @Override
    public void init() {

        cargarTablaArchivos();
//cargarNotsPendientes();
        renderNavegacion = false;

    }

    private void cargarTablaArchivos() {

        lstTablaSysArchivos.clear();
        List<String> lstParametros = new ArrayList<>();
        lstParametros.add("5");
        lstParametros.add("6");
        for (SysArchivo sysArchivo : aslb.getLstArchivosPrespuesto(lstParametros)) {
            TablaSysArchivo tsa = new TablaSysArchivo(sysArchivo);
            lstTablaSysArchivos.add(tsa);
        }
    }

    /**
     * @return the sysfuncionario
     */
    public SysFuncionario getSysfuncionario() {
        return sysfuncionario;
    }

    /**
     * @param sysfuncionario the sysfuncionario to set
     */
    public void setSysfuncionario(SysFuncionario sysfuncionario) {
        this.sysfuncionario = sysfuncionario;
    }

    /**
     * @return the lstArchivos
     */
    public List<SysArchivo> getLstArchivos() {
        return lstArchivos;
    }

    /**
     * @param lstArchivos the lstArchivos to set
     */
    public void setLstArchivos(List<SysArchivo> lstArchivos) {
        this.lstArchivos = lstArchivos;
    }

    /**
     * @return the lstTablaSysArchivos
     */
    public List<TablaSysArchivo> getLstTablaSysArchivos() {
        return lstTablaSysArchivos;
    }

    /**
     * @param lstTablaSysArchivos the lstTablaSysArchivos to set
     */
    public void setLstTablaSysArchivos(List<TablaSysArchivo> lstTablaSysArchivos) {
        this.lstTablaSysArchivos = lstTablaSysArchivos;
    }

    /**
     * @return the tablaSysArchivoSel
     */
    public TablaSysArchivo getTablaSysArchivoSel() {
        return tablaSysArchivoSel;
    }

    /**
     * @param tablaSysArchivoSel the tablaSysArchivoSel to set
     */
    public void setTablaSysArchivoSel(TablaSysArchivo tablaSysArchivoSel) {
        this.tablaSysArchivoSel = tablaSysArchivoSel;
    }

    public boolean isRenderNavegacion() {
        return renderNavegacion;
    }

    public void setRenderNavegacion(boolean renderNavegacion) {
        this.renderNavegacion = renderNavegacion;
    }

    public MenuModel getMenuModel() {
        return menuModel;
    }

    public void setMenuModel(MenuModel menuModel) {
        this.menuModel = menuModel;
    }

    public String getBeanDest() {
        return beanDest;
    }

    public void setBeanDest(String beanDest) {
        this.beanDest = beanDest;
    }

    public String getBeanAnt() {
        return beanAnt;
    }

    public void setBeanAnt(String beanAnt) {
        this.beanAnt = beanAnt;
    }
    private String beanAnt = "";

    /**
     * @return the strClaseStyleMensajes
     */
    public String getStrClaseStyleMensajes() {
        return strClaseStyleMensajes;
    }

    /**
     * @param strClaseStyleMensajes the strClaseStyleMensajes to set
     */
    public void setStrClaseStyleMensajes(String strClaseStyleMensajes) {
        this.strClaseStyleMensajes = strClaseStyleMensajes;
    }

    public TablaSysArchivosporEntidades getTablaThmArchivosporEntidadesSel() {
        return tablaThmArchivosporEntidadesSel;
    }

    public void setTablaThmArchivosporEntidadesSel(TablaSysArchivosporEntidades tablaThmArchivosporEntidadesSel) {
        this.tablaThmArchivosporEntidadesSel = tablaThmArchivosporEntidadesSel;
    }

    public List<SysArchivosporentidades> getLstArchivosEntidades() {
        return lstArchivosEntidades;
    }

    public void setLstArchivosEntidades(List<SysArchivosporentidades> lstArchivosEntidades) {
        this.lstArchivosEntidades = lstArchivosEntidades;
    }

    @Override
    public void limpiarVariables() {
    }

    @Override
    public void navegacionLateral_ActionEvent(ActionEvent ae) {
        numPanel = Integer.valueOf(String.valueOf(ae.getComponent().getAttributes().get("numPanel")));

    }

    @Override
    public boolean validarFormulario() {

        return true;
    }

    /**
     * @return the lstTablaNotifs
     */
    public List<TablaNotif> getLstTablaNotifs() {
        return lstTablaNotifs;
    }

    /**
     * @param lstTablaNotifs the lstTablaNotifs to set
     */
    public void setLstTablaNotifs(List<TablaNotif> lstTablaNotifs) {
        this.lstTablaNotifs = lstTablaNotifs;
    }

    /**
     * @return the tablaNotifSel
     */
    public TablaNotif getTablaNotifSel() {
        return tablaNotifSel;
    }

    /**
     * @param tablaNotifSel the tablaNotifSel to set
     */
    public void setTablaNotifSel(TablaNotif tablaNotifSel) {
        this.tablaNotifSel = tablaNotifSel;
    }

    /**
     * @return the segusrSFBean
     */
    public SegusrSFBean getSegusrSFBean() {
        return segusrSFBean;
    }
}
