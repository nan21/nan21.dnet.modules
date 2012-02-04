/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.data.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.api.model.IModelWithClientId;
import net.nan21.dnet.core.api.model.IModelWithId;
import net.nan21.dnet.core.presenter.model.AbstractDsModel;

import net.nan21.dnet.module.ad.data.domain.entity.AttachmentType;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = AttachmentType.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = AttachmentTypeLovDs.fNAME) })
public class AttachmentTypeLovDs extends AbstractDsModel<AttachmentType>
        implements IModelWithId, IModelWithClientId {

    public static final String fID = "id";
    public static final String fCLIENTID = "clientId";
    public static final String fNAME = "name";
    public static final String fACTIVE = "active";
    public static final String fUSEINCONTEXT = "useInContext";

    @DsField()
    private Long id;

    @DsField()
    private Long clientId;

    @DsField()
    private String name;

    @DsField()
    private Boolean active;

    @DsField(jpqlFilter = " :useInContext like e.useInContext ")
    private String useInContext;

    public AttachmentTypeLovDs() {
        super();
    }

    public AttachmentTypeLovDs(AttachmentType e) {
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

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getUseInContext() {
        return this.useInContext;
    }

    public void setUseInContext(String useInContext) {
        this.useInContext = useInContext;
    }

}
