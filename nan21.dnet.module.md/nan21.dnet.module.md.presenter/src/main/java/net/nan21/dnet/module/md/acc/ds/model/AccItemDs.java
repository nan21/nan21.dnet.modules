/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.acc.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;
import net.nan21.dnet.module.md.acc.domain.entity.AccItem;

@Ds(entity = AccItem.class, sort = { @SortField(field = AccItemDs.fNAME) })
public class AccItemDs extends AbstractTypeDs<AccItem> {

    public AccItemDs() {
        super();
    }

    public AccItemDs(AccItem e) {
        super(e);
    }

}
