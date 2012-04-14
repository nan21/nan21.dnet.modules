/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bp.base.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;

import net.nan21.dnet.module.bp.base.domain.entity.DeliveryMethod;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = DeliveryMethod.class, sort = { @SortField(field = DeliveryMethodDs.fNAME) })
public class DeliveryMethodDs extends AbstractTypeDs<DeliveryMethod> {

    public DeliveryMethodDs() {
        super();
    }

    public DeliveryMethodDs(DeliveryMethod e) {
        super(e);
    }

}
