/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.org.ds.model;

import java.util.Date;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;
import net.nan21.dnet.module.bd.org.domain.entity.OrganizationHierarchy;

@Ds(entity = OrganizationHierarchy.class, sort = { @SortField(field = OrganizationHierarchyDs.fNAME) })
public class OrganizationHierarchyDs extends
        AbstractTypeDs<OrganizationHierarchy> {

    public static final String fSTARTDATE = "startDate";
    public static final String fENDDATE = "endDate";

    @DsField()
    private Date startDate;

    @DsField()
    private Date endDate;

    public OrganizationHierarchyDs() {
        super();
    }

    public OrganizationHierarchyDs(OrganizationHierarchy e) {
        super(e);
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

}
