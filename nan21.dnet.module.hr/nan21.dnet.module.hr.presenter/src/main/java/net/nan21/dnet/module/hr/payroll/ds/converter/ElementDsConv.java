/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.payroll.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.hr.payroll.business.service.IElementTypeService;
import net.nan21.dnet.module.hr.payroll.domain.entity.ElementType;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.hr.payroll.ds.model.ElementDs;
import net.nan21.dnet.module.hr.payroll.domain.entity.Element;

public class ElementDsConv extends AbstractDsConverter<ElementDs, Element>
        implements IDsConverter<ElementDs, Element> {

    @Override
    protected void modelToEntityReferences(ElementDs ds, Element e,
            boolean isInsert) throws Exception {

        if (ds.getTypeId() != null) {
            if (e.getType() == null
                    || !e.getType().getId().equals(ds.getTypeId())) {
                e.setType((ElementType) this.em.find(ElementType.class,
                        ds.getTypeId()));
            }
        } else {
            this.lookup_type_ElementType(ds, e);
        }

    }

    protected void lookup_type_ElementType(ElementDs ds, Element e)
            throws Exception {
        if (ds.getType() != null && !ds.getType().equals("")) {
            ElementType x = null;
            try {
                x = ((IElementTypeService) findEntityService(ElementType.class))
                        .findByName(ds.getType());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `ElementType` reference:  `type` = "
                                + ds.getType() + "  ");
            }
            e.setType(x);

        } else {
            e.setType(null);
        }
    }

}
