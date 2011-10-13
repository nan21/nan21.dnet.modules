/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.mm.md.ds.model;

import java.util.Date;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.api.model.IModelWithClientId;
import net.nan21.dnet.core.api.model.IModelWithId;
import net.nan21.dnet.core.presenter.model.AbstractDsModel;

import net.nan21.dnet.module.mm.md.domain.entity.Product;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = Product.class, sort = { @SortField(field = ProductDs.fNAME) })
public class ProductDs extends AbstractDsModel<Product> implements
        IModelWithId, IModelWithClientId {

    public static final String fNAME = "name";
    public static final String fCODE = "code";
    public static final String fACTIVE = "active";
    public static final String fNOTES = "notes";
    public static final String fID = "id";
    public static final String fCLIENTID = "clientId";
    public static final String fCREATEDAT = "createdAt";
    public static final String fMODIFIEDAT = "modifiedAt";
    public static final String fCREATEDBY = "createdBy";
    public static final String fMODIFIEDBY = "modifiedBy";
    public static final String fVERSION = "version";
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
    public static final String fATTRIBUTEGROUPID = "attributeGroupId";
    public static final String fATTRIBUTEGROUP = "attributeGroup";
    public static final String fCLASSNAME = "className";

    @DsField()
    private String name;

    @DsField()
    private String code;

    @DsField()
    private Boolean active;

    @DsField()
    private String notes;

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

    @DsField(join = "left", path = "attributeGroup.id")
    private Long attributeGroupId;

    @DsField(join = "left", path = "attributeGroup.name")
    private String attributeGroup;

    @DsField(fetch = false)
    private String className;

    public ProductDs() {
        super();
    }

    public ProductDs(Product e) {
        super(e);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
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

    public Long getAttributeGroupId() {
        return this.attributeGroupId;
    }

    public void setAttributeGroupId(Long attributeGroupId) {
        this.attributeGroupId = attributeGroupId;
    }

    public String getAttributeGroup() {
        return this.attributeGroup;
    }

    public void setAttributeGroup(String attributeGroup) {
        this.attributeGroup = attributeGroup;
    }

    public String getClassName() {
        return this.className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

}
