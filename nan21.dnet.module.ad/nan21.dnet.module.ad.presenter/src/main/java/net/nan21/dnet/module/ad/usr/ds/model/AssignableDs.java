/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.usr.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;

import net.nan21.dnet.module.ad.usr.domain.entity.Assignable;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = Assignable.class, sort = { @SortField(field = AssignableDs.fNAME) })
public class AssignableDs extends AbstractTypeDs<Assignable> {

    public static final String fTYPEID = "typeId";
    public static final String fTYPE = "type";
    public static final String fUSERCODE = "userCode";

    @DsField(join = "left", path = "assignableType.id")
    private Long typeId;

    @DsField(join = "left", path = "assignableType.name")
    private String type;

    @DsField()
    private String userCode;

    public AssignableDs() {
        super();
    }

    public AssignableDs(Assignable e) {
        super(e);
    }

    public Long getTypeId() {
        return this.typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUserCode() {
        return this.userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

}
