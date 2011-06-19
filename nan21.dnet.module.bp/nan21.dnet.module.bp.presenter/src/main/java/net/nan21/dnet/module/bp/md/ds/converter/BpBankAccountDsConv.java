/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bp.md.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.bd.currency.domain.service.ICurrencyService;
import net.nan21.dnet.module.bp.base.domain.entity.Bank;
import net.nan21.dnet.module.bp.base.domain.service.IBankService;
import net.nan21.dnet.module.bp.md.domain.entity.BusinessPartner;
import net.nan21.dnet.module.bp.md.domain.service.IBusinessPartnerService;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.bp.md.ds.model.BpBankAccountDs;
import net.nan21.dnet.module.bp.md.domain.entity.BpBankAccount;

public class BpBankAccountDsConv extends
        AbstractDsConverter<BpBankAccountDs, BpBankAccount> implements
        IDsConverter<BpBankAccountDs, BpBankAccount> {

    protected void modelToEntityAttributes(BpBankAccountDs ds, BpBankAccount e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
        e.setBankBranch(ds.getBankBranch());
        e.setAccountNo(ds.getAccountNo());
        e.setIbanAccount(ds.getIbanAccount());
        e.setActive(ds.getActive());
        e.setNotes(ds.getNotes());
    }

    protected void modelToEntityReferences(BpBankAccountDs ds, BpBankAccount e)
            throws Exception {

        if (ds.getCurrencyId() != null) {
            if (e.getCurrency() == null
                    || !e.getCurrency().getId().equals(ds.getCurrencyId())) {
                e.setCurrency((Currency) this.em.getReference(Currency.class,
                        ds.getCurrencyId()));
            }
        } else {
            this.lookup_currency_Currency(ds, e);
        }
        if (ds.getBankId() != null) {
            if (e.getBank() == null
                    || !e.getBank().getId().equals(ds.getBankId())) {
                e.setBank((Bank) this.em.getReference(Bank.class,
                        ds.getBankId()));
            }
        } else {
            this.lookup_bank_Bank(ds, e);
        }
        if (ds.getBpartnerId() != null) {
            if (e.getBpartner() == null
                    || !e.getBpartner().getId().equals(ds.getBpartnerId())) {
                e.setBpartner((BusinessPartner) this.em.getReference(
                        BusinessPartner.class, ds.getBpartnerId()));
            }
        } else {
            this.lookup_bpartner_BusinessPartner(ds, e);
        }
    }

    protected void lookup_currency_Currency(BpBankAccountDs ds, BpBankAccount e)
            throws Exception {
        Currency x = null;
        try {
            x = ((ICurrencyService) getService(ICurrencyService.class))
                    .findByCode(ds.getClientId(), ds.getCurrencyCode());
        } catch (javax.persistence.NoResultException exception) {

        }
        e.setCurrency(x);
    }

    protected void lookup_bank_Bank(BpBankAccountDs ds, BpBankAccount e)
            throws Exception {
        Bank x = null;
        try {
            x = ((IBankService) getService(IBankService.class)).findByCode(
                    ds.getClientId(), ds.getBankCode());
        } catch (javax.persistence.NoResultException exception) {

        }
        e.setBank(x);
    }

    protected void lookup_bpartner_BusinessPartner(BpBankAccountDs ds,
            BpBankAccount e) throws Exception {
        BusinessPartner x = null;
        try {
            x = ((IBusinessPartnerService) getService(IBusinessPartnerService.class))
                    .findByCode(ds.getClientId(), ds.getBpartnerCode());
        } catch (javax.persistence.NoResultException exception) {

        }
        e.setBpartner(x);
    }

    @Override
    public void entityToModel(BpBankAccount e, BpBankAccountDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
        ds.setBankBranch(e.getBankBranch());
        ds.setAccountNo(e.getAccountNo());
        ds.setIbanAccount(e.getIbanAccount());
        ds.setActive(e.getActive());
        ds.setNotes(e.getNotes());
        ds.setBpartnerId(((e.getBpartner() != null)) ? e.getBpartner().getId()
                : null);
        ds.setBpartnerCode(((e.getBpartner() != null)) ? e.getBpartner()
                .getCode() : null);
        ds.setBankId(((e.getBank() != null)) ? e.getBank().getId() : null);
        ds.setBankCode(((e.getBank() != null)) ? e.getBank().getCode() : null);
        ds.setCurrencyId(((e.getCurrency() != null)) ? e.getCurrency().getId()
                : null);
        ds.setCurrencyCode(((e.getCurrency() != null)) ? e.getCurrency()
                .getCode() : null);
    }

}
