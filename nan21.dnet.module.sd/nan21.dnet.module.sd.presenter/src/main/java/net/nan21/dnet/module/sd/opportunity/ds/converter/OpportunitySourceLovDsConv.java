/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sd.opportunity.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.sd.opportunity.ds.model.OpportunitySourceLovDs;
import net.nan21.dnet.module.sd.opportunity.domain.entity.OpportunitySource;

public class OpportunitySourceLovDsConv extends
        AbstractDsConverter<OpportunitySourceLovDs, OpportunitySource>
        implements IDsConverter<OpportunitySourceLovDs, OpportunitySource> {

    protected void modelToEntityAttributes(OpportunitySourceLovDs ds,
            OpportunitySource e) throws Exception {
        e.setClientId(ds.getClientId());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(OpportunitySourceLovDs ds,
            OpportunitySource e) throws Exception {
    }

    @Override
    public void entityToModel(OpportunitySource e, OpportunitySourceLovDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
    }

}
