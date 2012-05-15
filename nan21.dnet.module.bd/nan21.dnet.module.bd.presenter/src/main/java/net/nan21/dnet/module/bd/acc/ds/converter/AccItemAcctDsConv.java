/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.acc.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.bd.acc.business.service.IAccItemService;
import net.nan21.dnet.module.bd.acc.business.service.IAccSchemaService;
import net.nan21.dnet.module.bd.acc.business.service.IAccountService;
import net.nan21.dnet.module.bd.acc.domain.entity.AccItem;
import net.nan21.dnet.module.bd.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.bd.acc.domain.entity.Account;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.bd.acc.ds.model.AccItemAcctDs;
import net.nan21.dnet.module.bd.acc.domain.entity.AccItemAcct;

public class AccItemAcctDsConv extends
        AbstractDsConverter<AccItemAcctDs, AccItemAcct> implements
        IDsConverter<AccItemAcctDs, AccItemAcct> {

    @Override
    protected void modelToEntityReferences(AccItemAcctDs ds, AccItemAcct e,
            boolean isInsert) throws Exception {

        if (ds.getAccItemId() != null) {
            if (e.getAccItem() == null
                    || !e.getAccItem().getId().equals(ds.getAccItemId())) {
                e.setAccItem((AccItem) this.em.find(AccItem.class,
                        ds.getAccItemId()));
            }
        } else {
            this.lookup_accItem_AccItem(ds, e);
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

        if (ds.getCrAccountId() != null) {
            if (e.getCrAccount() == null
                    || !e.getCrAccount().getId().equals(ds.getCrAccountId())) {
                e.setCrAccount((Account) this.em.find(Account.class,
                        ds.getCrAccountId()));
            }
        } else {
            this.lookup_crAccount_Account(ds, e);
        }

        if (ds.getDbAccountId() != null) {
            if (e.getDbAccount() == null
                    || !e.getDbAccount().getId().equals(ds.getDbAccountId())) {
                e.setDbAccount((Account) this.em.find(Account.class,
                        ds.getDbAccountId()));
            }
        } else {
            this.lookup_dbAccount_Account(ds, e);
        }

    }

    protected void lookup_accItem_AccItem(AccItemAcctDs ds, AccItemAcct e)
            throws Exception {
        if (ds.getAccItem() != null && !ds.getAccItem().equals("")) {
            AccItem x = null;
            try {
                x = ((IAccItemService) findEntityService(AccItem.class))
                        .findByName(ds.getAccItem());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `AccItem` reference:  `accItem` = "
                                + ds.getAccItem() + "  ");
            }
            e.setAccItem(x);

        } else {
            e.setAccItem(null);
        }
    }

    protected void lookup_accSchema_AccSchema(AccItemAcctDs ds, AccItemAcct e)
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

    protected void lookup_crAccount_Account(AccItemAcctDs ds, AccItemAcct e)
            throws Exception {
        if (ds.getCrAccount() != null && !ds.getCrAccount().equals("")) {
            Account x = null;
            try {
                x = ((IAccountService) findEntityService(Account.class))
                        .findByCode(ds.getCrAccount());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Account` reference:  `crAccount` = "
                                + ds.getCrAccount() + "  ");
            }
            e.setCrAccount(x);

        } else {
            e.setCrAccount(null);
        }
    }

    protected void lookup_dbAccount_Account(AccItemAcctDs ds, AccItemAcct e)
            throws Exception {
        if (ds.getDbAccount() != null && !ds.getDbAccount().equals("")) {
            Account x = null;
            try {
                x = ((IAccountService) findEntityService(Account.class))
                        .findByCode(ds.getDbAccount());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Account` reference:  `dbAccount` = "
                                + ds.getDbAccount() + "  ");
            }
            e.setDbAccount(x);

        } else {
            e.setDbAccount(null);
        }
    }

}
