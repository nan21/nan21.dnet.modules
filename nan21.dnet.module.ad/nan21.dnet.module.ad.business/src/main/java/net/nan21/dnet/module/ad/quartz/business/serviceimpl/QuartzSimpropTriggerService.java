/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.quartz.business.serviceimpl;

import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.ad.quartz.business.service.IQuartzSimpropTriggerService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.ad.quartz.domain.entity.QuartzSimpropTrigger;

public class QuartzSimpropTriggerService extends
        AbstractEntityService<QuartzSimpropTrigger> implements
        IQuartzSimpropTriggerService {

    public QuartzSimpropTriggerService() {
        super();
    }

    public QuartzSimpropTriggerService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<QuartzSimpropTrigger> getEntityClass() {
        return QuartzSimpropTrigger.class;
    }

}
