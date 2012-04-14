/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.acc.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeDsFilter;

public class AccountDsFilter extends AbstractTypeWithCodeDsFilter {

    private Long accSchemaId;

    private Long accSchemaId_From;
    private Long accSchemaId_To;

    private String accSchema;

    private Long accGroupId;

    private Long accGroupId_From;
    private Long accGroupId_To;

    private String accGroup;

    private String sign;

    private Boolean summary;

    public Long getAccSchemaId() {
        return this.accSchemaId;
    }

    public Long getAccSchemaId_From() {
        return this.accSchemaId_From;
    }

    public Long getAccSchemaId_To() {
        return this.accSchemaId_To;
    }

    public void setAccSchemaId(Long accSchemaId) {
        this.accSchemaId = accSchemaId;
    }

    public void setAccSchemaId_From(Long accSchemaId_From) {
        this.accSchemaId_From = accSchemaId_From;
    }

    public void setAccSchemaId_To(Long accSchemaId_To) {
        this.accSchemaId_To = accSchemaId_To;
    }

    public String getAccSchema() {
        return this.accSchema;
    }

    public void setAccSchema(String accSchema) {
        this.accSchema = accSchema;
    }

    public Long getAccGroupId() {
        return this.accGroupId;
    }

    public Long getAccGroupId_From() {
        return this.accGroupId_From;
    }

    public Long getAccGroupId_To() {
        return this.accGroupId_To;
    }

    public void setAccGroupId(Long accGroupId) {
        this.accGroupId = accGroupId;
    }

    public void setAccGroupId_From(Long accGroupId_From) {
        this.accGroupId_From = accGroupId_From;
    }

    public void setAccGroupId_To(Long accGroupId_To) {
        this.accGroupId_To = accGroupId_To;
    }

    public String getAccGroup() {
        return this.accGroup;
    }

    public void setAccGroup(String accGroup) {
        this.accGroup = accGroup;
    }

    public String getSign() {
        return this.sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public Boolean getSummary() {
        return this.summary;
    }

    public void setSummary(Boolean summary) {
        this.summary = summary;
    }

}
