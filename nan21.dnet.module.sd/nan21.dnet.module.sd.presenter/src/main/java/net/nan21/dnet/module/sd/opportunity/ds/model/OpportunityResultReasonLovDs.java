/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sd.opportunity.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;

import net.nan21.dnet.module.sd.opportunity.domain.entity.OpportunityResultReason;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = OpportunityResultReason.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = OpportunityResultReasonLovDs.fNAME) })
public class OpportunityResultReasonLovDs extends
        AbstractTypeLov<OpportunityResultReason> {

    public OpportunityResultReasonLovDs() {
        super();
    }

    public OpportunityResultReasonLovDs(OpportunityResultReason e) {
        super(e);
    }

}
