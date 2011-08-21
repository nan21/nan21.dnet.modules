/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.workflow.business.serviceimpl;

import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.ad.workflow.business.service.IActJobService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActJob;

public class ActJobService extends AbstractEntityService<ActJob> implements
        IActJobService {

    public ActJobService() {
        super();
    }

    public ActJobService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<ActJob> getEntityClass() {
        return ActJob.class;
    }

}
