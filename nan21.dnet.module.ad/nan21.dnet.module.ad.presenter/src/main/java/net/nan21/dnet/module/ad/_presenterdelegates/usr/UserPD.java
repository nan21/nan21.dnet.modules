package net.nan21.dnet.module.ad._presenterdelegates.usr;

import net.nan21.dnet.core.presenter.service.BaseDsDelegate;
import net.nan21.dnet.module.ad.usr.business.service.IUserService;
import net.nan21.dnet.module.ad.usr.domain.entity.User;
import net.nan21.dnet.module.ad.usr.ds.model.UserDs;
import net.nan21.dnet.module.ad.usr.ds.param.UserDsParam;

public class UserPD extends BaseDsDelegate<UserDs, UserDsParam> {
	public void changePassword(UserDs ds, UserDsParam params) throws Exception {		 
		 ((IUserService)this.findEntityService(User.class))
		 	.doChangePassword(ds.getId(), params.getNewPassword());		 
	}
}
