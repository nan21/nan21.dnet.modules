/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.report.business.serviceimpl;

import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.ad.report.business.service.IReportServerService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.ad.report.domain.entity.ReportServer;

public class ReportServerService extends AbstractEntityService<ReportServer>
        implements IReportServerService {

    public ReportServerService() {
        super();
    }

    public ReportServerService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<ReportServer> getEntityClass() {
        return ReportServer.class;
    }

    public ReportServer findByName(String name) {
        return (ReportServer) this.em
                .createNamedQuery(ReportServer.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

}
