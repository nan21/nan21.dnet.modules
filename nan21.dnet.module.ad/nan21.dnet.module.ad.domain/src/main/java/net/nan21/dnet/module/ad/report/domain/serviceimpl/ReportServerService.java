/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.report.domain.serviceimpl;

import net.nan21.dnet.core.domain.service.AbstractEntityService;
import net.nan21.dnet.module.ad.report.domain.service.IReportServerService;

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

    public ReportServer findByName(Long clientId, String name) {
        return (ReportServer) this.em
                .createNamedQuery(ReportServer.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

}
