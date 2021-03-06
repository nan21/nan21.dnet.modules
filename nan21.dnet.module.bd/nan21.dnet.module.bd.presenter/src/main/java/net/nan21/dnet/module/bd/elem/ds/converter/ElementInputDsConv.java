/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.elem.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.bd.elem.business.service.IElementService;
import net.nan21.dnet.module.bd.elem.business.service.IEngineService;
import net.nan21.dnet.module.bd.elem.domain.entity.Element;
import net.nan21.dnet.module.bd.elem.domain.entity.Engine;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.bd.elem.ds.model.ElementInputDs;
import net.nan21.dnet.module.bd.elem.domain.entity.ElementInput;

public class ElementInputDsConv extends
        AbstractDsConverter<ElementInputDs, ElementInput> implements
        IDsConverter<ElementInputDs, ElementInput> {

    @Override
    protected void modelToEntityReferences(ElementInputDs ds, ElementInput e,
            boolean isInsert) throws Exception {

        if (ds.getEngineId() == null) {
            Engine x = ((IEngineService) findEntityService(Engine.class))
                    .findByName(ds.getEngine());

            ds.setEngineId(x.getId());
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

        if (ds.getReferenceId() != null) {
            if (e.getCrossReference() == null
                    || !e.getCrossReference().getId()
                            .equals(ds.getReferenceId())) {
                e.setCrossReference((Element) this.em.find(Element.class,
                        ds.getReferenceId()));
            }
        } else {
            this.lookup_crossReference_Element(ds, e);
        }

    }

    protected void lookup_element_Element(ElementInputDs ds, ElementInput e)
            throws Exception {
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

    protected void lookup_crossReference_Element(ElementInputDs ds,
            ElementInput e) throws Exception {
        if (ds.getEngineId() != null && !ds.getEngineId().equals("")
                && ds.getReference() != null && !ds.getReference().equals("")) {
            Element x = null;
            try {
                x = ((IElementService) findEntityService(Element.class))
                        .findByEngine_code(ds.getEngineId(), ds.getReference());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Element` reference:  `engineId` = "
                                + ds.getEngineId() + " , `reference` = "
                                + ds.getReference() + "  ");
            }
            e.setCrossReference(x);

        } else {
            e.setCrossReference(null);
        }
    }

}
