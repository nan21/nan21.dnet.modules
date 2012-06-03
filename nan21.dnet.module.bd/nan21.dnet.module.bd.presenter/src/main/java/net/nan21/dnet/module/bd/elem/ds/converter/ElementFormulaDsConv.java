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
import net.nan21.dnet.module.bd.elem.ds.model.ElementFormulaDs;
import net.nan21.dnet.module.bd.elem.domain.entity.ElementFormula;

public class ElementFormulaDsConv extends
        AbstractDsConverter<ElementFormulaDs, ElementFormula> implements
        IDsConverter<ElementFormulaDs, ElementFormula> {

    @Override
    protected void modelToEntityReferences(ElementFormulaDs ds,
            ElementFormula e, boolean isInsert) throws Exception {

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

    }

    protected void lookup_element_Element(ElementFormulaDs ds, ElementFormula e)
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

}
