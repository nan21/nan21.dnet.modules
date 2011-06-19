/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bp.base.domain.service;

import net.nan21.dnet.core.api.service.IEntityService;

import net.nan21.dnet.module.bp.base.domain.entity.PaymentMethod;

public interface IPaymentMethodService extends IEntityService<PaymentMethod> {

    public PaymentMethod findByName(Long clientId, String name);

}
