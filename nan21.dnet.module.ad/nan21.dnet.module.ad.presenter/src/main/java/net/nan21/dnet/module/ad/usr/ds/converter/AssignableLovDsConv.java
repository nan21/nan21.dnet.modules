/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.usr.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.ad.usr.ds.model.AssignableLovDs;
import net.nan21.dnet.module.ad.usr.domain.entity.Assignable;

public class AssignableLovDsConv extends
        AbstractDsConverter<AssignableLovDs, Assignable> implements
        IDsConverter<AssignableLovDs, Assignable> {

    protected void modelToEntityAttributes(AssignableLovDs ds, Assignable e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(AssignableLovDs ds, Assignable e)
            throws Exception {
    }

    @Override
    public void entityToModel(Assignable e, AssignableLovDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
    }

}
