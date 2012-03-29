/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sc.order.domain.eventhandler;

import org.eclipse.persistence.descriptors.DescriptorEvent;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.module.sc.order.domain.entity.PurchaseOrderItem;

public class PurchaseOrderItemEventHandler extends DefaultEventHandler {

	@Override
    public void preInsert(DescriptorEvent event) {
        PurchaseOrderItem e = (PurchaseOrderItem)event.getSource(); 
        this.calculateLineAmount(e);       
    } 
    
	@Override
    public void preUpdate(DescriptorEvent event) {
		PurchaseOrderItem e = (PurchaseOrderItem)event.getSource();	
        this.calculateLineAmount(e);       
    }
	
	private void calculateLineAmount(PurchaseOrderItem e) {
	    if (e.getUnitPrice() != null && e.getQuantity() != null ) {
            e.setNetAmount(e.getUnitPrice() * e.getQuantity());
        }
	}
}
