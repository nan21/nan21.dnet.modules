/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bp.md.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.bd.geo.domain.entity.Country;
import net.nan21.dnet.module.bd.geo.domain.service.ICountryService;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.bp.md.ds.model.BusinessPartnerDs;
import net.nan21.dnet.module.bp.md.domain.entity.BusinessPartner;

public class BusinessPartnerDsConv extends
        AbstractDsConverter<BusinessPartnerDs, BusinessPartner> implements
        IDsConverter<BusinessPartnerDs, BusinessPartner> {

    protected void modelToEntityAttributes(BusinessPartnerDs ds,
            BusinessPartner e) throws Exception {
        e.setName(ds.getName());
        e.setCode(ds.getCode());
        e.setActive(ds.getActive());
        e.setNotes(ds.getNotes());
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
        e.setType(ds.getType());
        e.setFirstName(ds.getFirstName());
        e.setLastName(ds.getLastName());
        e.setGender(ds.getGender());
        e.setLegalForm(ds.getLegalForm());
        e.setRegistrationNo(ds.getRegistrationNo());
        e.setRegistrationDate(ds.getRegistrationDate());
        e.setTaxNo(ds.getTaxNo());
        e.setName1(ds.getName1());
        e.setName2(ds.getName2());
        e.setClassName(ds.getClassName());
    }

    protected void modelToEntityReferences(BusinessPartnerDs ds,
            BusinessPartner e) throws Exception {

        if (ds.getCountryId() != null) {
            if (e.getCountry() == null
                    || !e.getCountry().getId().equals(ds.getCountryId())) {
                e.setCountry((Country) this.em.getReference(Country.class,
                        ds.getCountryId()));
            }
        } else {
            this.lookup_country_Country(ds, e);
        }
    }

    protected void lookup_country_Country(BusinessPartnerDs ds,
            BusinessPartner e) throws Exception {
        Country x = null;
        try {
            x = ((ICountryService) getService(ICountryService.class))
                    .findByCode(ds.getClientId(), ds.getCountryCode());
        } catch (javax.persistence.NoResultException exception) {

        }
        e.setCountry(x);
    }

    @Override
    public void entityToModel(BusinessPartner e, BusinessPartnerDs ds)
            throws Exception {
        ds.setName(e.getName());
        ds.setCode(e.getCode());
        ds.setActive(e.getActive());
        ds.setNotes(e.getNotes());
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
        ds.setType(e.getType());
        ds.setFirstName(e.getFirstName());
        ds.setLastName(e.getLastName());
        ds.setGender(e.getGender());
        ds.setLegalForm(e.getLegalForm());
        ds.setRegistrationNo(e.getRegistrationNo());
        ds.setRegistrationDate(e.getRegistrationDate());
        ds.setTaxNo(e.getTaxNo());
        ds.setName1(e.getName1());
        ds.setName2(e.getName2());
        ds.setClassName(e.getClassName());
        ds.setCountryId(((e.getCountry() != null)) ? e.getCountry().getId()
                : null);
        ds.setCountryCode(((e.getCountry() != null)) ? e.getCountry().getCode()
                : null);
    }

}
