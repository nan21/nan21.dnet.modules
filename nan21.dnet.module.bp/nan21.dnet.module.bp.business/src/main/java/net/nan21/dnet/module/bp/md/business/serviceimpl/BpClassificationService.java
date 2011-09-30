/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bp.md.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.standards.domain.entity.ClassificationCode;
import net.nan21.dnet.module.bd.standards.domain.entity.ClassificationSystem;
import net.nan21.dnet.module.bp.md.business.service.IBpClassificationService;
import net.nan21.dnet.module.bp.md.domain.entity.BusinessPartner;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.bp.md.domain.entity.BpClassification;

public class BpClassificationService extends
        AbstractEntityService<BpClassification> implements
        IBpClassificationService {

    public BpClassificationService() {
        super();
    }

    public BpClassificationService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<BpClassification> getEntityClass() {
        return BpClassification.class;
    }

    public List<BpClassification> findByBp(BusinessPartner bp) {
        return this.findByBpId(bp.getId());
    }

    public List<BpClassification> findByBpId(Long bpId) {
        return (List<BpClassification>) this.em
                .createQuery(
                        "select e from BpClassification e where e.bp.id = :pBpId",
                        BpClassification.class).setParameter("pBpId", bpId)
                .getResultList();
    }

    public List<BpClassification> findByClassSystem(
            ClassificationSystem classSystem) {
        return this.findByClassSystemId(classSystem.getId());
    }

    public List<BpClassification> findByClassSystemId(Long classSystemId) {
        return (List<BpClassification>) this.em
                .createQuery(
                        "select e from BpClassification e where e.classSystem.id = :pClassSystemId",
                        BpClassification.class)
                .setParameter("pClassSystemId", classSystemId).getResultList();
    }

    public List<BpClassification> findByClassCode(ClassificationCode classCode) {
        return this.findByClassCodeId(classCode.getId());
    }

    public List<BpClassification> findByClassCodeId(Long classCodeId) {
        return (List<BpClassification>) this.em
                .createQuery(
                        "select e from BpClassification e where e.classCode.id = :pClassCodeId",
                        BpClassification.class)
                .setParameter("pClassCodeId", classCodeId).getResultList();
    }

}