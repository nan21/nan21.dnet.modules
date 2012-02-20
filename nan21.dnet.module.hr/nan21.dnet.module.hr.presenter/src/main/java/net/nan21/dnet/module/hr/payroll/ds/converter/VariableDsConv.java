/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.payroll.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.hr.payroll.business.service.IElementService;
import net.nan21.dnet.module.hr.payroll.domain.entity.Element;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.hr.payroll.ds.model.VariableDs;
import net.nan21.dnet.module.hr.payroll.domain.entity.Variable;

public class VariableDsConv extends AbstractDsConverter<VariableDs, Variable>
        implements IDsConverter<VariableDs, Variable> {

    @Override
    protected void modelToEntityReferences(VariableDs ds, Variable e,
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

        if (ds.getCrossReferenceId() != null) {
            if (e.getCrossReference() == null
                    || !e.getCrossReference().getId()
                            .equals(ds.getCrossReferenceId())) {
                e.setCrossReference((Element) this.em.find(Element.class,
                        ds.getCrossReferenceId()));
            }
        } else {
            this.lookup_crossReference_Element(ds, e);
        }

    }

    protected void lookup_element_Element(VariableDs ds, Variable e)
            throws Exception {
        if (ds.getElement() != null && !ds.getElement().equals("")) {
            Element x = null;
            try {
                x = ((IElementService) findEntityService(Element.class))
                        .findByName(ds.getElement());
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

    protected void lookup_crossReference_Element(VariableDs ds, Variable e)
            throws Exception {
        if (ds.getCrossReference() != null
                && !ds.getCrossReference().equals("")) {
            Element x = null;
            try {
                x = ((IElementService) findEntityService(Element.class))
                        .findByName(ds.getCrossReference());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Element` reference:  `crossReference` = "
                                + ds.getCrossReference() + "  ");
            }
            e.setCrossReference(x);

        } else {
            e.setCrossReference(null);
        }
    }

}
