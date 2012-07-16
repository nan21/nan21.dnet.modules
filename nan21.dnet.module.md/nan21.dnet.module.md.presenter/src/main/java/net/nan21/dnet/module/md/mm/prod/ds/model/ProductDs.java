/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.mm.prod.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeDs;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;

@Ds(entity = Product.class, sort = { @SortField(field = ProductDs.fNAME) })
public class ProductDs extends AbstractTypeWithCodeDs<Product> {

    public static final String fICONURL = "iconUrl";
    public static final String fIMAGEURL = "imageUrl";
    public static final String fDESCRIPTION = "description";
    public static final String fSHOWINCATALOG = "showInCatalog";
    public static final String fSALE = "sale";
    public static final String fPURCHASE = "purchase";
    public static final String fSTORABLE = "storable";
    public static final String fWEIGHT = "weight";
    public static final String fVOLUME = "volume";
    public static final String fDIMWIDTH = "dimWidth";
    public static final String fDIMHEIGHT = "dimHeight";
    public static final String fDIMDEPTH = "dimDepth";
    public static final String fMANUFACTURERPRODUCTNO = "manufacturerProductNo";
    public static final String fDEFAULTUOMID = "defaultUomId";
    public static final String fDEFAULTUOMCODE = "defaultUomCode";
    public static final String fWEIGHTUOMID = "weightUomId";
    public static final String fWEIGHTUOMCODE = "weightUomCode";
    public static final String fVOLUMEUOMID = "volumeUomId";
    public static final String fVOLUMEUOMCODE = "volumeUomCode";
    public static final String fDIMUOMID = "dimUomId";
    public static final String fDIMUOMCODE = "dimUomCode";
    public static final String fMANUFACTURERID = "manufacturerId";
    public static final String fMANUFACTURERCODE = "manufacturerCode";
    public static final String fATTRIBUTESETID = "attributeSetId";
    public static final String fATTRIBUTESET = "attributeSet";
    public static final String fCLASSNAME = "className";
    public static final String fBUSINESSOBJECT = "businessObject";

    @DsField()
    private String iconUrl;

    @DsField()
    private String imageUrl;

    @DsField()
    private String description;

    @DsField()
    private Boolean showInCatalog;

    @DsField()
    private Boolean sale;

    @DsField()
    private Boolean purchase;

    @DsField()
    private Boolean storable;

    @DsField()
    private Float weight;

    @DsField()
    private Float volume;

    @DsField()
    private Float dimWidth;

    @DsField()
    private Float dimHeight;

    @DsField()
    private Float dimDepth;

    @DsField()
    private String manufacturerProductNo;

    @DsField(join = "left", path = "defaultUom.id")
    private Long defaultUomId;

    @DsField(join = "left", path = "defaultUom.code")
    private String defaultUomCode;

    @DsField(join = "left", path = "weightUom.id")
    private Long weightUomId;

    @DsField(join = "left", path = "weightUom.code")
    private String weightUomCode;

    @DsField(join = "left", path = "volumeUom.id")
    private Long volumeUomId;

    @DsField(join = "left", path = "volumeUom.code")
    private String volumeUomCode;

    @DsField(join = "left", path = "dimUom.id")
    private Long dimUomId;

    @DsField(join = "left", path = "dimUom.code")
    private String dimUomCode;

    @DsField(join = "left", path = "manufacturer.id")
    private Long manufacturerId;

    @DsField(join = "left", path = "manufacturer.code")
    private String manufacturerCode;

    @DsField(join = "left", path = "attributeSet.id")
    private Long attributeSetId;

    @DsField(join = "left", path = "attributeSet.name")
    private String attributeSet;

    @DsField(fetch = false)
    private String className;

    @DsField(fetch = false)
    private String businessObject;

    public ProductDs() {
        super();
    }

    public ProductDs(Product e) {
        super(e);
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getShowInCatalog() {
        return this.showInCatalog;
    }

    public void setShowInCatalog(Boolean showInCatalog) {
        this.showInCatalog = showInCatalog;
    }

    public Boolean getSale() {
        return this.sale;
    }

    public void setSale(Boolean sale) {
        this.sale = sale;
    }

    public Boolean getPurchase() {
        return this.purchase;
    }

    public void setPurchase(Boolean purchase) {
        this.purchase = purchase;
    }

    public Boolean getStorable() {
        return this.storable;
    }

    public void setStorable(Boolean storable) {
        this.storable = storable;
    }

    public Float getWeight() {
        return this.weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Float getVolume() {
        return this.volume;
    }

    public void setVolume(Float volume) {
        this.volume = volume;
    }

    public Float getDimWidth() {
        return this.dimWidth;
    }

    public void setDimWidth(Float dimWidth) {
        this.dimWidth = dimWidth;
    }

    public Float getDimHeight() {
        return this.dimHeight;
    }

    public void setDimHeight(Float dimHeight) {
        this.dimHeight = dimHeight;
    }

    public Float getDimDepth() {
        return this.dimDepth;
    }

    public void setDimDepth(Float dimDepth) {
        this.dimDepth = dimDepth;
    }

    public String getManufacturerProductNo() {
        return this.manufacturerProductNo;
    }

    public void setManufacturerProductNo(String manufacturerProductNo) {
        this.manufacturerProductNo = manufacturerProductNo;
    }

    public Long getDefaultUomId() {
        return this.defaultUomId;
    }

    public void setDefaultUomId(Long defaultUomId) {
        this.defaultUomId = defaultUomId;
    }

    public String getDefaultUomCode() {
        return this.defaultUomCode;
    }

    public void setDefaultUomCode(String defaultUomCode) {
        this.defaultUomCode = defaultUomCode;
    }

    public Long getWeightUomId() {
        return this.weightUomId;
    }

    public void setWeightUomId(Long weightUomId) {
        this.weightUomId = weightUomId;
    }

    public String getWeightUomCode() {
        return this.weightUomCode;
    }

    public void setWeightUomCode(String weightUomCode) {
        this.weightUomCode = weightUomCode;
    }

    public Long getVolumeUomId() {
        return this.volumeUomId;
    }

    public void setVolumeUomId(Long volumeUomId) {
        this.volumeUomId = volumeUomId;
    }

    public String getVolumeUomCode() {
        return this.volumeUomCode;
    }

    public void setVolumeUomCode(String volumeUomCode) {
        this.volumeUomCode = volumeUomCode;
    }

    public Long getDimUomId() {
        return this.dimUomId;
    }

    public void setDimUomId(Long dimUomId) {
        this.dimUomId = dimUomId;
    }

    public String getDimUomCode() {
        return this.dimUomCode;
    }

    public void setDimUomCode(String dimUomCode) {
        this.dimUomCode = dimUomCode;
    }

    public Long getManufacturerId() {
        return this.manufacturerId;
    }

    public void setManufacturerId(Long manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public String getManufacturerCode() {
        return this.manufacturerCode;
    }

    public void setManufacturerCode(String manufacturerCode) {
        this.manufacturerCode = manufacturerCode;
    }

    public Long getAttributeSetId() {
        return this.attributeSetId;
    }

    public void setAttributeSetId(Long attributeSetId) {
        this.attributeSetId = attributeSetId;
    }

    public String getAttributeSet() {
        return this.attributeSet;
    }

    public void setAttributeSet(String attributeSet) {
        this.attributeSet = attributeSet;
    }

    public String getClassName() {
        return this.className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getBusinessObject() {
        return this.businessObject;
    }

    public void setBusinessObject(String businessObject) {
        this.businessObject = businessObject;
    }

}
