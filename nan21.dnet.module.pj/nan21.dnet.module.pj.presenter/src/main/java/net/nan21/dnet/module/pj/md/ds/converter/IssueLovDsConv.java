/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.pj.md.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.pj.md.ds.model.IssueLovDs;
import net.nan21.dnet.module.pj.md.domain.entity.Issue;

public class IssueLovDsConv extends AbstractDsConverter<IssueLovDs, Issue>
        implements IDsConverter<IssueLovDs, Issue> {

    protected void modelToEntityAttributes(IssueLovDs ds, Issue e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setCode(ds.getCode());
        e.setSummary(ds.getSummary());
    }

    protected void modelToEntityReferences(IssueLovDs ds, Issue e)
            throws Exception {
    }

    @Override
    public void entityToModel(Issue e, IssueLovDs ds) throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCode(e.getCode());
        ds.setSummary(e.getSummary());
    }

}
