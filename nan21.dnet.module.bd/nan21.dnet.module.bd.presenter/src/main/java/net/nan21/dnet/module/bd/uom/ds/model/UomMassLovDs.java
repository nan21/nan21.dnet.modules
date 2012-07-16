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

@Ds(entity = Uom.class, jpqlWhere = " e.type.category = 'mass' ", sort = { @SortField(field = UomMassLovDs.fCODE) })
public class UomMassLovDs extends AbstractTypeWithCodeLov<Uom> {

    public UomMassLovDs() {
        super();
    }

    public UomMassLovDs(Uom e) {
        super(e);
    }

}
