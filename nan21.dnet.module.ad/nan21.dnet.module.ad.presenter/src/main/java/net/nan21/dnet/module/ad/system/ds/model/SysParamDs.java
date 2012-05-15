/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.system.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeDs;

import net.nan21.dnet.module.ad.system.domain.entity.SysParam;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = SysParam.class, sort = { @SortField(field = SysParamDs.fNAME) })
public class SysParamDs extends AbstractTypeWithCodeDs<SysParam> {

    public static final String fDEFAULTVALUE = "defaultValue";
    public static final String fVALUE = "value";

    @DsField()
    private String defaultValue;

    @DsField()
    private String value;

    public SysParamDs() {
        super();
    }

    public SysParamDs(SysParam e) {
        super(e);
    }

    public String getDefaultValue() {
        return this.defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
