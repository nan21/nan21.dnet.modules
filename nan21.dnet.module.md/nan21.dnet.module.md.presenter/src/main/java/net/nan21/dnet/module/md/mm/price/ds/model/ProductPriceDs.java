/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.mm.price.ds.model;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;

import net.nan21.dnet.module.md.mm.price.domain.entity.ProductPrice;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = ProductPrice.class)
public class ProductPriceDs extends AbstractAuditableDs<ProductPrice> {

    public static final String fPRICELISTVERSIONID = "priceListVersionId";
    public static final String fPRICELISTVERSION = "priceListVersion";
    public static final String fPRODUCTID = "productId";
    public static final String fPRODUCT = "product";
    public static final String fPRODUCTNAME = "productName";
    public static final String fUOMID = "uomId";
    public static final String fUOM = "uom";
    public static final String fPRICE = "price";

    @DsField(join = "left", path = "priceListVersion.id")
    private Long priceListVersionId;

    @DsField(join = "left", path = "priceListVersion.name")
    private String priceListVersion;

    @DsField(join = "left", path = "product.id")
    private Long productId;

    @DsField(join = "left", path = "product.code")
    private String product;

    @DsField(join = "left", path = "product.name")
    private String productName;

    @DsField(join = "left", path = "uom.id")
    private Long uomId;

    @DsField(join = "left", path = "uom.code")
    private String uom;

    @DsField()
    private Float price;

    public ProductPriceDs() {
        super();
    }

    public ProductPriceDs(ProductPrice e) {
        super(e);
    }

    public Long getPriceListVersionId() {
        return this.priceListVersionId;
    }

    public void setPriceListVersionId(Long priceListVersionId) {
        this.priceListVersionId = priceListVersionId;
    }

    public String getPriceListVersion() {
        return this.priceListVersion;
    }

    public void setPriceListVersion(String priceListVersion) {
        this.priceListVersion = priceListVersion;
    }

    public Long getProductId() {
        return this.productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProduct() {
        return this.product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getUomId() {
        return this.uomId;
    }

    public void setUomId(Long uomId) {
        this.uomId = uomId;
    }

    public String getUom() {
        return this.uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }

    public Float getPrice() {
        return this.price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

}
