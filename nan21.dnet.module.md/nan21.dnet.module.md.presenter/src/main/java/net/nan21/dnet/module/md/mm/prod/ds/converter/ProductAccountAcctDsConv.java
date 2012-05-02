/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.mm.prod.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.bd.acc.business.service.IAccSchemaService;
import net.nan21.dnet.module.bd.acc.business.service.IAccountService;
import net.nan21.dnet.module.bd.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.bd.acc.domain.entity.Account;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAccount;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.md.mm.prod.ds.model.ProductAccountAcctDs;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAccountAcct;

public class ProductAccountAcctDsConv extends
        AbstractDsConverter<ProductAccountAcctDs, ProductAccountAcct> implements
        IDsConverter<ProductAccountAcctDs, ProductAccountAcct> {

    @Override
    protected void modelToEntityReferences(ProductAccountAcctDs ds,
            ProductAccountAcct e, boolean isInsert) throws Exception {

        if (ds.getProdAccountId() != null) {
            if (e.getProdAccount() == null
                    || !e.getProdAccount().getId()
                            .equals(ds.getProdAccountId())) {
                e.setProdAccount((ProductAccount) this.em.find(
                        ProductAccount.class, ds.getProdAccountId()));
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

        if (ds.getExpenseAccountId() != null) {
            if (e.getExpenseAccount() == null
                    || !e.getExpenseAccount().getId()
                            .equals(ds.getExpenseAccountId())) {
                e.setExpenseAccount((Account) this.em.find(Account.class,
                        ds.getExpenseAccountId()));
            }
        } else {
            this.lookup_expenseAccount_Account(ds, e);
        }

        if (ds.getRevenueAccountId() != null) {
            if (e.getRevenueAccount() == null
                    || !e.getRevenueAccount().getId()
                            .equals(ds.getRevenueAccountId())) {
                e.setRevenueAccount((Account) this.em.find(Account.class,
                        ds.getRevenueAccountId()));
            }
        } else {
            this.lookup_revenueAccount_Account(ds, e);
        }

    }

    protected void lookup_accSchema_AccSchema(ProductAccountAcctDs ds,
            ProductAccountAcct e) throws Exception {
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

    protected void lookup_expenseAccount_Account(ProductAccountAcctDs ds,
            ProductAccountAcct e) throws Exception {
        if (ds.getExpenseAccount() != null
                && !ds.getExpenseAccount().equals("")) {
            Account x = null;
            try {
                x = ((IAccountService) findEntityService(Account.class))
                        .findByCode(ds.getExpenseAccount());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Account` reference:  `expenseAccount` = "
                                + ds.getExpenseAccount() + "  ");
            }
            e.setExpenseAccount(x);

        } else {
            e.setExpenseAccount(null);
        }
    }

    protected void lookup_revenueAccount_Account(ProductAccountAcctDs ds,
            ProductAccountAcct e) throws Exception {
        if (ds.getRevenueAccount() != null
                && !ds.getRevenueAccount().equals("")) {
            Account x = null;
            try {
                x = ((IAccountService) findEntityService(Account.class))
                        .findByCode(ds.getRevenueAccount());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Account` reference:  `revenueAccount` = "
                                + ds.getRevenueAccount() + "  ");
            }
            e.setRevenueAccount(x);

        } else {
            e.setRevenueAccount(null);
        }
    }

}
