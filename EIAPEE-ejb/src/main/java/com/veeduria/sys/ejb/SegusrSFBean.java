/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veeduria.sys.ejb;

import com.veeduria.sys.dao.SysFuncionario;
import javax.ejb.LocalBean;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author luz
 */
@Stateful
@LocalBean
public class SegusrSFBean {

    @PersistenceContext
    EntityManager em;
    SysFuncionario frnlogeado = new SysFuncionario();

    public void validaringreso(SysFuncionario pSysFuncionario) {

        Query q = em.createNamedQuery("SysFuncionario.validarUsr");
        q.setParameter("frnUsuario", pSysFuncionario.getFrnUsuario());
        q.setParameter("frnClave", pSysFuncionario.getFrnClave());
        try {

            frnlogeado = (SysFuncionario) q.getSingleResult();


        } catch (NoResultException | NonUniqueResultException e) {
        }
    }

    
          
            
    public SysFuncionario getFrnlogeado() {
        return frnlogeado;
    }

    @Remove
    public void remove() {
    }
    
    
}
