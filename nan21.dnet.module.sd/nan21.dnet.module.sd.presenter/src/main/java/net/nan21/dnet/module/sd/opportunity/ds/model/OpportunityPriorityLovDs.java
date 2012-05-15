/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sd.opportunity.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;

import net.nan21.dnet.module.sd.opportunity.domain.entity.OpportunityPriority;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = OpportunityPriority.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = OpportunityPriorityLovDs.fNAME) })
public class OpportunityPriorityLovDs extends
        AbstractTypeLov<OpportunityPriority> {

    public OpportunityPriorityLovDs() {
        super();
    }

    public OpportunityPriorityLovDs(OpportunityPriority e) {
        super(e);
    }

}
