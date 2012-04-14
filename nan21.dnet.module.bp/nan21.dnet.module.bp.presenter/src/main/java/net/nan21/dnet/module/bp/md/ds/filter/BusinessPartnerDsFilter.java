/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bp.md.ds.filter;

import java.util.Date;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeDsFilter;

public class BusinessPartnerDsFilter extends AbstractTypeWithCodeDsFilter {

    private String type;

    private String businessObject;

    private Long countryId;

    private Long countryId_From;
    private Long countryId_To;

    private String countryCode;

    private String taxPayerNo;

    private String firstName;

    private String lastName;

    private String middleName;

    private String gender;

    private String identityCardNo;

    private String passportNo;

    private Date birthDate;

    private Date birthDate_From;
    private Date birthDate_To;

    private String companyName;

    private Long legalFormId;

    private Long legalFormId_From;
    private Long legalFormId_To;

    private String legalForm;

    private String registrationNo;

    private Date registrationDate;

    private Date registrationDate_From;
    private Date registrationDate_To;

    private String className;

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBusinessObject() {
        return this.businessObject;
    }

    public void setBusinessObject(String businessObject) {
        this.businessObject = businessObject;
    }

    public Long getCountryId() {
        return this.countryId;
    }

    public Long getCountryId_From() {
        return this.countryId_From;
    }

    public Long getCountryId_To() {
        return this.countryId_To;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public void setCountryId_From(Long countryId_From) {
        this.countryId_From = countryId_From;
    }

    public void setCountryId_To(Long countryId_To) {
        this.countryId_To = countryId_To;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getTaxPayerNo() {
        return this.taxPayerNo;
    }

    public void setTaxPayerNo(String taxPayerNo) {
        this.taxPayerNo = taxPayerNo;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return this.middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdentityCardNo() {
        return this.identityCardNo;
    }

    public void setIdentityCardNo(String identityCardNo) {
        this.identityCardNo = identityCardNo;
    }

    public String getPassportNo() {
        return this.passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    public Date getBirthDate() {
        return this.birthDate;
    }

    public Date getBirthDate_From() {
        return this.birthDate_From;
    }

    public Date getBirthDate_To() {
        return this.birthDate_To;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setBirthDate_From(Date birthDate_From) {
        this.birthDate_From = birthDate_From;
    }

    public void setBirthDate_To(Date birthDate_To) {
        this.birthDate_To = birthDate_To;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Long getLegalFormId() {
        return this.legalFormId;
    }

    public Long getLegalFormId_From() {
        return this.legalFormId_From;
    }

    public Long getLegalFormId_To() {
        return this.legalFormId_To;
    }

    public void setLegalFormId(Long legalFormId) {
        this.legalFormId = legalFormId;
    }

    public void setLegalFormId_From(Long legalFormId_From) {
        this.legalFormId_From = legalFormId_From;
    }

    public void setLegalFormId_To(Long legalFormId_To) {
        this.legalFormId_To = legalFormId_To;
    }

    public String getLegalForm() {
        return this.legalForm;
    }

    public void setLegalForm(String legalForm) {
        this.legalForm = legalForm;
    }

    public String getRegistrationNo() {
        return this.registrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    public Date getRegistrationDate() {
        return this.registrationDate;
    }

    public Date getRegistrationDate_From() {
        return this.registrationDate_From;
    }

    public Date getRegistrationDate_To() {
        return this.registrationDate_To;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public void setRegistrationDate_From(Date registrationDate_From) {
        this.registrationDate_From = registrationDate_From;
    }

    public void setRegistrationDate_To(Date registrationDate_To) {
        this.registrationDate_To = registrationDate_To;
    }

    public String getClassName() {
        return this.className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

}
