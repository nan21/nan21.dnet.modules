/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.pj.base.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.pj.base.ds.model.IssuePriorityLovDs;
import net.nan21.dnet.module.pj.base.domain.entity.IssuePriority;

public class IssuePriorityLovDsConv extends
        AbstractDsConverter<IssuePriorityLovDs, IssuePriority> implements
        IDsConverter<IssuePriorityLovDs, IssuePriority> {

    protected void modelToEntityAttributes(IssuePriorityLovDs ds,
            IssuePriority e) throws Exception {
        e.setClientId(ds.getClientId());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
        e.setSequenceNo(ds.getSequenceNo());
    }

    protected void modelToEntityReferences(IssuePriorityLovDs ds,
            IssuePriority e) throws Exception {
    }

    @Override
    public void entityToModel(IssuePriority e, IssuePriorityLovDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
        ds.setSequenceNo(e.getSequenceNo());
    }

}
