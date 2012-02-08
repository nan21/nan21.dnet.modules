package net.nan21.dnet.module.ad._presenterdelegates.usr;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;

import net.nan21.dnet.core.presenter.service.AbstractDsDelegate;
import net.nan21.dnet.module.ad.usr.business.service.IAssignableService;
import net.nan21.dnet.module.ad.usr.business.service.IUserService;
import net.nan21.dnet.module.ad.usr.domain.entity.Assignable;
import net.nan21.dnet.module.ad.usr.domain.entity.User;
import net.nan21.dnet.module.ad.usr.ds.model.UserDs;
import net.nan21.dnet.module.ad.usr.ds.param.UserDsParam;

public class UserPD extends AbstractDsDelegate {
	public void changePassword(UserDs ds, UserDsParam params) throws Exception {	
		String newPassword = params.getNewPassword();
		String confPassword = params.getConfirmPassword() ;
		if (newPassword == null || newPassword.equals("")) {
			throw new Exception("Password must not be empty!");
		}
		if ( !newPassword.equals(confPassword) ) {
			throw new Exception("New password is not confirmed correctly !");
		}
		
		 ((IUserService)this.findEntityService(User.class))
		 	.doChangePassword(ds.getId(), newPassword);		 
	}
	
	public void createAssignableResource(UserDs ds) throws Exception {
		IAssignableService srv = (IAssignableService)this.findEntityService(Assignable.class);
		Map<String, Object> attrs = new HashMap<String, Object>();
		attrs.put("userCode", ds.getCode());
		
		List<Assignable> list = srv.findEntitiesByAttributes(attrs);
		if (list.size() == 0 ) {
			Assignable a = new Assignable();
			a.setActive(true);
			a.setName(ds.getName());
			a.setUserCode(ds.getCode());
			srv.insert(a);
		} else {
			
		}
		 
	}
	
	
}
