/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.grade.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.hr.grade.domain.entity.Grade;
import net.nan21.dnet.module.hr.grade.domain.entity.GradeRate;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.hr.grade.ds.model.GradeRateValueDs;
import net.nan21.dnet.module.hr.grade.domain.entity.GradeRateValue;

public class GradeRateValueDsConv extends
        AbstractDsConverter<GradeRateValueDs, GradeRateValue> implements
        IDsConverter<GradeRateValueDs, GradeRateValue> {

    protected void modelToEntityReferences(GradeRateValueDs ds, GradeRateValue e)
            throws Exception {
        if (ds.getGradeId() != null) {
            if (e.getGrade() == null
                    || !e.getGrade().getId().equals(ds.getGradeId())) {
                e.setGrade((Grade) this.em.find(Grade.class, ds.getGradeId()));
            }
        }
        if (ds.getGradeRateId() != null) {
            if (e.getGradeRate() == null
                    || !e.getGradeRate().getId().equals(ds.getGradeRateId())) {
                e.setGradeRate((GradeRate) this.em.find(GradeRate.class,
                        ds.getGradeRateId()));
            }
        }
    }

}
