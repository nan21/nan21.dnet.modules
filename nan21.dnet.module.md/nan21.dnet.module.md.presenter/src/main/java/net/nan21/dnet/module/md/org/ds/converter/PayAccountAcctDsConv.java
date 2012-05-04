/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.org.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.bd.acc.business.service.IAccSchemaService;
import net.nan21.dnet.module.bd.acc.business.service.IAccountService;
import net.nan21.dnet.module.bd.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.bd.acc.domain.entity.Account;
import net.nan21.dnet.module.md.org.business.service.IPayAccountService;
import net.nan21.dnet.module.md.org.domain.entity.PayAccount;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.md.org.ds.model.PayAccountAcctDs;
import net.nan21.dnet.module.md.org.domain.entity.PayAccountAcct;

public class PayAccountAcctDsConv extends
        AbstractDsConverter<PayAccountAcctDs, PayAccountAcct> implements
        IDsConverter<PayAccountAcctDs, PayAccountAcct> {

    @Override
    protected void modelToEntityReferences(PayAccountAcctDs ds,
            PayAccountAcct e, boolean isInsert) throws Exception {

        if (ds.getPayAccountId() != null) {
            if (e.getPayAccount() == null
                    || !e.getPayAccount().getId().equals(ds.getPayAccountId())) {
                e.setPayAccount((PayAccount) this.em.find(PayAccount.class,
                        ds.getPayAccountId()));
            }
        } else {
            this.lookup_payAccount_PayAccount(ds, e);
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

    protected void lookup_payAccount_PayAccount(PayAccountAcctDs ds,
            PayAccountAcct e) throws Exception {
        if (ds.getPayAccount() != null && !ds.getPayAccount().equals("")) {
            PayAccount x = null;
            try {
                x = ((IPayAccountService) findEntityService(PayAccount.class))
                        .findByName(ds.getPayAccount());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `PayAccount` reference:  `payAccount` = "
                                + ds.getPayAccount() + "  ");
            }
            e.setPayAccount(x);

        } else {
            e.setPayAccount(null);
        }
    }

    protected void lookup_accSchema_AccSchema(PayAccountAcctDs ds,
            PayAccountAcct e) throws Exception {
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

    protected void lookup_depositAccount_Account(PayAccountAcctDs ds,
            PayAccountAcct e) throws Exception {
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

    protected void lookup_withdrawalAccount_Account(PayAccountAcctDs ds,
            PayAccountAcct e) throws Exception {
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
