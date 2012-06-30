/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.attr.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;

import net.nan21.dnet.module.bd.attr.domain.entity.AttributeSet;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = AttributeSet.class, sort = { @SortField(field = AttributeSetDs.fNAME) })
public class AttributeSetDs extends AbstractTypeDs<AttributeSet> {

    public AttributeSetDs() {
        super();
    }

    public AttributeSetDs(AttributeSet e) {
        super(e);
    }

}
