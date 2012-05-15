/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.tx.ds.model;

import java.util.Date;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeDs;

import net.nan21.dnet.module.bd.tx.domain.entity.FiscalYear;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = FiscalYear.class, sort = { @SortField(field = FiscalYearDs.fNAME) })
public class FiscalYearDs extends AbstractTypeWithCodeDs<FiscalYear> {

    public static final String fSTARTDATE = "startDate";
    public static final String fENDDATE = "endDate";
    public static final String fCALENDARID = "calendarId";
    public static final String fCALENDAR = "calendar";

    @DsField()
    private Date startDate;

    @DsField()
    private Date endDate;

    @DsField(join = "left", path = "calendar.id")
    private Long calendarId;

    @DsField(join = "left", path = "calendar.name")
    private String calendar;

    public FiscalYearDs() {
        super();
    }

    public FiscalYearDs(FiscalYear e) {
        super(e);
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

    public Long getCalendarId() {
        return this.calendarId;
    }

    public void setCalendarId(Long calendarId) {
        this.calendarId = calendarId;
    }

    public String getCalendar() {
        return this.calendar;
    }

    public void setCalendar(String calendar) {
        this.calendar = calendar;
    }

}
