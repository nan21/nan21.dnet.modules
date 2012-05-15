/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.usr.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.ad.system.business.service.ISysDateFormatService;
import net.nan21.dnet.module.ad.system.domain.entity.SysDateFormat;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.ad.usr.ds.model.MyUserSettingsDs;
import net.nan21.dnet.module.ad.usr.domain.entity.User;

public class MyUserSettingsDsConv extends
        AbstractDsConverter<MyUserSettingsDs, User> implements
        IDsConverter<MyUserSettingsDs, User> {

    @Override
    protected void modelToEntityReferences(MyUserSettingsDs ds, User e,
            boolean isInsert) throws Exception {

        if (ds.getDateFormatId() != null) {
            if (e.getDateFormat() == null
                    || !e.getDateFormat().getId().equals(ds.getDateFormatId())) {
                e.setDateFormat((SysDateFormat) this.em.find(
                        SysDateFormat.class, ds.getDateFormatId()));
            }
        } else {
            this.lookup_dateFormat_SysDateFormat(ds, e);
        }

    }

    protected void lookup_dateFormat_SysDateFormat(MyUserSettingsDs ds, User e)
            throws Exception {
        if (ds.getDateFormat() != null && !ds.getDateFormat().equals("")) {
            SysDateFormat x = null;
            try {
                x = ((ISysDateFormatService) findEntityService(SysDateFormat.class))
                        .findByName(ds.getDateFormat());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `SysDateFormat` reference:  `dateFormat` = "
                                + ds.getDateFormat() + "  ");
            }
            e.setDateFormat(x);

        } else {
            e.setDateFormat(null);
        }
    }

}
