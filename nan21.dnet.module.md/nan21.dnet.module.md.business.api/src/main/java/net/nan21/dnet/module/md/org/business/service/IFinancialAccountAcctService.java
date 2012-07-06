/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.org.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.md.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.md.acc.domain.entity.Account;
import net.nan21.dnet.module.md.org.domain.entity.FinancialAccount;

import net.nan21.dnet.module.md.org.domain.entity.FinancialAccountAcct;

public interface IFinancialAccountAcctService extends
        IEntityService<FinancialAccountAcct> {

    public FinancialAccountAcct findByAccount_schema(
            FinancialAccount financialAccount, AccSchema accSchema);

    public FinancialAccountAcct findByAccount_schema(Long financialAccountId,
            Long accSchemaId);

    public List<FinancialAccountAcct> findByFinancialAccount(
            FinancialAccount financialAccount);

    public List<FinancialAccountAcct> findByFinancialAccountId(
            Long financialAccountId);

    public List<FinancialAccountAcct> findByAccSchema(AccSchema accSchema);

    public List<FinancialAccountAcct> findByAccSchemaId(Long accSchemaId);

    public List<FinancialAccountAcct> findByDepositAccount(
            Account depositAccount);

    public List<FinancialAccountAcct> findByDepositAccountId(
            Long depositAccountId);

    public List<FinancialAccountAcct> findByWithdrawalAccount(
            Account withdrawalAccount);

    public List<FinancialAccountAcct> findByWithdrawalAccountId(
            Long withdrawalAccountId);

    public String getPostingDepositAcct(FinancialAccount financialAccount,
            AccSchema schema) throws Exception;

    public String getPostingWithdrawalAcct(FinancialAccount financialAccount,
            AccSchema schema) throws Exception;

}
