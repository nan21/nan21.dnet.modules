/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.usr.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.ad.usr.business.service.IUserTypeService;
import net.nan21.dnet.module.ad.usr.domain.entity.UserType;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.ad.usr.ds.model.UserDs;
import net.nan21.dnet.module.ad.usr.domain.entity.User;

public class UserDsConv extends AbstractDsConverter<UserDs, User> implements
        IDsConverter<UserDs, User> {

    protected void modelToEntityReferences(UserDs ds, User e) throws Exception {
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
    }

    protected void lookup_accountType_UserType(UserDs ds, User e)
            throws Exception {
        if (ds.getAccountType() != null && !ds.getAccountType().equals("")) {
            UserType x = null;
            try {
                x = ((IUserTypeService) findEntityService(UserType.class))
                        .findByName(ds.getClientId(), ds.getAccountType());
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

}
