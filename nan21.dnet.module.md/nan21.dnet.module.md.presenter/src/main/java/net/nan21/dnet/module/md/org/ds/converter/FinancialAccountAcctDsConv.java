/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.org.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.md.acc.business.service.IAccSchemaService;
import net.nan21.dnet.module.md.acc.business.service.IAccountService;
import net.nan21.dnet.module.md.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.md.acc.domain.entity.Account;
import net.nan21.dnet.module.md.org.business.service.IFinancialAccountService;
import net.nan21.dnet.module.md.org.domain.entity.FinancialAccount;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.md.org.ds.model.FinancialAccountAcctDs;
import net.nan21.dnet.module.md.org.domain.entity.FinancialAccountAcct;

public class FinancialAccountAcctDsConv extends
        AbstractDsConverter<FinancialAccountAcctDs, FinancialAccountAcct>
        implements IDsConverter<FinancialAccountAcctDs, FinancialAccountAcct> {

    @Override
    protected void modelToEntityReferences(FinancialAccountAcctDs ds,
            FinancialAccountAcct e, boolean isInsert) throws Exception {

        if (ds.getFinancialAccountId() != null) {
            if (e.getFinancialAccount() == null
                    || !e.getFinancialAccount().getId()
                            .equals(ds.getFinancialAccountId())) {
                e.setFinancialAccount((FinancialAccount) this.em.find(
                        FinancialAccount.class, ds.getFinancialAccountId()));
            }
        } else {
            this.lookup_financialAccount_FinancialAccount(ds, e);
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

        if (ds.getDepositAccountId() != null) {
            if (e.getDepositAccount() == null
                    || !e.getDepositAccount().getId()
                            .equals(ds.getDepositAccountId())) {
                e.setDepositAccount((Account) this.em.find(Account.class,
                        ds.getDepositAccountId()));
            }
        } else {
            this.lookup_depositAccount_Account(ds, e);
        }

        if (ds.getWithdrawalAccountId() != null) {
            if (e.getWithdrawalAccount() == null
                    || !e.getWithdrawalAccount().getId()
                            .equals(ds.getWithdrawalAccountId())) {
                e.setWithdrawalAccount((Account) this.em.find(Account.class,
                        ds.getWithdrawalAccountId()));
            }
        } else {
            this.lookup_withdrawalAccount_Account(ds, e);
        }

    }

    protected void lookup_financialAccount_FinancialAccount(
            FinancialAccountAcctDs ds, FinancialAccountAcct e) throws Exception {
        if (ds.getFinancialAccount() != null
                && !ds.getFinancialAccount().equals("")) {
            FinancialAccount x = null;
            try {
                x = ((IFinancialAccountService) findEntityService(FinancialAccount.class))
                        .findByName(ds.getFinancialAccount());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `FinancialAccount` reference:  `financialAccount` = "
                                + ds.getFinancialAccount() + "  ");
            }
            e.setFinancialAccount(x);

        } else {
            e.setFinancialAccount(null);
        }
    }

    protected void lookup_accSchema_AccSchema(FinancialAccountAcctDs ds,
            FinancialAccountAcct e) throws Exception {
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

    protected void lookup_depositAccount_Account(FinancialAccountAcctDs ds,
            FinancialAccountAcct e) throws Exception {
        if (ds.getDepositAccount() != null
                && !ds.getDepositAccount().equals("")) {
            Account x = null;
            try {
                x = ((IAccountService) findEntityService(Account.class))
                        .findByCode(ds.getDepositAccount());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Account` reference:  `depositAccount` = "
                                + ds.getDepositAccount() + "  ");
            }
            e.setDepositAccount(x);

        } else {
            e.setDepositAccount(null);
        }
    }

    protected void lookup_withdrawalAccount_Account(FinancialAccountAcctDs ds,
            FinancialAccountAcct e) throws Exception {
        if (ds.getWithdrawalAccount() != null
                && !ds.getWithdrawalAccount().equals("")) {
            Account x = null;
            try {
                x = ((IAccountService) findEntityService(Account.class))
                        .findByCode(ds.getWithdrawalAccount());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Account` reference:  `withdrawalAccount` = "
                                + ds.getWithdrawalAccount() + "  ");
            }
            e.setWithdrawalAccount(x);

        } else {
            e.setWithdrawalAccount(null);
        }
    }

}
