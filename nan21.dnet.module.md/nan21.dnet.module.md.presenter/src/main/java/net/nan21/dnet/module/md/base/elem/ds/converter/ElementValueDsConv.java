/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.base.elem.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.md.base.elem.business.service.IElementService;
import net.nan21.dnet.module.md.base.elem.domain.entity.Element;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.md.base.elem.ds.model.ElementValueDs;
import net.nan21.dnet.module.md.base.elem.domain.entity.ElementValue;

public class ElementValueDsConv extends
        AbstractDsConverter<ElementValueDs, ElementValue> implements
        IDsConverter<ElementValueDs, ElementValue> {

    @Override
    protected void modelToEntityReferences(ElementValueDs ds, ElementValue e,
            boolean isInsert) throws Exception {

        if (ds.getElementId() != null) {
            if (e.getElement() == null
                    || !e.getElement().getId().equals(ds.getElementId())) {
                e.setElement((Element) this.em.find(Element.class,
                        ds.getElementId()));
            }
        } else {
            this.lookup_element_Element(ds, e);
        }

    }

    protected void lookup_element_Element(ElementValueDs ds, ElementValue e)
            throws Exception {
        if (ds.getElement() != null && !ds.getElement().equals("")) {
            Element x = null;
            try {
                x = ((IElementService) findEntityService(Element.class))
                        .findByCode(ds.getElement());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Element` reference:  `element` = "
                                + ds.getElement() + "  ");
            }
            e.setElement(x);

        } else {
            e.setElement(null);
        }
    }

}
