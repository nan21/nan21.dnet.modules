/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bp.base.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.bp.base.ds.model.DeliveryMethodLovDs;
import net.nan21.dnet.module.bp.base.domain.entity.DeliveryMethod;

public class DeliveryMethodLovDsConv extends
        AbstractDsConverter<DeliveryMethodLovDs, DeliveryMethod> implements
        IDsConverter<DeliveryMethodLovDs, DeliveryMethod> {

    protected void modelToEntityAttributes(DeliveryMethodLovDs ds,
            DeliveryMethod e) throws Exception {
        e.setClientId(ds.getClientId());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(DeliveryMethodLovDs ds,
            DeliveryMethod e) throws Exception {
    }

    @Override
    public void entityToModel(DeliveryMethod e, DeliveryMethodLovDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
    }

}
