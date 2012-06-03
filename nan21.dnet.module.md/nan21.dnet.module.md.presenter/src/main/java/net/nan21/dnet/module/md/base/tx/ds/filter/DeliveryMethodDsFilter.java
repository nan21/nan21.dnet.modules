/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.base.tx.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractTypeDsFilter;

public class DeliveryMethodDsFilter extends AbstractTypeDsFilter {

    private Boolean delivery;

    private Boolean externalCourier;

    public Boolean getDelivery() {
        return this.delivery;
    }

    public void setDelivery(Boolean delivery) {
        this.delivery = delivery;
    }

    public Boolean getExternalCourier() {
        return this.externalCourier;
    }

    public void setExternalCourier(Boolean externalCourier) {
        this.externalCourier = externalCourier;
    }

}
