/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.pj.md.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableLov;
import net.nan21.dnet.module.pj.md.domain.entity.Issue;

@Ds(entity = Issue.class)
public class IssueLovDs extends AbstractAuditableLov<Issue> {

    public static final String fCODE = "code";
    public static final String fSUMMARY = "summary";

    @DsField()
    private String code;

    @DsField()
    private String summary;

    public IssueLovDs() {
        super();
    }

    public IssueLovDs(Issue e) {
        super(e);
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSummary() {
        return this.summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

}
