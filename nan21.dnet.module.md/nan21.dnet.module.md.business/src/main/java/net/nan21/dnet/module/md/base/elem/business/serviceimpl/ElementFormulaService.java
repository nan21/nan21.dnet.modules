/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.base.elem.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.md.base.elem.business.service.IElementFormulaService;
import net.nan21.dnet.module.md.base.elem.domain.entity.Element;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.md.base.elem.domain.entity.ElementFormula;

public class ElementFormulaService extends
        AbstractEntityService<ElementFormula> implements IElementFormulaService {

    public ElementFormulaService() {
        super();
    }

    public ElementFormulaService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<ElementFormula> getEntityClass() {
        return ElementFormula.class;
    }

    public List<ElementFormula> findByElement(Element element) {
        return this.findByElementId(element.getId());
    }

    public List<ElementFormula> findByElementId(Long elementId) {
        return (List<ElementFormula>) this.em
                .createQuery(
                        "select e from ElementFormula e where e.clientId = :pClientId and e.element.id = :pElementId",
                        ElementFormula.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pElementId", elementId).getResultList();
    }

}
