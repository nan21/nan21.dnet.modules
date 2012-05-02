/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.bp.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.md.bp.domain.entity.Bank;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;

import net.nan21.dnet.module.md.bp.domain.entity.BpBankAccount;

public interface IBpBankAccountService extends IEntityService<BpBankAccount> {

    public BpBankAccount findByAccount(BusinessPartner bpartner,
            String accountNo);

    public BpBankAccount findByAccount(Long bpartnerId, String accountNo);

    public List<BpBankAccount> findByBpartner(BusinessPartner bpartner);

    public List<BpBankAccount> findByBpartnerId(Long bpartnerId);

    public List<BpBankAccount> findByBank(Bank bank);

    public List<BpBankAccount> findByBankId(Long bankId);

    public List<BpBankAccount> findByCurrency(Currency currency);

    public List<BpBankAccount> findByCurrencyId(Long currencyId);

}
