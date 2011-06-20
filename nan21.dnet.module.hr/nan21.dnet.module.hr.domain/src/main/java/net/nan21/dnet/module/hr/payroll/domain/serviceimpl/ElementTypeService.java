/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.payroll.domain.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.domain.service.AbstractEntityService;
import net.nan21.dnet.module.hr.payroll.domain.entity.ElementCategory;
import net.nan21.dnet.module.hr.payroll.domain.service.IElementTypeService;

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

    public ElementType findByName(Long clientId, String name) {
        return (ElementType) this.em
                .createNamedQuery(ElementType.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

    public List<ElementType> findByCategory(ElementCategory category) {
        return this.findByCategoryId(category.getId());
    }

    public List<ElementType> findByCategoryId(Long categoryId) {
        return (List<ElementType>) this.em
                .createQuery(
                        "select e from ElementType where e.category.id = :pCategoryId",
                        ElementType.class)
                .setParameter("pCategoryId", categoryId).getResultList();
    }

}
