/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.bp.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDsFilter;

public class BpClassificationDsFilter extends AbstractAuditableDsFilter {

    private Long businessPartnerId;

    private Long businessPartnerId_From;
    private Long businessPartnerId_To;

    private String businessPartner;

    private String businessPartnerBO;

    private Long classificationSystemId;

    private Long classificationSystemId_From;
    private Long classificationSystemId_To;

    private String classificationSystem;

    private Long classificationId;

    private Long classificationId_From;
    private Long classificationId_To;

    private String classificationCode;

    private String classificationName;

    public Long getBusinessPartnerId() {
        return this.businessPartnerId;
    }

    public Long getBusinessPartnerId_From() {
        return this.businessPartnerId_From;
    }

    public Long getBusinessPartnerId_To() {
        return this.businessPartnerId_To;
    }

    public void setBusinessPartnerId(Long businessPartnerId) {
        this.businessPartnerId = businessPartnerId;
    }

    public void setBusinessPartnerId_From(Long businessPartnerId_From) {
        this.businessPartnerId_From = businessPartnerId_From;
    }

    public void setBusinessPartnerId_To(Long businessPartnerId_To) {
        this.businessPartnerId_To = businessPartnerId_To;
    }

    public String getBusinessPartner() {
        return this.businessPartner;
    }

    public void setBusinessPartner(String businessPartner) {
        this.businessPartner = businessPartner;
    }

    public String getBusinessPartnerBO() {
        return this.businessPartnerBO;
    }

    public void setBusinessPartnerBO(String businessPartnerBO) {
        this.businessPartnerBO = businessPartnerBO;
    }

    public Long getClassificationSystemId() {
        return this.classificationSystemId;
    }

    public Long getClassificationSystemId_From() {
        return this.classificationSystemId_From;
    }

    public Long getClassificationSystemId_To() {
        return this.classificationSystemId_To;
    }

    public void setClassificationSystemId(Long classificationSystemId) {
        this.classificationSystemId = classificationSystemId;
    }

    public void setClassificationSystemId_From(Long classificationSystemId_From) {
        this.classificationSystemId_From = classificationSystemId_From;
    }

    public void setClassificationSystemId_To(Long classificationSystemId_To) {
        this.classificationSystemId_To = classificationSystemId_To;
    }

    public String getClassificationSystem() {
        return this.classificationSystem;
    }

    public void setClassificationSystem(String classificationSystem) {
        this.classificationSystem = classificationSystem;
    }

    public Long getClassificationId() {
        return this.classificationId;
    }

    public Long getClassificationId_From() {
        return this.classificationId_From;
    }

    public Long getClassificationId_To() {
        return this.classificationId_To;
    }

    public void setClassificationId(Long classificationId) {
        this.classificationId = classificationId;
    }

    public void setClassificationId_From(Long classificationId_From) {
        this.classificationId_From = classificationId_From;
    }

    public void setClassificationId_To(Long classificationId_To) {
        this.classificationId_To = classificationId_To;
    }

    public String getClassificationCode() {
        return this.classificationCode;
    }

    public void setClassificationCode(String classificationCode) {
        this.classificationCode = classificationCode;
    }

    public String getClassificationName() {
        return this.classificationName;
    }

    public void setClassificationName(String classificationName) {
        this.classificationName = classificationName;
    }

}
