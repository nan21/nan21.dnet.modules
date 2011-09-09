/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.usr.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.ad.usr.business.service.IAccessControlService;
import net.nan21.dnet.module.ad.usr.domain.entity.AccessControl;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.ad.usr.ds.model.DsAccessControlDs;
import net.nan21.dnet.module.ad.usr.domain.entity.DsAccessControl;

public class DsAccessControlDsConv extends
        AbstractDsConverter<DsAccessControlDs, DsAccessControl> implements
        IDsConverter<DsAccessControlDs, DsAccessControl> {

    protected void modelToEntityAttributes(DsAccessControlDs ds,
            DsAccessControl e) throws Exception {
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
        e.setDsName(ds.getDsName());
        e.setQueryAllowed(ds.getQueryAllowed());
        e.setInsertAllowed(ds.getInsertAllowed());
        e.setUpdateAllowed(ds.getUpdateAllowed());
        e.setDeleteAllowed(ds.getDeleteAllowed());
        e.setImportAllowed(ds.getImportAllowed());
        e.setExportAllowed(ds.getExportAllowed());
    }

    protected void modelToEntityReferences(DsAccessControlDs ds,
            DsAccessControl e) throws Exception {

        if (ds.getAccessControlId() != null) {
            if (e.getAccessControl() == null
                    || !e.getAccessControl().getId()
                            .equals(ds.getAccessControlId())) {
                e.setAccessControl((AccessControl) this.em.getReference(
                        AccessControl.class, ds.getAccessControlId()));
            }
        } else {
            this.lookup_accessControl_AccessControl(ds, e);
        }
    }

    protected void lookup_accessControl_AccessControl(DsAccessControlDs ds,
            DsAccessControl e) throws Exception {
        if (ds.getAccessControl() != null && !ds.getAccessControl().equals("")) {
            AccessControl x = null;
            try {
                x = ((IAccessControlService) getService(IAccessControlService.class))
                        .findByName(ds.getClientId(), ds.getAccessControl());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `AccessControl` reference:  `accessControl` = "
                                + ds.getAccessControl() + "  ");
            }
            e.setAccessControl(x);
        }
    }

    @Override
    public void entityToModel(DsAccessControl e, DsAccessControlDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
        ds.setDsName(e.getDsName());
        ds.setQueryAllowed(e.getQueryAllowed());
        ds.setInsertAllowed(e.getInsertAllowed());
        ds.setUpdateAllowed(e.getUpdateAllowed());
        ds.setDeleteAllowed(e.getDeleteAllowed());
        ds.setImportAllowed(e.getImportAllowed());
        ds.setExportAllowed(e.getExportAllowed());
        ds.setAccessControlId(((e.getAccessControl() != null)) ? e
                .getAccessControl().getId() : null);
        ds.setAccessControl(((e.getAccessControl() != null)) ? e
                .getAccessControl().getName() : null);
    }

}
