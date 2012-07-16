/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.uom.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeLov;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;

@Ds(entity = Uom.class, jpqlWhere = " e.type.category = 'length' ", sort = { @SortField(field = UomLengthLovDs.fCODE) })
public class UomLengthLovDs extends AbstractTypeWithCodeLov<Uom> {

    public UomLengthLovDs() {
        super();
    }

    public UomLengthLovDs(Uom e) {
        super(e);
    }

}
