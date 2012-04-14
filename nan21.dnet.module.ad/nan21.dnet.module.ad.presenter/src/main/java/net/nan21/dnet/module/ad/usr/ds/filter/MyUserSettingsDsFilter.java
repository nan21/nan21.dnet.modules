/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.usr.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeDsFilter;

public class MyUserSettingsDsFilter extends AbstractTypeWithCodeDsFilter {

    private String decimalSeparator;

    private String thousandSeparator;

    private Long dateFormatId;

    private Long dateFormatId_From;
    private Long dateFormatId_To;

    private String dateFormat;

    public String getDecimalSeparator() {
        return this.decimalSeparator;
    }

    public void setDecimalSeparator(String decimalSeparator) {
        this.decimalSeparator = decimalSeparator;
    }

    public String getThousandSeparator() {
        return this.thousandSeparator;
    }

    public void setThousandSeparator(String thousandSeparator) {
        this.thousandSeparator = thousandSeparator;
    }

    public Long getDateFormatId() {
        return this.dateFormatId;
    }

    public Long getDateFormatId_From() {
        return this.dateFormatId_From;
    }

    public Long getDateFormatId_To() {
        return this.dateFormatId_To;
    }

    public void setDateFormatId(Long dateFormatId) {
        this.dateFormatId = dateFormatId;
    }

    public void setDateFormatId_From(Long dateFormatId_From) {
        this.dateFormatId_From = dateFormatId_From;
    }

    public void setDateFormatId_To(Long dateFormatId_To) {
        this.dateFormatId_To = dateFormatId_To;
    }

    public String getDateFormat() {
        return this.dateFormat;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }

}
