/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.standards.business.serviceimpl;

import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.standards.business.service.IClassificationSystemService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.bd.standards.domain.entity.ClassificationSystem;

public class ClassificationSystemService extends
        AbstractEntityService<ClassificationSystem> implements
        IClassificationSystemService {

    public ClassificationSystemService() {
        super();
    }

    public ClassificationSystemService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<ClassificationSystem> getEntityClass() {
        return ClassificationSystem.class;
    }

    public ClassificationSystem findByCode(Long clientId, String code) {
        return (ClassificationSystem) this.em
                .createNamedQuery(ClassificationSystem.NQ_FIND_BY_CODE)
                .setParameter("pClientId", clientId)
                .setParameter("pCode", code).getSingleResult();
    }

    public ClassificationSystem findByName(Long clientId, String name) {
        return (ClassificationSystem) this.em
                .createNamedQuery(ClassificationSystem.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

}
