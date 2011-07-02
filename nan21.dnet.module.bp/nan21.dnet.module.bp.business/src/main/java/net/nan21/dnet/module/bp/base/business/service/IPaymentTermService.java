/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bp.base.business.service;

import net.nan21.dnet.core.api.service.IEntityService;

import net.nan21.dnet.module.bp.base.domain.entity.PaymentTerm;

public interface IPaymentTermService extends IEntityService<PaymentTerm> {

    public PaymentTerm findByName(Long clientId, String name);

}
