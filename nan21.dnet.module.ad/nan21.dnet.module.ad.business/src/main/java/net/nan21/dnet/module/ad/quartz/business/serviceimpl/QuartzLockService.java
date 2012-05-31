/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.quartz.business.serviceimpl;

import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.ad.quartz.business.service.IQuartzLockService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.ad.quartz.domain.entity.QuartzLock;

public class QuartzLockService extends AbstractEntityService<QuartzLock>
        implements IQuartzLockService {

    public QuartzLockService() {
        super();
    }

    public QuartzLockService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<QuartzLock> getEntityClass() {
        return QuartzLock.class;
    }

}
