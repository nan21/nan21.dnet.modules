/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.benefit.business.service;

import net.nan21.dnet.core.api.service.IEntityService;

import net.nan21.dnet.module.hr.benefit.domain.entity.Benefit;

public interface IBenefitService extends IEntityService<Benefit> {

    public Benefit findByName(String name);

}
