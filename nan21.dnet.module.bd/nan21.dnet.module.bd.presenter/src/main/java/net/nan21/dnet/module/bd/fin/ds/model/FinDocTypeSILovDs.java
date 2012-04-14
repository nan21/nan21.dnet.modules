/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.fin.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;

import net.nan21.dnet.module.bd.fin.domain.entity.FinDocType;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = FinDocType.class, jpqlWhere = " e.category = 'SI' ", sort = { @SortField(field = FinDocTypeSILovDs.fNAME) })
public class FinDocTypeSILovDs extends AbstractTypeLov<FinDocType> {

    public static final String fCATEGORY = "category";

    @DsField()
    private String category;

    public FinDocTypeSILovDs() {
        super();
    }

    public FinDocTypeSILovDs(FinDocType e) {
        super(e);
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
