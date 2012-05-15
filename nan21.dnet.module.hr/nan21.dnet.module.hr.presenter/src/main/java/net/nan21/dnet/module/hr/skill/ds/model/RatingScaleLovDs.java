/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.skill.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;

import net.nan21.dnet.module.hr.skill.domain.entity.RatingScale;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = RatingScale.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = RatingScaleLovDs.fNAME) })
public class RatingScaleLovDs extends AbstractTypeLov<RatingScale> {

    public RatingScaleLovDs() {
        super();
    }

    public RatingScaleLovDs(RatingScale e) {
        super(e);
    }

}
