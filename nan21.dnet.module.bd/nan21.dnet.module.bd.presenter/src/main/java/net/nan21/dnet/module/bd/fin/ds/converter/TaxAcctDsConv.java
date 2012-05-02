/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.fin.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.bd.acc.business.service.IAccSchemaService;
import net.nan21.dnet.module.bd.acc.business.service.IAccountService;
import net.nan21.dnet.module.bd.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.bd.acc.domain.entity.Account;
import net.nan21.dnet.module.bd.fin.business.service.ITaxService;
import net.nan21.dnet.module.bd.fin.domain.entity.Tax;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.bd.fin.ds.model.TaxAcctDs;
import net.nan21.dnet.module.bd.fin.domain.entity.TaxAcct;

public class TaxAcctDsConv extends AbstractDsConverter<TaxAcctDs, TaxAcct>
        implements IDsConverter<TaxAcctDs, TaxAcct> {

    @Override
    protected void modelToEntityReferences(TaxAcctDs ds, TaxAcct e,
            boolean isInsert) throws Exception {

        if (ds.getTaxId() != null) {
            if (e.getTax() == null || !e.getTax().getId().equals(ds.getTaxId())) {
                e.setTax((Tax) this.em.find(Tax.class, ds.getTaxId()));
            }
        } else {
            this.lookup_tax_Tax(ds, e);
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

        if (ds.getSalesAccountId() != null) {
            if (e.getSalesAccount() == null
                    || !e.getSalesAccount().getId()
                            .equals(ds.getSalesAccountId())) {
                e.setSalesAccount((Account) this.em.find(Account.class,
                        ds.getSalesAccountId()));
            }
        } else {
            this.lookup_salesAccount_Account(ds, e);
        }

        if (ds.getPurchaseAccountId() != null) {
            if (e.getPurchaseAccount() == null
                    || !e.getPurchaseAccount().getId()
                            .equals(ds.getPurchaseAccountId())) {
                e.setPurchaseAccount((Account) this.em.find(Account.class,
                        ds.getPurchaseAccountId()));
            }
        } else {
            this.lookup_purchaseAccount_Account(ds, e);
        }

    }

    protected void lookup_tax_Tax(TaxAcctDs ds, TaxAcct e) throws Exception {
        if (ds.getTax() != null && !ds.getTax().equals("")) {
            Tax x = null;
            try {
                x = ((ITaxService) findEntityService(Tax.class)).findByName(ds
                        .getTax());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Tax` reference:  `tax` = "
                                + ds.getTax() + "  ");
            }
            e.setTax(x);

        } else {
            e.setTax(null);
        }
    }

    protected void lookup_accSchema_AccSchema(TaxAcctDs ds, TaxAcct e)
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

    protected void lookup_salesAccount_Account(TaxAcctDs ds, TaxAcct e)
            throws Exception {
        if (ds.getSalesAccount() != null && !ds.getSalesAccount().equals("")) {
            Account x = null;
            try {
                x = ((IAccountService) findEntityService(Account.class))
                        .findByCode(ds.getSalesAccount());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Account` reference:  `salesAccount` = "
                                + ds.getSalesAccount() + "  ");
            }
            e.setSalesAccount(x);

        } else {
            e.setSalesAccount(null);
        }
    }

    protected void lookup_purchaseAccount_Account(TaxAcctDs ds, TaxAcct e)
            throws Exception {
        if (ds.getPurchaseAccount() != null
                && !ds.getPurchaseAccount().equals("")) {
            Account x = null;
            try {
                x = ((IAccountService) findEntityService(Account.class))
                        .findByCode(ds.getPurchaseAccount());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Account` reference:  `purchaseAccount` = "
                                + ds.getPurchaseAccount() + "  ");
            }
            e.setPurchaseAccount(x);

        } else {
            e.setPurchaseAccount(null);
        }
    }

}
