/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.quartz.business.serviceimpl;

import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.ad.quartz.business.service.IQuartzFiredTriggerService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.ad.quartz.domain.entity.QuartzFiredTrigger;

public class QuartzFiredTriggerService extends
        AbstractEntityService<QuartzFiredTrigger> implements
        IQuartzFiredTriggerService {

    public QuartzFiredTriggerService() {
        super();
    }

    public QuartzFiredTriggerService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<QuartzFiredTrigger> getEntityClass() {
        return QuartzFiredTrigger.class;
    }

}
