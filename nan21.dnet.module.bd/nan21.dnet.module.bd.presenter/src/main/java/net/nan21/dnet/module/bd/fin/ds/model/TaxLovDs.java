/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.fin.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;

import net.nan21.dnet.module.bd.fin.domain.entity.Tax;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = Tax.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = TaxLovDs.fNAME) })
public class TaxLovDs extends AbstractTypeLov<Tax> {

    public static final String fRATE = "rate";
    public static final String fSUMMARY = "summary";

    @DsField()
    private Float rate;

    @DsField()
    private Boolean summary;

    public TaxLovDs() {
        super();
    }

    public TaxLovDs(Tax e) {
        super(e);
    }

    public Float getRate() {
        return this.rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    public Boolean getSummary() {
        return this.summary;
    }

    public void setSummary(Boolean summary) {
        this.summary = summary;
    }

}
