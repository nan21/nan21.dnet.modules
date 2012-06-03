/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.base.attr.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;

import net.nan21.dnet.module.md.base.attr.domain.entity.AttributeGroup;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = AttributeGroup.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = AttributeGroupLovDs.fNAME) })
public class AttributeGroupLovDs extends AbstractTypeLov<AttributeGroup> {

    public AttributeGroupLovDs() {
        super();
    }

    public AttributeGroupLovDs(AttributeGroup e) {
        super(e);
    }

}
