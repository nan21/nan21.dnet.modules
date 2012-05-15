/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.org.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.bd.acc.domain.entity.Account;
import net.nan21.dnet.module.md.org.domain.entity.PayAccount;

import net.nan21.dnet.module.md.org.domain.entity.PayAccountAcct;

public interface IPayAccountAcctService extends IEntityService<PayAccountAcct> {

    public PayAccountAcct findByAccount_schema(PayAccount payAccount,
            AccSchema accSchema);

    public PayAccountAcct findByAccount_schema(Long payAccountId,
            Long accSchemaId);

    public List<PayAccountAcct> findByPayAccount(PayAccount payAccount);

    public List<PayAccountAcct> findByPayAccountId(Long payAccountId);

    public List<PayAccountAcct> findByAccSchema(AccSchema accSchema);

    public List<PayAccountAcct> findByAccSchemaId(Long accSchemaId);

    public List<PayAccountAcct> findByDepositAccount(Account depositAccount);

    public List<PayAccountAcct> findByDepositAccountId(Long depositAccountId);

    public List<PayAccountAcct> findByWithdrawalAccount(
            Account withdrawalAccount);

    public List<PayAccountAcct> findByWithdrawalAccountId(
            Long withdrawalAccountId);

    public String getPostingDepositAcct(PayAccount payAccount, AccSchema schema)
            throws Exception;

    public String getPostingWithdrawalAcct(PayAccount payAccount,
            AccSchema schema) throws Exception;

}
