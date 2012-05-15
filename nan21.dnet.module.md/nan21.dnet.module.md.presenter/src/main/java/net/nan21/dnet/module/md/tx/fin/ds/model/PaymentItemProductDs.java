/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.tx.fin.ds.model;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;

import net.nan21.dnet.module.md.tx.fin.domain.entity.PaymentItem;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = PaymentItem.class, jpqlWhere = " e.product is not null ")
public class PaymentItemProductDs extends AbstractAuditableDs<PaymentItem> {

    public static final String fPAYMENTID = "paymentId";
    public static final String fPRODUCTID = "productId";
    public static final String fPRODUCT = "product";
    public static final String fUOMID = "uomId";
    public static final String fUOM = "uom";
    public static final String fQUANTITY = "quantity";
    public static final String fUNITPRICE = "unitPrice";
    public static final String fAMOUNT = "amount";

    @DsField(join = "left", path = "payment.id")
    private Long paymentId;

    @DsField(join = "left", path = "product.id")
    private Long productId;

    @DsField(join = "left", path = "product.code")
    private String product;

    @DsField(join = "left", path = "uom.id")
    private Long uomId;

    @DsField(join = "left", path = "uom.code")
    private String uom;

    @DsField()
    private Float quantity;

    @DsField()
    private Float unitPrice;

    @DsField()
    private Float amount;

    public PaymentItemProductDs() {
        super();
    }

    public PaymentItemProductDs(PaymentItem e) {
        super(e);
    }

    public Long getPaymentId() {
        return this.paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public Long getProductId() {
        return this.productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
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

    public void setUomId(Long uomId) {
        this.uomId = uomId;
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

    public void setQuantity(Float quantity) {
        this.quantity = quantity;
    }

    public Float getUnitPrice() {
        return this.unitPrice;
    }

    public void setUnitPrice(Float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Float getAmount() {
        return this.amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

}
