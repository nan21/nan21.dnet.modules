/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.tx.inventory.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;

import net.nan21.dnet.module.md.tx.inventory.domain.entity.InvTransactionType;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = InvTransactionType.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = InvTransactionTypeLovDs.fNAME) })
public class InvTransactionTypeLovDs extends
        AbstractTypeLov<InvTransactionType> {

    public static final String fDOCTYPEID = "docTypeId";
    public static final String fDOCTYPE = "docType";

    @DsField(join = "left", path = "docType.id")
    private Long docTypeId;

    @DsField(join = "left", path = "docType.name")
    private String docType;

    public InvTransactionTypeLovDs() {
        super();
    }

    public InvTransactionTypeLovDs(InvTransactionType e) {
        super(e);
    }

    public Long getDocTypeId() {
        return this.docTypeId;
    }

    public void setDocTypeId(Long docTypeId) {
        this.docTypeId = docTypeId;
    }

    public String getDocType() {
        return this.docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

}
