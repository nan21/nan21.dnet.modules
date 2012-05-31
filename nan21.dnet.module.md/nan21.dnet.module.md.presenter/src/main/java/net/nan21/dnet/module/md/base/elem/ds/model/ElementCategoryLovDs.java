/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.base.elem.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;

import net.nan21.dnet.module.md.base.elem.domain.entity.ElementCategory;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = ElementCategory.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = ElementCategoryLovDs.fNAME) })
public class ElementCategoryLovDs extends AbstractTypeLov<ElementCategory> {

    public ElementCategoryLovDs() {
        super();
    }

    public ElementCategoryLovDs(ElementCategory e) {
        super(e);
    }

}
