/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.payroll.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.hr.payroll.business.service.IVariableService;
import net.nan21.dnet.module.hr.payroll.domain.entity.Element;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.hr.payroll.domain.entity.Variable;

public class VariableService extends AbstractEntityService<Variable> implements
        IVariableService {

    public VariableService() {
        super();
    }

    public VariableService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<Variable> getEntityClass() {
        return Variable.class;
    }

    public Variable findByCode(Element element, String code) {
        return (Variable) this.em.createNamedQuery(Variable.NQ_FIND_BY_CODE)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pElement", element).setParameter("pCode", code)
                .getSingleResult();
    }

    public Variable findByCode(Long elementId, String code) {
        return (Variable) this.em
                .createNamedQuery(Variable.NQ_FIND_BY_CODE_PRIMITIVE)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pElementId", elementId)
                .setParameter("pCode", code).getSingleResult();
    }

    public Variable findByName(Element element, String name) {
        return (Variable) this.em.createNamedQuery(Variable.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pElement", element).setParameter("pName", name)
                .getSingleResult();
    }

    public Variable findByName(Long elementId, String name) {
        return (Variable) this.em
                .createNamedQuery(Variable.NQ_FIND_BY_NAME_PRIMITIVE)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pElementId", elementId)
                .setParameter("pName", name).getSingleResult();
    }

    public List<Variable> findByElement(Element element) {
        return this.findByElementId(element.getId());
    }

    public List<Variable> findByElementId(Long elementId) {
        return (List<Variable>) this.em
                .createQuery(
                        "select e from Variable e where e.clientId = :pClientId and  e.element.id = :pElementId",
                        Variable.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pElementId", elementId).getResultList();
    }

    public List<Variable> findByCrossReference(Element crossReference) {
        return this.findByCrossReferenceId(crossReference.getId());
    }

    public List<Variable> findByCrossReferenceId(Long crossReferenceId) {
        return (List<Variable>) this.em
                .createQuery(
                        "select e from Variable e where e.clientId = :pClientId and  e.crossReference.id = :pCrossReferenceId",
                        Variable.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pCrossReferenceId", crossReferenceId)
                .getResultList();
    }

}
