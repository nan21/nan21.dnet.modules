/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.bp.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;

import net.nan21.dnet.module.md.bp.domain.entity.CompanyLegalForm;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = CompanyLegalForm.class, sort = { @SortField(field = CompanyLegalFormDs.fNAME) })
public class CompanyLegalFormDs extends AbstractTypeDs<CompanyLegalForm> {

    public static final String fCOUNTRYID = "countryId";
    public static final String fCOUNTRY = "country";

    @DsField(join = "left", path = "country.id")
    private Long countryId;

    @DsField(join = "left", path = "country.code")
    private String country;

    public CompanyLegalFormDs() {
        super();
    }

    public CompanyLegalFormDs(CompanyLegalForm e) {
        super(e);
    }

    public Long getCountryId() {
        return this.countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}
