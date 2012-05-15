/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.standards.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeLov;

import net.nan21.dnet.module.bd.standards.domain.entity.ClassificationItem;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = ClassificationItem.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = ClassificationItemLovDs.fCODE) })
public class ClassificationItemLovDs extends
        AbstractTypeWithCodeLov<ClassificationItem> {

    public static final String fCLASSSYSTEMID = "classSystemId";

    @DsField(join = "left", path = "classSystem.id")
    private Long classSystemId;

    public ClassificationItemLovDs() {
        super();
    }

    public ClassificationItemLovDs(ClassificationItem e) {
        super(e);
    }

    public Long getClassSystemId() {
        return this.classSystemId;
    }

    public void setClassSystemId(Long classSystemId) {
        this.classSystemId = classSystemId;
    }

}
