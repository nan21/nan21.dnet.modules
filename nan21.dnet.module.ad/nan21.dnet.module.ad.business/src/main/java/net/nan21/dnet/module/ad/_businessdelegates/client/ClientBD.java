package net.nan21.dnet.module.ad._businessdelegates.client;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collection;

import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractBusinessDelegate;
import net.nan21.dnet.module.ad.client.domain.entity.Client;
import net.nan21.dnet.module.ad.usr.domain.entity.Role;
import net.nan21.dnet.module.ad.usr.domain.entity.User;
import net.nan21.dnet.module.ad.usr.domain.entity.UserType;

public class ClientBD extends AbstractBusinessDelegate{

	public static final String ROLE_ADMIN = "ROLE_DNET_ADMIN";
	public static final String ROLE_USER = "ROLE_DNET_USER";
	
	public void createAdminUser(Client client ,
			String userCode, String userName, String password) throws Exception  {
		client.setAdminRole(ClientBD.ROLE_ADMIN);
		this.em.persist(client);
		
		net.nan21.dnet.core.api.session.User su = Session.user.get();
		net.nan21.dnet.core.api.session.User newUser = new 
			net.nan21.dnet.core.api.session.User(su.getUsername(), su.getUsername(), "", 
					false, false, false, true, client.getCode(), client.getId(), null, null, null, null, null); 
		 
		
		try {
			Role radmin = new Role();
			radmin.setName(ROLE_ADMIN);
			radmin.setActive(true);
			radmin.setDescription("Administrator role for un-restricted access to business functions.");
			this.em.persist(radmin);
			
			Role ruser = new Role();
			ruser.setName(ROLE_USER);
			ruser.setActive(true);
			ruser.setDescription("Application role which allows a user to use the application.");
			this.em.persist(ruser);
			 
			UserType t = new UserType();
			t.setName("Default");	
			t.setActive(true);
			this.em.persist(t);
			
			Collection<Role> roles = new ArrayList<Role>();
			roles.add(radmin);
			roles.add(ruser);
		  
			User u = new User();
			 
			u.setCode(userCode);
			u.setName(userName);
			u.setActive(true);
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");  
			messageDigest.update(password.getBytes(),0, password.length());  
			String hashedPass = new BigInteger(1,messageDigest.digest()).toString(16);  
			if (hashedPass.length() < 32) { 
			   hashedPass = "0" + hashedPass; 
			}
			
			u.setPassword(hashedPass);	
			u.setRoles(roles);
			this.em.persist(u);
			Session.user.set(newUser);
			this.em.flush();			
		} finally {
			Session.user.set(su);
		}
	}
}
