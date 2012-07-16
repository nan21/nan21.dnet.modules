/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.pj.base.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;
import net.nan21.dnet.module.pj.base.domain.entity.IssueResolution;

@Ds(entity = IssueResolution.class, sort = { @SortField(field = IssueResolutionDs.fNAME) })
public class IssueResolutionDs extends AbstractTypeDs<IssueResolution> {

    public IssueResolutionDs() {
        super();
    }

    public IssueResolutionDs(IssueResolution e) {
        super(e);
    }

}
