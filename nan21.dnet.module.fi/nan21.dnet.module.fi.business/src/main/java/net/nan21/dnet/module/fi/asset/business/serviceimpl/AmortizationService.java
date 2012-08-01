/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.fi.asset.business.serviceimpl;

import java.util.Date;
import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.fi.asset.business.service.IAmortizationService;
import net.nan21.dnet.module.fi.asset.domain.entity.Asset;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.fi.asset.domain.entity.Amortization;

public class AmortizationService extends AbstractEntityService<Amortization>
        implements IAmortizationService {

    public AmortizationService() {
        super();
    } 

    public AmortizationService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<Amortization> getEntityClass() {
        return Amortization.class;
    }

    public Amortization findByAmort(Asset asset, Date postingDate) {
        return (Amortization) this.em
                .createNamedQuery(Amortization.NQ_FIND_BY_AMORT)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pAsset", asset)
                .setParameter("pPostingDate", postingDate).getSingleResult();
    }

    public Amortization findByAmort(Long assetId, Date postingDate) {
        return (Amortization) this.em
                .createNamedQuery(Amortization.NQ_FIND_BY_AMORT_PRIMITIVE)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pAssetId", assetId)
                .setParameter("pPostingDate", postingDate).getSingleResult();
    }

    public List<Amortization> findByAsset(Asset asset) {
        return this.findByAssetId(asset.getId());
    }

    public List<Amortization> findByAssetId(Long assetId) {
        return (List<Amortization>) this.em
                .createQuery(
                        "select e from Amortization e where e.clientId = :pClientId and e.asset.id = :pAssetId",
                        Amortization.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pAssetId", assetId).getResultList();
    }

}
