/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.elem.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.elem.business.service.IElementCategoryService;
import net.nan21.dnet.module.bd.elem.domain.entity.Engine;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.bd.elem.domain.entity.ElementCategory;

public class ElementCategoryService extends
        AbstractEntityService<ElementCategory> implements
        IElementCategoryService {

    public ElementCategoryService() {
        super();
    }

    public ElementCategoryService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<ElementCategory> getEntityClass() {
        return ElementCategory.class;
    }

    public ElementCategory findByEngine_name(Engine engine, String name) {
        return (ElementCategory) this.em
                .createNamedQuery(ElementCategory.NQ_FIND_BY_ENGINE_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pEngine", engine).setParameter("pName", name)
                .getSingleResult();
    }

    public ElementCategory findByEngine_name(Long engineId, String name) {
        return (ElementCategory) this.em
                .createNamedQuery(
                        ElementCategory.NQ_FIND_BY_ENGINE_NAME_PRIMITIVE)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pEngineId", engineId)
                .setParameter("pName", name).getSingleResult();
    }

    public List<ElementCategory> findByEngine(Engine engine) {
        return this.findByEngineId(engine.getId());
    }

    public List<ElementCategory> findByEngineId(Long engineId) {
        return (List<ElementCategory>) this.em
                .createQuery(
                        "select e from ElementCategory e where e.clientId = :pClientId and e.engine.id = :pEngineId",
                        ElementCategory.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pEngineId", engineId).getResultList();
    }

}
