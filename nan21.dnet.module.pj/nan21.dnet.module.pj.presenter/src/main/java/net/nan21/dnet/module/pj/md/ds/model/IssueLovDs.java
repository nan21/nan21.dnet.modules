/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.pj.md.ds.model;

import net.nan21.dnet.core.api.model.IModelWithClientId;
import net.nan21.dnet.core.api.model.IModelWithId;
import net.nan21.dnet.core.presenter.model.AbstractDsModel;

import net.nan21.dnet.module.pj.md.domain.entity.Issue;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = Issue.class)
public class IssueLovDs extends AbstractDsModel<Issue> implements IModelWithId,
        IModelWithClientId {

    public static final String fID = "id";
    public static final String fCLIENTID = "clientId";
    public static final String fCODE = "code";
    public static final String fSUMMARY = "summary";

    @DsField()
    private Long id;

    @DsField()
    private Long clientId;

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

    public Long getId() {
        return this.id;
    }

    public void setId(Object id) {
        this.id = this._asLong_(id);

    }

    public Long getClientId() {
        return this.clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
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
