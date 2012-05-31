/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.tx.fin.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.md.base.tx.domain.entity.PaymentMethod;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;
import net.nan21.dnet.module.md.org.domain.entity.PayAccount;
import net.nan21.dnet.module.md.tx.fin.domain.entity.PaymentItem;

import net.nan21.dnet.module.md.tx.fin.domain.entity.Payment;

public interface IPaymentService extends IEntityService<Payment> {

    public List<Payment> findByCurrency(Currency currency);

    public List<Payment> findByCurrencyId(Long currencyId);

    public List<Payment> findByPaymentMethod(PaymentMethod paymentMethod);

    public List<Payment> findByPaymentMethodId(Long paymentMethodId);

    public List<Payment> findByFromOrg(Organization fromOrg);

    public List<Payment> findByFromOrgId(Long fromOrgId);

    public List<Payment> findByToOrg(Organization toOrg);

    public List<Payment> findByToOrgId(Long toOrgId);

    public List<Payment> findByFromAccount(PayAccount fromAccount);

    public List<Payment> findByFromAccountId(Long fromAccountId);

    public List<Payment> findByToAccount(PayAccount toAccount);

    public List<Payment> findByToAccountId(Long toAccountId);

    public List<Payment> findByBpartner(BusinessPartner bpartner);

    public List<Payment> findByBpartnerId(Long bpartnerId);

    public List<Payment> findByLines(PaymentItem lines);

    public List<Payment> findByLinesId(Long linesId);

}
