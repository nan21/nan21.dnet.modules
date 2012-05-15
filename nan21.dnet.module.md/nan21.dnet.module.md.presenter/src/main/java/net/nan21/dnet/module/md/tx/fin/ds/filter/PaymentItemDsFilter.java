/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.tx.fin.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDsFilter;

public class PaymentItemDsFilter extends AbstractAuditableDsFilter {

    private Long paymentId;

    private Long paymentId_From;
    private Long paymentId_To;

    private Long accItemId;

    private Long accItemId_From;
    private Long accItemId_To;

    private String accItem;

    private Long productId;

    private Long productId_From;
    private Long productId_To;

    private String product;

    private Long uomId;

    private Long uomId_From;
    private Long uomId_To;

    private String uom;

    private Float quantity;

    private Float quantity_From;
    private Float quantity_To;

    private Float unitPrice;

    private Float unitPrice_From;
    private Float unitPrice_To;

    private Float amount;

    private Float amount_From;
    private Float amount_To;

    public Long getPaymentId() {
        return this.paymentId;
    }

    public Long getPaymentId_From() {
        return this.paymentId_From;
    }

    public Long getPaymentId_To() {
        return this.paymentId_To;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public void setPaymentId_From(Long paymentId_From) {
        this.paymentId_From = paymentId_From;
    }

    public void setPaymentId_To(Long paymentId_To) {
        this.paymentId_To = paymentId_To;
    }

    public Long getAccItemId() {
        return this.accItemId;
    }

    public Long getAccItemId_From() {
        return this.accItemId_From;
    }

    public Long getAccItemId_To() {
        return this.accItemId_To;
    }

    public void setAccItemId(Long accItemId) {
        this.accItemId = accItemId;
    }

    public void setAccItemId_From(Long accItemId_From) {
        this.accItemId_From = accItemId_From;
    }

    public void setAccItemId_To(Long accItemId_To) {
        this.accItemId_To = accItemId_To;
    }

    public String getAccItem() {
        return this.accItem;
    }

    public void setAccItem(String accItem) {
        this.accItem = accItem;
    }

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

    public String getProduct() {
        return this.product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Long getUomId() {
        return this.uomId;
    }

    public Long getUomId_From() {
        return this.uomId_From;
    }

    public Long getUomId_To() {
        return this.uomId_To;
    }

    public void setUomId(Long uomId) {
        this.uomId = uomId;
    }

    public void setUomId_From(Long uomId_From) {
        this.uomId_From = uomId_From;
    }

    public void setUomId_To(Long uomId_To) {
        this.uomId_To = uomId_To;
    }

    public String getUom() {
        return this.uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }

    public Float getQuantity() {
        return this.quantity;
    }

    public Float getQuantity_From() {
        return this.quantity_From;
    }

    public Float getQuantity_To() {
        return this.quantity_To;
    }

    public void setQuantity(Float quantity) {
        this.quantity = quantity;
    }

    public void setQuantity_From(Float quantity_From) {
        this.quantity_From = quantity_From;
    }

    public void setQuantity_To(Float quantity_To) {
        this.quantity_To = quantity_To;
    }

    public Float getUnitPrice() {
        return this.unitPrice;
    }

    public Float getUnitPrice_From() {
        return this.unitPrice_From;
    }

    public Float getUnitPrice_To() {
        return this.unitPrice_To;
    }

    public void setUnitPrice(Float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setUnitPrice_From(Float unitPrice_From) {
        this.unitPrice_From = unitPrice_From;
    }

    public void setUnitPrice_To(Float unitPrice_To) {
        this.unitPrice_To = unitPrice_To;
    }

    public Float getAmount() {
        return this.amount;
    }

    public Float getAmount_From() {
        return this.amount_From;
    }

    public Float getAmount_To() {
        return this.amount_To;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public void setAmount_From(Float amount_From) {
        this.amount_From = amount_From;
    }

    public void setAmount_To(Float amount_To) {
        this.amount_To = amount_To;
    }

}
