/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.bp.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;

import net.nan21.dnet.module.md.bp.domain.entity.BpBalance;

public interface IBpBalanceService extends IEntityService<BpBalance> {

    public List<BpBalance> findByBpartner(BusinessPartner bpartner);

    public List<BpBalance> findByBpartnerId(Long bpartnerId);

    public List<BpBalance> findByOrg(Organization org);

    public List<BpBalance> findByOrgId(Long orgId);

    public List<BpBalance> findByCurrency(Currency currency);

    public List<BpBalance> findByCurrencyId(Long currencyId);

}
