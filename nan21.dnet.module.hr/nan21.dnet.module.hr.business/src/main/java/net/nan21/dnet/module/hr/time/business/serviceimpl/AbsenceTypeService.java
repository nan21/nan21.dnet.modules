/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.time.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.domain.service.AbstractEntityService;
import net.nan21.dnet.module.hr.time.business.service.IAbsenceTypeService;
import net.nan21.dnet.module.hr.time.domain.entity.AbsenceCategory;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.hr.time.domain.entity.AbsenceType;

public class AbsenceTypeService extends AbstractEntityService<AbsenceType>
        implements IAbsenceTypeService {

    public AbsenceTypeService() {
        super();
    }

    public AbsenceTypeService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<AbsenceType> getEntityClass() {
        return AbsenceType.class;
    }

    public AbsenceType findByName(Long clientId, String name) {
        return (AbsenceType) this.em
                .createNamedQuery(AbsenceType.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

    public List<AbsenceType> findByCategory(AbsenceCategory category) {
        return this.findByCategoryId(category.getId());
    }

    public List<AbsenceType> findByCategoryId(Long categoryId) {
        return (List<AbsenceType>) this.em
                .createQuery(
                        "select e from AbsenceType where e.category.id = :pCategoryId",
                        AbsenceType.class)
                .setParameter("pCategoryId", categoryId).getResultList();
    }

}
