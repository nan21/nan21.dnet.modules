/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.pj.base.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;

import net.nan21.dnet.module.pj.base.domain.entity.IssueResolution;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = IssueResolution.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = IssueResolutionLovDs.fNAME) })
public class IssueResolutionLovDs extends AbstractTypeLov<IssueResolution> {

    public IssueResolutionLovDs() {
        super();
    }

    public IssueResolutionLovDs(IssueResolution e) {
        super(e);
    }

}
