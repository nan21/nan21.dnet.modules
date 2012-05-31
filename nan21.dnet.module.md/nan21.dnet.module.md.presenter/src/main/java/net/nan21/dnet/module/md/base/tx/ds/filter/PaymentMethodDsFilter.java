/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.base.tx.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractTypeDsFilter;

public class PaymentMethodDsFilter extends AbstractTypeDsFilter {

    private String type;

    private Long docTypeId;

    private Long docTypeId_From;
    private Long docTypeId_To;

    private String docType;

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getDocTypeId() {
        return this.docTypeId;
    }

    public Long getDocTypeId_From() {
        return this.docTypeId_From;
    }

    public Long getDocTypeId_To() {
        return this.docTypeId_To;
    }

    public void setDocTypeId(Long docTypeId) {
        this.docTypeId = docTypeId;
    }

    public void setDocTypeId_From(Long docTypeId_From) {
        this.docTypeId_From = docTypeId_From;
    }

    public void setDocTypeId_To(Long docTypeId_To) {
        this.docTypeId_To = docTypeId_To;
    }

    public String getDocType() {
        return this.docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

}
