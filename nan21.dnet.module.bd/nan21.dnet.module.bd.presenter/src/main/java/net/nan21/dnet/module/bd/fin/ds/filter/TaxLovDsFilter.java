/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.fin.ds.filter;

import net.nan21.dnet.core.api.model.IModelWithClientId;
import net.nan21.dnet.core.api.model.IModelWithId;

import net.nan21.dnet.core.presenter.model.AbstractDsFilter;

public class TaxLovDsFilter extends AbstractDsFilter implements IModelWithId,
        IModelWithClientId {

    private Long id;

    private Long clientId;

    private String name;

    private Boolean active;

    private Float rate;

    private Float rate_From;
    private Float rate_To;

    private Boolean summary;

    public Long getId() {
        return this.id;
    }

    public void setId(Object id) {
        this.id = this._asLong_(id);

    }

    public Long getClientId() {
        return this.clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Float getRate() {
        return this.rate;
    }

    public Float getRate_From() {
        return this.rate_From;
    }

    public Float getRate_To() {
        return this.rate_To;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    public void setRate_From(Float rate_From) {
        this.rate_From = rate_From;
    }

    public void setRate_To(Float rate_To) {
        this.rate_To = rate_To;
    }

    public Boolean getSummary() {
        return this.summary;
    }

    public void setSummary(Boolean summary) {
        this.summary = summary;
    }

}
