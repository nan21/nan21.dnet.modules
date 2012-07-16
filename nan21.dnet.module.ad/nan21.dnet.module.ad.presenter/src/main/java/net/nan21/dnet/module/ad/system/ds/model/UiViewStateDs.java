/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.system.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;
import net.nan21.dnet.module.ad.system.domain.entity.UiViewState;

@Ds(entity = UiViewState.class)
public class UiViewStateDs extends AbstractAuditableDs<UiViewState> {

    public static final String fNAME = "name";
    public static final String fCMP = "cmp";
    public static final String fCMPTYPE = "cmpType";
    public static final String fSTATEVALUE = "stateValue";

    @DsField()
    private String name;

    @DsField()
    private String cmp;

    @DsField()
    private String cmpType;

    @DsField()
    private String stateValue;

    public UiViewStateDs() {
        super();
    }

    public UiViewStateDs(UiViewState e) {
        super(e);
    }

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

}
