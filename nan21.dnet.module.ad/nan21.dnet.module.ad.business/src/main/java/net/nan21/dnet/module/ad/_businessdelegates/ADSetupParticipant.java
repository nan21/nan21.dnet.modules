package net.nan21.dnet.module.ad._businessdelegates;
 
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.transaction.annotation.Transactional;
 
import net.nan21.dnet.core.business.service.AbstractBusinessDelegate;
import net.nan21.dnet.module.ad.usr.domain.entity.Role;
import net.nan21.dnet.module.ad.usr.domain.entity.User;
import net.nan21.dnet.module.ad.usr.domain.entity.UserType;

public class ADSetupParticipant extends AbstractBusinessDelegate 
		  {
 
	private Boolean needsToRun;
	
	@Transactional
 
	public void run() {
		this.insertClient();
		this.insertUser();
		this.needsToRun = false;
	} 
	
	
	private void insertClient() {
		//this.em.createQuery("select count(1) from ") ;
	}
	
	private void insertUser() {

		Role r = new Role();
		r.setName("DNET_ADMIN");
		r.setClientId(1L);
		this.em.persist(r);
		
		UserType t = new UserType();
		t.setName("Default");
		t.setClientId(1L);
		this.em.persist(t);
		
		Collection<Role> roles = new ArrayList<Role>();
		roles.add(r);
		User u = new User();
		u.setCode("admin");
		u.setName("Administrator User");
		u.setClientId(1L);		
		u.setRoles(roles);
		this.em.persist(u);
		//u.set

	}
	
	
 
	public boolean needsToRun() {
		if (this.needsToRun != null ) {
			return this.needsToRun;
		}
		else {
			this.needsToRun = false;
			int count = this.em.createQuery("select count(1) from "+User.class.getSimpleName() + " e" ).getFirstResult();
			if (count==0) {
				this.needsToRun = true;
			}
		}
		return this.needsToRun;
	}
	
}
