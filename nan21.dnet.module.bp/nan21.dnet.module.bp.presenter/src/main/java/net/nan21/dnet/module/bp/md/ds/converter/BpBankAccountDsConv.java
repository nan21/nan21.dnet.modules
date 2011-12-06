/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bp.md.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.bd.currency.business.service.ICurrencyService;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.bp.base.business.service.IBankService;
import net.nan21.dnet.module.bp.base.domain.entity.Bank;
import net.nan21.dnet.module.bp.md.business.service.IBusinessPartnerService;
import net.nan21.dnet.module.bp.md.domain.entity.BusinessPartner;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.bp.md.ds.model.BpBankAccountDs;
import net.nan21.dnet.module.bp.md.domain.entity.BpBankAccount;

public class BpBankAccountDsConv extends
        AbstractDsConverter<BpBankAccountDs, BpBankAccount> implements
        IDsConverter<BpBankAccountDs, BpBankAccount> {

    protected void modelToEntityReferences(BpBankAccountDs ds, BpBankAccount e)
            throws Exception {
        if (ds.getCurrencyId() != null) {
            if (e.getCurrency() == null
                    || !e.getCurrency().getId().equals(ds.getCurrencyId())) {
                e.setCurrency((Currency) this.em.find(Currency.class,
                        ds.getCurrencyId()));
            }
        } else {
            this.lookup_currency_Currency(ds, e);
        }
        if (ds.getBankId() != null) {
            if (e.getBank() == null
                    || !e.getBank().getId().equals(ds.getBankId())) {
                e.setBank((Bank) this.em.find(Bank.class, ds.getBankId()));
            }
        } else {
            this.lookup_bank_Bank(ds, e);
        }
        if (ds.getBpartnerId() != null) {
            if (e.getBpartner() == null
                    || !e.getBpartner().getId().equals(ds.getBpartnerId())) {
                e.setBpartner((BusinessPartner) this.em.find(
                        BusinessPartner.class, ds.getBpartnerId()));
            }
        } else {
            this.lookup_bpartner_BusinessPartner(ds, e);
        }
    }

    protected void lookup_currency_Currency(BpBankAccountDs ds, BpBankAccount e)
            throws Exception {
        if (ds.getCurrencyCode() != null && !ds.getCurrencyCode().equals("")) {
            Currency x = null;
            try {
                x = ((ICurrencyService) getService(ICurrencyService.class))
                        .findByCode(ds.getClientId(), ds.getCurrencyCode());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Currency` reference:  `currencyCode` = "
                                + ds.getCurrencyCode() + "  ");
            }
            e.setCurrency(x);

        } else {
            e.setCurrency(null);
        }
    }

    protected void lookup_bank_Bank(BpBankAccountDs ds, BpBankAccount e)
            throws Exception {
        if (ds.getBankCode() != null && !ds.getBankCode().equals("")) {
            Bank x = null;
            try {
                x = ((IBankService) getService(IBankService.class)).findByCode(
                        ds.getClientId(), ds.getBankCode());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Bank` reference:  `bankCode` = "
                                + ds.getBankCode() + "  ");
            }
            e.setBank(x);

        } else {
            e.setBank(null);
        }
    }

    protected void lookup_bpartner_BusinessPartner(BpBankAccountDs ds,
            BpBankAccount e) throws Exception {
        if (ds.getBpartnerCode() != null && !ds.getBpartnerCode().equals("")) {
            BusinessPartner x = null;
            try {
                x = ((IBusinessPartnerService) getService(IBusinessPartnerService.class))
                        .findByCode(ds.getClientId(), ds.getBpartnerCode());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `BusinessPartner` reference:  `bpartnerCode` = "
                                + ds.getBpartnerCode() + "  ");
            }
            e.setBpartner(x);

        } else {
            e.setBpartner(null);
        }
    }

}
