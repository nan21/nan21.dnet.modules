/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.base.attr.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;

import net.nan21.dnet.module.md.base.attr.domain.entity.Attribute;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = Attribute.class, sort = { @SortField(field = AttributeDs.fNAME) })
public class AttributeDs extends AbstractTypeDs<Attribute> {

    public static final String fTITLE = "title";
    public static final String fTYPEID = "typeId";
    public static final String fTYPE = "type";
    public static final String fDATATYPE = "dataType";
    public static final String fLISTOFVALUES = "listOfvalues";
    public static final String fUOMID = "uomId";
    public static final String fUOM = "uom";

    @DsField()
    private String title;

    @DsField(join = "left", path = "type.id")
    private Long typeId;

    @DsField(join = "left", path = "type.name")
    private String type;

    @DsField()
    private String dataType;

    @DsField()
    private String listOfvalues;

    @DsField(join = "left", path = "uom.id")
    private Long uomId;

    @DsField(join = "left", path = "uom.code")
    private String uom;

    public AttributeDs() {
        super();
    }

    public AttributeDs(Attribute e) {
        super(e);
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getDataType() {
        return this.dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getListOfvalues() {
        return this.listOfvalues;
    }

    public void setListOfvalues(String listOfvalues) {
        this.listOfvalues = listOfvalues;
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

}
