/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.tx.fin.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.bd.tx.domain.entity.PaymentMethod;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;

import net.nan21.dnet.module.md.tx.fin.domain.entity.TxAmount;

public interface ITxAmountService extends IEntityService<TxAmount> {

    public List<TxAmount> findByBpartner(BusinessPartner bpartner);

    public List<TxAmount> findByBpartnerId(Long bpartnerId);

    public List<TxAmount> findByOrg(Organization org);

    public List<TxAmount> findByOrgId(Long orgId);

    public List<TxAmount> findByPaymentMethod(PaymentMethod paymentMethod);

    public List<TxAmount> findByPaymentMethodId(Long paymentMethodId);

}
