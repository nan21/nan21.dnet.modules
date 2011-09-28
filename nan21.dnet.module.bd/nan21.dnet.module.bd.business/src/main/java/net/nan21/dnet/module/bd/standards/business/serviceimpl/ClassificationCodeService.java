/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.standards.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.standards.business.service.IClassificationCodeService;
import net.nan21.dnet.module.bd.standards.domain.entity.ClassificationSystem;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.bd.standards.domain.entity.ClassificationCode;

public class ClassificationCodeService extends
        AbstractEntityService<ClassificationCode> implements
        IClassificationCodeService {

    public ClassificationCodeService() {
        super();
    }

    public ClassificationCodeService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<ClassificationCode> getEntityClass() {
        return ClassificationCode.class;
    }

    public ClassificationCode findBySyscode(Long clientId,
            ClassificationSystem classSystem, String code) {
        return (ClassificationCode) this.em
                .createNamedQuery(ClassificationCode.NQ_FIND_BY_SYSCODE)
                .setParameter("pClientId", clientId)
                .setParameter("pClassSystem", classSystem)
                .setParameter("pCode", code).getSingleResult();
    }

    public ClassificationCode findBySyscode(Long clientId, Long classSystemId,
            String code) {
        return (ClassificationCode) this.em
                .createNamedQuery(
                        ClassificationCode.NQ_FIND_BY_SYSCODE_PRIMITIVE)
                .setParameter("pClientId", clientId)
                .setParameter("pClassSystemId", classSystemId)
                .setParameter("pCode", code).getSingleResult();
    }

    public ClassificationCode findBySysname(Long clientId,
            ClassificationSystem classSystem, String name) {
        return (ClassificationCode) this.em
                .createNamedQuery(ClassificationCode.NQ_FIND_BY_SYSNAME)
                .setParameter("pClientId", clientId)
                .setParameter("pClassSystem", classSystem)
                .setParameter("pName", name).getSingleResult();
    }

    public ClassificationCode findBySysname(Long clientId, Long classSystemId,
            String name) {
        return (ClassificationCode) this.em
                .createNamedQuery(
                        ClassificationCode.NQ_FIND_BY_SYSNAME_PRIMITIVE)
                .setParameter("pClientId", clientId)
                .setParameter("pClassSystemId", classSystemId)
                .setParameter("pName", name).getSingleResult();
    }

    public List<ClassificationCode> findByClassSystem(
            ClassificationSystem classSystem) {
        return this.findByClassSystemId(classSystem.getId());
    }

    public List<ClassificationCode> findByClassSystemId(Long classSystemId) {
        return (List<ClassificationCode>) this.em
                .createQuery(
                        "select e from ClassificationCode e where e.classSystem.id = :pClassSystemId",
                        ClassificationCode.class)
                .setParameter("pClassSystemId", classSystemId).getResultList();
    }

}
