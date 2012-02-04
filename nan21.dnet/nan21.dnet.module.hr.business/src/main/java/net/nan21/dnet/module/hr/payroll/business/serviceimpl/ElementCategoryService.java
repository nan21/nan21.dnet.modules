/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.payroll.business.serviceimpl;

import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.hr.payroll.business.service.IElementCategoryService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.hr.payroll.domain.entity.ElementCategory;

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

    public ElementCategory findByName(Long clientId, String name) {
        return (ElementCategory) this.em
                .createNamedQuery(ElementCategory.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

}
