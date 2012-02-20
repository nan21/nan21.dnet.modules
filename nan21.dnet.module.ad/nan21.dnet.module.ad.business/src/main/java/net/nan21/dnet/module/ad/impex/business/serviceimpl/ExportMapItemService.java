/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.impex.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.ad.impex.business.service.IExportMapItemService;
import net.nan21.dnet.module.ad.impex.domain.entity.CsvExport;
import net.nan21.dnet.module.ad.impex.domain.entity.ExportMap;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.ad.impex.domain.entity.ExportMapItem;

public class ExportMapItemService extends AbstractEntityService<ExportMapItem>
        implements IExportMapItemService {

    public ExportMapItemService() {
        super();
    }

    public ExportMapItemService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<ExportMapItem> getEntityClass() {
        return ExportMapItem.class;
    }

    public List<ExportMapItem> findByExportMap(ExportMap exportMap) {
        return this.findByExportMapId(exportMap.getId());
    }

    public List<ExportMapItem> findByExportMapId(Long exportMapId) {
        return (List<ExportMapItem>) this.em
                .createQuery(
                        "select e from ExportMapItem e where e.clientId = :pClientId and e.exportMap.id = :pExportMapId",
                        ExportMapItem.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pExportMapId", exportMapId).getResultList();
    }

    public List<ExportMapItem> findByCsvExport(CsvExport csvExport) {
        return this.findByCsvExportId(csvExport.getId());
    }

    public List<ExportMapItem> findByCsvExportId(Long csvExportId) {
        return (List<ExportMapItem>) this.em
                .createQuery(
                        "select e from ExportMapItem e where e.clientId = :pClientId and e.csvExport.id = :pCsvExportId",
                        ExportMapItem.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pCsvExportId", csvExportId).getResultList();
    }

}
