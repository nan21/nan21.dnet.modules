/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.tx.acc.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.md.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.md.base.period.domain.entity.FiscalPeriod;
import net.nan21.dnet.module.md.tx.acc.business.service.IAccOperationService;
import net.nan21.dnet.module.md.tx.acc.domain.entity.AccDoc;
import net.nan21.dnet.module.md.tx.acc.domain.entity.AccDocLine;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.md.tx.acc.domain.entity.AccOperation;

public class AccOperationService extends AbstractEntityService<AccOperation>
        implements IAccOperationService {

    public AccOperationService() {
        super();
    }

    public AccOperationService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<AccOperation> getEntityClass() {
        return AccOperation.class;
    }

    public List<AccOperation> findByOrg(Organization org) {
        return this.findByOrgId(org.getId());
    }

    public List<AccOperation> findByOrgId(Long orgId) {
        return (List<AccOperation>) this.em
                .createQuery(
                        "select e from AccOperation e where e.clientId = :pClientId and e.org.id = :pOrgId",
                        AccOperation.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pOrgId", orgId).getResultList();
    }

    public List<AccOperation> findByAccSchema(AccSchema accSchema) {
        return this.findByAccSchemaId(accSchema.getId());
    }

    public List<AccOperation> findByAccSchemaId(Long accSchemaId) {
        return (List<AccOperation>) this.em
                .createQuery(
                        "select e from AccOperation e where e.clientId = :pClientId and e.accSchema.id = :pAccSchemaId",
                        AccOperation.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pAccSchemaId", accSchemaId).getResultList();
    }

    public List<AccOperation> findByPeriod(FiscalPeriod period) {
        return this.findByPeriodId(period.getId());
    }

    public List<AccOperation> findByPeriodId(Long periodId) {
        return (List<AccOperation>) this.em
                .createQuery(
                        "select e from AccOperation e where e.clientId = :pClientId and e.period.id = :pPeriodId",
                        AccOperation.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pPeriodId", periodId).getResultList();
    }

    public List<AccOperation> findByAccDoc(AccDoc accDoc) {
        return this.findByAccDocId(accDoc.getId());
    }

    public List<AccOperation> findByAccDocId(Long accDocId) {
        return (List<AccOperation>) this.em
                .createQuery(
                        "select e from AccOperation e where e.clientId = :pClientId and e.accDoc.id = :pAccDocId",
                        AccOperation.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pAccDocId", accDocId).getResultList();
    }

    public List<AccOperation> findByAccDocLine(AccDocLine accDocLine) {
        return this.findByAccDocLineId(accDocLine.getId());
    }

    public List<AccOperation> findByAccDocLineId(Long accDocLineId) {
        return (List<AccOperation>) this.em
                .createQuery(
                        "select e from AccOperation e where e.clientId = :pClientId and e.accDocLine.id = :pAccDocLineId",
                        AccOperation.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pAccDocLineId", accDocLineId).getResultList();
    }

}
