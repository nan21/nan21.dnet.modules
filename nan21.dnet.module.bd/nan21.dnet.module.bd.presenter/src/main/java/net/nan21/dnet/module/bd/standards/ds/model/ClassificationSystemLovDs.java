/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.standards.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeLov;

import net.nan21.dnet.module.bd.standards.domain.entity.ClassificationSystem;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = ClassificationSystem.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = ClassificationSystemLovDs.fCODE) })
public class ClassificationSystemLovDs extends
        AbstractTypeWithCodeLov<ClassificationSystem> {

    public static final String fUSEINCONTEXT = "useInContext";

    @DsField(jpqlFilter = " :useInContext like e.useInContext ")
    private String useInContext;

    public ClassificationSystemLovDs() {
        super();
    }

    public ClassificationSystemLovDs(ClassificationSystem e) {
        super(e);
    }

    public String getUseInContext() {
        return this.useInContext;
    }

    public void setUseInContext(String useInContext) {
        this.useInContext = useInContext;
    }

}
