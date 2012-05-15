/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.org.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeDsFilter;

public class OrganizationDsFilter extends AbstractTypeWithCodeDsFilter {

    private Boolean valid;

    private Long typeId;

    private Long typeId_From;
    private Long typeId_To;

    private String type;

    private Long calendarId;

    private Long calendarId_From;
    private Long calendarId_To;

    private String calendar;

    private String className;

    public Boolean getValid() {
        return this.valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    public Long getTypeId() {
        return this.typeId;
    }

    public Long getTypeId_From() {
        return this.typeId_From;
    }

    public Long getTypeId_To() {
        return this.typeId_To;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public void setTypeId_From(Long typeId_From) {
        this.typeId_From = typeId_From;
    }

    public void setTypeId_To(Long typeId_To) {
        this.typeId_To = typeId_To;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getClassName() {
        return this.className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

}
