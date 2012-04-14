/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.impex.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;

import net.nan21.dnet.module.ad.impex.domain.entity.ExportMap;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = ExportMap.class, sort = { @SortField(field = ExportMapDs.fNAME) })
public class ExportMapDs extends AbstractTypeDs<ExportMap> {

    public ExportMapDs() {
        super();
    }

    public ExportMapDs(ExportMap e) {
        super(e);
    }

}
