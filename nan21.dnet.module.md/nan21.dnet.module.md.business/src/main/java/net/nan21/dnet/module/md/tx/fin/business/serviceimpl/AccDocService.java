/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.tx.fin.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.bd.tx.domain.entity.TxDocType;
import net.nan21.dnet.module.md.tx.fin.business.service.IAccDocService;
import net.nan21.dnet.module.md.tx.fin.domain.entity.AccDocLine;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.md.tx.fin.domain.entity.AccDoc;

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

}
