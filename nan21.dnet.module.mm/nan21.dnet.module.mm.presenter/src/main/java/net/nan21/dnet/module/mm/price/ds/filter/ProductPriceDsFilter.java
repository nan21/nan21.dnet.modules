/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.mm.price.ds.filter;

import java.util.Date;
import net.nan21.dnet.core.api.model.IModelWithClientId;
import net.nan21.dnet.core.api.model.IModelWithId;

import net.nan21.dnet.core.presenter.model.AbstractDsFilter;

public class ProductPriceDsFilter extends AbstractDsFilter implements
        IModelWithId, IModelWithClientId {

    private Long id;

    private String uuid;

    private Long clientId;

    private Date createdAt;

    private Date createdAt_From;
    private Date createdAt_To;

    private Date modifiedAt;

    private Date modifiedAt_From;
    private Date modifiedAt_To;

    private String createdBy;

    private String modifiedBy;

    private String entityFQN;

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

    public Long getId() {
        return this.id;
    }

    public void setId(Object id) {
        this.id = this._asLong_(id);

    }

    public String getUuid() {
        return this.uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Long getClientId() {
        return this.clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public Date getCreatedAt_From() {
        return this.createdAt_From;
    }

    public Date getCreatedAt_To() {
        return this.createdAt_To;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setCreatedAt_From(Date createdAt_From) {
        this.createdAt_From = createdAt_From;
    }

    public void setCreatedAt_To(Date createdAt_To) {
        this.createdAt_To = createdAt_To;
    }

    public Date getModifiedAt() {
        return this.modifiedAt;
    }

    public Date getModifiedAt_From() {
        return this.modifiedAt_From;
    }

    public Date getModifiedAt_To() {
        return this.modifiedAt_To;
    }

    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public void setModifiedAt_From(Date modifiedAt_From) {
        this.modifiedAt_From = modifiedAt_From;
    }

    public void setModifiedAt_To(Date modifiedAt_To) {
        this.modifiedAt_To = modifiedAt_To;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedBy() {
        return this.modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getEntityFQN() {
        return this.entityFQN;
    }

    public void setEntityFQN(String entityFQN) {
        this.entityFQN = entityFQN;
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
