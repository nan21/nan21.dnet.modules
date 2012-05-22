/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.fi.asset.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.fi.asset.business.service.IAmortizationItemService;
import net.nan21.dnet.module.fi.asset.domain.entity.Asset;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.fi.asset.domain.entity.AmortizationItem;

public class AmortizationItemService extends
        AbstractEntityService<AmortizationItem> implements
        IAmortizationItemService {

    public AmortizationItemService() {
        super();
    }

    public AmortizationItemService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<AmortizationItem> getEntityClass() {
        return AmortizationItem.class;
    }

    public List<AmortizationItem> findByAsset(Asset asset) {
        return this.findByAssetId(asset.getId());
    }

    public List<AmortizationItem> findByAssetId(Long assetId) {
        return (List<AmortizationItem>) this.em
                .createQuery(
                        "select e from AmortizationItem e where e.clientId = :pClientId and e.asset.id = :pAssetId",
                        AmortizationItem.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pAssetId", assetId).getResultList();
    }

    public List<AmortizationItem> findByCurrency(Currency currency) {
        return this.findByCurrencyId(currency.getId());
    }

    public List<AmortizationItem> findByCurrencyId(Long currencyId) {
        return (List<AmortizationItem>) this.em
                .createQuery(
                        "select e from AmortizationItem e where e.clientId = :pClientId and e.currency.id = :pCurrencyId",
                        AmortizationItem.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pCurrencyId", currencyId).getResultList();
    }

}
