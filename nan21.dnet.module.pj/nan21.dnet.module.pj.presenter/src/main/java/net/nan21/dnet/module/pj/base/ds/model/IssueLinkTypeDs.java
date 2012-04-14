/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.pj.base.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;

import net.nan21.dnet.module.pj.base.domain.entity.IssueLinkType;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = IssueLinkType.class, sort = { @SortField(field = IssueLinkTypeDs.fNAME) })
public class IssueLinkTypeDs extends AbstractTypeDs<IssueLinkType> {

    public IssueLinkTypeDs() {
        super();
    }

    public IssueLinkTypeDs(IssueLinkType e) {
        super(e);
    }

}
