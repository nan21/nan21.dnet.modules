/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.skill.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;

import net.nan21.dnet.module.hr.skill.domain.entity.Qualification;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = Qualification.class, sort = { @SortField(field = QualificationDs.fNAME) })
public class QualificationDs extends AbstractTypeDs<Qualification> {

    public QualificationDs() {
        super();
    }

    public QualificationDs(Qualification e) {
        super(e);
    }

}
