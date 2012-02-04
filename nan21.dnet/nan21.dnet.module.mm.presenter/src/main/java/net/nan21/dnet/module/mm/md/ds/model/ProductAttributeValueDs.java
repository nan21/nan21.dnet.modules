/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.mm.md.ds.model;

import java.util.Date;
import javax.persistence.QueryHint;
import net.nan21.dnet.core.api.annotation.DsQueryHints;
import net.nan21.dnet.core.api.model.IModelWithClientId;
import net.nan21.dnet.core.api.model.IModelWithId;
import net.nan21.dnet.core.presenter.model.AbstractDsModel;
import org.eclipse.persistence.config.QueryHints;

import net.nan21.dnet.module.mm.md.domain.entity.ProductAttributeValue;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = ProductAttributeValue.class)
@DsQueryHints({
        @QueryHint(name = QueryHints.LEFT_FETCH, value = "e.product.attributeGroup"),
        @QueryHint(name = QueryHints.LEFT_FETCH, value = "e.groupAttribute.attribute.type"),
        @QueryHint(name = QueryHints.LEFT_FETCH, value = "e.groupAttribute.attribute.uom") })
public class ProductAttributeValueDs extends
        AbstractDsModel<ProductAttributeValue> implements IModelWithId,
        IModelWithClientId {

    public static final String fID = "id";
    public static final String fUUID = "uuid";
    public static final String fCLIENTID = "clientId";
    public static final String fCREATEDAT = "createdAt";
    public static final String fMODIFIEDAT = "modifiedAt";
    public static final String fCREATEDBY = "createdBy";
    public static final String fMODIFIEDBY = "modifiedBy";
    public static final String fVERSION = "version";
    public static final String fENTITYFQN = "entityFQN";
    public static final String fPRODUCTID = "productId";
    public static final String fPRODUCTCODE = "productCode";
    public static final String fPRODUCTNAME = "productName";
    public static final String fGROUPID = "groupId";
    public static final String fGROUP = "group";
    public static final String fGROUPATTRIBUTEID = "groupAttributeId";
    public static final String fATTRIBUTEID = "attributeId";
    public static final String fATTRIBUTE = "attribute";
    public static final String fTITLE = "title";
    public static final String fDATATYPE = "dataType";
    public static final String fTYPEID = "typeId";
    public static final String fTYPE = "type";
    public static final String fUOM = "uom";
    public static final String fLISTOFVALUES = "listOfvalues";
    public static final String fVALUE = "value";

    @DsField()
    private Long id;

    @DsField()
    private String uuid;

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

    @DsField(fetch = false, path = "className")
    private String entityFQN;

    @DsField(join = "left", path = "product.id")
    private Long productId;

    @DsField(join = "left", path = "product.code")
    private String productCode;

    @DsField(join = "left", path = "product.name")
    private String productName;

    @DsField(join = "left", path = "product.attributeGroup.id")
    private Long groupId;

    @DsField(join = "left", path = "product.attributeGroup.name")
    private String group;

    @DsField(join = "left", path = "groupAttribute.id")
    private Long groupAttributeId;

    @DsField(join = "left", path = "groupAttribute.attribute.id")
    private Long attributeId;

    @DsField(join = "left", path = "groupAttribute.attribute.name")
    private String attribute;

    @DsField(join = "left", path = "groupAttribute.attribute.title")
    private String title;

    @DsField(join = "left", path = "groupAttribute.attribute.dataType")
    private String dataType;

    @DsField(join = "left", path = "groupAttribute.attribute.type.id")
    private Long typeId;

    @DsField(join = "left", path = "groupAttribute.attribute.type.name")
    private String type;

    @DsField(join = "left", path = "groupAttribute.attribute.uom.code")
    private String uom;

    @DsField(join = "left", path = "groupAttribute.attribute.listOfvalues")
    private String listOfvalues;

    @DsField()
    private String value;

    public ProductAttributeValueDs() {
        super();
    }

    public ProductAttributeValueDs(ProductAttributeValue e) {
        super(e);
    }

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

    public String getEntityFQN() {
        return this.entityFQN;
    }

    public void setEntityFQN(String entityFQN) {
        this.entityFQN = entityFQN;
    }

    public Long getProductId() {
        return this.productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductCode() {
        return this.productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getGroupId() {
        return this.groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getGroup() {
        return this.group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Long getGroupAttributeId() {
        return this.groupAttributeId;
    }

    public void setGroupAttributeId(Long groupAttributeId) {
        this.groupAttributeId = groupAttributeId;
    }

    public Long getAttributeId() {
        return this.attributeId;
    }

    public void setAttributeId(Long attributeId) {
        this.attributeId = attributeId;
    }

    public String getAttribute() {
        return this.attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDataType() {
        return this.dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
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

    public String getUom() {
        return this.uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }

    public String getListOfvalues() {
        return this.listOfvalues;
    }

    public void setListOfvalues(String listOfvalues) {
        this.listOfvalues = listOfvalues;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}