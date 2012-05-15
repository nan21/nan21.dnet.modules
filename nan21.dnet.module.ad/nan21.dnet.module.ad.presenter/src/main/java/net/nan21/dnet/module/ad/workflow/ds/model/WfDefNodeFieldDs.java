/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.workflow.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;

import net.nan21.dnet.module.ad.workflow.domain.entity.WfDefNodeField;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = WfDefNodeField.class, sort = { @SortField(field = WfDefNodeFieldDs.fNAME) })
public class WfDefNodeFieldDs extends AbstractTypeDs<WfDefNodeField> {

    public static final String fTYPE = "type";
    public static final String fREQUIRED = "required";
    public static final String fNODEID = "nodeId";

    @DsField()
    private String type;

    @DsField()
    private Boolean required;

    @DsField(join = "left", path = "node.id")
    private Long nodeId;

    public WfDefNodeFieldDs() {
        super();
    }

    public WfDefNodeFieldDs(WfDefNodeField e) {
        super(e);
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getRequired() {
        return this.required;
    }

    public void setRequired(Boolean required) {
        this.required = required;
    }

    public Long getNodeId() {
        return this.nodeId;
    }

    public void setNodeId(Long nodeId) {
        this.nodeId = nodeId;
    }

}
