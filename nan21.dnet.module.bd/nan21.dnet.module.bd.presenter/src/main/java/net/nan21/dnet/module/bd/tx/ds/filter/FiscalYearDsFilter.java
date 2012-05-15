/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.tx.ds.filter;

import java.util.Date;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeDsFilter;

public class FiscalYearDsFilter extends AbstractTypeWithCodeDsFilter {

    private Date startDate;

    private Date startDate_From;
    private Date startDate_To;

    private Date endDate;

    private Date endDate_From;
    private Date endDate_To;

    private Long calendarId;

    private Long calendarId_From;
    private Long calendarId_To;

    private String calendar;

    public Date getStartDate() {
        return this.startDate;
    }

    public Date getStartDate_From() {
        return this.startDate_From;
    }

    public Date getStartDate_To() {
        return this.startDate_To;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setStartDate_From(Date startDate_From) {
        this.startDate_From = startDate_From;
    }

    public void setStartDate_To(Date startDate_To) {
        this.startDate_To = startDate_To;
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public Date getEndDate_From() {
        return this.endDate_From;
    }

    public Date getEndDate_To() {
        return this.endDate_To;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setEndDate_From(Date endDate_From) {
        this.endDate_From = endDate_From;
    }

    public void setEndDate_To(Date endDate_To) {
        this.endDate_To = endDate_To;
    }

    public Long getCalendarId() {
        return this.calendarId;
    }

    public Long getCalendarId_From() {
        return this.calendarId_From;
    }

    public Long getCalendarId_To() {
        return this.calendarId_To;
    }

    public void setCalendarId(Long calendarId) {
        this.calendarId = calendarId;
    }

    public void setCalendarId_From(Long calendarId_From) {
        this.calendarId_From = calendarId_From;
    }

    public void setCalendarId_To(Long calendarId_To) {
        this.calendarId_To = calendarId_To;
    }

    public String getCalendar() {
        return this.calendar;
    }

    public void setCalendar(String calendar) {
        this.calendar = calendar;
    }

}
