/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.grade.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.api.model.IModelWithClientId;
import net.nan21.dnet.core.api.model.IModelWithId;
import net.nan21.dnet.core.presenter.model.AbstractDsModel;

import net.nan21.dnet.module.hr.grade.domain.entity.PayScalePoint;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = PayScalePoint.class, sort = { @SortField(field = PayScalePointLovDs.fNAME) })
public class PayScalePointLovDs extends AbstractDsModel<PayScalePoint>
        implements IModelWithId, IModelWithClientId {

    public static final String fNAME = "name";
    public static final String fID = "id";
    public static final String fCLIENTID = "clientId";
    public static final String fPAYSCALEID = "payScaleId";

    @DsField(path = "code")
    private String name;

    @DsField()
    private Long id;

    @DsField()
    private Long clientId;

    @DsField(join = "left", path = "payScale.id")
    private Long payScaleId;

    public PayScalePointLovDs() {
        super();
    }

    public PayScalePointLovDs(PayScalePoint e) {
        super(e);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Object id) {
        this.id = this._asLong_(id);

    }

    public Long getClientId() {
        return this.clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getPayScaleId() {
        return this.payScaleId;
    }

    public void setPayScaleId(Long payScaleId) {
        this.payScaleId = payScaleId;
    }

}
