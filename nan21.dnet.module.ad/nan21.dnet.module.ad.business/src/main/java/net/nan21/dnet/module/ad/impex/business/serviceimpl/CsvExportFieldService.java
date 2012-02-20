/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.impex.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.ad.impex.business.service.ICsvExportFieldService;
import net.nan21.dnet.module.ad.impex.domain.entity.CsvExport;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.ad.impex.domain.entity.CsvExportField;

public class CsvExportFieldService extends
        AbstractEntityService<CsvExportField> implements ICsvExportFieldService {

    public CsvExportFieldService() {
        super();
    }

    public CsvExportFieldService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<CsvExportField> getEntityClass() {
        return CsvExportField.class;
    }

    public List<CsvExportField> findByCsvExport(CsvExport csvExport) {
        return this.findByCsvExportId(csvExport.getId());
    }

    public List<CsvExportField> findByCsvExportId(Long csvExportId) {
        return (List<CsvExportField>) this.em
                .createQuery(
                        "select e from CsvExportField e where e.clientId = :pClientId and  e.csvExport.id = :pCsvExportId",
                        CsvExportField.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pCsvExportId", csvExportId).getResultList();
    }

}
