/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.base.attr.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;

import net.nan21.dnet.module.md.base.attr.domain.entity.AttributeCategory;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = AttributeCategory.class, sort = { @SortField(field = AttributeCategoryDs.fNAME) })
public class AttributeCategoryDs extends AbstractTypeDs<AttributeCategory> {

    public AttributeCategoryDs() {
        super();
    }

    public AttributeCategoryDs(AttributeCategory e) {
        super(e);
    }

}
