/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.base.elem.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.md.base.elem.business.service.IElementValueService;
import net.nan21.dnet.module.md.base.elem.domain.entity.Element;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.md.base.elem.domain.entity.ElementValue;

public class ElementValueService extends AbstractEntityService<ElementValue>
        implements IElementValueService {

    public ElementValueService() {
        super();
    }

    public ElementValueService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<ElementValue> getEntityClass() {
        return ElementValue.class;
    }

    public List<ElementValue> findByElement(Element element) {
        return this.findByElementId(element.getId());
    }

    public List<ElementValue> findByElementId(Long elementId) {
        return (List<ElementValue>) this.em
                .createQuery(
                        "select e from ElementValue e where e.clientId = :pClientId and e.element.id = :pElementId",
                        ElementValue.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pElementId", elementId).getResultList();
    }

    public List<ElementValue> findByOrg(Organization org) {
        return this.findByOrgId(org.getId());
    }

    public List<ElementValue> findByOrgId(Long orgId) {
        return (List<ElementValue>) this.em
                .createQuery(
                        "select e from ElementValue e where e.clientId = :pClientId and e.org.id = :pOrgId",
                        ElementValue.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pOrgId", orgId).getResultList();
    }

}
