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

    @Override
    protected void modelToEntityReferences(OrganizationDs ds, Organization e,
            boolean isInsert) throws Exception {

        if (ds.getTypeId() != null) {
            if (e.getType() == null
                    || !e.getType().getId().equals(ds.getTypeId())) {
                e.setType((OrganizationType) this.em.find(
                        OrganizationType.class, ds.getTypeId()));
            }
        } else {
            this.lookup_type_OrganizationType(ds, e);
        }

    }

    protected void lookup_type_OrganizationType(OrganizationDs ds,
            Organization e) throws Exception {
        if (ds.getType() != null && !ds.getType().equals("")) {
            OrganizationType x = null;
            try {
                x = ((IOrganizationTypeService) findEntityService(OrganizationType.class))
                        .findByName(ds.getType());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `OrganizationType` reference:  `type` = "
                                + ds.getType() + "  ");
            }
            e.setType(x);

        } else {
            e.setType(null);
        }
    }

}
