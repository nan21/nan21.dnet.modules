/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.pj.base.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;

import net.nan21.dnet.module.pj.base.domain.entity.IssueTextType;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = IssueTextType.class, sort = { @SortField(field = IssueTextTypeDs.fNAME) })
public class IssueTextTypeDs extends AbstractTypeDs<IssueTextType> {

    public IssueTextTypeDs() {
        super();
    }

    public IssueTextTypeDs(IssueTextType e) {
        super(e);
    }

}
