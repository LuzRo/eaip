/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veeduria.dosfases.jsf;

import com.veeduria.adm.dao.AdmDefajuste;
import com.veeduria.web.base.TablaBaseFrm;

/**
 *
 * @author fernando
 */
public class TablaAjusteInc extends TablaBaseFrm {

    private AdmDefajuste ad = new AdmDefajuste();

    public TablaAjusteInc() {
    }

    public TablaAjusteInc(AdmDefajuste pAd) {
        this.ad = pAd;
    }

    /**
     * @return the ad
     */
    public AdmDefajuste getAd() {
        return ad;
    }

    /**
     * @param ad the ad to set
     */
    public void setAd(AdmDefajuste ad) {
        this.ad = ad;
    }
}
