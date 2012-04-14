/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.usr.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeDs;

import net.nan21.dnet.module.ad.usr.domain.entity.User;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = User.class, sort = { @SortField(field = UserDs.fNAME) })
public class UserDs extends AbstractTypeWithCodeDs<User> {

    public static final String fCODE = "code";
    public static final String fLOCKED = "locked";
    public static final String fACCOUNTTYPE = "accountType";
    public static final String fACCOUNTTYPEID = "accountTypeId";
    public static final String fDECIMALSEPARATOR = "decimalSeparator";
    public static final String fTHOUSANDSEPARATOR = "thousandSeparator";
    public static final String fDATEFORMATID = "dateFormatId";
    public static final String fDATEFORMAT = "dateFormat";

    @DsField(noUpdate = true)
    private String code;

    @DsField()
    private Boolean locked;

    @DsField(join = "left", path = "accountType.name")
    private String accountType;

    @DsField(join = "left", path = "accountType.id")
    private Long accountTypeId;

    @DsField()
    private String decimalSeparator;

    @DsField()
    private String thousandSeparator;

    @DsField(join = "left", path = "dateFormat.id")
    private Long dateFormatId;

    @DsField(join = "left", path = "dateFormat.name")
    private String dateFormat;

    public UserDs() {
        super();
    }

    public UserDs(User e) {
        super(e);
    }

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

    public void setAccountTypeId(Long accountTypeId) {
        this.accountTypeId = accountTypeId;
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

    public void setDateFormatId(Long dateFormatId) {
        this.dateFormatId = dateFormatId;
    }

    public String getDateFormat() {
        return this.dateFormat;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }

}
