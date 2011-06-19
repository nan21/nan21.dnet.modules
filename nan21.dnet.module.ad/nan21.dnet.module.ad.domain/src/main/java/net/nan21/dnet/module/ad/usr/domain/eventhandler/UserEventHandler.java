/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.usr.domain.eventhandler;

import org.eclipse.persistence.descriptors.DescriptorEvent;
import net.nan21.dnet.core.domain.eventhandler.DomainEntityBaseEventHandler;
import net.nan21.dnet.module.ad.usr.domain.entity.User;

public class UserEventHandler extends DomainEntityBaseEventHandler {
	
	@Override
    public void preInsert(DescriptorEvent event) {
        User e = (User)event.getSource();        
    } 
    
	@Override
    public void preUpdate(DescriptorEvent event) {
        User e = (User)event.getSource();		        
    } 
}
 
 