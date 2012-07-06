/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.impex.ds.param;

import net.nan21.dnet.core.presenter.model.EmptyParam;

public class CsvExportDsParam extends EmptyParam {

    public static final String fCLONENAME = "cloneName";

    private String cloneName;

    public String getCloneName() {
        return this.cloneName;
    }

    public void setCloneName(String cloneName) {
        this.cloneName = cloneName;
    }

}
