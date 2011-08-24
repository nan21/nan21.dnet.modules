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

    protected void modelToEntityAttributes(RatingLevelDs ds, RatingLevel e)
            throws Exception {
        e.setName(ds.getName());
        e.setActive(ds.getActive());
        e.setDescription(ds.getDescription());
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
        e.setValue(ds.getValue());
    }

    protected void modelToEntityReferences(RatingLevelDs ds, RatingLevel e)
            throws Exception {

        if (ds.getRatingScaleId() != null) {
            if (e.getRatingScale() == null
                    || !e.getRatingScale().getId()
                            .equals(ds.getRatingScaleId())) {
                e.setRatingScale((RatingScale) this.em.getReference(
                        RatingScale.class, ds.getRatingScaleId()));
            }
        } else {
            this.lookup_ratingScale_RatingScale(ds, e);
        }
    }

    protected void lookup_ratingScale_RatingScale(RatingLevelDs ds,
            RatingLevel e) throws Exception {
        if (ds.getRatingScale() != null) {
            RatingScale x = null;
            try {
                x = ((IRatingScaleService) getService(IRatingScaleService.class))
                        .findByName(ds.getClientId(), ds.getRatingScale());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `RatingScale` reference:  `ratingScale` = "
                                + ds.getRatingScale() + "  ");
            }
            e.setRatingScale(x);
        }
    }

    @Override
    public void entityToModel(RatingLevel e, RatingLevelDs ds) throws Exception {
        ds.setName(e.getName());
        ds.setActive(e.getActive());
        ds.setDescription(e.getDescription());
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
        ds.setValue(e.getValue());
        ds.setRatingScaleId(((e.getRatingScale() != null)) ? e.getRatingScale()
                .getId() : null);
        ds.setRatingScale(((e.getRatingScale() != null)) ? e.getRatingScale()
                .getName() : null);
    }

}
