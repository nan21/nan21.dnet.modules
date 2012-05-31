/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.base.attr.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;

import net.nan21.dnet.module.md.base.attr.domain.entity.Attribute;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = Attribute.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = AttributeLovDs.fNAME) })
public class AttributeLovDs extends AbstractTypeLov<Attribute> {

    public AttributeLovDs() {
        super();
    }

    public AttributeLovDs(Attribute e) {
        super(e);
    }

}
