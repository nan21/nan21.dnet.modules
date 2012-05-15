/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.tx.ds.model;

import java.util.Date;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeDs;

import net.nan21.dnet.module.bd.tx.domain.entity.FiscalPeriod;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = FiscalPeriod.class, sort = { @SortField(field = FiscalPeriodDs.fNAME) })
public class FiscalPeriodDs extends AbstractTypeWithCodeDs<FiscalPeriod> {

    public static final String fYEARID = "yearId";
    public static final String fYEAR = "year";
    public static final String fSTARTDATE = "startDate";
    public static final String fENDDATE = "endDate";

    @DsField(join = "left", path = "year.id")
    private Long yearId;

    @DsField(join = "left", path = "year.code")
    private String year;

    @DsField()
    private Date startDate;

    @DsField()
    private Date endDate;

    public FiscalPeriodDs() {
        super();
    }

    public FiscalPeriodDs(FiscalPeriod e) {
        super(e);
    }

    public Long getYearId() {
        return this.yearId;
    }

    public void setYearId(Long yearId) {
        this.yearId = yearId;
    }

    public String getYear() {
        return this.year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

}
