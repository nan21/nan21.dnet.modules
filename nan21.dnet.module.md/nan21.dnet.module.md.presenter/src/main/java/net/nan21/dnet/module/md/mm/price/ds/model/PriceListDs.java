/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.mm.price.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;

import net.nan21.dnet.module.md.mm.price.domain.entity.PriceList;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = PriceList.class, sort = { @SortField(field = PriceListDs.fNAME) })
public class PriceListDs extends AbstractTypeDs<PriceList> {

    public static final String fCURRENCYID = "currencyId";
    public static final String fCURRENCY = "currency";
    public static final String fSALESLIST = "salesList";
    public static final String fISDEFAULT = "isDefault";

    @DsField(join = "left", path = "currency.id")
    private Long currencyId;

    @DsField(join = "left", path = "currency.code")
    private String currency;

    @DsField()
    private Boolean salesList;

    @DsField()
    private Boolean isDefault;

    public PriceListDs() {
        super();
    }

    public PriceListDs(PriceList e) {
        super(e);
    }

    public Long getCurrencyId() {
        return this.currencyId;
    }

    public void setCurrencyId(Long currencyId) {
        this.currencyId = currencyId;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Boolean getSalesList() {
        return this.salesList;
    }

    public void setSalesList(Boolean salesList) {
        this.salesList = salesList;
    }

    public Boolean getIsDefault() {
        return this.isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

}
