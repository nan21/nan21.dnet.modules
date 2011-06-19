/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bp.base.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.bp.base.ds.model.PaymentTermLovDs;
import net.nan21.dnet.module.bp.base.domain.entity.PaymentTerm;

public class PaymentTermLovDsConv extends
        AbstractDsConverter<PaymentTermLovDs, PaymentTerm> implements
        IDsConverter<PaymentTermLovDs, PaymentTerm> {

    protected void modelToEntityAttributes(PaymentTermLovDs ds, PaymentTerm e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(PaymentTermLovDs ds, PaymentTerm e)
            throws Exception {
    }

    @Override
    public void entityToModel(PaymentTerm e, PaymentTermLovDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
    }

}
