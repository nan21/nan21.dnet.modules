/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.payroll.domain.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.domain.service.AbstractEntityService;
import net.nan21.dnet.module.hr.payroll.domain.entity.ElementType;
import net.nan21.dnet.module.hr.payroll.domain.service.IElementService;

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

    public Element findByCode(Long clientId, String code) {
        return (Element) this.em.createNamedQuery(Element.NQ_FIND_BY_CODE)
                .setParameter("pClientId", clientId)
                .setParameter("pCode", code).getSingleResult();
    }

    public Element findByName(Long clientId, String name) {
        return (Element) this.em.createNamedQuery(Element.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

    public List<Element> findByType(ElementType type) {
        return this.findByTypeId(type.getId());
    }

    public List<Element> findByTypeId(Long typeId) {
        return (List<Element>) this.em
                .createQuery(
                        "select e from Element where e.type.id = :pTypeId",
                        Element.class).setParameter("pTypeId", typeId)
                .getResultList();
    }

}
