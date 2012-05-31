/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.tx.acc.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.md.acc.domain.entity.AccJournal;
import net.nan21.dnet.module.md.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.md.base.period.domain.entity.FiscalPeriod;
import net.nan21.dnet.module.md.base.tx.domain.entity.TxDocType;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;
import net.nan21.dnet.module.md.tx.acc.business.service.IAccDocService;
import net.nan21.dnet.module.md.tx.acc.domain.entity.AccDocLine;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.md.tx.acc.domain.entity.AccDoc;
import net.nan21.dnet.module.md._businessdelegates.tx.fin.AccDocToAccOperationBD;

public class AccDocService extends AbstractEntityService<AccDoc> implements
        IAccDocService {

    public AccDocService() {
        super();
    }

    public AccDocService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<AccDoc> getEntityClass() {
        return AccDoc.class;
    }

    public List<AccDoc> findByOrg(Organization org) {
        return this.findByOrgId(org.getId());
    }

    public List<AccDoc> findByOrgId(Long orgId) {
        return (List<AccDoc>) this.em
                .createQuery(
                        "select e from AccDoc e where e.clientId = :pClientId and e.org.id = :pOrgId",
                        AccDoc.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pOrgId", orgId).getResultList();
    }

    public List<AccDoc> findByAccSchema(AccSchema accSchema) {
        return this.findByAccSchemaId(accSchema.getId());
    }

    public List<AccDoc> findByAccSchemaId(Long accSchemaId) {
        return (List<AccDoc>) this.em
                .createQuery(
                        "select e from AccDoc e where e.clientId = :pClientId and e.accSchema.id = :pAccSchemaId",
                        AccDoc.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pAccSchemaId", accSchemaId).getResultList();
    }

    public List<AccDoc> findByPeriod(FiscalPeriod period) {
        return this.findByPeriodId(period.getId());
    }

    public List<AccDoc> findByPeriodId(Long periodId) {
        return (List<AccDoc>) this.em
                .createQuery(
                        "select e from AccDoc e where e.clientId = :pClientId and e.period.id = :pPeriodId",
                        AccDoc.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pPeriodId", periodId).getResultList();
    }

    public List<AccDoc> findByJournal(AccJournal journal) {
        return this.findByJournalId(journal.getId());
    }

    public List<AccDoc> findByJournalId(Long journalId) {
        return (List<AccDoc>) this.em
                .createQuery(
                        "select e from AccDoc e where e.clientId = :pClientId and e.journal.id = :pJournalId",
                        AccDoc.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pJournalId", journalId).getResultList();
    }

    public List<AccDoc> findByBpartner(BusinessPartner bpartner) {
        return this.findByBpartnerId(bpartner.getId());
    }

    public List<AccDoc> findByBpartnerId(Long bpartnerId) {
        return (List<AccDoc>) this.em
                .createQuery(
                        "select e from AccDoc e where e.clientId = :pClientId and e.bpartner.id = :pBpartnerId",
                        AccDoc.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pBpartnerId", bpartnerId).getResultList();
    }

    public List<AccDoc> findByDocCurrency(Currency docCurrency) {
        return this.findByDocCurrencyId(docCurrency.getId());
    }

    public List<AccDoc> findByDocCurrencyId(Long docCurrencyId) {
        return (List<AccDoc>) this.em
                .createQuery(
                        "select e from AccDoc e where e.clientId = :pClientId and e.docCurrency.id = :pDocCurrencyId",
                        AccDoc.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pDocCurrencyId", docCurrencyId).getResultList();
    }

    public List<AccDoc> findByDocType(TxDocType docType) {
        return this.findByDocTypeId(docType.getId());
    }

    public List<AccDoc> findByDocTypeId(Long docTypeId) {
        return (List<AccDoc>) this.em
                .createQuery(
                        "select e from AccDoc e where e.clientId = :pClientId and e.docType.id = :pDocTypeId",
                        AccDoc.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pDocTypeId", docTypeId).getResultList();
    }

    public List<AccDoc> findByLines(AccDocLine lines) {
        return this.findByLinesId(lines.getId());
    }

    public List<AccDoc> findByLinesId(Long linesId) {
        return (List<AccDoc>) this.em
                .createQuery(
                        "select distinct e from AccDoc e , IN (e.lines) c where e.clientId = :pClientId and c.id = :pLinesId",
                        AccDoc.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pLinesId", linesId).getResultList();
    }

    public void doPost(AccDoc doc) throws Exception {
        this.getBusinessDelegate(AccDocToAccOperationBD.class).post(doc);
    }

    public void doUnPost(AccDoc doc) throws Exception {
        this.getBusinessDelegate(AccDocToAccOperationBD.class).unPost(doc);
    }

}
