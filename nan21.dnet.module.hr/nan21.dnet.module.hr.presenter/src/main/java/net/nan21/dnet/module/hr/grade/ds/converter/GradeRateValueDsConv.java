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

    protected void modelToEntityAttributes(GradeRateValueDs ds, GradeRateValue e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
        e.setFixValue(ds.getFixValue());
        e.setMinValue(ds.getMinValue());
        e.setMaxValue(ds.getMaxValue());
        e.setValidFrom(ds.getValidFrom());
        e.setValidTo(ds.getValidTo());
    }

    protected void modelToEntityReferences(GradeRateValueDs ds, GradeRateValue e)
            throws Exception {

        if (ds.getGradeId() != null) {
            if (e.getGrade() == null
                    || !e.getGrade().getId().equals(ds.getGradeId())) {
                e.setGrade((Grade) this.em.getReference(Grade.class,
                        ds.getGradeId()));
            }
        }
        if (ds.getGradeRateId() != null) {
            if (e.getGradeRate() == null
                    || !e.getGradeRate().getId().equals(ds.getGradeRateId())) {
                e.setGradeRate((GradeRate) this.em.getReference(
                        GradeRate.class, ds.getGradeRateId()));
            }
        }
    }

    @Override
    public void entityToModel(GradeRateValue e, GradeRateValueDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
        ds.setFixValue(e.getFixValue());
        ds.setMinValue(e.getMinValue());
        ds.setMaxValue(e.getMaxValue());
        ds.setValidFrom(e.getValidFrom());
        ds.setValidTo(e.getValidTo());
        ds.setGradeId(((e.getGrade() != null)) ? e.getGrade().getId() : null);
        ds.setGradeName(((e.getGrade() != null)) ? e.getGrade().getName()
                : null);
        ds.setGradeRateId(((e.getGradeRate() != null)) ? e.getGradeRate()
                .getId() : null);
        ds.setGradeRateName(((e.getGradeRate() != null)) ? e.getGradeRate()
                .getName() : null);
    }

}
