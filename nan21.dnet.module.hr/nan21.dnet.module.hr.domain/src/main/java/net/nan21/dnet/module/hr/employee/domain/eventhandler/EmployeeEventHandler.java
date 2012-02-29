/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.employee.domain.eventhandler;

import org.eclipse.persistence.descriptors.ClassDescriptor;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.eclipse.persistence.history.HistoryPolicy;

import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.module.hr.employee.domain.entity.Employee;

public class EmployeeEventHandler extends DefaultEventHandler {
	
	@Override
	public void customize(ClassDescriptor descriptor) {
        HistoryPolicy policy = new HistoryPolicy();
        policy.addHistoryTableName("EMPLOYEE_HIST");
        policy.addStartFieldName("START_DATE");
        policy.addEndFieldName("END_DATE");
        descriptor.setHistoryPolicy(policy);
        super.customize(descriptor);
    }
	 
	@Override
    public void preInsert(DescriptorEvent event) {
        Employee e = (Employee)event.getSource();        
    } 
    
	@Override
    public void preUpdate(DescriptorEvent event) {
        Employee e = (Employee)event.getSource();		        
    } 
}
 
 