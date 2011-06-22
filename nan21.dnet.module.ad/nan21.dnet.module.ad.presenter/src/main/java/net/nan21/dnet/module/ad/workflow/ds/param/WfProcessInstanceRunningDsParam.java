/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.workflow.ds.param;

import net.nan21.dnet.core.presenter.model.EmptyParam;

public class WfProcessInstanceRunningDsParam extends EmptyParam {

    public static final String fPROCESSFULLNAME = "processFullName";
    public static final String fREASONTOKILL = "reasonToKill";

    private String processFullName;
    private String reasonToKill;

    public String getProcessFullName() {
        return this.processFullName;
    }

    public void setProcessFullName(String processFullName) {
        this.processFullName = processFullName;
    }

    public String getReasonToKill() {
        return this.reasonToKill;
    }

    public void setReasonToKill(String reasonToKill) {
        this.reasonToKill = reasonToKill;
    }

}
