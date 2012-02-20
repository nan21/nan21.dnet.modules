/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.payroll.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.hr.payroll.business.service.IElementTypeService;
import net.nan21.dnet.module.hr.payroll.domain.entity.ElementCategory;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.hr.payroll.domain.entity.ElementType;

public class ElementTypeService extends AbstractEntityService<ElementType>
        implements IElementTypeService {

    public ElementTypeService() {
        super();
    }

    public ElementTypeService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<ElementType> getEntityClass() {
        return ElementType.class;
    }

    public ElementType findByName(String name) {
        return (ElementType) this.em
                .createNamedQuery(ElementType.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

    public List<ElementType> findByCategory(ElementCategory category) {
        return this.findByCategoryId(category.getId());
    }

    public List<ElementType> findByCategoryId(Long categoryId) {
        return (List<ElementType>) this.em
                .createQuery(
                        "select e from ElementType e where e.clientId = :pClientId and e.category.id = :pCategoryId",
                        ElementType.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pCategoryId", categoryId).getResultList();
    }

}
