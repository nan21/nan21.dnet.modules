/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.skill.business.serviceimpl;

import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.hr.skill.business.service.IQualificationService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.hr.skill.domain.entity.Qualification;

public class QualificationService extends AbstractEntityService<Qualification>
        implements IQualificationService {

    public QualificationService() {
        super();
    }

    public QualificationService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<Qualification> getEntityClass() {
        return Qualification.class;
    }

    public Qualification findByName(Long clientId, String name) {
        return (Qualification) this.em
                .createNamedQuery(Qualification.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

}
