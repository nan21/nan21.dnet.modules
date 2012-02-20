/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.mm.price.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;
import net.nan21.dnet.module.mm.md.domain.entity.Product;
import net.nan21.dnet.module.mm.price.business.service.IProductPriceService;
import net.nan21.dnet.module.mm.price.domain.entity.PriceListVersion;

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

    public ProductPrice findByName(PriceListVersion priceListVersion,
            Product product) {
        return (ProductPrice) this.em
                .createNamedQuery(ProductPrice.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pPriceListVersion", priceListVersion)
                .setParameter("pProduct", product).getSingleResult();
    }

    public ProductPrice findByName(Long priceListVersionId, Long productId) {
        return (ProductPrice) this.em
                .createNamedQuery(ProductPrice.NQ_FIND_BY_NAME_PRIMITIVE)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pPriceListVersionId", priceListVersionId)
                .setParameter("pProductId", productId).getSingleResult();
    }

    public List<ProductPrice> findByPriceListVersion(
            PriceListVersion priceListVersion) {
        return this.findByPriceListVersionId(priceListVersion.getId());
    }

    public List<ProductPrice> findByPriceListVersionId(Long priceListVersionId) {
        return (List<ProductPrice>) this.em
                .createQuery(
                        "select e from ProductPrice e where e.clientId = :pClientId and e.priceListVersion.id = :pPriceListVersionId",
                        ProductPrice.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pPriceListVersionId", priceListVersionId)
                .getResultList();
    }

    public List<ProductPrice> findByProduct(Product product) {
        return this.findByProductId(product.getId());
    }

    public List<ProductPrice> findByProductId(Long productId) {
        return (List<ProductPrice>) this.em
                .createQuery(
                        "select e from ProductPrice e where e.clientId = :pClientId and e.product.id = :pProductId",
                        ProductPrice.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pProductId", productId).getResultList();
    }

    public List<ProductPrice> findByUom(Uom uom) {
        return this.findByUomId(uom.getId());
    }

    public List<ProductPrice> findByUomId(Long uomId) {
        return (List<ProductPrice>) this.em
                .createQuery(
                        "select e from ProductPrice e where e.clientId = :pClientId and e.uom.id = :pUomId",
                        ProductPrice.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pUomId", uomId).getResultList();
    }

}
