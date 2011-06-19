/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bp.md.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.bp.md.ds.model.BusinessPartnerLovDs;
import net.nan21.dnet.module.bp.md.domain.entity.BusinessPartner;

public class BusinessPartnerLovDsConv extends
        AbstractDsConverter<BusinessPartnerLovDs, BusinessPartner> implements
        IDsConverter<BusinessPartnerLovDs, BusinessPartner> {

    protected void modelToEntityAttributes(BusinessPartnerLovDs ds,
            BusinessPartner e) throws Exception {
        e.setClientId(ds.getClientId());
        e.setCode(ds.getCode());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(BusinessPartnerLovDs ds,
            BusinessPartner e) throws Exception {
    }

    @Override
    public void entityToModel(BusinessPartner e, BusinessPartnerLovDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCode(e.getCode());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
    }

}
