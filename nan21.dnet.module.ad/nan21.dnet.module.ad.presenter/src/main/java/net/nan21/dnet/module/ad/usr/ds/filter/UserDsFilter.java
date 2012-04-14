/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.usr.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeDsFilter;

public class UserDsFilter extends AbstractTypeWithCodeDsFilter {

    private String code;

    private Boolean locked;

    private String accountType;

    private Long accountTypeId;

    private Long accountTypeId_From;
    private Long accountTypeId_To;

    private String decimalSeparator;

    private String thousandSeparator;

    private Long dateFormatId;

    private Long dateFormatId_From;
    private Long dateFormatId_To;

    private String dateFormat;

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Boolean getLocked() {
        return this.locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public String getAccountType() {
        return this.accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Long getAccountTypeId() {
        return this.accountTypeId;
    }

    public Long getAccountTypeId_From() {
        return this.accountTypeId_From;
    }

    public Long getAccountTypeId_To() {
        return this.accountTypeId_To;
    }

    public void setAccountTypeId(Long accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

    public void setAccountTypeId_From(Long accountTypeId_From) {
        this.accountTypeId_From = accountTypeId_From;
    }

    public void setAccountTypeId_To(Long accountTypeId_To) {
        this.accountTypeId_To = accountTypeId_To;
    }

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
