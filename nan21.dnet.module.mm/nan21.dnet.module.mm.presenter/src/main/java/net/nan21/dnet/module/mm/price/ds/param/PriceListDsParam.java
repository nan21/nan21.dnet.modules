/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.mm.price.ds.param;

import java.util.Date;

import net.nan21.dnet.core.presenter.model.EmptyParam;

public class PriceListDsParam extends EmptyParam {

    public static final String fVALIDAT = "validAt";

    private Date validAt;

    public Date getValidAt() {
        return this.validAt;
    }

    public void setValidAt(Date validAt) {
        this.validAt = validAt;
    }

}
