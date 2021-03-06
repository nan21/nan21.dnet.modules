/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.workflow.business.serviceimpl;

import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.ad.workflow.business.service.IActAttachmentService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActAttachment;

public class ActAttachmentService extends AbstractEntityService<ActAttachment>
        implements IActAttachmentService {

    public ActAttachmentService() {
        super();
    }

    public ActAttachmentService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<ActAttachment> getEntityClass() {
        return ActAttachment.class;
    }

}
