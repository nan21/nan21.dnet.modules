/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.mm.price.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;
import net.nan21.dnet.module.md.mm.price.domain.entity.PriceList;

@Ds(entity = PriceList.class, jpqlWhere = " e.active=true and e.salesList = false ", sort = { @SortField(field = PriceListPurchaseLovDs.fNAME) })
public class PriceListPurchaseLovDs extends AbstractTypeLov<PriceList> {

    public static final String fCURRENCYID = "currencyId";
    public static final String fCURRENCY = "currency";
    public static final String fSALESLIST = "salesList";

    @DsField(join = "left", path = "currency.id")
    private Long currencyId;

    @DsField(join = "left", path = "currency.code")
    private String currency;

    @DsField()
    private Boolean salesList;

    public PriceListPurchaseLovDs() {
        super();
    }

    public PriceListPurchaseLovDs(PriceList e) {
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

}
