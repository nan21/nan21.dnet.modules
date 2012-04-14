/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.standards.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeDs;

import net.nan21.dnet.module.bd.standards.domain.entity.ClassificationCode;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = ClassificationCode.class, sort = { @SortField(field = ClassificationCodeDs.fNAME) })
public class ClassificationCodeDs extends
        AbstractTypeWithCodeDs<ClassificationCode> {

    public static final String fCLASSSYSTEMID = "classSystemId";
    public static final String fCLASSSYSTEM = "classSystem";

    @DsField(join = "left", path = "classSystem.id")
    private Long classSystemId;

    @DsField(join = "left", path = "classSystem.code")
    private String classSystem;

    public ClassificationCodeDs() {
        super();
    }

    public ClassificationCodeDs(ClassificationCode e) {
        super(e);
    }

    public Long getClassSystemId() {
        return this.classSystemId;
    }

    public void setClassSystemId(Long classSystemId) {
        this.classSystemId = classSystemId;
    }

    public String getClassSystem() {
        return this.classSystem;
    }

    public void setClassSystem(String classSystem) {
        this.classSystem = classSystem;
    }

}
