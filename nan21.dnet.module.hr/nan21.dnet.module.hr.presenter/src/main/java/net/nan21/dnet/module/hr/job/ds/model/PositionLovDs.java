/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.job.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeLov;
import net.nan21.dnet.module.hr.job.domain.entity.Position;

@Ds(entity = Position.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = PositionLovDs.fCODE) })
public class PositionLovDs extends AbstractTypeWithCodeLov<Position> {

    public PositionLovDs() {
        super();
    }

    public PositionLovDs(Position e) {
        super(e);
    }

}
