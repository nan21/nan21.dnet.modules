/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.base.elem.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;

import net.nan21.dnet.module.md.base.elem.domain.entity.ElementCategory;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = ElementCategory.class, sort = { @SortField(field = ElementCategoryDs.fNAME) })
public class ElementCategoryDs extends AbstractTypeDs<ElementCategory> {

    public ElementCategoryDs() {
        super();
    }

    public ElementCategoryDs(ElementCategory e) {
        super(e);
    }

}
