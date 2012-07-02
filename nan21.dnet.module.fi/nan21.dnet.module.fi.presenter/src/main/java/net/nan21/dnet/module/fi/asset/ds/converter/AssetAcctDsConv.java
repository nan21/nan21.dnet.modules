/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.fi.asset.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.fi.asset.business.service.IAssetService;
import net.nan21.dnet.module.fi.asset.domain.entity.Asset;
import net.nan21.dnet.module.md.acc.business.service.IAccSchemaService;
import net.nan21.dnet.module.md.acc.business.service.IAccountService;
import net.nan21.dnet.module.md.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.md.acc.domain.entity.Account;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.fi.asset.ds.model.AssetAcctDs;
import net.nan21.dnet.module.fi.asset.domain.entity.AssetAcct;

public class AssetAcctDsConv extends
        AbstractDsConverter<AssetAcctDs, AssetAcct> implements
        IDsConverter<AssetAcctDs, AssetAcct> {

    @Override
    protected void modelToEntityReferences(AssetAcctDs ds, AssetAcct e,
            boolean isInsert) throws Exception {

        if (ds.getAssetId() != null) {
            if (e.getAsset() == null
                    || !e.getAsset().getId().equals(ds.getAssetId())) {
                e.setAsset((Asset) this.em.find(Asset.class, ds.getAssetId()));
            }
        } else {
            this.lookup_asset_Asset(ds, e);
        }

        if (ds.getDeprecAccountId() != null) {
            if (e.getDeprecAccount() == null
                    || !e.getDeprecAccount().getId()
                            .equals(ds.getDeprecAccountId())) {
                e.setDeprecAccount((Account) this.em.find(Account.class,
                        ds.getDeprecAccountId()));
            }
        } else {
            this.lookup_deprecAccount_Account(ds, e);
        }

        if (ds.getAcmlDeprecAccountId() != null) {
            if (e.getAcmlDeprecAccount() == null
                    || !e.getAcmlDeprecAccount().getId()
                            .equals(ds.getAcmlDeprecAccountId())) {
                e.setAcmlDeprecAccount((Account) this.em.find(Account.class,
                        ds.getAcmlDeprecAccountId()));
            }
        } else {
            this.lookup_acmlDeprecAccount_Account(ds, e);
        }

        if (ds.getAccSchemaId() != null) {
            if (e.getAccSchema() == null
                    || !e.getAccSchema().getId().equals(ds.getAccSchemaId())) {
                e.setAccSchema((AccSchema) this.em.find(AccSchema.class,
                        ds.getAccSchemaId()));
            }
        } else {
            this.lookup_accSchema_AccSchema(ds, e);
        }

    }

    protected void lookup_asset_Asset(AssetAcctDs ds, AssetAcct e)
            throws Exception {
        if (ds.getAsset() != null && !ds.getAsset().equals("")) {
            Asset x = null;
            try {
                x = ((IAssetService) findEntityService(Asset.class))
                        .findByCode(ds.getAsset());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Asset` reference:  `asset` = "
                                + ds.getAsset() + "  ");
            }
            e.setAsset(x);

        } else {
            e.setAsset(null);
        }
    }

    protected void lookup_deprecAccount_Account(AssetAcctDs ds, AssetAcct e)
            throws Exception {
        if (ds.getDeprecAccount() != null && !ds.getDeprecAccount().equals("")) {
            Account x = null;
            try {
                x = ((IAccountService) findEntityService(Account.class))
                        .findByCode(ds.getDeprecAccount());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Account` reference:  `deprecAccount` = "
                                + ds.getDeprecAccount() + "  ");
            }
            e.setDeprecAccount(x);

        } else {
            e.setDeprecAccount(null);
        }
    }

    protected void lookup_acmlDeprecAccount_Account(AssetAcctDs ds, AssetAcct e)
            throws Exception {
        if (ds.getAcmlDeprecAccount() != null
                && !ds.getAcmlDeprecAccount().equals("")) {
            Account x = null;
            try {
                x = ((IAccountService) findEntityService(Account.class))
                        .findByCode(ds.getAcmlDeprecAccount());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Account` reference:  `acmlDeprecAccount` = "
                                + ds.getAcmlDeprecAccount() + "  ");
            }
            e.setAcmlDeprecAccount(x);

        } else {
            e.setAcmlDeprecAccount(null);
        }
    }

    protected void lookup_accSchema_AccSchema(AssetAcctDs ds, AssetAcct e)
            throws Exception {
        if (ds.getAccSchema() != null && !ds.getAccSchema().equals("")) {
            AccSchema x = null;
            try {
                x = ((IAccSchemaService) findEntityService(AccSchema.class))
                        .findByCode(ds.getAccSchema());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `AccSchema` reference:  `accSchema` = "
                                + ds.getAccSchema() + "  ");
            }
            e.setAccSchema(x);

        } else {
            e.setAccSchema(null);
        }
    }

}
