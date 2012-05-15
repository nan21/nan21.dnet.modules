/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.currency.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeDsFilter;

public class CurrencyDsFilter extends AbstractTypeWithCodeDsFilter {

    private String iso3;

    private Integer standardPrecision;

    private Integer standardPrecision_From;
    private Integer standardPrecision_To;

    private String symbol;

    public String getIso3() {
        return this.iso3;
    }

    public void setIso3(String iso3) {
        this.iso3 = iso3;
    }

    public Integer getStandardPrecision() {
        return this.standardPrecision;
    }

    public Integer getStandardPrecision_From() {
        return this.standardPrecision_From;
    }

    public Integer getStandardPrecision_To() {
        return this.standardPrecision_To;
    }

    public void setStandardPrecision(Integer standardPrecision) {
        this.standardPrecision = standardPrecision;
    }

    public void setStandardPrecision_From(Integer standardPrecision_From) {
        this.standardPrecision_From = standardPrecision_From;
    }

    public void setStandardPrecision_To(Integer standardPrecision_To) {
        this.standardPrecision_To = standardPrecision_To;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

}
