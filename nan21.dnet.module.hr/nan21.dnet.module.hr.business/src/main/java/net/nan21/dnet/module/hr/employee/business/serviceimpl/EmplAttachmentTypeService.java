/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.employee.business.serviceimpl;

import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.hr.employee.business.service.IEmplAttachmentTypeService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.hr.employee.domain.entity.EmplAttachmentType;

public class EmplAttachmentTypeService extends
        AbstractEntityService<EmplAttachmentType> implements
        IEmplAttachmentTypeService {

    public EmplAttachmentTypeService() {
        super();
    }

    public EmplAttachmentTypeService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<EmplAttachmentType> getEntityClass() {
        return EmplAttachmentType.class;
    }

    public EmplAttachmentType findByName(Long clientId, String name) {
        return (EmplAttachmentType) this.em
                .createNamedQuery(EmplAttachmentType.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

}
