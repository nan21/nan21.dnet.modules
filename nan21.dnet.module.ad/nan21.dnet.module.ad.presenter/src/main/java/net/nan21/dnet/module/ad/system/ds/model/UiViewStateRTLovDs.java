/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.system.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.api.model.IModelWithClientId;
import net.nan21.dnet.core.api.model.IModelWithId;
import net.nan21.dnet.core.presenter.model.AbstractDsModel;

import net.nan21.dnet.module.ad.system.domain.entity.UiViewState;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = UiViewState.class, sort = { @SortField(field = UiViewStateRTLovDs.fNAME) })
public class UiViewStateRTLovDs extends AbstractDsModel<UiViewState> implements
        IModelWithId, IModelWithClientId {

    public static final String fID = "id";
    public static final String fCLIENTID = "clientId";
    public static final String fNAME = "name";
    public static final String fCMP = "cmp";
    public static final String fCMPTYPE = "cmpType";
    public static final String fSTATEVALUE = "stateValue";
    public static final String fOWNER = "owner";

    @DsField()
    private Long id;

    @DsField()
    private Long clientId;

    @DsField()
    private String name;

    @DsField()
    private String cmp;

    @DsField()
    private String cmpType;

    @DsField()
    private String stateValue;

    @DsField(path = "createdBy")
    private String owner;

    public UiViewStateRTLovDs() {
        super();
    }

    public UiViewStateRTLovDs(UiViewState e) {
        super(e);
    }

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
