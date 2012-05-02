/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.mm.price.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDsFilter;

public class ProductPriceDsFilter extends AbstractAuditableDsFilter {

    private Long priceListVersionId;

    private Long priceListVersionId_From;
    private Long priceListVersionId_To;

    private String priceListVersion;

    private Long productId;

    private Long productId_From;
    private Long productId_To;

    private String product;

    private String productName;

    private Long uomId;

    private Long uomId_From;
    private Long uomId_To;

    private String uom;

    private Float price;

    private Float price_From;
    private Float price_To;

    public Long getPriceListVersionId() {
        return this.priceListVersionId;
    }

    public Long getPriceListVersionId_From() {
        return this.priceListVersionId_From;
    }

    public Long getPriceListVersionId_To() {
        return this.priceListVersionId_To;
    }

    public void setPriceListVersionId(Long priceListVersionId) {
        this.priceListVersionId = priceListVersionId;
    }

    public void setPriceListVersionId_From(Long priceListVersionId_From) {
        this.priceListVersionId_From = priceListVersionId_From;
    }

    public void setPriceListVersionId_To(Long priceListVersionId_To) {
        this.priceListVersionId_To = priceListVersionId_To;
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

    public Long getProductId_From() {
        return this.productId_From;
    }

    public Long getProductId_To() {
        return this.productId_To;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public void setProductId_From(Long productId_From) {
        this.productId_From = productId_From;
    }

    public void setProductId_To(Long productId_To) {
        this.productId_To = productId_To;
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

    public Long getUomId_From() {
        return this.uomId_From;
    }

    public Long getUomId_To() {
        return this.uomId_To;
    }

    public void setUomId(Long uomId) {
        this.uomId = uomId;
    }

    public void setUomId_From(Long uomId_From) {
        this.uomId_From = uomId_From;
    }

    public void setUomId_To(Long uomId_To) {
        this.uomId_To = uomId_To;
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

    public Float getPrice_From() {
        return this.price_From;
    }

    public Float getPrice_To() {
        return this.price_To;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public void setPrice_From(Float price_From) {
        this.price_From = price_From;
    }

    public void setPrice_To(Float price_To) {
        this.price_To = price_To;
    }

}
