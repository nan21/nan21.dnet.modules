/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.pj.base.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.pj.base.ds.model.IssueTaskStatusLovDs;
import net.nan21.dnet.module.pj.base.domain.entity.IssueTaskStatus;

public class IssueTaskStatusLovDsConv extends
        AbstractDsConverter<IssueTaskStatusLovDs, IssueTaskStatus> implements
        IDsConverter<IssueTaskStatusLovDs, IssueTaskStatus> {

    protected void modelToEntityAttributes(IssueTaskStatusLovDs ds,
            IssueTaskStatus e) throws Exception {
        e.setClientId(ds.getClientId());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(IssueTaskStatusLovDs ds,
            IssueTaskStatus e) throws Exception {
    }

    @Override
    public void entityToModel(IssueTaskStatus e, IssueTaskStatusLovDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
    }

}
