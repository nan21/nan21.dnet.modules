/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.skill.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.hr.skill.ds.model.RatingScaleLovDs;
import net.nan21.dnet.module.hr.skill.domain.entity.RatingScale;

public class RatingScaleLovDsConv extends
        AbstractDsConverter<RatingScaleLovDs, RatingScale> implements
        IDsConverter<RatingScaleLovDs, RatingScale> {

    protected void modelToEntityAttributes(RatingScaleLovDs ds, RatingScale e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(RatingScaleLovDs ds, RatingScale e)
            throws Exception {
    }

    @Override
    public void entityToModel(RatingScale e, RatingScaleLovDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
    }

}
