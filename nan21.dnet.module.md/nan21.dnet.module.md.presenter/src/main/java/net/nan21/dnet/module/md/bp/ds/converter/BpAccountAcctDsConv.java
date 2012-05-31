/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.bp.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.md.acc.business.service.IAccSchemaService;
import net.nan21.dnet.module.md.acc.business.service.IAccountService;
import net.nan21.dnet.module.md.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.md.acc.domain.entity.Account;
import net.nan21.dnet.module.md.bp.domain.entity.BpAccount;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.md.bp.ds.model.BpAccountAcctDs;
import net.nan21.dnet.module.md.bp.domain.entity.BpAccountAcct;

public class BpAccountAcctDsConv extends
        AbstractDsConverter<BpAccountAcctDs, BpAccountAcct> implements
        IDsConverter<BpAccountAcctDs, BpAccountAcct> {

    @Override
    protected void modelToEntityReferences(BpAccountAcctDs ds, BpAccountAcct e,
            boolean isInsert) throws Exception {

        if (ds.getBpAccountId() != null) {
            if (e.getBpAccount() == null
                    || !e.getBpAccount().getId().equals(ds.getBpAccountId())) {
                e.setBpAccount((BpAccount) this.em.find(BpAccount.class,
                        ds.getBpAccountId()));
            }
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

        if (ds.getCustSalesAccountId() != null) {
            if (e.getCustSalesAccount() == null
                    || !e.getCustSalesAccount().getId()
                            .equals(ds.getCustSalesAccountId())) {
                e.setCustSalesAccount((Account) this.em.find(Account.class,
                        ds.getCustSalesAccountId()));
            }
        } else {
            this.lookup_custSalesAccount_Account(ds, e);
        }

        if (ds.getCustPrepayAccountId() != null) {
            if (e.getCustPrepayAccount() == null
                    || !e.getCustPrepayAccount().getId()
                            .equals(ds.getCustPrepayAccountId())) {
                e.setCustPrepayAccount((Account) this.em.find(Account.class,
                        ds.getCustPrepayAccountId()));
            }
        } else {
            this.lookup_custPrepayAccount_Account(ds, e);
        }

        if (ds.getVendorPurchaseAccountId() != null) {
            if (e.getVendorPurchaseAccount() == null
                    || !e.getVendorPurchaseAccount().getId()
                            .equals(ds.getVendorPurchaseAccountId())) {
                e.setVendorPurchaseAccount((Account) this.em.find(
                        Account.class, ds.getVendorPurchaseAccountId()));
            }
        } else {
            this.lookup_vendorPurchaseAccount_Account(ds, e);
        }

        if (ds.getVendorPrepayAccountId() != null) {
            if (e.getVendorPrepayAccount() == null
                    || !e.getVendorPrepayAccount().getId()
                            .equals(ds.getVendorPrepayAccountId())) {
                e.setVendorPrepayAccount((Account) this.em.find(Account.class,
                        ds.getVendorPrepayAccountId()));
            }
        } else {
            this.lookup_vendorPrepayAccount_Account(ds, e);
        }

    }

    protected void lookup_accSchema_AccSchema(BpAccountAcctDs ds,
            BpAccountAcct e) throws Exception {
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

    protected void lookup_custSalesAccount_Account(BpAccountAcctDs ds,
            BpAccountAcct e) throws Exception {
        if (ds.getCustSalesAccount() != null
                && !ds.getCustSalesAccount().equals("")) {
            Account x = null;
            try {
                x = ((IAccountService) findEntityService(Account.class))
                        .findByCode(ds.getCustSalesAccount());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Account` reference:  `custSalesAccount` = "
                                + ds.getCustSalesAccount() + "  ");
            }
            e.setCustSalesAccount(x);

        } else {
            e.setCustSalesAccount(null);
        }
    }

    protected void lookup_custPrepayAccount_Account(BpAccountAcctDs ds,
            BpAccountAcct e) throws Exception {
        if (ds.getCustPrepayAccount() != null
                && !ds.getCustPrepayAccount().equals("")) {
            Account x = null;
            try {
                x = ((IAccountService) findEntityService(Account.class))
                        .findByCode(ds.getCustPrepayAccount());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Account` reference:  `custPrepayAccount` = "
                                + ds.getCustPrepayAccount() + "  ");
            }
            e.setCustPrepayAccount(x);

        } else {
            e.setCustPrepayAccount(null);
        }
    }

    protected void lookup_vendorPurchaseAccount_Account(BpAccountAcctDs ds,
            BpAccountAcct e) throws Exception {
        if (ds.getVendorPurchaseAccount() != null
                && !ds.getVendorPurchaseAccount().equals("")) {
            Account x = null;
            try {
                x = ((IAccountService) findEntityService(Account.class))
                        .findByCode(ds.getVendorPurchaseAccount());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Account` reference:  `vendorPurchaseAccount` = "
                                + ds.getVendorPurchaseAccount() + "  ");
            }
            e.setVendorPurchaseAccount(x);

        } else {
            e.setVendorPurchaseAccount(null);
        }
    }

    protected void lookup_vendorPrepayAccount_Account(BpAccountAcctDs ds,
            BpAccountAcct e) throws Exception {
        if (ds.getVendorPrepayAccount() != null
                && !ds.getVendorPrepayAccount().equals("")) {
            Account x = null;
            try {
                x = ((IAccountService) findEntityService(Account.class))
                        .findByCode(ds.getVendorPrepayAccount());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Account` reference:  `vendorPrepayAccount` = "
                                + ds.getVendorPrepayAccount() + "  ");
            }
            e.setVendorPrepayAccount(x);

        } else {
            e.setVendorPrepayAccount(null);
        }
    }

}
