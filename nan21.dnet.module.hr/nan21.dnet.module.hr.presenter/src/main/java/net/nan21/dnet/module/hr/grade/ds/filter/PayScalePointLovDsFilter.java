/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.grade.ds.filter;

import net.nan21.dnet.core.api.model.IModelWithClientId;
import net.nan21.dnet.core.api.model.IModelWithId;

import net.nan21.dnet.core.presenter.model.AbstractDsFilter;

public class PayScalePointLovDsFilter extends AbstractDsFilter implements
        IModelWithId, IModelWithClientId {

    private String name;

    private Long id;

    private Long id_From;
    private Long id_To;

    private Long clientId;

    private Long clientId_From;
    private Long clientId_To;

    private Long payScaleId;

    private Long payScaleId_From;
    private Long payScaleId_To;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return this.id;
    }

    public Long getId_From() {
        return this.id_From;
    }

    public Long getId_To() {
        return this.id_To;
    }

    public void setId(Object id) {
        this.id = this._asLong_(id);

    }

    public Long getClientId() {
        return this.clientId;
    }

    public Long getClientId_From() {
        return this.clientId_From;
    }

    public Long getClientId_To() {
        return this.clientId_To;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public void setClientId_From(Long clientId_From) {
        this.clientId_From = clientId_From;
    }

    public void setClientId_To(Long clientId_To) {
        this.clientId_To = clientId_To;
    }

    public Long getPayScaleId() {
        return this.payScaleId;
    }

    public Long getPayScaleId_From() {
        return this.payScaleId_From;
    }

    public Long getPayScaleId_To() {
        return this.payScaleId_To;
    }

    public void setPayScaleId(Long payScaleId) {
        this.payScaleId = payScaleId;
    }

    public void setPayScaleId_From(Long payScaleId_From) {
        this.payScaleId_From = payScaleId_From;
    }

    public void setPayScaleId_To(Long payScaleId_To) {
        this.payScaleId_To = payScaleId_To;
    }

}
