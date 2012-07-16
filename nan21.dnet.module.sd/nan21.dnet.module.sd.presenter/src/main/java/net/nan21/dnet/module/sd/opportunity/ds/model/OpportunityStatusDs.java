/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sd.opportunity.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;
import net.nan21.dnet.module.sd.opportunity.domain.entity.OpportunityStatus;

@Ds(entity = OpportunityStatus.class, sort = { @SortField(field = OpportunityStatusDs.fNAME) })
public class OpportunityStatusDs extends AbstractTypeDs<OpportunityStatus> {

    public static final String fSEQUENCENO = "sequenceNo";

    @DsField()
    private Integer sequenceNo;

    public OpportunityStatusDs() {
        super();
    }

    public OpportunityStatusDs(OpportunityStatus e) {
        super(e);
    }

    public Integer getSequenceNo() {
        return this.sequenceNo;
    }

    public void setSequenceNo(Integer sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

}
