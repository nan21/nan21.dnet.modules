/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.quartz.business.serviceimpl;

import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.ad.quartz.business.service.IQuartzBlobTriggerService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.ad.quartz.domain.entity.QuartzBlobTrigger;

public class QuartzBlobTriggerService extends
        AbstractEntityService<QuartzBlobTrigger> implements
        IQuartzBlobTriggerService {

    public QuartzBlobTriggerService() {
        super();
    }

    public QuartzBlobTriggerService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<QuartzBlobTrigger> getEntityClass() {
        return QuartzBlobTrigger.class;
    }

}
