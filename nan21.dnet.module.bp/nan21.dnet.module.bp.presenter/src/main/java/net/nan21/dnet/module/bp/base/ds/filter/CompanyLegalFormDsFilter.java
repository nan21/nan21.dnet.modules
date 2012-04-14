/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bp.base.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractTypeDsFilter;

public class CompanyLegalFormDsFilter extends AbstractTypeDsFilter {

    private Long countryId;

    private Long countryId_From;
    private Long countryId_To;

    private String country;

    public Long getCountryId() {
        return this.countryId;
    }

    public Long getCountryId_From() {
        return this.countryId_From;
    }

    public Long getCountryId_To() {
        return this.countryId_To;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public void setCountryId_From(Long countryId_From) {
        this.countryId_From = countryId_From;
    }

    public void setCountryId_To(Long countryId_To) {
        this.countryId_To = countryId_To;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}
