/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.fin.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractTypeDsFilter;

public class PaymentTermDsFilter extends AbstractTypeDsFilter {

    private Integer days;

    private Integer days_From;
    private Integer days_To;

    public Integer getDays() {
        return this.days;
    }

    public Integer getDays_From() {
        return this.days_From;
    }

    public Integer getDays_To() {
        return this.days_To;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public void setDays_From(Integer days_From) {
        this.days_From = days_From;
    }

    public void setDays_To(Integer days_To) {
        this.days_To = days_To;
    }

}
