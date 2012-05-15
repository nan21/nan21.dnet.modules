/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.pj.base.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;

import net.nan21.dnet.module.pj.base.domain.entity.IssueSeverity;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = IssueSeverity.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = IssueSeverityLovDs.fSEQUENCENO) })
public class IssueSeverityLovDs extends AbstractTypeLov<IssueSeverity> {

    public static final String fSEQUENCENO = "sequenceNo";

    @DsField()
    private Integer sequenceNo;

    public IssueSeverityLovDs() {
        super();
    }

    public IssueSeverityLovDs(IssueSeverity e) {
        super(e);
    }

    public Integer getSequenceNo() {
        return this.sequenceNo;
    }

    public void setSequenceNo(Integer sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

}
