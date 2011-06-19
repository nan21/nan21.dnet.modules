/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bp.base.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.bp.base.ds.model.PaymentMethodLovDs;
import net.nan21.dnet.module.bp.base.domain.entity.PaymentMethod;

public class PaymentMethodLovDsConv extends
        AbstractDsConverter<PaymentMethodLovDs, PaymentMethod> implements
        IDsConverter<PaymentMethodLovDs, PaymentMethod> {

    protected void modelToEntityAttributes(PaymentMethodLovDs ds,
            PaymentMethod e) throws Exception {
        e.setClientId(ds.getClientId());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(PaymentMethodLovDs ds,
            PaymentMethod e) throws Exception {
    }

    @Override
    public void entityToModel(PaymentMethod e, PaymentMethodLovDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
    }

}
