/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.quartz.business.serviceimpl;

import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.ad.quartz.business.service.IQuartzCronTriggerService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.ad.quartz.domain.entity.QuartzCronTrigger;

public class QuartzCronTriggerService extends
        AbstractEntityService<QuartzCronTrigger> implements
        IQuartzCronTriggerService {

    public QuartzCronTriggerService() {
        super();
    }

    public QuartzCronTriggerService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<QuartzCronTrigger> getEntityClass() {
        return QuartzCronTrigger.class;
    }

}
