/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.pj.base.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.pj.base.ds.model.IssueTaskTypeDs;
import net.nan21.dnet.module.pj.base.domain.entity.IssueTaskType;

public class IssueTaskTypeDsConv extends
        AbstractDsConverter<IssueTaskTypeDs, IssueTaskType> implements
        IDsConverter<IssueTaskTypeDs, IssueTaskType> {

    protected void modelToEntityAttributes(IssueTaskTypeDs ds, IssueTaskType e)
            throws Exception {
        e.setName(ds.getName());
        e.setActive(ds.getActive());
        e.setDescription(ds.getDescription());
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
    }

    protected void modelToEntityReferences(IssueTaskTypeDs ds, IssueTaskType e)
            throws Exception {
    }

    @Override
    public void entityToModel(IssueTaskType e, IssueTaskTypeDs ds)
            throws Exception {
        ds.setName(e.getName());
        ds.setActive(e.getActive());
        ds.setDescription(e.getDescription());
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
    }

}
