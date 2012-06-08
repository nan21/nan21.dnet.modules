/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.base.tx.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;

import net.nan21.dnet.module.md.base.tx.domain.entity.TxDocType;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = TxDocType.class, jpqlWhere = " e.active=true and e.category = 'purchase-order' ", sort = { @SortField(field = TxDocTypePOLovDs.fNAME) })
public class TxDocTypePOLovDs extends AbstractTypeLov<TxDocType> {

    public static final String fCATEGORY = "category";

    @DsField()
    private String category;

    public TxDocTypePOLovDs() {
        super();
    }

    public TxDocTypePOLovDs(TxDocType e) {
        super(e);
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}