/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.fi.asset.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.fi.asset.business.service.IAssetAcctService;
import net.nan21.dnet.module.fi.asset.domain.entity.Asset;
import net.nan21.dnet.module.md.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.md.acc.domain.entity.Account;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.fi.asset.domain.entity.AssetAcct;

public class AssetAcctService extends AbstractEntityService<AssetAcct>
        implements IAssetAcctService {

    public AssetAcctService() {
        super();
    }

    public AssetAcctService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<AssetAcct> getEntityClass() {
        return AssetAcct.class;
    }

    public AssetAcct findByAccount_schema(Asset asset, AccSchema accSchema) {
        return (AssetAcct) this.em
                .createNamedQuery(AssetAcct.NQ_FIND_BY_ACCOUNT_SCHEMA)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pAsset", asset)
                .setParameter("pAccSchema", accSchema).getSingleResult();
    }

    public AssetAcct findByAccount_schema(Long assetId, Long accSchemaId) {
        return (AssetAcct) this.em
                .createNamedQuery(AssetAcct.NQ_FIND_BY_ACCOUNT_SCHEMA_PRIMITIVE)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pAssetId", assetId)
                .setParameter("pAccSchemaId", accSchemaId).getSingleResult();
    }

    public List<AssetAcct> findByAsset(Asset asset) {
        return this.findByAssetId(asset.getId());
    }

    public List<AssetAcct> findByAssetId(Long assetId) {
        return (List<AssetAcct>) this.em
                .createQuery(
                        "select e from AssetAcct e where e.clientId = :pClientId and e.asset.id = :pAssetId",
                        AssetAcct.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pAssetId", assetId).getResultList();
    }

    public List<AssetAcct> findByAccSchema(AccSchema accSchema) {
        return this.findByAccSchemaId(accSchema.getId());
    }

    public List<AssetAcct> findByAccSchemaId(Long accSchemaId) {
        return (List<AssetAcct>) this.em
                .createQuery(
                        "select e from AssetAcct e where e.clientId = :pClientId and e.accSchema.id = :pAccSchemaId",
                        AssetAcct.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pAccSchemaId", accSchemaId).getResultList();
    }

    public List<AssetAcct> findByDeprecAccount(Account deprecAccount) {
        return this.findByDeprecAccountId(deprecAccount.getId());
    }

    public List<AssetAcct> findByDeprecAccountId(Long deprecAccountId) {
        return (List<AssetAcct>) this.em
                .createQuery(
                        "select e from AssetAcct e where e.clientId = :pClientId and e.deprecAccount.id = :pDeprecAccountId",
                        AssetAcct.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pDeprecAccountId", deprecAccountId)
                .getResultList();
    }

    public List<AssetAcct> findByAcmlDeprecAccount(Account acmlDeprecAccount) {
        return this.findByAcmlDeprecAccountId(acmlDeprecAccount.getId());
    }

    public List<AssetAcct> findByAcmlDeprecAccountId(Long acmlDeprecAccountId) {
        return (List<AssetAcct>) this.em
                .createQuery(
                        "select e from AssetAcct e where e.clientId = :pClientId and e.acmlDeprecAccount.id = :pAcmlDeprecAccountId",
                        AssetAcct.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pAcmlDeprecAccountId", acmlDeprecAccountId)
                .getResultList();
    }

}
