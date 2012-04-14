/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.system.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;

import net.nan21.dnet.module.ad.system.domain.entity.SysDateFormat;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = SysDateFormat.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = SysDateFormatLovDs.fNAME) })
public class SysDateFormatLovDs extends AbstractTypeLov<SysDateFormat> {

    public SysDateFormatLovDs() {
        super();
    }

    public SysDateFormatLovDs(SysDateFormat e) {
        super(e);
    }

}
