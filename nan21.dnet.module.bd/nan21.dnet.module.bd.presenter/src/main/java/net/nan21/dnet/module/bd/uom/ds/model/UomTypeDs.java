/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.uom.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;
import net.nan21.dnet.module.bd.uom.domain.entity.UomType;

@Ds(entity = UomType.class, sort = { @SortField(field = UomTypeDs.fNAME) })
public class UomTypeDs extends AbstractTypeDs<UomType> {

    public static final String fCATEGORY = "category";

    @DsField()
    private String category;

    public UomTypeDs() {
        super();
    }

    public UomTypeDs(UomType e) {
        super(e);
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
