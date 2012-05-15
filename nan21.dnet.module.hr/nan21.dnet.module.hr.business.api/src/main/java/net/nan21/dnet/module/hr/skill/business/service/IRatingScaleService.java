/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.skill.business.service;

import net.nan21.dnet.core.api.service.IEntityService;

import net.nan21.dnet.module.hr.skill.domain.entity.RatingScale;

public interface IRatingScaleService extends IEntityService<RatingScale> {

    public RatingScale findByName(String name);

}
