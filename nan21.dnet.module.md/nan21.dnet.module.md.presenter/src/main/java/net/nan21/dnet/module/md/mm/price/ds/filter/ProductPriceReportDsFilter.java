/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.mm.price.ds.filter;

import java.util.Date;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDsFilter;

public class ProductPriceReportDsFilter extends AbstractAuditableDsFilter {

    private Long priceListId;

    private Long priceListId_From;
    private Long priceListId_To;

    private String priceList;

    private Long currencyId;

    private Long currencyId_From;
    private Long currencyId_To;

    private String currency;

    private Long priceListVersionId;

    private Long priceListVersionId_From;
    private Long priceListVersionId_To;

    private String priceListVersion;

    private Date validFrom;

    private Date validFrom_From;
    private Date validFrom_To;

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

    public Long getPriceListId() {
        return this.priceListId;
    }

    public Long getPriceListId_From() {
        return this.priceListId_From;
    }

    public Long getPriceListId_To() {
        return this.priceListId_To;
    }

    public void setPriceListId(Long priceListId) {
        this.priceListId = priceListId;
    }

    public void setPriceListId_From(Long priceListId_From) {
        this.priceListId_From = priceListId_From;
    }

    public void setPriceListId_To(Long priceListId_To) {
        this.priceListId_To = priceListId_To;
    }

    public String getPriceList() {
        return this.priceList;
    }

    public void setPriceList(String priceList) {
        this.priceList = priceList;
    }

    public Long getCurrencyId() {
        return this.currencyId;
    }

    public Long getCurrencyId_From() {
        return this.currencyId_From;
    }

    public Long getCurrencyId_To() {
        return this.currencyId_To;
    }

    public void setCurrencyId(Long currencyId) {
        this.currencyId = currencyId;
    }

    public void setCurrencyId_From(Long currencyId_From) {
        this.currencyId_From = currencyId_From;
    }

    public void setCurrencyId_To(Long currencyId_To) {
        this.currencyId_To = currencyId_To;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

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

    public Date getValidFrom() {
        return this.validFrom;
    }

    public Date getValidFrom_From() {
        return this.validFrom_From;
    }

    public Date getValidFrom_To() {
        return this.validFrom_To;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    public void setValidFrom_From(Date validFrom_From) {
        this.validFrom_From = validFrom_From;
    }

    public void setValidFrom_To(Date validFrom_To) {
        this.validFrom_To = validFrom_To;
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
