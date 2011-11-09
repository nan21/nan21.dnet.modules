/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sd.opportunity.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.sd.opportunity.ds.model.OpportunityStatusDs;
import net.nan21.dnet.module.sd.opportunity.domain.entity.OpportunityStatus;

public class OpportunityStatusDsConv extends
        AbstractDsConverter<OpportunityStatusDs, OpportunityStatus> implements
        IDsConverter<OpportunityStatusDs, OpportunityStatus> {

    protected void modelToEntityAttributes(OpportunityStatusDs ds,
            OpportunityStatus e) throws Exception {
        e.setName(ds.getName());
        e.setActive(ds.getActive());
        e.setDescription(ds.getDescription());
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
        e.setSequenceNo(ds.getSequenceNo());
    }

    protected void modelToEntityReferences(OpportunityStatusDs ds,
            OpportunityStatus e) throws Exception {
    }

    @Override
    public void entityToModel(OpportunityStatus e, OpportunityStatusDs ds)
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
