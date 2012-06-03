/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.base.attr.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;

import net.nan21.dnet.module.md.base.attr.domain.entity.AttributeCategory;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = AttributeCategory.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = AttributeCategoryLovDs.fNAME) })
public class AttributeCategoryLovDs extends AbstractTypeLov<AttributeCategory> {

    public AttributeCategoryLovDs() {
        super();
    }

    public AttributeCategoryLovDs(AttributeCategory e) {
        super(e);
    }

}
