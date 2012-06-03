/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.payroll.ds.param;

import net.nan21.dnet.core.presenter.model.EmptyParam;

public class PayrollElementValueDsParam extends EmptyParam {

    public static final String fELEMENTSETID = "elementSetId";
    public static final String fELEMENTSET = "elementSet";

    private Long elementSetId;
    private String elementSet;

    public Long getElementSetId() {
        return this.elementSetId;
    }

    public void setElementSetId(Long elementSetId) {
        this.elementSetId = elementSetId;
    }

    public String getElementSet() {
        return this.elementSet;
    }

    public void setElementSet(String elementSet) {
        this.elementSet = elementSet;
    }

}
