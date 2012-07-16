/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.pj.base.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;
import net.nan21.dnet.module.pj.base.domain.entity.IssueCategory;

@Ds(entity = IssueCategory.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = IssueCategoryLovDs.fNAME) })
public class IssueCategoryLovDs extends AbstractTypeLov<IssueCategory> {

    public IssueCategoryLovDs() {
        super();
    }

    public IssueCategoryLovDs(IssueCategory e) {
        super(e);
    }

}
