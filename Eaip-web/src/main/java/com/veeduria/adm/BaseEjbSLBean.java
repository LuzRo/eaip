/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veeduria.adm;

import com.veeduria.adm.dao.AdmEntidad;
import com.veeduria.sys.dao.SysArchivosporentidades;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author luz
 */
public abstract class BaseEjbSLBean {

    @PersistenceContext
    protected EntityManager em;

    public Long getNomcargaDuplicados(String pLgregNomarchivocarga, Integer pLgregIdmsjcarga) {

        Query q = em.createNamedQuery("SysRegistrocarga.nomarchcargaporIdcarga");
        q.setParameter("lgregNomarchivocarga", pLgregNomarchivocarga);
        q.setParameter("lgregIdmsjcarga", pLgregIdmsjcarga);
        return (Long) q.getSingleResult();
    }

    public AdmEntidad getAdmEntidadXCodPredis(Double pCdPredis) {
        try {
            return (AdmEntidad) em.createNamedQuery("AdmEntidad.findByEntCdpredis").
                    setParameter("entCdpredis", pCdPredis).
                    getSingleResult();
        } catch (NoResultException | NonUniqueResultException ex) {
            return null;
        }
    }

    public SysArchivosporentidades getArchivosporentidades(String pEntId, Integer pArcId) {
        try {
            Query q = em.createNamedQuery("SysArchivosporentidades.archivosPorEntidades");
            q.setParameter("entId", pEntId);
            q.setParameter("arcId", pArcId);
            return (SysArchivosporentidades) q.getSingleResult();
        } catch (NoResultException | NonUniqueResultException ex) {
            return null;

        }
    }
}
