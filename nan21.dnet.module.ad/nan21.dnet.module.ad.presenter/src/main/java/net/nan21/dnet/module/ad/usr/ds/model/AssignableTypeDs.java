/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.usr.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;

import net.nan21.dnet.module.ad.usr.domain.entity.AssignableType;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = AssignableType.class, sort = { @SortField(field = AssignableTypeDs.fNAME) })
public class AssignableTypeDs extends AbstractTypeDs<AssignableType> {

    public AssignableTypeDs() {
        super();
    }

    public AssignableTypeDs(AssignableType e) {
        super(e);
    }

}
