/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.bp.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.md.base.tx.domain.entity.PaymentMethod;
import net.nan21.dnet.module.md.base.tx.domain.entity.PaymentTerm;
import net.nan21.dnet.module.md.bp.domain.entity.CustomerGroupAcct;

import net.nan21.dnet.module.md.bp.domain.entity.CustomerGroup;

public interface ICustomerGroupService extends IEntityService<CustomerGroup> {

    public CustomerGroup findByCode(String code);

    public CustomerGroup findByName(String name);

    public List<CustomerGroup> findByPaymentMethod(PaymentMethod paymentMethod);

    public List<CustomerGroup> findByPaymentMethodId(Long paymentMethodId);

    public List<CustomerGroup> findByPaymentTerm(PaymentTerm paymentTerm);

    public List<CustomerGroup> findByPaymentTermId(Long paymentTermId);

    public List<CustomerGroup> findByAccounts(CustomerGroupAcct accounts);

    public List<CustomerGroup> findByAccountsId(Long accountsId);

}
