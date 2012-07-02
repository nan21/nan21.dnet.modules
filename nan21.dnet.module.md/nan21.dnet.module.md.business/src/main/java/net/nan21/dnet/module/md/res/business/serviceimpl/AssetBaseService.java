/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.res.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;
import net.nan21.dnet.module.md.res.business.service.IAssetBaseService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.md.res.domain.entity.AssetBase;

public class AssetBaseService extends AbstractEntityService<AssetBase>
        implements IAssetBaseService {

    public AssetBaseService() {
        super();
    }

    public AssetBaseService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<AssetBase> getEntityClass() {
        return AssetBase.class;
    }

    public AssetBase findByCode(String code) {
        return (AssetBase) this.em.createNamedQuery(AssetBase.NQ_FIND_BY_CODE)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pCode", code).getSingleResult();
    }

    public List<AssetBase> findByOrg(Organization org) {
        return this.findByOrgId(org.getId());
    }

    public List<AssetBase> findByOrgId(Long orgId) {
        return (List<AssetBase>) this.em
                .createQuery(
                        "select e from AssetBase e where e.clientId = :pClientId and e.org.id = :pOrgId",
                        AssetBase.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pOrgId", orgId).getResultList();
    }

    public List<AssetBase> findByProduct(Product product) {
        return this.findByProductId(product.getId());
    }

    public List<AssetBase> findByProductId(Long productId) {
        return (List<AssetBase>) this.em
                .createQuery(
                        "select e from AssetBase e where e.clientId = :pClientId and e.product.id = :pProductId",
                        AssetBase.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pProductId", productId).getResultList();
    }

}
