/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sd.opportunity.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;
import net.nan21.dnet.module.sd.opportunity.domain.entity.OpportunityStage;

@Ds(entity = OpportunityStage.class, sort = { @SortField(field = OpportunityStageDs.fNAME) })
public class OpportunityStageDs extends AbstractTypeDs<OpportunityStage> {

    public OpportunityStageDs() {
        super();
    }

    public OpportunityStageDs(OpportunityStage e) {
        super(e);
    }

}
