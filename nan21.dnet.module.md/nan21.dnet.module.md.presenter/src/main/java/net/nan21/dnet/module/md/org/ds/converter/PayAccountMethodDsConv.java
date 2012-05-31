/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.org.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.md.base.tx.business.service.IPaymentMethodService;
import net.nan21.dnet.module.md.base.tx.domain.entity.PaymentMethod;
import net.nan21.dnet.module.md.org.business.service.IPayAccountService;
import net.nan21.dnet.module.md.org.domain.entity.PayAccount;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.md.org.ds.model.PayAccountMethodDs;
import net.nan21.dnet.module.md.org.domain.entity.PayAccountMethod;

public class PayAccountMethodDsConv extends
        AbstractDsConverter<PayAccountMethodDs, PayAccountMethod> implements
        IDsConverter<PayAccountMethodDs, PayAccountMethod> {

    @Override
    protected void modelToEntityReferences(PayAccountMethodDs ds,
            PayAccountMethod e, boolean isInsert) throws Exception {

        if (ds.getPayAccountId() != null) {
            if (e.getPayAccount() == null
                    || !e.getPayAccount().getId().equals(ds.getPayAccountId())) {
                e.setPayAccount((PayAccount) this.em.find(PayAccount.class,
                        ds.getPayAccountId()));
            }
        } else {
            this.lookup_payAccount_PayAccount(ds, e);
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

    protected void lookup_payAccount_PayAccount(PayAccountMethodDs ds,
            PayAccountMethod e) throws Exception {
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

    protected void lookup_payMethod_PaymentMethod(PayAccountMethodDs ds,
            PayAccountMethod e) throws Exception {
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
