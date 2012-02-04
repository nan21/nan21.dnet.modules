/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.mm.price.ds.filter;

import java.util.Date;
import net.nan21.dnet.core.api.model.IModelWithClientId;
import net.nan21.dnet.core.api.model.IModelWithId;

import net.nan21.dnet.core.presenter.model.AbstractDsFilter;

public class PriceListVersionLovDsFilter extends AbstractDsFilter implements
        IModelWithId, IModelWithClientId {

    private Long id;

    private Long clientId;

    private String name;

    private Boolean active;

    private Long priceListId;

    private Long priceListId_From;
    private Long priceListId_To;

    private Date validFrom;

    private Date validFrom_From;
    private Date validFrom_To;

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

    public Long getPriceListId() {
        return this.priceListId;
    }

    public Long getPriceListId_From() {
        return this.priceListId_From;
    }

    public Long getPriceListId_To() {
        return this.priceListId_To;
    }

    public void setPriceListId(Long priceListId) {
        this.priceListId = priceListId;
    }

    public void setPriceListId_From(Long priceListId_From) {
        this.priceListId_From = priceListId_From;
    }

    public void setPriceListId_To(Long priceListId_To) {
        this.priceListId_To = priceListId_To;
    }

    public Date getValidFrom() {
        return this.validFrom;
    }

    public Date getValidFrom_From() {
        return this.validFrom_From;
    }

    public Date getValidFrom_To() {
        return this.validFrom_To;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    public void setValidFrom_From(Date validFrom_From) {
        this.validFrom_From = validFrom_From;
    }

    public void setValidFrom_To(Date validFrom_To) {
        this.validFrom_To = validFrom_To;
    }

}
