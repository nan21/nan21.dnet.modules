/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.workflow.ds.filter;

import java.util.Date;
import net.nan21.dnet.core.presenter.model.base.AbstractBaseDsFilter;

public class ActDeploymentDsFilter extends AbstractBaseDsFilter {

    private String id;

    private String name;

    private Date deployTime;

    private Date deployTime_From;
    private Date deployTime_To;

    private String fullName;

    public String getId() {
        return this.id;
    }

    public void setId(Object id) {
        this.id = (String) id;

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

    public Date getDeployTime_From() {
        return this.deployTime_From;
    }

    public Date getDeployTime_To() {
        return this.deployTime_To;
    }

    public void setDeployTime(Date deployTime) {
        this.deployTime = deployTime;
    }

    public void setDeployTime_From(Date deployTime_From) {
        this.deployTime_From = deployTime_From;
    }

    public void setDeployTime_To(Date deployTime_To) {
        this.deployTime_To = deployTime_To;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

}
