/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.time.ds.param;

import java.util.Date;

import net.nan21.dnet.core.presenter.model.EmptyParam;

public class AbsenceDsParam extends EmptyParam {

    public static final String fFROM = "from";
    public static final String fTO = "to";

    private Date from;
    private Date to;

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
