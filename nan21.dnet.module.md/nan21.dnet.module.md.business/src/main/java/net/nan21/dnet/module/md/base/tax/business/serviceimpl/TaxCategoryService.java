/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.base.tax.business.serviceimpl;

import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.md.base.tax.business.service.ITaxCategoryService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.md.base.tax.domain.entity.TaxCategory;

public class TaxCategoryService extends AbstractEntityService<TaxCategory>
        implements ITaxCategoryService {

    public TaxCategoryService() {
        super();
    }

    public TaxCategoryService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<TaxCategory> getEntityClass() {
        return TaxCategory.class;
    }

    public TaxCategory findByName(String name) {
        return (TaxCategory) this.em
                .createNamedQuery(TaxCategory.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

}
