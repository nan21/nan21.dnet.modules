/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.impex.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.ad.impex.business.service.ICsvExportSortService;
import net.nan21.dnet.module.ad.impex.domain.entity.CsvExport;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.ad.impex.domain.entity.CsvExportSort;

public class CsvExportSortService extends AbstractEntityService<CsvExportSort>
        implements ICsvExportSortService {

    public CsvExportSortService() {
        super();
    }

    public CsvExportSortService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<CsvExportSort> getEntityClass() {
        return CsvExportSort.class;
    }

    public List<CsvExportSort> findByCsvExport(CsvExport csvExport) {
        return this.findByCsvExportId(csvExport.getId());
    }

    public List<CsvExportSort> findByCsvExportId(Long csvExportId) {
        return (List<CsvExportSort>) this.em
                .createQuery(
                        "select e from CsvExportSort e where e.clientId = :pClientId and e.csvExport.id = :pCsvExportId",
                        CsvExportSort.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pCsvExportId", csvExportId).getResultList();
    }

}
