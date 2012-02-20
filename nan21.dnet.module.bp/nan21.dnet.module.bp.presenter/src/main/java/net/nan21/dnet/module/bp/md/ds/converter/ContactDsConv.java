/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bp.md.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.bp.md.business.service.IBusinessPartnerService;
import net.nan21.dnet.module.bp.md.domain.entity.BusinessPartner;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.bp.md.ds.model.ContactDs;
import net.nan21.dnet.module.bp.md.domain.entity.Contact;

public class ContactDsConv extends AbstractDsConverter<ContactDs, Contact>
        implements IDsConverter<ContactDs, Contact> {

    @Override
    protected void modelToEntityReferences(ContactDs ds, Contact e,
            boolean isInsert) throws Exception {

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

    protected void lookup_bpartner_BusinessPartner(ContactDs ds, Contact e)
            throws Exception {
        if (ds.getBpartnerCode() != null && !ds.getBpartnerCode().equals("")) {
            BusinessPartner x = null;
            try {
                x = ((IBusinessPartnerService) findEntityService(BusinessPartner.class))
                        .findByCode(ds.getBpartnerCode());
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
