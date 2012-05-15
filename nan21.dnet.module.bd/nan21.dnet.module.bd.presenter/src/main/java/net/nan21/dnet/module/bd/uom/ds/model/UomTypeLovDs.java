/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.uom.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;

import net.nan21.dnet.module.bd.uom.domain.entity.UomType;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = UomType.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = UomTypeLovDs.fNAME) })
public class UomTypeLovDs extends AbstractTypeLov<UomType> {

    public UomTypeLovDs() {
        super();
    }

    public UomTypeLovDs(UomType e) {
        super(e);
    }

}
