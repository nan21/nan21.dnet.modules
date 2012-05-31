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

import net.nan21.dnet.module.md.org.domain.entity.PayAccount;

public interface IPayAccountService extends IEntityService<PayAccount> {

    public PayAccount findByName(String name);

    public List<PayAccount> findByOrg(Organization org);

    public List<PayAccount> findByOrgId(Long orgId);

    public List<PayAccount> findByCurrency(Currency currency);

    public List<PayAccount> findByCurrencyId(Long currencyId);

    public List<PayAccount> findByJournal(AccJournal journal);

    public List<PayAccount> findByJournalId(Long journalId);

}
