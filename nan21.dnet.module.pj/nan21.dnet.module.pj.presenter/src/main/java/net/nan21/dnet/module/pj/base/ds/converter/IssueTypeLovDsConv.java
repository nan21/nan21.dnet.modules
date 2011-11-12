/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.pj.base.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.pj.base.ds.model.IssueTypeLovDs;
import net.nan21.dnet.module.pj.base.domain.entity.IssueType;

public class IssueTypeLovDsConv extends
        AbstractDsConverter<IssueTypeLovDs, IssueType> implements
        IDsConverter<IssueTypeLovDs, IssueType> {

    protected void modelToEntityAttributes(IssueTypeLovDs ds, IssueType e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(IssueTypeLovDs ds, IssueType e)
            throws Exception {
    }

    @Override
    public void entityToModel(IssueType e, IssueTypeLovDs ds) throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
    }

}
