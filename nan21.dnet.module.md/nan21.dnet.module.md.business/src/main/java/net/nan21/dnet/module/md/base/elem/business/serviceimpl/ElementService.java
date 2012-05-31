/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.base.elem.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.md.base.elem.business.service.IElementService;
import net.nan21.dnet.module.md.base.elem.domain.entity.ElementFormula;
import net.nan21.dnet.module.md.base.elem.domain.entity.ElementInput;
import net.nan21.dnet.module.md.base.elem.domain.entity.ElementType;
import net.nan21.dnet.module.md.base.elem.domain.entity.Engine;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.md.base.elem.domain.entity.Element;

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

    public List<Element> findByEngine(Engine engine) {
        return this.findByEngineId(engine.getId());
    }

    public List<Element> findByEngineId(Long engineId) {
        return (List<Element>) this.em
                .createQuery(
                        "select e from Element e where e.clientId = :pClientId and e.engine.id = :pEngineId",
                        Element.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pEngineId", engineId).getResultList();
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

    public List<Element> findByVariables(ElementInput variables) {
        return this.findByVariablesId(variables.getId());
    }

    public List<Element> findByVariablesId(Long variablesId) {
        return (List<Element>) this.em
                .createQuery(
                        "select distinct e from Element e , IN (e.variables) c where e.clientId = :pClientId and c.id = :pVariablesId",
                        Element.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pVariablesId", variablesId).getResultList();
    }

    public List<Element> findByFormulas(ElementFormula formulas) {
        return this.findByFormulasId(formulas.getId());
    }

    public List<Element> findByFormulasId(Long formulasId) {
        return (List<Element>) this.em
                .createQuery(
                        "select distinct e from Element e , IN (e.formulas) c where e.clientId = :pClientId and c.id = :pFormulasId",
                        Element.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pFormulasId", formulasId).getResultList();
    }

}
