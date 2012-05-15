/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.system.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractTypeDsFilter;

public class SysDateFormatDsFilter extends AbstractTypeDsFilter {

    private String extjsDateFormat;

    private String extjsTimeFormat;

    private String extjsDateTimeFormat;

    private String extjsAltFormats;

    private String javaDateFormat;

    private String javaTimeFormat;

    private String javaDateTimeFormat;

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
