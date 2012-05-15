/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.workflow.ds.param;

import java.util.Date;

import net.nan21.dnet.core.presenter.model.EmptyParam;

public class ActProcessInstanceDsParam extends EmptyParam {

    public static final String fPROCESSFULLNAME = "processFullName";
    public static final String fREASONTOKILL = "reasonToKill";
    public static final String fFROM = "from";
    public static final String fTO = "to";

    private String processFullName;
    private String reasonToKill;
    private Date from;
    private Date to;

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

    public Date getFrom() {
        return this.from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return this.to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

}
