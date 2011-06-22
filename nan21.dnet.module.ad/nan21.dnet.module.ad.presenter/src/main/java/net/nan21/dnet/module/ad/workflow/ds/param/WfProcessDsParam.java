/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.workflow.ds.param;

import net.nan21.dnet.core.presenter.model.EmptyParam;

public class WfProcessDsParam extends EmptyParam {

    public static final String fDEPLOYMENT = "deployment";

    private String deployment;

    public String getDeployment() {
        return this.deployment;
    }

    public void setDeployment(String deployment) {
        this.deployment = deployment;
    }

}
