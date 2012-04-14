/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.impex.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;

import net.nan21.dnet.module.ad.impex.domain.entity.ExportMap;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = ExportMap.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = ExportMapLovDs.fNAME) })
public class ExportMapLovDs extends AbstractTypeLov<ExportMap> {

    public ExportMapLovDs() {
        super();
    }

    public ExportMapLovDs(ExportMap e) {
        super(e);
    }

}
