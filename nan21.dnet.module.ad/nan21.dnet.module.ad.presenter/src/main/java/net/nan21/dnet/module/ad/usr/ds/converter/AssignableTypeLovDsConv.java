/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.usr.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.ad.usr.ds.model.AssignableTypeLovDs;
import net.nan21.dnet.module.ad.usr.domain.entity.AssignableType;

public class AssignableTypeLovDsConv extends
        AbstractDsConverter<AssignableTypeLovDs, AssignableType> implements
        IDsConverter<AssignableTypeLovDs, AssignableType> {

    protected void modelToEntityAttributes(AssignableTypeLovDs ds,
            AssignableType e) throws Exception {
        e.setClientId(ds.getClientId());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(AssignableTypeLovDs ds,
            AssignableType e) throws Exception {
    }

    @Override
    public void entityToModel(AssignableType e, AssignableTypeLovDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
    }

}
