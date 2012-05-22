/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.fi.asset.business.serviceimpl;

import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.fi.asset.business.service.IAssetCategoryService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.fi.asset.domain.entity.AssetCategory;

public class AssetCategoryService extends AbstractEntityService<AssetCategory>
        implements IAssetCategoryService {

    public AssetCategoryService() {
        super();
    }

    public AssetCategoryService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<AssetCategory> getEntityClass() {
        return AssetCategory.class;
    }

    public AssetCategory findByCode(String code) {
        return (AssetCategory) this.em
                .createNamedQuery(AssetCategory.NQ_FIND_BY_CODE)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pCode", code).getSingleResult();
    }

    public AssetCategory findByName(String name) {
        return (AssetCategory) this.em
                .createNamedQuery(AssetCategory.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

}
