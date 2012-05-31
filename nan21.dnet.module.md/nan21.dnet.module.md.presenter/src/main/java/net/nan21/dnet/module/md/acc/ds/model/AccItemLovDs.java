/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.acc.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;

import net.nan21.dnet.module.md.acc.domain.entity.AccItem;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = AccItem.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = AccItemLovDs.fNAME) })
public class AccItemLovDs extends AbstractTypeLov<AccItem> {

    public AccItemLovDs() {
        super();
    }

    public AccItemLovDs(AccItem e) {
        super(e);
    }

}
