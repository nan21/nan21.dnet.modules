/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.report.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;

import net.nan21.dnet.module.ad.report.domain.entity.ReportServer;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = ReportServer.class, sort = { @SortField(field = ReportServerDs.fNAME) })
public class ReportServerDs extends AbstractTypeDs<ReportServer> {

    public static final String fURL = "url";

    @DsField()
    private String url;

    public ReportServerDs() {
        super();
    }

    public ReportServerDs(ReportServer e) {
        super(e);
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
