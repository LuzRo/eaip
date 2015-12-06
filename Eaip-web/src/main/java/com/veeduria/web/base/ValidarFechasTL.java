/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.veeduria.web.base;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author luz
 */
public class ValidarFechasTL {
    private ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>(){

        @Override
        public DateFormat get() {
            return super.get(); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("dd/MM/yyyy");
        }

        @Override
        public void set(DateFormat value) {
            super.set(value); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void remove() {
            super.remove(); //To change body of generated methods, choose Tools | Templates.
        }
      public Date convertirTextoAFecha(String fechaEnTexto) throws ParseException {
	  return df.get().parse(fechaEnTexto);
	 }
    };
}
