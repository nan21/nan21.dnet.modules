/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ux.example.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.bd.geo.domain.entity.Country;
import net.nan21.dnet.module.bd.geo.domain.service.ICountryService;
import net.nan21.dnet.module.ux.example.domain.entity.LandFormType;
import net.nan21.dnet.module.ux.example.domain.service.ILandFormTypeService;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.ux.example.ds.model.LandFormDs;
import net.nan21.dnet.module.ux.example.domain.entity.LandForm;

public class LandFormDsConv extends AbstractDsConverter<LandFormDs, LandForm>
        implements IDsConverter<LandFormDs, LandForm> {

    protected void modelToEntityAttributes(LandFormDs ds, LandForm e)
            throws Exception {
        e.setName(ds.getName());
        e.setActive(ds.getActive());
        e.setDescription(ds.getDescription());
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
    }

    protected void modelToEntityReferences(LandFormDs ds, LandForm e)
            throws Exception {

        if (ds.getTypeId() != null) {
            if (e.getType() == null
                    || !e.getType().getId().equals(ds.getTypeId())) {
                e.setType((LandFormType) this.em.getReference(
                        LandFormType.class, ds.getTypeId()));
            }
        } else {
            this.lookup_type_LandFormType(ds, e);
        }
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

    protected void lookup_type_LandFormType(LandFormDs ds, LandForm e)
            throws Exception {
        LandFormType x = null;
        try {
            x = ((ILandFormTypeService) getService(ILandFormTypeService.class))
                    .findByName(ds.getClientId(), ds.getType());
        } catch (javax.persistence.NoResultException exception) {

        }
        e.setType(x);
    }

    protected void lookup_country_Country(LandFormDs ds, LandForm e)
            throws Exception {
        Country x = null;
        try {
            x = ((ICountryService) getService(ICountryService.class))
                    .findByCode(ds.getClientId(), ds.getCountryCode());
        } catch (javax.persistence.NoResultException exception) {

        }
        e.setCountry(x);
    }

    @Override
    public void entityToModel(LandForm e, LandFormDs ds) throws Exception {
        ds.setName(e.getName());
        ds.setActive(e.getActive());
        ds.setDescription(e.getDescription());
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
        ds.setTypeId(((e.getType() != null)) ? e.getType().getId() : null);
        ds.setType(((e.getType() != null)) ? e.getType().getName() : null);
        ds.setCountryId(((e.getCountry() != null)) ? e.getCountry().getId()
                : null);
        ds.setCountryCode(((e.getCountry() != null)) ? e.getCountry().getCode()
                : null);
    }

}
