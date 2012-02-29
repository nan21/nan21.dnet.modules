/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.time.domain.eventhandler;

import org.eclipse.persistence.descriptors.DescriptorEvent;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.module.hr.time.domain.entity.Absence;

public class AbsenceEventHandler extends DefaultEventHandler {
	
	@Override
    public void preInsert(DescriptorEvent event) {
        Absence e = (Absence)event.getSource();        
    } 
    
	@Override
    public void preUpdate(DescriptorEvent event) {
        Absence e = (Absence)event.getSource();		        
    } 
}
 
 