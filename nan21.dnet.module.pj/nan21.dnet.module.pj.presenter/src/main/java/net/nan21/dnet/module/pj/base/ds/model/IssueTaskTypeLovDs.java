/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.pj.base.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;

import net.nan21.dnet.module.pj.base.domain.entity.IssueTaskType;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = IssueTaskType.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = IssueTaskTypeLovDs.fNAME) })
public class IssueTaskTypeLovDs extends AbstractTypeLov<IssueTaskType> {

    public IssueTaskTypeLovDs() {
        super();
    }

    public IssueTaskTypeLovDs(IssueTaskType e) {
        super(e);
    }

}
