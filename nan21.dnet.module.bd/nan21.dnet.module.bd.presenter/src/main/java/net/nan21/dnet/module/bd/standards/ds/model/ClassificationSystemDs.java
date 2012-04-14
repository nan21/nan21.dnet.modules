/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.standards.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeDs;

import net.nan21.dnet.module.bd.standards.domain.entity.ClassificationSystem;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = ClassificationSystem.class, sort = { @SortField(field = ClassificationSystemDs.fNAME) })
public class ClassificationSystemDs extends
        AbstractTypeWithCodeDs<ClassificationSystem> {

    public static final String fINTERNAL = "internal";
    public static final String fTAG = "tag";
    public static final String fUSEINCONTEXT = "useInContext";

    @DsField()
    private Boolean internal;

    @DsField()
    private String tag;

    @DsField()
    private String useInContext;

    public ClassificationSystemDs() {
        super();
    }

    public ClassificationSystemDs(ClassificationSystem e) {
        super(e);
    }

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
