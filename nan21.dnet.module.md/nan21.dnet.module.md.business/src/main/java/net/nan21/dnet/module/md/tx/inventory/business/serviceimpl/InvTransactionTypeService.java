/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.tx.inventory.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.tx.domain.entity.TxDocType;
import net.nan21.dnet.module.md.tx.inventory.business.service.IInvTransactionTypeService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.md.tx.inventory.domain.entity.InvTransactionType;

public class InvTransactionTypeService extends
        AbstractEntityService<InvTransactionType> implements
        IInvTransactionTypeService {

    public InvTransactionTypeService() {
        super();
    }

    public InvTransactionTypeService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<InvTransactionType> getEntityClass() {
        return InvTransactionType.class;
    }

    public InvTransactionType findByName(String name) {
        return (InvTransactionType) this.em
                .createNamedQuery(InvTransactionType.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

    public List<InvTransactionType> findByDocType(TxDocType docType) {
        return this.findByDocTypeId(docType.getId());
    }

    public List<InvTransactionType> findByDocTypeId(Long docTypeId) {
        return (List<InvTransactionType>) this.em
                .createQuery(
                        "select e from InvTransactionType e where e.clientId = :pClientId and e.docType.id = :pDocTypeId",
                        InvTransactionType.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pDocTypeId", docTypeId).getResultList();
    }

}
