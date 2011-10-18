/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.client.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.ad.client.ds.model.MyClientDs;
import net.nan21.dnet.module.ad.client.domain.entity.Client;

public class MyClientDsConv extends AbstractDsConverter<MyClientDs, Client>
        implements IDsConverter<MyClientDs, Client> {

    protected void modelToEntityAttributes(MyClientDs ds, Client e)
            throws Exception {
        e.setName(ds.getName());
        e.setCode(ds.getCode());
        e.setNotes(ds.getNotes());
        e.setMaintenanceLanguage(ds.getMaintenanceLanguage());
        e.setAdminRole(ds.getAdminRole());
    }

    protected void modelToEntityReferences(MyClientDs ds, Client e)
            throws Exception {
    }

    @Override
    public void entityToModel(Client e, MyClientDs ds) throws Exception {
        ds.setName(e.getName());
        ds.setCode(e.getCode());
        ds.setNotes(e.getNotes());
        ds.setMaintenanceLanguage(e.getMaintenanceLanguage());
        ds.setAdminRole(e.getAdminRole());
        ds.setId(e.getId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
    }

}
