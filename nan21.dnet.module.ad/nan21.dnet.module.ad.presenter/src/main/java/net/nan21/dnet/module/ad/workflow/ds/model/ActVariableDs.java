/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.workflow.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.presenter.model.base.AbstractBaseDs;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActVariable;

@Ds(entity = ActVariable.class)
public class ActVariableDs extends AbstractBaseDs<ActVariable> {

    public static final String fTYPE = "type";
    public static final String fNAME = "name";
    public static final String fPROCESSINSTANCEID = "processInstanceId";
    public static final String fEXECUTIONID = "executionId";
    public static final String fDOUBLEVALUE = "doubleValue";
    public static final String fLONGVALUE = "longValue";
    public static final String fTEXTVALUE = "textValue";
    public static final String fTEXTVALUE2 = "textValue2";

    @DsField()
    private String type;

    @DsField()
    private String name;

    @DsField()
    private String processInstanceId;

    @DsField()
    private String executionId;

    @DsField()
    private Float doubleValue;

    @DsField()
    private Long longValue;

    @DsField()
    private String textValue;

    @DsField()
    private String textValue2;

    public ActVariableDs() {
        super();
    }

    public ActVariableDs(ActVariable e) {
        super(e);
    }

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

    public void setDoubleValue(Float doubleValue) {
        this.doubleValue = doubleValue;
    }

    public Long getLongValue() {
        return this.longValue;
    }

    public void setLongValue(Long longValue) {
        this.longValue = longValue;
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
