/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.org.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.bd.org.ds.model.OrganizationTypeDs;
import net.nan21.dnet.module.bd.org.domain.entity.OrganizationType;

public class OrganizationTypeDsConv extends
        AbstractDsConverter<OrganizationTypeDs, OrganizationType> implements
        IDsConverter<OrganizationTypeDs, OrganizationType> {

    protected void modelToEntityAttributes(OrganizationTypeDs ds,
            OrganizationType e) throws Exception {
        e.setName(ds.getName());
        e.setActive(ds.getActive());
        e.setDescription(ds.getDescription());
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
        e.setVirtualEntity(ds.getVirtualEntity());
        e.setLegalEntity(ds.getLegalEntity());
        e.setAccountingEnabled(ds.getAccountingEnabled());
        e.setInventory(ds.getInventory());
        e.setExternal(ds.getExternal());
        e.setCarrier(ds.getCarrier());
    }

    protected void modelToEntityReferences(OrganizationTypeDs ds,
            OrganizationType e) throws Exception {
    }

    @Override
    public void entityToModel(OrganizationType e, OrganizationTypeDs ds)
            throws Exception {
        ds.setName(e.getName());
        ds.setActive(e.getActive());
        ds.setDescription(e.getDescription());
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
        ds.setVirtualEntity(e.getVirtualEntity());
        ds.setLegalEntity(e.getLegalEntity());
        ds.setAccountingEnabled(e.getAccountingEnabled());
        ds.setInventory(e.getInventory());
        ds.setExternal(e.getExternal());
        ds.setCarrier(e.getCarrier());
    }

}
