/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.contact.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;

import net.nan21.dnet.module.bd.contact.domain.entity.CommunicationChannelType;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = CommunicationChannelType.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = CommunicationChannelTypeLovDs.fNAME) })
public class CommunicationChannelTypeLovDs extends
        AbstractTypeLov<CommunicationChannelType> {

    public CommunicationChannelTypeLovDs() {
        super();
    }

    public CommunicationChannelTypeLovDs(CommunicationChannelType e) {
        super(e);
    }

}
