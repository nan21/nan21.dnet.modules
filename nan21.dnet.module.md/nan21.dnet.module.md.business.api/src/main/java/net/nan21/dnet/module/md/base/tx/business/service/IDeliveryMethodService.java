/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.base.tx.business.service;

import net.nan21.dnet.core.api.service.IEntityService;

import net.nan21.dnet.module.md.base.tx.domain.entity.DeliveryMethod;

public interface IDeliveryMethodService extends IEntityService<DeliveryMethod> {

    public DeliveryMethod findByName(String name);

}
