/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.workflow.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractBaseDsFilter;

public class ActVariableDsFilter extends AbstractBaseDsFilter {

    private String type;

    private String name;

    private String processInstanceId;

    private String executionId;

    private Float doubleValue;

    private Float doubleValue_From;
    private Float doubleValue_To;

    private Long longValue;

    private Long longValue_From;
    private Long longValue_To;

    private String textValue;

    private String textValue2;

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProcessInstanceId() {
        return this.processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public String getExecutionId() {
        return this.executionId;
    }

    public void setExecutionId(String executionId) {
        this.executionId = executionId;
    }

    public Float getDoubleValue() {
        return this.doubleValue;
    }

    public Float getDoubleValue_From() {
        return this.doubleValue_From;
    }

    public Float getDoubleValue_To() {
        return this.doubleValue_To;
    }

    public void setDoubleValue(Float doubleValue) {
        this.doubleValue = doubleValue;
    }

    public void setDoubleValue_From(Float doubleValue_From) {
        this.doubleValue_From = doubleValue_From;
    }

    public void setDoubleValue_To(Float doubleValue_To) {
        this.doubleValue_To = doubleValue_To;
    }

    public Long getLongValue() {
        return this.longValue;
    }

    public Long getLongValue_From() {
        return this.longValue_From;
    }

    public Long getLongValue_To() {
        return this.longValue_To;
    }

    public void setLongValue(Long longValue) {
        this.longValue = longValue;
    }

    public void setLongValue_From(Long longValue_From) {
        this.longValue_From = longValue_From;
    }

    public void setLongValue_To(Long longValue_To) {
        this.longValue_To = longValue_To;
    }

    public String getTextValue() {
        return this.textValue;
    }

    public void setTextValue(String textValue) {
        this.textValue = textValue;
    }

    public String getTextValue2() {
        return this.textValue2;
    }

    public void setTextValue2(String textValue2) {
        this.textValue2 = textValue2;
    }

}
