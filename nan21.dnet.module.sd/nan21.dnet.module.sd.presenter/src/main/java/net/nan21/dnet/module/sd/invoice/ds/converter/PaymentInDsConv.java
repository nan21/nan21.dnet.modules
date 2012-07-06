/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sd.invoice.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.bd.currency.business.service.ICurrencyService;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.bd.org.business.service.IOrganizationService;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.md.base.tx.business.service.IPaymentMethodService;
import net.nan21.dnet.module.md.base.tx.domain.entity.PaymentMethod;
import net.nan21.dnet.module.md.bp.business.service.IBusinessPartnerService;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;
import net.nan21.dnet.module.md.org.business.service.IFinancialAccountService;
import net.nan21.dnet.module.md.org.domain.entity.FinancialAccount;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.sd.invoice.ds.model.PaymentInDs;
import net.nan21.dnet.module.sd.invoice.domain.entity.PaymentIn;

public class PaymentInDsConv extends
        AbstractDsConverter<PaymentInDs, PaymentIn> implements
        IDsConverter<PaymentInDs, PaymentIn> {

    @Override
    protected void modelToEntityReferences(PaymentInDs ds, PaymentIn e,
            boolean isInsert) throws Exception {

        if (ds.getCurrencyId() != null) {
            if (e.getCurrency() == null
                    || !e.getCurrency().getId().equals(ds.getCurrencyId())) {
                e.setCurrency((Currency) this.em.find(Currency.class,
                        ds.getCurrencyId()));
            }
        } else {
            this.lookup_currency_Currency(ds, e);
        }

        if (ds.getPaymentMethodId() != null) {
            if (e.getPaymentMethod() == null
                    || !e.getPaymentMethod().getId()
                            .equals(ds.getPaymentMethodId())) {
                e.setPaymentMethod((PaymentMethod) this.em.find(
                        PaymentMethod.class, ds.getPaymentMethodId()));
            }
        } else {
            this.lookup_paymentMethod_PaymentMethod(ds, e);
        }

        if (ds.getToAccountId() != null) {
            if (e.getToAccount() == null
                    || !e.getToAccount().getId().equals(ds.getToAccountId())) {
                e.setToAccount((FinancialAccount) this.em.find(
                        FinancialAccount.class, ds.getToAccountId()));
            }
        } else {
            this.lookup_toAccount_FinancialAccount(ds, e);
        }

        if (ds.getOrgId() != null) {
            if (e.getToOrg() == null
                    || !e.getToOrg().getId().equals(ds.getOrgId())) {
                e.setToOrg((Organization) this.em.find(Organization.class,
                        ds.getOrgId()));
            }
        } else {
            this.lookup_toOrg_Organization(ds, e);
        }

        if (ds.getPayFromId() != null) {
            if (e.getBpartner() == null
                    || !e.getBpartner().getId().equals(ds.getPayFromId())) {
                e.setBpartner((BusinessPartner) this.em.find(
                        BusinessPartner.class, ds.getPayFromId()));
            }
        } else {
            this.lookup_bpartner_BusinessPartner(ds, e);
        }

    }

    protected void lookup_currency_Currency(PaymentInDs ds, PaymentIn e)
            throws Exception {
        if (ds.getCurrency() != null && !ds.getCurrency().equals("")) {
            Currency x = null;
            try {
                x = ((ICurrencyService) findEntityService(Currency.class))
                        .findByCode(ds.getCurrency());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Currency` reference:  `currency` = "
                                + ds.getCurrency() + "  ");
            }
            e.setCurrency(x);

        } else {
            e.setCurrency(null);
        }
    }

    protected void lookup_paymentMethod_PaymentMethod(PaymentInDs ds,
            PaymentIn e) throws Exception {
        if (ds.getPaymentMethod() != null && !ds.getPaymentMethod().equals("")) {
            PaymentMethod x = null;
            try {
                x = ((IPaymentMethodService) findEntityService(PaymentMethod.class))
                        .findByName(ds.getPaymentMethod());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `PaymentMethod` reference:  `paymentMethod` = "
                                + ds.getPaymentMethod() + "  ");
            }
            e.setPaymentMethod(x);

        } else {
            e.setPaymentMethod(null);
        }
    }

    protected void lookup_toAccount_FinancialAccount(PaymentInDs ds, PaymentIn e)
            throws Exception {
        if (ds.getToAccount() != null && !ds.getToAccount().equals("")) {
            FinancialAccount x = null;
            try {
                x = ((IFinancialAccountService) findEntityService(FinancialAccount.class))
                        .findByName(ds.getToAccount());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `FinancialAccount` reference:  `toAccount` = "
                                + ds.getToAccount() + "  ");
            }
            e.setToAccount(x);

        } else {
            e.setToAccount(null);
        }
    }

    protected void lookup_toOrg_Organization(PaymentInDs ds, PaymentIn e)
            throws Exception {
        if (ds.getOrg() != null && !ds.getOrg().equals("")) {
            Organization x = null;
            try {
                x = ((IOrganizationService) findEntityService(Organization.class))
                        .findByCode(ds.getOrg());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Organization` reference:  `org` = "
                                + ds.getOrg() + "  ");
            }
            e.setToOrg(x);

        } else {
            e.setToOrg(null);
        }
    }

    protected void lookup_bpartner_BusinessPartner(PaymentInDs ds, PaymentIn e)
            throws Exception {
        if (ds.getPayFrom() != null && !ds.getPayFrom().equals("")) {
            BusinessPartner x = null;
            try {
                x = ((IBusinessPartnerService) findEntityService(BusinessPartner.class))
                        .findByCode(ds.getPayFrom());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `BusinessPartner` reference:  `payFrom` = "
                                + ds.getPayFrom() + "  ");
            }
            e.setBpartner(x);

        } else {
            e.setBpartner(null);
        }
    }

}
