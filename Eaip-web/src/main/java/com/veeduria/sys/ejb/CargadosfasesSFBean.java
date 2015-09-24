/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veeduria.sys.ejb;

import com.veeduria.adm.dao.AdmAjustexvalidacion;
import com.veeduria.adm.dao.AdmLoginconsistencias;
import com.veeduria.pre.dao.PreAccionincgasto;
import com.veeduria.pre.dao.PreCmgastoinconsistencia;
import com.veeduria.sys.ejb.base.BaseSFBean;
import java.awt.event.ActionEvent;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.Query;

/**
 *
 * @author fernando
 */
@Stateful
@LocalBean
public class CargadosfasesSFBean extends BaseSFBean {

    public List<PreCmgastoinconsistencia> getLstInconsistenciasxArchivo(Long pLgregId) {

        Query q = em.createNamedQuery("PreCmgastoinconsistencia.inconsistenciasporArchivo");
        q.setParameter("lgregId", pLgregId);
        return q.getResultList();
    }
    
    public List<AdmLoginconsistencias> getLstAdlLogInc(Long pLgRegId, Boolean pLogAplicado){
      return em.createNamedQuery("AdmLoginconsistencias.logIncXArchivoAplicado").
              setParameter("lgregId", pLgRegId).setParameter("logAplicado", pLogAplicado).
              getResultList();
    }

    public List<PreCmgastoinconsistencia> getDetporInconsistencia(String pValDescripcion) {
        Query q = em.createNamedQuery("PreCmgastoinconsistencia.detInconsistencia");
        q.setParameter("valDescripcion", pValDescripcion);
        return q.getResultList();
    }

    public List<AdmAjustexvalidacion> getLstAjxval(Long pValId) {
        return em.createNamedQuery("AdmAjustexvalidacion.ajustesActivos").
                setParameter("valId", pValId).
                setParameter("ajuEstado", Boolean.TRUE).
                getResultList();
    }

    public void grabarLstLogIncnsGasto(List<AdmLoginconsistencias> pLstALInc) {
        pLstALInc.stream().forEach((alig) -> {
            alig = em.merge(alig);
        });
    }
    
    public void editarLogIncGasto(AdmLoginconsistencias pAIG){
      pAIG = em.merge(pAIG);
    }
    
    public void grabarHomolgacionGasto(PreAccionincgasto pAIG){
      pAIG = em.merge(pAIG);
    }

    public boolean insertInconsGasto(Long pLgregId) {
        try {

            boolean blnValidarDosFases = false;
            con = jdbcVeeduria.getConnection();
            StringBuilder strBSqlInsert = new StringBuilder();
            StringBuilder strBSqlUpdate = new StringBuilder();
            //Insertar validación códigos de cuenta

            strBSqlInsert.append("INSERT INTO pre_cmgastoinconsistencia(\n");
            strBSqlInsert.append(" gin_id, val_id, ger_procesado)\n");
            strBSqlInsert.append(" SELECT gi.gin_id,2::integer, false FROM pre_cmgastoinicial gi, sys_registrocarga src WHERE  src.lgreg_id = gi.lgreg_id AND  gi.gin_codcuenta \n");
            strBSqlInsert.append("  NOT IN(SELECT pco_numcuenta FROM cnt_plancuetagastos WHERE pco_vigencia  = date_part('YEAR', src.lgreg_periodo)  )\n");
            strBSqlInsert.append(" AND src.lgreg_id = ? ORDER BY   gi.gin_id, src.lgreg_id");

            PreparedStatement ps = con.prepareStatement(strBSqlInsert.toString());
            ps.setLong(1, pLgregId);
            Integer filas = ps.executeUpdate();
            Logger.getLogger(CargadosfasesSFBean.class.getName()).log(Level.INFO, null, "Filas insertadas validación 2: " + filas);

            if (filas > 0) {
                blnValidarDosFases = true;
            }
            //Insertar validación diferencias significativas en nombre para un mismo código de cuenta 
            strBSqlInsert.delete(0, strBSqlInsert.length());

            strBSqlInsert.append(" SELECT gi.gin_id,1::integer, false   \n");
            strBSqlInsert.append("FROM  \n");
            strBSqlInsert.append("  pre_cmgastoinicial gi, \n");
            strBSqlInsert.append("  sys_registrocarga src, \n");
            strBSqlInsert.append("  cnt_plancuetagastos pcg\n");
            strBSqlInsert.append("WHERE \n");
            strBSqlInsert.append("\n");
            strBSqlInsert.append("  gi.lgreg_id = src.lgreg_id AND\n");
            strBSqlInsert.append("  date_part('year', src.lgreg_periodo) = pcg.pco_vigencia AND\n");
            strBSqlInsert.append("  gi.gin_codcuenta =  pcg.pco_numcuenta   AND \n");
            strBSqlInsert.append(" replace(replace(replace(replace(replace(replace(replace(replace(replace(upper(gi.gin_nomcuenta),'Á','A'),'É','E'),'Í','I'),'Ó','O'),'Ú','U'),',',''),'.',''),'Ü',''),' ','') <>  \n");
            strBSqlInsert.append(" replace(replace(replace(replace(replace(replace(replace(replace(replace(upper(pcg.pco_nomcuenta),'Á','A'),'É','E'),'Í','I'),'Ó','O'),'Ú','U'),',',''),'.',''),'Ü',''),' ','') \n");
            strBSqlInsert.append("  AND src.lgreg_id = ? ");
            strBSqlInsert.append("  ORDER BY   gi.gin_id, src.lgreg_id;");

            ps = con.prepareStatement(strBSqlInsert.toString());
            ps.setLong(1, pLgregId);
            filas = ps.executeUpdate();
            Logger.getLogger(CargadosfasesSFBean.class.getName()).log(Level.INFO, null, "Filas insertadas validación 1: " + filas);

            if (filas > 0) {
                blnValidarDosFases = true;
            }

            if (blnValidarDosFases) {
                strBSqlUpdate.append("UPDATE sys_registrocarga SET lgreg_validado = ? WHERE lgreg_id = ?");
                ps = con.prepareStatement(strBSqlUpdate.toString());
                ps.setBoolean(1, blnValidarDosFases);
                ps.setLong(2, pLgregId);
                ps.executeUpdate();
            }

            return blnValidarDosFases;
        } catch (SQLException ex) {
            Logger.getLogger(CargadosfasesSFBean.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(CargadosfasesSFBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
