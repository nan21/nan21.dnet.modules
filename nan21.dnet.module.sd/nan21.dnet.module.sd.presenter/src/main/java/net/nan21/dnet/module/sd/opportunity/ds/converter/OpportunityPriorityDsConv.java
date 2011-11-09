/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sd.opportunity.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.sd.opportunity.ds.model.OpportunityPriorityDs;
import net.nan21.dnet.module.sd.opportunity.domain.entity.OpportunityPriority;

public class OpportunityPriorityDsConv extends
        AbstractDsConverter<OpportunityPriorityDs, OpportunityPriority>
        implements IDsConverter<OpportunityPriorityDs, OpportunityPriority> {

    protected void modelToEntityAttributes(OpportunityPriorityDs ds,
            OpportunityPriority e) throws Exception {
        e.setName(ds.getName());
        e.setActive(ds.getActive());
        e.setDescription(ds.getDescription());
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
        e.setSequenceNo(ds.getSequenceNo());
    }

    protected void modelToEntityReferences(OpportunityPriorityDs ds,
            OpportunityPriority e) throws Exception {
    }

    @Override
    public void entityToModel(OpportunityPriority e, OpportunityPriorityDs ds)
            throws Exception {
        ds.setName(e.getName());
        ds.setActive(e.getActive());
        ds.setDescription(e.getDescription());
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
        ds.setSequenceNo(e.getSequenceNo());
    }

}
