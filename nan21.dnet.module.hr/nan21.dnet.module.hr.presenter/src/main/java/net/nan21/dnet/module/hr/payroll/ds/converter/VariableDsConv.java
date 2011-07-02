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

    protected void modelToEntityAttributes(VariableDs ds, Variable e)
            throws Exception {
        e.setName(ds.getName());
        e.setCode(ds.getCode());
        e.setActive(ds.getActive());
        e.setNotes(ds.getNotes());
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
    }

    protected void modelToEntityReferences(VariableDs ds, Variable e)
            throws Exception {

        if (ds.getElementId() != null) {
            if (e.getElement() == null
                    || !e.getElement().getId().equals(ds.getElementId())) {
                e.setElement((Element) this.em.getReference(Element.class,
                        ds.getElementId()));
            }
        } else {
            this.lookup_element_Element(ds, e);
        }
        if (ds.getCrossReferenceId() != null) {
            if (e.getCrossReference() == null
                    || !e.getCrossReference().getId()
                            .equals(ds.getCrossReferenceId())) {
                e.setCrossReference((Element) this.em.getReference(
                        Element.class, ds.getCrossReferenceId()));
            }
        } else {
            this.lookup_crossReference_Element(ds, e);
        }
    }

    protected void lookup_element_Element(VariableDs ds, Variable e)
            throws Exception {
        Element x = null;
        try {
            x = ((IElementService) getService(IElementService.class))
                    .findByName(ds.getClientId(), ds.getElement());
        } catch (javax.persistence.NoResultException exception) {

        }
        e.setElement(x);
    }

    protected void lookup_crossReference_Element(VariableDs ds, Variable e)
            throws Exception {
        Element x = null;
        try {
            x = ((IElementService) getService(IElementService.class))
                    .findByName(ds.getClientId(), ds.getCrossReference());
        } catch (javax.persistence.NoResultException exception) {

        }
        e.setCrossReference(x);
    }

    @Override
    public void entityToModel(Variable e, VariableDs ds) throws Exception {
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
        ds.setElementId(((e.getElement() != null)) ? e.getElement().getId()
                : null);
        ds.setElement(((e.getElement() != null)) ? e.getElement().getName()
                : null);
        ds.setCrossReferenceId(((e.getCrossReference() != null)) ? e
                .getCrossReference().getId() : null);
        ds.setCrossReference(((e.getCrossReference() != null)) ? e
                .getCrossReference().getName() : null);
    }

}
