/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.usr.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.ad.usr.business.service.IAccessControlService;
import net.nan21.dnet.module.ad.usr.domain.entity.AccessControl;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.ad.usr.ds.model.DsMethodAccessControlDs;
import net.nan21.dnet.module.ad.usr.domain.entity.DsMethodAccessControl;

public class DsMethodAccessControlDsConv extends
        AbstractDsConverter<DsMethodAccessControlDs, DsMethodAccessControl>
        implements IDsConverter<DsMethodAccessControlDs, DsMethodAccessControl> {

    @Override
    protected void modelToEntityReferences(DsMethodAccessControlDs ds,
            DsMethodAccessControl e, boolean isInsert) throws Exception {

        if (ds.getAccessControlId() != null) {
            if (e.getAccessControl() == null
                    || !e.getAccessControl().getId()
                            .equals(ds.getAccessControlId())) {
                e.setAccessControl((AccessControl) this.em.find(
                        AccessControl.class, ds.getAccessControlId()));
            }
        } else {
            this.lookup_accessControl_AccessControl(ds, e);
        }

    }

    protected void lookup_accessControl_AccessControl(
            DsMethodAccessControlDs ds, DsMethodAccessControl e)
            throws Exception {
        if (ds.getAccessControl() != null && !ds.getAccessControl().equals("")) {
            AccessControl x = null;
            try {
                x = ((IAccessControlService) findEntityService(AccessControl.class))
                        .findByName(ds.getAccessControl());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `AccessControl` reference:  `accessControl` = "
                                + ds.getAccessControl() + "  ");
            }
            e.setAccessControl(x);

        } else {
            e.setAccessControl(null);
        }
    }

}
