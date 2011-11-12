/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.pj.base.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.pj.base.ds.model.IssueSeverityLovDs;
import net.nan21.dnet.module.pj.base.domain.entity.IssueSeverity;

public class IssueSeverityLovDsConv extends
        AbstractDsConverter<IssueSeverityLovDs, IssueSeverity> implements
        IDsConverter<IssueSeverityLovDs, IssueSeverity> {

    protected void modelToEntityAttributes(IssueSeverityLovDs ds,
            IssueSeverity e) throws Exception {
        e.setClientId(ds.getClientId());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
        e.setSequenceNo(ds.getSequenceNo());
    }

    protected void modelToEntityReferences(IssueSeverityLovDs ds,
            IssueSeverity e) throws Exception {
    }

    @Override
    public void entityToModel(IssueSeverity e, IssueSeverityLovDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
        ds.setSequenceNo(e.getSequenceNo());
    }

}
