/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.usr.ds.param;

import net.nan21.dnet.core.presenter.model.EmptyParam;

public class UserDsParam extends EmptyParam {

    public static final String fNEWPASSWORD = "newPassword";
    public static final String fCONFIRMPASSWORD = "confirmPassword";

    private String newPassword;
    private String confirmPassword;

    public String getNewPassword() {
        return this.newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmPassword() {
        return this.confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

}
