/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veeduria.web.base;

import java.io.File;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author con1ead
 */
public class ServletListenerClase implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Contexto inicializado"); //To change body of generated methods, choose Tools | Templates.

        System.out.println("Contexto inicializado, crear carpeta archivos de carga si no existe....");
        String homeusuarioSO = System.getProperty("user.home");
        String carpetaArchivos = "archivoscarga";
        String rutaNorm = homeusuarioSO + File.separator + carpetaArchivos;
        File f = new File(rutaNorm);
        if (f.exists()) {
            if (!f.isDirectory()) {
                f.delete();
                f.mkdir();
            }
        } else {
            f.mkdir();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
