/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.elem.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.elem.business.service.IElementSetElementService;
import net.nan21.dnet.module.bd.elem.domain.entity.Element;
import net.nan21.dnet.module.bd.elem.domain.entity.ElementSet;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.bd.elem.domain.entity.ElementSetElement;

public class ElementSetElementService extends
        AbstractEntityService<ElementSetElement> implements
        IElementSetElementService {

    public ElementSetElementService() {
        super();
    }

    public ElementSetElementService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<ElementSetElement> getEntityClass() {
        return ElementSetElement.class;
    }

    public ElementSetElement findBySet_elem(ElementSet elementSet,
            Element element) {
        return (ElementSetElement) this.em
                .createNamedQuery(ElementSetElement.NQ_FIND_BY_SET_ELEM)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pElementSet", elementSet)
                .setParameter("pElement", element).getSingleResult();
    }

    public ElementSetElement findBySet_elem(Long elementSetId, Long elementId) {
        return (ElementSetElement) this.em
                .createNamedQuery(
                        ElementSetElement.NQ_FIND_BY_SET_ELEM_PRIMITIVE)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pElementSetId", elementSetId)
                .setParameter("pElementId", elementId).getSingleResult();
    }

    public List<ElementSetElement> findByElementSet(ElementSet elementSet) {
        return this.findByElementSetId(elementSet.getId());
    }

    public List<ElementSetElement> findByElementSetId(Long elementSetId) {
        return (List<ElementSetElement>) this.em
                .createQuery(
                        "select e from ElementSetElement e where e.clientId = :pClientId and e.elementSet.id = :pElementSetId",
                        ElementSetElement.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pElementSetId", elementSetId).getResultList();
    }

    public List<ElementSetElement> findByElement(Element element) {
        return this.findByElementId(element.getId());
    }

    public List<ElementSetElement> findByElementId(Long elementId) {
        return (List<ElementSetElement>) this.em
                .createQuery(
                        "select e from ElementSetElement e where e.clientId = :pClientId and e.element.id = :pElementId",
                        ElementSetElement.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pElementId", elementId).getResultList();
    }

}
