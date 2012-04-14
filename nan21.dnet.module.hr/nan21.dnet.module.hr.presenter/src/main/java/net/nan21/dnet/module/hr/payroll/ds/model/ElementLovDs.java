/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.payroll.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeLov;

import net.nan21.dnet.module.hr.payroll.domain.entity.Element;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = Element.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = ElementLovDs.fCODE) })
public class ElementLovDs extends AbstractTypeWithCodeLov<Element> {

    public ElementLovDs() {
        super();
    }

    public ElementLovDs(Element e) {
        super(e);
    }

}
