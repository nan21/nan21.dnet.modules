/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.payroll.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.hr.payroll.business.service.IElementService;
import net.nan21.dnet.module.hr.payroll.domain.entity.ElementType;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.hr.payroll.domain.entity.Element;

public class ElementService extends AbstractEntityService<Element> implements
        IElementService {

    public ElementService() {
        super();
    }

    public ElementService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<Element> getEntityClass() {
        return Element.class;
    }

    public Element findByCode(String code) {
        return (Element) this.em.createNamedQuery(Element.NQ_FIND_BY_CODE)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pCode", code).getSingleResult();
    }

    public Element findByName(String name) {
        return (Element) this.em.createNamedQuery(Element.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

    public List<Element> findByType(ElementType type) {
        return this.findByTypeId(type.getId());
    }

    public List<Element> findByTypeId(Long typeId) {
        return (List<Element>) this.em
                .createQuery(
                        "select e from Element e where e.clientId = :pClientId and e.type.id = :pTypeId",
                        Element.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pTypeId", typeId).getResultList();
    }

}
