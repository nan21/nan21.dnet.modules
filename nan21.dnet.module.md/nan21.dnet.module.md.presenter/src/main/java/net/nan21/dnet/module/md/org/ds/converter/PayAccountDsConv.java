/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.org.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.bd.currency.business.service.ICurrencyService;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.bd.org.business.service.IOrganizationService;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.md.org.ds.model.PayAccountDs;
import net.nan21.dnet.module.md.org.domain.entity.PayAccount;

public class PayAccountDsConv extends
        AbstractDsConverter<PayAccountDs, PayAccount> implements
        IDsConverter<PayAccountDs, PayAccount> {

    @Override
    protected void modelToEntityReferences(PayAccountDs ds, PayAccount e,
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

        if (ds.getOrgId() != null) {
            if (e.getOrg() == null || !e.getOrg().getId().equals(ds.getOrgId())) {
                e.setOrg((Organization) this.em.find(Organization.class,
                        ds.getOrgId()));
            }
        } else {
            this.lookup_org_Organization(ds, e);
        }

    }

    protected void lookup_currency_Currency(PayAccountDs ds, PayAccount e)
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

    protected void lookup_org_Organization(PayAccountDs ds, PayAccount e)
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

}
