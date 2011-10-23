/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bp.base.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.bp.base.ds.model.CompanyLegalFormLovDs;
import net.nan21.dnet.module.bp.base.domain.entity.CompanyLegalForm;

public class CompanyLegalFormLovDsConv extends
        AbstractDsConverter<CompanyLegalFormLovDs, CompanyLegalForm> implements
        IDsConverter<CompanyLegalFormLovDs, CompanyLegalForm> {

    protected void modelToEntityAttributes(CompanyLegalFormLovDs ds,
            CompanyLegalForm e) throws Exception {
        e.setClientId(ds.getClientId());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(CompanyLegalFormLovDs ds,
            CompanyLegalForm e) throws Exception {
    }

    @Override
    public void entityToModel(CompanyLegalForm e, CompanyLegalFormLovDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
        ds.setCountryId(((e.getCountry() != null)) ? e.getCountry().getId()
                : null);
    }

}
