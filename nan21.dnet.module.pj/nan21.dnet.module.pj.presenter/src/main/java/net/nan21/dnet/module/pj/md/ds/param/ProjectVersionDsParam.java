/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.pj.md.ds.param;

import net.nan21.dnet.core.presenter.model.EmptyParam;

public class ProjectVersionDsParam extends EmptyParam {

    public static final String fHIDERELEASED = "hideReleased";
    public static final String fHIDEDUE = "hideDue";

    private Boolean hideReleased;
    private Boolean hideDue;

    public Boolean getHideReleased() {
        return this.hideReleased;
    }

    public void setHideReleased(Boolean hideReleased) {
        this.hideReleased = hideReleased;
    }

    public Boolean getHideDue() {
        return this.hideDue;
    }

    public void setHideDue(Boolean hideDue) {
        this.hideDue = hideDue;
    }

}
