/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.workflow.ds.model;

import java.util.Date;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractBaseDs;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActDeployment;

@Ds(entity = ActDeployment.class, sort = { @SortField(field = ActDeploymentDs.fDEPLOYTIME, desc = true) })
public class ActDeploymentDs extends AbstractBaseDs<ActDeployment> {

    public static final String fID = "id";
    public static final String fCLIENTID = "clientId";
    public static final String fNAME = "name";
    public static final String fDEPLOYTIME = "deployTime";
    public static final String fFULLNAME = "fullName";

    @DsField()
    private String id;

    @DsField()
    private Long clientId;

    @DsField()
    private String name;

    @DsField()
    private Date deployTime;

    @DsField(fetch = false)
    private String fullName;

    public ActDeploymentDs() {
        super();
    }

    public ActDeploymentDs(ActDeployment e) {
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

    public Date getDeployTime() {
        return this.deployTime;
    }

    public void setDeployTime(Date deployTime) {
        this.deployTime = deployTime;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

}
