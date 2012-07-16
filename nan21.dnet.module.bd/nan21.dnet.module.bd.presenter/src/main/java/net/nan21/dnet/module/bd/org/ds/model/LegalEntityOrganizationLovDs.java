/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.org.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeLov;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;

@Ds(entity = Organization.class, jpqlWhere = " e.type.legalEntity = true ", sort = { @SortField(field = LegalEntityOrganizationLovDs.fCODE) })
public class LegalEntityOrganizationLovDs extends
        AbstractTypeWithCodeLov<Organization> {

    public static final String fLEGALENTITY = "legalEntity";

    @DsField(join = "left", path = "type.legalEntity")
    private Boolean legalEntity;

    public LegalEntityOrganizationLovDs() {
        super();
    }

    public LegalEntityOrganizationLovDs(Organization e) {
        super(e);
    }

    public Boolean getLegalEntity() {
        return this.legalEntity;
    }

    public void setLegalEntity(Boolean legalEntity) {
        this.legalEntity = legalEntity;
    }

}
