/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.base.attr.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;

import net.nan21.dnet.module.md.base.attr.domain.entity.AttributeGroup;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = AttributeGroup.class, sort = { @SortField(field = AttributeGroupDs.fNAME) })
public class AttributeGroupDs extends AbstractTypeDs<AttributeGroup> {

    public AttributeGroupDs() {
        super();
    }

    public AttributeGroupDs(AttributeGroup e) {
        super(e);
    }

}
