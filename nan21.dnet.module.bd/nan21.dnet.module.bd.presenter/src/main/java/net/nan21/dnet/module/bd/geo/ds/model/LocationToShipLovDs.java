/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.geo.ds.model;

import net.nan21.dnet.core.api.model.IModelWithClientId;
import net.nan21.dnet.core.api.model.IModelWithId;
import net.nan21.dnet.core.presenter.model.AbstractDsModel;

import net.nan21.dnet.module.bd.geo.domain.entity.Location;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = Location.class, jpqlWhere = " e.active = true and e.forShipping = true ")
public class LocationToShipLovDs extends AbstractDsModel<Location> implements
        IModelWithId, IModelWithClientId {

    public static final String fID = "id";
    public static final String fCLIENTID = "clientId";
    public static final String fTARGETID = "targetId";
    public static final String fTARGETTYPE = "targetType";
    public static final String fASSTRING = "asString";
    public static final String fACTIVE = "active";

    @DsField()
    private Long id;

    @DsField()
    private Long clientId;

    @DsField()
    private Long targetId;

    @DsField()
    private String targetType;

    @DsField(fetch = false)
    private String asString;

    @DsField()
    private Boolean active;

    public LocationToShipLovDs() {
        super();
    }

    public LocationToShipLovDs(Location e) {
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

    public Long getTargetId() {
        return this.targetId;
    }

    public void setTargetId(Long targetId) {
        this.targetId = targetId;
    }

    public String getTargetType() {
        return this.targetType;
    }

    public void setTargetType(String targetType) {
        this.targetType = targetType;
    }

    public String getAsString() {
        return this.asString;
    }

    public void setAsString(String asString) {
        this.asString = asString;
    }

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

}
