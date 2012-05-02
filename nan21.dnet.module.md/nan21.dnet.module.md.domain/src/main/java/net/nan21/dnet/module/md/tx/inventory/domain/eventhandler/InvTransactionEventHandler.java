/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.tx.inventory.domain.eventhandler;

import org.eclipse.persistence.descriptors.ClassDescriptor;
import org.eclipse.persistence.descriptors.ClassExtractor;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.eclipse.persistence.sessions.Record;
import org.eclipse.persistence.sessions.Session;

import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.module.md.tx.inventory.domain.entity.InvTransaction;

public class InvTransactionEventHandler extends DefaultEventHandler {
 
	public void customize(ClassDescriptor descriptor) {
        super.customize(descriptor);
        descriptor.getInheritancePolicy().setShouldOuterJoinSubclasses(true);     
        descriptor.getInheritancePolicy().setClassExtractor(new ClassExtractor() {            
            @Override
            public Class extractClassFromRow(Record row, Session session) {                 
                return InvTransaction.class;
            }            
        });
        descriptor.getInheritancePolicy().setClassIndicatorField(null);
    }
	
    @Override
    public void preInsert(DescriptorEvent event) {
        InvTransaction e = (InvTransaction) event.getSource();
    }

    @Override
    public void preUpdate(DescriptorEvent event) {
        InvTransaction e = (InvTransaction) event.getSource();
    }
}
