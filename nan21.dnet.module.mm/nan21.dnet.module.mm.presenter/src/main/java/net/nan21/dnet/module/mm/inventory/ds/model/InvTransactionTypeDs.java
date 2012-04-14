/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.mm.inventory.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;

import net.nan21.dnet.module.mm.inventory.domain.entity.InvTransactionType;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = InvTransactionType.class, sort = { @SortField(field = InvTransactionTypeDs.fNAME) })
public class InvTransactionTypeDs extends AbstractTypeDs<InvTransactionType> {

    public static final String fDOCTYPEID = "docTypeId";
    public static final String fDOCTYPE = "docType";
    public static final String fHASFROMINVENTORY = "hasFromInventory";
    public static final String fHASTOINVENTORY = "hasToInventory";

    @DsField(join = "left", path = "docType.id")
    private Long docTypeId;

    @DsField(join = "left", path = "docType.name")
    private String docType;

    @DsField()
    private Boolean hasFromInventory;

    @DsField()
    private Boolean hasToInventory;

    public InvTransactionTypeDs() {
        super();
    }

    public InvTransactionTypeDs(InvTransactionType e) {
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

    public Boolean getHasFromInventory() {
        return this.hasFromInventory;
    }

    public void setHasFromInventory(Boolean hasFromInventory) {
        this.hasFromInventory = hasFromInventory;
    }

    public Boolean getHasToInventory() {
        return this.hasToInventory;
    }

    public void setHasToInventory(Boolean hasToInventory) {
        this.hasToInventory = hasToInventory;
    }

}
