/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.skill.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.hr.skill.ds.model.RatingLevelLovDs;
import net.nan21.dnet.module.hr.skill.domain.entity.RatingLevel;

public class RatingLevelLovDsConv extends
        AbstractDsConverter<RatingLevelLovDs, RatingLevel> implements
        IDsConverter<RatingLevelLovDs, RatingLevel> {

    protected void modelToEntityAttributes(RatingLevelLovDs ds, RatingLevel e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
        e.setValue(ds.getValue());
    }

    protected void modelToEntityReferences(RatingLevelLovDs ds, RatingLevel e)
            throws Exception {
    }

    @Override
    public void entityToModel(RatingLevel e, RatingLevelLovDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
        ds.setValue(e.getValue());
        ds.setRatingScaleId(((e.getRatingScale() != null)) ? e.getRatingScale()
                .getId() : null);
    }

}
