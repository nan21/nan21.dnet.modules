/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.pj.base.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;
import net.nan21.dnet.module.pj.base.domain.entity.IssueTextType;

@Ds(entity = IssueTextType.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = IssueTextTypeLovDs.fNAME) })
public class IssueTextTypeLovDs extends AbstractTypeLov<IssueTextType> {

    public IssueTextTypeLovDs() {
        super();
    }

    public IssueTextTypeLovDs(IssueTextType e) {
        super(e);
    }

}
