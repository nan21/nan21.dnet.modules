/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.mm.md.business.serviceimpl;

import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.mm.md.business.service.IProductManufacturerService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.mm.md.domain.entity.ProductManufacturer;

public class ProductManufacturerService extends
        AbstractEntityService<ProductManufacturer> implements
        IProductManufacturerService {

    public ProductManufacturerService() {
        super();
    }

    public ProductManufacturerService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<ProductManufacturer> getEntityClass() {
        return ProductManufacturer.class;
    }

    public ProductManufacturer findByCode(Long clientId, String code) {
        return (ProductManufacturer) this.em
                .createNamedQuery(ProductManufacturer.NQ_FIND_BY_CODE)
                .setParameter("pClientId", clientId)
                .setParameter("pCode", code).getSingleResult();
    }

    public ProductManufacturer findByName(Long clientId, String name) {
        return (ProductManufacturer) this.em
                .createNamedQuery(ProductManufacturer.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

}
