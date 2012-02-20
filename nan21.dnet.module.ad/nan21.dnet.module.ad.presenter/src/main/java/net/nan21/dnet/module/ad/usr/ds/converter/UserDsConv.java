/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.usr.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.ad.system.business.service.ISysDateFormatService;
import net.nan21.dnet.module.ad.system.domain.entity.SysDateFormat;
import net.nan21.dnet.module.ad.usr.business.service.IUserTypeService;
import net.nan21.dnet.module.ad.usr.domain.entity.UserType;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.ad.usr.ds.model.UserDs;
import net.nan21.dnet.module.ad.usr.domain.entity.User;

public class UserDsConv extends AbstractDsConverter<UserDs, User> implements
        IDsConverter<UserDs, User> {

    @Override
    protected void modelToEntityReferences(UserDs ds, User e, boolean isInsert)
            throws Exception {

        if (ds.getAccountTypeId() != null) {
            if (e.getAccountType() == null
                    || !e.getAccountType().getId()
                            .equals(ds.getAccountTypeId())) {
                e.setAccountType((UserType) this.em.find(UserType.class,
                        ds.getAccountTypeId()));
            }
        } else {
            this.lookup_accountType_UserType(ds, e);
        }

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

    protected void lookup_accountType_UserType(UserDs ds, User e)
            throws Exception {
        if (ds.getAccountType() != null && !ds.getAccountType().equals("")) {
            UserType x = null;
            try {
                x = ((IUserTypeService) findEntityService(UserType.class))
                        .findByName(ds.getAccountType());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `UserType` reference:  `accountType` = "
                                + ds.getAccountType() + "  ");
            }
            e.setAccountType(x);

        } else {
            e.setAccountType(null);
        }
    }

    protected void lookup_dateFormat_SysDateFormat(UserDs ds, User e)
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
