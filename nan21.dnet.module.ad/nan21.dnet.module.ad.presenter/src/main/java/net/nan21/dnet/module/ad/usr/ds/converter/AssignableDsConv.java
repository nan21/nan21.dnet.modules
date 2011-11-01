/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.usr.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.ad.usr.business.service.IAssignableTypeService;
import net.nan21.dnet.module.ad.usr.domain.entity.AssignableType;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.ad.usr.ds.model.AssignableDs;
import net.nan21.dnet.module.ad.usr.domain.entity.Assignable;

public class AssignableDsConv extends
        AbstractDsConverter<AssignableDs, Assignable> implements
        IDsConverter<AssignableDs, Assignable> {

    protected void modelToEntityAttributes(AssignableDs ds, Assignable e)
            throws Exception {
        e.setName(ds.getName());
        e.setActive(ds.getActive());
        e.setDescription(ds.getDescription());
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
    }

    protected void modelToEntityReferences(AssignableDs ds, Assignable e)
            throws Exception {

        if (ds.getTypeId() != null) {
            if (e.getAssignableType() == null
                    || !e.getAssignableType().getId().equals(ds.getTypeId())) {
                e.setAssignableType((AssignableType) this.em.find(
                        AssignableType.class, ds.getTypeId()));
            }
        } else {
            this.lookup_assignableType_AssignableType(ds, e);
        }
    }

    protected void lookup_assignableType_AssignableType(AssignableDs ds,
            Assignable e) throws Exception {
        if (ds.getType() != null && !ds.getType().equals("")) {
            AssignableType x = null;
            try {
                x = ((IAssignableTypeService) getService(IAssignableTypeService.class))
                        .findByName(ds.getClientId(), ds.getType());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `AssignableType` reference:  `type` = "
                                + ds.getType() + "  ");
            }
            e.setAssignableType(x);
        } else {
            e.setAssignableType(null);
        }
    }

    @Override
    public void entityToModel(Assignable e, AssignableDs ds) throws Exception {
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
        ds.setTypeId(((e.getAssignableType() != null)) ? e.getAssignableType()
                .getId() : null);
        ds.setType(((e.getAssignableType() != null)) ? e.getAssignableType()
                .getName() : null);
    }

}