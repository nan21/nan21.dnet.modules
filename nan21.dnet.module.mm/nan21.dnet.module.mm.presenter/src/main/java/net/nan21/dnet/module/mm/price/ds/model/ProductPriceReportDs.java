/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.mm.price.ds.model;

import java.util.Date;
import net.nan21.dnet.core.api.model.IModelWithClientId;
import net.nan21.dnet.core.api.model.IModelWithId;
import net.nan21.dnet.core.presenter.model.AbstractDsModel;

import net.nan21.dnet.module.mm.price.domain.entity.ProductPrice;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = ProductPrice.class)
public class ProductPriceReportDs extends AbstractDsModel<ProductPrice>
        implements IModelWithId, IModelWithClientId {

    public static final String fID = "id";
    public static final String fCLIENTID = "clientId";
    public static final String fCREATEDAT = "createdAt";
    public static final String fMODIFIEDAT = "modifiedAt";
    public static final String fCREATEDBY = "createdBy";
    public static final String fMODIFIEDBY = "modifiedBy";
    public static final String fVERSION = "version";
    public static final String fPRICELISTID = "priceListId";
    public static final String fTYPEID = "typeId";
    public static final String fTYPE = "type";
    public static final String fCURRENCYID = "currencyId";
    public static final String fCURRENCY = "currency";
    public static final String fVALIDFROM = "validFrom";
    public static final String fVALIDTO = "validTo";
    public static final String fPRODUCTID = "productId";
    public static final String fPRODUCT = "product";
    public static final String fPRODUCTNAME = "productName";
    public static final String fPRICE = "price";

    @DsField()
    private Long id;

    @DsField()
    private Long clientId;

    @DsField()
    private Date createdAt;

    @DsField()
    private Date modifiedAt;

    @DsField()
    private String createdBy;

    @DsField()
    private String modifiedBy;

    @DsField()
    private Long version;

    @DsField(join = "left", path = "priceList.id")
    private Long priceListId;

    @DsField(join = "left", path = "priceList.type.id")
    private Long typeId;

    @DsField(join = "left", path = "priceList.type.name")
    private String type;

    @DsField(join = "left", path = "priceList.currency.id")
    private Long currencyId;

    @DsField(join = "left", path = "priceList.currency.code")
    private String currency;

    @DsField(join = "left", path = "priceList.validFrom")
    private Date validFrom;

    @DsField(join = "left", path = "priceList.validTo")
    private Date validTo;

    @DsField(join = "left", path = "product.id")
    private Long productId;

    @DsField(join = "left", path = "product.code")
    private String product;

    @DsField(join = "left", path = "product.name")
    private String productName;

    @DsField()
    private Float price;

    public ProductPriceReportDs() {
        super();
    }

    public ProductPriceReportDs(ProductPrice e) {
        super(e);
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Object id) {
        this.id = this._asLong_(id);

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

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getModifiedAt() {
        return this.modifiedAt;
    }

    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
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

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Long getPriceListId() {
        return this.priceListId;
    }

    public void setPriceListId(Long priceListId) {
        this.priceListId = priceListId;
    }

    public Long getTypeId() {
        return this.typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getCurrencyId() {
        return this.currencyId;
    }

    public void setCurrencyId(Long currencyId) {
        this.currencyId = currencyId;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Date getValidFrom() {
        return this.validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    public Date getValidTo() {
        return this.validTo;
    }

    public void setValidTo(Date validTo) {
        this.validTo = validTo;
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

    public Float getPrice() {
        return this.price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

}