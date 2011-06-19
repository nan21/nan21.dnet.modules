/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.report.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.ad.report.ds.model.ReportServerLovDs;
import net.nan21.dnet.module.ad.report.domain.entity.ReportServer;

public class ReportServerLovDsConv extends
        AbstractDsConverter<ReportServerLovDs, ReportServer> implements
        IDsConverter<ReportServerLovDs, ReportServer> {

    protected void modelToEntityAttributes(ReportServerLovDs ds, ReportServer e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(ReportServerLovDs ds, ReportServer e)
            throws Exception {
    }

    @Override
    public void entityToModel(ReportServer e, ReportServerLovDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
    }

}
