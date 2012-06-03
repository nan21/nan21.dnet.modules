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
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;

import net.nan21.dnet.module.md.tx.fin.domain.entity.TxBalance;

public interface ITxBalanceService extends IEntityService<TxBalance> {

    public List<TxBalance> findByBpartner(BusinessPartner bpartner);

    public List<TxBalance> findByBpartnerId(Long bpartnerId);

    public List<TxBalance> findByOrg(Organization org);

    public List<TxBalance> findByOrgId(Long orgId);

    public List<TxBalance> findByCurrency(Currency currency);

    public List<TxBalance> findByCurrencyId(Long currencyId);

}
