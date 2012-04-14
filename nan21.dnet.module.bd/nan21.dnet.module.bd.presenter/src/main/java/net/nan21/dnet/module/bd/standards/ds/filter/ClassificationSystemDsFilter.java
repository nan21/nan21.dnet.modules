/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.standards.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeDsFilter;

public class ClassificationSystemDsFilter extends AbstractTypeWithCodeDsFilter {

    private Boolean internal;

    private String tag;

    private String useInContext;

    public Boolean getInternal() {
        return this.internal;
    }

    public void setInternal(Boolean internal) {
        this.internal = internal;
    }

    public String getTag() {
        return this.tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getUseInContext() {
        return this.useInContext;
    }

    public void setUseInContext(String useInContext) {
        this.useInContext = useInContext;
    }

}
