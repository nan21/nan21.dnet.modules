/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.data.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;

import net.nan21.dnet.module.ad.data.domain.entity.AttachmentType;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = AttachmentType.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = AttachmentTypeLovDs.fNAME) })
public class AttachmentTypeLovDs extends AbstractTypeLov<AttachmentType> {

    public static final String fUSEINCONTEXT = "useInContext";

    @DsField(jpqlFilter = " :useInContext like e.useInContext ")
    private String useInContext;

    public AttachmentTypeLovDs() {
        super();
    }

    public AttachmentTypeLovDs(AttachmentType e) {
        super(e);
    }

    public String getUseInContext() {
        return this.useInContext;
    }

    public void setUseInContext(String useInContext) {
        this.useInContext = useInContext;
    }

}
