/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sd.opportunity.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.sd.opportunity.ds.model.OpportunityPriorityLovDs;
import net.nan21.dnet.module.sd.opportunity.domain.entity.OpportunityPriority;

public class OpportunityPriorityLovDsConv extends
        AbstractDsConverter<OpportunityPriorityLovDs, OpportunityPriority>
        implements IDsConverter<OpportunityPriorityLovDs, OpportunityPriority> {

    protected void modelToEntityAttributes(OpportunityPriorityLovDs ds,
            OpportunityPriority e) throws Exception {
        e.setClientId(ds.getClientId());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(OpportunityPriorityLovDs ds,
            OpportunityPriority e) throws Exception {
    }

    @Override
    public void entityToModel(OpportunityPriority e, OpportunityPriorityLovDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
    }

}
