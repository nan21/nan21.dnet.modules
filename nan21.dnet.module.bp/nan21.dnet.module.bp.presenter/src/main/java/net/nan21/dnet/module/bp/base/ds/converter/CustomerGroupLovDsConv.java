/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bp.base.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.bp.base.ds.model.CustomerGroupLovDs;
import net.nan21.dnet.module.bp.base.domain.entity.CustomerGroup;

public class CustomerGroupLovDsConv extends
        AbstractDsConverter<CustomerGroupLovDs, CustomerGroup> implements
        IDsConverter<CustomerGroupLovDs, CustomerGroup> {

    protected void modelToEntityAttributes(CustomerGroupLovDs ds,
            CustomerGroup e) throws Exception {
        e.setClientId(ds.getClientId());
        e.setCode(ds.getCode());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(CustomerGroupLovDs ds,
            CustomerGroup e) throws Exception {
    }

    @Override
    public void entityToModel(CustomerGroup e, CustomerGroupLovDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCode(e.getCode());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
    }

}
