/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.mm.md.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.standards.domain.entity.ClassificationCode;
import net.nan21.dnet.module.bd.standards.domain.entity.ClassificationSystem;
import net.nan21.dnet.module.mm.md.business.service.IProdClassificationService;
import net.nan21.dnet.module.mm.md.domain.entity.Product;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.mm.md.domain.entity.ProdClassification;

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
                        "select e from ProdClassification e where e.product.id = :pProductId",
                        ProdClassification.class)
                .setParameter("pProductId", productId).getResultList();
    }

    public List<ProdClassification> findByClassSystem(
            ClassificationSystem classSystem) {
        return this.findByClassSystemId(classSystem.getId());
    }

    public List<ProdClassification> findByClassSystemId(Long classSystemId) {
        return (List<ProdClassification>) this.em
                .createQuery(
                        "select e from ProdClassification e where e.classSystem.id = :pClassSystemId",
                        ProdClassification.class)
                .setParameter("pClassSystemId", classSystemId).getResultList();
    }

    public List<ProdClassification> findByClassCode(ClassificationCode classCode) {
        return this.findByClassCodeId(classCode.getId());
    }

    public List<ProdClassification> findByClassCodeId(Long classCodeId) {
        return (List<ProdClassification>) this.em
                .createQuery(
                        "select e from ProdClassification e where e.classCode.id = :pClassCodeId",
                        ProdClassification.class)
                .setParameter("pClassCodeId", classCodeId).getResultList();
    }

}