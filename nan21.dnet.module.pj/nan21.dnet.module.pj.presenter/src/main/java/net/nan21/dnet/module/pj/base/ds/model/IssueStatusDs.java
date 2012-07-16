/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.pj.base.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;
import net.nan21.dnet.module.pj.base.domain.entity.IssueStatus;

@Ds(entity = IssueStatus.class, sort = { @SortField(field = IssueStatusDs.fNAME) })
public class IssueStatusDs extends AbstractTypeDs<IssueStatus> {

    public IssueStatusDs() {
        super();
    }

    public IssueStatusDs(IssueStatus e) {
        super(e);
    }

}
