/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
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

    protected void modelToEntityAttributes(UomDs ds, Uom e) throws Exception {
        e.setName(ds.getName());
        e.setCode(ds.getCode());
        e.setActive(ds.getActive());
        e.setNotes(ds.getNotes());
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
    }

    protected void modelToEntityReferences(UomDs ds, Uom e) throws Exception {

        if (ds.getTypeId() != null) {
            if (e.getType() == null
                    || !e.getType().getId().equals(ds.getTypeId())) {
                e.setType((UomType) this.em.getReference(UomType.class,
                        ds.getTypeId()));
            }
        } else {
            this.lookup_type_UomType(ds, e);
        }
    }

    protected void lookup_type_UomType(UomDs ds, Uom e) throws Exception {
        if (ds.getType() != null && !ds.getType().equals("")) {
            UomType x = null;
            try {
                x = ((IUomTypeService) getService(IUomTypeService.class))
                        .findByName(ds.getClientId(), ds.getType());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `UomType` reference:  `type` = "
                                + ds.getType() + "  ");
            }
            e.setType(x);
        }
    }

    @Override
    public void entityToModel(Uom e, UomDs ds) throws Exception {
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
        ds.setTypeId(((e.getType() != null)) ? e.getType().getId() : null);
        ds.setType(((e.getType() != null)) ? e.getType().getName() : null);
    }

}
