/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.workflow.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractBaseDs;

import net.nan21.dnet.module.ad.workflow.domain.entity.ActProcessDefinition;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = ActProcessDefinition.class, sort = { @SortField(field = ActProcessDefinitionLovDs.fNAME) })
public class ActProcessDefinitionLovDs extends
        AbstractBaseDs<ActProcessDefinition> {

    public static final String fID = "id";
    public static final String fCLIENTID = "clientId";
    public static final String fNAME = "name";
    public static final String fFULLNAME = "fullName";

    @DsField()
    private String id;

    @DsField()
    private Long clientId;

    @DsField()
    private String name;

    @DsField(fetch = false, jpqlFilter = " e.name like :fullName ")
    private String fullName;

    public ActProcessDefinitionLovDs() {
        super();
    }

    public ActProcessDefinitionLovDs(ActProcessDefinition e) {
        super(e);
    }

    public String getId() {
        return this.id;
    }

    public void setId(Object id) {
        this.id = (String) id;

    }

    public Long getClientId() {
        return this.clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

}
