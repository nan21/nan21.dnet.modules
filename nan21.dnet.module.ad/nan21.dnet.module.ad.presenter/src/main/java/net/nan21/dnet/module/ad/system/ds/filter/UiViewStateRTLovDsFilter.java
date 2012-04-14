/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.system.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableLovFilter;

public class UiViewStateRTLovDsFilter extends AbstractAuditableLovFilter {

    private String name;

    private String cmp;

    private String cmpType;

    private String stateValue;

    private String owner;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCmp() {
        return this.cmp;
    }

    public void setCmp(String cmp) {
        this.cmp = cmp;
    }

    public String getCmpType() {
        return this.cmpType;
    }

    public void setCmpType(String cmpType) {
        this.cmpType = cmpType;
    }

    public String getStateValue() {
        return this.stateValue;
    }

    public void setStateValue(String stateValue) {
        this.stateValue = stateValue;
    }

    public String getOwner() {
        return this.owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

}
