/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.benefit.business.serviceimpl;

import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.hr.benefit.business.service.IOptionService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.hr.benefit.domain.entity.Option;

public class OptionService extends AbstractEntityService<Option> implements
        IOptionService {

    public OptionService() {
        super();
    }

    public OptionService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<Option> getEntityClass() {
        return Option.class;
    }

    public Option findByName(String name) {
        return (Option) this.em.createNamedQuery(Option.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

}
