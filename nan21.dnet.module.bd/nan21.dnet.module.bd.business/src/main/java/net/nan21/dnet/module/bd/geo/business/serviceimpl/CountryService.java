/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.geo.business.serviceimpl;

import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.geo.business.service.ICountryService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.bd.geo.domain.entity.Country;

public class CountryService extends AbstractEntityService<Country> implements
        ICountryService {

    public CountryService() {
        super();
    }

    public CountryService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<Country> getEntityClass() {
        return Country.class;
    }

    public Country findByCode(String code) {
        return (Country) this.em.createNamedQuery(Country.NQ_FIND_BY_CODE)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pCode", code).getSingleResult();
    }

    public Country findByName(String name) {
        return (Country) this.em.createNamedQuery(Country.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

}
