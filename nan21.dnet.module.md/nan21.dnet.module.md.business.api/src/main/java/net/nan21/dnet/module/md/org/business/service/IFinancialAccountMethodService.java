/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.org.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.md.base.tx.domain.entity.PaymentMethod;
import net.nan21.dnet.module.md.org.domain.entity.FinancialAccount;

import net.nan21.dnet.module.md.org.domain.entity.FinancialAccountMethod;

public interface IFinancialAccountMethodService extends
        IEntityService<FinancialAccountMethod> {

    public FinancialAccountMethod findByAccount_mtd(
            FinancialAccount financialAccount, PaymentMethod payMethod);

    public FinancialAccountMethod findByAccount_mtd(Long financialAccountId,
            Long payMethodId);

    public List<FinancialAccountMethod> findByFinancialAccount(
            FinancialAccount financialAccount);

    public List<FinancialAccountMethod> findByFinancialAccountId(
            Long financialAccountId);

    public List<FinancialAccountMethod> findByPayMethod(PaymentMethod payMethod);

    public List<FinancialAccountMethod> findByPayMethodId(Long payMethodId);

}
