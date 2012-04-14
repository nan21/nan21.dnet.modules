/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.pj.base.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;

import net.nan21.dnet.module.pj.base.domain.entity.IssueCategory;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = IssueCategory.class, sort = { @SortField(field = IssueCategoryDs.fNAME) })
public class IssueCategoryDs extends AbstractTypeDs<IssueCategory> {

    public IssueCategoryDs() {
        super();
    }

    public IssueCategoryDs(IssueCategory e) {
        super(e);
    }

}
