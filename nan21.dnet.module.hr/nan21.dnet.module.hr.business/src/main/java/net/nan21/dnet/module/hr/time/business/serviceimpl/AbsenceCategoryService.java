/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.time.business.serviceimpl;

import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.hr.time.business.service.IAbsenceCategoryService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.hr.time.domain.entity.AbsenceCategory;

public class AbsenceCategoryService extends
        AbstractEntityService<AbsenceCategory> implements
        IAbsenceCategoryService {

    public AbsenceCategoryService() {
        super();
    }

    public AbsenceCategoryService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<AbsenceCategory> getEntityClass() {
        return AbsenceCategory.class;
    }

    public AbsenceCategory findByName(String name) {
        return (AbsenceCategory) this.em
                .createNamedQuery(AbsenceCategory.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

}
