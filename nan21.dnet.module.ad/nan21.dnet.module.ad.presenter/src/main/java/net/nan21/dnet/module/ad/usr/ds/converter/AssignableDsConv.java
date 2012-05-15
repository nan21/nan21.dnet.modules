/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
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

    @Override
    protected void modelToEntityReferences(AssignableDs ds, Assignable e,
            boolean isInsert) throws Exception {

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
                x = ((IAssignableTypeService) findEntityService(AssignableType.class))
                        .findByName(ds.getType());
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

}
