/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.base.period.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.md.base.period.business.service.IFiscalYearService;
import net.nan21.dnet.module.md.base.period.domain.entity.FiscalYear;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.md.base.period.ds.model.FiscalPeriodDs;
import net.nan21.dnet.module.md.base.period.domain.entity.FiscalPeriod;

public class FiscalPeriodDsConv extends
        AbstractDsConverter<FiscalPeriodDs, FiscalPeriod> implements
        IDsConverter<FiscalPeriodDs, FiscalPeriod> {

    @Override
    protected void modelToEntityReferences(FiscalPeriodDs ds, FiscalPeriod e,
            boolean isInsert) throws Exception {

        if (ds.getYearId() != null) {
            if (e.getYear() == null
                    || !e.getYear().getId().equals(ds.getYearId())) {
                e.setYear((FiscalYear) this.em.find(FiscalYear.class,
                        ds.getYearId()));
            }
        } else {
            this.lookup_year_FiscalYear(ds, e);
        }

    }

    protected void lookup_year_FiscalYear(FiscalPeriodDs ds, FiscalPeriod e)
            throws Exception {
        if (ds.getYear() != null && !ds.getYear().equals("")) {
            FiscalYear x = null;
            try {
                x = ((IFiscalYearService) findEntityService(FiscalYear.class))
                        .findByCode(ds.getYear());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `FiscalYear` reference:  `year` = "
                                + ds.getYear() + "  ");
            }
            e.setYear(x);

        } else {
            e.setYear(null);
        }
    }

}
