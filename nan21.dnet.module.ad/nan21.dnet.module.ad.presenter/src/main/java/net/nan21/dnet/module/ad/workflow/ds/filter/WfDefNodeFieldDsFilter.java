/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.workflow.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractTypeDsFilter;

public class WfDefNodeFieldDsFilter extends AbstractTypeDsFilter {

    private String type;

    private Boolean required;

    private Long nodeId;

    private Long nodeId_From;
    private Long nodeId_To;

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

    public Long getNodeId_From() {
        return this.nodeId_From;
    }

    public Long getNodeId_To() {
        return this.nodeId_To;
    }

    public void setNodeId(Long nodeId) {
        this.nodeId = nodeId;
    }

    public void setNodeId_From(Long nodeId_From) {
        this.nodeId_From = nodeId_From;
    }

    public void setNodeId_To(Long nodeId_To) {
        this.nodeId_To = nodeId_To;
    }

}
