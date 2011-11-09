/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sd.opportunity.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.sd.opportunity.ds.model.OpportunityStageLovDs;
import net.nan21.dnet.module.sd.opportunity.domain.entity.OpportunityStage;

public class OpportunityStageLovDsConv extends
        AbstractDsConverter<OpportunityStageLovDs, OpportunityStage> implements
        IDsConverter<OpportunityStageLovDs, OpportunityStage> {

    protected void modelToEntityAttributes(OpportunityStageLovDs ds,
            OpportunityStage e) throws Exception {
        e.setClientId(ds.getClientId());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(OpportunityStageLovDs ds,
            OpportunityStage e) throws Exception {
    }

    @Override
    public void entityToModel(OpportunityStage e, OpportunityStageLovDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
    }

}
