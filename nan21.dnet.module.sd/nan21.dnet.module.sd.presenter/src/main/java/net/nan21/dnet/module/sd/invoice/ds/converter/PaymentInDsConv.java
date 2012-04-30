/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sd.invoice.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.bd.currency.business.service.ICurrencyService;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.bd.org.business.service.IOrganizationService;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.bd.tx.business.service.IPaymentMethodService;
import net.nan21.dnet.module.bd.tx.domain.entity.PaymentMethod;
import net.nan21.dnet.module.md.bp.business.service.IBusinessPartnerService;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;

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

        if (ds.getOrgId() != null) {
            if (e.getOrg() == null || !e.getOrg().getId().equals(ds.getOrgId())) {
                e.setOrg((Organization) this.em.find(Organization.class,
                        ds.getOrgId()));
            }
        } else {
            this.lookup_org_Organization(ds, e);
        }

        if (ds.getPayToId() != null) {
            if (e.getBpartner() == null
                    || !e.getBpartner().getId().equals(ds.getPayToId())) {
                e.setBpartner((BusinessPartner) this.em.find(
                        BusinessPartner.class, ds.getPayToId()));
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

    protected void lookup_org_Organization(PaymentInDs ds, PaymentIn e)
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
            e.setOrg(x);

        } else {
            e.setOrg(null);
        }
    }

    protected void lookup_bpartner_BusinessPartner(PaymentInDs ds, PaymentIn e)
            throws Exception {
        if (ds.getPayTo() != null && !ds.getPayTo().equals("")) {
            BusinessPartner x = null;
            try {
                x = ((IBusinessPartnerService) findEntityService(BusinessPartner.class))
                        .findByCode(ds.getPayTo());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `BusinessPartner` reference:  `payTo` = "
                                + ds.getPayTo() + "  ");
            }
            e.setBpartner(x);

        } else {
            e.setBpartner(null);
        }
    }

}
