/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.workflow.ds.param;

import net.nan21.dnet.core.presenter.model.EmptyParam;

public class ActProcessInstanceHistoryDsParam extends EmptyParam {

    public static final String fPROCESSFULLNAME = "processFullName";

    private String processFullName;

    public String getProcessFullName() {
        return this.processFullName;
    }

    public void setProcessFullName(String processFullName) {
        this.processFullName = processFullName;
    }

}
