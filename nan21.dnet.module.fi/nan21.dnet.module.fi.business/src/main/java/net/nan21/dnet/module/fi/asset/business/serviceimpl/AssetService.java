/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.fi.asset.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.fi.asset.business.service.IAssetService;
import net.nan21.dnet.module.fi.asset.domain.entity.AssetCategory;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.fi.asset.domain.entity.Asset;

public class AssetService extends AbstractEntityService<Asset> implements
        IAssetService {

    public AssetService() {
        super();
    }

    public AssetService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<Asset> getEntityClass() {
        return Asset.class;
    }

    public List<Asset> findByCategory(AssetCategory category) {
        return this.findByCategoryId(category.getId());
    }

    public List<Asset> findByCategoryId(Long categoryId) {
        return (List<Asset>) this.em
                .createQuery(
                        "select e from Asset e where e.clientId = :pClientId and e.category.id = :pCategoryId",
                        Asset.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pCategoryId", categoryId).getResultList();
    }

}
