/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bp.md.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.bp.md.domain.entity.BusinessPartner;
import net.nan21.dnet.module.bp.md.domain.service.IBusinessPartnerService;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.bp.md.ds.model.ContactDs;
import net.nan21.dnet.module.bp.md.domain.entity.Contact;

public class ContactDsConv extends AbstractDsConverter<ContactDs, Contact>
        implements IDsConverter<ContactDs, Contact> {

    protected void modelToEntityAttributes(ContactDs ds, Contact e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
        e.setFirstName(ds.getFirstName());
        e.setLastName(ds.getLastName());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
        e.setGender(ds.getGender());
        e.setBirthdate(ds.getBirthdate());
        e.setPosition(ds.getPosition());
        e.setClassName(ds.getClassName());
    }

    protected void modelToEntityReferences(ContactDs ds, Contact e)
            throws Exception {

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

    protected void lookup_bpartner_BusinessPartner(ContactDs ds, Contact e)
            throws Exception {
        BusinessPartner x = null;
        try {
            x = ((IBusinessPartnerService) getService(IBusinessPartnerService.class))
                    .findByCode(ds.getClientId(), ds.getBpartnerCode());
        } catch (javax.persistence.NoResultException exception) {

        }
        e.setBpartner(x);
    }

    @Override
    public void entityToModel(Contact e, ContactDs ds) throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
        ds.setFirstName(e.getFirstName());
        ds.setLastName(e.getLastName());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
        ds.setGender(e.getGender());
        ds.setBirthdate(e.getBirthdate());
        ds.setPosition(e.getPosition());
        ds.setClassName(e.getClassName());
        ds.setBpartnerId(((e.getBpartner() != null)) ? e.getBpartner().getId()
                : null);
        ds.setBpartnerCode(((e.getBpartner() != null)) ? e.getBpartner()
                .getCode() : null);
    }

}
