/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.grade.business.serviceimpl;

import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.hr.grade.business.service.IGradeService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.hr.grade.domain.entity.Grade;

public class GradeService extends AbstractEntityService<Grade> implements
        IGradeService {

    public GradeService() {
        super();
    }

    public GradeService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<Grade> getEntityClass() {
        return Grade.class;
    }

    public Grade findByCode(Long clientId, String code) {
        return (Grade) this.em.createNamedQuery(Grade.NQ_FIND_BY_CODE)
                .setParameter("pClientId", clientId)
                .setParameter("pCode", code).getSingleResult();
    }

    public Grade findByName(Long clientId, String name) {
        return (Grade) this.em.createNamedQuery(Grade.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

}
