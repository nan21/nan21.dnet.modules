/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.mm.md.ds.filter;

import java.util.Date;
import net.nan21.dnet.core.api.model.IModelWithClientId;
import net.nan21.dnet.core.api.model.IModelWithId;

import net.nan21.dnet.core.presenter.model.AbstractDsFilter;

public class ProductDsFilter extends AbstractDsFilter implements IModelWithId,
        IModelWithClientId {

    private String name;

    private String code;

    private Boolean active;

    private String notes;

    private Long id;

    private Long id_From;
    private Long id_To;

    private Long clientId;

    private Long clientId_From;
    private Long clientId_To;

    private Date createdAt;

    private Date createdAt_From;
    private Date createdAt_To;

    private Date modifiedAt;

    private Date modifiedAt_From;
    private Date modifiedAt_To;

    private String createdBy;

    private String modifiedBy;

    private String iconUrl;

    private String imageUrl;

    private String description;

    private Boolean showInCatalog;

    private Boolean storable;

    private Float weight;

    private Float weight_From;
    private Float weight_To;

    private Float volume;

    private Float volume_From;
    private Float volume_To;

    private Float dimWidth;

    private Float dimWidth_From;
    private Float dimWidth_To;

    private Float dimHeight;

    private Float dimHeight_From;
    private Float dimHeight_To;

    private Float dimDepth;

    private Float dimDepth_From;
    private Float dimDepth_To;

    private String manufacturerProductNo;

    private Long defaultUomId;

    private Long defaultUomId_From;
    private Long defaultUomId_To;

    private String defaultUomCode;

    private Long weightUomId;

    private Long weightUomId_From;
    private Long weightUomId_To;

    private String weightUomCode;

    private Long volumeUomId;

    private Long volumeUomId_From;
    private Long volumeUomId_To;

    private String volumeUomCode;

    private Long dimUomId;

    private Long dimUomId_From;
    private Long dimUomId_To;

    private String dimUomCode;

    private Long manufacturerId;

    private Long manufacturerId_From;
    private Long manufacturerId_To;

    private String manufacturerCode;

    private Long attributeGroupId;

    private Long attributeGroupId_From;
    private Long attributeGroupId_To;

    private String attributeGroup;

    private String className;

    private String businessObject;

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

    public Long getId_From() {
        return this.id_From;
    }

    public Long getId_To() {
        return this.id_To;
    }

    public void setId(Object id) {
        this.id = this._asLong_(id);

    }

    public Long getClientId() {
        return this.clientId;
    }

    public Long getClientId_From() {
        return this.clientId_From;
    }

    public Long getClientId_To() {
        return this.clientId_To;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public void setClientId_From(Long clientId_From) {
        this.clientId_From = clientId_From;
    }

    public void setClientId_To(Long clientId_To) {
        this.clientId_To = clientId_To;
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

    public Boolean getStorable() {
        return this.storable;
    }

    public void setStorable(Boolean storable) {
        this.storable = storable;
    }

    public Float getWeight() {
        return this.weight;
    }

    public Float getWeight_From() {
        return this.weight_From;
    }

    public Float getWeight_To() {
        return this.weight_To;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public void setWeight_From(Float weight_From) {
        this.weight_From = weight_From;
    }

    public void setWeight_To(Float weight_To) {
        this.weight_To = weight_To;
    }

    public Float getVolume() {
        return this.volume;
    }

    public Float getVolume_From() {
        return this.volume_From;
    }

    public Float getVolume_To() {
        return this.volume_To;
    }

    public void setVolume(Float volume) {
        this.volume = volume;
    }

    public void setVolume_From(Float volume_From) {
        this.volume_From = volume_From;
    }

    public void setVolume_To(Float volume_To) {
        this.volume_To = volume_To;
    }

    public Float getDimWidth() {
        return this.dimWidth;
    }

    public Float getDimWidth_From() {
        return this.dimWidth_From;
    }

    public Float getDimWidth_To() {
        return this.dimWidth_To;
    }

    public void setDimWidth(Float dimWidth) {
        this.dimWidth = dimWidth;
    }

    public void setDimWidth_From(Float dimWidth_From) {
        this.dimWidth_From = dimWidth_From;
    }

    public void setDimWidth_To(Float dimWidth_To) {
        this.dimWidth_To = dimWidth_To;
    }

    public Float getDimHeight() {
        return this.dimHeight;
    }

    public Float getDimHeight_From() {
        return this.dimHeight_From;
    }

    public Float getDimHeight_To() {
        return this.dimHeight_To;
    }

    public void setDimHeight(Float dimHeight) {
        this.dimHeight = dimHeight;
    }

    public void setDimHeight_From(Float dimHeight_From) {
        this.dimHeight_From = dimHeight_From;
    }

    public void setDimHeight_To(Float dimHeight_To) {
        this.dimHeight_To = dimHeight_To;
    }

    public Float getDimDepth() {
        return this.dimDepth;
    }

    public Float getDimDepth_From() {
        return this.dimDepth_From;
    }

    public Float getDimDepth_To() {
        return this.dimDepth_To;
    }

    public void setDimDepth(Float dimDepth) {
        this.dimDepth = dimDepth;
    }

    public void setDimDepth_From(Float dimDepth_From) {
        this.dimDepth_From = dimDepth_From;
    }

    public void setDimDepth_To(Float dimDepth_To) {
        this.dimDepth_To = dimDepth_To;
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

    public Long getDefaultUomId_From() {
        return this.defaultUomId_From;
    }

    public Long getDefaultUomId_To() {
        return this.defaultUomId_To;
    }

    public void setDefaultUomId(Long defaultUomId) {
        this.defaultUomId = defaultUomId;
    }

    public void setDefaultUomId_From(Long defaultUomId_From) {
        this.defaultUomId_From = defaultUomId_From;
    }

    public void setDefaultUomId_To(Long defaultUomId_To) {
        this.defaultUomId_To = defaultUomId_To;
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

    public Long getWeightUomId_From() {
        return this.weightUomId_From;
    }

    public Long getWeightUomId_To() {
        return this.weightUomId_To;
    }

    public void setWeightUomId(Long weightUomId) {
        this.weightUomId = weightUomId;
    }

    public void setWeightUomId_From(Long weightUomId_From) {
        this.weightUomId_From = weightUomId_From;
    }

    public void setWeightUomId_To(Long weightUomId_To) {
        this.weightUomId_To = weightUomId_To;
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

    public Long getVolumeUomId_From() {
        return this.volumeUomId_From;
    }

    public Long getVolumeUomId_To() {
        return this.volumeUomId_To;
    }

    public void setVolumeUomId(Long volumeUomId) {
        this.volumeUomId = volumeUomId;
    }

    public void setVolumeUomId_From(Long volumeUomId_From) {
        this.volumeUomId_From = volumeUomId_From;
    }

    public void setVolumeUomId_To(Long volumeUomId_To) {
        this.volumeUomId_To = volumeUomId_To;
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

    public Long getDimUomId_From() {
        return this.dimUomId_From;
    }

    public Long getDimUomId_To() {
        return this.dimUomId_To;
    }

    public void setDimUomId(Long dimUomId) {
        this.dimUomId = dimUomId;
    }

    public void setDimUomId_From(Long dimUomId_From) {
        this.dimUomId_From = dimUomId_From;
    }

    public void setDimUomId_To(Long dimUomId_To) {
        this.dimUomId_To = dimUomId_To;
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

    public Long getManufacturerId_From() {
        return this.manufacturerId_From;
    }

    public Long getManufacturerId_To() {
        return this.manufacturerId_To;
    }

    public void setManufacturerId(Long manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public void setManufacturerId_From(Long manufacturerId_From) {
        this.manufacturerId_From = manufacturerId_From;
    }

    public void setManufacturerId_To(Long manufacturerId_To) {
        this.manufacturerId_To = manufacturerId_To;
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

    public Long getAttributeGroupId_From() {
        return this.attributeGroupId_From;
    }

    public Long getAttributeGroupId_To() {
        return this.attributeGroupId_To;
    }

    public void setAttributeGroupId(Long attributeGroupId) {
        this.attributeGroupId = attributeGroupId;
    }

    public void setAttributeGroupId_From(Long attributeGroupId_From) {
        this.attributeGroupId_From = attributeGroupId_From;
    }

    public void setAttributeGroupId_To(Long attributeGroupId_To) {
        this.attributeGroupId_To = attributeGroupId_To;
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

    public String getBusinessObject() {
        return this.businessObject;
    }

    public void setBusinessObject(String businessObject) {
        this.businessObject = businessObject;
    }

}
