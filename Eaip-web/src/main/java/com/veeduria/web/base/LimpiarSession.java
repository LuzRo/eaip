/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veeduria.web.base;

import java.io.File;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 *
 * @author luz
 */
public class LimpiarSession implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
//        String rutaGral = System.getenv("user.home") + File.separator + "archivoscarga" + File.separator
//                + se.getSession().getId();
//        File fileRutaDestSession = new File(rutaGral);
//        if (!fileRutaDestSession.exists()) {
//            fileRutaDestSession.mkdir();
//        }

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        String rutaGral = System.getenv("user.home") + File.separator + "archivoscarga" + File.separator
                + se.getSession().getId();

        File fileRutaDestSession = new File(rutaGral);

        if (fileRutaDestSession.exists()) {
            if (fileRutaDestSession.isDirectory()) {
                for (File file : fileRutaDestSession.listFiles()) {
                    if (file.exists()) {
                        file.delete();
                    }

                }
                fileRutaDestSession.delete();

            }
        }
    }

}
