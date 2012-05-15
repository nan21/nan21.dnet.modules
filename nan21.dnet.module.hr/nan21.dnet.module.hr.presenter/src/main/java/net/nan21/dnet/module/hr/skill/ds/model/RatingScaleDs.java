/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.skill.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;

import net.nan21.dnet.module.hr.skill.domain.entity.RatingScale;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = RatingScale.class, sort = { @SortField(field = RatingScaleDs.fNAME) })
public class RatingScaleDs extends AbstractTypeDs<RatingScale> {

    public RatingScaleDs() {
        super();
    }

    public RatingScaleDs(RatingScale e) {
        super(e);
    }

}
