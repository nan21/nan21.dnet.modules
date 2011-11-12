/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.pj.base.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.pj.base.ds.model.IssueLinkTypeLovDs;
import net.nan21.dnet.module.pj.base.domain.entity.IssueLinkType;

public class IssueLinkTypeLovDsConv extends
        AbstractDsConverter<IssueLinkTypeLovDs, IssueLinkType> implements
        IDsConverter<IssueLinkTypeLovDs, IssueLinkType> {

    protected void modelToEntityAttributes(IssueLinkTypeLovDs ds,
            IssueLinkType e) throws Exception {
        e.setClientId(ds.getClientId());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(IssueLinkTypeLovDs ds,
            IssueLinkType e) throws Exception {
    }

    @Override
    public void entityToModel(IssueLinkType e, IssueLinkTypeLovDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
    }

}
