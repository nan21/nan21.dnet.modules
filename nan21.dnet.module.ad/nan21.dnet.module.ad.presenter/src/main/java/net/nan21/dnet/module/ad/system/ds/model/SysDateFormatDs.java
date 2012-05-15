/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.system.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;

import net.nan21.dnet.module.ad.system.domain.entity.SysDateFormat;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = SysDateFormat.class, sort = { @SortField(field = SysDateFormatDs.fNAME) })
public class SysDateFormatDs extends AbstractTypeDs<SysDateFormat> {

    public static final String fEXTJSDATEFORMAT = "extjsDateFormat";
    public static final String fEXTJSTIMEFORMAT = "extjsTimeFormat";
    public static final String fEXTJSDATETIMEFORMAT = "extjsDateTimeFormat";
    public static final String fEXTJSALTFORMATS = "extjsAltFormats";
    public static final String fJAVADATEFORMAT = "javaDateFormat";
    public static final String fJAVATIMEFORMAT = "javaTimeFormat";
    public static final String fJAVADATETIMEFORMAT = "javaDateTimeFormat";

    @DsField()
    private String extjsDateFormat;

    @DsField()
    private String extjsTimeFormat;

    @DsField()
    private String extjsDateTimeFormat;

    @DsField()
    private String extjsAltFormats;

    @DsField()
    private String javaDateFormat;

    @DsField()
    private String javaTimeFormat;

    @DsField()
    private String javaDateTimeFormat;

    public SysDateFormatDs() {
        super();
    }

    public SysDateFormatDs(SysDateFormat e) {
        super(e);
    }

    public String getExtjsDateFormat() {
        return this.extjsDateFormat;
    }

    public void setExtjsDateFormat(String extjsDateFormat) {
        this.extjsDateFormat = extjsDateFormat;
    }

    public String getExtjsTimeFormat() {
        return this.extjsTimeFormat;
    }

    public void setExtjsTimeFormat(String extjsTimeFormat) {
        this.extjsTimeFormat = extjsTimeFormat;
    }

    public String getExtjsDateTimeFormat() {
        return this.extjsDateTimeFormat;
    }

    public void setExtjsDateTimeFormat(String extjsDateTimeFormat) {
        this.extjsDateTimeFormat = extjsDateTimeFormat;
    }

    public String getExtjsAltFormats() {
        return this.extjsAltFormats;
    }

    public void setExtjsAltFormats(String extjsAltFormats) {
        this.extjsAltFormats = extjsAltFormats;
    }

    public String getJavaDateFormat() {
        return this.javaDateFormat;
    }

    public void setJavaDateFormat(String javaDateFormat) {
        this.javaDateFormat = javaDateFormat;
    }

    public String getJavaTimeFormat() {
        return this.javaTimeFormat;
    }

    public void setJavaTimeFormat(String javaTimeFormat) {
        this.javaTimeFormat = javaTimeFormat;
    }

    public String getJavaDateTimeFormat() {
        return this.javaDateTimeFormat;
    }

    public void setJavaDateTimeFormat(String javaDateTimeFormat) {
        this.javaDateTimeFormat = javaDateTimeFormat;
    }

}
