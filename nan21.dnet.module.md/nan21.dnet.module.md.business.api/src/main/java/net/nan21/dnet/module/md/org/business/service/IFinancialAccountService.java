/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.org.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.md.acc.domain.entity.AccJournal;

import net.nan21.dnet.module.md.org.domain.entity.FinancialAccount;

public interface IFinancialAccountService extends
        IEntityService<FinancialAccount> {

    public FinancialAccount findByName(String name);

    public List<FinancialAccount> findByOrg(Organization org);

    public List<FinancialAccount> findByOrgId(Long orgId);

    public List<FinancialAccount> findByCurrency(Currency currency);

    public List<FinancialAccount> findByCurrencyId(Long currencyId);

    public List<FinancialAccount> findByJournal(AccJournal journal);

    public List<FinancialAccount> findByJournalId(Long journalId);

}
