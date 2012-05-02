/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.bp.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeDs;

import net.nan21.dnet.module.md.bp.domain.entity.CustomerGroup;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = CustomerGroup.class, sort = { @SortField(field = CustomerGroupDs.fNAME) })
public class CustomerGroupDs extends AbstractTypeWithCodeDs<CustomerGroup> {

    public CustomerGroupDs() {
        super();
    }

    public CustomerGroupDs(CustomerGroup e) {
        super(e);
    }

}
