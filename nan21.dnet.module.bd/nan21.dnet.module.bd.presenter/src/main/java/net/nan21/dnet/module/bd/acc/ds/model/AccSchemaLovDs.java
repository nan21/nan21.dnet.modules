/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.acc.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeLov;

import net.nan21.dnet.module.bd.acc.domain.entity.AccSchema;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = AccSchema.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = AccSchemaLovDs.fCODE) })
public class AccSchemaLovDs extends AbstractTypeWithCodeLov<AccSchema> {

    public AccSchemaLovDs() {
        super();
    }

    public AccSchemaLovDs(AccSchema e) {
        super(e);
    }

}
