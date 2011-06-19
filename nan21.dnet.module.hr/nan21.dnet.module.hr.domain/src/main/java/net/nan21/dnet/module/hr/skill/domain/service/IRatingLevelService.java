/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.skill.domain.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.skill.domain.entity.RatingScale;

import net.nan21.dnet.module.hr.skill.domain.entity.RatingLevel;

public interface IRatingLevelService extends IEntityService<RatingLevel> {

    public RatingLevel findByName(Long clientId, RatingScale ratingScale,
            String name);

    public RatingLevel findByName(Long clientId, Long ratingScaleId, String name);

    public List<RatingLevel> findByRatingScale(RatingScale ratingScale);

    public List<RatingLevel> findByRatingScaleId(Long ratingScaleId);

}
