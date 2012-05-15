/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.contact.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;

import net.nan21.dnet.module.bd.contact.domain.entity.CommunicationChannelType;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = CommunicationChannelType.class, sort = { @SortField(field = CommunicationChannelTypeDs.fNAME) })
public class CommunicationChannelTypeDs extends
        AbstractTypeDs<CommunicationChannelType> {

    public static final String fTYPE = "type";

    @DsField()
    private String type;

    public CommunicationChannelTypeDs() {
        super();
    }

    public CommunicationChannelTypeDs(CommunicationChannelType e) {
        super(e);
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
