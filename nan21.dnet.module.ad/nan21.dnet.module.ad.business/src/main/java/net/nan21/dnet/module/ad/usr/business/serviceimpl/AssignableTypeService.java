/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.usr.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.ad.system.domain.entity.BusinessObject;
import net.nan21.dnet.module.ad.usr.business.service.IAssignableTypeService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.ad.usr.domain.entity.AssignableType;

public class AssignableTypeService extends
        AbstractEntityService<AssignableType> implements IAssignableTypeService {

    public AssignableTypeService() {
        super();
    }

    public AssignableTypeService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<AssignableType> getEntityClass() {
        return AssignableType.class;
    }

    public AssignableType findByName(Long clientId, String name) {
        return (AssignableType) this.em
                .createNamedQuery(AssignableType.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

    public List<AssignableType> findByBusinessObject(
            BusinessObject businessObject) {
        return this.findByBusinessObjectId(businessObject.getId());
    }

    public List<AssignableType> findByBusinessObjectId(Long businessObjectId) {
        return (List<AssignableType>) this.em
                .createQuery(
                        "select e from AssignableType e where e.businessObject.id = :pBusinessObjectId",
                        AssignableType.class)
                .setParameter("pBusinessObjectId", businessObjectId)
                .getResultList();
    }

}
