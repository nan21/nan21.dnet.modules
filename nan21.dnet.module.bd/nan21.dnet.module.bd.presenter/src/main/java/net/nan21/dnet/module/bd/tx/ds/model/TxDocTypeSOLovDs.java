/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.tx.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;

import net.nan21.dnet.module.bd.tx.domain.entity.TxDocType;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = TxDocType.class, jpqlWhere = " e.active=true and e.category = 'sales-order' ", sort = { @SortField(field = TxDocTypeSOLovDs.fNAME) })
public class TxDocTypeSOLovDs extends AbstractTypeLov<TxDocType> {

    public static final String fCATEGORY = "category";

    @DsField()
    private String category;

    public TxDocTypeSOLovDs() {
        super();
    }

    public TxDocTypeSOLovDs(TxDocType e) {
        super(e);
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
