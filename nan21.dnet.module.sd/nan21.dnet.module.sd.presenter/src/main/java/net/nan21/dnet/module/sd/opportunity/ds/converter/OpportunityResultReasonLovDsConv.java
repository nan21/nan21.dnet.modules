/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sd.opportunity.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.sd.opportunity.ds.model.OpportunityResultReasonLovDs;
import net.nan21.dnet.module.sd.opportunity.domain.entity.OpportunityResultReason;

public class OpportunityResultReasonLovDsConv
        extends
        AbstractDsConverter<OpportunityResultReasonLovDs, OpportunityResultReason>
        implements
        IDsConverter<OpportunityResultReasonLovDs, OpportunityResultReason> {

    protected void modelToEntityAttributes(OpportunityResultReasonLovDs ds,
            OpportunityResultReason e) throws Exception {
        e.setClientId(ds.getClientId());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(OpportunityResultReasonLovDs ds,
            OpportunityResultReason e) throws Exception {
    }

    @Override
    public void entityToModel(OpportunityResultReason e,
            OpportunityResultReasonLovDs ds) throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
    }

}
