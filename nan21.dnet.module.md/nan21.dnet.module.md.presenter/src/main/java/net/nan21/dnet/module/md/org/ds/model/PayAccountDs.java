/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.org.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;

import net.nan21.dnet.module.md.org.domain.entity.PayAccount;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = PayAccount.class, sort = { @SortField(field = PayAccountDs.fNAME) })
public class PayAccountDs extends AbstractTypeDs<PayAccount> {

    public static final String fTYPE = "type";
    public static final String fORGID = "orgId";
    public static final String fORG = "org";
    public static final String fCURRENCYID = "currencyId";
    public static final String fCURRENCY = "currency";

    @DsField(noUpdate = true)
    private String type;

    @DsField(join = "left", path = "org.id")
    private Long orgId;

    @DsField(join = "left", path = "org.code")
    private String org;

    @DsField(join = "left", path = "currency.id")
    private Long currencyId;

    @DsField(join = "left", path = "currency.code")
    private String currency;

    public PayAccountDs() {
        super();
    }

    public PayAccountDs(PayAccount e) {
        super(e);
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getOrgId() {
        return this.orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getOrg() {
        return this.org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public Long getCurrencyId() {
        return this.currencyId;
    }

    public void setCurrencyId(Long currencyId) {
        this.currencyId = currencyId;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

}
