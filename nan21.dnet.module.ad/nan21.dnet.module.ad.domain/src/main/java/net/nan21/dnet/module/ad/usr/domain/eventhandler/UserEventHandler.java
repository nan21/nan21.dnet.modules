/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.usr.domain.eventhandler;

import org.eclipse.persistence.descriptors.DescriptorEvent;
 
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.module.ad.usr.domain.entity.User;

public class UserEventHandler extends DefaultEventHandler {
	
	@Override
    public void preInsert(DescriptorEvent event) {        
        User e = (User)event.getSource(); 
        if (e.getPassword() == null) {
            // md5 for 1234
            e.setPassword("81dc9bdb52d04dc20036dbd8313ed055");
        }
    } 
    
	@Override
    public void preUpdate(DescriptorEvent event) {
        User e = (User)event.getSource();		        
    } 
}
 
 