/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bp.base.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeLov;

import net.nan21.dnet.module.bp.base.domain.entity.CustomerGroup;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = CustomerGroup.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = CustomerGroupLovDs.fCODE) })
public class CustomerGroupLovDs extends AbstractTypeWithCodeLov<CustomerGroup> {

    public CustomerGroupLovDs() {
        super();
    }

    public CustomerGroupLovDs(CustomerGroup e) {
        super(e);
    }

}
