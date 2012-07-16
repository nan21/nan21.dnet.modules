/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.workflow.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;
import net.nan21.dnet.module.ad.workflow.domain.entity.WfDefProcess;

@Ds(entity = WfDefProcess.class, sort = { @SortField(field = WfDefProcessDs.fNAME) })
public class WfDefProcessDs extends AbstractTypeDs<WfDefProcess> {

    public WfDefProcessDs() {
        super();
    }

    public WfDefProcessDs(WfDefProcess e) {
        super(e);
    }

}
