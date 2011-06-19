/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.report.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.ad.report.ds.model.ReportServerDs;
import net.nan21.dnet.module.ad.report.domain.entity.ReportServer;

public class ReportServerDsConv extends
        AbstractDsConverter<ReportServerDs, ReportServer> implements
        IDsConverter<ReportServerDs, ReportServer> {

    protected void modelToEntityAttributes(ReportServerDs ds, ReportServer e)
            throws Exception {
        e.setName(ds.getName());
        e.setActive(ds.getActive());
        e.setDescription(ds.getDescription());
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
        e.setUrl(ds.getUrl());
    }

    protected void modelToEntityReferences(ReportServerDs ds, ReportServer e)
            throws Exception {
    }

    @Override
    public void entityToModel(ReportServer e, ReportServerDs ds)
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
        ds.setUrl(e.getUrl());
    }

}
