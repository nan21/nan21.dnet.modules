/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.skill.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.hr.skill.business.service.IRatingScaleService;
import net.nan21.dnet.module.hr.skill.domain.entity.RatingScale;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.hr.skill.ds.model.RatingLevelDs;
import net.nan21.dnet.module.hr.skill.domain.entity.RatingLevel;

public class RatingLevelDsConv extends
        AbstractDsConverter<RatingLevelDs, RatingLevel> implements
        IDsConverter<RatingLevelDs, RatingLevel> {

    protected void modelToEntityReferences(RatingLevelDs ds, RatingLevel e)
            throws Exception {
        if (ds.getRatingScaleId() != null) {
            if (e.getRatingScale() == null
                    || !e.getRatingScale().getId()
                            .equals(ds.getRatingScaleId())) {
                e.setRatingScale((RatingScale) this.em.find(RatingScale.class,
                        ds.getRatingScaleId()));
            }
        } else {
            this.lookup_ratingScale_RatingScale(ds, e);
        }
    }

    protected void lookup_ratingScale_RatingScale(RatingLevelDs ds,
            RatingLevel e) throws Exception {
        if (ds.getRatingScale() != null && !ds.getRatingScale().equals("")) {
            RatingScale x = null;
            try {
                x = ((IRatingScaleService) findEntityService(RatingScale.class))
                        .findByName(ds.getClientId(), ds.getRatingScale());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `RatingScale` reference:  `ratingScale` = "
                                + ds.getRatingScale() + "  ");
            }
            e.setRatingScale(x);

        } else {
            e.setRatingScale(null);
        }
    }

}
