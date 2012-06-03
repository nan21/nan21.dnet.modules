/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.quartz.business.serviceimpl;

import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.ad.quartz.business.service.IQuartzSchedulerStateService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.ad.quartz.domain.entity.QuartzSchedulerState;

public class QuartzSchedulerStateService extends
        AbstractEntityService<QuartzSchedulerState> implements
        IQuartzSchedulerStateService {

    public QuartzSchedulerStateService() {
        super();
    }

    public QuartzSchedulerStateService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<QuartzSchedulerState> getEntityClass() {
        return QuartzSchedulerState.class;
    }

}
