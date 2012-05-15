/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sd.opportunity.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;

import net.nan21.dnet.module.sd.opportunity.domain.entity.OpportunityPriority;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = OpportunityPriority.class, sort = { @SortField(field = OpportunityPriorityDs.fNAME) })
public class OpportunityPriorityDs extends AbstractTypeDs<OpportunityPriority> {

    public static final String fSEQUENCENO = "sequenceNo";

    @DsField()
    private Integer sequenceNo;

    public OpportunityPriorityDs() {
        super();
    }

    public OpportunityPriorityDs(OpportunityPriority e) {
        super(e);
    }

    public Integer getSequenceNo() {
        return this.sequenceNo;
    }

    public void setSequenceNo(Integer sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

}
