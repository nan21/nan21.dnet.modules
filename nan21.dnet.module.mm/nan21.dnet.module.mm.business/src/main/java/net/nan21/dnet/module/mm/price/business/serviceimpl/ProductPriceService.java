/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.mm.price.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.mm.md.domain.entity.Product;
import net.nan21.dnet.module.mm.price.business.service.IProductPriceService;
import net.nan21.dnet.module.mm.price.domain.entity.PriceList;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.mm.price.domain.entity.ProductPrice;

public class ProductPriceService extends AbstractEntityService<ProductPrice>
        implements IProductPriceService {

    public ProductPriceService() {
        super();
    }

    public ProductPriceService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<ProductPrice> getEntityClass() {
        return ProductPrice.class;
    }

    public ProductPrice findByName(Long clientId, PriceList priceList,
            Product product) {
        return (ProductPrice) this.em
                .createNamedQuery(ProductPrice.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pPriceList", priceList)
                .setParameter("pProduct", product).getSingleResult();
    }

    public ProductPrice findByName(Long clientId, Long priceListId,
            Long productId) {
        return (ProductPrice) this.em
                .createNamedQuery(ProductPrice.NQ_FIND_BY_NAME_PRIMITIVE)
                .setParameter("pClientId", clientId)
                .setParameter("pPriceListId", priceListId)
                .setParameter("pProductId", productId).getSingleResult();
    }

    public List<ProductPrice> findByPriceList(PriceList priceList) {
        return this.findByPriceListId(priceList.getId());
    }

    public List<ProductPrice> findByPriceListId(Long priceListId) {
        return (List<ProductPrice>) this.em
                .createQuery(
                        "select e from ProductPrice e where e.priceList.id = :pPriceListId",
                        ProductPrice.class)
                .setParameter("pPriceListId", priceListId).getResultList();
    }

    public List<ProductPrice> findByProduct(Product product) {
        return this.findByProductId(product.getId());
    }

    public List<ProductPrice> findByProductId(Long productId) {
        return (List<ProductPrice>) this.em
                .createQuery(
                        "select e from ProductPrice e where e.product.id = :pProductId",
                        ProductPrice.class)
                .setParameter("pProductId", productId).getResultList();
    }

}
