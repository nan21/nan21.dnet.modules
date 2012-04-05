/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.fin.business.service;

import net.nan21.dnet.core.api.service.IEntityService;

import net.nan21.dnet.module.bd.fin.domain.entity.PaymentTerm;

public interface IPaymentTermService extends IEntityService<PaymentTerm> {

    public PaymentTerm findByName(String name);

}
