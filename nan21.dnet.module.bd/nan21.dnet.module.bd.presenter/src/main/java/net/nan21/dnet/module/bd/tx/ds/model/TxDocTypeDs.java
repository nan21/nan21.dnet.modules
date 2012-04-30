/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.tx.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;

import net.nan21.dnet.module.bd.tx.domain.entity.TxDocType;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = TxDocType.class, sort = { @SortField(field = TxDocTypeDs.fNAME) })
public class TxDocTypeDs extends AbstractTypeDs<TxDocType> {

    public static final String fCATEGORY = "category";

    @DsField()
    private String category;

    public TxDocTypeDs() {
        super();
    }

    public TxDocTypeDs(TxDocType e) {
        super(e);
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
