/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.system.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;

import net.nan21.dnet.module.ad.system.domain.entity.SysJobParam;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = SysJobParam.class, sort = { @SortField(field = SysJobParamLovDs.fNAME) })
public class SysJobParamLovDs extends AbstractTypeDs<SysJobParam> {

    public SysJobParamLovDs() {
        super();
    }

    public SysJobParamLovDs(SysJobParam e) {
        super(e);
    }

}
