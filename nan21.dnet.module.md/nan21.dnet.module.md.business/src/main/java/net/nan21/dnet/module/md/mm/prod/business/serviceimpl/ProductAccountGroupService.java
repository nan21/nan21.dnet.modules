/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.mm.prod.business.serviceimpl;

import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.md.mm.prod.business.service.IProductAccountGroupService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAccountGroup;

public class ProductAccountGroupService extends
        AbstractEntityService<ProductAccountGroup> implements
        IProductAccountGroupService {

    public ProductAccountGroupService() {
        super();
    }

    public ProductAccountGroupService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<ProductAccountGroup> getEntityClass() {
        return ProductAccountGroup.class;
    }

    public ProductAccountGroup findByCode(String code) {
        return (ProductAccountGroup) this.em
                .createNamedQuery(ProductAccountGroup.NQ_FIND_BY_CODE)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pCode", code).getSingleResult();
    }

    public ProductAccountGroup findByName(String name) {
        return (ProductAccountGroup) this.em
                .createNamedQuery(ProductAccountGroup.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

}
