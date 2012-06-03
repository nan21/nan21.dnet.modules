/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.elem.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.bd.elem.business.service.IElementService;
import net.nan21.dnet.module.bd.elem.business.service.IElementSetService;
import net.nan21.dnet.module.bd.elem.business.service.IEngineService;
import net.nan21.dnet.module.bd.elem.domain.entity.Element;
import net.nan21.dnet.module.bd.elem.domain.entity.ElementSet;
import net.nan21.dnet.module.bd.elem.domain.entity.Engine;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.bd.elem.ds.model.ElementSetElementDs;
import net.nan21.dnet.module.bd.elem.domain.entity.ElementSetElement;

public class ElementSetElementDsConv extends
        AbstractDsConverter<ElementSetElementDs, ElementSetElement> implements
        IDsConverter<ElementSetElementDs, ElementSetElement> {

    @Override
    protected void modelToEntityReferences(ElementSetElementDs ds,
            ElementSetElement e, boolean isInsert) throws Exception {

        if (ds.getEngineId() == null) {
            Engine x = ((IEngineService) findEntityService(Engine.class))
                    .findByName(ds.getEngine());

            ds.setEngineId(x.getId());
        }

        if (ds.getElementSetId() != null) {
            if (e.getElementSet() == null
                    || !e.getElementSet().getId().equals(ds.getElementSetId())) {
                e.setElementSet((ElementSet) this.em.find(ElementSet.class,
                        ds.getElementSetId()));
            }
        } else {
            this.lookup_elementSet_ElementSet(ds, e);
        }

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

    protected void lookup_elementSet_ElementSet(ElementSetElementDs ds,
            ElementSetElement e) throws Exception {
        if (ds.getEngineId() != null && !ds.getEngineId().equals("")
                && ds.getElementSet() != null && !ds.getElementSet().equals("")) {
            ElementSet x = null;
            try {
                x = ((IElementSetService) findEntityService(ElementSet.class))
                        .findByEngine_name(ds.getEngineId(), ds.getElementSet());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `ElementSet` reference:  `engineId` = "
                                + ds.getEngineId() + " , `elementSet` = "
                                + ds.getElementSet() + "  ");
            }
            e.setElementSet(x);

        } else {
            e.setElementSet(null);
        }
    }

    protected void lookup_element_Element(ElementSetElementDs ds,
            ElementSetElement e) throws Exception {
        if (ds.getEngineId() != null && !ds.getEngineId().equals("")
                && ds.getElement() != null && !ds.getElement().equals("")) {
            Element x = null;
            try {
                x = ((IElementService) findEntityService(Element.class))
                        .findByEngine_code(ds.getEngineId(), ds.getElement());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Element` reference:  `engineId` = "
                                + ds.getEngineId() + " , `element` = "
                                + ds.getElement() + "  ");
            }
            e.setElement(x);

        } else {
            e.setElement(null);
        }
    }

}
