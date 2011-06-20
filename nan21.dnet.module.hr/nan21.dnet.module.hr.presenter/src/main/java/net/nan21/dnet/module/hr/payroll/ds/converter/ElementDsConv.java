/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.payroll.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.hr.payroll.domain.entity.ElementType;
import net.nan21.dnet.module.hr.payroll.domain.service.IElementTypeService;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.hr.payroll.ds.model.ElementDs;
import net.nan21.dnet.module.hr.payroll.domain.entity.Element;

public class ElementDsConv extends AbstractDsConverter<ElementDs, Element>
        implements IDsConverter<ElementDs, Element> {

    protected void modelToEntityAttributes(ElementDs ds, Element e)
            throws Exception {
        e.setName(ds.getName());
        e.setCode(ds.getCode());
        e.setActive(ds.getActive());
        e.setNotes(ds.getNotes());
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
        e.setDataType(ds.getDataType());
    }

    protected void modelToEntityReferences(ElementDs ds, Element e)
            throws Exception {

        if (ds.getTypeId() != null) {
            if (e.getType() == null
                    || !e.getType().getId().equals(ds.getTypeId())) {
                e.setType((ElementType) this.em.getReference(ElementType.class,
                        ds.getTypeId()));
            }
        } else {
            this.lookup_type_ElementType(ds, e);
        }
    }

    protected void lookup_type_ElementType(ElementDs ds, Element e)
            throws Exception {
        ElementType x = null;
        try {
            x = ((IElementTypeService) getService(IElementTypeService.class))
                    .findByName(ds.getClientId(), ds.getType());
        } catch (javax.persistence.NoResultException exception) {

        }
        e.setType(x);
    }

    @Override
    public void entityToModel(Element e, ElementDs ds) throws Exception {
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
        ds.setDataType(e.getDataType());
        ds.setTypeId(((e.getType() != null)) ? e.getType().getId() : null);
        ds.setType(((e.getType() != null)) ? e.getType().getName() : null);
    }

}
