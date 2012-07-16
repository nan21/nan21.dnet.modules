/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sd.opportunity.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;
import net.nan21.dnet.module.sd.opportunity.domain.entity.OpportunityResultReason;

@Ds(entity = OpportunityResultReason.class, sort = { @SortField(field = OpportunityResultReasonDs.fNAME) })
public class OpportunityResultReasonDs extends
        AbstractTypeDs<OpportunityResultReason> {

    public OpportunityResultReasonDs() {
        super();
    }

    public OpportunityResultReasonDs(OpportunityResultReason e) {
        super(e);
    }

}
