/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veeduria.web.cargaarchivo.aut.th;

import com.veeduria.sys.ejb.VigilarCarpetaSLBean;
import com.veeduria.web.cargaarchivo.BaseCargaMasiva;
import com.veeduria.web.cargaarchivo.ICargaArchivo;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author luz
 */
public class CargaPlanta extends BaseCargaMasiva implements ICargaArchivo<Object> {

    @Override
    public void cargarArchivo() {

    }

    public void cargarArchivoEmpleados(Path rutaArchivo) {
        //Get first sheet from the workbook
        try {
            StringBuilder strBSql = new StringBuilder();
            HSSFWorkbook workbook = new HSSFWorkbook(Files.newInputStream(rutaArchivo, StandardOpenOption.READ));
            HSSFSheet sheet = workbook.getSheet("EMPLEADOS");
            if (sheet != null) {
                Iterator<org.apache.poi.ss.usermodel.Row> rowIterator = sheet.iterator();
                while (rowIterator.hasNext()) {
                    Row row = (Row) rowIterator.next();
                    if (row.getRowNum() >= 10) {
                        if (row.getCell(0) != null) {
                            for (int i = 0; i < 42; i++) {
                                Cell cell = row.getCell(i);
                                switch (cell.getCellType()) {
                                    case Cell.CELL_TYPE_BOOLEAN:
                                        strBSql.append(cell.getBooleanCellValue());
                                        strBSql.append(",");
                                        //  System.out.print(cell.getBooleanCellValue() + "\t\t");
                                        break;
                                    case Cell.CELL_TYPE_NUMERIC:
                                        strBSql.append(cell.getNumericCellValue());
                                        strBSql.append(",");
                                        //   System.out.print(cell.getNumericCellValue() + "\t\t");
                                        break;
                                    case Cell.CELL_TYPE_STRING:
                                        strBSql.append(",'");
                                        strBSql.append(cell.getStringCellValue());
                                        strBSql.append("',");
                                        //  System.out.print(cell.getStringCellValue() + "\t\t");
                                        break;

                                }

                            }
                            strBSql.replace(strBSql.length() - 1, strBSql.length(), "");
                        }

                    }
                    strBSql.append(System.getProperty("line.separator"));
                }

                System.out.println("");
            }

//            FileOutputStream out = new FileOutputStream(new File(System.getProperty("user.home") + File.separator + "test.xls"));
//            workbook.write(out);
//            out.close();
        } catch (IOException e) {
            Logger.getLogger(VigilarCarpetaSLBean.class.getName()).log(Level.SEVERE, null, e);
        }
    }

}
