/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.impex.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.ad.impex.business.service.ICsvExportService;
import net.nan21.dnet.module.ad.impex.domain.entity.CsvExportField;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.ad.impex.domain.entity.CsvExport;

public class CsvExportService extends AbstractEntityService<CsvExport>
        implements ICsvExportService {

    public CsvExportService() {
        super();
    }

    public CsvExportService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<CsvExport> getEntityClass() {
        return CsvExport.class;
    }

    public CsvExport findByName(String name) {
        return (CsvExport) this.em.createNamedQuery(CsvExport.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

    public List<CsvExport> findByFields(CsvExportField fields) {
        return this.findByFieldsId(fields.getId());
    }

    public List<CsvExport> findByFieldsId(Long fieldsId) {
        return (List<CsvExport>) this.em
                .createQuery(
                        "select distinct e from CsvExport e , IN (e.fields) c where e.clientId = :pClientId and c.id = :pFieldsId",
                        CsvExport.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pFieldsId", fieldsId).getResultList();
    }

}
