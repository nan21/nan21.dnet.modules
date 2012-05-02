/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.mm.prod.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.standards.domain.entity.ClassificationItem;
import net.nan21.dnet.module.bd.standards.domain.entity.ClassificationSystem;
import net.nan21.dnet.module.md.mm.prod.business.service.IProdClassificationService;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProdClassification;

public class ProdClassificationService extends
        AbstractEntityService<ProdClassification> implements
        IProdClassificationService {

    public ProdClassificationService() {
        super();
    }

    public ProdClassificationService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<ProdClassification> getEntityClass() {
        return ProdClassification.class;
    }

    public List<ProdClassification> findByProduct(Product product) {
        return this.findByProductId(product.getId());
    }

    public List<ProdClassification> findByProductId(Long productId) {
        return (List<ProdClassification>) this.em
                .createQuery(
                        "select e from ProdClassification e where e.clientId = :pClientId and e.product.id = :pProductId",
                        ProdClassification.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pProductId", productId).getResultList();
    }

    public List<ProdClassification> findByClassSystem(
            ClassificationSystem classSystem) {
        return this.findByClassSystemId(classSystem.getId());
    }

    public List<ProdClassification> findByClassSystemId(Long classSystemId) {
        return (List<ProdClassification>) this.em
                .createQuery(
                        "select e from ProdClassification e where e.clientId = :pClientId and e.classSystem.id = :pClassSystemId",
                        ProdClassification.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pClassSystemId", classSystemId).getResultList();
    }

    public List<ProdClassification> findByClassCode(ClassificationItem classCode) {
        return this.findByClassCodeId(classCode.getId());
    }

    public List<ProdClassification> findByClassCodeId(Long classCodeId) {
        return (List<ProdClassification>) this.em
                .createQuery(
                        "select e from ProdClassification e where e.clientId = :pClientId and e.classCode.id = :pClassCodeId",
                        ProdClassification.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pClassCodeId", classCodeId).getResultList();
    }

}
