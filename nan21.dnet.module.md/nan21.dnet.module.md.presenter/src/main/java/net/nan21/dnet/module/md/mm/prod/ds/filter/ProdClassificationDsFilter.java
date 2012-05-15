/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.mm.prod.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDsFilter;

public class ProdClassificationDsFilter extends AbstractAuditableDsFilter {

    private Long productId;

    private Long productId_From;
    private Long productId_To;

    private String productCode;

    private Long classificationSystemId;

    private Long classificationSystemId_From;
    private Long classificationSystemId_To;

    private String classificationSystem;

    private Long classificationId;

    private Long classificationId_From;
    private Long classificationId_To;

    private String classificationCode;

    private String classificationName;

    public Long getProductId() {
        return this.productId;
    }

    public Long getProductId_From() {
        return this.productId_From;
    }

    public Long getProductId_To() {
        return this.productId_To;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public void setProductId_From(Long productId_From) {
        this.productId_From = productId_From;
    }

    public void setProductId_To(Long productId_To) {
        this.productId_To = productId_To;
    }

    public String getProductCode() {
        return this.productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
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
