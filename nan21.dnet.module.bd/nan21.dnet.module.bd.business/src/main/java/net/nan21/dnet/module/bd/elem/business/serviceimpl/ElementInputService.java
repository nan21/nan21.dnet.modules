/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.elem.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.elem.business.service.IElementInputService;
import net.nan21.dnet.module.bd.elem.domain.entity.Element;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.bd.elem.domain.entity.ElementInput;

public class ElementInputService extends AbstractEntityService<ElementInput>
        implements IElementInputService {

    public ElementInputService() {
        super();
    }

    public ElementInputService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<ElementInput> getEntityClass() {
        return ElementInput.class;
    }

    public List<ElementInput> findByElement(Element element) {
        return this.findByElementId(element.getId());
    }

    public List<ElementInput> findByElementId(Long elementId) {
        return (List<ElementInput>) this.em
                .createQuery(
                        "select e from ElementInput e where e.clientId = :pClientId and e.element.id = :pElementId",
                        ElementInput.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pElementId", elementId).getResultList();
    }

    public List<ElementInput> findByCrossReference(Element crossReference) {
        return this.findByCrossReferenceId(crossReference.getId());
    }

    public List<ElementInput> findByCrossReferenceId(Long crossReferenceId) {
        return (List<ElementInput>) this.em
                .createQuery(
                        "select e from ElementInput e where e.clientId = :pClientId and e.crossReference.id = :pCrossReferenceId",
                        ElementInput.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pCrossReferenceId", crossReferenceId)
                .getResultList();
    }

}
