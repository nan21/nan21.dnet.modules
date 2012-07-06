/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.org.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.md.base.tx.business.service.IPaymentMethodService;
import net.nan21.dnet.module.md.base.tx.domain.entity.PaymentMethod;
import net.nan21.dnet.module.md.org.business.service.IFinancialAccountService;
import net.nan21.dnet.module.md.org.domain.entity.FinancialAccount;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.md.org.ds.model.FinancialAccountMethodDs;
import net.nan21.dnet.module.md.org.domain.entity.FinancialAccountMethod;

public class FinancialAccountMethodDsConv extends
        AbstractDsConverter<FinancialAccountMethodDs, FinancialAccountMethod>
        implements
        IDsConverter<FinancialAccountMethodDs, FinancialAccountMethod> {

    @Override
    protected void modelToEntityReferences(FinancialAccountMethodDs ds,
            FinancialAccountMethod e, boolean isInsert) throws Exception {

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

        if (ds.getPayMethodId() != null) {
            if (e.getPayMethod() == null
                    || !e.getPayMethod().getId().equals(ds.getPayMethodId())) {
                e.setPayMethod((PaymentMethod) this.em.find(
                        PaymentMethod.class, ds.getPayMethodId()));
            }
        } else {
            this.lookup_payMethod_PaymentMethod(ds, e);
        }

    }

    protected void lookup_financialAccount_FinancialAccount(
            FinancialAccountMethodDs ds, FinancialAccountMethod e)
            throws Exception {
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

    protected void lookup_payMethod_PaymentMethod(FinancialAccountMethodDs ds,
            FinancialAccountMethod e) throws Exception {
        if (ds.getPayMethod() != null && !ds.getPayMethod().equals("")) {
            PaymentMethod x = null;
            try {
                x = ((IPaymentMethodService) findEntityService(PaymentMethod.class))
                        .findByName(ds.getPayMethod());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `PaymentMethod` reference:  `payMethod` = "
                                + ds.getPayMethod() + "  ");
            }
            e.setPayMethod(x);

        } else {
            e.setPayMethod(null);
        }
    }

}
