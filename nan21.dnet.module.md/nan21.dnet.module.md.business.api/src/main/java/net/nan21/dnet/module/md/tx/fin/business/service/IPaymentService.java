/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.tx.fin.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.bd.tx.domain.entity.PaymentMethod;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;

import net.nan21.dnet.module.md.tx.fin.domain.entity.Payment;

public interface IPaymentService extends IEntityService<Payment> {

    public List<Payment> findByBpartner(BusinessPartner bpartner);

    public List<Payment> findByBpartnerId(Long bpartnerId);

    public List<Payment> findByOrg(Organization org);

    public List<Payment> findByOrgId(Long orgId);

    public List<Payment> findByCurrency(Currency currency);

    public List<Payment> findByCurrencyId(Long currencyId);

    public List<Payment> findByPaymentMethod(PaymentMethod paymentMethod);

    public List<Payment> findByPaymentMethodId(Long paymentMethodId);

}
