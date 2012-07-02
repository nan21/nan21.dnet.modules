/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.fi.asset.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.fi.asset.business.service.IAssetCategoryService;
import net.nan21.dnet.module.fi.asset.domain.entity.AssetCategory;
import net.nan21.dnet.module.md.acc.business.service.IAccSchemaService;
import net.nan21.dnet.module.md.acc.business.service.IAccountService;
import net.nan21.dnet.module.md.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.md.acc.domain.entity.Account;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.fi.asset.ds.model.AssetCategoryAcctDs;
import net.nan21.dnet.module.fi.asset.domain.entity.AssetCategoryAcct;

public class AssetCategoryAcctDsConv extends
        AbstractDsConverter<AssetCategoryAcctDs, AssetCategoryAcct> implements
        IDsConverter<AssetCategoryAcctDs, AssetCategoryAcct> {

    @Override
    protected void modelToEntityReferences(AssetCategoryAcctDs ds,
            AssetCategoryAcct e, boolean isInsert) throws Exception {

        if (ds.getAssetCategoryId() != null) {
            if (e.getAssetCategory() == null
                    || !e.getAssetCategory().getId()
                            .equals(ds.getAssetCategoryId())) {
                e.setAssetCategory((AssetCategory) this.em.find(
                        AssetCategory.class, ds.getAssetCategoryId()));
            }
        } else {
            this.lookup_assetCategory_AssetCategory(ds, e);
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

    protected void lookup_assetCategory_AssetCategory(AssetCategoryAcctDs ds,
            AssetCategoryAcct e) throws Exception {
        if (ds.getAssetCategory() != null && !ds.getAssetCategory().equals("")) {
            AssetCategory x = null;
            try {
                x = ((IAssetCategoryService) findEntityService(AssetCategory.class))
                        .findByCode(ds.getAssetCategory());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `AssetCategory` reference:  `assetCategory` = "
                                + ds.getAssetCategory() + "  ");
            }
            e.setAssetCategory(x);

        } else {
            e.setAssetCategory(null);
        }
    }

    protected void lookup_deprecAccount_Account(AssetCategoryAcctDs ds,
            AssetCategoryAcct e) throws Exception {
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

    protected void lookup_acmlDeprecAccount_Account(AssetCategoryAcctDs ds,
            AssetCategoryAcct e) throws Exception {
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

    protected void lookup_accSchema_AccSchema(AssetCategoryAcctDs ds,
            AssetCategoryAcct e) throws Exception {
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
