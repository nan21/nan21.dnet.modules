/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.currency.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeDs;

import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = Currency.class, sort = { @SortField(field = CurrencyDs.fNAME) })
public class CurrencyDs extends AbstractTypeWithCodeDs<Currency> {

    public static final String fISO3 = "iso3";
    public static final String fSTANDARDPRECISION = "standardPrecision";
    public static final String fSYMBOL = "symbol";

    @DsField()
    private String iso3;

    @DsField()
    private Integer standardPrecision;

    @DsField()
    private String symbol;

    public CurrencyDs() {
        super();
    }

    public CurrencyDs(Currency e) {
        super(e);
    }

    public String getIso3() {
        return this.iso3;
    }

    public void setIso3(String iso3) {
        this.iso3 = iso3;
    }

    public Integer getStandardPrecision() {
        return this.standardPrecision;
    }

    public void setStandardPrecision(Integer standardPrecision) {
        this.standardPrecision = standardPrecision;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

}
