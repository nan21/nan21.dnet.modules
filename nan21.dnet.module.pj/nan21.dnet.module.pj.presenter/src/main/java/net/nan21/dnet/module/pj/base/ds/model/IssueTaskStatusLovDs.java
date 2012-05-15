/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.pj.base.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;

import net.nan21.dnet.module.pj.base.domain.entity.IssueTaskStatus;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = IssueTaskStatus.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = IssueTaskStatusLovDs.fNAME) })
public class IssueTaskStatusLovDs extends AbstractTypeLov<IssueTaskStatus> {

    public IssueTaskStatusLovDs() {
        super();
    }

    public IssueTaskStatusLovDs(IssueTaskStatus e) {
        super(e);
    }

}
