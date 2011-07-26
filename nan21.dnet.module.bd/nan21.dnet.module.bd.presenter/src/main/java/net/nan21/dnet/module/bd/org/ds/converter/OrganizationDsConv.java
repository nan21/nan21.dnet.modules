/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.org.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.bd.org.business.service.IOrganizationTypeService;
import net.nan21.dnet.module.bd.org.domain.entity.OrganizationType;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.bd.org.ds.model.OrganizationDs;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;

public class OrganizationDsConv extends
        AbstractDsConverter<OrganizationDs, Organization> implements
        IDsConverter<OrganizationDs, Organization> {

    protected void modelToEntityAttributes(OrganizationDs ds, Organization e)
            throws Exception {
        e.setName(ds.getName());
        e.setCode(ds.getCode());
        e.setActive(ds.getActive());
        e.setNotes(ds.getNotes());
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
        e.setValid(ds.getValid());
    }

    protected void modelToEntityReferences(OrganizationDs ds, Organization e)
            throws Exception {

        if (ds.getTypeId() != null) {
            if (e.getType() == null
                    || !e.getType().getId().equals(ds.getTypeId())) {
                e.setType((OrganizationType) this.em.getReference(
                        OrganizationType.class, ds.getTypeId()));
            }
        } else {
            this.lookup_type_OrganizationType(ds, e);
        }
    }

    protected void lookup_type_OrganizationType(OrganizationDs ds,
            Organization e) throws Exception {
        OrganizationType x = null;
        try {
            x = ((IOrganizationTypeService) getService(IOrganizationTypeService.class))
                    .findByName(ds.getClientId(), ds.getType());
        } catch (javax.persistence.NoResultException exception) {

        }
        e.setType(x);
    }

    @Override
    public void entityToModel(Organization e, OrganizationDs ds)
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
        ds.setValid(e.getValid());
        ds.setTypeId(((e.getType() != null)) ? e.getType().getId() : null);
        ds.setType(((e.getType() != null)) ? e.getType().getName() : null);
    }

}