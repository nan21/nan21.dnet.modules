/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.quartz.business.serviceimpl;

import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.ad.quartz.business.service.IQuartzSimpleTriggerService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.ad.quartz.domain.entity.QuartzSimpleTrigger;

public class QuartzSimpleTriggerService extends
        AbstractEntityService<QuartzSimpleTrigger> implements
        IQuartzSimpleTriggerService {

    public QuartzSimpleTriggerService() {
        super();
    }

    public QuartzSimpleTriggerService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<QuartzSimpleTrigger> getEntityClass() {
        return QuartzSimpleTrigger.class;
    }

}
