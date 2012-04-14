/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.fin.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractTypeLovFilter;

public class FinDocTypePOLovDsFilter extends AbstractTypeLovFilter {

    private String category;

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
