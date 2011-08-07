/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.client.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.ad.client.ds.model.ClientDs;
import net.nan21.dnet.module.ad.client.domain.entity.Client;

public class ClientDsConv extends AbstractDsConverter<ClientDs, Client>
        implements IDsConverter<ClientDs, Client> {

    protected void modelToEntityAttributes(ClientDs ds, Client e)
            throws Exception {
        e.setName(ds.getName());
        e.setCode(ds.getCode());
        e.setNotes(ds.getNotes());
        e.setMaintenanceLanguage(ds.getMaintenanceLanguage());
        e.setDefaultImportPath(ds.getDefaultImportPath());
        e.setDefaultExportPath(ds.getDefaultExportPath());
        e.setTempPath(ds.getTempPath());
        e.setDefaultDsAccessRule(ds.getDefaultDsAccessRule());
        e.setAdminRole(ds.getAdminRole());
    }

    protected void modelToEntityReferences(ClientDs ds, Client e)
            throws Exception {
    }

    @Override
    public void entityToModel(Client e, ClientDs ds) throws Exception {
        ds.setName(e.getName());
        ds.setCode(e.getCode());
        ds.setNotes(e.getNotes());
        ds.setMaintenanceLanguage(e.getMaintenanceLanguage());
        ds.setDefaultImportPath(e.getDefaultImportPath());
        ds.setDefaultExportPath(e.getDefaultExportPath());
        ds.setTempPath(e.getTempPath());
        ds.setDefaultDsAccessRule(e.getDefaultDsAccessRule());
        ds.setAdminRole(e.getAdminRole());
        ds.setId(e.getId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
    }

}
