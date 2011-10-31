/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.pj.md.ds.param;

import net.nan21.dnet.core.presenter.model.EmptyParam;

public class ItemLinkDsParam extends EmptyParam {

    public static final String fITEMID = "itemId";

    private Long itemId;

    public Long getItemId() {
        return this.itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

}
