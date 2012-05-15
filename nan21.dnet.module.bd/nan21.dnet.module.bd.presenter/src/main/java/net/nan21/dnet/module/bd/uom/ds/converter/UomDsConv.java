/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.uom.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.bd.uom.business.service.IUomTypeService;
import net.nan21.dnet.module.bd.uom.domain.entity.UomType;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.bd.uom.ds.model.UomDs;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;

public class UomDsConv extends AbstractDsConverter<UomDs, Uom> implements
        IDsConverter<UomDs, Uom> {

    @Override
    protected void modelToEntityReferences(UomDs ds, Uom e, boolean isInsert)
            throws Exception {

        if (ds.getTypeId() != null) {
            if (e.getType() == null
                    || !e.getType().getId().equals(ds.getTypeId())) {
                e.setType((UomType) this.em.find(UomType.class, ds.getTypeId()));
            }
        } else {
            this.lookup_type_UomType(ds, e);
        }

    }

    protected void lookup_type_UomType(UomDs ds, Uom e) throws Exception {
        if (ds.getType() != null && !ds.getType().equals("")) {
            UomType x = null;
            try {
                x = ((IUomTypeService) findEntityService(UomType.class))
                        .findByName(ds.getType());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `UomType` reference:  `type` = "
                                + ds.getType() + "  ");
            }
            e.setType(x);

        } else {
            e.setType(null);
        }
    }

}
