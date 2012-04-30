/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.tx.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.tx.domain.entity.TxDocType;

import net.nan21.dnet.module.bd.tx.domain.entity.PaymentMethod;

public interface IPaymentMethodService extends IEntityService<PaymentMethod> {

    public PaymentMethod findByName(String name);

    public List<PaymentMethod> findByDocType(TxDocType docType);

    public List<PaymentMethod> findByDocTypeId(Long docTypeId);

}
